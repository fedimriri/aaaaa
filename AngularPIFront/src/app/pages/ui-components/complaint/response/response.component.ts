import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Response } from 'src/app/core/Response';
import { ResponseService } from 'src/app/services/response.service';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.scss']
})
export class ResponseComponent {

  description: string;
  response: Response = new Response(); 
  constructor(
    private _service: ResponseService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {}
  addResponse() {
    this.response.responseDate = new Date();
    this._service.createResponse(this.response).subscribe(() => {
      const config = new MatSnackBarConfig();
      config.duration = 2000;
      this.snackBar.open('Le response a été envoyer avec succès', 'Fermer', config);
      this.router.navigate(['/dashboard']);
    });
  }
}
