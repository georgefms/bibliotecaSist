package br.com.georgefms.bibliotecaSist.model;

import br.com.georgefms.bibliotecaSist.enums.RoleName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "TB_ROLE")
@Getter
@Setter
public class RoleModel implements GrantedAuthority {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;
    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
