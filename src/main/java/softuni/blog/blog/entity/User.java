package softuni.blog.blog.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Integer id;
    private String email;
    private String fullName;
    private String password;
    private String photo;
    private String gender;


    public User(String email, String fullName, String password, String gender) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;

        this.roles = new HashSet<>();
        this.articles = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "fullName", nullable = false)
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "password", length = 60, nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "photo", length = 64)
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    @Column(name = "gender")
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public User() { }

    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="users_roles")
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    private Set<Article> articles;

    @OneToMany(mappedBy = "author")
    public Set<Article> getArticles() { return articles; }
    public void setArticles(Set<Article> articles) { this.articles = articles; }


    @Transient
    public boolean isAdmin() {
        return this.getRoles()
                .stream()
                .anyMatch(role -> role.getName().equals("ROLE_ADMIN"));
    }
    @Transient
    public boolean isAuthor(Article article) {
        return Objects.equals(this.getId(),
                article.getAuthor().getId());
    }
    @Transient
    public String getPhotosImagePath() {
        String g = "F";
        String g2 = "M";
        if (photo == null || id == null){
            if (gender.equals(g2)) {
                return "/user-photos/default/male.jpg";
            }
            else if (gender.equals(g)){
                return "/user-photos/default/female.jpg";
            }
            else if (!gender.equals(g) && !gender.equals(g2)){
                return "/user-photos/default/unknown.jpg";
            }
        }

        return "/user-photos/" + id + "/" + photo;
    }
}
