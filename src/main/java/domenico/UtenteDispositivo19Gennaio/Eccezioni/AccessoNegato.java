package domenico.UtenteDispositivo19Gennaio.Eccezioni;

import java.time.LocalDate;

public class AccessoNegato extends RuntimeException{
    public AccessoNegato(String message, LocalDate timestamp){
        super(message);
    }
}
