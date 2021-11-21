package com.jdmp.aldeamo.conf;

import com.jdmp.aldeamo.service.ArraysRepositoryData;
import com.jdmp.aldeamo.usecase.arrays.ArraysUseCase;
import com.jdmp.aldeamo.usecase.arrays.ArraysUseCaseImpl;
import com.jdmp.aldeamo.usecase.bartender.BartenderUseCase;
import com.jdmp.aldeamo.usecase.bartender.BartenderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {
    @Bean
    public ArraysUseCase createModuleArraysUseCase(ArraysRepositoryData arraysRepositoryData){
        return new ArraysUseCaseImpl(arraysRepositoryData);
    }

    @Bean
    public BartenderUseCase createModuleBartenderUseCase() {
        return new BartenderUseCaseImpl();
    }

}
