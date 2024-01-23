package domenico.UtenteDispositivo19Gennaio.controllers;

import domenico.UtenteDispositivo19Gennaio.Dto.NuovoUtenteRisposta;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteDTO;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteLogin;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteLoginRisposta;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.BadRequest;
import domenico.UtenteDispositivo19Gennaio.Service.UtenteService;
import domenico.UtenteDispositivo19Gennaio.Sicurezza.SicurezzaService;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sicurezza")
public class SicurezzaController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private SicurezzaService sicurezzaService;

    @PostMapping("/login")
    public UtenteLoginRisposta login(@RequestBody UtenteLogin utenteLogin){
       String tokenAccesso=sicurezzaService.autentixazioneUtente(utenteLogin);
       return new UtenteLoginRisposta(tokenAccesso);
    }


    @PostMapping("/register")
    public NuovoUtenteRisposta postUtente(@RequestBody @Validated UtenteDTO utenteBody, BindingResult validazione){
        if (validazione.hasErrors()){
            throw new BadRequest(validazione.getAllErrors());
        }
        Utente ute=utenteService.save(utenteBody);
        return new NuovoUtenteRisposta(ute.getUserId());
    }
}
