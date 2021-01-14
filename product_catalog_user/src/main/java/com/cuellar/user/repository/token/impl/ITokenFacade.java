package com.cuellar.user.repository.token.impl;

import com.cuellar.user.models.entity.Token;
import com.cuellar.user.models.entity.User;

public interface ITokenFacade {

    void save(Token token);

    Token token(User user);
}
