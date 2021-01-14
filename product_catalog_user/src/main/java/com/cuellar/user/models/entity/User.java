package com.cuellar.user.models.entity;


import lombok.*;
import javax.persistence.*;

/**
 * @author Steven Cuellar
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id_user")
    private Long idUser;
    private String name;
    private String credentials;
    @OneToOne()
    private Role role;
    private String email;

}
