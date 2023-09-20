import java.awt.*;
import java.awt.event.*;

class Game  extends KeyAdapter  implements MouseMotionListener
{
    static Frame f;
    static  Button  brick, catcher;
    static  Label score_text, score;
    static  Panel p;
    static int x1, x2;

    Game()
    {
        f= new Frame("Brick_Collector");
        f.setLayout(null);
        p= new Panel();
        p.setLayout(null);
        p.setBackground(new Color(145,244,255));
        catcher = new Button();
        catcher.setBackground(new Color(173,98,96));
        p.addMouseMotionListener(this);
        catcher.addKeyListener(this);
        catcher.setBounds(240,540,120,10);
        p.add(catcher);
        score_text= new Label("0");
        score= new Label("Score  : ");  
        p.setBounds(0,0,600,550);
        score_text.setFont(new Font("Arial",1,24));
        score.setFont(new Font("Arial",1,24));
        score.setBounds(450,565,90,25);
        score_text.setBounds(550,565,50,25);
        f.add(p);
        f.add(score_text);
        f.add(score);
        f.setSize(600,600);
        f.setBackground(new Color(186,200,207));
        f.setResizable(false);
        f.setVisible(true);
         BrickThread b1= new BrickThread();
          b1.start();

    }

    public static void main(String ar[])
    {
      Game g= new Game();
    }

    public void mouseMoved(MouseEvent e)
    {
       
    }

    public void mouseDragged(MouseEvent e)
    {
                int x2=e.getX();

       if(x2>=0 && x2<= 480){
        catcher.setBounds(x2,540,120,10);
       }
       else if(x2<=0)
       {
        catcher.setBounds(0,540,120,10);

       }
       else if(x2>480){
        catcher.setBounds(480,540,120,10);
       }
    }




    @Override
    public void keyReleased(KeyEvent e)
    { 

      int dis= catcher.getX();
      if(e.getKeyCode() == KeyEvent.VK_LEFT)
      {
        if(dis != 0)
           dis= dis - 10;
      }
        

      else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
          if(dis != 480)
           dis = dis+10;
         }


         catcher.setBounds(dis, 540,120,10);
      }

}