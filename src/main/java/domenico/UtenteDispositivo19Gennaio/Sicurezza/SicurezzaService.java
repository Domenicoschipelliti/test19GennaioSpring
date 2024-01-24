package domenico.UtenteDispositivo19Gennaio.Sicurezza;


import domenico.UtenteDispositivo19Gennaio.Dto.NuovoUtenteDto;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteDTO;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteLogin;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.BadRequest;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.Errore401;
import domenico.UtenteDispositivo19Gennaio.Enum.Ruoli;
import domenico.UtenteDispositivo19Gennaio.InterfaceDao.UtenteDao;
import domenico.UtenteDispositivo19Gennaio.Service.UtenteService;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SicurezzaService {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private ImpostazioniJwTs JwTs;

    @Autowired
    private UtenteDao utenteDao;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public String autenticazioneUtente(UtenteLogin utente){
        Utente utente1=utenteService.cercaEmail(utente.email());
      if (passwordEncoder.matches(utente1.getPassword(),utente.password())){
         return JwTs.tokenCreation(utente1);
      }else {
         throw new Errore401("l'utente non è autorizzato, la preghiamo di autenticarsi");
      }
    }

    //POST
    public Utente save(NuovoUtenteDto utenteDTO){

        utenteDao.findByEmail(utenteDTO.email()).ifPresent(utente->{
            throw new BadRequest("l'email " +utente.getEmail()+" è già in uso");
        });

        Utente utenteSalvato=new Utente();

        utenteSalvato.setName(utenteDTO.name());
        utenteSalvato.setSurname(utenteDTO.surname());
        utenteSalvato.setEmail(utenteDTO.email());
        utenteSalvato.setPassword(passwordEncoder.encode(utenteDTO.password()));
        utenteSalvato.setRuoli(Ruoli.UTENTE);

        //da annotare di fare il set email che ci servirà mailgun
        //da fare upload immagini per l'utente

        return  utenteDao.save(utenteSalvato);

    }


}
