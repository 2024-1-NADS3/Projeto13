package com.example.estudamilhasog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText firstname, user, pass, lastname;
    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstname = (EditText) findViewById(R.id.Nome_edit_text);
        lastname = (EditText) findViewById(R.id.Sobrenome_edit_text);
        pass = (EditText) findViewById(R.id.Password_edit_text);
        user = (EditText) findViewById(R.id.Email_edit_text);

        //Connect to db
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-db").build();
    }

    private void output(int id, String result){
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(result);
    }

    private String input(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String str = editText.getText().toString();
        return str;
    }

    public void onSignUp(View view){
        Intent i = new Intent(this, HomeScreen.class);
        startActivity(i);
    }

    /*
       Inscreva o usuário com dados da entrada de edit text input
     */
    public void signUp(View v){
        final String userEmail = user.getText().toString(); //adiciona do elemento view
        final String passwordText = pass.getText().toString(); //adiciona do elemento view

        if(userEmail.isEmpty() || passwordText.isEmpty()){
            Toast.makeText(getApplicationContext(), "Campos Obrigatórios!", Toast.LENGTH_SHORT).show();
        }else{
            //Perform Query to DB
            final UserDao userDao = db.userDao();
            Log.i("DEBUG","got the USER DAO");
            Thread tr = new Thread(new Runnable(){
                @Override
                public void run(){
                    Log.i("DEBUG", "run thread");

                    //Register user to Data base
                    User user = new User(userEmail, passwordText, firstname.getText().toString(), lastname.getText().toString());
                    Log.i("DEBUG", "User Created, name: " + user.firstName);
                    userDao.register(user);
                    Log.i("DEBUG", "Registered User");
                    if(false){
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        ////Abre a tela inicial
                        startActivity(new Intent(Signup.this, HomeScreen.class)
                                //Passa pelo email do usuário
                                .putExtra("email",userEmail));
                    }
                }
            });
            tr.start();
        }
    }

}