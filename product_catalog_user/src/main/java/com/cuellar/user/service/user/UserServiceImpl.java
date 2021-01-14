package com.cuellar.user.service.user;

import com.cuellar.user.commons.dto.LoginDto;
import com.cuellar.user.commons.dto.UserBasicDto;
import com.cuellar.user.commons.utils.Util;
import com.cuellar.user.commons.utils.email.ISendEmail;
import com.cuellar.user.models.entity.Token;
import com.cuellar.user.models.entity.User;
import com.cuellar.user.repository.token.impl.ITokenFacade;
import com.cuellar.user.repository.user.impl.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserFacade iUserFacade;

    @Autowired
    private ITokenFacade iTokenFacade;

    @Autowired
    private ISendEmail iSendEmail;

    @Override
    public ResponseEntity<?> login(String basic) {
        UserBasicDto userBasic = Util.getIdUser(basic);
        User user = iUserFacade.user(userBasic.getIdUser());
        if (user != null) {
            boolean access = user.getCredentials().equals(userBasic.getCredentials());
            if (access) {
                LoginDto login = LoginDto.builder().status(true).role(user.getRole()).name(user.getName()).build();
                if (user.getRole().getIdRole() == 1) {
                    Long randomNumber = (new Double(Math.random() * 1000000)).longValue();
                    Token token = findToken(user);
                    token.setToken(randomNumber);
                    token.setUser(user);
                    token.setCalendar(Calendar.getInstance());
                    login.setStatus(iSendEmail.sendEmail(randomNumber, user.getEmail()));
                    iTokenFacade.save(token);
                }
                return new ResponseEntity<>(login, HttpStatus.OK);
            } else {
                LoginDto login = LoginDto.builder().status(false).build();
                return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
            }
        } else {
            LoginDto login = LoginDto.builder().status(false).build();
            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> loginAdmin(String basic, Long tokenHeader) {
        UserBasicDto userBasic = Util.getIdUser(basic);
        User user = iUserFacade.user(userBasic.getIdUser());
        Token token = iTokenFacade.token(user);
        boolean access = token.getToken().equals(tokenHeader);
        if (access) {
            LoginDto login = LoginDto.builder().status(true).role(user.getRole()).name(user.getName()).build();
            return new ResponseEntity<>(login, HttpStatus.OK);
        } else {
            LoginDto login = LoginDto.builder().status(false).build();
            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
        }
    }

    public Token findToken(User user) {
        Token token = iTokenFacade.token(user);
        if (token != null){
            return token;
        }else {
            return new Token();
        }
    }
}
