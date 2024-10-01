import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame extends JFrame
{
    UserService userService;

    LoginFrame(UserService userService)
    {
        this.userService = userService;

        setTitle("Log In");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel title = new JLabel("    AIUB CINEPLEX");
        add(title);
        title.setBounds(220,80,275,50);
        title.setFont(new Font("Rockwell Condensed",Font.BOLD,30));
        title.setBackground(Color.RED);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);

        JLabel label = new JLabel("          Log in your account");
        add(label);
        label.setBounds(175,175,350,50);
        label.setFont(new Font("Arial",Font.BOLD,24));
        label.setBackground(Color.RED);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);

        JLabel nameLabel = new JLabel("  Student ID ");
        nameLabel.setBounds(175, 225, 100, 50);
        nameLabel.setFont(new Font("Arial",Font.BOLD,16));
        nameLabel.setBackground(Color.WHITE);
        nameLabel.setOpaque(true);
        add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(275, 225, 250, 50);
        nameField.setFont(new Font("Arial",Font.BOLD,16));
        add(nameField);

        JLabel passwordLabel = new JLabel("   Password ");
        passwordLabel.setBounds(175, 275, 100, 50);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,16));
        passwordLabel.setBackground(Color.WHITE);
        passwordLabel.setOpaque(true);
        add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(275, 275, 250, 50);
        passwordField.setFont(new Font("Arial",Font.BOLD,16));
        add(passwordField);

        JButton loginButton = new JButton(" Log In ");
        loginButton.setBounds(175, 325, 175, 50);
        loginButton.setFont(new Font("Arial",Font.BOLD,16));
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);
        add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(350, 325, 175, 50);
        registerButton.setFont(new Font("Arial",Font.BOLD,16));
        registerButton.setBackground(Color.RED);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusable(false);
        add(registerButton);

        ImageIcon backimg = new ImageIcon("Pictures/Background.png");
        Image img = backimg.getImage();
        Image tempimg = img.getScaledInstance(750,450, Image.SCALE_SMOOTH);
        backimg = new ImageIcon(tempimg);
        JLabel back = new JLabel("",backimg,JLabel.CENTER);
        back.setBounds(0,0,700,450);
        add(back);

        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());

                if (!name.isEmpty() && !password.isEmpty())
                {
                    if (userService.login(name, password))
                    {
                        DashboardFrame dashboard = new DashboardFrame(userService);
                        dashboard.setVisible(true);
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid login.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Information missing.");
                }
            }
        });
        registerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                RegisterFrame register = new RegisterFrame(userService);
                register.setVisible(true);
                setVisible(false);
            }
        });
        setVisible(true);
    }
}