package domenico.UtenteDispositivo19Gennaio.enteties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import domenico.UtenteDispositivo19Gennaio.Enum.Ruoli;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@JsonIgnoreProperties({"password", "authorities", "accountNonExpired", "enabled", "accountNonLocked", "credentialsNonExpired", "username"})
public class Utente implements UserDetails {
   @Id
   @GeneratedValue
   private UUID userId;

    private String username;

    private String name;

    private String surname;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Ruoli ruoli;

    @OneToMany(mappedBy = "utente")
    private List<Dispositivo> dispositivo;

    public Utente(String username, String name, String surname, String email,String password,Ruoli ruoli) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password=password;
        this.ruoli=ruoli;
    }

    public Utente(){

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRuoli(Ruoli ruoli) {
        this.ruoli = ruoli;
    }

    public void setDispositivo(List<Dispositivo> dispositivo) {
        this.dispositivo = dispositivo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of( new SimpleGrantedAuthority(this.ruoli.name())); //si occupa di recuperare tutti i ruoli disponibili nell'enum
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
