package com.cuellar.user.commons.dto;

import com.cuellar.user.models.entity.Role;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private boolean status;
    private Role role;
    private String name;
}
