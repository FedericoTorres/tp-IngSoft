package Snake.SnakeView;

public interface IGui 
{
    void setSnake(int x, int y);

    void setBoni(int x, int y);

    void setBorder(int x, int y);

    void setEmpty(int x, int y);

    void setScore(int score);

    void sendMessage(String message);

    void updateUI();
}
