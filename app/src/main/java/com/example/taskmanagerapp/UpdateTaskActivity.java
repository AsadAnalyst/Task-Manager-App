package com.example.taskmanagerapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateTaskActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextDescription, editTextDate, editTextPriority;
    private Button buttonUpdate;
    private DatabaseHelper databaseHelper;
    private int taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextDate = findViewById(R.id.editTextDate);
        editTextPriority = findViewById(R.id.editTextPriority);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        databaseHelper = new DatabaseHelper(this);

        taskId = getIntent().getIntExtra("TASK_ID", -1);
        editTextTitle.setText(getIntent().getStringExtra("TASK_TITLE"));
        editTextDescription.setText(getIntent().getStringExtra("TASK_DESC"));
        editTextDate.setText(getIntent().getStringExtra("TASK_DATE"));
        editTextPriority.setText(String.valueOf(getIntent().getIntExtra("TASK_PRIORITY", 1)));

        buttonUpdate.setOnClickListener(v -> updateTask());
    }

    private void updateTask() {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        int priority = Integer.parseInt(editTextPriority.getText().toString().trim());

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TITLE, title);
        values.put(DatabaseHelper.COLUMN_DESCRIPTION, description);
        values.put(DatabaseHelper.COLUMN_DATE, date);
        values.put(DatabaseHelper.COLUMN_PRIORITY, priority);

        int rowsUpdated = db.update(DatabaseHelper.TABLE_TASKS, values, "id=?", new String[]{String.valueOf(taskId)});
        db.close();

        if (rowsUpdated > 0) {
            Toast.makeText(this, "Task Updated!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Error updating task", Toast.LENGTH_SHORT).show();
        }
    }
}
