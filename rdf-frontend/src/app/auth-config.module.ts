import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { AuthModule } from 'angular-auth-oidc-client';

@NgModule({
    imports: [
        HttpClientModule,
        AuthModule.forRoot({
            config: {
                authority: 'https://dev-57878581.okta.com/oauth2/default',
                redirectUrl: window.location.origin,
                postLogoutRedirectUri: window.location.origin,
                clientId: '0oab3hsuxkIQfGLw05d7',
                scope: 'openid profile offline_access',
                responseType: 'code',
                silentRenew: true,
                useRefreshToken: true,
                renewTimeBeforeTokenExpiresInSeconds: 30,
            }
        })],
    exports: [AuthModule],
    providers: [
    ],
})
export class AuthConfigModule { }
