package logic;

import javax.swing.JOptionPane;
public class Atleta extends Persona{
	
//Atributos Persona
    private String nombreA;
    private int edadA; 
    public Double estatura; 
    public String genero;
//Atributos Atleta
    public int claveAtleta;
	public String nacionalidad;
	public String deporte;
	public String categoria;
    
//Se inicializan los valores por default
    public Atleta(){
    	//Atributos Persona
    	nombreA = null;
    	edadA =  0;
    	estatura = 0.0;
    	genero = null;
    	//Atributos Atleta
        claveAtleta = 0;
        nacionalidad = null;
        deporte = null;
    }
    
//Constructor inicializado con parametros sobrecargados
    public Atleta(int np, String d, int ed, String nd, Double es, String gn, String dp){
    	claveAtleta = np;
    	//Atributos Persona
        nombreA = d;
        edadA = ed;
        estatura = es;
        genero = gn;
        //Atributos Atleta
        nacionalidad = nd;
        deporte = dp;
    }
    
//Constructor 
    public Atleta(Atleta px){
    	//Atriutos Persona
        this.nombreA = px.nombreA;
        this.edadA = px.edadA;
        this.estatura = px.estatura;
        this.genero = px.genero;
        //Atributos Atleta
        this.claveAtleta = px.claveAtleta;
        this.nacionalidad = px.nacionalidad;
        this.deporte = px.deporte;
    }
    
    //Getters Setters Clave
    public int getClaveAtleta(){return claveAtleta;}
    public void setClaveAtleta(int np){claveAtleta=np;}
    //Getters Setters Nombre
    public String getNombreAtleta(){return nombreA;}
    public void setNombreAtleta(String d){nombreA=d;}
    //Getters Setters Edad
    public int getEdadAtleta(){return edadA;}
    public void setEdadAtleta(int ed){edadA=ed;}
    //Getters Setters Estatura
    public double getEstatura(){return estatura;}
    public void setEstatura(Double es){estatura = es;}
    //Getters Setters Genero
    public String getGenero(){return genero;}
    public void setGenero(String gn){genero=gn;}
    //Getters Setters Nacionalidad
    public String getNacionalidad(){return nacionalidad;}
    public void setNacionalidad(String nd){nacionalidad=nd;}
    //Getters Setters deporte
    public String getDeporte(){return deporte;}
	public void setDeporte(String deporte){this.deporte = deporte;}
    
    
    
//Aqui se leen los datos de el atleta
    public void leerAtleta(int np){
            claveAtleta = np;
            nombreA = JOptionPane.showInputDialog(null, "¿Cual es el nombre del atleta?", "Inserta porfa el nombre", JOptionPane.WARNING_MESSAGE);
            edadA = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cual es la edad del atleta?.", "Inserte edad", JOptionPane.PLAIN_MESSAGE));
            estatura = Double.parseDouble(JOptionPane.showInputDialog(null, "¿Cual es la estatura del atleta?", "Inserte estatura", JOptionPane.PLAIN_MESSAGE));
            genero = JOptionPane.showInputDialog(null, "¿Cual es el genero del atleta?", "Inserte genero", JOptionPane.PLAIN_MESSAGE);
            nacionalidad = JOptionPane.showInputDialog(null,"Cual es la nacionalidad del atleta?","Inserte Nacionalidad",JOptionPane.PLAIN_MESSAGE);
            deporte = JOptionPane.showInputDialog(null,"Cual es el deporte del atleta?","Inserte deporte/disciplina",JOptionPane.PLAIN_MESSAGE);
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
                "Nombre:    " + nombreA +"\n"+
                "Edad:    " + edadA +"\n"+
                "Estatura:   " + estatura + "\n" +
                "Genero:     " + genero + "\n"+
                "Nacionalidad:   " + nacionalidad + "\n"+
                "Deporte:   " + deporte + "\n";
    }
}