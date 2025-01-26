package com.example.projetfinal;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.HashMap;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        Intent int1=getIntent();
        String nom=int1.getStringExtra("nomU");
        HashMap<String,HashMap<String,String>> User=(HashMap<String,HashMap<String,String>>) int1.getSerializableExtra("User");
        LinearLayout screenfinal=findViewById(R.id.screenfinal);
            TextView affnom=findViewById(R.id.affnom);
            affnom.setText(nom);
            affnom.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        for(String key: User.get(nom).keySet())
        {
            LinearLayout choixmodel=new LinearLayout(this);
            choixmodel.setOrientation(LinearLayout.HORIZONTAL);
            choixmodel.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            LinearLayout.LayoutParams childParams=new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,1);
            TextView vmodel=new TextView(this);
            vmodel.setText(key);
            vmodel.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            vmodel.setLayoutParams(childParams);
            Button btn=new Button(this);
            btn.setText("Enlever");
            btn.setLayoutParams(childParams);
            btn.setOnClickListener(v->
            {
                User.get(nom).remove(key);
                screenfinal.removeView(choixmodel);
            });
            TextView date=new TextView(this);
            date.setText(User.get(nom).get(key));
            date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            date.setLayoutParams(childParams);
            choixmodel.addView(vmodel);
            choixmodel.addView(date);
            choixmodel.addView(btn);
            screenfinal.addView(choixmodel);
        }
        Button accueilbutton=findViewById(R.id.btnaccueil);
        accueilbutton.setOnClickListener(v->
        {
            Intent intent4=new Intent(MainActivity3.this,MainActivity.class);
            intent4.putExtra("User",User);
            intent4.putExtra("nomU",nom);
            startActivity(intent4);
        });
        Button btnoffre=findViewById(R.id.btnoffre);
        btnoffre.setOnClickListener(v->
        {
            Intent intent =new Intent(MainActivity3.this,MainActivity2.class);
            intent.putExtra("User",User);
            intent.putExtra("nomU",nom);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}