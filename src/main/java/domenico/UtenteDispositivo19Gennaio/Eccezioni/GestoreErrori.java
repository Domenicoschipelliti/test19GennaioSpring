package domenico.UtenteDispositivo19Gennaio.Eccezioni;


import domenico.UtenteDispositivo19Gennaio.Errori.ErroriPossibili;
import domenico.UtenteDispositivo19Gennaio.Errori.ErroriPossibili2;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestControllerAdvice
public class GestoreErrori {

  @ExceptionHandler(BadRequest.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErroriPossibili erroriPossibili(BadRequest e) {
    List<String> messagiErronei = new ArrayList<>();
    if (e.getErroriPost() != null)
      messagiErronei = e.getErroriPost().stream().map(err -> err.getDefaultMessage()).toList();
    return new ErroriPossibili(e.getMessage(), LocalDate.now(), messagiErronei);
  }
  @ExceptionHandler(UtenteNonTrovato.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErroriPossibili2 erroriPossibili2Utente(UtenteNonTrovato e) {
    return new ErroriPossibili2(e.getMessage(), LocalDate.now());
  }

  @ExceptionHandler(DispositivoNonTrovato.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErroriPossibili2 erroriPossibili2Dispositivo(DispositivoNonTrovato e) {
    return new ErroriPossibili2(e.getMessage(), LocalDate.now());
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErroriPossibili2 erroriPossibili2ServerProblem(Exception e) {
    e.printStackTrace();
    return new ErroriPossibili2("Errore generico, risolveremo il prima possibile", LocalDate.now());
  }



}


