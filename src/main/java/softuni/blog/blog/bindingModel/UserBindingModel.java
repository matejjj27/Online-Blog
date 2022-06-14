package softuni.blog.blog.bindingModel;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;


public class UserBindingModel {

    @NotNull
    private String email;
    @NotNull
    private String fullName;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;
    private String photo;
    @NotNull
    private String gender;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
