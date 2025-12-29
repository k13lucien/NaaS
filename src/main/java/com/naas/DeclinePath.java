package com.naas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclinePath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    @Column(unique = true) String code;
    String title;
    @Column(columnDefinition = "TEXT") String message;
    String tone;
}
