package com.ssga.hjl.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssga.hjl.entity.Fund;

@Service
public class FundService extends GenericService<Fund> {

	@Cacheable(value="Funds")
	public Fund getFundByTicker(String ticker) {
		System.out.println("begin to get fund for:" + ticker);
		Fund fund = (Fund)getRedisTemplate().opsForHash().get("ticker", ticker);
		return fund;
	}
	
	public void saveFund(Fund fund) {
		getRedisTemplate().opsForHash().put("ticker", fund.getTickerSymbol(), fund);
	}
}
