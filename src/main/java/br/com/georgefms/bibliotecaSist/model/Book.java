package br.com.georgefms.bibliotecaSist.model;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    @Length(min =5, max= 150)
    @Column(length = 150, nullable = false)
    private String name;
    @NotNull
    @Column(length = 4, nullable = false)
    private Integer year;
    @NotBlank
    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String author;
    @NotBlank
    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String gender;
}
