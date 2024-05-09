package com.example.estudamilhas;

import static com.example.estudamilhas.R.id.profileB;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Hub extends AppCompatActivity {

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hub);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            img_profileB = (ImageButton) findViewById(R.id.profileB);
            Btn_todoB = (Button) findViewById(R.id.todoB);
            Btn_editProfileB = (Button) findViewById(R.id.editProfileB);
            metasCard = (CardView) findViewById(R.id.metasCard);
            learnCard = (CardView) findViewById(R.id.learnCard);
            practiceCard = (CardView) findViewById(R.id.practiceCard);
            interestsCard = (CardView) findViewById(R.id.interestsCard);
            helpCard = (CardView) findViewById(R.id.helpCard);
            settingsCard = (CardView) findViewById(R.id.settingsCard);

            ImageButton.setOnclickListener(new View())
        });
    }
}