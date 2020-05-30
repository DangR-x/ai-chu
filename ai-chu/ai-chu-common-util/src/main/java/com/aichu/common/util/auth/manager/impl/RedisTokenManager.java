package com.aichu.common.util.auth.manager.impl;

import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName RedisTokenManager
 * @Description 使用Redis存储Token
 * @Author Melon
 * @Date 2019/7/18 10:22
 * @Version 1.0.0
 **/
public class RedisTokenManager extends AbstractTokenManager {

  /**
   * Redis中Key的前缀
   */
  private static final String REDIS_KEY_PREFIX = "AUTHORIZATION_KEY_";

  /**
   * Redis中Token的前缀
   */
  private static final String REDIS_TOKEN_PREFIX = "AUTHORIZATION_TOKEN_";

  /**
   * stringRedisTemplate
   */
  protected StringRedisTemplate stringRedisTemplate;

  public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
    this.stringRedisTemplate = stringRedisTemplate;
  }

  @Override
  public String getTokenByKey(String key) {
    return getToken(key);
  }

  @Override
  protected void delSingleRelationshipByKey(String key) {
    String token = getToken(key);
    if (token != null) {
      delete(formatKey(key), formatToken(token));
    }
  }

  @Override
  public void delRelationshipByToken(String token) {
    if (singleTokenWithUser) {
      String key = getKey(token);
      delete(formatKey(key), formatToken(token));
    } else {
      delete(formatToken(token));
    }
  }

  @Override
  protected void createSingleRelationship(String key, String token) {
    String oldToken = get(formatKey(key));
    if (oldToken != null) {
      delete(formatToken(oldToken));
    }
    set(formatToken(token), key, tokenExpireSeconds);
    set(formatKey(key), token, tokenExpireSeconds);
  }

  @Override
  protected void createMultipleRelationship(String key, String token) {
    set(formatToken(token), key, tokenExpireSeconds);
  }

  @Override
  protected String getKeyByToken(String token) {
    return get(formatToken(token));
  }

  @Override
  protected void flushExpireAfterOperation(String key, String token) {
    if (singleTokenWithUser) {
      expire(formatKey(key), tokenExpireSeconds);
    }
    expire(formatToken(token), tokenExpireSeconds);
  }

  private String get(String key) {
    return stringRedisTemplate.opsForValue().get(key);
  }

  private void set(String key, String value, int expireSeconds) {
    stringRedisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
  }

  private void expire(String key, int seconds) {
    stringRedisTemplate.expire(key, seconds, TimeUnit.SECONDS);
  }

  private void delete(String... keys) {
    for (String key : keys) {
      stringRedisTemplate.delete(key);
    }
  }

  private String getToken(String key) {
    return get(formatKey(key));
  }

  private String formatKey(String key) {
    return REDIS_KEY_PREFIX.concat(key);
  }

  private String formatToken(String token) {
    return REDIS_TOKEN_PREFIX.concat(token);
  }

  @Override
  public void reflushToken(String key, String token) {
    flushExpireAfterOperation(key, token);
  }

}
