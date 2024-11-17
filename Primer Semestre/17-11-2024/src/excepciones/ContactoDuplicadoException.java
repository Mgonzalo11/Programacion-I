package excepciones;
import dominio.Contacto;
public class ContactoDuplicadoException extends Exception {
    private Contacto c;
    public ContactoDuplicadoException(Contacto contacto){
        c = contacto;
    }
    public Contacto getContacto(){
        return c;
    }
}