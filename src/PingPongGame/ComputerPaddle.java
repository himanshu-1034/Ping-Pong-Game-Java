package PingPongGame;

import java.awt.*;

public class ComputerPaddle implements Paddle {
    double y,yVelocity;
    final double GRAVITY = 0.94;
    boolean upSpeed,downSpeed;
    int players , x;
    Ball b1;

    public ComputerPaddle(int players,Ball b) {

        upSpeed=false;
        downSpeed=false;
        b1 = b;
        y=210;
        yVelocity = 0;
        if (players==1)
            x=20;
        else
            x=660;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,(int)y,20,80);

    }

    @Override
    public void move() {

        y= b1.getY() - 40;



        if (y<0)
            y=0;
        else if (y>420)
            y=420;
    }



    @Override
    public int getY() {
        return (int)y;
    }
}
