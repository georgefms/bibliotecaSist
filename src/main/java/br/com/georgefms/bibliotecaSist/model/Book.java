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
@Table(name = "TB_BOOK")


public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Length(min =5, max= 150)
    @Column(length = 150, nullable = false)
    private String name;
    @NotNull
    @Column(length = 4, nullable = false)
    private Integer year;
    @NotBlank
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String author;
    @NotBlank
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String gender;
    @Column(length = 30, nullable = false)
    private String createdBy;
}
