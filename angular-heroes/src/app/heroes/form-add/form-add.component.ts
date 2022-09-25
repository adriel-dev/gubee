import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { catchError, of } from 'rxjs';
import { HeroesService } from '../heroes.service';

import { Hero } from '../types/Hero';

@Component({
  selector: 'app-form-add',
  templateUrl: './form-add.component.html',
  styleUrls: ['./form-add.component.css']
})
export class FormAddComponent implements OnInit {

  alertMessage: string = '';
  alertType: string = 'success';

  @ViewChild("form") myForm!: NgForm;

  hero: Hero = {
    id: "",
    name: "",
    race: "",
    strength: 0,
    agility: 0,
    dexterity: 0,
    intelligence: 0
  }

  constructor(private service: HeroesService) {
  }

  ngOnInit(): void {
  }

  saveNewHero() {
    this.service.createHero(this.hero).pipe(
      catchError(error => {
        console.error(error.message);
        this.alertType = "danger";
        this.alertMessage = "Error saving hero.";
        setTimeout(() => {
          this.alertMessage = "";
        }, 5000);
        return of();
      }))
      .subscribe(res => {
        this.alertType = "success";
        this.alertMessage = "Hero saved successfully.";
        this.clearInputs();
        setTimeout(() => {
          this.alertMessage = "";
        }, 5000);
      });
  }

  clearInputs() {
    this.hero = {
      id: "",
      name: "",
      race: "",
      strength: 0,
      agility: 0,
      dexterity: 0,
      intelligence: 0
    };
    this.myForm.form.markAsPristine();
    this.myForm.form.markAsUntouched();
    this.myForm.form.updateValueAndValidity();
  }

}
