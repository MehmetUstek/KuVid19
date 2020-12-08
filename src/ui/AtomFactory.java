package ui;

public class AtomFactory {
	
	private static AtomFactory instance;
	
	public AtomFactory() {
		// TODO Auto-generated constructor stub
	}

	
		
	public static AtomFactory getInstance() {
		if (instance == null) {
			instance = new AtomFactory();
		}
		return instance;
	}
	
//	public IStorageServiceAdapter getStorageServiceAdapter(String serviceUsed)  {
//		IStorageServiceAdapter storageService;
//		if (serviceUsed == "GoodAsGold")
//			storageService= new  GoodAsGoldServiceAdapter();
//		else
//			storageService= new BestStorageServiceAdapter();
//	
//		return storageService;
//	}

}
