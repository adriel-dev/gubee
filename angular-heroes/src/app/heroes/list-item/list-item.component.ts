import { Component, Input, OnInit } from '@angular/core';
import { Hero } from '../types/Hero';
import { faChevronDown, faChevronUp, faEdit } from '@fortawesome/free-solid-svg-icons';

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

  constructor() { }

  ngOnInit(): void {
  }

}