import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

class BrickThread extends Thread{
       static int d;
        static Button b;

        static boolean run ;
    public void  run()
    {
        try
        {
            run = true;
       while(run){
        d= (int)(Math.random()*520);
        b= new Button();
        b.setBackground(new Color(240,155,89));
        b.setBounds(d,40,80,20);
        Game.p.add(b);
        for(int i=40; i<=550; i= i+10)
        {
            b.setBounds(d,i,80,20);

           if(b.getX()>= Game.catcher.getX()-60 && b.getX()<= Game.catcher.getX()+60 && b.getY()== 540)
        {

            int sc= Integer.parseInt(Game.score_text.getText());
            sc++;
            Game.score_text.setText(""+sc);
        } 

         else if((b.getX()<= Game.catcher.getX()-60 || b.getX()>= Game.catcher.getX()+60) && b.getY()== 540 )
         {
             run = false;
             Label l1= new Label("GAME OVER !!");
             l1.setForeground(Color.RED);
            l1.setFont(new Font("Arial" ,1, 40));
            l1.setBounds(150, 240, 300, 50);
             Game.p.add(l1);

             Label l2= new Label("Your score: "+ Game.score_text.getText());
              l2.setForeground(Color.RED);
             l2.setFont(new Font("Arial" ,1, 20));
             l2.setBounds(210, 290, 200, 30);
             Game.p.add(l2);
         }
            Thread.sleep(100);
        }   


        }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}