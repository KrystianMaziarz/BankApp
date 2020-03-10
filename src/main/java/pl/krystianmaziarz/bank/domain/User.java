package pl.krystianmaziarz.bank.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;
import pl.krystianmaziarz.bank.domain.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class User  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "imie")
    private String name;
    @Column (name = "nazwisko")
    private String surname;
    @Column (name = "mail")
    private String email;
    private String password;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dataUrodzenia")
    private LocalDate dateOfBirthday;
    @Column(name = "płeć")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne (cascade = CascadeType.ALL)
    private BankAccount bankAccount;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public User() {
    }

    public User(String name, String surname, String email, String password, LocalDate dateOfBirthday, Gender gender,BankAccount bankAccount, Address address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
        this.bankAccount = bankAccount;
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
