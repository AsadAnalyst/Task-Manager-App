ddsdspackage com.example.taskmanagerapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription, editTextDate, editTextPriority;
    private Button buttonSave;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Initialize UI elements
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextDate = findViewById(R.id.editTextDate);
        editTextPriority = findViewById(R.id.editTextPriority);
        buttonSave = findViewById(R.id.buttonSave);

        // Initialize Database Helper
        databaseHelper = new DatabaseHelper(this);

        // Save Button Click Listener
        buttonSave.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        String priorityStr = editTextPriority.getText().toString().trim();

        if (title.isEmpty() || description.isEmpty() || date.isEmpty() || priorityStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int priority = Integer.parseInt(priorityStr);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TITLE, title);
        values.put(DatabaseHelper.COLUMN_DESCRIPTION, description);
        values.put(DatabaseHelper.COLUMN_DATE, date);
        values.put(DatabaseHelper.COLUMN_PRIORITY, priority);

        long newRowId = db.insert(DatabaseHelper.TABLE_TASKS, null, values);
        db.close();

        if (newRowId != -1) {
            Toast.makeText(this, "Task Added!", Toast.LENGTH_SHORT).show();
            finish(); // Close activity after saving
        } else {
            Toast.makeText(this, "Error adding task", Toast.LENGTH_SHORT).show();
        }
    }
}
