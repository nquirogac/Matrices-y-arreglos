package com.example.uncomedor.Data;

public class Comedor {
    int capacidad;
    String nombre;
    Menu menu;
    Cola colaComedor;
    int ocupacion;
    int turno;
    //podriamos poner las coordenadas en donde esta para lo de la geolocalizacion al final
    public Comedor (int capac,String nomb){
        this.capacidad = capac;
        this.nombre = nomb;
    }
    public Comedor(int capac, String nomb, Menu menu, Cola colaComedor) {
        this.capacidad = capac;
        this.nombre = nomb;
        this.menu = menu;
        this.colaComedor = colaComedor;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    }
    public int getTurno() {
        return this.turno;
    }
    public String toString()
	{
		return this.nombre;
	}
    public Cola getcolaComedor() {
        return this.colaComedor;
    }
    
}
