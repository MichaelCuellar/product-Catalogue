package com.cuellar.user.service.user;

import com.cuellar.user.commons.dto.LoginDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<?> login (String basic);
    ResponseEntity<?> loginAdmin (String basic, Long tokenHeader);
}
