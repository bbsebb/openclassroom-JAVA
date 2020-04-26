package apj.p2;

public class Test {
	public static void main(String[] args) {
	
		Ville v = null;
		try {
			v = new Capital("test",100,"France","Tour");
		} catch (NombreHabitantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomVilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(v.toString());
		Ville v2 = (Capital)v;
		System.out.println(v2.toString());
	}
	
	

}

