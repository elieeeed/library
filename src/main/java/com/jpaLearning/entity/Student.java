package com.jpaLearning.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "student")
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "student_seq",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "entryDate",
            nullable = false)
    private LocalDate entryDate;

    @OneToOne
    @JoinColumn(name = "person_id",
            nullable = false)
    private Person person;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Subscribe> subscribeList;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Subscribe> getSubscribeList() {
        return subscribeList;
    }

    public void setSubscribeList(List<Subscribe> subscribeList) {
        this.subscribeList = subscribeList;
    }
}
