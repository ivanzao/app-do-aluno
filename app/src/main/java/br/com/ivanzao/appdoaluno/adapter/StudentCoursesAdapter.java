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

public class StudentCoursesAdapter extends ArrayAdapter<CourseData> {

    private final Context context;
    private final ArrayList<CourseData> elements;

    public StudentCoursesAdapter(@NonNull Context context, @NonNull List<CourseData> objects) {
        super(context, R.layout.data_card, objects);

        this.context = context;
        this.elements = (ArrayList<CourseData>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CourseData course = elements.get(position);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dataCard = inflater.inflate(R.layout.data_card, parent, false);

        TextView txtSubject = dataCard.findViewById(R.id.title);
        txtSubject.setText(course.getName());

        TextView txtCode = dataCard.findViewById(R.id.code);
        txtCode.setText(course.getCode());

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

        return dataCard;
    }

}