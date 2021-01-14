package com.cuellar.user.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author Steven Cuellar
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Long idToken;
    @OneToOne
    @JoinColumn(name = "FK_USER")
    private User user;
    private Calendar calendar;
    private Long token;
}
