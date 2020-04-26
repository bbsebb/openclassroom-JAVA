package apj.p2.personnage;
@FunctionalInterface
public interface EspritCombatif {
	
	public void combat();
	default void test() {
		System.out.println("Test de la methode defaut dans une interface.");
	}
	public static void test2() {
		System.out.println("Test de la methode static dans une interface.");
	}	
	
}