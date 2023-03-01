package br.com.georgefms.bibliotecaSist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@UniqueElements
    @NotBlank
    @Length(min =5, max= 30)
    @Column(length = 30, nullable = false)
    private String nick;
    @NotBlank
    @Length(min =8, max= 100)
    @Column(length = 100, nullable = false)
    private String password;
    @NotBlank
    //@Pattern(regexp = "Admin | User")
    @Column(length = 5, nullable = false)
    private String role = "User";
}
