export class fiche {


    nresponsable: string;
    incerticide: string;
    nencadreur: string;
    observations: string;

    harrive: string;
    hdepart: string;


  constructor( nresponsable: string, incerticide: string, nencadreur: string,
              observations: string, harrive: string, hdepart: string)
  {
    this.nresponsable= nresponsable;
    this.incerticide=incerticide;
    this.nencadreur=nencadreur;
    this.observations= observations;
    this.harrive= harrive;
    this.hdepart= hdepart;
  }
}
