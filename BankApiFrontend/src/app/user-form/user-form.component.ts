import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';
import {Gender} from '../gender.enum';
import {BankAccount} from '../bank-account';
import {Address} from '../address';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user: User;
  Gender = Gender;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User();
    this.user.bankAccount = new BankAccount();
    this.user.address = new Address();
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

}
