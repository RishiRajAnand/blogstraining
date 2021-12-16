package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@ApplicationScoped
public class BloggingServiceImpl implements BloggingService {

    @Inject
    BloggingRepository bloggingRepository;

    public BloggingServiceImpl() { }

    @Transactional
    public List<Blog> getBlogs() {
        return Blog.listAll();
    }

    @Transactional
    public Blog postBlog(Blog blog) {
        blog.persist();
        return blog;
    }

    public Blog getBlogByName(String name) {

        List<Blog> blogs = Blog.listAll();
        for (Blog blog : blogs) {
            if (blog.name.equals(name)) {
                return blog;
            }

        }
        return  null;
    }

    @Transactional
    public String deletelogById(long id) {
         return  bloggingRepository.findanddelete(id);
    }

    public List<Blog> blogByAuthorName(String name) {

        return bloggingRepository.getBlogsByAuthorName(name);
    }

    public Blog UpdateBlog(Blog blog) {
        return bloggingRepository.UpdateBlog(blog);
    }
}
