package papplet.hellfish.mathchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import papplet.hellfish.mathchallenge.Model.User;

import static android.R.attr.duration;
import static android.R.id.message;

public class Game extends AppCompatActivity {

    int respuestaMaquina=0;
    int resposeInt=0;
    String respose="";
    int turnos=0;

    User usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String nombre=intent.getStringExtra(MainActivity.CLAVE_VALOR);

        usuario= new User(nombre);


        ActualizarOperacion();

        
        Button comprobar= (Button) findViewById(R.id.buttonComprobar);
        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText= (EditText) findViewById(R.id.user_answer);
                respose= editText.getText().toString();
                System.out.println("PRINTEADO PAPU:"+respose);
                resposeInt = Integer.parseInt(respose);

                verificar(resposeInt,respuestaMaquina);

                turnos++;
                System.out.println(turnos);

                String finished="";

                if(turnos<8) {

                    ActualizarOperacion();

                }else{
                    if(evaluarFinal()){
                      finished="Ganaste Mai";
                    }else{
                        finished="Perdiste Mai";
                    }

                    mostrarOperacion(finished);

                    Toast toast = Toast.makeText(getApplicationContext(), "ACABÓ ESTO :"+finished, Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });

    }

    public void ActualizarOperacion(){

        int x= generaNumeroAleatorio(0,10);
        int y=generaNumeroAleatorio(0,10);
        int answer=0;
        //int operacion=(int)Math.random()*2;
        int operacion=generaNumeroAleatorio(0,2);
        String signo="";


        switch (operacion){
            case 0://suma
                signo= "+";
                answer= x+y;

                break;
            case 1://resta
                signo= "-";
                answer= x-y;

                break;
            case 2://multiplicacón
                signo= "*";
                answer= x*y;

                break;
        }


    mostrarOperacion(x+signo+y+"="+"?");
        respuestaMaquina=answer;

    }

    public void mostrarOperacion(String s){

        TextView textView =(TextView) findViewById(R.id.text_operacion);
        textView.setText(s);

    }

    public void verificar(int numeroUno, int numeroDos){

        if (numeroUno==numeroDos){
            Toast toast = Toast.makeText(getApplicationContext(), "yei", Toast.LENGTH_SHORT);
            toast.show();
            usuario.addbuenas();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "nope", Toast.LENGTH_SHORT);
            toast.show();
            usuario.addMalas();
        }

    }

    public static int generaNumeroAleatorio(int minimo,int maximo){

        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;

    }

    public boolean evaluarFinal(){
        if(usuario.getBuenas()>usuario.getMalas()) {
            return true;
        }else{
            return false;
        }
    }




}
