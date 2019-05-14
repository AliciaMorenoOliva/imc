package com.ng.a.calcularimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_LOG = "MIAPP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
     private static float formulaImc (float peso, float altura)
    {
        float imc = 0;
        imc = peso/(altura*altura);
        return imc;


    }
public void calcularIMC (View view)
{
    calcularIMC();


}
}
