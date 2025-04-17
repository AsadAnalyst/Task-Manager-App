# Task-Manager-App

Question | Answer
**What is SQLiteOpenHelper? 
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
