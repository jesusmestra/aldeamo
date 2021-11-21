package com.jdmp.aldeamo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Body {
    @JsonProperty("iteraciones")
    @Min(value = 1, message = "Valor invalido")
    @NotNull(message = "Debe ingresar un valor")
    private Integer iteraciones;

    @Min(value = 1, message = "Valor invalido")
    @NotNull(message = "Debe ingresar un valor")
    @JsonProperty("pila")
    private Integer pila;


    public Integer getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(Integer iteraciones) {
        this.iteraciones = iteraciones;
    }

    public Integer getPila() {
        return pila;
    }

    public void setPila(Integer pila) {
        this.pila = pila;
    }
}
