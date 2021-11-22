package com.jdmp.aldeamo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

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

    public Integer getPila() {
        return pila;
    }
}
