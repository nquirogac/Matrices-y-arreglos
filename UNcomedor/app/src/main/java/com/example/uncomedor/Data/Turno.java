package com.example.uncomedor.Data;

public class Turno {
    private int numTurno;
    Comedor turnoCom;
    private Usuario turnoUsuario;
    private Menu turnoMenu;

    public Turno(int numTurno, Comedor turnoCom, Usuario turnoUsuario, Menu turnoMenu) {
        this.numTurno = numTurno;
        this.turnoCom = turnoCom;
        this.turnoUsuario = turnoUsuario;
        this.turnoMenu = turnoMenu;
        
    }

	public void setNumTurno(int numTurno){
        this.numTurno = numTurno;
    }
    public int getNumTurno(){
        return this.numTurno;
    }
    public void setTurnoCom(Comedor turnoCom){
        this.turnoCom = turnoCom;
    }
    public Comedor getTurnoCom(){
        return this.turnoCom;
    }
    public void setTurnoUsuario(Usuario turno){
        this.turnoUsuario= turno;
    }
    public Usuario getTurnoUsuario(){
        return this.turnoUsuario;
    }
    public void setTurnoMenu(Menu turnoMenu){
        this.turnoMenu = turnoMenu;
    }
    public Menu getTurnoMenu(){
        return this.turnoMenu;
    }
    public String toString()
	{
		return this.numTurno + " " + turnoCom.toString() + " "+ this.turnoUsuario.toString(); 
	}


    
}
