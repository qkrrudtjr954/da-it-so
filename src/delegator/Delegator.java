package delegator;

public class Delegator {
	private static Delegator instance = null;
	
	private Delegator() {  //Ä¿¹ÔÅ×½ºÆ®
	}
	
	public static Delegator getInstance() {
		if(instance==null) {
			instance = new Delegator();
		}
		return instance;
	}
	
}
