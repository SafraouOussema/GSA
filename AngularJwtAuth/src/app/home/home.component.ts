import { Component, OnInit } from '@angular/core';
import { scheduleData } from './data';
import {EventSettingsModel , DayService, WeekService, WorkWeekService,
  MonthService, AgendaService, ResizeService, DragAndDropService } from '@syncfusion/ej2-angular-schedule';

import { TokenStorageService } from '../auth/token-storage.service';
import { extend } from '@syncfusion/ej2-base';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [DayService, WeekService, WorkWeekService, MonthService, AgendaService, ResizeService, DragAndDropService]

})
export class HomeComponent implements OnInit {
  info: any;
  public selectedDate: Date = new Date(2019, 0, 10);
  public eventSettings: EventSettingsModel = { dataSource: <Object[]>extend([], scheduleData, null, true) };
  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
