package com.cuellar.user.repository.token.impl;

import com.cuellar.user.models.entity.Token;
import com.cuellar.user.models.entity.User;
import com.cuellar.user.repository.token.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenImpl implements ITokenFacade{

    @Autowired
    private ITokenRepository iTokenRepository;


    @Override
    public void save(Token token) {
         iTokenRepository.save(token);
    }

    @Override
    public Token token(User user) {
        return iTokenRepository.findTokenByUser(user);
    }
}
