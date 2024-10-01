import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame
{
    UserService userService;

    Home(UserService userService)
    {
        this.userService = userService;

        setTitle("Home");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel title = new JLabel("  AIUB CINEPLEX");
        title.setBounds(10,20,200,20);
        title.setFont(new Font("Rockwell Condensed",Font.BOLD,20));
        title.setForeground(Color.WHITE);
        add(title);

        JLabel aiub = new JLabel("AIUB");
        add(aiub);
        aiub.setForeground(Color.WHITE);
        aiub.setBounds(350,15,50,20);
        aiub.setFont(new Font("Arial",Font.BOLD,16));

        JLabel java = new JLabel("JAVA");
        add(java);
        java.setForeground(Color.WHITE);
        java.setBounds(405,15,50,20);
        java.setFont(new Font("Arial",Font.BOLD,16));

        JLabel summer = new JLabel("SUMMER_24");
        add(summer);
        summer.setForeground(Color.WHITE);
        summer.setBounds(465,15,100,20);
        summer.setFont(new Font("Arial",Font.BOLD,16));

        JLabel project = new JLabel("PROJECT");
        add(project);
        project.setForeground(Color.WHITE);
        project.setBounds(580,15,100,20);
        project.setFont(new Font("Arial",Font.BOLD,16));

        JLabel note = new JLabel("Welcome to AIUB CINEPLEX");
        add(note);
        note.setForeground(Color.WHITE);
        note.setBounds(50,150,350,50);
        note.setFont(new Font("Arial",Font.BOLD,25));

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(70, 300, 100, 40);
        loginButton.setFont(new Font("Algerian",Font.BOLD,20));
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);      
        add(loginButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 300, 100, 40);
        exitButton.setFont(new Font("Algerian",Font.BOLD,20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusable(false);
        add(exitButton);

        ImageIcon backimg = new ImageIcon("Pictures/HomeImage.png");
        Image img = backimg.getImage();
        Image tempimg = img.getScaledInstance(750,450, Image.SCALE_SMOOTH);
        backimg = new ImageIcon(tempimg);
        JLabel back = new JLabel("",backimg,JLabel.CENTER);
        back.setBounds(0,0,700,450);
        add(back);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame log = new LoginFrame(userService);
                log.setVisible(true);
                setVisible(false);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setVisible(true);
    }
}