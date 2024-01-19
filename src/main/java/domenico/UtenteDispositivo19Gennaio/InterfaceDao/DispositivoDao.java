package domenico.UtenteDispositivo19Gennaio.InterfaceDao;

import domenico.UtenteDispositivo19Gennaio.enteties.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DispositivoDao extends JpaRepository<Dispositivo,UUID> {
}
