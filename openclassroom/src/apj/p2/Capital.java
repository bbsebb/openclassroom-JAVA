package apj.p2;

public class Capital extends Ville{
	
	private String monument;
	public Capital() {
		super();
		this.monument = "aucun";
	}
	

	public Capital(String nomVille,int nbreHabitants,String nomPays,String monument)  throws  NombreHabitantException, NomVilleException
	{  
		super(nomVille,nbreHabitants,nomPays);
		this.monument = monument;         
		}	
	public String getMonument() {
		    return monument;
	} 

	public void setMonument(String monument) {
		    this.monument = monument;
	}   
	
	
	
	
	public String decrisToi(){
	    String str =  super.decrisToi() + "\n \t ==>>" + this.monument+ " en est un monument"; 
	    return str;
	}
	
	public String toString(){
		  String str = super.toString() + "\n \t ==>>" + this.monument + " en est un monument";
		  return str;
	}	
}
