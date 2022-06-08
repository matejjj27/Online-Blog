package softuni.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.blog.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByid(Integer id);
}