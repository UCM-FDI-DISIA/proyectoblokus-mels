package model;

public interface BlokusObserver {
	
	public void onBoardChange();
	public void onPlayerChange();
	public void onFinishGame();
	
}
