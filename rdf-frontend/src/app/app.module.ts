import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthConfigModule } from './auth-config.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { HttpClientModule } from '@angular/common/http';

import { FacetsViewComponent } from './discovery/facets-view/facets-view.component';
import { SearchViewComponent } from './discovery/search-view/search-view.component';
import { DatasetsViewComponent } from './discovery/datasets-view/datasets-view.component';

@NgModule({
    declarations: [
        AppComponent,
        SearchViewComponent,
        DatasetsViewComponent,
        FacetsViewComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        AuthConfigModule,
        BrowserAnimationsModule,
        MatIconModule,
        MatButtonModule,
        MatToolbarModule,
        HttpClientModule,
        MatSelectModule,
        MatInputModule,
        MatRadioModule,
    ],
    providers: [
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
