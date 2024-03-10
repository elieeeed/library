package com.jpaLearning.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "class")
@Table(name = "class")
public class CourseClass {

    @Id
    @SequenceGenerator(
            name = "class_seq",
            sequenceName = "class_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "class_seq",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    @JoinColumn(name = "class_id")
    private List<Subscribe> subscribeList;

    public CourseClass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Subscribe> getSubscribeList() {
        return subscribeList;
    }

    public void setSubscribeList(List<Subscribe> subscribeList) {
        this.subscribeList = subscribeList;
    }
}
