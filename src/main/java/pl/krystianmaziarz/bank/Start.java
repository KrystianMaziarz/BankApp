package pl.krystianmaziarz.bank;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krystianmaziarz.bank.domain.Address;
import pl.krystianmaziarz.bank.domain.BankAccount;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.domain.enums.Gender;
import pl.krystianmaziarz.bank.repositories.UserRepo;

import java.time.LocalDate;

@Component
public class Start {

    private UserRepo userRepo;

    public Start(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        User jan = new User("Jan", "Kowalski", "kowalski@onet.pl", "jan123",
                LocalDate.of(1994, 5, 5), Gender.MALE, new BankAccount(0L)
                , new Address("Lublin", "Narutowicza", "11", "17-233"));
        User dawid = new User("Dawid", "Malinowski", "malina@onet.pl", "malina123",
                LocalDate.of(1997, 8, 10), Gender.MALE, new BankAccount(0L)
                , new Address("Warszawa", "Narutowicza", "15", "15-343"));
        User janina = new User("Janina", "Janikowska", "janina@onet.pl", "janina123",
                LocalDate.of(1980, 8, 10), Gender.FEMALE, new BankAccount(0L)
                , new Address("Kraków", "Hetmanioka", "17", "24-566"));
        userRepo.save(jan);
        userRepo.save(dawid);
        userRepo.save(janina);

    }


}
