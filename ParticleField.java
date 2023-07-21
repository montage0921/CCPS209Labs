import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ParticleField extends javax.swing.JPanel{
    private boolean running=true;
    private java.util.List<Particle> particles = new java.util.ArrayList<Particle>();

    public ParticleField(int n,int width, int height){
        this.setPreferredSize(new Dimension(width,height));
        for(int i=0;i<n;i++){
            particles.add(new Particle(width,height));
        }
        new Thread(new Animation()).start();
    }

    private class Animation implements Runnable{
        @Override
        public void run() {
            while(running){
                try{
                    Thread.sleep(20);}
                catch (InterruptedException e){
                }
                for(Particle pt:particles){
                    pt.move();
                }
                repaint();
            }

        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for(Particle pt:particles){
            g2.fill(new Rectangle2D.Double(pt.getX()-1,pt.getY()-1,3,3));
        }
    }

    public void terminate(){
        this.running=false;
    }


}
