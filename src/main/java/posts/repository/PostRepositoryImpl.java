package posts.repository;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import posts.entities.PostEntity;
import posts.utils.SessionUtil;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository{

    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public List<PostEntity> findRecentPosts() {
        sessionUtil.openTransaction();

        String queryStr = "select * from POST"
                        + "order by desc id limit 20";

        Query query = sessionUtil.getSession().createNativeQuery(queryStr)
                                                .addEntity(PostEntity.class);
        List<PostEntity> postEntities = (List<PostEntity>) query.list();

        sessionUtil.closeTransaction();
        return postEntities;
    }

    @Override
    public List<PostEntity> findPosts(long max, int count) {
        sessionUtil.openTransaction();

        String queryStr = "select * from POST"
                        + "where id < :max"
                        + "order by desc limit :count";

        Query query = sessionUtil.getSession().createNativeQuery(queryStr)
                                                .addEntity(PostEntity.class);

        query.setParameter("max", max);
        query.setParameter("count", count);

        List<PostEntity> postEntities = (List<PostEntity>) query.list();

        sessionUtil.closeTransaction();
        return postEntities;
    }

    @Override
    public PostEntity findOne(long id) {
        sessionUtil.openTransaction();

        String queryStr = "select * from POST"
                        + "where id = :id";

        Query query = sessionUtil.getSession().createNativeQuery(queryStr)
                                                .addEntity(PostEntity.class);
        query.setParameter("id", id);
        PostEntity postEntity = (PostEntity) query.getSingleResult();

        sessionUtil.closeTransaction();
        return  postEntity;
    }

    @Override
    public PostEntity save(PostEntity postEntity) {
        sessionUtil.openTransaction();

        sessionUtil.getSession().save(postEntity);

        sessionUtil.closeTransaction();
        return postEntity;
    }
}
