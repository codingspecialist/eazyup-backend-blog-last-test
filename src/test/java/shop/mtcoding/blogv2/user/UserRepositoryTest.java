package shop.mtcoding.blogv2.user;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void update_test() {
        User user = userRepository.findById(1).get();
        // User user = User.builder().id(1).password("5678").build();
        user.setPassword("5678");
        // userRepository.save(user);
        em.flush();
    } // rollback

    @Test
    public void save_test() {
        User user = User.builder()
                .username("love")
                .password("1234")
                .email("love@nate.com")
                .build();
        userRepository.save(user);
    } // rollback

    @Test
    public void mSave_test() {
        userRepository.mSave("love", "1234", "love@nate.com");
    } // rollback

    @Test
    public void findByUsername_test() {
        User user = userRepository.findByUsername("hello");
        System.out.println("테스트 : " + user.getEmail());
    } // rollback

    @Test
    public void findById_test() {
        Optional<User> userOP = userRepository.findById(3);

        if (userOP.isPresent()) {
            User user = userOP.get();
            System.out.println(user.getEmail());
        } else {
            System.out.println("해당 id를 찾을 수 없습니다");
        }
    }

    @Test
    public void mFindById_test() {
        User user = userRepository.mFindById(3);
        if (user == null) {
            System.out.println("해당 id를 찾을 수 없습니다");
        } else {
            System.out.println(user.getEmail());
        }

    }

    @Test
    public void optional_test() {
        User user = User.builder().id(1).username("ssar").build();

        Optional<User> userOP = Optional.of(user);

        if (userOP.isPresent()) {
            User u = userOP.get();
            System.out.println("user가 null이 아닙니다");
        } else {
            System.out.println("user가 null이에요");
        }
    }

}
