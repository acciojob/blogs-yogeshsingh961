package com.driver.models;
import javax.persistence.*;

@Entity
public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dimension;
    private String descripiton;

    @ManyToOne
    @JoinColumn //introduces a FK blog id in Image table
    Blog blog;

    public Image(){

    }

    public Image(int id, String description, String dimensions) {
        this.id = id;
        this.descripiton = description;
        this.dimension = dimensions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}