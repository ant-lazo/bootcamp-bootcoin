package com.nttdata.bootcamp.redis.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.redis.core.RedisHash;

import com.nttdata.bootcamp.api.response.RateBootcoinResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("RateBootcoin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RateBootcoinCache implements Serializable{
	private String id;
	private String typeTransaction;
	private BigDecimal minimunAmount;
	private BigDecimal maximunAmount;
	private BigDecimal price;
	
	public static RateBootcoinCache fromRateBootcoinResponse(RateBootcoinResponse rateBootcoinResponse) {
		return RateBootcoinCache.builder()
				.id(rateBootcoinResponse.getId())
				.typeTransaction(rateBootcoinResponse.getTypeTransaction())
				.minimunAmount(rateBootcoinResponse.getMinimunAmount())
				.maximunAmount(rateBootcoinResponse.getMaximunAmount())
				.price(rateBootcoinResponse.getPrice())
				.build();
	}
}
