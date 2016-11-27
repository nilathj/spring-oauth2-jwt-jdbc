# Spring Boot OAuth 2 with JWT authentication and JDBC client store

This is based on the original project from:
http://www.hascode.com/2016/03/setting-up-an-oauth2-authorization-server-and-resource-provider-with-spring-boot/
Please refer to: **2016 Micha Kops / hasCode.com**


## Enhanced functionality
Added JWT based authorization, OpenAPI access token enrichment, JDBC based client store.

Pre-requisits:
Createa Mysql database jdbc:mysql://localhost:3306/identity with user name root and blank password.
This is configured in DatabaseConfig.

1. Start up com.hascode.tutorial.Oauth2AuthorizationServerApplication as a spring boot application.

2. POST to http://localhost:9000/login with Content-Type application/json and body {"username":"greenrabbit948", "password":"celeste"}
A JWT will be returned in the header, with a success 200.

3. GET to http://localhost:9000/oauth/authorize?redirect_uri=http://localhost:8080/&client_id=ING_BANK&response_type=code 
with a header a Authorization Bearer jwt-token
You will be redirected to localhost:8080 with an authorization code.

4. Use the authorization code 
POST http://localhost:9000/oauth/token?redirect_uri=http://localhost:8080/&grant_type=authorization_code&code=YOUR_AUTH_CODE_FROM_ABOVE
5. You will get an access token and an id_token in a json response
```
{
"access_token": "950d44c9-54b5-445f-8e82-02995d2468a0",
"token_type": "bearer",
"expires_in": 43199,
"scope": "openid",
"id_token": "ad9f151c-1296-4dc4-976b-3eaed9eb08dd"
}      
```       


## Original Doco:

Examples how to set up an OAuth2 identity server and resource provider within a few minutes using [Spring Boot] and Maven.

Please feel free to take a look at [my blog] for the full tutorial.

## Running the Identity Server

Using Maven

```
cd identity-server && mvn spring-boot:run
```

## Running the Resource Provider

Using Maven

```
cd resource-provider && mvn spring-boot:run
```

## Requesting a Token

Using Curl

```
curl -XPOST -k -vi foo:foosecret@localhost:9000/hascode/oauth/token \
-d grant_type=password -d client_id=foo -d client_secret=abc123 \
-d redirect_uri=http://www.hascode.com -d username=bar -d password=barsecret
```

## Accessing the secured Resource

```
TOKEN = 'xxxxxxx'
curl -vi -H "Authorization: Bearer $TOKEN" http://localhost:9001/resource/
```

---
