package hi.xmr.springboot.except;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hi.xmr.springboot.model.HttpResult;

@RestControllerAdvice
public class HiExceptionHandler {
	@ExceptionHandler(Exception.class)
	public HttpResult handleDuplicateKeyException(Exception e){
		return HttpResult.onException(e);
	}
}
