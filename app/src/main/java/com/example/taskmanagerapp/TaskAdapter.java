package com.example.taskmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> taskList;
    private OnTaskUpdateListener updateListener;
    private OnTaskDeleteListener deleteListener;

    public interface OnTaskUpdateListener {
        void onTaskUpdate(Task task);
    }

    public interface OnTaskDeleteListener {
        void onTaskDelete(Task task);
    }

    public TaskAdapter(List<Task> taskList, OnTaskUpdateListener updateListener, OnTaskDeleteListener deleteListener) {
        this.taskList = taskList;
        this.updateListener = updateListener;
        this.deleteListener = deleteListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textViewTitle.setText(task.getTitle());
        holder.textViewDate.setText(task.getDate());
        holder.textViewPriority.setText("Priority: " + task.getPriority());

        // Set click listener for update button
        holder.buttonUpdate.setOnClickListener(v -> updateListener.onTaskUpdate(task));

        // Set click listener for delete button
        holder.buttonDelete.setOnClickListener(v -> deleteListener.onTaskDelete(task));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDate, textViewPriority;
        ImageButton buttonUpdate, buttonDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewPriority = itemView.findViewById(R.id.textViewPriority);
            buttonUpdate = itemView.findViewById(R.id.buttonUpdate);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
