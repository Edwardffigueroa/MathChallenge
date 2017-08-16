package papplet.hellfish.mathchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String CLAVE_VALOR="tupack.MENSAJE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view){

        Intent intent = new Intent(this, Game.class);
        EditText editText= (EditText) findViewById(R.id.edit_message);
        String nombre = editText.getText().toString();
        intent.putExtra(CLAVE_VALOR, nombre);
        startActivity(intent);

    }
}
