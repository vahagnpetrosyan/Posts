package posts.repository;

import posts.entities.UserEntity;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    UserEntity findByUserName(String username);
}
