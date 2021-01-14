package com.cuellar.user.repository.token;

import com.cuellar.user.models.entity.Token;
import com.cuellar.user.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT c FROM Token c WHERE c.user=:user")
    Token findTokenByUser(@Param("user") User user);
}
