package hi.xmr.springboot.except;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hi.xmr.springboot.model.HiHttpResult;

@RestControllerAdvice
public class HiExceptionHandler {
	@ExceptionHandler(Exception.class)
	public HiHttpResult handleDuplicateKeyException(Exception e){
		return HiHttpResult.onException(e);
	}
}
