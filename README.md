# Task-Manager-App

❓ Question | ✅ Answer
What is SQLiteOpenHelper? 
| It is a helper class to manage database creation and versioning.
What does onCreate() do? 
| It creates the database schema (tables, columns).
Why do we use ContentValues? 
| It’s used to map column names to their values for insert/update operations.
What is the use of Cursor? 
| It is used to read rows from the result of a database query.
What is the purpose of onUpgrade()? 
| It handles schema changes when the database version increases.
Difference between getReadableDatabase() and getWritableDatabase()? 
| The first gives read-only access; the second gives write access.
Why do we close the database? 
| To release resources and avoid memory leaks.
Why use constants for column names? 
| Prevents typo bugs and makes maintenance easier.
Can multiple tables be created in this class? 
| Yes, you can extend the logic in onCreate() to define multiple tables.
What is the data type of priority? 
| INTEGER (stored as an int).


-------------------------------------------------------------------------------------------

❓ Question | ✅ Answer
What is the purpose of AddTaskActivity? 
| To allow the user to enter and save a new task into the SQLite database.
What is ContentValues used for? 
| It maps column names to values to insert into the database.
Why use DatePickerDialog? 
| It lets the user easily select a date from a calendar view.
Why do we use trim()? 
| To remove leading/trailing spaces from user input.
What happens if db.insert() fails? 
| It returns -1 and the app shows an error message.
What is finish() used for? 
| It closes the current activity and returns to the previous screen.
Why use Calendar.getInstance()? 
| To get the current date to initialize the DatePicker with today's date.
Why parse priorityStr into an int? 
| Because the database expects priority as an integer, not a string.
How does the app handle empty fields? 
| It checks each one and shows a Toast message if any are empty.
Why close the database? | To prevent memory leaks and free up system resources.

-------------------------------------------------------------------------------------------

❓ Question | ✅ Answer
What is RecyclerView.Adapter used for? 
| It connects the data source (taskList) to the UI (RecyclerView).
What is ViewHolder? 
| It holds views for one item in the list and allows efficient view recycling.
Why do we use inflate() in onCreateViewHolder? 
| To convert the XML layout (item_task) into a View object.
What is onBindViewHolder() for? 
| To bind data from the model (task) to the UI (text fields, buttons).
Why use @NonNull? 
| It tells the compiler that the parameter will never be null, improving safety.
Why use interfaces like OnTaskUpdateListener? 
| To allow the activity or fragment to define custom behavior for update/delete.
What is taskList.get(position)? 
| It gets the Task object at a specific position in the list.
What happens if you don’t override getItemCount()? 
| RecyclerView won’t know how many items to show, so nothing will be displayed.
Why use ImageButton instead of Button?
| For icons (like pencil or trash) which make the UI more intuitive.
Can you reuse the same ViewHolder for multiple items?
| Yes, that’s the purpose of the ViewHolder pattern in RecyclerView.
