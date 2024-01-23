package domenico.UtenteDispositivo19Gennaio.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UtenteLogin(@Email(message = "accertati che la mail sia giusta")String email, @NotEmpty(message = "assicurati che la passrword sia messa")String password) {
}
