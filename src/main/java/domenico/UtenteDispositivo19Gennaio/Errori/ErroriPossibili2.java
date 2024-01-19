package domenico.UtenteDispositivo19Gennaio.Errori;

import java.time.LocalDate;


public record ErroriPossibili2(String message,
                               LocalDate timestamp) {

    public  ErroriPossibili2(String message,LocalDate timestamp){
        this.message=message;
        this.timestamp=timestamp;
    }

}
