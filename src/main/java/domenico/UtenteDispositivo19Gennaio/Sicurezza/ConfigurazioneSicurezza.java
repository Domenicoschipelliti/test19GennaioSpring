package domenico.UtenteDispositivo19Gennaio.Sicurezza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurazioneSicurezza {
    @Bean
    SecurityFilterChain filtroDiSucurezza(HttpSecurity cambioDiSicurezza) throws Exception {

        cambioDiSicurezza.formLogin(AbstractHttpConfigurer::disable);

        return cambioDiSicurezza.build();

    }
}
