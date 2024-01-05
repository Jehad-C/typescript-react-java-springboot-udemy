export const oktaConfig = {
    clientId: '{CLIENT-ID}',
    issuer: 'https://example.com',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck:true,
}
