package shop.mtcoding.blogv2.user;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserQueryRepository {

    @Autowired
    private EntityManager em;

    public void save(User user) {
        em.persist(user); // 영속화 (영속성 컨텍스트)
    }

    public User findById(Integer id) {
        Query query = em.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

}
