package com.hiczp.web.mystery.model;

import com.hiczp.web.mystery.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by czp on 17-7-7.
 */
public class MysteryUser extends User {
    private long id;

    private String username;

    private String password;

    private String nick;

    private String avatar;

    private int point = 0;

    private String gameFlag;

    public MysteryUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Account account) {
        super(username, password, authorities);
        this.id = account.getId();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.nick = account.getNick();
        this.avatar = account.getAvatar();
        this.point = account.getPoint();
        this.gameFlag = account.getGameFlag();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getGameFlag() {
        return gameFlag;
    }

    public void setGameFlag(String gameFlag) {
        this.gameFlag = gameFlag;
    }
}
