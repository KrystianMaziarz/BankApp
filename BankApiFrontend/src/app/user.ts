import {Address} from './address';
import {Gender} from './gender.enum';
import {BankAccount} from './bank-account';

export class User {
  id: number;
  name: string;
  surname: string;
  email: string;
  dateOfBirthday: number;
  gender: Gender;
  bankAccount: BankAccount;
  address: Address;
}
