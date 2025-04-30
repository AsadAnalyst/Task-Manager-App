package com.example.taskmanagerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TaskDetailsFragment extends Fragment {
    private TextView textViewTitle, textViewDescription, textViewDate, textViewPriority;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewDescription = view.findViewById(R.id.textViewDescription);
        textViewDate = view.findViewById(R.id.textViewDate);
        textViewPriority = view.findViewById(R.id.textViewPriority);

        if (getArguments() != null) {
            Task task = (Task) getArguments().getSerializable("task");
            if (task != null) {
                textViewTitle.setText(task.getTitle());
                textViewDescription.setText(task.getDescription());
                textViewDate.setText("Due: " + task.getDate());
                textViewPriority.setText("Priority: " + task.getPriority());
            }
        }
        return view;
    }
}
