import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame("Mario Bros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,360);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);


    }
}