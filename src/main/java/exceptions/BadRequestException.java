package exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
    private List<ObjectError> errorList;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(List<ObjectError> errorList) {
        super("Validation Error");
        this.errorList = errorList;
    }

    public Arrays getErrorList() {

        return null;
    }}
