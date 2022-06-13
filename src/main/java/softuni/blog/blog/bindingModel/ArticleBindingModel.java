package softuni.blog.blog.bindingModel;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import softuni.blog.blog.entity.User;

public class ArticleBindingModel {

    @NotNull
    private String title;
    @NotNull
    private String content;
    private Integer categoryId;
    private String tagString;
    private User author;

    public String getTagString() { return tagString; }
    public void setTagString(String tagString) { this.tagString = tagString; }

    public Integer getCategoryId() { return categoryId; }

    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }
}
