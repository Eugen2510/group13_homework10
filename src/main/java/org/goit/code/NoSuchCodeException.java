package org.goit.code;

public class NoSuchCodeException extends Exception{
    public NoSuchCodeException (int code){
        super("There is not image for HTTP status " + code);
    }
}
