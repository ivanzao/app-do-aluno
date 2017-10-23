package br.com.ivanzao.appdoaluno;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import br.com.ivanzao.appdoaluno.service.CrawlerService;
import br.com.ivanzao.appdoaluno.service.model.RetrieveRequest;
import br.com.ivanzao.appdoaluno.student.StudentData;
import br.com.ivanzao.appdoaluno.util.ViewUtils;

public class MainActivity extends AppCompatActivity {

    private EditText txtRa;
    private EditText txtPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRa = (EditText) findViewById(R.id.ra);
        txtPassword = (EditText) findViewById(R.id.password);
        btnSubmit = (Button) findViewById(R.id.submit);

        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                submitLogin();
            }
        });
    }

    private void submitLogin() {
        String ra = txtRa.getText().toString();
        String password = txtPassword.getText().toString();

        if (ra.isEmpty()) {
            ViewUtils.showOkAlert("RA inválido", "Por favor insira um número de RA.", this);
            return;
        }

        if (password.isEmpty()) {
            ViewUtils.showOkAlert("Senha inválida", "Por favor insira sua senha.", this);
            return;
        }

        new RetrieveStudentDataTask(this).execute(new RetrieveRequest(ra, password, false));
    }

    private class RetrieveStudentDataTask extends AsyncTask<RetrieveRequest, Integer, StudentData> {

        private final CrawlerService crawler = CrawlerService.getInstance();
        private final Context context;

        private ProgressDialog dialog;
        private String errorMessage;

        RetrieveStudentDataTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(MainActivity.this, "Por favor Aguarde...",
                    "Obtendo os dados do aluno...");
        }

        @Override
        protected StudentData doInBackground(RetrieveRequest... params) {
            StudentData data = null;
            try {
                data = crawler.retrieveStudentData(params[0]);
            } catch (Exception e) {
                errorMessage = e.getMessage();
            }

            return data;
        }

        @Override
        protected void onPostExecute(StudentData response) {
            if (response != null) {
                ViewUtils.showOkAlert("Login com sucesso",
                        response.getName() + " - " + response.getProgram().getName(),
                        context);
            } else {
                ViewUtils.showOkAlert("Deu ruim ):",
                        errorMessage,
                        context);
            }

            dialog.dismiss();
        }
    }

}