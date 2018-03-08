package com.codecool.enterprise.overcomplicated.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Service
public class FunFactService {

    private static final String FUNFACT_SERVICE_URL = "http://localhost:60001/get-funfact";

    public String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URLConnection connection = new URL(urlString).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public String getFunfact() throws Exception {
        String funfact = readUrl(FUNFACT_SERVICE_URL);
        return funfact;
    }

}
