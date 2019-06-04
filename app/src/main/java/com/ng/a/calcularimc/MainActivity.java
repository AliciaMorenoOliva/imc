package com.ng.a.calcularimc;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    public static final String TAG_LOG = "MIAPP";

    @Override
    protected void onCreate(Bundle saquito) { //hemos cambiado el nombre para aclararnos mejor
        super.onCreate(saquito);
        setContentView(R.layout.activity_main);


        if (saquito == null) { //le decimos que saquito es null
            Log.d("MIAPP", "Es la primera vez que se ejecuta o no hay nada guardado");//creamos un error para saber por donde va


        } else {
            Log.d("MIAPP", "Hay cosas guardadas");


            String peso_guardado;
            String altura_guardado;
            float pesof;
            float alturaf;


            peso_guardado = saquito.getString("peso");
            altura_guardado = saquito.getString("altura");

            pesof = Float.parseFloat(peso_guardado);
            alturaf = Float.parseFloat(altura_guardado);

            calcularIMC(pesof, alturaf);


        }
    }

    public void calcularIMC(float peso, float altura) {

        String valor = null; // creamos la variable para despues declarar para la traduccion


        //calculo imc
        float cal_imc = formulaImc(peso, altura);


        //mostrarlo

        TextView caja_destino = findViewById(R.id.caja_destino);
        caja_destino.setText(String.valueOf(cal_imc));

        // poner el estado (sobrepeso....)
        if (cal_imc < 16) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.desnutrido);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.desnutrido);
        } else if (cal_imc < 18) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.delgado); //recogemos la variable para que recoga la traduccion
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView); //indicamos la imagen
            imageView.setImageResource(R.drawable.delgado);
        } else if (cal_imc < 25) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.ideal);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.ideal);
        } else if (cal_imc < 31) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.sobrepeso);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.sobrepeso);
        } else {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.obeso);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.obeso);
        }
    }


    //metodo para calcular el IMC
    public void calcularIMC() {

        String valor = null; // creamos la variable para despues declarar para la traduccion

        //recojo el peso
        EditText editText = findViewById(R.id.text_introd_peso);//recoje la caja del peso
        String peso_introducido = editText.getText().toString();//reconoce el texto de la caja en String
        float peso = Float.parseFloat(peso_introducido); //cambio de String a float
        //recojo la altura
        EditText editText1 = findViewById(R.id.text_introd_altura);
        String altura_introducida = editText1.getText().toString();
        float altura = Float.parseFloat(altura_introducida);

        //calculo imc
        float cal_imc = formulaImc(peso, altura);


        //mostrarlo

        TextView caja_destino = findViewById(R.id.caja_destino);
        caja_destino.setText(String.valueOf(cal_imc));

        // poner el estado (sobrepeso....)
        if (cal_imc < 16) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.desnutrido);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.desnutrido);
        } else if (cal_imc < 18) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.delgado); //recogemos la variable para que recoga la traduccion
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView); //indicamos la imagen
            imageView.setImageResource(R.drawable.delgado);
        } else if (cal_imc < 25) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.ideal);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.ideal);
        } else if (cal_imc < 31) {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.sobrepeso);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.sobrepeso);
        } else {
            TextView estadoSalud = findViewById(R.id.resultado);
            valor = getResources().getString(R.string.obeso);
            estadoSalud.setText(valor);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.obeso);
        }
    }

    private static float formulaImc(float peso, float altura) {
        float imc = 0;
        imc = peso / (altura * altura);
        return imc;


    }

    public void calcularIMC(View view) {
        calcularIMC();
    }

    private void guardarSaquito(Bundle saquito) {

        EditText caja_peso = findViewById(R.id.text_introd_peso);
        EditText caja_altura = findViewById(R.id.text_introd_altura);
        saquito.putString("peso", caja_peso.getText().toString());
        saquito.putString("altura", caja_altura.getText().toString());
    }

    //recuperamos este metodo para guardar la informacion cuando le damos la vuelta al terminal
    @Override
    public void onSaveInstanceState(Bundle saquito) {
        super.onSaveInstanceState(saquito);

        Log.d("MIAPP", "La actividad se va a recrear"); //creamos este error para saber si pasa por aqui
        guardarSaquito(saquito);//con el putBollean le decimos que guarde un boleano (true o false)
//TODO gestionar cambio de orientacion

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        /*menu.add ("fulanito"); //para añadir en el menu*/

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.informacion:

               // abrirwebapp();
irPagina("https://es.wikipedia.org/wiki/Índice_de_masa_corporal");
                Log.d("MIAPP", "toco v infinito");
                break;

            default:
                Log.d("MIAPP", "No sé que toco");
        }
        return super.onOptionsItemSelected(item);
    }

    public void irPagina(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        String pregunta = "Con que app quieres continuar";
        Intent chooser = Intent.createChooser(intent, pregunta);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void abrirwebapp() {
        Intent intent = new Intent(this, WebAtivity.class);
        startActivity(intent);
        }
    }

