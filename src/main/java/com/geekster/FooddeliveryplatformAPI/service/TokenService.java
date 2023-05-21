package com.geekster.FooddeliveryplatformAPI.service;

import com.geekster.FooddeliveryplatformAPI.models.AuthenticationToken;
import com.geekster.FooddeliveryplatformAPI.models.User;
import com.geekster.FooddeliveryplatformAPI.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    ITokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public boolean authenticate(String email, String token) {

        if(token==null && email==null){
            return false;
        }

        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);

        if(authToken==null){
            return false;
        }

        String expectedEmail = authToken.getUser().getEmail();


        return expectedEmail.equals(email);
    }


    public void deleteToken(String token) {
        AuthenticationToken token1 = tokenRepo.findFirstByToken(token);

        tokenRepo.deleteById(token1.getTokenId());
    }

    public User findUserByToken(String token)
    {
        return tokenRepo.findFirstByToken(token).getUser();
    }
}