package com.jdmp.aldeamo.usecase.bartender;

import com.jdmp.aldeamo.domain.ArraysData;
import com.jdmp.aldeamo.exceptions.CustomExeption;
import com.jdmp.aldeamo.usecase.arrays.ArraysUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BartenderUseCaseImpl implements BartenderUseCase {

    private final static Logger LOG = Logger.getLogger(BartenderUseCase.class.getName());

    @Autowired
    private ArraysUseCase arraysUseCase;

    /**
     * Recorre Realiza las iteraciones correspondientes al parametro y va retirando
     * de la pila (extraida de la bd segun el id enviado como parametro|pila) el vaso
     * correspodiente de acuerdo a si es divisible uniformemente por el numero
     * primo correspodiente a la iteraccion.
     * Devuelve el resultado en un String con los vaso que fueron retirados de la pila
     *
     * @param iteraciones
     * @param pila
     * @return String
     */
    @Override
    public String initBartender(Integer iteraciones, Integer pila) {

        LOG.log(Level.INFO, "Iniciado initBartender");
        String result = null;

        Optional<ArraysData> stacks = arraysUseCase.findById(pila);
        if (stacks.isPresent()) {

            LinkedList<Integer> aStack = convertStringToStack(stacks.get().getInputArray());
            List<Integer> primes = prime(iteraciones + 100);

            ArrayList<Integer> respuesta = new ArrayList<>();
            ListIterator<Integer> listIterator;
            for (int i = 0; i < iteraciones; i++) {
                listIterator = aStack.listIterator();
                while (listIterator.hasNext()) {
                    Integer num = listIterator.next();
                    Integer mod = num % primes.get(i);
                    if (mod == 0) {
                        listIterator.remove();
                        respuesta.add(num);
                    }
                }
            }
            result = respuesta.stream().map(String::valueOf).collect(Collectors.joining(","));

        } else {
            throw new CustomExeption("No se encontro una pila con ese ID");
        }
        LOG.log(Level.INFO, "Finalizando initBartender");
        return result;
    }


    /**
     * Covierte el String enviado como parametro en una Pila (Stack)
     *
     * @param stackStr
     * @return LinkedList<Integer>
     */
    public LinkedList<Integer> convertStringToStack(String stackStr) {
        LOG.log(Level.INFO, "Iniciado convertStringToStack");
        String[] lista = stackStr.split(",");
        LinkedList<Integer> aStack = new LinkedList<>();
        for (int i = 0; i < lista.length; i++) {
            try {
                aStack.push(Integer.valueOf(lista[i]));
            } catch (Exception e) {
                throw new CustomExeption("Error al convertir el numero - Formato invalido");
            }
        }
        LOG.log(Level.INFO, "Finalizando convertStringToStack");
        return aStack;
    }


    /**
     * Devuelve la lista de los numeros primos hasta el numero enviado como parametro
     *
     * @param num
     * @return List<Integer>
     */
    public static List<Integer> prime(int num) {
        LOG.log(Level.INFO, "Iniciado prime");
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= num; ++i) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        LOG.log(Level.INFO, "Finalizando prime");
        return result;
    }

    /**
     * Valida si el numero enviado como parametro es Primo
     *
     * @param i
     * @return boolean
     */
    private static boolean isPrime(int i) {
        LOG.log(Level.INFO, "Iniciado isPrime");
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != i)) {
            if (i % contador == 0)
                primo = false;
            contador++;
        }
        LOG.log(Level.INFO, "Iniciado isPrime");
        return primo;
    }


}
