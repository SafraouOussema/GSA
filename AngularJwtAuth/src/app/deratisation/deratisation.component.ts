import { Component, OnInit  , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CompanyService } from '../services/company.service';
import { DeratisationService } from '../services/deratisation.service';
import {deratisation} from './deratisation';
import {ProduitService} from '../services/produit.service';
import {LocauxService} from '../services/locaux.service';


@Component({
  selector: 'app-deratisation',
  templateUrl: './deratisation.component.html',
  styleUrls: ['./deratisation.component.css']
})
export class DeratisationComponent implements OnInit {


  public selecteclass  = null;
  Deratisation: deratisation;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private companyService: CompanyService,
              private deratisationService: DeratisationService,
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
      this.deratisationService.get(id).subscribe(data => {
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
    this.Deratisation = new deratisation(
    );

    this.deratisationService.save(this.Deratisation,this.fi,this.selectedlocaux,this.selectedproduit).subscribe(
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
    this.deratisationService.remove(form).subscribe(result => {
      this.loadData();
    }, error => console.error(error));
  }



}
