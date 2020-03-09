package pl.krystianmaziarz.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krystianmaziarz.bank.domain.Address;

@Repository
public interface AddressRepo extends JpaRepository <Address, Long> {
}
