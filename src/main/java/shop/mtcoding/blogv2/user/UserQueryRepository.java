package shop.mtcoding.blogv2.user;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserQueryRepository {

    @Autowired
    private EntityManager em;

}
