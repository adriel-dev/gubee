import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeroesService } from '../heroes.service';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-form-edit',
  templateUrl: './form-edit.component.html',
  styleUrls: ['./form-edit.component.css']
})
export class FormEditComponent implements OnInit {

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
    this.service.updateHero(this.hero).subscribe(res => console.log(res));
  }

  deleteHero() {
    this.service.deleteHeroById(this.hero.id).subscribe(res => console.log(res));
  }

}
