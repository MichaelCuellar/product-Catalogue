package com.cuellar.user.repository.user;

import com.cuellar.user.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
