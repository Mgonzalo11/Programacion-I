1.1. Conceptos generales de orientación a objetos,
Java y programación en general
Ejercicio 1. Defina los siguientes términos:
1. Objeto: un objeto es una entidad de un programa capaz de tener al mismo tiempo una serie de valores y de métodos.
2. Propiedad de un objeto: característica o atributo que está asociada a un objeto
3. Mensaje: es la comunicación entre diferentes objetos que llama a un método
4. Clase: plantilla en la que se va a definir las características y el comportamiento de un programa
5. Atributo: define el estado o alguna característica de un objeto.
6. Método: función que define como se va a comportar un objeto.
7. Miembro estático de una clase (atributos y métodos de clase): es un elemento que esta asociado a la clase en general no a una instancia individual.
8. Variable: espacio de memoria que guarda el programa en el ordenador para almacenar cierto dato y poder utilizarlo en el futuro.
9. Parámetro: datos que se pasan a un método para su procesamiento
10. Tipo: clase de datos que pueden almacenar variables.
11. Tipo básico: int, char y boolean. Se refieren a números enteros, caracteres y booleanos.
12. UML: combinación de varias notaciones orientadas a objetos: diseño orientado a objetos, técnica de modelado de objetos e ingeniería de software orientada a objetos
13. Compilador: programa que traduce código fuente a código máquina.
14. Intérprete: programa que ejecuta código línea por línea sin compilarlo.
15. Paso de parámetros por valor: se pasa una copia del valor al método.
16. Paso de parámetros por referencia: se pasa la referencia al valor original al método.
17. El objeto this: hace referencia al objeto actual dentro de su clase.
18. Los setters: establece el valor de un atributo.
19. Los getters: obtiene el valor de un atributo.
20. Sobrecarga: situación que ocurre cuando se define varios métodos con el mismo nombre pero diferentes parámetros.
21. El classpath: ruta que usa el sistema para encontrar clases y paquetes.

Ejercicio 2. Explique los diferentes niveles de computación vistos en clase.

Computadoras sin programa almacenado: Sistemas que ejecutan instrucciones directamente sin guardar programas en la memoria; se programan manualmente usando hardware o tarjetas perforadas.

Computadoras con programa almacenado: Computadoras que pueden guardar programas en memoria, permitiendo modificar y ejecutar diferentes programas sin cambiar el hardware.

Lenguajes ensambladores: Lenguajes de bajo nivel que utilizan códigos mnemotécnicos para representar instrucciones de la máquina, específicos para cada arquitectura.

Lenguajes de alto nivel: Lenguajes de programación más abstractos y fáciles de usar, independientes de la arquitectura, como Java, Python o C++. Traducen el código a lenguaje máquina mediante compiladores o intérpretes.

Ejercicio 3. Explique los tipos básicos de Java.
Se dividen en cuatro categorías:

Enteros:
byte (8 bits)
short (16 bits)
int (32 bits)
long (64 bits)

Coma flotante (números con decimales):
float (32 bits)
double (64 bits)

Caracteres:
char (16 bits, almacena un carácter Unicode)

Booleanos:
boolean (puede tener solo dos valores: true o false)

Ejercicio 4. Explique los convenios de nombrado en Java.

Por lo general se inician las clases se inician con mayúscula y se usa camelCase y para las variables se inician con minúscula y también se usa camelCase. También se pueden utilizar _ pero nunca usar espacios.

Ejercicio 5. El propósito del siguiente ejercicio es presentar la máquina
virtual de Java. Se propone realizar los siguientes apartados:
1. Visualice el siguiente vídeo: https://www.youtube.com/watch?
v=tcC-4jGtkHM sobre la máquina virtual de Java (JVM).
2. Explique qué es la JVM.
La JVM (Java Virtual Machine) es una máquina virtual que permite ejecutar programas escritos en Java. 
3. Explique cuál es su motivación.
Se encarga de interpretar el código intermedio generado al compilar un programa Java, y lo convierte en instrucciones comprensibles para el sistema operativo y hardware subyacentes.
4. ¿Tiene sentido desarrollar un lenguaje de programación que no sea
Java pensado para que se ejecute sobre la máquina virtual de Java?
Justifique la respuesta.
Podría hacerse perfectamente ya que se puede sacar partido de la portabilidad, seguridad y eficiencia a la hora de gestionar memoria por parte de JVM. Además esta cuenta con muchas bibliotecas y herramientas y se pueden aprovechar para otros lenguajes de programación.
5. ¿Tiene sentido que haya diferentes versiones de la JVM para un mismo
sistema operativo sobre una misma arquitectura?
Podría ser de utilidad en ciertas ocasiones que la compatibilidad y los requerimientos sean específicos y se necesiten de versiones antiguas o modernas.
6. ¿Cómo se puede instalar la JVM?
En la página oficial de Oracle se descarga el paquete oficial de JDK y se siguen las instrucciones del instalador, con el comando java --versión se confirma la instalación. En la variable de entorno path debemos revisar que se encuentre la ruta del directorio bin de la versión de JDK instalado.

Ejercicio 6. Explique los siguientes niveles de alcance: private, protected
y public. ¿Qué alcance tienen aquellos miembros para los que no se utiliza
ninguna de las palabras reservadas anteriores?
private: El miembro es accesible solo dentro de la misma clase.
protected: El miembro es accesible dentro del mismo paquete y por las clases que heredan de la clase.
public: El miembro es accesible desde cualquier clase.
Si no se especifica ningún modificador o esta por defecto el miembro es accesible solo dentro del mismo paquete.

Ejercicio 7. Explique cómo quedan almacenados los objetos en memoria
para los siguientes casos:
1. Un objeto simple que sólo tiene atributos con tipos básicos.
2. Un objeto que tiene como atributo una referencia a otro objeto.
3. Un objeto que tiene como atributo una referencia a un array de objetos.
Los objetos almacenan directamente sus atributos básicos y referencias a otros objetos o arrays, mientras que los objetos referenciados y los elementos del array se almacenan en sus propias ubicaciones en memoria.