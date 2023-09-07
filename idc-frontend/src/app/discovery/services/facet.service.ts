import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { Observable, map, mergeMap, tap } from 'rxjs';
import { Facet } from 'src/app/dto/facet';

@Injectable({
    providedIn: 'root'
})
export class FacetService {

    constructor(private httpClient: HttpClient, private oidcSecurityService: OidcSecurityService) { }

    public getFacets(): Observable<Facet[]> {
        return this.oidcSecurityService.getIdToken()
            .pipe(mergeMap(token => {
                let headers = new HttpHeaders();
                headers = headers.append('Authorization', `Bearer ${token}`);
                return this.httpClient.get<Facet[]>('/api/v1/facets', { headers });
            }));
    }
}
