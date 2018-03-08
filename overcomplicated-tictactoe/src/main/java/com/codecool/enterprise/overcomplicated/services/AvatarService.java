package com.codecool.enterprise.overcomplicated.services;

import org.springframework.stereotype.Service;

@Service
public class AvatarService {

    public static final String AVATAR_SERVICE_URL = "http://localhost:60003/get-avatar";

    public String getAvatar() throws Exception {
        String avatar = JSONReader.readUrl(AVATAR_SERVICE_URL);
        return avatar;
    }

}
