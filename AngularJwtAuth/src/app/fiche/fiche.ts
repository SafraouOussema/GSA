export class fiche {


    locaux: string;
    nresponsable: string;
    incerticide: string;
    nencadreur: string;
    observations: string;

    harrive: string;
    hdepart: string;


  constructor(locaux: string, nresponsable: string, incerticide: string, nencadreur: string,
              observations: string, harrive: string, hdepart: string)
  {
    this.locaux= locaux;
    this.nresponsable= nresponsable;
    this.incerticide=incerticide;
    this.nencadreur=nencadreur;
    this.observations= observations;
    this.harrive= harrive;
    this.hdepart= hdepart;
  }
}
