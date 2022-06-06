package com.nttdata.bootcamp.api.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.api.response.RateBootcoinResponse;
import com.nttdata.bootcamp.config.RateBootcoinProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@RequiredArgsConstructor
public class RateBootcoinApiClient {
	private final WebClient webClient;
	private final RateBootcoinProperties rateBootcoinProperties;
	
	public List<RateBootcoinResponse> getActiveRateBoincoinList() throws InterruptedException{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<RateBootcoinResponse> result = new ArrayList<>();
		webClient.get().uri(rateBootcoinProperties.getBaseUrl() + "/rateBootcoin/active")
			.accept(MediaType.TEXT_EVENT_STREAM)
			.retrieve()
			.bodyToFlux(RateBootcoinResponse.class)
			.publishOn(Schedulers.fromExecutor(executor))
			.subscribe(rb -> result.add(rb));
		executor.awaitTermination(1, TimeUnit.SECONDS);
		log.info("RateBoincoin list"+result);
		return result;
		
	}
}
