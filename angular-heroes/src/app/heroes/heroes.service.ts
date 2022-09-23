import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hero } from './types/Hero';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ComparationResult } from './types/ComparationResult';

@Injectable({
  providedIn: 'root'
})
export class HeroesService {

  private readonly URL: string = `${environment.API}/heroes`;

  constructor(private http: HttpClient) { }

  findAllHeroes() {
    const findAllUrl = `${this.URL}/all`;
    return this.http.get<Hero[]>(findAllUrl);
  }

  findHeroByName(name: string): Observable<Hero> {
    const findByNameUrl = `${this.URL}?name=${name}`;
    return this.http.get<Hero>(findByNameUrl);
  }

  createHero(hero: Hero) {
    return this.http.post(this.URL, hero);
  }

  updateHero(hero: Hero) {
    const id = hero.id;
    const urlUpdate = `${this.URL}/${id}`;
    return this.http.put(urlUpdate, hero);
  }

  deleteHeroById(id: string) {
    const urlDelete = `${this.URL}/${id}`;
    return this.http.delete(urlDelete);
  }

  compareHeroes(id1: string, id2: string) {
    const urlCompare = `${this.URL}/compare/${id1}/${id2}`;
    return this.http.get<ComparationResult>(urlCompare);
  }

}