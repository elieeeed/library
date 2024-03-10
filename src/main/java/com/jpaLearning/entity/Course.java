package com.jpaLearning.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "course")
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "course_seq",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name",
            nullable = false)
    private String name;

    @Column(name = "unit",
            nullable = false)
    private Integer unit;

    @OneToMany
    @JoinColumn(name = "course_id")
    private List<CourseTeacher> courseTeacherList;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<CourseTeacher> getCourseTeacherList() {
        return courseTeacherList;
    }

    public void setCourseTeacherList(List<CourseTeacher> courseTeacherList) {
        this.courseTeacherList = courseTeacherList;
    }
}
