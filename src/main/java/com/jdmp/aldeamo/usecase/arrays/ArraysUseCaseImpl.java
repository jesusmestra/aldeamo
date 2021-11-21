package com.jdmp.aldeamo.usecase.arrays;

import com.jdmp.aldeamo.domain.ArraysData;
import com.jdmp.aldeamo.service.ArraysRepositoryData;
import com.jdmp.aldeamo.usecase.bartender.BartenderUseCase;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArraysUseCaseImpl implements ArraysUseCase{

    private ArraysRepositoryData arraysRepositoryData;

    public ArraysUseCaseImpl(ArraysRepositoryData arraysRepositoryData) {
        this.arraysRepositoryData = arraysRepositoryData;
    }

    /**
     * Busca en la BD el Objeto que corresponda a Id enviado como parametro
     *
     * @param id
     * @return Optional<ArraysData>
     */
    @Override
    public Optional<ArraysData> findById(Integer id) {
        return arraysRepositoryData.findById(id);
    }


}
