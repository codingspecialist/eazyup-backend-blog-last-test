package shop.mtcoding.blogv2._core.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.blogv2._core.error.ex.MyApiException;
import shop.mtcoding.blogv2._core.error.ex.MyException;
import shop.mtcoding.blogv2._core.util.ApiUtil;
import shop.mtcoding.blogv2._core.util.Script;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public String error(MyException e) {
        log.error("에러 : "+e.getMessage());
        return Script.back(e.getMessage());
    }


    @ExceptionHandler(MyApiException.class)
    public ApiUtil<String> error(MyApiException e) {
        log.error("에러 : "+e.getMessage());
        return new ApiUtil<String>(false, e.getMessage());
    }
}
