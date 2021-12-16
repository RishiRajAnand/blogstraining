package org.acme;

import java.util.List;

public interface BloggingService {

     List<Blog> getBlogs();

     Blog postBlog(Blog blog);

     Blog getBlogByName(String name);

     String deletelogById(long id);

     List<Blog> blogByAuthorName(String name);

     Blog UpdateBlog(Blog blog);
}
