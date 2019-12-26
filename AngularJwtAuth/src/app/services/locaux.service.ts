import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocauxService {


  public API = '//localhost:8080/application';

  public locaus_API = this.API + '/locaus';
  public locausd_API = this.API + '/locaus/';

  constructor(private http: HttpClient) {
  }


  getAll(): Observable<any> {
    return this.http.get(this.API + '/locaus');
  }

  get(id: string) {
    return this.http.get(this.locausd_API+id,{ responseType: 'json' });
  }


  save(niv: any,companyid:any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(
      this.locausd_API+companyid,
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

    result = this.http.post(this.locaus_API, prof);

    return result;
  }



  remove(delniv: any): Observable<any> {
    let result: Observable<Object>;

    result = this.http.delete(this.locausd_API+delniv);

    return result;
  }



}

