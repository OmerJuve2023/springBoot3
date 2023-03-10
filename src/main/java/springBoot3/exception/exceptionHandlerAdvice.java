package springBoot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.net.URISyntaxException;

@RestControllerAdvice
public class exceptionHandlerAdvice {
    @ExceptionHandler(PostNotFound.class)
    public ProblemDetail handlerCustomerFoundException(PostNotFound e) throws URISyntaxException {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setProperty("postId", e.getId());
        problemDetail.setType(new URI("http://localhost:3000/problems/post-not-found"));
        return problemDetail;
    }
}
