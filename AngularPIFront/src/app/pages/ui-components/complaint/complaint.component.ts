import { Component, OnInit } from '@angular/core';
import { Complaint } from 'src/app/core/Complaint';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ComplaintService } from 'src/app/services/complaint.service';
import { ResponseComponent } from './response/response.component';




@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.scss']
})
export class ComplaintComponent implements OnInit{
  complaints: Complaint[];

  constructor(private complaintService: ComplaintService, private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.fetchComplaints();
    };

    openADDDialog(idComp: number): void {
      const dialogRef = this.dialog.open(ResponseComponent, {
        data: { idComp: idComp }
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.fetchComplaints();
      });
    }

 getComplaints() {
    this.complaintService.getAllComplaints().subscribe((src: Complaint[]) => {
      console.log(src);
      this.complaints = src;
    });
  }  

  deleteComplaint(idComp) {
    if (confirm('Voulez-vous supprimer cette complaint ?')) {
      this.complaintService.deleteComplaint(idComp).subscribe(() => {
        alert('Suppression réussie');
        window.location.reload();
      });
    }
  }
  fetchComplaints(): void {
    this.complaintService.getAllComplaints().subscribe(
      complaints => {
        this.complaints = complaints;
      },
      error => {
        console.error('Error fetching Complaints:', error);
      }
    );
  }
  }


     


