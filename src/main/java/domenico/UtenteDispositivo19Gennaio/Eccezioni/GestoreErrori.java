package domenico.UtenteDispositivo19Gennaio.Eccezioni;

import domenico.UtenteDispositivo19Gennaio.Errori.ErroriPossibili;
import domenico.UtenteDispositivo19Gennaio.Errori.ErroriPossibili2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;



@RestControllerAdvice
public class GestoreErrori {
  @ExceptionHandler(UtenteNonTrovato.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErroriPossibili2 handleNotFound(UtenteNonTrovato e) {
    return new ErroriPossibili2(e.getMessage(), LocalDate.now());
  }

  @ExceptionHandler(DispositivoNonTrovato.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErroriPossibili2 handleNotFound(DispositivoNonTrovato e) {
    return new ErroriPossibili2(e.getMessage(), LocalDate.now());
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErroriPossibili2 handleGeneric(Exception e) {
    e.printStackTrace();
    return new ErroriPossibili2("Errore generico, risolveremo il prima possibile", LocalDate.now());
  }



}


