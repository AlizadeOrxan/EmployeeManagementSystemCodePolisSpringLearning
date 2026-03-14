package com.ltc.employeemanagementsystemcodepolisspringlearning.service;

import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.request.UserRequest;
import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.response.UserResponse;
import com.ltc.employeemanagementsystemcodepolisspringlearning.exception.UserNotFoundException;
import com.ltc.employeemanagementsystemcodepolisspringlearning.model.UserEntity;
import com.ltc.employeemanagementsystemcodepolisspringlearning.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public UserResponse createUser(UserRequest userRequest) { ///  mushviq , gojaev , as,djh123!

        UserEntity userEntity = new UserEntity(); /// id , first , last , passw
        userEntity.setFirstName(userRequest.getFirstName()); /// mushviq
        userEntity.setLastName(userRequest.getLastName()); /// familuyasi
        userEntity.setPassword(userRequest.getPassword()); // shifresi

        UserEntity save = userRepository.save(userEntity); /// id  1 ,  mushviq , gojaev , as,djh123!

        UserResponse userResponse = new UserResponse();

        userResponse.setId(save.getId()); /// 1
        userResponse.setFirstName(save.getFirstName()); /// mushviq
        userResponse.setLastName(save.getLastName()); /// familyasi

        return userResponse;

    }


    public void deleteById(Long id) { ///  id 1 , Mushviq
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException("Bele bir ID-e sahib istifadechi yoxdur , silinme ede bilmersiniz" + id);
        }

        userRepository.deleteById(id);

    }


}
