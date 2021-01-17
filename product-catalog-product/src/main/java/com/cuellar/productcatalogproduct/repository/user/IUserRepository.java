package com.cuellar.productcatalogproduct.repository.user;


import com.cuellar.productcatalogproduct.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
