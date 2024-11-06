/*El error de compilación en este código se debe a que la clase C no tiene un constructor sin parámetros.
package dominio;
public class C {
    private int a, b;
    public C(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
La clase C tiene un único constructor que requiere dos parámetros (int a y int b). Esto significa que no existe un constructor sin parámetros en C

package aplicacion;
import dominio.C;
public class Principal {
    public static void main(String[] args) {
        C c = new C();  // Error de compilación: no existe un constructor sin parámetros en C
        System.out.println(c);
    }
}
En la clase Principal, se intenta crear una instancia de C con new C(). Como C no tiene un constructor sin parámetros, el compilador genera un error al intentar encontrar un constructor que coincida con C().

Para corregir el error de compilación, puedes hacer cualquiera de las siguientes modificaciones:

Agregar un constructor sin parámetros en C
public class C {
    private int a, b;
    public C() {
        // Constructor sin parámetros
    }
    public C(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
Modificar la creación de la instancia en Principal para pasar los parámetros requeridos
public class Principal {
    public static void main(String[] args) {
        C c = new C(1, 2);  // Crear instancia de C con parámetros
        System.out.println(c);
    }
 */