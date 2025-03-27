package com.mycompany.tp2grupo22eda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
   
public class JJOO {
    private String pais;
    private int medallasBronce;
    private int medallasPlata;
    private int medallasOro;
    private int ranking;

    public JJOO(String pais, int medallasBronce, int medallasPlata, int medallasOro, int ranking) {
        this.pais = pais;
        this.medallasBronce = medallasBronce;
        this.medallasPlata = medallasPlata;
        this.medallasOro = medallasOro;
        this.ranking = ranking;
    }

    public String getPais() {
        return pais;
    }

    public int getMedallasBronce() {
        return medallasBronce;
    }

    public int getMedallasPlata() {
        return medallasPlata;
    }

    public int getMedallasOro() {
        return medallasOro;
    }

    public int getRanking() {
        return ranking;
    }

    public static ArrayList<JJOO> cargarDatos() {
        ArrayList<JJOO> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Ingrese la cantidad de paises a registrar: ");
            if (sc.hasNextInt()) {  
                n = sc.nextInt();
                if (n > 0) break; 
                else System.out.println("Please ingrese un numero mayor a 0.");
            } else {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
                sc.next(); 
            }
        }

        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            String pais;
            boolean existe;
            do {
                System.out.print("Nombre del pais: ");
                pais = sc.nextLine();
                final String paisAux = pais; 
                existe = lista.stream().anyMatch(j -> j.getPais().equalsIgnoreCase(paisAux));
                if (existe) {
                    System.out.println("El pais ya existe, ingrese otro porfa.");
                }
            } while (existe);

            System.out.print("Cantidad de medallas de oro: ");
            int oro = sc.nextInt();
            System.out.print("Cantidad de medallas de plata: ");
            int plata = sc.nextInt();
            System.out.print("Cantidad de medallas de bronce: ");
            int bronce = sc.nextInt();
            System.out.print("Ranking: ");
            int ranking = sc.nextInt();
            sc.nextLine(); 

            lista.add(new JJOO(pais, bronce, plata, oro, ranking));
        }
        return lista;
    }

    public static void mostrarDatos(ArrayList<JJOO> lista) {
        for (JJOO j : lista) {
            System.out.println(j);
        }
    }

    @Override
    public String toString() {
        return "pais: " + pais + "  oro: " + medallasOro + "  plata: " + medallasPlata + "  bronce: " + medallasBronce + "  ranking: " + ranking;
    }

    public static class ComparadorMedallas implements Comparator<JJOO> {
        public int compare(JJOO j1, JJOO j2) {
            if (j1.medallasOro != j2.medallasOro) {
                return j2.medallasOro - j1.medallasOro;
            }
            if (j1.medallasPlata != j2.medallasPlata) {
                return j2.medallasPlata - j1.medallasPlata;
            }
            if (j1.medallasBronce != j2.medallasBronce) {
                return j2.medallasBronce - j1.medallasBronce;
            }
            return j1.pais.compareToIgnoreCase(j2.pais);
        }
    }

    public static void ordenarBurbuja(ArrayList<JJOO> lista) {
        Comparator<JJOO> comp = new ComparadorMedallas();
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comp.compare(lista.get(j), lista.get(j + 1)) > 0) {
                    JJOO temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    public static void ordenarInsercion(ArrayList<JJOO> lista) {
        Comparator<JJOO> comp = new ComparadorMedallas();
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            JJOO clave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && comp.compare(lista.get(j), clave) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, clave);
        }
    }

    public static ArrayList<JJOO> agregarPaises(ArrayList<JJOO> lista) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.print("Ingrese la cantidad de paises a agregar: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) break;
                else System.out.println("Porfis ingrese un número mayor a 0.");
            } else {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
                sc.next();
            }
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String pais;
            boolean existe;
            do {
                System.out.print("Nombre del pais: ");
                pais = sc.nextLine();
                final String paisAux = pais; // Variable auxiliar para la lambda
                existe = lista.stream().anyMatch(j -> j.getPais().equalsIgnoreCase(paisAux));
                if (existe) {
                    System.out.println("El país ya existe, ingrese otro.");
                }
            } while (existe);

            System.out.print("Cantidad de medallas de oro: ");
            int oro = sc.nextInt();
            System.out.print("Cantidad de medallas de plata: ");
            int plata = sc.nextInt();
            System.out.print("Cantidad de medallas de bronce: ");
            int bronce = sc.nextInt();
            System.out.print("Ranking: ");
            int ranking = sc.nextInt();
            sc.nextLine(); 

            lista.add(new JJOO(pais, bronce, plata, oro, ranking));
        }
        return lista;
    }

    public static ArrayList<JJOO> eliminarLista() {
        return new ArrayList<>();
    }
}


