package com.example.jokenpo;;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        System.out.println("selecionado pedra");
        this.opcaoSelecionada(0);

    }
    public void selecionadoPapel(View view){
        System.out.println("selecionado papel");
        this.opcaoSelecionada(1);

    }
    public void selecionadoTesoura(View view){
        System.out.println("selecionado tesoura");
        this.opcaoSelecionada(2);

    }

    public void opcaoSelecionada(int opcaoSelecionada){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        TextView textResJogador = findViewById(R.id.textResJogador);
        TextView textResComputador = findViewById(R.id.textResComputador);

        String getScoreJogador  = textResJogador.getText().toString();
        String getScoreComputador = textResComputador.getText().toString();

        int scoreJogador = Integer.parseInt(getScoreJogador);
        int scoreComputador = Integer.parseInt(getScoreComputador);

        int numero = new Random().nextInt(3);
        int[] opcoes = {0,1,2};
        int opcoesApp = opcoes[numero];

        switch(opcoesApp){
            case 0:
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case 1:
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case 2:
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if( (opcoesApp == 0 && opcaoSelecionada == 2) ||
            (opcoesApp == 1 && opcaoSelecionada == 0) ||
            (opcoesApp == 2 && opcaoSelecionada == 1)
        )
        {
            textResultado.setText("Voce perdeu");
            scoreComputador += 1;
            textResComputador.setText(""+scoreComputador);

        } else if (
            (opcaoSelecionada == 0 && opcoesApp == 2) ||
            (opcaoSelecionada == 1 && opcoesApp == 0) ||
            (opcaoSelecionada == 2 && opcoesApp == 1)
        )
        {
            textResultado.setText("Voce ganhou");
            scoreJogador += 1;
            textResJogador.setText(""+scoreJogador);
        }
        else{
            textResultado.setText("Empate");
        }

    }
}