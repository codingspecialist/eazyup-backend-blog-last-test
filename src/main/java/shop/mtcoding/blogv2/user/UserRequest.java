package shop.mtcoding.blogv2.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

// 수요일 세환이 DTO 발표
public class UserRequest {

    @Getter
    @Setter
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
        private MultipartFile pic;
    }

    @Getter
    @Setter
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    public static class UpdateDTO {
        private String password;
        private MultipartFile pic;
    }
}
