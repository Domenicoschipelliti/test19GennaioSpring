package domenico.UtenteDispositivo19Gennaio.Eccezioni;

import java.util.UUID;

public class UtenteNonTrovato extends RuntimeException{
   public UtenteNonTrovato(UUID id){
       super("utente con id "+id+" non trovato");
   }
}
