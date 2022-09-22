import { Component, OnInit } from '@angular/core';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-form-edit',
  templateUrl: './form-edit.component.html',
  styleUrls: ['./form-edit.component.css']
})
export class FormEditComponent implements OnInit {

  hero: Hero = {
    name: "",
    race: "",
    strength: 0,
    agility: 0,
    dexterity: 0,
    intelligence: 0
  }

  constructor() { }

  ngOnInit(): void {
  }

  updateHero() {
    
  }

}
