package com.example.learningmanagementsystem.ui.home.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.n_ui.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesFragment extends Fragment {

    private String[] data = {"English", "Math", "Physics", "Biology"};
    private List<Course> courses = new ArrayList<>();

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_coures, container, false);
        listView = view.findViewById(R.id.course_list);
        initCourse();
        CourseAdpter courseAdpter = new CourseAdpter(getContext(), R.layout.course_item, courses);
        listView.setAdapter(courseAdpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return view;
    }

    private void initCourse() {
        courses.clear();
        for (int i = 0; i < data.length; i++) {
            courses.add(new Course(data[i], i));
        }
    }

    private class CourseAdpter extends ArrayAdapter {
        private int resource;

        public CourseAdpter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
            this.resource = resource;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Course course = (Course) getItem(position);
            View view = LayoutInflater.from(this.getContext()).inflate(resource, null);
            ImageView imageView = view.findViewById(R.id.course_item_image);
            imageView.setImageResource(R.drawable.ic_launcher_background);
            TextView textView = view.findViewById(R.id.course_item_name);
            textView.setText(course.getName());
            return view;
        }
    }
}
