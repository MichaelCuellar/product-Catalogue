package com.cuellar.productcatalogproduct.repository.user.impl;



import com.cuellar.productcatalogproduct.models.entity.User;
import com.cuellar.productcatalogproduct.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUserFacade{

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public User user(Long idUser) {
        return iUserRepository.findById(idUser).orElse(null);
    }
}
