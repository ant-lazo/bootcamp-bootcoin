package com.nttdata.bootcamp.services;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.api.client.RateBootcoinApiClient;
import com.nttdata.bootcamp.config.Util;
import com.nttdata.bootcamp.models.Bootcoin;
import com.nttdata.bootcamp.redis.models.RateBootcoinCache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BootcoinServiceImp implements BootcoinService{
	
	private final RateBootcoinService rateBootcoinService;
	private final RateBootcoinApiClient rateBootcoinApiClient;

	@Override
	public String processBootcoin(Bootcoin bootcoin) throws InterruptedException {
		
		if(bootcoin.getTypeTransaction().equals(Util.PURCHASE)) {
			if(rateBootcoinService.getAll().isEmpty()) {
				rateBootcoinService.storageRateBootcoinCache(
					rateBootcoinApiClient.getActiveRateBoincoinList()
					.stream()
					.map(RateBootcoinCache::fromRateBootcoinResponse)
					.collect(Collectors.toList())
				);
			}
			log.info("from Redis Cache: "+rateBootcoinService.getAll().toString());
			return "Processing Draft";
		}else {
			return "Procession "+ bootcoin.getTypeTransaction();
		}
	}

}
