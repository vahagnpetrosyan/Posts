package posts.repository;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import posts.entities.PostEntity;
import posts.utils.SessionUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        CriteriaBuilder criteriaBuilder = sessionUtil.getSession().getCriteriaBuilder();
        CriteriaQuery<PostEntity> criteria = criteriaBuilder.createQuery(PostEntity.class);
        Root<PostEntity> root = criteria.from(PostEntity.class);

        criteria.select(root).where(criteriaBuilder.lessThan(root.get("id"), max))
                .orderBy(criteriaBuilder.asc(root.get("time")));

        Query<PostEntity> query = sessionUtil.getSession().createQuery(criteria);
        List<PostEntity> entities = query.setMaxResults(count).getResultList();

        sessionUtil.closeTransaction();
        return  entities;
    }

    @Override
    public PostEntity findOne(long id) {
        sessionUtil.openTransaction();

        String queryStr = "select * from POST"
                        + " where id = :id";

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
