package com.example.projetfinal;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class volkwagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volkwagen);


        TextView affdate=findViewById(R.id.affdate);
        Button btndate=findViewById(R.id.btndate6);
        Button validation=findViewById(R.id.valider);
        Button demandes=findViewById(R.id.demandes);
        Button accueil=findViewById(R.id.Accueil);
        LinearLayout screenvolkwagen=findViewById(R.id.screenvolkwagen);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateSetListener =
                (datePicker,year1,month1,day1) -> {
                    affdate.setText(year1 + "/" + month1 + "/" + day1);
                };
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(
                        this,
                        AlertDialog.THEME_HOLO_LIGHT,
                        dateSetListener,
                        year,
                        month,
                        day);
        btndate.setOnClickListener(v->{
            datePickerDialog.show();
        });
        Intent int1=getIntent();
        String nom=int1.getStringExtra("nomU");
        Intent int2=getIntent();
        HashMap<String,HashMap<String,String>>User=(HashMap<String,HashMap<String,String>>) int2.getSerializableExtra("User");
        validation.setOnClickListener(v->{
            for(int i=0;i<screenvolkwagen.getChildCount();i++)
            {
                View child=new View(this);
                child=screenvolkwagen.getChildAt(i);
                if(child instanceof CheckBox && ((CheckBox) child).isChecked())
                {
                    String model=((CheckBox) child).getText().toString();

                    User.get(nom).put(model,affdate.getText().toString());
                    ((CheckBox) child).setChecked(false);
                    Toast.makeText(this, "l'utilisateur "+nom+" a ajoute le model "+model+" a la date: "+affdate.getText(), Toast.LENGTH_SHORT).show();
                }


            }
        });
        demandes.setOnClickListener(v->
        {
            Intent int3=new Intent(volkwagen.this,MainActivity3.class);
            int3.putExtra("User",User);
            int3.putExtra("nomU",nom);
            int3.putExtra("date",affdate.getText().toString());
            startActivity(int3);
        });
        accueil.setOnClickListener(v->
        {
            Intent int4=new Intent(volkwagen.this,MainActivity.class);
            int4.putExtra("User",User);
            int4.putExtra("nomU",nom);
            startActivity(int4);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}