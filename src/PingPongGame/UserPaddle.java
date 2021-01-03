package PingPongGame;

import java.awt.*;

public class UserPaddle implements Paddle{

    double y,yVelocity;
    final double GRAVITY = 0.94;
    boolean upSpeed,downSpeed;
    int players , x;

    public UserPaddle(int players) {

        upSpeed=false;
        downSpeed=false;
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
        if (upSpeed){
            yVelocity-=2;
        }
        else if (downSpeed){
            yVelocity+=2;
        }
        else if (!upSpeed && !downSpeed){
            yVelocity*=GRAVITY; // logic is to decrease down the movement of paddle is we are not moving up or down.
        }

        if (yVelocity>=5)
            yVelocity=5;
        else if (yVelocity<=-5)
            yVelocity = -5;


        y+=yVelocity;

        if (y<0)
            y=0;
        else if (y>420)
            y=420;
    }

    public void setUpSpeed(boolean input){
        upSpeed = input;
    }

    public void setDownSpeed(boolean input){
        downSpeed = input;
    }

    @Override
    public int getY() {
        return (int)y;
    }
}
