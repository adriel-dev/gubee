import { Component, Input, OnInit } from '@angular/core';
import { Hero } from '../types/Hero';
import { faChevronDown, faChevronUp, faEdit } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { state } from '@angular/animations';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css']
})
export class ListItemComponent implements OnInit {

  faChevronDown = faChevronDown;
  faChevronUp = faChevronUp;
  faEdit = faEdit;

  @Input() hero!: Hero;

  isCollapsed: boolean = true

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToEdit() {
    this.router.navigateByUrl('/edit', {state: this.hero});
  }

}