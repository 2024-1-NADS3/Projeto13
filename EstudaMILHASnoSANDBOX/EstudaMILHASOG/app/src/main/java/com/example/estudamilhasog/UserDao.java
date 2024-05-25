package com.example.estudamilhasog;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE email IN (:emails)")
    List<User> loadAllByIds(int[] emails);

    @Query("SELECT * FROM user WHERE email LIKE :email LIMIT 1")
    User login(String email);

    @Query("SELECT * FROM user WHERE email LIKE :email LIMIT 1")
    User getUser(String email);

    @Transaction
    @Query("SELECT * FROM user")
    public List<UserWithTask> getUserWithTask();

    @Transaction
    @Query("SELECT * FROM user WHERE email LIKE :emailS")
    public List<UserWithTask> getUserWithTask(String emailS);

    @Query("SELECT * FROM user, task WHERE :user = userCreatorId")
    public List<Task> getTasks(String user);

    @Transaction
    @Insert
    void register(User user);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Transaction
    @Insert
    void insert(Task task);

    @Query("SELECT * FROM task WHERE task.userCreatorId LIKE :email")
    public List<Task> getTaskNew(String email);

    @Query("SELECT * FROM task")
    List<Task> getAllTask();

    @Delete
    void delete(Task task);

}