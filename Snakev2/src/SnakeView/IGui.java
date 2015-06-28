package SnakeView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public interface IGui {
    
    
    
	/**
	 * informs the gui that the snake is at this position.
	 * <p>
	 * The snake may be at more than one position at a time.
	 * 
	 * @param x
	 *            x
	 * @param y
	 *            y
	 */
	void setSnake(int x, int y);

	/**
	 * informs the gui that a bonus is at this position.
	 * <p>
	 * There may be more than one bonus in the field.
	 * 
	 * @param x
	 *            x
	 * @param y
	 *            y
	 */
	void setBoni(int x, int y);

	/**
	 * informs the gui that a border (unwalkable square) is at this position.
	 * <p>
	 * There may be more than one unwalkable square in the field.
	 * <p>
	 * Most of the time it will not be necessary to update the borders in the
	 * gui every time this method is called as borders tend to be fixed.
	 * 
	 * @param x
	 *            x
	 * @param y
	 *            y
	 */
	void setBorder(int x, int y);

	/**
	 * informs the gui that this position does not hold anything (but it does
	 * exist).
	 * 
	 * @param x
	 *            x
	 * @param y
	 *            y
	 */
	void setEmpty(int x, int y);

	/**
	 * informs the gui about the current score of the player.
	 * 
	 * @param score
	 *            score
	 */
	void setScore(int score);

	/**
	 * sends a message to the gui. This may be information about the game state
	 * (for example game over).
	 * 
	 * @param message
	 *            message
	 */
        
        void perdiste();

	/**
	 * is always called after all other methods in this interface where called
	 * by the controller for this turn.
	 */
	void updateUI();

    
    
    
    
    
    
    
    
}
