import { Component, OnInit  , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CompanyService } from '../services/company.service';
import { DesinsectisationService } from '../services/desinsectisation.service';
import {desinsectisation} from './desinsectisation';
import {ProduitService} from '../services/produit.service';
import {LocauxService} from '../services/locaux.service';

@Component({
  selector: 'app-desinsectisation',
  templateUrl: './desinsectisation.component.html',
  styleUrls: ['./desinsectisation.component.css']
})
export class DesinsectisationComponent implements OnInit {


  public selecteclass  = null;
  Desinsectisation: desinsectisation;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private companyService: CompanyService,
              private desinsectisationService: DesinsectisationService,
              private produitService: ProduitService,
              private locauxService: LocauxService

  )
  { }

  gcs: any=null;
  niveaus: any=null;
  produits: any=null;
  fi : any =null ;
  g: any = {};

  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  delgc : any = {};

  gg : any = {};

  form: any = {};


  public selectedproduit = null;
  public selectedlocaux = null;

  ngOnInit() {
    this.loadData();
  }


  loadData(){
    this.route.params.subscribe(params => {
      const id = params['fichid'];
      this.fi = id ;
      const comid = params['companyid'];
      this.desinsectisationService.get(id).subscribe(data => {
        this.gcs = data;
        console.log( this.gcs);

      });
      this.locauxService.get(comid).subscribe(data => {
        this.niveaus = data;
        console.log( this.niveaus);

      });
    });
    this.produitService.getAll().subscribe(data => {
      this.produits = data;
      console.log(this.produits);
    });
  }



  onSubmit() {
    this.Desinsectisation = new desinsectisation(
    );

    this.desinsectisationService.save(this.Desinsectisation,this.fi,this.selectedlocaux,this.selectedproduit).subscribe(
      data => {
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
    this.desinsectisationService.remove(form).subscribe(result => {
      this.loadData();
    }, error => console.error(error));
  }



}
