package com.example.estudamilhasog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity {

    ImageButton img_profileB;
    Button Btn_todoB;
    Button Btn_editProfileB;
    CardView metasCard;
    CardView practiceCard;
    CardView learnCard;
    CardView interestsCard;
    CardView helpCard;
    CardView settingsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        img_profileB = (ImageButton) findViewById(R.id.profileB);
        Btn_todoB = (Button) findViewById(R.id.todoB);
        Btn_editProfileB = (Button) findViewById(R.id.editProfileB);
        metasCard = (CardView) findViewById(R.id.metasCard);
        learnCard = (CardView) findViewById(R.id.learnCard);
        practiceCard = (CardView) findViewById(R.id.practiceCard);
        interestsCard = (CardView) findViewById(R.id.interestsCard);
        helpCard = (CardView) findViewById(R.id.helpCard);
        settingsCard = (CardView) findViewById(R.id.settingsCard);






        //Passando
        Intent i = getIntent();
        String email = i.getStringExtra("email");
        Log.i("DEBUG","EMAIL: " + email);

        Intent intent = new Intent(this, TaskView.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}