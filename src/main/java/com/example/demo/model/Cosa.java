package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cose")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cosa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcosa;
    private String name;
    private String utility;
    private String materiale;
}
