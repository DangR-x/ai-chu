package com.aichu.manager.dao;

import com.aichu.common.util.common.CommonUtils;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class SmsCodeCacheDao extends RedisGeneratorDao<String, String> {

	private String cacheKey = "china_data_tangor_sms:";

	/**
	 * 获取验证码
	 * @param mobile
	 * @param codeLength
	 * @return
	 */
	public String getAuthCode(String mobile, Integer codeLength,Long timeout) {
		String authCode = CommonUtils.get(codeLength).toString().trim();
		// 存储到redis并设置过期时间
		redisTemplate.boundValueOps(cacheKey + mobile).set(authCode, timeout, TimeUnit.MINUTES);
		return redisTemplate.boundValueOps(cacheKey + mobile).get();
	}

	/**
	 * 清空验证码
	 * 
	 * @param mobile
	 */
	public void deleteAuthCodeCache(String mobile) {
		redisTemplate.delete(cacheKey + mobile);
	}

	/**
	 * 验证验证码
	 * 
	 * @param mobile
	 * @return
	 */
	public String getAuthCode(String mobile) {
		String cacheToken = redisTemplate.boundValueOps(cacheKey + mobile).get();
		//redisTemplate.delete(_cache_key + mobile);
		return cacheToken;
	}
}
