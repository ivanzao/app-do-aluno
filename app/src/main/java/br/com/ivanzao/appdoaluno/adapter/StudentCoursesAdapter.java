package br.com.ivanzao.appdoaluno.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.ivanzao.appdoaluno.R;
import br.com.ivanzao.appdoaluno.student.CourseData;
import br.com.ivanzao.appdoaluno.student.Grade;

public class StudentCoursesAdapter extends ArrayAdapter<CourseData> {

    private final Context context;
    private final ArrayList<CourseData> elements;

    public StudentCoursesAdapter(@NonNull Context context, @NonNull List<CourseData> objects) {
        super(context, R.layout.data_card, objects);

        this.context = context;
        this.elements = (ArrayList<CourseData>) objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CourseData course = elements.get(position);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dataCard = inflater.inflate(R.layout.data_card, parent, false);

        TextView txtSubject = dataCard.findViewById(R.id.title);
        txtSubject.setText(course.getName());

        populateAverages(dataCard, course);
        populateAbsences(dataCard, course);
        populateGrades(dataCard, course.getGrades());
        populateEdpGrades(dataCard, course.getEdpGrades());

        return dataCard;
    }

    private void populateAverages(View dataCard, CourseData course) {
        String partialAverage = (course.getPartialAverage() != null) ?
                String.valueOf(course.getPartialAverage()) :
                "Não consta";
        TextView txtPartialAverage = dataCard.findViewById(R.id.partialAverage);
        txtPartialAverage.setText(partialAverage);

        String finalAverage = (course.getFinalAverage() != null) ?
                String.valueOf(course.getFinalAverage()) :
                "Não consta";
        TextView txtFinalAverage = dataCard.findViewById(R.id.finalAverage);
        txtFinalAverage.setText(finalAverage);
    }

    private void populateAbsences(View dataCard, CourseData course) {
        String absences = (course.getAbsences() != null) ?
                String.valueOf(course.getAbsences()) :
                "Não consta";
        TextView txtAbsences = dataCard.findViewById(R.id.abscences);
        txtAbsences.setText(absences);

        String absencesLimit = (course.getAbsencesLimit() != null) ?
                String.valueOf(course.getAbsencesLimit()) :
                "Não consta";
        TextView txtAbsencesLimit = dataCard.findViewById(R.id.abscencesLimit);
        txtAbsencesLimit.setText(absencesLimit);
    }

    private void populateGrades(View dataCard, List<Grade> grades) {
        if (grades != null && grades.size() > 0) {
            dataCard.findViewById(R.id.gradeTitle).setVisibility(View.VISIBLE);
            dataCard.findViewById(R.id.grade0).setVisibility(View.VISIBLE);

            Grade grade0 = grades.get(0);
            TextView txtGradeDate0 = dataCard.findViewById(R.id.gradeDate0);
            txtGradeDate0.setText(formatDate(grade0.getDate()));

            String mark0 = (grade0.getMark() != null) ?
                    String.valueOf(grade0.getMark()) :
                    "N/C";
            TextView txtGradeMark0 = dataCard.findViewById(R.id.gradeMark0);
            txtGradeMark0.setText(mark0);

            if (grades.size() > 1) {
                dataCard.findViewById(R.id.grade1).setVisibility(View.VISIBLE);

                Grade grade1 = grades.get(1);
                TextView txtGradeDate1 = dataCard.findViewById(R.id.gradeDate1);
                txtGradeDate1.setText(formatDate(grade1.getDate()));

                String mark1 = (grade1.getMark() != null) ?
                        String.valueOf(grade1.getMark()) :
                        "N/C";
                TextView txtGradeMark1 = dataCard.findViewById(R.id.gradeMark1);
                txtGradeMark1.setText(mark1);
            }

            if (grades.size() > 2) {
                dataCard.findViewById(R.id.grade2).setVisibility(View.VISIBLE);

                Grade grade2 = grades.get(2);
                TextView txtGradeDate2 = dataCard.findViewById(R.id.gradeDate2);
                txtGradeDate2.setText(formatDate(grade2.getDate()));

                String mark2 = (grade2.getMark() != null) ?
                        String.valueOf(grade2.getMark()) :
                        "N/C";
                TextView txtGradeMark2 = dataCard.findViewById(R.id.edpGradeMark3);
                txtGradeMark2.setText(mark2);
            }
        }
    }

    private void populateEdpGrades(View dataCard, List<Grade> edpGrades) {
        if (edpGrades != null && edpGrades.size() > 0) {
            dataCard.findViewById(R.id.edpTitle).setVisibility(View.VISIBLE);
            dataCard.findViewById(R.id.edp0).setVisibility(View.VISIBLE);

            Grade edpGrade0 = edpGrades.get(0);
            TextView txtGradeDate0 = dataCard.findViewById(R.id.edpGradeDate0);
            txtGradeDate0.setText(formatDate(edpGrade0.getDate()));

            String mark0 = (edpGrade0.getMark() != null) ?
                    String.valueOf(edpGrade0.getMark()) :
                    "N/C";
            TextView txtGradeMark0 = dataCard.findViewById(R.id.edpGradeMark0);
            txtGradeMark0.setText(mark0);

            if (edpGrades.size() > 1) {
                dataCard.findViewById(R.id.edp1).setVisibility(View.VISIBLE);

                Grade edpGrade1 = edpGrades.get(1);
                TextView txtGradeDate1 = dataCard.findViewById(R.id.edpGradeDate1);
                txtGradeDate1.setText(formatDate(edpGrade1.getDate()));

                String mark1 = (edpGrade1.getMark() != null) ?
                        String.valueOf(edpGrade1.getMark()) :
                        "N/C";
                TextView txtGradeMark1 = dataCard.findViewById(R.id.edpGradeMark1);
                txtGradeMark1.setText(mark1);
            }

            if (edpGrades.size() > 2) {
                dataCard.findViewById(R.id.edp2).setVisibility(View.VISIBLE);

                Grade edpGrade2 = edpGrades.get(2);
                TextView txtGradeDate2 = dataCard.findViewById(R.id.edpGradeDate2);
                txtGradeDate2.setText(formatDate(edpGrade2.getDate()));

                String mark2 = (edpGrade2.getMark() != null) ?
                        String.valueOf(edpGrade2.getMark()) :
                        "N/C";
                TextView txtGradeMark2 = dataCard.findViewById(R.id.edpGradeMark2);
                txtGradeMark2.setText(mark2);
            }

            if (edpGrades.size() > 3) {
                dataCard.findViewById(R.id.edp3).setVisibility(View.VISIBLE);

                Grade edpGrade3 = edpGrades.get(3);
                TextView txtGradeDate2 = dataCard.findViewById(R.id.edpGradeDate3);
                txtGradeDate2.setText(formatDate(edpGrade3.getDate()));

                String mark3 = (edpGrade3.getMark() != null) ?
                        String.valueOf(edpGrade3.getMark()) :
                        "N/C";
                TextView txtGradeMark2 = dataCard.findViewById(R.id.edpGradeMark3);
                txtGradeMark2.setText(mark3);
            }
        }
    }

    private static String formatDate(String date) {
        String[] splitDate = date.split("-");
        return splitDate[2] + "/" + splitDate[1];
    }

}