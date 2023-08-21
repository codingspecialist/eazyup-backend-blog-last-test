package shop.mtcoding.blogv2.board;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
 * save(), findById(), findAll(), count(), deleteById()
 */
// 스프링이 실행될 때, BoardRepository의 구현체가 IoC 컨테이너에 생성된다
public interface BoardRepository extends JpaRepository<Board, Integer> {

    // select id, title, content, user_id, created_at from board_tb b inner join
    // user_tb u on b.user_id = u.id;
    // fetch를 붙여야 *를 한다.
    @Query("select b from Board b join fetch b.user")
    List<Board> mFindAll();

    @Query("select b from Board b join fetch b.user where b.id = :id")
    Board mFindById(@Param("id") Integer id);

    @Query("select b from Board b left join fetch b.replies r left join fetch r.user ru where b.id = :id")
    Optional<Board> mFindByIdJoinRepliesInUser(@Param("id") Integer id);
}
