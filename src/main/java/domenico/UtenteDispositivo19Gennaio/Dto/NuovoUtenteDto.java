package domenico.UtenteDispositivo19Gennaio.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NuovoUtenteDto(@NotEmpty(message = "il campo nome deve essere compilato")@Size(min = 3,max = 30,message = "il nome deve avere un minimo di 3 un massimo di 30 caratteri") String name, @NotEmpty(message = "il cognome è utile per capire chi sei")@Size(min = 2,message = "il cognome almeno di 2 caratteri") String surname, @NotEmpty(message = "l'email è obbligatoria per poterti far entrare nel nostro sito")@Email(message = "mi raccomando l'ndirizzo mail deve essere valido") String email, @NotEmpty(message = "la password è fondamentale metti questo campo")@Size(min = 4,message = "di solito una password ha un minimo di 4 caratteri")String password)
{
}
