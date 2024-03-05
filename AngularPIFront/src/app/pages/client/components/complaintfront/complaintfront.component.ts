import { Component, OnInit } from '@angular/core';
import { ComplaintService } from 'src/app/services/complaint.service';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Complaint, TypeRec } from 'src/app/core/Complaint';

@Component({
  selector: 'app-complaintfront',
  templateUrl: './complaintfront.component.html',
  styleUrls: ['./complaintfront.component.scss']
})
export class ComplaintfrontComponent implements OnInit {

  complaint: Complaint = new Complaint(); // Initialisation de la variable complaint
  complaintTypes: string[] = Object.values(TypeRec);
  constructor(
    private _service: ComplaintService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit(): void {}

  addComplaint() {
    this.complaint.dateComplaint = new Date();
    this._service.createComplaint(this.complaint).subscribe(() => {
      const config = new MatSnackBarConfig();
      config.duration = 2000;
      this.snackBar.open('La complaint a été ajoutée avec succès', 'Fermer', config);
      this.router.navigate(['/home/complaint']);
    });
  }
}
