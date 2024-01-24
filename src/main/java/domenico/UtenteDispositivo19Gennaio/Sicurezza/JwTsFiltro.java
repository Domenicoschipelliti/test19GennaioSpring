package domenico.UtenteDispositivo19Gennaio.Sicurezza;


import domenico.UtenteDispositivo19Gennaio.Eccezioni.Errore401;
import domenico.UtenteDispositivo19Gennaio.Service.UtenteService;
import domenico.UtenteDispositivo19Gennaio.enteties.Utente;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class JwTsFiltro extends OncePerRequestFilter {
    @Autowired
    private ImpostazioniJwTs JwTs;
    @Autowired
    private UtenteService utenteService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header=request.getHeader("Authorization");

        if (header==null || !header.startsWith("Bearer ")){
          throw  new Errore401("errore ci si aspetta il campo pieno");
        }else {
            String allaccessoToken=header.substring(7);
            JwTs.verificaToken(allaccessoToken);

            String codiceUnivoco = JwTs.extractIdFromToken(header);
            Utente utente = utenteService.utenteIdTrovato(UUID.fromString(codiceUnivoco));

            Authentication autenticazione = new UsernamePasswordAuthenticationToken(utente, null,utente.getAuthorities());
            //getAuthorities serve qui per attivare il processo di autorizzazione
            SecurityContextHolder.getContext().setAuthentication(autenticazione);

            filterChain.doFilter(request, response);

        }




    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathMatcher().match("/sicurezza/**", request.getServletPath());
    }
}
