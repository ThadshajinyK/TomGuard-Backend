package com.TomGuard.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name="users")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;


    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String job_title;

    @JsonIgnore
    private String resetToken;

    private String phone;

    private String location;

    @Column(columnDefinition = "text")
    private  String image;



}
