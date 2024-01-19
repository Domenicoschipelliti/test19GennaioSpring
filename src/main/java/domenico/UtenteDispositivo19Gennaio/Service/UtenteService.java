package domenico.UtenteDispositivo19Gennaio.Service;

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

    //POST
    public Utente save(UtenteDTO utenteDTO){

        Utente utenteSalvato=new Utente();

        utenteSalvato.setName(utenteDTO.name());
        utenteSalvato.setSurname(utenteDTO.surname());

        //da annotare di fare il set email che ci servirà mailgun
        //da fare upload immagini per l'utente

       return  utenteDao.save(utenteSalvato);

    }

    //GET
    public Page<Utente> findAll(int size,int page,String order){
        Pageable impaginazione= PageRequest.of(size,page,Sort.by(order))

        return utenteDao.findAll(impaginazione);
    }

    //GET/PUT/PATCH
    public Utente utenteIdTrovato(UUID id){
        return utenteDao.findById(id).orElseThrow(()->new UtenteNonTrovato(id));
    }











}
