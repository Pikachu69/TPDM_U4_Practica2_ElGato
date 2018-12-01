package mx.edu.ittepic.tpdm_u4_practica2_elgato;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Juego juego;
    TextView uno,dos,tre,cua,cin,sei,sie,och,nue;
    int[] disponibles;
    int turno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tre = findViewById(R.id.tre);
        cua = findViewById(R.id.cua);
        cin = findViewById(R.id.cin);
        sei = findViewById(R.id.sei);
        sie = findViewById(R.id.sie);
        och = findViewById(R.id.och);
        nue = findViewById(R.id.nue);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tre.setOnClickListener(this);
        cua.setOnClickListener(this);
        cin.setOnClickListener(this);
        sei.setOnClickListener(this);
        sie.setOnClickListener(this);
        och.setOnClickListener(this);
        nue.setOnClickListener(this);

        turno = 0;
        disponibles = new int[9];
        arreglo();
    }

    private void arreglo() {
        for (int i=0;i<disponibles.length;i++){
            disponibles[i] = i+1;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.uno){
            uno.setText("X");
            disponibles[0] = 0;
            uno.setEnabled(false);
            turno ++;
        } else if (view.getId() == R.id.dos){
            dos.setText("X");
            disponibles[1] = 0;
            dos.setEnabled(false);
            turno++;
        } else if (view.getId() == R.id.tre){
            tre.setText("X");
            disponibles[2] = 0;
            turno++;
            tre.setEnabled(false);
        } else if (view.getId() == R.id.cua){
            cua.setText("X");
            disponibles[3] = 0;
            cua.setEnabled(false);
            turno++;
        } else if (view.getId() == R.id.cin){
            cin.setText("X");
            disponibles[4] = 0;
            cin.setEnabled(false);
            turno++;
        } else if (view.getId() == R.id.sei){
            sei.setText("X");
            disponibles[5] = 0;
            sei.setEnabled(false);
            turno++;
        } else if (view.getId() == R.id.sie){
            sie.setText("X");
            disponibles[6] = 0;
            sie.setEnabled(false);
            turno++;
        } else if (view.getId() == R.id.och){
            och.setText("X");
            disponibles[7] = 0;
            och.setEnabled(false);
            turno++;
        } else if (view.getId() == R.id.nue){
            nue.setText("X");
            disponibles[8] = 0;
            nue.setEnabled(false);
            turno++;
        }

        if (turno<=4) {
            juego = new Juego(MainActivity.this);
            juego.execute(disponibles);
        }

        ganador("X");
        if (turno>4){
            mensaje("Empate");
        }
    }

    public void ganador(String l){
        if (uno.getText().toString().equals(l) && (dos.getText().toString().equals(l)) && (tre.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (sei.getText().toString().equals(l) && (cua.getText().toString().equals(l)) && (cin.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (sie.getText().toString().equals(l) && (och.getText().toString().equals(l)) && (nue.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (uno.getText().toString().equals(l) && (cua.getText().toString().equals(l)) && (sie.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (dos.getText().toString().equals(l) && (cin.getText().toString().equals(l)) && (och.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (tre.getText().toString().equals(l) && (sei.getText().toString().equals(l)) && (nue.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (uno.getText().toString().equals(l) && (cin.getText().toString().equals(l)) && (nue.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        } else if (tre.getText().toString().equals(l) && (cin.getText().toString().equals(l)) && (sie.getText().toString().equals(l))){
            mensaje("A Ganado: "+l);
        }
    }

    public void mensaje(String ganador) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle("Fin del Juego")
                .setMessage(ganador)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arreglo();

                        uno.setEnabled(true);
                        dos.setEnabled(true);
                        tre.setEnabled(true);
                        cua.setEnabled(true);
                        cin.setEnabled(true);
                        sei.setEnabled(true);
                        sie.setEnabled(true);
                        och.setEnabled(true);
                        nue.setEnabled(true);

                        uno.setText("");
                        dos.setText("");
                        tre.setText("");
                        cua.setText("");
                        cin.setText("");
                        sei.setText("");
                        sie.setText("");
                        och.setText("");
                        nue.setText("");

                        uno.setTextColor(Color.BLACK);
                        dos.setTextColor(Color.BLACK);
                        tre.setTextColor(Color.BLACK);
                        cua.setTextColor(Color.BLACK);
                        cin.setTextColor(Color.BLACK);
                        sei.setTextColor(Color.BLACK);
                        sie.setTextColor(Color.BLACK);
                        och.setTextColor(Color.BLACK);
                        nue.setTextColor(Color.BLACK);

                        turno=0;
                    }
                }).show();
    }
}
