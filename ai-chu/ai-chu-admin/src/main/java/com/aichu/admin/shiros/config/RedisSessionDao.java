package com.aichu.admin.shiros.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

/**
 * @ClassName RedisSessionDao
 * @Author yuan.shuai
 * @Description 继承AbstractSessionDAO，实现Redis Session的增刪改查操作
 * @Date 2019/8/29
 * @Version 1.0.0
 */
public class RedisSessionDao extends AbstractSessionDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSessionDao.class);

    public static final String SESSION_PREFIX = "shiro_session:";
    public static final int DEFAILT_TIME_OUT = 12;
    @Resource RedisTemplate<String, Object> redisTemplate;
    //@Resource RedisUtil redisUtil;
    private int timeout = DEFAILT_TIME_OUT;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable id = generateSessionId(session);
        LOGGER.debug("id:{}", id.toString());
        assignSessionId(session, id);//将session 和 sessionId捆绑在一起
        saveSession(session);
        return id;
    }

    public void update(Session session) throws UnknownSessionException {
        LOGGER.debug("id:{}", session.getId().toString());
        saveSession(session);
    }

    public void delete(Session session) {
        LOGGER.debug("id:{}", session.getId().toString());
        if(session == null || session.getId() == null){
            return;
        }
        redisTemplate.delete(getKey(session.getId()));
    }

    public Collection<Session> getActiveSessions() {
        Set<String> keys = keys();
        Set<Session> sessions = new HashSet<Session>();
        if(keys.size() == 0){
            return sessions;
        }
        for (String id : keys) {
            Session _session = getSession(id);
            if(_session == null){
                continue;
            }
            sessions.add(_session);
        }
        return sessions;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if(sessionId == null){
            return null;
        }
        LOGGER.debug("id:{}", sessionId.toString());
        return getSession(sessionId);
    }

    private static String getKey(Serializable id){
        return SESSION_PREFIX + id.toString();
    }

    private void saveSession(Session session){
        if(session != null && session.getId() != null){
            Serializable id = session.getId();
            redisTemplate.opsForValue().set(getKey(id), session, timeout, TimeUnit.HOURS);
        }
    }

    private Session getSession(Serializable id){
        return (Session)redisTemplate.boundValueOps(getKey(id)).get();
    }

    private Set<String> keys(){
        return redisTemplate.execute(new RedisCallback<Set<String>>() {
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                Set<String> binaryKeys = new HashSet<String>();
                Cursor<byte[]> cursor = connection.scan( new ScanOptions.ScanOptionsBuilder().match(SESSION_PREFIX + "*").count(1000).build());
                while (cursor.hasNext()) {
                    binaryKeys.add(new String(cursor.next()));
                }
                connection.close();
                return binaryKeys;
            }
        });
    }
}
