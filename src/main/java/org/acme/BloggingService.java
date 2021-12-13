package org.acme;

import java.util.List;

public interface BloggingService {

     List<Blog> getBlogs();

     Blog postBlog(String name, String auhor);

     Blog getBlogByName(String name);

     Blog updateBlogByName(String name, String author);

     List<Blog> blogByAuthorName(String name);
}
