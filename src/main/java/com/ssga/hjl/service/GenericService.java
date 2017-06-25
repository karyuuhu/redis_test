package com.ssga.hjl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<E> {

	@Autowired
	private RedisTemplate<String, E> redisTemplate;

	public RedisTemplate<String, E> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, E> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
