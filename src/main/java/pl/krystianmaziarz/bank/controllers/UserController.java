package pl.krystianmaziarz.bank.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.services.implementations.UserServiceImpl;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> findAll(){

    return userService.findAll();

    }
    @GetMapping("/find")
    public User findById(Long id){
       //TODO

        return null;

    }
}
