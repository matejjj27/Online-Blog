package softuni.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.blog.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByid(Integer id);
}