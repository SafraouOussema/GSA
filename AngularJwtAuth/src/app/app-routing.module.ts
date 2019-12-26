import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';
import {CompanyComponent} from './company/company.component'
import {CalendarComponent} from './calendar/calendar.component';
import {FicheComponent} from './fiche/fiche.component';
import {ProduitComponent} from './produit/produit.component';
import {LocauxComponent} from './locaux/locaux.component';
import {DesinsectisationComponent} from './desinsectisation/desinsectisation.component';
import {DeratisationComponent} from './deratisation/deratisation.component';
import {AficheComponent} from './afiche/afiche.component';
import {FichedetailComponent} from './fichedetail/fichedetail.component';
const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
      path:'calendar',
      component:CalendarComponent
    },
  {
    path:'produit',
    component:ProduitComponent
  },
  {
    path:'fiche',
    component:FicheComponent
  },{
    path: 'afichd/:fichid/:companyid',
    component: FichedetailComponent

  },
  {

    path: 'afich',
    component: AficheComponent
  },
    {
      path: 'company',
      component: CompanyComponent
    },
    {
      path: 'deratisation/:fichid/:companyid',
      component:DeratisationComponent
    },
    {
      path: 'desinsectisation/:fichid/:companyid',
      component:DesinsectisationComponent
    },
    {
      path: 'locaux/:id',
      component: LocauxComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'pm',
        component: PmComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
