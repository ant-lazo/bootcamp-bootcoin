package com.nttdata.bootcamp.services;

import java.util.List;

import com.nttdata.bootcamp.redis.models.RateBootcoinCache;

public interface RateBootcoinService {
	List<RateBootcoinCache> getAll();
	String storageRateBootcoinCache(List<RateBootcoinCache> rateBootcoinCacheList);
}
