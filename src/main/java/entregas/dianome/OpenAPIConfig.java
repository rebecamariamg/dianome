package entregas.dianome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenAPIConfig {


  @Bean
  public OpenAPI myOpenAPI() {
    Contact contact = new Contact();
    contact.setEmail("rebecamariamg@gmail.com");
    contact.setName("Rebeca Maria");
    contact.setUrl("https://github.com/rebecamariamg");

    License mitLicense = new License().name("MIT License");

    Info info = new Info()
        .title("Serviço de entregas Dianome")
        .version("1.0")
        .contact(contact)
        .description("Esta API expõe os end-points utilizados na aplicação Dianome")
        .license(mitLicense);

    return new OpenAPI().info(info);
  }

}
