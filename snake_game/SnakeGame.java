package snake_game;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{
    Random random = new Random();
    private class Tile{
        int x;
        int y;

        Tile(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int boardHeight, boardWidth;
    int tilesize = 25;

    Tile snakeHead;
    ArrayList<Tile> snakeBody;

    Tile food;
    
    //game Logic
    Timer gameLoop;
    int velocityx;
    int velocityy;
    boolean gameOver = false;
    
    public SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        snakeBody = new ArrayList<Tile>();


        snakeHead = new Tile(5, 5);
        food = new Tile(10, 10);
        placeFood();
        velocityx = 0;
        velocityy = 0;

        gameLoop = new Timer(100, this);
        gameLoop.start();


}
public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
}

public void draw(Graphics g){
    //Grid
    /*for(int i = 0; i<boardWidth/tilesize; i++){
        g.drawLine(i*tilesize, 0, i*tilesize, boardHeight);
        g.drawLine(0, i*tilesize, boardWidth, i*tilesize);
    }*/

    g.setColor(Color.red);
    //g.fillRect(food.x * tilesize, food.y * tilesize, tilesize, tilesize);
    g.fill3DRect(food.x * tilesize, food.y * tilesize, tilesize, tilesize, true);
    //Snake Head
    g.setColor(Color.green);
    //g.fillRect(snakeHead.x * tilesize, snakeHead.y * tilesize, tilesize, tilesize);
    g.fill3DRect(snakeHead.x * tilesize, snakeHead.y * tilesize, tilesize, tilesize, true);
    //Snake Body
    for(int i = 0; i < snakeBody.size(); i++){
        Tile snakePart = snakeBody.get(i);
        //g.fillRect(snakePart.x*tilesize, snakePart.y*tilesize, tilesize, tilesize);
        g.fill3DRect(snakePart.x*tilesize, snakePart.y*tilesize, tilesize, tilesize, true);
    }
     //Score Board
     g.setFont(new Font("Arial", Font.PLAIN, 16));
     if (gameOver) {
        g.setColor(Color.red);
        g.drawString("Game Over", tilesize - 16, tilesize);
        FontMetrics fontMetrics = g.getFontMetrics(); // for getting the font width and height of the above text
        int fontHeight = fontMetrics.getHeight();
        g.drawString("Score: " + String.valueOf(snakeBody.size()), tilesize - 16, tilesize + fontHeight);
    }
    
    
     else{
        g.drawString("Score: " + String.valueOf(snakeBody.size()), tilesize - 16, tilesize);
     }
}
public void placeFood(){
    food.x = random.nextInt(boardWidth/tilesize); //600/25 = 24
    food.y = random.nextInt(boardHeight/tilesize);
}

public boolean collision(Tile tile1, Tile tile2){
    return (tile1.x == tile2.x) && (tile1.y == tile2.y);

}
public void move(){
    //Game over conditions for i) colliding with its own body and ii) with the boundary of the board
    for (int i = 0; i<snakeBody.size(); i++){
        Tile snakePart = snakeBody.get(i);
        //i) if snake collides with its own head
        if (collision(snakeHead, snakePart)){
            gameOver = true;
        }
    }
    // ii) if snake hits the boundary
    if (snakeHead.x * tilesize < 0 || snakeHead.x * tilesize > boardWidth || snakeHead.y * tilesize < 0 || snakeHead.y * tilesize > boardHeight){
        gameOver = true;
    }

    //eating the food
    if(collision(snakeHead, food)){
        snakeBody.add(new Tile(food.x, food.y));
        placeFood();
    }
    //Snake body
    for (int i = snakeBody.size() - 1; i >= 0; i--){
        Tile snakePart = snakeBody.get(i);
        if(i == 0){
            snakePart.x = snakeHead.x;
            snakePart.y = snakeHead.y;
        }
        else{
            Tile prevSnakePart = snakeBody.get(i - 1);
            snakePart.x = prevSnakePart.x;
            snakePart.y = prevSnakePart.y;
        }
    }

    //snake head
    snakeHead.x += velocityx;
    snakeHead.y += velocityy; 
}
@Override
public void actionPerformed(ActionEvent e) {
    move();
    repaint();
    if (gameOver){
        gameLoop.stop();
    }
}
@Override
public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_UP && velocityy != 1){
        velocityx = 0;
        velocityy = -1;
    }
    else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityy != -1){
        velocityx = 0;
        velocityy = 1;
    }
    else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityx != 1){
        velocityx = -1;
        velocityy = 0;
    }
    else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityx != -1){
        velocityx = 1;
        velocityy = 0;
    }

}
// koi zarurat nhi
@Override
public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
}
@Override
public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
}
}
