import { Routes, RouterModule } from '@angular/router';

import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import { SearchDataComponent } from './components/search-data/search-data.component'
import { AddDataComponent } from './components/add-data/add-data.component'

const appRoutes: Routes = [
    { path: 'upload', component: UploadFilesComponent },
    { path: 'search', component: SearchDataComponent },
    { path: 'add', component: AddDataComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);