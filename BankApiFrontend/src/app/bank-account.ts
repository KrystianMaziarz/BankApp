import {User} from './user';

export class BankAccount {
   id: number;
   iban: string;
   isActive: boolean;
   balance: number;
   user: User;
}
