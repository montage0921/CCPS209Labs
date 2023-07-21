import java.util.Random;
public class Particle {
    private static final Random rng = new Random();
    private static final double BUZZY = 0.7;
    private double x,y,heading;

    public Particle(int width, int height){
        this.x=width*rng.nextDouble();
        this.y=height*rng.nextDouble();
        this.heading=Math.PI*2*rng.nextDouble();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;

    }

    public void move(){
        this.x+=Math.cos(this.heading);
        this.y+=Math.sin(this.heading);
        this.heading+=rng.nextGaussian()*BUZZY;
    }

}
