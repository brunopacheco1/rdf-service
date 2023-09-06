import { Component } from '@angular/core';
import { LoginResponse, OidcSecurityService } from 'angular-auth-oidc-client';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {

    title = 'idc-frontend';

    isAuthenticated: boolean = false;
    userData: any;


    constructor(private oidcSecurityService: OidcSecurityService) { }

    ngOnInit() {
        this.oidcSecurityService
            .checkAuth()
            .subscribe((loginResponse: LoginResponse) => {
                const { isAuthenticated, userData } = loginResponse;
                this.isAuthenticated = isAuthenticated;
                this.userData = userData;
            });
    }

    login() {
        this.oidcSecurityService.authorize();
    }

    logout() {
        this.oidcSecurityService
            .logoff()
            .subscribe((result) => console.log(result));
    }

    userName() {
        return this.userData?.name;
    }
}
