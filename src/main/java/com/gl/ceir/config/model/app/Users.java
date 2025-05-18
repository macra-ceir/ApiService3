package com.gl.ceir.config.model.app;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
 
@Table(name = "users")

public class Users extends UserVars {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String username;
    String password;
    int parentId;


}
