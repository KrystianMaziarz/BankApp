package pl.krystianmaziarz.bank.controllers;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.services.implementations.UserServiceImpl;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userService) {
        this.userServiceImpl = userService;
    }

    @GetMapping("/all")
    @CrossOrigin
    public List<User> findAll(){
    return userServiceImpl.findAll();

    }
    @GetMapping
    public HttpEntity<User> findById(@RequestParam Long id){
     return ResponseEntity.ok (userServiceImpl.findById(id));

    }

    @GetMapping("/email")
    public HttpEntity<User> findByMail (@RequestParam String email){
        return ResponseEntity.ok (userServiceImpl.findByEmail(email));

    }
    @DeleteMapping
    public void deleteById (Long id){
        userServiceImpl.deleteById(id);
    }

    @PostMapping
    @CrossOrigin
    public void addUser (@RequestBody User user){
       userServiceImpl.addUser(user);

    }
    @PutMapping
    public void updateUser(@RequestBody User user){
        userServiceImpl.updateUser(user);
    }

}
