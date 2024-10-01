EJERCICIO LOGARITMO DE EUCLIDES
import java.util.Scanner;  // Importamos la clase Scanner para pedir valores de las variables
public class algoritmoDeEuclides {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);
        // Declaramos de las variables n, m y r
        System.out.println("Bem-vindo ao programa de algoritmo euclidiano");
        System.out.print("Introduce el valor de n: ");
        int n = input.nextInt();  // El programa lee el valor de n
        System.out.print("Introduce el valor de m: ");
        int m = input.nextInt();  // El programa lee el valor de m
        int r;
        int nInicial = n; //Guardamos el valor de la n
        int mInicial = m; //Guardamos el valor de la m
        // Mientras el resto no sea 0
        while (m != 0) {
            r = n % m;  //  Guardamos el resto de la división n/m
            System.out.println("n: " + n + ", m: " + m + ", r: " + r); // Imprimos por pantalla cada paso del algoritmo
            n = m;      // m pasa a ser n
            m = r;      // r pasa a ser m
        }
        // Imprimir el último valor de n, que es el MCD
        System.out.println("El máximo común divisor de " + nInicial + " y " + mInicial + " es: " + n);
        input.close();
    }
}

EJERCICIO MULTIPLICACIÓN RUSA
import java.util.Scanner;  // Importamos la clase Scanner para pedir valores de las variables
public class algoritmoDeEuclides {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);
        // Declaramos de las variables n, m y r
        System.out.println("Bem-vindo ao programa de algoritmo euclidiano");
        System.out.print("Introduce el valor de n: ");
        int n = input.nextInt();  // El programa lee el valor de n
        System.out.print("Introduce el valor de m: ");
        int m = input.nextInt();  // El programa lee el valor de m
        int r;
        int nInicial = n; //Guardamos el valor de la n
        int mInicial = m; //Guardamos el valor de la m
        // Mientras el resto no sea 0
        while (m != 0) {
            r = n % m;  //  Guardamos el resto de la división n/m
            System.out.println("n: " + n + ", m: " + m + ", r: " + r); // Imprimos por pantalla cada paso del algoritmo
            n = m;      // m pasa a ser n
            m = r;      // r pasa a ser m
        }
        // Imprimir el último valor de n, que es el MCD
        System.out.println("El máximo común divisor de " + nInicial + " y " + mInicial + " es: " + n);
        input.close();
    }
}

EJERCICIO 1
import java.util.Scanner; //Scanner para que el usuario introduzca los datos
public class ejercicioIntro {
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in); //Iniciamos el scanner
        //Println salta una linea y Print no salta linea
        System.out.println("Receperint programmata introductoria in JAVA");
        System.out.print("Introduce el primer numero: ");
        int x = input.nextInt(); //Leemos el valor de la variable introducida
        System.out.print("Introduce el segundo numero: ");
        int y = input.nextInt();
        //Operaciones básicas
        int suma=x+y, producto=x*y, cociente=x/y;
        System.out.println("Su suma es: " +suma);
        System.out.println("Su producto es: " +producto);
        System.out.println("Su cociente es: " +cociente);
        //Comparación del primero con el segundo
        if (x>y){
            System.out.println(x+" es mayor que"+y);
        } else if (x<y) {
            System.out.println(y+" es mayor que"+x);
        }else System.out.println(x+" es igual que"+y);
        //Comprobación de si ambos numeros son pares
        if(x%2==0 && y%2==0){
            System.out.println(x+" y " +y+ " Son pares");
        } else System.out.println(x+" y " +y+ " Son impares");
        //Comprobación de si ambos numeros son divisibles entre si
        if(x%y==0 && y%x==0){
            System.out.println(x+" y " +y+ " Son divisibles entre si");
        } else System.out.println(x+" y " +y+ " No son divisibles entre si");
        //Comprobación de si el primer numero se encuentra en el intervalo [1,10]
        if (1<=x && 10>=x){
            System.out.println(x+" Se encuentra en el intervalo [1,10]");
        }else System.out.println(x+" NO se encuentra en el intervalo [1,10]");
        //Comprobación de si ambos numeros se encuentran en el intervalo [1,10]
        if (1<=x && 10>=x && 1<=y && 10>=y){
            System.out.println(x+" y "+y+" Se encuentran en el intervalo [1,10]");
        }else System.out.println(x+" y "+y+" NO se encuentran en el intervalo [1,10]");
        //Incrementación de x con y
        int xinicial = x; //Guardamos el valor de x inicial
        x+=y;
        System.out.println("El valor de " + xinicial + " incrementado por " + y + " es " + x);
        input.close();//Apagamos el scanner
    }
}

EJERCICIO 2
import java.util.Scanner;
public class ejercicioTriangulos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("benvenuti al programma sui triangoli in JAVA");
        System.out.print("Introduce el posible valor del lado a: ");
        int a = input.nextInt();
        System.out.print("Introduce el posible valor del lado b: ");
        int b = input.nextInt();
        System.out.print("Introduce el posible valor del lado c: ");
        int c = input.nextInt();
        //Comprobación de si los valores son validos
        if (a+b>c && a+c>b && b+c>a){
            System.out.println("Los valores de los lados son válidos");
                //Comprobación del tipo de triangulo que forman los lados después de validar valores
                if (a==b && b==c){
                    System.out.println("El triángulo es equilatero");
                } else if (a==b && b!=c || b==c && c!=a ) {
                    System.out.println("El triángulo es isósceles");
                }else System.out.println("El triángulo es escaleno");
        }else System.out.println("Los valores de los lados NO son válidos");
        input.close();//Apagamos el scanner
    }
}