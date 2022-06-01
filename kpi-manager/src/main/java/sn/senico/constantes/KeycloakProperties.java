package sn.senico.constantes;

import javax.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * filter values management class
 *
 * @author A513197
 */
@Data
@Component
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "keycloakadminclient")
public class KeycloakProperties {

    @Valid
    final Realm master = new Realm();
    @Valid
    final Realm admin = new Realm();

    @Data
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class Realm {

        String realm;
        String clientId;
        String user;
        String password;

    }

}
