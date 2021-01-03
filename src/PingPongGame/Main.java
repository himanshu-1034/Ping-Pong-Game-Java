package PingPongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements Runnable, KeyListener {

    final int HEIGHT = 500,WIDTH=700;
    int score1=0;
    Thread thread;
    UserPaddle p1;
    ComputerPaddle p2;
    boolean gameStarted;
    Ball b1;


    public Main(){
        gameStarted = false;
        p1 = new UserPaddle(1);
        b1 = new Ball();
        p2 = new ComputerPaddle(2,b1);

        thread = new Thread(this);
        thread.start();

        this.addKeyListener(this);


        this.setBackground(Color.black);
        this.setTitle("Ping Pong Game");
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(400,200,WIDTH,HEIGHT);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

//    public String winner(){
//        return score1==10 ? "GAME OVER. YOU WON, YOU SCORED 10 ON 10 POINTS." : "GAME OVER. YOUR SCORE WAS "+score1+" ON 10 BETTER LUCK NEXT TIME.";
//    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.GRAY);
        g.drawLine(350,0,350,500);


        if (b1.getX()<-10 || b1.getX()>710){
//            gameStarted=false;
            g.setColor(Color.green);
            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("GAME OVER.PRESS ENTER TO START",210,250);
        }
        else {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);
        }
        if (!gameStarted){
            g.setColor(Color.cyan);
            g.drawString("PING PONG",340,100);
            g.drawString("PRESS ENTER TO BEGIN.",310,130);
        }


    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void run() {
        while (true){

           if (gameStarted){
               p1.move();
               b1.move();
               p2.move();
               b1.checkPaddleCollision(p1,p2);
//               score1 = b1.getScore();
           }
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP){
            p1.setUpSpeed(true);
        }else if (e.getKeyCode()==KeyEvent.VK_DOWN){
            p1.setDownSpeed(true);
        }else if (e.getKeyCode()==KeyEvent.VK_ENTER){
            gameStarted=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP){
            p1.setUpSpeed(false);
        }else if (e.getKeyCode()==KeyEvent.VK_DOWN){
            p1.setDownSpeed(false);
        }
    }
}
