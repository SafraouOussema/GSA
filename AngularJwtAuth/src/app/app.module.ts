import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {DataTableModule} from "angular-6-datatable";



import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { PmComponent } from './pm/pm.component';
import { DatePickerModule} from '@syncfusion/ej2-angular-calendars';

import { httpInterceptorProviders } from './auth/auth-interceptor';
import {ScheduleModule} from '@syncfusion/ej2-angular-schedule';
import { CompanyComponent } from './company/company.component';
import {CompanyService} from './services/company.service';
import { CalendarComponent } from './calendar/calendar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    PmComponent,
    CompanyComponent,
    CalendarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ScheduleModule,
    DatePickerModule,
    DataTableModule



  ],
  providers: [httpInterceptorProviders,CompanyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
