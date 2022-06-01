package sn.senico.exceptions;

import javax.ws.rs.core.Response.StatusType;

import sn.senico.user.model.Stop;

public class KeycloakCreateUserException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public KeycloakCreateUserException(String realm, Stop stop, StatusType status) {
        super("An error occured when trying to process user [" + stop + "] for realm [" + realm + "], error : " + status);
    }

}
