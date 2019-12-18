import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CompanyService {


  public API = '//localhost:8080/application';

  public company_API = this.API + '/companys';
   public companydelte_API = this.API+'/companys';



  constructor(private http: HttpClient) {
  }


  getAll(): Observable<any> {
    return this.http.get(this.API + '/companys');
  }

  save(niv: any): Observable<any> {
    let result: Observable<Object>;
    console.log(result);
    result = this.http.post(
      this.company_API,
      niv,
      {headers :
          {
            'Content-Type': 'application/json'
          }
      }
    );

    return result;
  }


  update(prof: any): Observable<any> {
    let result: Observable<Object>;

    result = this.http.post(this.company_API, prof);

    return result;
  }



  remove(del: any): Observable<any> {
    let result: Observable<Object>;

    result = this.http.post(this.companydelte_API,del);

    return result;
  }


}
