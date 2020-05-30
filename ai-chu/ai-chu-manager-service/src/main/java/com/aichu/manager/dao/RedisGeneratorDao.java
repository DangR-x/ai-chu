package com.aichu.manager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @ClassName RedisGeneratorDao
 * @Description RedisGeneratorDao实体
 * @Author Melon
 * @Date 2019/7/19 13:50
 * @Version 1.0.0
 **/
@Repository
public abstract class RedisGeneratorDao<K extends Serializable, V extends Serializable> {

    @Autowired(required = true)
    protected RedisTemplate<K, V> redisTemplate;

    /**
     * 设置redisTemplate
     *
     * @param redisTemplate the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取 RedisSerializer
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }

}