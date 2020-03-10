package pl.krystianmaziarz.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    private boolean isActive;
    private Long balance;
    @OneToOne
    private User user;

    public BankAccount(String iban, boolean isActive, Long balance) {
        this.iban = iban;
        this.isActive = isActive;
        this.balance = balance;
    }
}


