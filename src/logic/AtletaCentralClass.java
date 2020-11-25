package logic;

import java.io.*;
import javax.swing.JOptionPane;

public class AtletaCentralClass extends Object{
    private Atleta pros[];
    private int auxiliar;
    private int numAtleta;
    
    public AtletaCentralClass(int n){
        pros = new Atleta[n];
        for (int i=0; i<n; i++){
            pros[i] = new Atleta();
        }
        auxiliar = 0;
        numAtleta = 0;
    }
    public void alta(){
        if(auxiliar < pros.length){
            pros[auxiliar].leerProducto(numAtleta);
            auxiliar++;
            numAtleta++;
        }
        else{
            JOptionPane.showMessageDialog(null, "Base de datos de atletas llena.", "Intenta liberarla o aumentarla!", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void baja(int np){
        if (encontrado(np)){
            int pos = buscar(np);
            for(int i = pos; i<(auxiliar-1); i++){
                pros[i].setClaveAtleta( pros[i+1].getClaveAtleta() );
                pros[i].setNombreAtleta( pros[i+1].getNombreAtleta() );
                pros[i].setEdadAtleta( pros[i+1].getEdadAtleta() );
            }
            auxiliar--;
        }
        else{
            JOptionPane.showMessageDialog(null, "El atleta no esta registrado!.", "Inexistente!", JOptionPane.WARNING_MESSAGE);
        }
    }
    private boolean encontrado(int np){
        for(int i=0; i<auxiliar; i++){
            if (pros[i].getClaveAtleta() == np)
                return true;
        }
        return false;
    }
    private int buscar(int np){
        int pos=0;
        for(int i=0; i<auxiliar; i++){
            if(pros[i].getClaveAtleta() == np){
                pos = i;
                break;
            }
        }
        return pos;
    }
    public void consulta(int np) throws Exception{
        if( encontrado(np)){
            int pos = buscar(np);
            JOptionPane.showMessageDialog(null, pros[pos].toString(), "Atleta encontrado", JOptionPane.INFORMATION_MESSAGE );
        }
        else{
        	JOptionPane.showMessageDialog(null, "Este Atleta no esta registrado!", "Inexistente", JOptionPane.ERROR_MESSAGE, null);
        	throw new Exception();
        }
    }
    public void cambio(int np) throws Excpt{
        if( encontrado(np)){
            int pos = buscar(np);
            JOptionPane.showMessageDialog(null, pros[pos].toString(), "Estas a punto de hacer cambios en", JOptionPane.INFORMATION_MESSAGE);
            pros[pos].cambiar();
        }
        else{
        	JOptionPane.showMessageDialog(null, "Este Atleta no esta registrado!", "Inexistente", JOptionPane.ERROR_MESSAGE, null);
        }
    
    }
    public String toString(){
        String aux = "";
        for(int i=0; i < auxiliar; i++){
            aux = aux + pros[i].toString() + "\n";
        }
        return aux;
    }
    public void guardar(){ 
       Atleta c = null;
       try{    
           FileOutputStream fout = new FileOutputStream("C:\\Users\\Jorge\\Desktop\\Clientes.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fout);   
           for(int i=0; i<auxiliar; i++){
               c = pros[i];
               oos.writeObject(c);
           }
           //Final del guardado
           oos.close();
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    public void cargar(){
       Atleta atletaDoc = null;
       try{
           FileInputStream fin = new FileInputStream("C:\\Users\\Diego\\Desktop\\atlet.dat");
           ObjectInputStream ois = new ObjectInputStream(fin);
           int i = 0; auxiliar = 0;
           try{
               while(true){
                   
                   atletaDoc = (Atleta) ois.readObject();
                   pros[i] = new Atleta(atletaDoc);
                   numAtleta = pros[i].getClaveAtleta();
                   auxiliar++;
                   i++; 
                   JOptionPane.showMessageDialog(null, "Se cargo : " + atletaDoc);
                }
            }
            catch(EOFException eoefe){
                
            }
            finally{
            	//Final de el cargado
                ois.close(); 
            }
        }
        catch(Exception ex){
        	//Si no se encuentra el archivo, procede esto
        	guardar();
        	JOptionPane.showMessageDialog(null, "No existe el archivo, se creara uno vacio!", 
        			"Creando uno nuevo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void cargarS(){
        Atleta atledaDoc = null;
        try{
            FileInputStream fin = new FileInputStream("C:\\Users\\Diego\\Desktop\\atlet.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            int i = 0; auxiliar = 0;
            try{
                while(true){
                    
                    atledaDoc = (Atleta) ois.readObject();
                    pros[i] = new Atleta(atledaDoc);
                    numAtleta = pros[i].getClaveAtleta();
                    auxiliar++;
                    i++;
                 }
             }
             catch(EOFException eoefe){
                 
             }
             finally{
             	//Final de el cargado
                 ois.close(); 
             }
         }
         catch(Exception ex){
         	//Si no se encuentra el archivo, procede esto
         	guardar();
         	JOptionPane.showMessageDialog(null, "No existe el archivo, se creara uno vacio!", 
         			"Creando uno nuevo", JOptionPane.INFORMATION_MESSAGE);
         }
     }
}//class