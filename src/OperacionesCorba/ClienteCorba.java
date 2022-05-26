package OperacionesCorba;

import OperacionApp.Operacion;
import OperacionApp.OperacionHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import java.util.Scanner;

public class ClienteCorba {

    static Operacion operacionImp;

    public static void main(String args[]) {
        try {
            // Se crea e inicializa el ORB
            ORB orb = ORB.init(args, null);
            // obtener el contexto de la raíz (un nombre)
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Utilice NamingContextExt en lugar de NamingContext.
            // Esto es parte del servicio de nombres interoperable.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolver la referencia de objeto en Naming
            String name = "Fibonacci";
            operacionImp = OperacionHelper.narrow(ncRef.resolve_str(name));

            //MENU DE OPERACIONES   
            Scanner sc = new Scanner(System.in);
            int eleccion;
            String menu = "\n======================================\n[-1] => Salir\n[1] => Realizar una suma\n[2] => Realizar una resta\n[3] => Realizar una multiplicacion\n[4] => Realizar una division\n Elige: ";
            do {
                System.out.println(menu);

                //Convertir a numero la entrada
                try {
                    eleccion = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    eleccion = -1;
                }

                if (eleccion != -1) {

                    System.out.println("=====================================");

                    switch (eleccion) {
                        case 1:
                            System.out.println("            ---SUMAR---");
                            System.out.println("Ingresa el numero 1");
                            int Snum1 = sc.nextInt();
                            System.out.println("Ingresa el numero 2");
                            int Snum2 = sc.nextInt();
                            System.out.println(" Resultado: " + operacionImp.sumar(Snum1, Snum2));
                            break;
                        case 2:
                            System.out.println("            ---RESTAR---");
                            System.out.println("Ingresa el numero 1");
                            int Rnum1 = sc.nextInt();
                            System.out.println("Ingresa el numero 2");
                            int Rnum2 = sc.nextInt();
                            System.out.println(" Resultado: " + operacionImp.restar(Rnum1, Rnum2));
                            break;
                        case 3:
                            System.out.println("            ---MULTIPLICACION---");
                            System.out.println("Ingresa el numero 1");
                            int Mnum1 = sc.nextInt();
                            System.out.println("Ingresa el numero 2");
                            int Mnum2 = sc.nextInt();
                            System.out.println(" Resultado: " + operacionImp.multiplicar(Mnum1, Mnum2));
                            break;
                        case 4:
                            System.out.println("            ---DIVISION---");
                            System.out.println("Ingresa el numero 1");
                            int Dnum1 = sc.nextInt();
                            System.out.println("Ingresa el numero 2");
                            int Dnum2 = sc.nextInt();
                            System.out.println(" Resultado: " + operacionImp.dividir(Dnum1, Dnum2));
                            break;

                    }

                    System.out.println("Presiona ENTER para continuar");
                    sc.nextLine();
                }
            } while (eleccion != -1);
            operacionImp.apagarConexion();

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
