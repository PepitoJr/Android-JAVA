package com.example.projetfinal;

import android.os.Bundle;
import android.widget.Button;
import java.util.HashMap;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Button btnMerco=findViewById(R.id.btn1offre);
        Button btnTesla=findViewById(R.id.btn2offre);
        Button btnBMW=findViewById(R.id.btn3offre);
        Button btnHONDA=findViewById(R.id.btn4offre);
        Button btnAUDI=findViewById(R.id.btn5offre);
        Button btnTOYOTA=findViewById(R.id.btn6offre);
        btnMerco.setOnClickListener(v->{
            Intent int1=getIntent();
           String nom= int1.getStringExtra("nomUser");
           Intent int2=getIntent();
            HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
            Intent int3=new Intent(MainActivity2.this, mercedes1.class);
                int3.putExtra("nomU",nom);
                int3.putExtra("User",User);
            startActivity(int3);
        });
        btnTesla.setOnClickListener(v->{
            Intent int1=getIntent();
            String nom= int1.getStringExtra("nomUser");
            Intent int2=getIntent();
            HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
            Intent int3=new Intent(MainActivity2.this, tesla.class);
            int3.putExtra("nomU",nom);
            int3.putExtra("User",User);
            startActivity(int3);
        });
        btnBMW.setOnClickListener(v->{
            Intent int1=getIntent();
            String nom= int1.getStringExtra("nomUser");
            Intent int2=getIntent();
            HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
            Intent int3=new Intent(MainActivity2.this, bmw.class);
            int3.putExtra("nomU",nom);
            int3.putExtra("User",User);
            startActivity(int3);
        });
        btnHONDA.setOnClickListener(v->{
            Intent int1=getIntent();
            String nom= int1.getStringExtra("nomUser");
            Intent int2=getIntent();
            HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
            Intent int3=new Intent(MainActivity2.this, honda.class);
            int3.putExtra("nomU",nom);
            int3.putExtra("User",User);
            startActivity(int3);
        });
        btnAUDI.setOnClickListener(v->{
            Intent int1=getIntent();
            String nom= int1.getStringExtra("nomUser");
            Intent int2=getIntent();
            HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
            Intent int3=new Intent(MainActivity2.this, audi.class);
            int3.putExtra("nomU",nom);
            int3.putExtra("User",User);
            startActivity(int3);
        });
        btnTOYOTA.setOnClickListener(v->{
            Intent int1=getIntent();
            String nom= int1.getStringExtra("nomUser");
            Intent int2=getIntent();
            HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
            Intent int3=new Intent(MainActivity2.this, toyota.class);
            int3.putExtra("nomU",nom);
            int3.putExtra("User",User);
            startActivity(int3);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}