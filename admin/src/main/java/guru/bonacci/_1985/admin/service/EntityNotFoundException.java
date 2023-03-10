package guru.bonacci._1985.admin.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  public EntityNotFoundException() {
    super();
  }
  
  public EntityNotFoundException(String message) {
    super(message);
  }
}
