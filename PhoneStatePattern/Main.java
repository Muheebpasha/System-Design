import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

// Main class
public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();

        JFrame frame = new JFrame("Phone State Example");
        frame.setLayout(new FlowLayout());

        JButton home = new JButton("Home");
        JButton onOff = new JButton("On/Off");

        home.addActionListener(e -> {
            String result = phone.getState().onHome();
            System.out.println(result);
        });

        onOff.addActionListener(e -> {
            String result = phone.getState().onOffOn();
            System.out.println(result);
        });

        frame.add(home);
        frame.add(onOff);

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
