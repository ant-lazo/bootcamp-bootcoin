package com.nttdata.bootcamp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.redis.models.RateBootcoinCache;

@Repository
public interface RateBootcoinRepository extends CrudRepository<RateBootcoinCache, String>{

}
