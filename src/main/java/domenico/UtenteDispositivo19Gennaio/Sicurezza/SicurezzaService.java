package domenico.UtenteDispositivo19Gennaio.Sicurezza;


import domenico.UtenteDispositivo19Gennaio.Dto.UtenteDTO;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteLogin;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.Errore401;
import domenico.UtenteDispositivo19Gennaio.Service.UtenteService;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SicurezzaService {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private ImpostazioniJwTs JwTs;



    public String autentixazioneUtente(UtenteLogin utente){
        Utente utente1=utenteService.verificaEmail(utente.email());
      if (utente.password().equals(utente1.getPassword())){
         return JwTs.tokenCreation(utente1);
      }else {
         throw new Errore401("l'utente non è autorizzato, la preghiamo di autenticarsi");
      }
    }


}
