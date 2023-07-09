import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Head extends JPanel {
    final int HEAD_SIZE=500;

    private boolean mouseInside;
    public Head(){
        this.setPreferredSize(new Dimension(HEAD_SIZE,HEAD_SIZE));
        this.setBorder(BorderFactory.createBevelBorder(1,Color.DARK_GRAY,Color.DARK_GRAY));
        MyMouseListener listener=new MyMouseListener();
        this.addMouseListener(listener);
    }

    class MyMouseListener extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {

            mouseInside=true;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mouseInside=false;

            repaint();
        }
    }

    @Override public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D) g;

        // draw the face
        int diameter=300;
        int center=(this.getWidth()-diameter)/2; //width=500
        g2.drawOval(center,center,diameter,diameter);

        //draw the mouth
        int mouthHeight=30;
        int mouthWidth=80;
        g2.drawRect(215,340,mouthWidth,mouthHeight);

        //draw eyes
        int eyeSize=30;
        //opening eyes
        if(!this.mouseInside){
            g2.drawLine(180,200,210,200);
            g2.drawLine(300,200,330,200);

        } else{
            g2.drawOval(180,200,eyeSize,eyeSize);
            g2.drawOval(300,200,eyeSize,eyeSize);

        }



    }


}
