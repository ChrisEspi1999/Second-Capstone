package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.UserAccount;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class UserAccountService implements UserAccountServ{

    private RestTemplate restTemplate = new RestTemplate();
    private String BASE_URL;
    private AuthenticatedUser currentUser;

    public UserAccountService(String url) {
        this.restTemplate = new RestTemplate();
        this.BASE_URL = url;
    }

    @Override
    public Balance getBalance(AuthenticatedUser authenticatedUser) {
        HttpEntity entity = makeEntity(authenticatedUser);
        Balance balance = null;
        try {
            balance = restTemplate.exchange(BASE_URL + "balance", HttpMethod.GET, entity, Balance.class).getBody();
            System.out.println("Your balance is $" + balance);
        }catch (RestClientException | NullPointerException e){
            System.out.println();
        }
        return balance;
    }

    @Override
    public UserAccount getAccountWithUserId(AuthenticatedUser authenticatedUser, int userId) {
        return null;
    }

    @Override
    public UserAccount getAccountWithAccountId(AuthenticatedUser authenticatedUser, int accountId) {
        return null;
    }

    private HttpEntity makeEntity(AuthenticatedUser authenticatedUser) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(authenticatedUser.getToken());
        HttpEntity entity = new HttpEntity(httpHeaders);
        return entity;
    }
}
