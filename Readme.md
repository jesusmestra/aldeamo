
# Challenger Aldeamo - Bartender

Microservice que permite ir retirando vasos de acuerdo a los parametros de entrada.

Recorre Realiza las iteraciones correspondientes al parametro y va retirando
de la pila (extraida de la bd segun el id enviado como parametro|pila) el vaso
correspodiente de acuerdo a si es divisible uniformemente por el numero
primo correspodiente a la iteraccion.
Devuelve el resultado en un String con los vaso que fueron retirados de la pila


###Prueba:
Eres un bar ténder del bar más famoso de tu ciudad. Hay un arreglo de vasos numerados que está
representado por el arreglo A. Adicional se tiene un arreglo con números primos representado
por P.

Valor del array P
```javascript
P=2,3,5,7,11,13,17...
```

En cada iteración Qi, retira cada vaso de la parte superior del arreglo A. Determina si el número
del plato es divisible uniformemente por el Pi número primo. Si lo es, agréguelo en un arreglo B.
En caso contrario, añádalo a un arreglo Ai. Guarda los valores de B en el arreglo Respuesta. En
la siguiente iteración, haz lo mismo con los valores del arreglo Ai. Una vez completado el
número necesario de iteraciones Q, almacene los valores restantes de Ai, al final de Respuesta.

Se debe exponer un API que reciba un numero de iteraciones Q y un número del 1 al 5 que
representara el id de la pila de datos a trabajar (script de DB entregados) y entregue el array de
respuesta


## Ejemplo:
```javascript
INPUT
A0=2,3,4,5,6,7
Q=3

Q1:
B=6,4,2
A1=7,5,3
Respuesta=6,4,2

Q2:
A1=7,5,3
B=3
A2=5,7
Respuesta=6,4,2,3

Q3:
A2=5,7
B=5
A3=7
Respuesta=6,4,2,3,5

Como Q ya se completó entonces:

OUTPUT
Respuesta=6,4,2,3,5
```





## Desplegar

Ejecutar el siguiente comando:

```bash
gradle bootRoon
```

## End-Point | LOCAL

```html
http://localhost:8080/bartender
```


## End-Point Heroku - Bartender | POST


[MUTANT: http://heroku.com/bartender](http://heroku/bartender)

```javascript
{
    "iteraciones": 1,
    "pila": 6
}
```


RESPUESTA
```javascript
6,4,2
```

## Desarrollado por:
Jesus David Mestra Polo

[jesusmestra@gmail.com](email:jesusmestra@gmail.com)