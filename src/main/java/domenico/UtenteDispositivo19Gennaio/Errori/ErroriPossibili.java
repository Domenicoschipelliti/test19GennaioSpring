package domenico.UtenteDispositivo19Gennaio.Errori;

import java.time.LocalDate;
import java.util.List;


public record ErroriPossibili(  String message,
                                LocalDate timestamp,
                                List<String> erroriPost) {
}

