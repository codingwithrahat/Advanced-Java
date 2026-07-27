package com.turtlesltd.productshopdatabase.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "student_table")
public class Student {

    @Id
    private int id;
    private String name;

    @Column(name = "mygpa")
    private double cgpa;

    @Embedded
    private Address address;

    @ElementCollection
    //only for String
    private List<String> phnNumbers;

    @OneToOne
    private Gardian gardian;
}
