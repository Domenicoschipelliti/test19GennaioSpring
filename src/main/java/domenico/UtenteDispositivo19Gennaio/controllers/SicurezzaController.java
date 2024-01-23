package domenico.UtenteDispositivo19Gennaio.controllers;

import domenico.UtenteDispositivo19Gennaio.Dto.*;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.BadRequest;
import domenico.UtenteDispositivo19Gennaio.Service.UtenteService;
import domenico.UtenteDispositivo19Gennaio.Sicurezza.SicurezzaService;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public NuovoUtenteRisposta postUtente(@RequestBody @Validated NuovoUtenteDto utenteBody, BindingResult validazione){
        if (validazione.hasErrors()){
            throw new BadRequest(validazione.getAllErrors());
        }
        Utente ute=utenteService.save(utenteBody);
        return new NuovoUtenteRisposta(ute.getUserId());
    }
}
