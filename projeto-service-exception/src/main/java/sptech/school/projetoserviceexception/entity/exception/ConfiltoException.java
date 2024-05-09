package sptech.school.projetoserviceexception.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConfiltoException extends RuntimeException{

    public ConfiltoException(String entidade) {
        super(String.format("%s com confilto!", entidade));
    }
}
