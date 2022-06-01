package sn.senico.exceptions;

import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.client.HttpStatusCodeException;

public class ResourceAlreadyExistHttpException extends HttpStatusCodeException {
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistHttpException(HttpStatus statusCode) {
        super(statusCode);
    }

    public ResourceAlreadyExistHttpException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public ResourceAlreadyExistHttpException(HttpStatus statusCode, String statusText,
        @Nullable byte[] responseBody, @Nullable Charset responseCharset) {
        super(statusCode, statusText, responseBody, responseCharset);
    }

    public ResourceAlreadyExistHttpException(HttpStatus statusCode, String statusText,
        @Nullable HttpHeaders responseHeaders, @Nullable byte[] responseBody,
        @Nullable Charset responseCharset) {
        super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
    }

}
