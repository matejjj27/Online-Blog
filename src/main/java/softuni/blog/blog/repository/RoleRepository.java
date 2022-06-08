package softuni.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.blog.blog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    Role findByid(Integer id);
}