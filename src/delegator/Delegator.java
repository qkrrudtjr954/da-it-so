package delegator;

public class Delegator {
	private static Delegator instance = null;
	
	private Delegator() {  //Ŀ���׽�Ʈ
	}
	
	public static Delegator getInstance() {
		if(instance==null) {
			instance = new Delegator();
		}
		return instance;
	}
	
}
