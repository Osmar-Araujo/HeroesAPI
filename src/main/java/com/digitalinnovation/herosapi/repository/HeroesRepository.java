package com.digitalinnovation.herosapi.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.digitalinnovation.herosapi.document.Heroes;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String>{

}
