package com.example.taskmanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListFragment extends Fragment {
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        databaseHelper = new DatabaseHelper(getContext());
        loadTasks();
        return view;
    }

    private void loadTasks() {
        List<Task> taskList = databaseHelper.getAllTasks();
        taskAdapter = new TaskAdapter(taskList,
                task -> {
                    Intent intent = new Intent(getContext(), UpdateTaskActivity.class);
                    intent.putExtra("TASK_ID", task.getId());
                    intent.putExtra("TASK_TITLE", task.getTitle());
                    intent.putExtra("TASK_DESC", task.getDescription());
                    intent.putExtra("TASK_DATE", task.getDate());
                    intent.putExtra("TASK_PRIORITY", task.getPriority());
                    startActivity(intent);
                },
                task -> {
                    databaseHelper.deleteTask(task.getId());
                    loadTasks(); // Refresh list after deletion
                    Toast.makeText(getContext(), "Task Deleted", Toast.LENGTH_SHORT).show();
                }
        );
        recyclerView.setAdapter(taskAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadTasks();
    }
}
