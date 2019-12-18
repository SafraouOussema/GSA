import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalendarService {


  public API = '//localhost:8080/application';

  public calendars_API = this.API + '/calendars';
  public calendarsd_API = this.API + '/calendars/';

  constructor(private http: HttpClient) {
  }


  getAll(): Observable<any> {
    return this.http.get(this.API + '/calendars');
  }

  save(niv: any): Observable<any> {
    let result: Observable<Object>;
    console.log(result);
    result = this.http.post(
      this.calendars_API,
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

    result = this.http.post(this.calendars_API, prof);

    return result;
  }



  remove(delniv: any): Observable<any> {
    let result: Observable<Object>;

    result = this.http.post(this.calendarsd_API, delniv);

    return result;
  }



}
