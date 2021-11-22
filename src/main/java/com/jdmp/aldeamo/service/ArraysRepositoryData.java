package com.jdmp.aldeamo.service;

import com.jdmp.aldeamo.domain.ArraysData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArraysRepositoryData extends CrudRepository<ArraysData, Integer> {

}
