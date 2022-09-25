import { Component, OnInit } from '@angular/core';

import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { catchError, of } from 'rxjs';

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
  errorMessage: string = '';
  alertType: string = 'danger'

  private secondRequest = false;
  comparationResult?: ComparationResult = undefined;

  heroesToCompare: Hero[] = [];

  constructor(private service: HeroesService) { }

  ngOnInit(): void {
  }

  searchForHero(name: string) {
    this.service.findHeroByName(name)
    .pipe(
      catchError(error => {
        console.error(error.message);
        this.errorMessage = "Error fetching hero.";
        setTimeout(() => {
          this.errorMessage = "";
        }, 5000);
        return of();
      }))
      .subscribe(res => {
        if (res != null) {
        if (!this.secondRequest) this.heroesToCompare[0] = res;
        else this.heroesToCompare[1] = res;
        this.secondRequest = !this.secondRequest;
      }else {
        this.errorMessage = 'Hero not found.';
        setTimeout(() => {
          this.errorMessage = "";
        }, 3000);
      }
    }
    );
  }

  compareHeroes() {
    let id1: string = this.heroesToCompare[0].id;
    let id2: string = this.heroesToCompare[1].id;
    return this.service.compareHeroes(id1, id2)
    .pipe(
      catchError(error => {
        console.error(error.message);
        this.errorMessage = "Error comparing heroes.";
        setTimeout(() => {
          this.errorMessage = "";
        }, 5000);
        return of();
      })
    ).subscribe(res => {
      this.comparationResult = res;
    });
  }

  clearArray() {
    this.heroesToCompare = [];
    this.secondRequest = false;
    this.comparationResult = undefined;
  }

}
