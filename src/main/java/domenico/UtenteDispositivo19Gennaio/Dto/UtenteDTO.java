package domenico.UtenteDispositivo19Gennaio.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UtenteDTO(@NotEmpty(message = "Mettere il nome ci aiuterà ad identificarti")
                        @Size(min = 2,max = 20,message = "la lunghezza del nome va dai 2 a i 20 caratteri di solito")
                        String name,
                        @NotEmpty(message = "il cognome ha la stessa importanza del nome")
                        String surname,
                        @NotEmpty(message = "L'email ci aiuterà a mandarti il codice del dispositivo che ti verrà dato")
                        @Email(message = "l'email non è corretta riprova")String email)
{


}
