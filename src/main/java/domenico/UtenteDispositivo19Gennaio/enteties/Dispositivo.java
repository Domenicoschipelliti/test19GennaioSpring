package domenico.UtenteDispositivo19Gennaio.enteties;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Dispositivo {
    @Id
    @GeneratedValue
    private UUID dispositivoId;

    private String disponibile="disponibile";
    private String dismesso="dismesso";
    private  String manutenzione="manutenzione";
    private String assegnato="assegnato";
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Dispositivo(String disponibile, String dismesso, String manutenzione, String assegnato) {
        this.disponibile = disponibile;
        this.dismesso = dismesso;
        this.manutenzione = manutenzione;
        this.assegnato = assegnato;
    }

    public Dispositivo(){

    }

    public void setDisponibile(String disponibile) {
        this.disponibile = disponibile;
    }

    public void setDismesso(String dismesso) {
        this.dismesso = dismesso;
    }

    public void setManutenzione(String manutenzione) {
        this.manutenzione = manutenzione;
    }

    public void setAssegnato(String assegnato) {
        this.assegnato = assegnato;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
