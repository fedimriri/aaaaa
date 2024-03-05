import { ComplaintComponent } from './../ui-components/complaint/complaint.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { ClientRoutingModule } from './client-routing.module';
import { MainComponent } from './main/main.component';
import { VideoComponent } from './video/video.component';
// import { FooterComponent } from './footer/footer.component';
import { CompanyfrontComponent } from './components/companyfront/companyfront.component';
import { ComplaintfrontComponent } from './components/complaintfront/complaintfront.component';
import { EventfrontComponent } from './components/eventfront/eventfront.component';
import { FooterComponent } from './footer/footer.component';

import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatListModule } from '@angular/material/list';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';


@NgModule({
  declarations: [
    NavbarComponent,
    MainComponent,
    VideoComponent,
    CompanyfrontComponent,
    ComplaintfrontComponent,
    EventfrontComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
     ClientRoutingModule,
      MatDialogModule,
      FormsModule,
      MatInputModule,
      MatIconModule,
      MatPaginatorModule,
      MatOptionModule,
      MatSelectModule,
      MatListModule,
      MatAutocompleteModule,
      ReactiveFormsModule,
      MatSnackBarModule,
  ],
})
export class ClientModule {}
