import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { Hero } from '../types/Hero';

@Component({
  selector: 'app-form-add',
  templateUrl: './form-add.component.html',
  styleUrls: ['./form-add.component.css']
})
export class FormAddComponent implements OnInit {

  valid: boolean;

  hero: Hero = {
    name: "",
    race: "",
    strength: 0,
    agility: 0,
    dexterity: 0,
    intelligence: 0
  }

  constructor(private http: HttpClient) { 
    this.valid = false;
   }

  ngOnInit(): void {
  }

  saveNewHero(form: any) {
    console.log(form);
  }

}
