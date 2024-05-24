package com.example.estudamilhasog;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Signup extends AppCompatActivity {

    private EditText firstname, user, pass, lastname;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstname = findViewById(R.id.Nome_edit_text);
        lastname = findViewById(R.id.Sobrenome_edit_text);
        pass = findViewById(R.id.Password_edit_text);
        user = findViewById(R.id.Email_edit_text);

        // Initialize request queue
        requestQueue = Volley.newRequestQueue(this);
    }

    public void signUp(View v) {
        final String userEmail = user.getText().toString();
        final String passwordText = pass.getText().toString();
        final String firstName = firstname.getText().toString();
        final String lastName = lastname.getText().toString();

        if (userEmail.isEmpty() || passwordText.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            // Prepare the JSON object to be sent to the server
            JSONObject userJson = new JSONObject();
            try {
                userJson.put("email", userEmail);
                userJson.put("senha", passwordText);
                userJson.put("nome", firstName);
                userJson.put("sobrenome", lastName);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String url = "https://67s4d4-3000.csb.app";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    userJson,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                int statusCode = response.getInt("statusCode");
                                if (statusCode == 200) {
                                    // Abre a tela inicial
                                    startActivity(new Intent(Signup.this, HomeScreen.class)
                                            .putExtra("email", userEmail));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Falha ao registrar: " + response.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Erro: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
            );

            // Add the request to the RequestQueue
            requestQueue.add(jsonObjectRequest);
        }
    }
}

    }

}
