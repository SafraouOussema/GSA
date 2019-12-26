import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FicheService {


  public API = '//localhost:8080/application';

  public calendars_API = this.API + '/fiches/';
  public calendarsd_API = this.API + '/fiches/';

  constructor(private http: HttpClient) {
  }


  getAll(): Observable<any> {
    return this.http.get(this.API + '/fiches');
  }

  save(niv: any, userid: any, companyid: any,calendarId:any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(
      this.calendarsd_API + userid + "/" + companyid+"/"+calendarId,
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

