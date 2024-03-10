package com.jpaLearning.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "course_teacher")
@Table(name = "course_teacher")
public class CourseTeacher {

    @Id
    @SequenceGenerator(
            name = "course_teacher_seq",
            sequenceName = "course_teacher_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "course_teacher_seq",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    @JoinColumn(name = "course_teacher_id")
    private List<CourseClass> classList;

    public CourseTeacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CourseClass> getClassList() {
        return classList;
    }

    public void setClassList(List<CourseClass> classList) {
        this.classList = classList;
    }
}
