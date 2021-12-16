package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/blogs")
public class GreetingResource {

    @Inject
    BloggingService bloggingService;

    @GET
    @Path("/blog")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Blog> helloWithquery() {
      return bloggingService.getBlogs();
    }

    @GET
    @Path("/blogByAuthorName")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Blog> blogByAuthorName(@QueryParam("name") String name) {
        return bloggingService.blogByAuthorName(name);
    }

    @POST
    @Path("/blog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Blog postvblog(Blog blog) {
        return bloggingService.postBlog(blog);
    }

    @PUT
    @Path("/blog")
    @Produces(MediaType.APPLICATION_JSON)
    public Blog updatevblog(Blog blog) {
        return bloggingService.UpdateBlog(blog);
    }

    @DELETE
    @Path("/blog/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteblog(@PathParam("id") long id) {
        return bloggingService.deletelogById(id);
    }

    @GET
    @Path("/blog/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Blog getBlogByName(@PathParam("name") String name) {
        return bloggingService.getBlogByName(name);
    }

}

