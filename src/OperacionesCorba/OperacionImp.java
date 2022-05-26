package OperacionesCorba;
import Fibonacci.Fibonacci;
import OperacionApp.OperacionPOA;
import org.omg.CORBA.ORB;
import java.lang.reflect.Array;

import java.util.Arrays;

public class OperacionImp extends OperacionPOA {
    private ORB orb;
  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }

  @Override
  // implementando método
  public String ejecutarOperacion(String nombre, int tam) {
    System.out.println(nombre+" de tamaño "+tam+":");
    Fibonacci f1 = new Fibonacci(nombre,tam);
    String datos = Arrays.toString(f1.mostrarSerie());
    int pos1 = datos.indexOf('[');
    int pos2 = datos.lastIndexOf(']');
    return datos.substring(pos1+1,pos2-1);
  }

  @Override
  public int sumar (int num1,int num2){
      int resultado;
      return resultado = num1 + num2;
  }

  @Override
  public int restar (int num1,int num2){
      int resultado;
      return resultado = num1 - num2;
  }  
  
  @Override
  public int dividir (int num1,int num2){
      int resultado;
      return resultado = num1 / num2;
  }  
  
  @Override
  public int multiplicar (int num1,int num2){
      int resultado;
      return resultado = num1 * num2;
  }
  
  @Override
  public void apagarConexion() {
    orb.shutdown(false);

  }

}
