package sn.senico.constantes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * filter values management class
 *
 * @author A513197
 */
@Component
public class UserManagerConfiguration {

    /* Keycloak Admin Client */
    public @Value("${keycloakadminclient.server-url}") String keycloakServerUrl;
    public @Value("${keycloakadminclient.http.proxy.enable:false}") boolean keycloakAdminclientHttpProxyEnable;
    public @Value("${keycloakadminclient.http.proxy.host:proxy}") String keycloakAdminclientHttpProxyHost;
    public @Value("${keycloakadminclient.http.proxy.port:3128}") Integer keycloakAdminclientHttpProxyPort;
    public @Value("${keycloakadminclient.http.poolsize:5}") Integer keycloakAdminclientProxyHttpPoolSize;
    public @Value("${keycloakadminclient.http.sockettimeout:-1}") long keycloakAdminclientHttpSocketTimeout;
    public @Value("${keycloakadminclient.http.establishConnectionTimeout:-1}") long keycloakAdminclientHttpEstablishConnectionTimeout;
    public @Value("${keycloakadminclient.http.connectionCheckoutTimeout:-1}") long keycloakAdminclientHttpConnectionCheckoutTimeout;

    /* Account */
    public @Value("${account.creation.emailActionsList}") String emailActionsListString;
    public @Value("${account.creation.sendemail}") Boolean isEmailActionsActive;

    /* Keycloak Users */
    public @Value("${keycloak.users.active}") Boolean isKeycloakUsersActive;
}
