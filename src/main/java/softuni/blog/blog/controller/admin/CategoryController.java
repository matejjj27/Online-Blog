package softuni.blog.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.blog.blog.bindingModel.CategoryBindingModel;
import softuni.blog.blog.entity.Article;
import softuni.blog.blog.entity.Category;
import softuni.blog.blog.repository.ArticleRepository;
import softuni.blog.blog.repository.CategoryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String list(Model model){

        model.addAttribute("view", "admin/category/list");

        List<Category> categories = this.categoryRepository.findAll();

        categories = categories.stream()
                .sorted(Comparator.comparingInt(Category::getId))
                .collect(Collectors.toList());

        model.addAttribute("categories", categories);

        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("view", "admin/category/create");

        return "base-layout";
    }

    @PostMapping("/create")
    public String createProcess(CategoryBindingModel categoryBindingModel){

        if(StringUtils.isEmpty(categoryBindingModel.getName())){
            return "redirect:/admin/categories/";
        }

        Category category = new Category(categoryBindingModel.getName());

        this.categoryRepository.saveAndFlush(category);

        return "redirect:/admin/categories/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        if(!this.categoryRepository.existsById(id)){
            return "redirect:/admin/categories/";
        }

        Category category = this.categoryRepository.findByid(id);

        model.addAttribute("category", category);
        model.addAttribute("view", "admin/category/edit");

        return "base-layout";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(@PathVariable Integer id,
                              CategoryBindingModel categoryBindingModel){
        if(!this.categoryRepository.existsById(id)){
            return "redirect: admin/categorie/";
        }

        Category category = this.categoryRepository.findByid(id);

        category.setName(categoryBindingModel.getName());

        this.categoryRepository.saveAndFlush(category);

        return "redirect:/admin/categories/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){

        if(!this.categoryRepository.existsById(id)){
            return "redirect:/admin/categories/";
        }

        Category category = this.categoryRepository.findByid(id);

        model.addAttribute("category", category);
        model.addAttribute("view", "admin/category/delete");

        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable Integer id){
        if(!this.categoryRepository.existsById(id)){
            return "redirect:/admin/categories/";
        }

        Category category = categoryRepository.findByid(id);

        for(Article article : category.getArticles()){
            this.articleRepository.delete(article);
        }

        this.categoryRepository.delete(category);

        return "redirect:/admin/categories/";
    }
}