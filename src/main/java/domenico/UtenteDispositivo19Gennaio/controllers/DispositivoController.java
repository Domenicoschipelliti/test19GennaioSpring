package domenico.UtenteDispositivo19Gennaio.controllers;

import domenico.UtenteDispositivo19Gennaio.Dto.DispositivoDTO;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.BadRequest;
import domenico.UtenteDispositivo19Gennaio.Service.DispoService;
import domenico.UtenteDispositivo19Gennaio.enteties.Dispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {
    @Autowired
    DispoService dispoService;

    //GET
    @GetMapping
    public Page<Dispositivo> dispositivoPage(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "40")int size,@RequestParam(defaultValue = "idDispositivo")String order){
        return dispoService.findAll(size,page,order);
    }

    //GET(id)
    @GetMapping("/{idDispositivo}")
    @ResponseStatus(HttpStatus.OK)
    public Dispositivo unicoDispositvo(@PathVariable UUID idDispositivo ){
        return dispoService.ritornaUnicoDispositivo(idDispositivo);
    }

    //POST(body)
    @PostMapping
    public Dispositivo postDispositivo(@RequestBody @Validated DispositivoDTO dispobody, BindingResult validazione){
        if (validazione.hasErrors()){
          throw new BadRequest(validazione.getAllErrors());
        }
        return dispoService.save(dispobody);
    }

    //PUT(body+id)
    @PutMapping("/{idDispositivo}")
    public Dispositivo aggiornamentoDispositivo(@PathVariable UUID idDispositivo,@RequestBody Dispositivo dispoBody){
        return dispoService.aggiornamentoDispositivo(idDispositivo,dispoBody);
    }

    //DELETE(id)
    @DeleteMapping("/{idDispositivo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  cancellaDispositivo(@PathVariable UUID idDispositivo){
      dispoService.cancellazioneDispositivo(idDispositivo);
    }






}
