package br.com.mobiauto.error;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class ApiErrorMessage {

    private HttpStatus status;
    private List<String> errors;

    public ApiErrorMessage(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }
}