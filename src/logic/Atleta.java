package logic;

import javax.swing.JOptionPane;
public class Atleta extends Persona
{
//Atributos Persona
    private String nombreAtleta;
    private int edadAtleta; 
    public Double estatura; 
    public String genero;
//Atributos Atleta
    public int claveAtleta;
	public String nacionalidad;
	public String deporte;
	public String categoria;
    
//Se inicializan los valores por default
    public Atleta(){
    	nombreAtleta = null;
    	edadAtleta =  0;
    	//TODO Estatura
        //TODO Genero
    	
        claveAtleta = 0;
        nacionalidad = null;
    }
    
//Constructor inicializado con parametros sobrecargados
    public Atleta(int np, String d, int ed, String nd){
        nombreAtleta = d;
        edadAtleta = ed;
        //TODO Estatura
        //TODO Genero
        
        claveAtleta = np;
        nacionalidad = nd;
    }
    
//Constructor 
    public Atleta(Atleta px){
        this.nombreAtleta = px.nombreAtleta;
        this.edadAtleta = px.edadAtleta;
        //TODO Estatura
        //TODO Genero
        
        this.claveAtleta = px.claveAtleta;
        this.nacionalidad = px.nacionalidad;
    }
    
    //Getters Setters Nombre
    public String getNombreAtleta(){return nombreAtleta;}
    public void setNombreAtleta(String d){nombreAtleta=d;}
    //Getters Setters Edad
    public int getEdadAtleta(){return edadAtleta;}
    public void setEdadAtleta(int ed){edadAtleta=ed;}
    //Getters Setters Clave
    public int getClaveAtleta(){return claveAtleta;}
    public void setClaveAtleta(int np){claveAtleta=np;}
    //TODO Estatura
    //TODO Genero
    
//Aqui se leen los datos de el atleta
    public void leerAtleta(int np){
            claveAtleta = np;
            nombreAtleta = JOptionPane.showInputDialog(null, "¿Cual es el nombre del atleta?", "Inserte nombre", JOptionPane.PLAIN_MESSAGE);
            edadAtleta = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cual es la edad del atleta?.", "Inserte edad", JOptionPane.PLAIN_MESSAGE));
            //TODO Estatura
            //TODO Genero
            
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
													        "\nEdad - E",
													        "\nCampos disponibles", JOptionPane.INFORMATION_MESSAGE);
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
            default: JOptionPane.showMessageDialog(null, "Intenta con las letras que se te dan!", "Opcion no valida", JOptionPane.WARNING_MESSAGE); break;
        }
    }
    
    
    public String toString(){
        return "Atleta numero:    " + claveAtleta +"\n"+
                "Nombre:    " + nombreAtleta +"\n"+
                "Edad:    " + edadAtleta +"\n";
    }
}