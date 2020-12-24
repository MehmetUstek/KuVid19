package domain;

public class SaveLoadAdapter implements ISaveLoad{
	
	ISaveLoad saveload;
	public SaveLoadAdapter(ISaveLoad saveload) {
		// TODO Auto-generated constructor stub
		this.saveload= saveload;
	}
	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		saveload.saveGame();
	}
	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
		saveload.loadGame();
	}

}
