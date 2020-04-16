package com.example.eglicem;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void validar(View view){
        EditText editValor = (EditText) findViewById(R.id.editValor);
        TextView textResultado = (TextView) findViewById(R.id.textResultado);
        TextView textResultadoDados = (TextView) findViewById(R.id.textResultadoDados);
        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        TextView textRetorno = (TextView) findViewById(R.id.textRetorno);

        SimpleDateFormat formatoDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date dataAtual = cal.getTime();
        String dataHora = formatoDataHora.format(dataAtual);

        String leitura = String.valueOf(editValor.getText());

        if (!leitura.isEmpty()){

            textResultado.setVisibility(view.VISIBLE);
            textResultadoDados.setVisibility(view.VISIBLE);

            int valor = Integer.parseInt(leitura);
            if (valor > 600){
                textResultado.setText(valor +" = VALOR INVÁLIDO!");
                textResultadoDados.setText("VALOR MÁXIMO PERMITIDO = 600");
            } else if (valor >= 200){
                textResultado.setText(valor +" = PROCURE UM MÉDICO");
                textResultadoDados.setText(dataHora + " -> DIABETES");
            } else if (valor >= 110){
                textResultado.setText(valor +" = PROCURE UM MÉDICO");
                textResultadoDados.setText(dataHora + " -> PRÉ-DIABETES");
            }
            else if (valor <= 70){
                textResultado.setText(valor +" = SE ALIMENTE!");
                textResultadoDados.setText(dataHora + " -> HIPOGLICEMIA");
            } else {
                textResultado.setText(valor +" = GLICEMIA NORMAL!");
                textResultadoDados.setText(dataHora + " -> GLICEMIA NORMAL!");
            }
            editValor.setText("");
            buttonSalvar.setVisibility(view.VISIBLE);
        } else {
            textResultado.setVisibility(view.INVISIBLE);
            textResultadoDados.setVisibility(view.INVISIBLE);
            buttonSalvar.setVisibility(view.INVISIBLE);
            textRetorno.setVisibility(view.INVISIBLE);
        }
    }

    public void limpar(View view){
        EditText editValor = (EditText) findViewById(R.id.editValor);
        TextView textResultado = (TextView) findViewById(R.id.textResultado);
        TextView textResultadoDados = (TextView) findViewById(R.id.textResultadoDados);
        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        TextView textRetorno = (TextView) findViewById(R.id.textRetorno);

        editValor.setText("");
        textResultadoDados.setText("");

        textResultado.setVisibility(view.INVISIBLE);
        textResultadoDados.setVisibility(view.INVISIBLE);
        buttonSalvar.setVisibility(view.INVISIBLE);
        textRetorno.setVisibility(view.INVISIBLE);
    }

    public void salvarResultado(View view){
        TextView textRetorno = (TextView) findViewById(R.id.textRetorno);
        textRetorno.setText("Salvo com Sucesso!");
        textRetorno.setVisibility(view.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
