package posts.repository;

import posts.entities.PostEntity;

import java.util.List;

public interface PostRepository {

    List<PostEntity> findRecentPosts();

    List findPosts(long max, int count);

    PostEntity findOne(long id);

    PostEntity save(PostEntity postEntity);
}
