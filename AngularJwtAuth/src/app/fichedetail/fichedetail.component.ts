import { Component, OnInit  , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CompanyService } from '../services/company.service';
import { DeratisationService } from '../services/deratisation.service';
import {ProduitService} from '../services/produit.service';
import {LocauxService} from '../services/locaux.service';
import {deratisation} from '../deratisation/deratisation';
import { DesinsectisationService } from '../services/desinsectisation.service';


@Component({
  selector: 'app-fichedetail',
  templateUrl: './fichedetail.component.html',
  styleUrls: ['./fichedetail.component.css']
})
export class FichedetailComponent implements OnInit {


  public selecteclass  = null;
  Deratisation: deratisation;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private companyService: CompanyService,
              private desinsectisationService: DesinsectisationService,
              private deratisationService: DeratisationService,
              private produitService: ProduitService,
              private locauxService: LocauxService

  )
  { }

  gcs: any=null;
  desi: any=null;

  niveaus: any=null;
  com: any=null;

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
        this.desi = data;
        console.log("desi",data);

      });
      this.deratisationService.get(id).subscribe(data => {
        this.gcs = data;
        console.log("dera",data);

      });

      this.companyService.get(comid).subscribe(data => {
        this.com = data;
        console.log( "company",this.com);

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





}
