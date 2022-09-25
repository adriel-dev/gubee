import { Component, OnInit } from '@angular/core';

import { faAdd } from '@fortawesome/free-solid-svg-icons';
import { catchError, Observable, of, Subject } from 'rxjs';

import { HeroesService } from '../heroes.service';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  faAdd = faAdd;

  heroes$!: Observable<Hero[]>;
  error$ = new Subject<boolean>();
  errorMessage: string = '';

  constructor(private service: HeroesService) {
  }
  
  ngOnInit(): void {
    this.listAllHeroes();
  }
  
  listAllHeroes() {
    this.heroes$ = this.service.findAllHeroes()
    .pipe(
      catchError(error => {
        console.error(error.message);
        this.errorMessage = "Error fetching heroes.";
        this.error$.next(true);
        return of();
      })
    );
  }

}
