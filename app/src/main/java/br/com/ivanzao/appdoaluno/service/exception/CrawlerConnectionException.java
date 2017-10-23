package br.com.ivanzao.appdoaluno.service.exception;

public class CrawlerConnectionException extends Exception {

    private int code;

    public CrawlerConnectionException(int code, String message) {
        super(message);

        this.code = code;
    }

    public int getCode() {
        return code;
    }

}