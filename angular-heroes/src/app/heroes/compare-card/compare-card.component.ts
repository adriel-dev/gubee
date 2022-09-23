import { Component, Input, OnInit } from '@angular/core';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-compare-card',
  templateUrl: './compare-card.component.html',
  styleUrls: ['./compare-card.component.css']
})
export class CompareCardComponent implements OnInit {

  @Input() hero: Hero = {
    id: "",
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

}
