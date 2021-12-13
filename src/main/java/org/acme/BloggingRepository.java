package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import net.bytebuddy.build.AccessControllerPlugin;

@ApplicationScoped
public class BloggingRepository implements PanacheRepository<Blog> {

    List<Blog> getBlogsByAuthorName(String name) {
        List<Blog> blogs = listAll();
        List<Blog> response = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.author.equals(name)) {
                response.add(blog);
            }
        }
        return  response;
    }

}
