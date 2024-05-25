package com.example.estudamilhasog;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

/*
Esta classe representa o relacionamento um-muitos entre entidades de usuário e de tarefa
 */
public class UserWithTask {
    @Embedded public User user;
    @Relation(
            parentColumn = "email",
            entityColumn = "userCreatorId"
    )
    public List<Task> taskList;

    public UserWithTask(User user, List<Task> taskList) {
        this.user = user;
        this.taskList = taskList;
    }
}
