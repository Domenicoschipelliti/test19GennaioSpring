package domenico.UtenteDispositivo19Gennaio.controllers;

import domenico.UtenteDispositivo19Gennaio.Dto.NuovoUtenteRisposta;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteDTO;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.BadRequest;
import domenico.UtenteDispositivo19Gennaio.Service.UtenteService;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    UtenteService utenteService;
    //GET
    @GetMapping
    @PreAuthorize("hasAuthority(ADMIN)")
    public Page<Utente> getUtenti(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "20")int size,@RequestParam(defaultValue = "userId")String order){
       return utenteService.findAll(page,size,order);
    }

    //GET(ID)
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority(ADMIN)")
    @ResponseStatus(HttpStatus.OK)
    public Utente utenteId(@PathVariable UUID id){
        return utenteService.utenteIdTrovato(id);
     }




    //PUT(ID+BODY)
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority(ADMIN)")
    public Utente utentePut(@PathVariable UUID id,@RequestBody Utente utenteBody ){
        return utenteService.utenteAggiornato(id,utenteBody);
    }


    //DELETE(ID)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority(ADMIN)")
    public void utenteDelete(@PathVariable UUID id){
        utenteService.utenteCancellato(id);
    }

    //------------------------Punti dedicati al profilo personale--------------------------------------\\

    @GetMapping("/me")
    public Utente profiloUtente(@AuthenticationPrincipal Utente utenteAttuale){
      return utenteAttuale;
    }


    @PutMapping("/me")
    public Utente aggiornaProfiloUtente(@AuthenticationPrincipal Utente utenteAttuale,@RequestBody Utente utenteBody){
        return utenteService.utenteAggiornato(utenteAttuale.getUserId(),utenteBody);
    }


    @DeleteMapping("/me")
    public void  cancellaUtente(Utente utenteAttuale){
      utenteService.utenteCancellato(utenteAttuale.getUserId());
    }


}
