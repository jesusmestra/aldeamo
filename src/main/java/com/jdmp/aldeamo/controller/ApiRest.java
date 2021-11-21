package com.jdmp.aldeamo.controller;

import com.jdmp.aldeamo.domain.Body;
import com.jdmp.aldeamo.usecase.bartender.BartenderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@AllArgsConstructor
@Validated
public class ApiRest {

    private final static Logger LOG = Logger.getLogger(ApiRest.class.getName());

    @Autowired
    private BartenderUseCase bartenderUseCase;


    @GetMapping(path = "/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    /**
     * Punto de entrada que permite ir retirando vasos de acuerdo a los parametros de entrada
     * @param body
     * @return String
     * Si con la informacion enviada es correcta devuelve codigo con Status 200.
     * Adicional si valida que los datos de entrada presenta errores devuelve un Status 400.
     * Si se presenta un error en la ejecucion se devuelve Status 424.
     *
     */
    @RequestMapping(path = "/bartender", method = RequestMethod.POST)
    public ResponseEntity<String> bartender(@Valid @RequestBody Body body) {
        LOG.log(Level.INFO, "Iniciado bartender");
        String response =  bartenderUseCase.initBartender(body.getIteraciones(), body.getPila());
        LOG.log(Level.INFO, "Finalizado bartender");
        return (response != null)?new ResponseEntity<>(response, HttpStatus.OK):new ResponseEntity<>(HttpStatus.FORBIDDEN);


    }

}
