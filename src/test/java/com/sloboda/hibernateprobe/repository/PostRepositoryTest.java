package com.sloboda.hibernateprobe.repository;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.Post;
import com.sloboda.hibernateprobe.entity.PostDetails;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.hibernate.graph.GraphSemantic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PostRepositoryTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        super.setUp();
        Post post = new Post(1);
        post.setDetails(new PostDetails("desc"));
        em.persist(post);

        Post post2 = new Post(2);
        post2.setDetails(new PostDetails("desc2"));
        em.persist(post2);

        em.flush();
        em.clear();
        QueryCountHolder.clear();
    }

    @Test
    public void test1() {
        em.createQuery("select p FROM Post p where p.id = 1", Post.class)
                .getResultList();
    }

    @Test
    public void test2() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> entity = cq.from(Post.class);
        TypedQuery<Post> query = em.createQuery(cq);
        EntityGraph<?> entityGraph = em.getEntityGraph("with-children");
        query.setHint(GraphSemantic.LOAD.getJpaHintName(), entityGraph);
        query.getResultList();
    }
}
