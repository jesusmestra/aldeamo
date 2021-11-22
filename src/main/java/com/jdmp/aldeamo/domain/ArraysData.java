package com.jdmp.aldeamo.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;



@Builder
@Entity()
@Table(name = "ARRAYS")
@Data
public class ArraysData {
    public ArraysData() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "input_array")
    private String inputArray;

    public Integer getId() {
        return id;
    }

    public String getInputArray() {
        return inputArray;
    }
}
