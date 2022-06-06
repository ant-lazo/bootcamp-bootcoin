package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.Bootcoin;

public interface BootcoinService {
	String processBootcoin(Bootcoin bootcoin) throws InterruptedException;
}
