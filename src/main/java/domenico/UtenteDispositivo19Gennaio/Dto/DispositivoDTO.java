package domenico.UtenteDispositivo19Gennaio.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DispositivoDTO(@NotEmpty(message = "il nome del dispositivo è importante")@NotNull(message = "assicurati che il dato emesso sia una stringa") String nomeDispositivo, @NotEmpty(message = "bisogna dire la disponobilità del dispositivo per darlo all'utente mettendo alla sezione dedicata si o no")@NotNull(message = "assicurati che il dato emesso sia una stringa") String disponibile, @NotEmpty(message = "bisogna dire la disponobilità del dispositivo per darlo all'utente mettendo alla sezione dedicata si o no")@NotNull(message = "assicurati che il dato emesso sia una stringa") String assegnato, @NotEmpty(message = "bisogna dire la disponobilità del dispositivo per darlo all'utente mettendo alla sezione dedicata si o no") @NotNull(message = "assicurati che il dato emesso sia una stringa")String manutenzione, @NotEmpty(message = "bisogna dire la disponobilità del dispositivo per darlo all'utente mettendo alla sezione dedicata si o no")@NotNull(message = "assicurati che il dato emesso sia una stringa") String dismesso, @NotEmpty(message = "serve il codice identificativo dell'utente") UUID idDispositivo) {


}
