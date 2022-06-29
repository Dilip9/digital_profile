package com.commandlinerunner;

import com.domain.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public DefaultData(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("Dilip","Verma","dilip.verma940805@gmail.com"));
        userRepository.save(new User("Anjali","Mehta","anjali@xyz.com"));
        userRepository.save(new User("Anju", "Verma", "anju.annu@anu.com"));
        userRepository.save(new User( "Rig","verma","rigverma@ashu.com"));
        System.out.println(" Data is getting added for default settings");
    }
}
