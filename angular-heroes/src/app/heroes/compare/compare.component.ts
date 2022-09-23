import { Component, OnInit } from '@angular/core';

import { faSearch } from '@fortawesome/free-solid-svg-icons';

import { HeroesService } from '../heroes.service';
import { ComparationResult } from '../types/ComparationResult';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.css', '../../app.component.css']
})
export class CompareComponent implements OnInit {

  faSearch = faSearch;

  private secondRequest = false;
  comparationResult?: ComparationResult = undefined;

  heroesToCompare: Hero[] = [];

  constructor(private service: HeroesService) { }

  ngOnInit(): void {
  }

  searchForHero(name: string) {
    this.service.findHeroByName(name).subscribe(res => {
      if (res != null) {
        if (!this.secondRequest) this.heroesToCompare[0] = res;
        else this.heroesToCompare[1] = res;
        this.secondRequest = !this.secondRequest;
      }
    });
  }

  compareHeroes() {
    let id1: string = this.heroesToCompare[0].id;
    let id2: string = this.heroesToCompare[1].id;
    console.log("compare click")
    return this.service.compareHeroes(id1, id2).subscribe(res => {
      this.comparationResult = res
    });
  }

  clearArray() {
    this.heroesToCompare = [];
    this.secondRequest = false;
    this.comparationResult = undefined;
  }

}
