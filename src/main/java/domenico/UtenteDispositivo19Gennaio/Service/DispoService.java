package domenico.UtenteDispositivo19Gennaio.Service;

import domenico.UtenteDispositivo19Gennaio.Dto.DispositivoDTO;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteDTO;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.DispositivoNonTrovato;
import domenico.UtenteDispositivo19Gennaio.InterfaceDao.DispositivoDao;
import domenico.UtenteDispositivo19Gennaio.enteties.Dispositivo;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DispoService {
    @Autowired
    DispositivoDao dispositivoDao;

    public Dispositivo save(DispositivoDTO dispositivoDTO){

        Dispositivo dispositivoSalvato=new Dispositivo();
        dispositivoSalvato.setNomeDispositivo(dispositivoDTO.nomeDispositivo());
        return  dispositivoDao.save(dispositivoSalvato);
    }

    public Page<Dispositivo> findAll(int size, int page, String order){
        Pageable listaDispositiviInOrdine= PageRequest.of(size,page, Sort.by(order));

        return dispositivoDao.findAll(listaDispositiviInOrdine);
    }


    public Dispositivo ritornaUnicoDispositivo(UUID idDispositivo){
        return dispositivoDao.findById(idDispositivo).orElseThrow(()->new DispositivoNonTrovato(idDispositivo));
    }


    public Dispositivo aggiornamentoDispositivo(UUID idDispositivo,Dispositivo bodyDispositivo){
         Dispositivo aggiornamentoDisp=this.ritornaUnicoDispositivo(idDispositivo);
         aggiornamentoDisp.setNomeDispositivo(bodyDispositivo.nomeDispositivo);
         aggiornamentoDisp.setAssegnato(bodyDispositivo.getAssegnato());
         aggiornamentoDisp.setAssegnato(bodyDispositivo.getAssegnato());
         aggiornamentoDisp.setDismesso(bodyDispositivo.getDismesso());
         aggiornamentoDisp.setDisponibile(bodyDispositivo.getDisponibile());
         return  dispositivoDao.save(aggiornamentoDisp);
    }

    public void cancellazioneDispositivo(UUID idDispositivo){
        Dispositivo cancellazioneDaId=this.ritornaUnicoDispositivo(idDispositivo);
        dispositivoDao.delete(cancellazioneDaId);
    }






}
