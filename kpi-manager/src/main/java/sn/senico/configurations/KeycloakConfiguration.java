package sn.senico.configurations;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sn.senico.constantes.KeycloakProperties;
import sn.senico.constantes.UserManagerConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class KeycloakConfiguration {

    @Bean(name="keycloak")
    public Keycloak keycloak(UserManagerConfiguration userManagerConfiguration, KeycloakProperties keycloakProperties) {

        return initKeycloak(userManagerConfiguration, keycloakProperties.getMaster());
    }

    @Bean(name="keycloakAdminRealm")
    public Keycloak keycloakAdminRealm(UserManagerConfiguration userManagerConfiguration, KeycloakProperties keycloakProperties) {

        if (StringUtils.isNotEmpty(keycloakProperties.getAdmin().getUser())) {
            return initKeycloak(userManagerConfiguration, keycloakProperties.getAdmin());
        }
        return null;
    }


    private Keycloak initKeycloak(UserManagerConfiguration userManagerConfiguration, KeycloakProperties.Realm realm) {
        log.info("Load Keycloak behind proxy configuration : http.proxy.enable[{}], http.proxy.host[{}], http.proxy.port[{}], http.poolSize[{}], http.sockettimeout[{}], http.establishConnectionTimeout[{}], http.connectionCheckoutTimeout[{}]",
                userManagerConfiguration.keycloakAdminclientHttpProxyEnable,
                userManagerConfiguration.keycloakAdminclientHttpProxyHost,
                userManagerConfiguration.keycloakAdminclientHttpProxyPort,
                userManagerConfiguration.keycloakAdminclientProxyHttpPoolSize,
                userManagerConfiguration.keycloakAdminclientHttpSocketTimeout,
                userManagerConfiguration.keycloakAdminclientHttpEstablishConnectionTimeout,
                userManagerConfiguration.keycloakAdminclientHttpConnectionCheckoutTimeout);

            ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder()
                .connectionPoolSize(userManagerConfiguration.keycloakAdminclientProxyHttpPoolSize)
                .socketTimeout(userManagerConfiguration.keycloakAdminclientHttpSocketTimeout, TimeUnit.MILLISECONDS)
                .establishConnectionTimeout(userManagerConfiguration.keycloakAdminclientHttpEstablishConnectionTimeout, TimeUnit.MILLISECONDS)
                .connectionCheckoutTimeout(userManagerConfiguration.keycloakAdminclientHttpConnectionCheckoutTimeout, TimeUnit.MILLISECONDS);

            if (userManagerConfiguration.keycloakAdminclientHttpProxyEnable) {
                resteasyClientBuilder.defaultProxy(userManagerConfiguration.keycloakAdminclientHttpProxyHost, userManagerConfiguration.keycloakAdminclientHttpProxyPort);
            }

            return KeycloakBuilder.builder()
                    .serverUrl(userManagerConfiguration.keycloakServerUrl)
                    .realm(realm.getRealm())
                    .clientId(realm.getClientId())
                    .username(realm.getUser())
                    .password(realm.getPassword())
                    .resteasyClient(resteasyClientBuilder.build())
                    .build();
    }

}
