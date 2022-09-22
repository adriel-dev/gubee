import { Component, OnInit } from '@angular/core';

import { faAdd } from '@fortawesome/free-solid-svg-icons';

import { HeroesService } from '../heroes.service';
import { Hero } from '../types/Hero';
import heroesData from './data.json';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  faAdd = faAdd;

  heroes: Hero[] = [];

  constructor(private service: HeroesService) {
  }
  
  ngOnInit(): void {
    this.listAllHeroesJson();
  }
  
  listAllHeroes() {
    this.service.findAllHeroes().subscribe(response => this.heroes = response);
  }

  listAllHeroesJson () {
    this.heroes = heroesData;
  }

}
