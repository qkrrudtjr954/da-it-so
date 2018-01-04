package delegator;

public class Delegator {
	private static Delegator instance = null;
	
	private Delegator() {
	}
	
	public static Delegator getInstance() {
		if(instance==null) {
			instance = new Delegator();
		}
		return instance;
	}
	
}
