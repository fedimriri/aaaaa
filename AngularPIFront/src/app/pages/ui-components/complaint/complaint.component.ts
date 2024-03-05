import { Component, OnInit, ViewChild } from '@angular/core';
import { Complaint, TypeRec } from 'src/app/core/Complaint';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ComplaintService } from 'src/app/services/complaint.service';
import { ResponseComponent } from './response/response.component';
import { MatTableDataSource } from '@angular/material/table';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';




@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.scss']
})
export class ComplaintComponent implements OnInit{
  complaints: Complaint[]=[];
filterShearch=''
@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private complaintService: ComplaintService, private router: Router, public dialog: MatDialog,private fb: FormBuilder) { }

  ngOnInit() {
    this.fetchComplaints();
    this.dataSource.paginator = this.paginator;

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
    complaintForm:any

    initForm(comp:Complaint): void {
      console.log(comp);
      
      this.complaintForm = this.fb.group({
        idComp: comp.idComp,
        typeRec: comp.typeRec,
        description: [comp.description, Validators.required],
        dateComplaint: [new Date(), Validators.required],
        name: [comp.name, Validators.required],
        lastname: [comp.lastname, Validators.required],
        email: [comp.email, [Validators.required, Validators.email]],
        status: [comp.status, Validators.required]
      });
    }
  

 getComplaints() {
    this.complaintService.getAllComplaints().subscribe((src: Complaint[]) => {
      console.log(src);
      this.complaints = src;
    });
  }  
  displayedColumns: string[] = [
    'description',	'type','dateComplaint' ,	'name',	'lastname',	'email',	'status',	'idComp'
  ];
  dataSource = null

  applyFilter() {
    
    this.dataSource.filter = this.filterShearch.trim().toLowerCase();
  }
  deleteComplaint(idComp) {
    if (confirm('Voulez-vous supprimer cette complaint ?')) {
      this.complaintService.deleteComplaint(idComp).subscribe(() => {
        alert('Suppression réussie');
        window.location.reload();
      });
    }
  }

  saveComplaint(){
    this.complaintService.updateComplaint(this.complaintForm.value.idComp,this.complaintForm.value).subscribe(
      res => {
        console.log(res);
        location.reload()
alert('updated sucsessfully')
      },
      error => {
        console.error('Error updating Complaints:', error);
      }
    );
  }
  fetchComplaints(): void {
    this.complaintService.getAllComplaints().subscribe(
      complaints => {
        console.log(complaints[0]);
        
        this.complaints = complaints;
        this.dataSource = new MatTableDataSource(complaints);
        this.dataSource.paginator = this.paginator;

      },
      error => {
        console.error('Error fetching Complaints:', error);
      }
    );
  }


 





  
  }


     


