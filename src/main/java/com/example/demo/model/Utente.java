package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Long idutente;
        @Column(name = "name")
        private String name;
        @Column(name = "lastname")
        private String lastname;
        @Column(name = "username", unique = true)
        private String username;
        @Column(name = "password")
        private String password;
        @Column(name = "email")
        private String email;
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Cosa.class)
        private List<Cosa> cosa;

}
