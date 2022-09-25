import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, of } from 'rxjs';
import { HeroesService } from '../heroes.service';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-form-edit',
  templateUrl: './form-edit.component.html',
  styleUrls: ['./form-edit.component.css']
})
export class FormEditComponent implements OnInit {

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

  constructor(private service: HeroesService, private router: Router) {
    const stateHero = this.router.getCurrentNavigation()?.extras.state;
    console.log(stateHero);
    this.hero.id = stateHero!['id'];
    this.hero.name = stateHero!['name'];
    this.hero.race = stateHero!['race'];
    this.hero.strength = stateHero!['strength'];
    this.hero.agility = stateHero!['agility'];
    this.hero.dexterity = stateHero!['dexterity'];
    this.hero.intelligence = stateHero!['intelligence'];
  }

  ngOnInit(): void {
  }

  updateHero() {
    this.service.updateHero(this.hero).pipe(
      catchError(error => {
        console.error(error.message);
        this.alertType = "danger";
        this.alertMessage = "Error updating hero.";
        setTimeout(() => {
          this.alertMessage = "";
        }, 5000);
        return of();
      }))
      .subscribe(res => {
        this.alertType = "success";
        this.alertMessage = "Hero updated successfully.";
        setTimeout(() => {
          this.alertMessage = "";
        }, 5000);
      });
  }

  deleteHero() {
    this.service.deleteHeroById(this.hero.id).pipe(
      catchError(error => {
        console.error(error.message);
        this.alertType = "danger";
        this.alertMessage = "Error deleting hero.";
        setTimeout(() => {
          this.alertMessage = "";
        }, 5000);
        return of();
      }))
      .subscribe(res => {
        this.alertType = "success";
        this.alertMessage = "Hero deleted successfully. Redirecting...";
        setTimeout(() => {
          this.alertMessage = "";
          this.router.navigateByUrl("/");
        }, 3000);
      });
  }

}
