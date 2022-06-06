package com.nttdata.bootcamp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.redis.models.RateBootcoinCache;
import com.nttdata.bootcamp.repository.RateBootcoinRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RateBootcoinServiceImp implements RateBootcoinService{

	private final RateBootcoinRepository repo;
	
	@Override
	public List<RateBootcoinCache> getAll() {
		try {
			List<RateBootcoinCache> rateBootcoinCacheList= new ArrayList<>();
			repo.findAll().forEach(rateBootcoinCacheList::add);
			return rateBootcoinCacheList;
		}
		catch (Exception e) {
			log.error("Error while trying to get RateBootcoinCache from Redis cache "+e.getMessage());
			return Collections.EMPTY_LIST;
		}
	}

	@Override
	public String storageRateBootcoinCache(List<RateBootcoinCache> rateBootcoinCacheList) {
		try {
			Iterable<RateBootcoinCache> rateBootcoinCacheIterable = rateBootcoinCacheList;
			repo.saveAll(rateBootcoinCacheIterable);
			return "RateBootcoinCache create successfully";
		}
		catch(Exception e){
			return "Error saving RateBootcoin cache list. "+e.getMessage();
		}
	}

}
