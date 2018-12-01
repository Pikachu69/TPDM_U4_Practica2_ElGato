package mx.edu.ittepic.tpdm_u4_practica2_elgato;

import android.graphics.Color;
import android.os.AsyncTask;

public class Juego extends AsyncTask<int[], Void, Integer> {
    MainActivity puntero;

    public Juego(MainActivity ventana) {
        puntero = ventana;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(int[]... ints) {
        int contador = 0;
        for (int i=0;i<ints[0].length;i++){
            if (ints[0][i] != 0){
                contador++;
            }
        }
        int[] disponibles = new int[contador];
        int posicion = 0;
        for (int i=0;i<ints[0].length;i++){
            if (ints[0][i]!=0){
                disponibles[posicion] = ints[0][i];
                posicion++;
            }
        }

        return elegirPosicion(disponibles);
    }

    private int elegirPosicion(int[] d) {
        int n = (int)(Math.random()*9)+1;
        int m = 0;
        while (m==0) {
            for (int i = 0; i < d.length; i++) {
                if (n == d[i]) {
                    m = n;
                    break;
                }
            }
            n = (int)(Math.random()*9)+1;
        }
        return m;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        switch (integer){
            case 1:
                puntero.uno.setText("O");
                puntero.uno.setEnabled(false);
                puntero.uno.setTextColor(Color.WHITE);
                break;
            case 2:
                puntero.dos.setText("O");
                puntero.dos.setEnabled(false);
                puntero.dos.setTextColor(Color.WHITE);
                break;
            case 3:
                puntero.tre.setText("O");
                puntero.tre.setEnabled(false);
                puntero.tre.setTextColor(Color.WHITE);
                break;
            case 4:
                puntero.cua.setTextColor(Color.WHITE);
                puntero.cua.setText("O");
                puntero.cua.setEnabled(false);
                break;
            case 5:
                puntero.cin.setTextColor(Color.WHITE);
                puntero.cin.setText("O");
                puntero.cin.setEnabled(false);
                break;
            case 6:
                puntero.sei.setTextColor(Color.WHITE);
                puntero.sei.setText("O");
                puntero.sei.setEnabled(false);
                break;
            case 7:
                puntero.sie.setTextColor(Color.WHITE);
                puntero.sie.setText("O");
                puntero.sie.setEnabled(false);
                break;
            case 8:
                puntero.och.setTextColor(Color.WHITE);
                puntero.och.setText("O");
                puntero.och.setEnabled(false);
                break;
            case 9:
                puntero.nue.setTextColor(Color.WHITE);
                puntero.nue.setText("O");
                puntero.nue.setEnabled(false);
                break;
        }
        puntero.ganador("O");
    }
}
