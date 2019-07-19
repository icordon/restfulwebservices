package org.anticentro.spring.restfulwebservices.users;

import org.anticentro.spring.restfulwebservices.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService postService;

    @Autowired
    private UserDaoService userService;

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPosts(@PathVariable int id){
        User user = userService.findByOne( id );
        if(user == null) throw new NotFoundException( "id - " + id );
        return postService.findAllPostByUser( id );

    }

    @GetMapping("/users/{id}/posts/{id_post}")
    public Post retrievePost(@PathVariable int id, @PathVariable int id_post){
        Post post = postService.findAPost( id, id_post );
        if(post == null){
            throw new NotFoundException("id_post - " + id_post);
        }
        return post;
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable int id) {
        Post savedPost = postService.savePost( post, id );

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( savedPost.getId() )
                .toUri();

        return ResponseEntity.created( location ).build();
    }
}
