package com.jdmp.aldeamo.usecase.arrays;

import com.jdmp.aldeamo.domain.ArraysData;

import java.util.Optional;

public interface ArraysUseCase {
    public Optional<ArraysData> findById(Integer id);
}
