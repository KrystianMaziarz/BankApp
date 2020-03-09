package pl.krystianmaziarz.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krystianmaziarz.bank.domain.BankAccount;

@Repository
public interface BankAccountRepo extends JpaRepository <BankAccount, Long> {
}
