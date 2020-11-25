package logic;

import javax.swing.JOptionPane;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Atleta extends Object implements Serializable
{
    private int claveAtleta, edadAtleta;
    private String nombreAtleta; 
    
	public String nacionalidad;
	public String deporte;
	public String categoria;
    
    
    public Atleta(){
        claveAtleta = 0;
        nombreAtleta = null;
        edadAtleta =  0;
        nacionalidad = null;
    }
    public Atleta(int np, String d, int ed, String nd){
        claveAtleta = np;
        nombreAtleta = d;
        edadAtleta = ed;
        nacionalidad = nd;
    }
    public Atleta(Atleta px){
        this.claveAtleta = px.claveAtleta;
        this.nombreAtleta = px.nombreAtleta;
        this.edadAtleta = px.edadAtleta;
        this.nacionalidad = px.nacionalidad;
    }
    public int getClaveAtleta(){return claveAtleta;}
    public void setClaveAtleta(int np){claveAtleta=np;}
    public String getNombreAtleta(){return nombreAtleta;}
    public void setNombreAtleta(String d){nombreAtleta=d;}
    public int getEdadAtleta(){return edadAtleta;}
    public void setEdadAtleta(int ed){edadAtleta=ed;}
    public String getNacionalidadAtleta(){return nacionalidad;}
    public void setNacionalidadAtleta(String nd) {nacionalidad =nd;}
    
    
    
    public void leerProducto(int np){
            claveAtleta = np;
            nombreAtleta = JOptionPane.showInputDialog(null, "¿Cual es el nombre de el atleta?");
            edadAtleta = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cual su edad?"));
            nacionalidad = JOptionPane.showInputDialog(null, "¿Cual es el la nacionalidad de el atleta?");
    }
    
    private boolean checarRangoInvalido(String sp){
        if(! (sp.toLowerCase().equals("n") ||
             sp.toLowerCase().equals("e"))){
            return true;
        }
        return false;
    }
    public void cambiar() throws Excpt{
        String subop = JOptionPane.showInputDialog(null, "Que campo quieres modificar?"+ 
													        "\nNombre - N" + 
													        "\nEdad - E" +
													        "nNacionalidad - Nd",
													        "Campos disponibles", JOptionPane.INFORMATION_MESSAGE);
        if(  checarRangoInvalido(subop) ){
            throw new Excpt();
        }
       
        
        switch( subop.toLowerCase() ) {
            case "n":
                String d = JOptionPane.showInputDialog(null, "Nuevo nombre.", "Cambio de nombre", JOptionPane.PLAIN_MESSAGE);
                setNombreAtleta(d);
                break;
            case "e":
                int ed = Integer.parseInt(JOptionPane.showInputDialog(null, "Nueva edad.", "Cambio de edad", JOptionPane.PLAIN_MESSAGE));
                setEdadAtleta(ed);
                break;
            case "nd":
            	String nd = JOptionPane.showInputDialog(null, "Nueva nacionalidad.", "Cambio de nacionalidad", JOptionPane.PLAIN_MESSAGE);
                setNacionalidadAtleta(nd);
            default: JOptionPane.showMessageDialog(null, "Intenta con las letras que se te dan!", "Opcion no valida", JOptionPane.WARNING_MESSAGE); break;
        }
    }
    public String toString(){
        return "Atleta numero:    " + claveAtleta +"\n"+
                "Nombre:    " + nombreAtleta +"\n"+
                "Edad:    " + edadAtleta +"\n"+
                "Nacionalidad:    " + nacionalidad + "\n";
    }
}