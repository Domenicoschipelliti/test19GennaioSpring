package domenico.UtenteDispositivo19Gennaio.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UtenteDTO(@NotEmpty(message = "lo username con cui si è registrato nel sito è importante")@NotNull(message = "l'user deve essere messo") String username,
                        @NotEmpty(message = "Mettere il nome ci aiuterà ad identificarti")
                        @Size(min = 2,max = 20,message = "la lunghezza del nome va dai 2 a i 20 caratteri di solito")
                        String name,
                        @NotEmpty(message = "il cognome ha la stessa importanza del nome")
                        String surname,
                        @NotEmpty(message = "L'email ci aiuterà a mandarti il codice del dispositivo che ti verrà dato")
                        String email)
{


}
