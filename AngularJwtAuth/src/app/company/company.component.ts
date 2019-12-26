import { Component, OnInit , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {CompanyService} from '../services/company.service';
import {company} from './company';
@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CompanyComponent implements OnInit {


  form: any = {};
  Company: company;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  gg : any = {};

  constructor(private route: ActivatedRoute,
              private router: Router,private compnayService:CompanyService) {

  }

  niveaus: Array<any>;
  ngOnInit() {

    this.loadData();



  }

  loadData(){
    this.compnayService.getAll().subscribe(data => {
      this.niveaus = data;
      console.log(this.niveaus);
    });
  }

  gotoList() {
    this.router.navigate(['/company']);
  }

  onSubmit() {
    this.Company = new company(
      this.form.label,
      this.form.address);

    this.compnayService.save(this.Company).subscribe(
      data => {
        this.gotoList();
        this.loadData();
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

    this.gg = form ;

    this.compnayService.remove(this.gg).subscribe(result => {
      this.gotoList();
      this.loadData();
    }, error => console.error(error));

  }


}
