package servicio;

import dominio.Pelicula;
import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {
    
    private final List<Pelicula> peliculas;
    
    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("--- Lista de Peliculas ---");
        for (Pelicula e : peliculas) {
            System.out.println(e.getNombre());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula.getNombre());
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        int indice = peliculas.indexOf(pelicula);
        
        if (indice == -1) {
            System.out.println("No se encontro la pelicula " 
                    + pelicula.getNombre());
        } else {
            System.out.println("Pelicula " 
                    + pelicula.getNombre() 
                    + " encontrada en el indice: " + (indice + 1));
        }
    }
    
    
    
    
    // Este main es solamente para pruebas personales del programador
    

    
    
    
}
