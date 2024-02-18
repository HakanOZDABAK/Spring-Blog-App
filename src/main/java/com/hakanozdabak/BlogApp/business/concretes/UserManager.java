package com.hakanozdabak.BlogApp.business.concretes;

import com.hakanozdabak.BlogApp.business.abstracts.UserService;
import com.hakanozdabak.BlogApp.business.core.utilities.mappers.ModelMapperService;
import com.hakanozdabak.BlogApp.business.responses.PostResponse;
import com.hakanozdabak.BlogApp.business.responses.UserResponse;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.UserRepository;
import com.hakanozdabak.BlogApp.entities.concretes.Post;
import com.hakanozdabak.BlogApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses= users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, UserResponse.class)).collect(Collectors.toList());
        return userResponses;
    }


}
