package br.com.ivanzao.appdoaluno.service.model;

public class RetrieveRequest {

    public final String ra;
    public final String password;
    public final Boolean forceUpdate;

    public RetrieveRequest(String ra, String password, Boolean forceUpdate) {
        this.ra = ra;
        this.password = password;
        this.forceUpdate = forceUpdate;
    }

}