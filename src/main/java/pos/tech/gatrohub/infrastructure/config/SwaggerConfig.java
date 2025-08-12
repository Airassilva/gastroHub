package pos.tech.gatrohub.infrastructure.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de controle de usuários - GastroHub")
                        .description("Documentação da API usando SpringDoc e Swagger UI")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação completa no GitHub")
                        .url("https://github.com/Airassilva/gastroHub"));
    }
}

