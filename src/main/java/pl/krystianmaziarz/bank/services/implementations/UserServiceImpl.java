package pl.krystianmaziarz.bank.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
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

    @Override
    @Transactional
    public void addUser(User user) {
      User persistedUser = new User();
        persistedUser.setAddress(user.getAddress());
        persistedUser.setBankAccount(user.getBankAccount());
        persistedUser.setEmail(user.getEmail());
        persistedUser.setDateOfBirthday(user.getDateOfBirthday());
        persistedUser.setName(user.getName());
        persistedUser.setGender(user.getGender());
        persistedUser.setSurname(user.getSurname());
        persistedUser.setPassword(user.getPassword());
        userRepo.save(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User foundUser = userRepo.getOne(user.getId());
        if (user.getAddress()!=null){
        foundUser.setAddress(user.getAddress());}
        if(user.getBankAccount()!=null) {
        foundUser.setBankAccount(user.getBankAccount());}
        foundUser.setEmail(user.getEmail());
        foundUser.setDateOfBirthday(user.getDateOfBirthday());
        foundUser.setName(user.getName());
        foundUser.setGender(user.getGender());
        foundUser.setSurname(user.getSurname());
        foundUser.setPassword(user.getPassword());
        userRepo.save(foundUser);

    }
}
