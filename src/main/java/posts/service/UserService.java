package posts.service;

import posts.entities.UserEntity;

public interface UserService {
    UserEntity save(UserEntity userEntity);

    UserEntity getByUsername(String username);
}
