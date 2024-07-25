package presentacion;

import dominio.Pelicula;
import java.util.Scanner;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivos;
import servicio.ServicioPeliculasLista;

public class Main {
    
    public static void main(String[] args) {
        
        boolean salir = false;
        Scanner input = new Scanner(System.in);
        
//        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivos();
        
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(input, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
            }
        }
        
    }
    
    private static void mostrarMenu() {
        System.out.println("""
                           *** Catalogo de Peliculas ***
                           1. Agregar Pelicula.
                           2. Lista de Peliculas.
                           3. Buscar Pelicula.
                           4. Salir.
                           Elige una opcion
                           """);
    }
    
    public static boolean ejecutarOpciones(Scanner input, IServicioPeliculas servicioPeliculas) {
        
        int opcion = Integer.parseInt(input.nextLine());
        boolean salir = false;
        
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula");
                String nombrePelicula = input.nextLine();
//                Pelicula nuevaPelicula = new Pelicula(nombrePelicula);
//                servicioPeliculas.agregarPelicula(nuevaPelicula);
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 -> {
                System.out.println("Introduce la pelicula que quieres buscar");
                String buscar = input.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto!!");
                salir = true;
            }
            default -> {
                System.out.println("La opcion ingresada no es valida");
            }
        }
        return salir;
    }
    
}
