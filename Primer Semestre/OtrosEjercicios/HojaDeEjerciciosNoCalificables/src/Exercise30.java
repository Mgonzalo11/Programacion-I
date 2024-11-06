/* En este código, el error de compilación se debe a que la clase `A` no tiene un constructor
El error de compilación en este código se debe a que la clase A no tiene un constructor que acepte dos parámetros.
En Java, cuando una clase no define un constructor explícito, el compilador genera un constructor por defecto sin parámetros.
public class A {

}

package dominio;
public class B extends A {
    private int a, b;

Para solucionar esto, hay dos opciones:

Agregar un constructor con dos parámetros en A:
package dominio;
public class A {
    public A(int a, int b) {
        // Constructor que recibe dos parámetros
    }
}

Modificar el constructor de B para llamar al constructor sin parámetros de A:
    public B(int a, int b) {
        super(a, b);  // Error de compilación: no existe un constructor en A que reciba dos parámetros
        this.a = a;
        this.b = b;
    }
}
*/