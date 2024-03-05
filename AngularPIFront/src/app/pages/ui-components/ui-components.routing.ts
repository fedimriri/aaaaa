import { Routes } from '@angular/router';

// ui
import { CompanyComponent } from './company/company.component';
import { UserComponent } from './user/user.component';
import { DefenseComponent } from './defense/defense.component';
import { TaskComponent } from './task/task.component';
import { ComplaintComponent } from './complaint/complaint.component';
import { InternshipComponent } from './internship/internship.component';
import { EventComponent } from './event/event.component';
import { DocumetsComponent } from './documets/documets.component';
import { AddTaskComponent } from './task/add-task/add-task.component';

export const UiComponentsRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'defense',
        component: DefenseComponent,
      },
      {
        path: 'company',
        component: CompanyComponent,
      },
      {
        path: 'task',
        component: TaskComponent,
      },
      {
        path: 'complaint',
        component: ComplaintComponent,
      },
      {
        path: 'internship',
        component: InternshipComponent,
      },
      {
        path: 'event',
        component: EventComponent,
      },
      {
        path: 'user',
        component: UserComponent,
      },
      {
        path: 'interview',
        component: InternshipComponent,
      },
      {
        path: 'documents',
        component: DocumetsComponent,
      },
      {
      path: 'add-task',
      component: AddTaskComponent,
      },

    ],
  },
];
