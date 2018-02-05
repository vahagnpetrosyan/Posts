package posts.service;

import posts.entities.PostEntity;

import java.util.List;

public interface PostService {

    List<PostEntity> findRecentPosts();

    List<PostEntity> findPosts(long max, int count);

    PostEntity findOne(long id);

    PostEntity save(PostEntity postEntity);
}
