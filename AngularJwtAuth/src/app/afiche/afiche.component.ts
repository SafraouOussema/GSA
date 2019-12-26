import { Component, OnInit , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {CalendarService} from '../services/calendar.service';
import {CompanyService} from '../services/company.service';
import {UserService} from '../services/user.service';
import {FicheService} from '../services/fiche.service';
import {fiche} from '../fiche/fiche';

@Component({
  selector: 'app-afiche',
  templateUrl: './afiche.component.html',
  styleUrls: ['./afiche.component.css']
})
export class AficheComponent implements OnInit {




  public selecteduser = null;
  public selectedcompany = null;
  public selectedcalendar = null;

  form: any = {};
  Fiche: fiche;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  gg : any= {};
  users: Array<any>;
  companys: Array<any>;
  fiches: Array<any>;


  constructor(private route: ActivatedRoute,
              private router: Router,
              private calendarService:CalendarService,
              private companyService:CompanyService,
              private userService:UserService,
              private ficheService:FicheService
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
      console.log(this.users);

    });
    this.companyService.getAll().subscribe(data => {
      this.companys = data;
      console.log(this.companys);

    });

    this.ficheService.getAll().subscribe(data=>{
      this.fiches =data ;
      console.log(this.fiches);
    });

  }








}
