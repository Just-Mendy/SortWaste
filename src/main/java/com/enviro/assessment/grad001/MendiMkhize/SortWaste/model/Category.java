package com.enviro.assessment.grad001.MendiMkhize.SortWaste.model;


import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="category")
public class Category {
    public Category() {
    }

    public Category(Long id, String name, String disposalGuidelines,   String recyclingTips) {
        this.id = id;
        this.name = name;
        this.disposalGuidelines = disposalGuidelines;
        this.recyclingTips = recyclingTips;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String disposalGuidelines;
    private String recyclingTips;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(String disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }

    public String getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(String recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}
