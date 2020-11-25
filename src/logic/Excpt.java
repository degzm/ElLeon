package logic;
@SuppressWarnings("serial")
public class Excpt extends Exception {
	public Excpt(){
		super();
	}
	@Override
	public String toString(){
		return "Error";
	}
}