import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class DesinsectisationService {

  public API = '//localhost:8080/application';

  public calendars_API = this.API + '/desinsectisations/';
  public calendarsd_API = this.API + '/desinsectisations/';

  constructor(private http: HttpClient) {
  }


  get(id: string) {
    return this.http.get(this.calendars_API+id,{ responseType: 'json' });
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/desinsectisations');
  }

  save(niv: any, ficheid: any, locauxId: any,produitId:any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(
      this.calendarsd_API + ficheid + "/" + locauxId+"/"+produitId,
      niv,
      {
        headers:
          {
            'Content-Type': 'application/json'
          }
      }
    );

    return result;
  }


  update(prof: any): Observable<any> {
    let result: Observable<Object>;

    result = this.http.post(this.calendars_API, prof);

    return result;
  }


  remove(delniv: any): Observable<any> {
    let result: Observable<Object>;

    result = this.http.delete(this.calendarsd_API + delniv);

    return result;
  }


}
