package RPG_Game;

import Display.GameCamera;
import Input.KeyManager;
import Input.MouseManager;
import Levels.Level;

public class Handler {
	
	private Game game;
	private Level level;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
