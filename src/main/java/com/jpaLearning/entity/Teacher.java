package com.jpaLearning.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity(name = "teacher")
@Table(name = "teacher")
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_seq",
            sequenceName = "teacher_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "teacher_seq",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id",
            nullable = false)
    private Person person;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<CourseTeacher> courseTeacherList;

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<CourseTeacher> getCourseTeacherList() {
        return courseTeacherList;
    }

    public void setCourseTeacherList(List<CourseTeacher> courseTeacherList) {
        this.courseTeacherList = courseTeacherList;
    }
}
