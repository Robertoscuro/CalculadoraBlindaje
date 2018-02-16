package com.juego_de_rol.roberto.calculadorablindaje;

/**
 *
 * @author Roberto
 */
public class Calculadora {
    
    double p;
    //GestorIO gestor;
    boolean terminar;
    public Calculadora(double p){
       
        this.p=p/10;
       // gestor=GestorIO.getGestorIO();
        terminar=false;
        
    }

    public int app(int b,int d){
        return  this.calcular(b,d);
    }
    /*public void inicializar(){
        int x=0;
        int b=0;
        do{

            b=this.capturab();
            if(!this.terminar){
                 x=this.capturarnumero();
            }
           if(!this.terminar){
               gestor.escribirLinea("Iniciando calculos...");
            
            gestor.escribirLinea("El blinaje resultante es:");
            gestor.escribirLinea(this.calcular(b,x));
           }
            
        }while(!this.terminar);
    }

    private int capturarnumero() {
        int x=0;
        
        x=gestor.leerInt("Intoduzca el resultado de los dados: ");
        if(x==0){
            this.terminar=true;
        }
        else if(x>100){
             gestor.escribirLinea("Error");
             x=this.capturarnumero();
        }
        
        return x;
        
    }*/
    private int calcular (int b,int x){
        int y=0;
        double c=0;
        int c2=0;
        if(!this.terminar){
            
            c=(x*this.p);
            c2=(int) c;
            y=b-(c2);
            
        }
        
             return y;
        
    }


/*
    private int capturab() {
          int b=0;
        do{
        b=gestor.leerInt("Intoduzca el blindaje inicial: ");
        if(b==0){
            this.terminar=true;
        }
        }while((b<0 && b>100));
        return b;
    }*/
    
}
