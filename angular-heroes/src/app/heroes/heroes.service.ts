import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hero } from './types/Hero';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HeroesService {

  private readonly URL: string = `${environment.API}/heroes`;

  constructor(private http: HttpClient) { }

  findAllHeroes(): Observable<Hero[]> {
    const findAllUrl = `${this.URL}/all`;
    return this.http.get<Hero[]>(findAllUrl);
  }

  findHeroById(id: string) {
    
  }

  findHeroByName(name: string) {

  }

  createHero(hero: Hero) {

  }

  updateHero(id: string, hero: Hero) {

  }

  deleteHeroById(id: string) {

  }

  compareHeroes(id1: string, id2: string) {

  }

}