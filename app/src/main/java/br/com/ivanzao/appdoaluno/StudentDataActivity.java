package br.com.ivanzao.appdoaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import br.com.ivanzao.appdoaluno.adapter.StudentCoursesAdapter;
import br.com.ivanzao.appdoaluno.student.StudentData;

public class StudentDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);

        Intent intent = this.getIntent();

        String studentDataString = intent.getStringExtra("studentData");
        StudentData studentData;

        try {
            studentData = new ObjectMapper().readValue(studentDataString, StudentData.class);

            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(new StudentCoursesAdapter(this, studentData.getCourses()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}