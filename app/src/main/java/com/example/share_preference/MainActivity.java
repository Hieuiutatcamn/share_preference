package com.example.share_preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private Button buttonSave;
    private TextView textViewDisplay;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonSave = findViewById(R.id.buttonSave);
        textViewDisplay = findViewById(R.id.textViewDisplay);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Load saved data if exists
        String savedName = sharedPreferences.getString("username", "No Name Found");
        int savedAge = sharedPreferences.getInt("age", 0);
        String savedEmail = sharedPreferences.getString("email", "No Email Found");
        String savedPhone = sharedPreferences.getString("phone", "No Phone Found");
        textViewDisplay.setText("Name: " + savedName + ", Age: " + savedAge +
                ", Email: " + savedEmail + ", Phone: " + savedPhone);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name);
                editor.putInt("age", age);
                editor.putString("email", email);
                editor.putString("phone", phone);
                editor.apply();

                textViewDisplay.setText("Name: " + name + ", Age: " + age +
                        ", Email: " + email + ", Phone: " + phone);
            }
        });
    }

}