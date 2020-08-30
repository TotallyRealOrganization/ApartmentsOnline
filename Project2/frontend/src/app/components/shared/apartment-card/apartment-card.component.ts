import { Component, OnInit, Input, Inject } from '@angular/core';
import { Apartment } from 'src/app/models/Apartment';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-apartment-card',
  templateUrl: './apartment-card.component.html',
  styleUrls: ['./apartment-card.component.css']
})
export class ApartmentCardComponent implements OnInit {

  @Input() apartment: Apartment

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openDetails() {
    this.dialog.open(DetailsDialog, {
      data: this.apartment
    })
  }

}

@Component({
  selector: 'apartment-details-dialog',
  templateUrl: './apartment-details.component.html',
})
export class DetailsDialog {
  constructor(@Inject(MAT_DIALOG_DATA) public data: Apartment) {}
}
