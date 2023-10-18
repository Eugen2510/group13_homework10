package org.goit.code;

import java.util.Scanner;

public class HttpImageStatusCli {
    private static final String SUCCESS_DOWNLOAD = "Picture for status has been uploaded";
    private static final String NOT_VALID_INPUT = "Please enter valid number or 'e' for exit";
    private static final String WELCOME_MESSAGE = "Enter HTTP status code, press 'e' for exit";

    private HttpImageStatusCli(){}
    public static void askStatus() {
        try (Scanner scanner = new Scanner(System.in)){
            String outputMessage = WELCOME_MESSAGE;

            while (true){
                System.out.println(outputMessage);
                String input = scanner.nextLine();
                if (input.equals("e")){
                    break;
                }
                try {
                    int statusCode = Integer.parseInt(input);
                    HttpStatusImageDownloader.downloadStatusImage(statusCode);
                    outputMessage = SUCCESS_DOWNLOAD + '\n' + WELCOME_MESSAGE;
                }catch (NumberFormatException e){
                    outputMessage = NOT_VALID_INPUT;
                }catch (NoSuchCodeException e){
                    System.out.println(e.getMessage());
                    outputMessage = NOT_VALID_INPUT;
                }
            }

        }
    }
}
