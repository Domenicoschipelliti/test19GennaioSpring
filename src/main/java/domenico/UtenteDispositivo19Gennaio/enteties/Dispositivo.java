package domenico.UtenteDispositivo19Gennaio.enteties;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Dispositivo {
    @Id
    @GeneratedValue
    private UUID idDispositivo;
    public String nomeDispositivo;
    private String disponibile="";
    private String dismesso="";
    private  String manutenzione="";
    private String assegnato="";
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

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }
}
