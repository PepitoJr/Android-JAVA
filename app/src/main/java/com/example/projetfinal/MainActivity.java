package com.example.projetfinal;

import android.os.Bundle;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnvofre=findViewById(R.id.btnoffer);
        EditText entree1=findViewById(R.id.inputnom);

        HashMap<String, HashMap<String,String>> User;

        if(getIntent().hasExtra("User"))
        {
            User=((HashMap<String, HashMap<String, String>>) getIntent().getSerializableExtra("User"));
        }
        else
        {
            User=(new HashMap<>());
        }
        btnvofre.setOnClickListener(v->
        {
            String nomUser=entree1.getText().toString();
            if(!nomUser.isEmpty())
            {
                Intent int1=new Intent(MainActivity.this,MainActivity2.class);
                if(!User.containsKey(nomUser))
                {
                    User.put(nomUser,new HashMap<>());
                }
                int1.putExtra("nomUser",nomUser);
                int1.putExtra("User",User);
                startActivity(int1);
            }
            else
            {
                Toast.makeText(this, "Veuillez remplir le champs de saisi", Toast.LENGTH_SHORT).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}