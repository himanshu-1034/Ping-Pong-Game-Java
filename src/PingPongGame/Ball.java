package PingPongGame;

import java.awt.*;

public class Ball {
    double xVelocity,yVelocity,x,y;
    int score=0;

    public Ball(){
        x=350;
        y=250;
        xVelocity=-2;
        yVelocity=1;
    }

    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval((int)x-10,(int)y-10,20,20); // we are subtracting 10 because of the center point as diameter is 20,20 then center will be at 10,10

    }

    public void move(){
        x+=xVelocity;
        y+=yVelocity;

        if (y<10){ // because 10,10 is the center so if the outer part of ball ie center+10 then this should become true and not when center touches the top because then half of the ball would be off the screen

            yVelocity=-yVelocity;
        }
        else if (y>490)
            yVelocity = -yVelocity;

    }

    public void checkPaddleCollision(Paddle p1,Paddle p2){
        if (x<=50){
            if (y>=p1.getY()&&y<=p1.getY()+80){
                xVelocity = - xVelocity;
                score++;
            }
        }
        else if (x>=650){
            if (y>=p2.getY()&&y<=p2.getY()+80){
                xVelocity = - xVelocity;
            }
        }
    }


    public int getScore(){
        return score;
    }

    public int getX(){
        return (int)x;
    }
    public int getY(){
        return (int)y;
    }

}
