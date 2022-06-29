package com.pluralsight.blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pluralsight.blog.model.Post;
import java.util.List;
import com.pluralsight.blog.data.PostRepository;




@Controller
public class BlogController {
	
	private PostRepository postRepository;
	
	public BlogController(PostRepository postRepository) {
		
		this.postRepository = postRepository;
		
	}
	
	
	@RequestMapping("/")
	public String listPosts(ModelMap modelMap) {
		
		List<Post> allPosts = postRepository.getAllPosts();
		
		modelMap.put("posts", allPosts);
		
		return "home";
	}

}

