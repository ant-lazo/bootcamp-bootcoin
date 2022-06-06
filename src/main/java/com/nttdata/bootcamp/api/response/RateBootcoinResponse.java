package com.nttdata.bootcamp.api.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RateBootcoinResponse {
	private String id;
	private String typeTransaction;
	private BigDecimal minimunAmount;
	private BigDecimal maximunAmount;
	private BigDecimal price;
}
