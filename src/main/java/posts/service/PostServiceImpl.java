package posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posts.entities.PostEntity;
import posts.repository.PostRepository;
import posts.utils.SessionUtil;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostEntity> findRecentPosts() {
        return postRepository.findRecentPosts();
    }

    @Override
    public List<PostEntity> findPosts(long max, int count) {
        return postRepository.findPosts(max, count);
    }

    @Override
    public PostEntity findOne(long id) {
        return postRepository.findOne(id);
    }

    @Override
    public PostEntity save(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }
}
