package org.goit.code;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Optional;

public class HttpStatusChecker {
    private static final String URL = "https://http.cat/status/";

    private HttpStatusChecker(){}
    public static Optional<String> getStatusImage(int code) throws NoSuchCodeException{
        Optional<String> response;
        try {
            Connection connect = Jsoup.connect(URL + code);
            connect.execute();
            response = Optional.of("https://http.cat/images/" + code + ".jpg");
        }catch (IOException e){
            throw new NoSuchCodeException(code);
        }

        return response;
    }

}
