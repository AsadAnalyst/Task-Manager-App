# Task-Manager-App

Question | Answer
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
