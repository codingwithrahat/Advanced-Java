package com.turtlesltd.productshopdatabase.student;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gardian_data")
public class Gardian {

    @Id
    int id;

    @Column(name = "Guardian_Name")
    String name;

}
