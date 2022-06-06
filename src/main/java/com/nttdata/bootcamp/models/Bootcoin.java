package com.nttdata.bootcamp.models;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bootcoin implements Serializable{
	private String id;
	private String typeTransaction;
	private BigDecimal amount;
}
