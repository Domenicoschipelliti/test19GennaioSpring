package domenico.UtenteDispositivo19Gennaio.InterfaceDao;

import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteDao extends JpaRepository<Utente,UUID> {
    Optional<Utente> verificaEmail(String email);
}
