package posts.repository;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import posts.entities.UserEntity;
import posts.utils.SessionUtil;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public UserEntity save(UserEntity userEntity) {
        sessionUtil.openTransaction();
        sessionUtil.getSession().save(userEntity);
        sessionUtil.closeTransaction();
        return userEntity;
    }

    @Override
    public UserEntity findByUserName(String username) {
        sessionUtil.openTransaction();

        String querystr = "select * from USER where USER_NAME = :username";
        Query query = sessionUtil
                .getSession().createNativeQuery(querystr).addEntity(UserEntity.class);
        query.setParameter("username", username);

        UserEntity userEntity = (UserEntity) query.getSingleResult();
        return userEntity;
    }
}
