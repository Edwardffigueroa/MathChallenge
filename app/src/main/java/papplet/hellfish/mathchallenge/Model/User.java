package papplet.hellfish.mathchallenge.Model;

/**
 * Created by edward on 8/08/17.
 */

public class User {

    int buenas=0;
    int malas=0;
    private String nombre;

    public User(String nombre) {
        this.nombre = nombre;
    }

    public void addbuenas(){
        buenas++;
    }

    public void addMalas(){
        malas++;
    }

    public int getBuenas() {
        return buenas;
    }

    public void setBuenas(int buenas) {
        this.buenas = buenas;
    }

    public int getMalas() {
        return malas;
    }

    public void setMalas(int malas) {
        this.malas = malas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
