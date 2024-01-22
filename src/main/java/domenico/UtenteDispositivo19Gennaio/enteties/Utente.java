package domenico.UtenteDispositivo19Gennaio.enteties;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class Utente {
   @Id
   @GeneratedValue
   private UUID userId;

    private String username;

    private String name;

    private String surname;

    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Dispositivo> dispositivo;

    public Utente(String username, String name, String surname, String email) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Utente(){

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDispositivo(List<Dispositivo> dispositivo) {
        this.dispositivo = dispositivo;
    }


}
