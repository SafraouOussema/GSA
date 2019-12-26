import { Component, OnInit  , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CompanyService } from '../services/company.service';
import { LocauxService } from '../services/locaux.service';
import {locaux} from './locaux';


@Component({
  selector: 'app-locaux',
  templateUrl: './locaux.component.html',
  styleUrls: ['./locaux.component.css']
})
export class LocauxComponent implements OnInit {


  public selecteclass  = null;
  Locaux: locaux;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private companyService: CompanyService,
              private locauxService: LocauxService
  )
  { }

  gcs: any=null;
  niveaus: any=null;

  g: any = {};

  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  delgc : any = {};

  gg : any = {};

  form: any = {};



  ngOnInit() {
    this.loadData();
  }


  loadData(){
    this.route.params.subscribe(params => {
      const id = params['id'];

      this.locauxService.get(id).subscribe(data => {
        this.gcs = data;
        console.log( this.gcs);

      });
      this.companyService.get(id).subscribe(data => {
        this.niveaus = data;
        console.log(data);
      });
    });
  }



  onSubmit() {
    this.Locaux = new locaux(
      this.form.name
      );

    this.locauxService.save(this.Locaux,this.niveaus.id).subscribe(
      data => {
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }






  remove(form: NgForm) {
    this.locauxService.remove(form).subscribe(result => {
      this.loadData();
    }, error => console.error(error));
  }



}
