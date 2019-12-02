package com.example.learningmanagementsystem.ui.home.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.n_ui.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesFragment extends Fragment {

    private String[] data = {"English", "Math", "Physics", "Biology"};
    private List<Course> courses = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_coures, container, false);
        initCourse();
//        ListView listView = view.findViewById(R.id.course_list);
//        CourseAdpter courseAdpter = new CourseAdpter(getContext(), R.layout.course_item, courses);
//        listView.setAdapter(courseAdpter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent();
//                intent.setClass(getContext(), LearningActivity.class);
//                startActivity(intent);
//            }
//        });
        RecyclerView recyclerView = view.findViewById(R.id.course_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CourseAdapter courseAdapter = new CourseAdapter();
        recyclerView.setAdapter(courseAdapter);
        return view;
    }

    private void initCourse() {
        courses.clear();
        for (int i = 0; i < data.length; i++) {
            courses.add(new Course(data[i], i));
        }
    }

    private class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

        @NonNull
        @Override
        public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
            return new CourseViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
            holder.name.setText(courses.get(position).getName());
            holder.image.setImageResource(R.drawable.ic_launcher_background);
            //TODO:get more picture resources...

        }

        @Override
        public int getItemCount() {
            return courses.size();
        }


        //        private int resource;
//
//        public CourseAdpter(@NonNull Context context, int resource, @NonNull List objects) {
//            super(context, resource, objects);
//            this.resource = resource;
//        }
//
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            Course course = (Course) getItem(position);
//            View view = LayoutInflater.from(this.getContext()).inflate(resource, null);
//            ImageView imageView = view.findViewById(R.id.course_item_image);
//            imageView.setImageResource(R.drawable.ic_launcher_background);
//            TextView textView = view.findViewById(R.id.course_item_name);
//            textView.setText(course.getName());
//            return view;
//        }
        private class CourseViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            ImageView image;

            CourseViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.course_item_name);
                image = itemView.findViewById(R.id.course_item_image);
            }
        }
    }
}
