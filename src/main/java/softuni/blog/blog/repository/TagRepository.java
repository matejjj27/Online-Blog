package softuni.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.blog.blog.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag findByName(String name);
}
