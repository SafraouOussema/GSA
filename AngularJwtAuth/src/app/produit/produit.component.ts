import { Component, OnInit  , ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ProduitService } from '../services/produit.service';
import {produit} from './produit';



@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {


  public selecteclass  = null;
  Produit: produit;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private produitService: ProduitService
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

  gotoList() {
    this.router.navigate(['/produit']);
  }


  ngOnInit() {
    this.loadData();
  }


  loadData(){
    this.produitService.getAll().subscribe(data => {
      this.niveaus = data;
      console.log(this.niveaus);
    });
  }



  onSubmit() {
    this.Produit = new produit(
      this.form.pname
    );

    this.produitService.save(this.Produit).subscribe(
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
    this.produitService.remove(form).subscribe(result => {
      this.loadData();
      this.gotoList();
    }, error => console.error(error));
  }



}
