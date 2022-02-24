package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tmedia = findViewById(R.id.media);
        TextView situacao = findViewById(R.id.situacao);
        TextView nome_aluno = findViewById(R.id.nome);
        TextView frequencia_aluno = findViewById(R.id.tfrequencia);

        //recebe dados da outra activity
        Intent resultado = getIntent();
        Bundle dados = resultado.getExtras();
        String nome = dados.getString("aluno");
        String nota1 = dados.getString("nota1");
        String nota2 = dados.getString("nota2");
        String freq = dados.getString("freq");

        nome_aluno.setText(nome);
        frequencia_aluno.setText(freq);

        //calcula media
        double media = (Double.parseDouble(nota1)+Double.parseDouble(nota2)) / 2;
        tmedia.setText(String.valueOf(media));

        if ((Integer.parseInt(freq)>=75)){
            if (media < 4){
                situacao.setTextColor(0xFFBC3E3E);
                situacao.setText("REPROVADO POR NOTA");
            } else if (media < 7){
                situacao.setTextColor(0xFF3E85BC);
                situacao.setText("FINAL");
            } else {
                situacao.setTextColor(0xFF83BC3E);
                situacao.setText("APROVADO");
            }
        } else {
           situacao.setTextColor(0xFFBC3E3E);
           situacao.setText("REPROVADO POR FREQUENCIA");
        }
    }
}