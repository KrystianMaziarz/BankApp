package pl.krystianmaziarz.bank.services;

import org.springframework.stereotype.Service;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.repositories.UserRepo;

import java.util.List;

@Service
public interface UserService {

     List<User> findAll();

     User findById(Long id);

     User findByEmail (String email);

     void deleteById(Long id);


    }



