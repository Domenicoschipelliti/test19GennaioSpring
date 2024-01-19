package domenico.UtenteDispositivo19Gennaio.Eccezioni;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;
@Getter
public class BadRequest extends RuntimeException {
    private List<ObjectError> erroriPost;

    public BadRequest(String message) {
        super(message);
    }

    public BadRequest(List<ObjectError> erroriPost) {
        super("Errori nel body");
        this.erroriPost = erroriPost;
    }
}
