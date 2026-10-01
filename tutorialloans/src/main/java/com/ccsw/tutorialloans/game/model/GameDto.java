package com.ccsw.tutorialloans.game.model;


import com.ccsw.tutorialloans.author.AuthorDto;
import com.ccsw.tutorialloans.category.CategoryDto;

public class GameDto {

    private Long id;

    private String title;

    private String age;

    private CategoryDto category;

    private AuthorDto author;

    // @return id
    public Long getId() {

        return this.id;
    }

    // @param id new value of {@link #getId}.
    public void setId(Long id) {

        this.id = id;
    }

    // @return title
    public String getTitle() {

        return this.title;
    }

    // @param title new value of {@link #getTitle}.
    public void setTitle(String title) {

        this.title = title;
    }

    // @return age
    public String getAge() {

        return this.age;
    }

    // @param age new value of {@link #getAge}.
    public void setAge(String age) {

        this.age = age;
    }

    // @return idCategory
    public CategoryDto getCategory() {

        return this.category;
    }

    // @param idCategory new value of {@link #getIdCategory}.
    public void setCategory(CategoryDto category) {

        this.category = category;
    }

    // @return idAuthor
    public AuthorDto getAuthor() {

        return this.author;
    }

    // @param idAuthor new value of {@link #getIdAuthor}.
    public void setAuthor(AuthorDto author) {

        this.author = author;
    }

}
