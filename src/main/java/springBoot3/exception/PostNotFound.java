package springBoot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFound extends RuntimeException {
    private final Integer id;

    public PostNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
