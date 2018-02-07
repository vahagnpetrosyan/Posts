package posts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import posts.entities.PostEntity;
import posts.entities.PostForm;
import posts.service.PostService;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @RequestMapping(value = "/posts", method = GET)
    public String posts(Model model, @RequestParam(defaultValue = MAX_LONG_AS_STRING) long max,
                                     @RequestParam(defaultValue = "20") int count){

        List<PostEntity> postEntities = postService.findPosts(max, count);
        model.addAttribute("postList", postEntities);
        return "posts";
    }

    @RequestMapping(value = "/{postId}", method = GET)
    public String post(Model model, @PathVariable long postId){
        PostEntity postEntity = postService.findOne(postId);
        model.addAttribute("post", postEntity);
        return "post";
    }

    @RequestMapping(value = "posts", method = POST)
    public String addPost(PostForm postForm){
        postService.save(new PostEntity(null, postForm.getMessage(), new Date()));
        return "redirect:posts";
    }
}
