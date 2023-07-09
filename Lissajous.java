import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class Lissajous extends JPanel {

    private JTextField aField;
    private JTextField bField;
    private JTextField deltaField;
    private int size;
    public Lissajous(int size){
        this.size=size;
        this.setPreferredSize(new Dimension(this.size,this.size));
        createComponent();
    }

    private void createComponent(){
        createTextFields();
        createEventListener();
    }

    private void createEventListener(){
        MyActionListener listener=new MyActionListener();

        Component[] components=this.getComponents();
        for(Component component:components){
            if(component instanceof JTextField){
                ((JTextField) component).addActionListener(listener);
            }
        }

    }
    protected void createTextFields(){
        int FIELD_WIDTH=7;

        //field a
        JLabel aLabel=new JLabel("a: ");
        this.aField=new JTextField(FIELD_WIDTH);
        this.aField.setText("6");

        //field b
        JLabel bLabel=new JLabel("b: ");
        this.bField=new JTextField(FIELD_WIDTH);
        this.bField.setText("5");

        //field delta
        JLabel deltaLabel=new JLabel("delta: ");
        this.deltaField=new JTextField(FIELD_WIDTH);
        this.deltaField.setText("0.5");

        //note: adding sequence is same as displaying sequence
        //note: adding is line by line
        this.add(aLabel);
        this.add(aField);

        this.add(bLabel);
        this.add(bField);

        this.add(deltaLabel);
        this.add(deltaField);

    }

    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }

    }

    @Override public void paintComponent(Graphics g){

        Graphics2D g2=(Graphics2D) g;
        if (!aField.getText().isEmpty() && !bField.getText().isEmpty() && !deltaField.getText().isEmpty()){
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            double delta = Double.parseDouble(deltaField.getText());

            //points when t=0 should be handled seperately to obtain correct curve
            double tPrevious = 0;
            double xPrevious = this.size/2 + 2*size/5*Math.sin(a*tPrevious*Math.PI+delta);
            double yPrevious = this.size/2 + 2*size/5*Math.sin(b*tPrevious*Math.PI);

            for(double t=0.005;t<=(a/gcd(a,b)*b);t+=0.005){
                double x1 = this.size/2 + 2*size/5*Math.sin(a*t*Math.PI+delta);
                double y1 = this.size/2 + 2*size/5*Math.sin(b*t*Math.PI);

                Line2D line = new Line2D.Double(xPrevious, yPrevious, x1, y1);
                g2.draw(line);

                // update previous x and y
                xPrevious = x1;
                yPrevious = y1;
            }
        }





    }

    //Get Greatest Common Divisor between a and b
    private int gcd(int a, int b){
        if (b == 0) return a;
        // call the gcd() method recursively by
        // replacing a with b and b with
        // difference(a,b) as long as b != 0
        else return gcd(b, Math.abs(a - b));
    }


}
