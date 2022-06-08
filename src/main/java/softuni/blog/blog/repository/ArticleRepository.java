package softuni.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.blog.blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}