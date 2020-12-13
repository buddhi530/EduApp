package com.example.eduapp.rasuni;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eduapp.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter {


    private Activity mContext;
    List<Result> results;

    public ListAdapter( Activity mContext, List<Result> results) {
        super(mContext, R.layout.layout_itemmarks,results);
        this.mContext = mContext;
        this.results = results;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.layout_itemmarks,null,true);

        TextView tvyear = listItemView.findViewById(R.id.tv_year);
        TextView tvsemester = listItemView.findViewById(R.id.tv_semester);
        TextView tvmark = listItemView.findViewById(R.id.tv_mark);
        TextView tvsubject = listItemView.findViewById(R.id.tv_subject);
        TextView tvgpa = listItemView.findViewById(R.id.tv_gpa);

        Result result = results.get(position);


        tvyear.setText(result.getYear());
        tvsemester.setText(result.getSemester());
        tvmark.setText(result.getMarks());
        tvsubject.setText(result.getSubjects());
        tvgpa.setText(result.getGpa());

        return  listItemView;

    }
}
