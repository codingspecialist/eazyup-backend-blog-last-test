package shop.mtcoding.blogv2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
    
    @GetMapping("/test/log")
    public String log(){
        log.debug("나 실행됨?");
        return "log ok";
    }
}
