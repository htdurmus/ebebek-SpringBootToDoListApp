package com.todoapp.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "kontrol", nullable = false)
    private boolean checked = false;

    public User(String firstName, String lastName, boolean checked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checked = checked;
    }
}
