import { Component, OnInit , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {CalendarService} from '../services/calendar.service';
import {calendar} from './calendar';
import {CompanyService} from '../services/company.service';
import {UserService} from '../services/user.service'
@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  public selecteduser = null;
  public selectedcompany = null;

  form: any = {};
  Calendar: calendar;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  gg : any= {};
  users: Array<any>;
  companys: Array<any>;


  constructor(private route: ActivatedRoute,
              private router: Router,private calendarService:CalendarService,
              private compnayService:CompanyService,
              private userService:UserService
  ) {

  }

  niveaus: Array<any>;
  ngOnInit() {

    this.loadData();



  }

  loadData(){
    this.calendarService.getAll().subscribe(data => {
      this.niveaus = data;
      console.log(this.niveaus);
    });
    this.userService.getAll().subscribe(data => {
      this.users = data;
      console.log(data);
    });
    this.compnayService.getAll().subscribe(data => {
      this.companys = data;
      console.log(this.companys);
    });




  }

  gotoList() {
    this.router.navigate(['/calendar']);
  }

  onSubmit() {

    this.Calendar = new calendar(
      this.form.date);

    this.calendarService.save(this.Calendar,this.selecteduser,this.selectedcompany).subscribe(
      data => {
        this.isSignedUp = true;
        this.isSignUpFailed = false;
        this.gotoList();
        this.loadData();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }


  remove(form: NgForm) {

    this.gg = form ;

    this.calendarService.remove(this.gg).subscribe(result => {
      this.gotoList();
      this.loadData();
    }, error => console.error(error));

  }



}
