package domenico.UtenteDispositivo19Gennaio.Service;

import domenico.UtenteDispositivo19Gennaio.Dto.NuovoUtenteDto;
import domenico.UtenteDispositivo19Gennaio.Dto.UtenteDTO;
import domenico.UtenteDispositivo19Gennaio.Eccezioni.UtenteNonTrovato;
import domenico.UtenteDispositivo19Gennaio.InterfaceDao.UtenteDao;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    UtenteDao utenteDao;




    //GET
    public Page<Utente> findAll(int size,int page,String order){
        Pageable impaginazione= PageRequest.of(size,page,Sort.by(order));

        return utenteDao.findAll(impaginazione);
    }

    //GET/PUT/PATCH
    public Utente utenteIdTrovato(UUID utenteId){
        return utenteDao.findById(utenteId).orElseThrow(()->new UtenteNonTrovato(utenteId));
    }

    //PUT
    public Utente utenteAggiornato(UUID utenteId,Utente utenteSet){
        Utente aggiornamento=this.utenteIdTrovato(utenteId);
        aggiornamento.setName(utenteSet.getName());
        aggiornamento.setSurname(utenteSet.getSurname());
        aggiornamento.setEmail(utenteSet.getEmail());
        return utenteDao.save(aggiornamento);
    }


    //DELETE
    public void  utenteCancellato(UUID utenteId){
       Utente cancellazione=this.utenteIdTrovato(utenteId);
       utenteDao.delete(cancellazione);
    }


    public Utente verificaEmail(String email) throws UtenteNonTrovato {
        return utenteDao.verificaEmail(email).orElseThrow(() -> new UtenteNonTrovato("Utente con email " + email + " non trovata!"));
    }













}
