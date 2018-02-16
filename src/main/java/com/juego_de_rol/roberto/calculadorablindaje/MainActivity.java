package com.juego_de_rol.roberto.calculadorablindaje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    private EditText b,d,p;
    private TextView r,e;
    Calculadora calculadora;
    private int blindaje,dados;
    private boolean error =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(EditText)findViewById(R.id.blindaje);
        d=(EditText)findViewById(R.id.dados);
        p=(EditText)findViewById(R.id.porcentaje);
        r=(TextView)findViewById(R.id.resultado);
        e=(TextView)findViewById(R.id.Error);

     /*  @SuppressLint({"CutPasteId", "WrongViewCast"}) Button btn = findViewById(R.id.blindaje);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String bl=b.getText().toString();
                 String da=d.getText().toString();
                calculadora= new Calculadora(0.3);

                int x =calculadora.app(Integer.parseInt(bl),Integer.parseInt(da));
                r.setText(x);

            }});*/

    }/*
    @Override
    public boolean onCreateOptionMenu(Menu menu){
       getMenuInflater().inflate((R.menu.menu_main, menu));
       return true;

    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

*/




    private void pasarNumeros() {
        String bl=null;
        String da=null;


            if(b.getText().toString().isEmpty()){
                bl = "0";
                if(d.getText().toString().isEmpty()){
                    da="0";
                }
                else{
                    da=d.getText().toString();
                }


                this.error(1);

            }
            else if(d.getText().toString().isEmpty()){
                bl=b.getText().toString();
                da="0";
                this.error(1);
            }
            else{
                bl=b.getText().toString();
                da=d.getText().toString();
                e.setText("");
            }



            this.blindaje=(int)Integer.parseInt(bl);
            this.dados=(int)Integer.parseInt(da);
            if(this.blindaje<0 || this.dados<0 || this.dados>100){
                error=true;
            }
            else{
                error=false;
            }





    }

    private void error(int op) {
        switch (op){
            case 1: e.setText("ERROR: Hay variables vacias");
                this.error=false;
                break;
            case 2:
                e.setText("ERROR: Variables incorrectas");
                this.error=false;
                break;
            default:
                this.error=false;
                break;
        }

    }


    public void blindajeC(View view){
       this.pasarNumeros();
       if(error){
           this.error(2);
           r.setText("0");
       }else{
           // String bl=b.getText().toString();
           // String da=d.getText().toString();
           calculadora= new Calculadora(3);
           int x =calculadora.app(blindaje,dados);
           //int x =calculadora.app(Integer.parseInt(bl),Integer.parseInt(da));
           // r.setText(x);
           // char c= (char) x;
           // r.setText(c);
           String resultado=String.valueOf(x);


           r.setText(resultado);
       }

    }
    public void cocheC(View view){
        this.pasarNumeros();
        if(error){
            this.error(2);
            r.setText("0");
        }else{
            //  String bl=b.getText().toString();
            //String da=d.getText().toString();
            calculadora= new Calculadora(1);
            int x =calculadora.app(blindaje,dados);
            //  int x =calculadora.app(Integer.parseInt(bl),Integer.parseInt(da));
            //  r.setText(x);
            String resultado=String.valueOf(x);
            r.setText(resultado);
        }

    }
    public void porcentajeC(View view){
        this.pasarNumeros();
        int porcentaje;
        String po=null;
        if(error){
            this.error(2);
            r.setText("0");
        }else{
            if(p.getText().toString().isEmpty()){
                po="0";
                this.error(1);
            }
            else{
                po=p.getText().toString();
                e.setText("");
                porcentaje=Integer.parseInt(po);
                if(porcentaje<1 || porcentaje>10){
                    this.error(2);
                    r.setText("0");
                }else{
                    calculadora= new Calculadora(porcentaje);
                    int x =calculadora.app(blindaje,dados);
                    //  int x =calculadora.app(Integer.parseInt(bl),Integer.parseInt(da));
                    // r.setText(x);
                    String resultado=String.valueOf(x);

                    r.setText(resultado);
                }
            }



        }
      //  String bl=b.getText().toString();
      //  String da=d.getText().toString();

    }

}
