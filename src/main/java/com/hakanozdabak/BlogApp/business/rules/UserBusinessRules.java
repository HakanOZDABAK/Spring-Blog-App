package com.hakanozdabak.BlogApp.business.rules;

import com.hakanozdabak.BlogApp.core.utilites.exceptions.BusinessException;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;
    public  void checkIfUserEmailExists(String email){
        if(this.userRepository.existsByEmail(email)){
            throw new BusinessException("Product name already exists");


        }
    }
}
