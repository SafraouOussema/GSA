import { Component, OnInit , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {CalendarService} from '../services/calendar.service';
import {CompanyService} from '../services/company.service';
import {UserService} from '../services/user.service';
import {FicheService} from '../services/fiche.service';

import {fiche} from './fiche';

@Component({
  selector: 'app-fiche',
  templateUrl: './fiche.component.html',
  styleUrls: ['./fiche.component.css']
})
export class FicheComponent implements OnInit {


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
     });
    this.userService.getAll().subscribe(data => {
      this.users = data;
     });
    this.companyService.getAll().subscribe(data => {
      this.companys = data;
     });

    this.ficheService.getAll().subscribe(data=>{
      this.fiches =data ;
      console.log(data);
    });

  }

  gotoList() {
    this.router.navigate(['/fiche']);
  }

  onSubmit() {

    this.Fiche = new fiche(
      this.form.locaux,
    this.form.nresponsable,
    this.form.incerticide,
    this.form.nencadreur,
    this.form.observations,
    this.form.harrive,
    this.form.hdepart
    );

    this.ficheService.save(this.Fiche,this.selecteduser,this.selectedcompany,this.selectedcalendar).subscribe(
      data => {
        this.isSignedUp = true;
        this.isSignUpFailed = false;
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

    this.ficheService.remove(this.gg).subscribe(result => {
      this.gotoList();
      this.loadData();
    }, error => console.error(error));

  }




}
