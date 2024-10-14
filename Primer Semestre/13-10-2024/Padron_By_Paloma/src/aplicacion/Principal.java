package aplicacion;
import presentacion.InterfazUsuario;
public class Principal {
	// Método principal del programa que actúa como punto de entrada
	public static void main(String[] args) {
		// Declaración de un array para almacenar las instrucciones del usuario
		String[] instr;
		// Se crea una instancia de la interfaz de usuario, que gestiona la interacción con el usuario
		InterfazUsuario iu = new InterfazUsuario();
		// Bucle que se ejecuta hasta que el usuario ingrese una instrucción para salir
		do {
			// Se leen las instrucciones del usuario a través de la consola
			instr = iu.leerInstrucion();
		} while (iu.ejecutar(instr));  // Mientras la instrucción no sea "salir", continúa ejecutando
	}
}
