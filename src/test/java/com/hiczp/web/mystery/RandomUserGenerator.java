package com.hiczp.web.mystery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hiczp.web.mystery.entity.Account;
import com.hiczp.web.mystery.repository.AccountRepository;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czp on 17-7-18.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RandomUserGenerator {
    private static final int GENERATE_COUNT = 50;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void generateUser() {
        try (CloseableHttpClient closeableHttpClient = HttpClients.createMinimal()) {
            JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(closeableHttpClient.execute(
                    new HttpGet("https://randomuser.me/api/?results=" + GENERATE_COUNT)
                    ).getEntity()
            ));
            JSONArray results = jsonObject.getJSONArray("results");
            List<Account> accounts = new ArrayList<>(GENERATE_COUNT);
            results.parallelStream().forEach(user -> {
                JSONObject userObject = (JSONObject) user;
                Account account = new Account();
                account.setAvatar(userObject.getJSONObject("picture").getString("large"));
                account.setNick(userObject.getJSONObject("name").getString("first"));
                JSONObject login = userObject.getJSONObject("login");
                account.setPassword(new BCryptPasswordEncoder().encode(login.getString("password")));
                account.setUsername(login.getString("username"));
                accounts.add(account);
            });
            accountRepository.save(accounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
