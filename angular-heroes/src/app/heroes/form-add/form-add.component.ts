import { Component, OnInit } from '@angular/core';
import { HeroesService } from '../heroes.service';

import { Hero } from '../types/Hero';

@Component({
  selector: 'app-form-add',
  templateUrl: './form-add.component.html',
  styleUrls: ['./form-add.component.css']
})
export class FormAddComponent implements OnInit {

  valid: boolean;

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
    this.valid = false;
   }

  ngOnInit(): void {
  }

  saveNewHero() {
    console.log(this.service.createHero(this.hero).subscribe());
  }

}
