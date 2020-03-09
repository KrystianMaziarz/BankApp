package pl.krystianmaziarz.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krystianmaziarz.bank.domain.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

     List<User> findAll();
     User findByEmail(String email);
}
