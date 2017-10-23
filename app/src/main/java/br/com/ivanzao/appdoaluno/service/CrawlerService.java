package br.com.ivanzao.appdoaluno.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import br.com.ivanzao.appdoaluno.service.exception.CrawlerConnectionException;
import br.com.ivanzao.appdoaluno.service.model.RetrieveRequest;
import br.com.ivanzao.appdoaluno.student.StudentData;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CrawlerService {

    private static final CrawlerService INSTANCE = new CrawlerService();

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final String HOST = "http://192.168.15.17:8080";
    private static final String RETRIEVE_ENDPOINT = "/v1/student/retrieveData";

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    private CrawlerService() {
    }

    public static CrawlerService getInstance() {
        return INSTANCE;
    }

    public StudentData retrieveStudentData(RetrieveRequest data)
            throws CrawlerConnectionException, IOException {
        RequestBody requestBody = RequestBody.create(JSON, mapper.writeValueAsString(data));
        Request request = new Request.Builder()
                .url(HOST + RETRIEVE_ENDPOINT)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        int responseCode = response.code();
        String responseBody = response.body().string();

        if (responseCode != 200) {
            CrawlerErrorResponse errorResponse = mapper.readValue(responseBody,
                    CrawlerErrorResponse.class);
            throw new CrawlerConnectionException(responseCode, errorResponse.getError());
        }

        return mapper.readValue(responseBody, StudentData.class);
    }

    private static class CrawlerErrorResponse {

        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

    }
}