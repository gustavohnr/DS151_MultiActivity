package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular (View view){
        TextView aluno = findViewById(R.id.aluno);
        TextView nota1 = findViewById(R.id.nota1);
        TextView nota2 = findViewById(R.id.nota2);
        TextView freq = findViewById(R.id.freq);

        String saluno = aluno.getText().toString();
        String snota1= nota1.getText().toString();
        String snota2 = nota2.getText().toString();
        String sfreq = freq.getText().toString();

        Intent resultado = new Intent(this, MainActivity2.class);
        Bundle dados = new Bundle();
        dados.putString("aluno", saluno);
        dados.putString("nota1", snota1);
        dados.putString("nota2", snota2);
        dados.putString("freq", sfreq);
        resultado.putExtras(dados);

        if (saluno.length() == 0){
            Toast.makeText(this, "Digite o nome do aluno!", Toast.LENGTH_SHORT).show();
        } else if (snota1.length() == 0 || Integer.parseInt(snota1) > 10 || Integer.parseInt(snota1) < 0){
            Toast.makeText(this, "Nota 1 inválida. Digite um número de 0 a 10", Toast.LENGTH_SHORT).show();
        } else if (snota2.length() == 0 || Integer.parseInt(snota2) > 10 || Integer.parseInt(snota2) < 0) {
            Toast.makeText(this, "Nota 2 inválida. Digite um número de 0 a 10", Toast.LENGTH_SHORT).show();
        } else if (sfreq.length() == 0 || Integer.parseInt(sfreq) > 100 || Integer.parseInt(sfreq) < 0){
            Toast.makeText(this, "Frequência inválida. Digite um número de 0 a 100", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(resultado);
        }
    }
}