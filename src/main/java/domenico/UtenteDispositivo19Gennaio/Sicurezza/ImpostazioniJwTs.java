package domenico.UtenteDispositivo19Gennaio.Sicurezza;

import domenico.UtenteDispositivo19Gennaio.Eccezioni.Errore401;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ImpostazioniJwTs {
    @Value("${spring_JwT_key}")
    private String codiceSegreto;

   public String tokenCreation(Utente codiceUtente){
     return Jwts.builder()//costruzione token,
             .subject(String.valueOf(codiceUtente.getUserId()))//sogetto da cercare è ID utente,
             .issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis()+1000*60*60*24*14))//data scadenza del token,
             .signWith(Keys.hmacShaKeyFor(codiceSegreto.getBytes())).compact();//immissione del codice segreto e fine.
   }

   public void verificaToken(String token){
       try {
           Jwts.parser().verifyWith(Keys.hmacShaKeyFor(codiceSegreto.getBytes())).build().parse(token);
       } catch (Exception ex) {
           throw new Errore401("Il token sembra non sia valido riprova a loggarti");
       }
   }

    public String extractIdFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(codiceSegreto.getBytes()))
                .build()
                .parseSignedClaims(token).getPayload().getSubject();
    }

}
