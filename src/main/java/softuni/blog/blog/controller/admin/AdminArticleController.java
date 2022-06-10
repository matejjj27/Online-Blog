package softuni.blog.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.blog.blog.bindingModel.ArticleBindingModel;
import softuni.blog.blog.entity.Article;
import softuni.blog.blog.entity.Category;
import softuni.blog.blog.entity.Tag;
import softuni.blog.blog.repository.ArticleRepository;
import softuni.blog.blog.repository.CategoryRepository;
import softuni.blog.blog.repository.TagRepository;
import softuni.blog.blog.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/articles")
public class AdminArticleController {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String listArticles(Model model){

        List<Article> articles = this.articleRepository.findAll();

        model.addAttribute("articles", articles);
        model.addAttribute("view", "/admin/article/list");

        return "base-layout";
    }
}
