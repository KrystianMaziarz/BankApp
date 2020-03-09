package pl.krystianmaziarz.bank.services.implementations;

import org.springframework.stereotype.Service;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.repositories.UserRepo;
import pl.krystianmaziarz.bank.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.getOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
    userRepo.deleteById(id);
    }
}
