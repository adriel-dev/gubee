import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormEditComponent } from './form-edit/form-edit.component';
import { CompareComponent } from './compare/compare.component';

@NgModule({
  declarations: [
  
    FormEditComponent,
       CompareComponent
  ],
  imports: [
    CommonModule
  ]
})
export class HeroesModule { }
