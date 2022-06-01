package sn.senico.constantes;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Component
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "swagger.ui.oauth")
public class SwaggerUiProperties {

    @NotEmpty
    String clientId;

    @NotEmpty
    String clientSecret;

    @NotEmpty
    List<Realms> realms;

    @Data
    @Validated
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Realms {

        @NotEmpty
        String name;

        @NotEmpty
        String tokenUrl;

    }
}
