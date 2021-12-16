package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BloggingRepository implements PanacheRepository<Blog> {

    @Inject
    EntityManager entityManager;

    List<Blog> getBlogsByAuthorName(String name) {
        List<Blog> blogs = listAll();
        List<Blog> response = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.author.equals(name)) {
                response.add(blog);
            }
        }
        return response;
    }

    String findanddelete(long id) {
        Blog blog = findById(id);
        if (blog.isPersistent()) {
            if (deleteById(id) == true) {
                return "Item is deletefd with id  " + id;
            }
        }
        return "Item is not deletefd with id ";
    }

    @Transactional
    public Blog UpdateBlog(Blog blog) {
        Blog entity = findById(blog.id);
        if (entity == null) {
            throw new NotFoundException();
        }
        if (entity != null) {
            entityManager.merge(blog);
        }
        return blog;
    }
}
