import java.math.BigInteger;
import java.util.Scanner;

public class AñosMesesSemanasDiasHorasMinutosSegundos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger segundos;

        // Definir constantes de tiempo en segundos
        BigInteger SEGUNDOS_POR_ANO = new BigInteger("31536000");
        BigInteger SEGUNDOS_POR_MES = new BigInteger("2592000");
        BigInteger SEGUNDOS_POR_SEMANA = new BigInteger("604800");
        BigInteger SEGUNDOS_POR_DIA = new BigInteger("86400");
        BigInteger SEGUNDOS_POR_HORA = new BigInteger("3600");
        BigInteger SEGUNDOS_POR_MINUTO = new BigInteger("60");

        do {
            // Solicitar al usuario que introduzca el número de segundos
            System.out.println("====================================");
            System.out.println("  Conversor de Segundos a Años, Meses, Semanas, Días, Horas y Minutos");
            System.out.println("====================================");
            System.out.print("Introduce el número de segundos (0 para salir): ");

            // Leer el número de segundos introducido por el usuario
            segundos = sc.nextBigInteger();

            if (!segundos.equals(BigInteger.ZERO)) {
                // Calcular el número de años, meses, semanas, días, horas y minutos
                BigInteger años = segundos.divide(SEGUNDOS_POR_ANO);
                segundos = segundos.mod(SEGUNDOS_POR_ANO);
                BigInteger meses = segundos.divide(SEGUNDOS_POR_MES);
                segundos = segundos.mod(SEGUNDOS_POR_MES);
                BigInteger semanas = segundos.divide(SEGUNDOS_POR_SEMANA);
                segundos = segundos.mod(SEGUNDOS_POR_SEMANA);
                BigInteger dias = segundos.divide(SEGUNDOS_POR_DIA);
                segundos = segundos.mod(SEGUNDOS_POR_DIA);
                BigInteger horas = segundos.divide(SEGUNDOS_POR_HORA);
                segundos = segundos.mod(SEGUNDOS_POR_HORA);
                BigInteger minutos = segundos.divide(SEGUNDOS_POR_MINUTO);
                BigInteger segundosRestantes = segundos.mod(SEGUNDOS_POR_MINUTO);

                // Mostrar el resultado al usuario
                System.out.println("====================================");
                System.out.printf("%d segundos son:%n", segundos);
                System.out.printf("  %d años%n", años);
                System.out.printf("  %d meses%n", meses);
                System.out.printf("  %d semanas%n", semanas);
                System.out.printf("  %d días%n", dias);
                System.out.printf("  %d horas%n", horas);
                System.out.printf("  %d minutos%n", minutos);
                System.out.printf("  %d segundos%n", segundosRestantes);
                System.out.println("====================================");
            }
        } while (!segundos.equals(BigInteger.ZERO));

        System.out.println("Programa terminado.");
    }
}