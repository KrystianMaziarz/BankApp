package pl.krystianmaziarz.bank;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krystianmaziarz.bank.domain.Address;
import pl.krystianmaziarz.bank.domain.BankAccount;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.domain.enums.Gender;
import pl.krystianmaziarz.bank.repositories.AddressRepo;
import pl.krystianmaziarz.bank.repositories.BankAccountRepo;
import pl.krystianmaziarz.bank.repositories.UserRepo;

import java.time.LocalDate;

@Component
public class Start {

    private UserRepo userRepo;
    private AddressRepo addressRepo;
    private BankAccountRepo bankAccountRepo;

    public Start(UserRepo userRepo, AddressRepo addressRepo, BankAccountRepo bankAccountRepo) {
        this.userRepo = userRepo;
        this.addressRepo = addressRepo;
        this.bankAccountRepo = bankAccountRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        BankAccount janAccount = new BankAccount(0L);
        BankAccount dawidAccount = new BankAccount(0L);
        BankAccount janinaAccount = new BankAccount(0L);

        bankAccountRepo.save(janAccount);
        bankAccountRepo.save(dawidAccount);
        bankAccountRepo.save(janinaAccount);

        Address janAddress = new Address("Lublin", "Narutowicza", "11", "17-233");
        Address dawidAddress = new Address("Warszawa", "Narutowicza", "15", "15-343");
        Address janinaAddress = new Address("Kraków", "Hetmanioka", "17", "24-566");

        addressRepo.save(janAddress);
        addressRepo.save(dawidAddress);
        addressRepo.save(janinaAddress);

        User jan = new User("Jan", "Kowalski", "kowalski@onet.pl", "jan123",
                LocalDate.of(1994, 5, 5), Gender.MALE, janAccount, janAddress);
        User dawid = new User("Dawid", "Malinowski", "malina@onet.pl", "malina123",
                LocalDate.of(1997, 8, 10), Gender.MALE, dawidAccount, dawidAddress);
        User janina = new User("Janina", "Janikowska", "janina@onet.pl", "janina123",
                LocalDate.of(1980, 8, 10), Gender.FEMALE, janinaAccount, janinaAddress);

        userRepo.save(jan);
        userRepo.save(dawid);
        userRepo.save(janina);



    }


}
