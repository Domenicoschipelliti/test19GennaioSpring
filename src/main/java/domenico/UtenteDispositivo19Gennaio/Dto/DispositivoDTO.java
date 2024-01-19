package domenico.UtenteDispositivo19Gennaio.Dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record DispositivoDTO(@NotEmpty(message = "serve il codice identificativo dell'utente") UUID utente_id) {


}
