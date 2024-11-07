import java.time.LocalDateTime; // Para trabajar con fechas y horas
import java.time.ZoneId; // Para trabajar con zonas horarias
import java.time.format.DateTimeFormatter; // Para formatear la fecha a un formato específico
import java.time.temporal.ChronoUnit; // Para calcular la diferencia entre dos fechas
import java.time.Period; // Para calcular la diferencia en años, meses y días

public class FechasEnJava {
    public static void main(String[] args) {
        // Formato de fecha en España (día/mes/año hora:minuto:segundo)
        DateTimeFormatter formatoEspañol = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // --------------------------------------------------------------
        // Ejercicio 1: La fecha actual local
        LocalDateTime fechaActualLocal = LocalDateTime.now();
        System.out.println("\n🌍 **Fecha actual local**:");
        System.out.println("Hoy es: " + fechaActualLocal.format(formatoEspañol));

        // --------------------------------------------------------------
        // Ejercicio 2: La fecha actual en Caracas
        LocalDateTime fechaActualCaracas = LocalDateTime.now(ZoneId.of("America/Caracas"));
        System.out.println("\n🌎 **Fecha actual en Caracas**:");
        System.out.println("En Caracas ahora mismo es: " + fechaActualCaracas.format(formatoEspañol));

        // --------------------------------------------------------------
        // Ejercicio 3: Los años transcurridos desde el descubrimiento de América
        LocalDateTime descubrimientoAmerica = LocalDateTime.of(1492, 10, 12, 0, 0);
        long añosTranscurridos = ChronoUnit.YEARS.between(descubrimientoAmerica, fechaActualLocal);
        System.out.println("\n🗺️ **Años transcurridos desde el descubrimiento de América**:");
        System.out.println("¡Han pasado " + añosTranscurridos + " años desde que Colón llegó a América!");

        // --------------------------------------------------------------
        // Ejercicio 4: La hora actual local
        System.out.println("\n⏰ **Hora actual local**:");
        System.out.println("La hora en tu zona es: " + fechaActualLocal.toLocalTime());

        // --------------------------------------------------------------
        // Ejercicio 5: La hora actual en Caracas
        System.out.println("\n⏱️ **Hora actual en Caracas**:");
        System.out.println("La hora en Caracas es: " + fechaActualCaracas.toLocalTime());

        // --------------------------------------------------------------
        // Ejercicio 6: Las horas de diferencia entre Madrid y Caracas
        long diferenciaHoras = ChronoUnit.HOURS.between(fechaActualLocal.atZone(ZoneId.of("Europe/Madrid")), fechaActualCaracas.atZone(ZoneId.of("America/Caracas")));
        System.out.println("\n⏳ **Diferencia horaria entre Madrid y Caracas**:");
        System.out.println("La diferencia horaria entre Madrid y Caracas es de " + diferenciaHoras + " horas.");

        // --------------------------------------------------------------
        // Ejercicio 7: La fecha y la hora cuando Neil Armstrong pisó la luna
        LocalDateTime neilArmstrong = LocalDateTime.of(1969, 7, 21, 3, 56);
        System.out.println("\n🌕 **Neil Armstrong pisó la luna**:");
        System.out.println("¡Recuerda ese momento histórico! Neil Armstrong pisó la luna el: " + neilArmstrong.format(formatoEspañol));

        // --------------------------------------------------------------
        // Ejercicio 8: Fecha y hora final de la carrera
        // Fecha final de la carrera (21 de junio de 2029 a las 12:00:00)
        LocalDateTime fechaFinalCarrera = LocalDateTime.of(2028, 6, 21, 12, 0, 0);
        LocalDateTime ahora = LocalDateTime.now();

        System.out.println("\n🎓 **Fecha final de la carrera**:");
        System.out.println("¡La fecha en que terminarás tu carrera será el: " + fechaFinalCarrera.format(formatoEspañol));

        // Calculamos la diferencia en años, meses, semanas, días, horas, minutos y segundos
        Period periodo = Period.between(ahora.toLocalDate(), fechaFinalCarrera.toLocalDate());

        long semanasRestantes = ChronoUnit.WEEKS.between(ahora, fechaFinalCarrera);
        long diasRestantes = ChronoUnit.DAYS.between(ahora, fechaFinalCarrera);
        long horasRestantes = ChronoUnit.HOURS.between(ahora, fechaFinalCarrera);
        long minutosRestantes = ChronoUnit.MINUTES.between(ahora, fechaFinalCarrera);
        long segundosRestantes = ChronoUnit.SECONDS.between(ahora, fechaFinalCarrera);

        System.out.println("\n📅 **Tiempo restante para terminar la carrera**:");
        System.out.println("Quedan: ");
        System.out.println("  - " + periodo.getYears() + " años");
        System.out.println("  - " + periodo.getMonths() + " meses");
        System.out.println("  - " + periodo.getDays() + " días");
        System.out.println("  - " + semanasRestantes + " semanas");
        System.out.println("  - " + horasRestantes + " horas");
        System.out.println("  - " + minutosRestantes + " minutos");
        System.out.println("  - " + segundosRestantes + " segundos");

        // --------------------------------------------------------------
        System.out.println("\n📚 **tRu5t.M3, 'M αn.3ngIn33R!**:");
    }
}