package com.cuellar.user.web.api.rest;

import com.cuellar.user.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserApi {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/login")
    public ResponseEntity<?> login(@RequestHeader String basic){
        return iUserService.login(basic);
    }

    @GetMapping(value = "/hola")
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok("Hola mundo");
    }
}
