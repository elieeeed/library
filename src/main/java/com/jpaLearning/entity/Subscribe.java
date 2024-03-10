package com.jpaLearning.entity;

import jakarta.persistence.*;

@Entity(name = "subscribe")
@Table(name = "subscribe")
public class Subscribe {

    @Id
    @SequenceGenerator(
            name = "sub_seq",
            sequenceName = "sub_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "sub_seq",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    public Subscribe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
