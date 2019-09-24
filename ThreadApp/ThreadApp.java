import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadApp extends JFrame {

    JLabel d;

    public ThreadApp() {
        ThreadApp();
    }

    private void ThreadApp() {
        setSize(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setAlwaysOnTop(true);
        JPanel jp = new JPanel();
        jp.setBackground(Color.BLACK);
        add(jp);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                System.exit(0);
            }
        });

        d = new JLabel("");
        d.setVerticalTextPosition(JLabel.CENTER);
        d.setHorizontalAlignment(0);
        d.setLayout(new java.awt.BorderLayout());
        d.setFont(new java.awt.Font("Serif", 1, 100));
        d.setForeground(Color.WHITE);
        d.setBackground(Color.red);
        jp.add(d);

        Thread t = new Thread(new Runnable() {

            public void run() {

                String msgh = "<html><br><br>";
                String msgt = "</html>";
                
                while (true) {
                    for (int i = 0; true; i++) {
                        switch (i) {
                            case 1:
                                d.setText(msgh + "<font color='RED'>i</font> Love Java" + msgt);
                                break;
                            case 2:
                                d.setText(msgh + "i <font color='RED'>Love</font> Java" + msgt);
                                break;
                            case 3:
                                d.setText(msgh + "i Love <font color='RED'>Java</font>" + msgt);
                                break;
                            default:
                                i = 0;
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });
        t.start();
    }

    public static void main(String sanu[]) {

        new ThreadApp().setVisible(true);
    }
}
