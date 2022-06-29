package com.serviceimpl;

import com.domain.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> save(User user) {
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public ResponseEntity<User> updateUserProfilesById(User user, Long id){
        Optional<User> users = userRepository.findById(id);
        if (users.isPresent()){
            User updateUser = users.get();
            updateUser.setEmail(user.getEmail());
            updateUser.setFirst_name(user.getFirst_name());
            updateUser.setLast_name(user.getLast_name());
            userRepository.save(updateUser);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUserFilter(Long id){

        return userRepository.findById(id);
    }
}
