package domenico.UtenteDispositivo19Gennaio.Eccezioni;

import java.util.UUID;

public class DispositivoNonTrovato extends RuntimeException{
    public DispositivoNonTrovato(UUID idDispositivo){
        super("id del dispositivo "+ idDispositivo+" non trovato");
    }
}
