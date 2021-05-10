package com.xl.consumoapicepjava.ApiViaJson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xl.consumoapicepjava.ApiViaXmL.ConsumerXml;
import com.xl.consumoapicepjava.ApiViaXmL.Model.CEP;
import com.xl.consumoapicepjava.Conexion.Conexao;
import com.xl.consumoapicepjava.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViaJSON extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private List<CEP> cepList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_via_json);


        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call JSON url
                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://viacep.com.br/ws/RS/Porto%20Alegre/Domingos+Jose/json/");

            }
        });

    }

    private class  Tarefa extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return  retorno;

        }

        @Override
        protected void onPostExecute(String s) {

            // Consumer JSON
            cepList = ConsumerJson.jsonDados(s);
            showList();
        }
    }

    private void showList() {
        if (cepList != null) {
            for( CEP cep: cepList){
                textView.append(cep.getLogradouro()+ "\n"); //append not subscribe data
            }
        }
    }

    // execute in thread/ when app is running// function execute in background
}