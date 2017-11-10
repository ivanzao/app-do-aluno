package br.com.ivanzao.appdoaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import br.com.ivanzao.appdoaluno.adapter.StudentCoursesAdapter;
import br.com.ivanzao.appdoaluno.student.Program;
import br.com.ivanzao.appdoaluno.student.StudentData;

public class StudentDataActivity extends AppCompatActivity {

    private TextView txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);

        txtBack = (TextView) findViewById(R.id.back);
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = this.getIntent();

        String studentDataString = intent.getStringExtra("studentData");
        StudentData studentData;

        try {
            studentData = new ObjectMapper().readValue(studentDataString, StudentData.class);

            TextView txtName = (TextView) findViewById(R.id.name);
            txtName.setText(getTxtNameValue(studentData));

            TextView txtProgram = (TextView) findViewById(R.id.program);
            txtProgram.setText(getTxtProgramValue(studentData));

            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(new StudentCoursesAdapter(this, studentData.getCourses()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
    }

    private String getTxtNameValue(StudentData studentData) {
        return studentData.getName() + " - " + studentData.getRa();
    }

    private String getTxtProgramValue(StudentData studentData) {
        Program program = studentData.getProgram();
        return program.getName() + " - " + program.getPeriod() + "º Período";
    }

}