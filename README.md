# Examen Mercadolibre

## Introdución

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. con este objetivo se crea 
API REST que analice una ADN y concluya si es mutante. recibirás como parámetro un array de Strings que representan 
cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.  

### Ejemplo (Caso mutante):

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal
o vertical. Ejemplo (Caso mutante):


String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    "A T G C G A"
    "C A G T G C"
    "T T A T G T"
    "A G A A G G"
    "C C C C T A"
    "T C A C T G"

## Caracteristicas del Proyecto

- Lenguaje Java
- API REST la cual detecta ADN y determina si es Mutante, esta despelagada en Amazon AWS.
- Consulta de estadisticas de Mutantes y Humanos detectados ,persistencia en base de datos MySql.
- Covertura de las pruebas - > 82 % 

## Instrucciones de Ejecucion

El servicio se en cuantra desplegado en Amazon Elastic Beanstalk.

La API cuenta con dos metodos:

http://proyectoadnmeli-env.eba-2kfeqdha.us-east-1.elasticbeanstalk.com/mutant </br>
http://proyectoadnmeli-env.eba-2kfeqdha.us-east-1.elasticbeanstalk.com/stats

 *  Metodo  POST para identificar si un ADN es Mutante:

   http://proyectoadnmeli-env.eba-2kfeqdha.us-east-1.elasticbeanstalk.com/mutant </br>
   Para probar el servicio se debe enviar la secuencia en un HTTP POST  con un Json que tenga 
   el siguiente formato:

   {"dna":["TTGCGA", "CTGTGC", "TTATGT", "AGAAGG", "CCCTTA", "TCTCTG"]}

   Si se detecta que la secuencia ADN es de un mutante , el servicio retornara HTTP 200 OK, 
   de lo contrario retornara 403 - Forbidden.

 * Mtodo GET obtiene las estadisticas del las verificaciones 

   http://proyectoadnmeli-env.eba-2kfeqdha.us-east-1.elasticbeanstalk.com/stats

   {"count_mutant_dna": 40, "count_human_dna": 100: "ratio": 0.4}


## Prueba en Postman 

 *  Metodo  POST para identificar si un ADN es Mutante:

![image](https://user-images.githubusercontent.com/34867751/166400713-ab790f73-bf48-44cf-aa5e-944bbad07651.png)


 * Mtodo GET obtiene las estadisticas del las verificaciones 
 
 ![image](https://user-images.githubusercontent.com/34867751/166400769-abaa5edd-af9c-4f0e-8470-758d12813b8f.png)

## Ambiente 
 
 * Java 8 : (https://www.oracle.com/java/technologies/downloads/)
 * Maven : (https://maven.apache.org/)
 * IDE Intellij IDEA : (https://www.jetbrains.com/idea/)
 * Junit 4 :(https://junit.org/junit4/)
 * Covertura JaCoCo : (https://www.jacoco.org/)


