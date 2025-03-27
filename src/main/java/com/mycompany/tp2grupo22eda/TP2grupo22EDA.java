

package com.mycompany.tp2grupo22eda;

import static com.mycompany.tp2grupo22eda.JJOO.agregarPaises;
import static com.mycompany.tp2grupo22eda.JJOO.cargarDatos;
import static com.mycompany.tp2grupo22eda.JJOO.eliminarLista;
import static com.mycompany.tp2grupo22eda.JJOO.mostrarDatos;
import static com.mycompany.tp2grupo22eda.JJOO.ordenarBurbuja;
import static com.mycompany.tp2grupo22eda.JJOO.ordenarInsercion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luciano
 */


public class TP2grupo22EDA {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        ArrayList<JJOO> lista = new ArrayList<>();
        boolean datosCargados = false;
        int opcion;
        do {
            System.out.println("\n---MENU----");
            System.out.println("1- cargar datos");
            System.out.println("2- mostrar datos en el orden ingresado");
            System.out.println("3- ordenar con metodo burbuja");
            System.out.println("4- ordenar con metodo por insercion");
            System.out.println("5- agregar pais adicional");
            System.out.println("6- eliminar lista actual");
            System.out.println("7- salir");
            System.out.print("seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch  (opcion)  {
                case 1:
                    lista = cargarDatos();
                    datosCargados = true;
                    break;
                case 2:
                    if(datosCargados && !lista.isEmpty()) {
                        System.out.println("\ndatos en orden ingresado:");
                        mostrarDatos(lista);
                    } else {
                        System.out.println("no hay datos cargados");
                    }
                    break;
                case 3:
                    if(datosCargados && !lista.isEmpty()) {
                        ArrayList<JJOO> copia = new ArrayList<>(lista);
                        long inicio = System.nanoTime();
                        ordenarBurbuja(copia);
                        long fin = System.nanoTime();
                        System.out.println("\ndatos ordenados con metodo burbuja");
                        mostrarDatos(copia);
                        System.out.println("tiempo de ejecucion (nanosegundos): " + (fin - inicio));
                    } else {
                        System.out.println("no hay datos cargados");
                    }
                    break;
                case 4:
                    if(datosCargados && !lista.isEmpty()) {
                        ArrayList<JJOO> copia = new ArrayList<>(lista);
                        long inicio = System.nanoTime();
                        ordenarInsercion(copia);    
                        long fin = System.nanoTime();
                        System.out.println("\ndatos ordenados con metodo insercion");
                        mostrarDatos(copia);
                        System.out.println("tiempo de ordenamiento (nanosegundos): " + (fin - inicio));
                    } else {
                        System.out.println("no hay datos cargados");
                    }
                    break;
                case 5:
                    if(datosCargados) {
                        lista = agregarPaises(lista);
                    } else {
                        System.out.println("no hay datos cargados use la opcion 1 para cargar datos");
                    }
                    break;
                case 6:
                    lista = eliminarLista();
                    datosCargados = false;
                    System.out.println("lista eliminada");
                    break;
                case 7:
                    System.out.println("saliendo del programa");
                    break;
                default:
                    System.out.println("opcion invalida intente nuevamente");
            }
        } while(opcion != 7);
    }
    }

