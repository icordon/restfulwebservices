package org.anticentro.spring.restfulwebservices.users;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>();
    private static int postCounter = 0;

    static {
        posts.add( new Post( ++postCounter, 1, new Date(), "my fist message" ) );
        posts.add( new Post( ++postCounter, 1, new Date(), "my second message" ) );
        posts.add( new Post( ++postCounter, 1, new Date(), "my third message" ) );
    }

    public List<Post> findAllPostByUser(int idUser){
        List<Post> postByUser = new ArrayList<>();
        for(Post post:posts) {
            if(post.getIdUser() == idUser) {
                postByUser.add( post );
            }
        }
        return postByUser;
    }

    public Post findAPost(@PathVariable int id, @PathVariable int id_post){
        for(Post post:posts){
            if(post.getIdUser() == id && post.getId() == id_post) {
                return post;
            }
        }
        return null;
    }

    public Post savePost(Post post, int id){
        post.setIdUser( id );
        post.setId( ++postCounter );
        posts.add( post );
        return post;
    }


}
