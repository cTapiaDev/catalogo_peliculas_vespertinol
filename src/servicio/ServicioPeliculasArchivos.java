package servicio;

import dominio.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivos implements IServicioPeliculas {
    
    private final String NOMBRE_ARCHIVO  = "peliculas.txt";
    
    public ServicioPeliculasArchivos() {
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            
            if (archivo.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("El archivo se creo correctamente");
            }
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
    

    @Override
    public void listarPeliculas() {
        
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            
            System.out.println("--- Lista de Peliculas ---");
            
            // abrir archivo en modo lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            String linea;
            linea = entrada.readLine();
            
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula.getNombre());
                
                linea = entrada.readLine();
            }
            
            entrada.close();
            
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        
        boolean agregar = false;
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            
            agregar = archivo.exists();
            
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, agregar));
            
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se agrego la pelicula: " + pelicula.getNombre());
            
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            String linea = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;
            String buscar = pelicula.getNombre();
            
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    encontrada = true;
                    break;
                }
                
                linea = entrada.readLine();
                indice++;
            }
            
            if (encontrada) {
                System.out.println("Pelicula " + linea 
                        + " encontrada - linea " + indice);
            } else {
                System.out.println("No se encontro la pelicula: " + pelicula.getNombre());
            }
            
            
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        
    }
    
}
