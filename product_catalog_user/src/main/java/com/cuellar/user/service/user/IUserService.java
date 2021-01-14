package com.cuellar.user.service.user;

import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<?> login(String basic);

    ResponseEntity<?> loginAdmin(String basic, Long tokenHeader);
}
