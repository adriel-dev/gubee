import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ListComponent } from './heroes/list/list.component';
import { ListItemComponent } from './heroes/list-item/list-item.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HeroesService } from './heroes/heroes.service';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormAddComponent } from './heroes/form-add/form-add.component';
import { CompareComponent } from './heroes/compare/compare.component';
import { FormEditComponent } from './heroes/form-edit/form-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    ListItemComponent,
    NavbarComponent,
    FormAddComponent,
    FormEditComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'list', component: ListComponent},
      {path: 'new', component: FormAddComponent},
      {path: 'edit', component: FormEditComponent},
      {path: 'compare', component: CompareComponent},
      {path: '', redirectTo: '/list', pathMatch: 'full'}
    ]),
    FontAwesomeModule,
    FormsModule
  ],
  providers: [HeroesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
