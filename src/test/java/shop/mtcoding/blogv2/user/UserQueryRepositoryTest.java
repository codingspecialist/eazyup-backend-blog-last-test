package shop.mtcoding.blogv2.user;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserQueryRepository.class)
@DataJpaTest // JpaRepository만 IoC 메모리에 올려준다.
public class UserQueryRepositoryTest {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Autowired
    private EntityManager em;

    // persist (영속화)
    @Test
    public void save_test() {
        User user = User.builder()
                .username("love")
                .password("1234")
                .email("love@nate.com")
                .build();
        userQueryRepository.save(user); // 영속화
        // em.flush();
    }

    // 1차 캐시
    @Test
    public void findById_test() {
        System.out.println("1. pc는 비어있다");
        userQueryRepository.findById(1);
        System.out.println("2. pc의 user 1은 영속화 되어 있다");
        userQueryRepository.findById(1);
        System.out.println("???????????????????");
    }
}
