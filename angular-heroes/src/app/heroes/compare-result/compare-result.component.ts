import { Component, Input, OnInit } from '@angular/core';
import { ComparationResult } from '../types/ComparationResult';
import { Hero } from '../types/Hero';

@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.css']
})
export class CompareResultComponent implements OnInit {

  @Input() heroes: Hero[] = [];
  @Input() comparationResult: ComparationResult = {
    id1: "",
    id2: "",
    strength_diff: 0,
    agility_diff: 0,
    dexterity_diff: 0,
    intelligence_diff: 0
  };

  constructor() { }

  ngOnInit(): void {
  }

}
