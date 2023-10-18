package org.goit.code;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.Optional;

public class HttpStatusImageDownloader {

    private HttpStatusImageDownloader(){}
    public static void downloadStatusImage(int code) throws NoSuchCodeException{
        Optional<String> response = HttpStatusChecker.getStatusImage(code);

        if(response.isPresent()) {
            Connection connection = Jsoup.connect(response.get()).ignoreContentType(true);
            try (InputStream is = connection.execute().bodyStream();
                 OutputStream out = new FileOutputStream("src/main/java/org/goit/images/imageForStatus" +
                         code + ".jpg")) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

    }
}
