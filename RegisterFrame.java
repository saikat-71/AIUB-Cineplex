import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterFrame extends JFrame
{
    UserService userService;

    RegisterFrame(UserService userService)
    {
        this.userService = userService;

        setTitle("Register");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel title = new JLabel("  AIUB CINEPLEX");
        add(title);
        title.setBounds(30,65,275,50);
        title.setFont(new Font("Rockwell Condensed",Font.BOLD,30));
        title.setForeground(Color.RED);

        JLabel name1 = new JLabel("CREATE");
        add(name1);
        name1.setBounds(70,160,300,30);
        name1.setFont(new Font("Arial",Font.BOLD,35));
        name1.setForeground(Color.WHITE);
        
        JLabel name2 = new JLabel("YOUR");
        add(name2);
        name2.setBounds(70,200,300,30);
        name2.setFont(new Font("Arial",Font.BOLD,35));
        name2.setForeground(Color.WHITE);

        JLabel name3 = new JLabel("ACCOUNT");
        add(name3);
        name3.setBounds(70,240,300,30);
        name3.setFont(new Font("Arial",Font.BOLD,35));
        name3.setForeground(Color.WHITE);

        JLabel nameLabel = new JLabel("   Name:");
        nameLabel.setBounds(320, 85, 100, 30);
        nameLabel.setFont(new Font("Arial",Font.BOLD,16));
        nameLabel.setBackground(Color.RED);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setOpaque(true);
        add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(100, 10, 160, 25);
        nameField.setBounds(430,85,200,30);
        nameField.setFont(new Font("Arial",Font.BOLD,16));
        add(nameField);

        JLabel genderField = new JLabel("   Gender");
        add(genderField);
        genderField.setBounds(320,120,100,30);
        genderField.setFont(new Font("Arial",Font.BOLD,16));
        genderField.setBackground(Color.RED);
        genderField.setForeground(Color.WHITE);
        genderField.setOpaque(true);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(430,120,64,30);
        add(male);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(490,120,70,30);
        add(female);
        JRadioButton other = new JRadioButton("Other");
        other.setBounds(560,120,70,30);
        add(other);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);

        JLabel mobileLabel = new JLabel("   Mobile No.");
        mobileLabel.setBounds(320,155,100,30);
        mobileLabel.setFont(new Font("Arial",Font.BOLD,16));
        mobileLabel.setBackground(Color.RED);
        mobileLabel.setForeground(Color.WHITE);
        mobileLabel.setOpaque(true);
        add(mobileLabel);
        JTextField mobileField = new JTextField();
        mobileField.setBounds(430,155,200,30);
        mobileField.setFont(new Font("Arial",Font.BOLD,16));
        add(mobileField);

        JLabel studentIdLabel = new JLabel("   Student ID");
        studentIdLabel.setBounds(320,190,100,30);
        studentIdLabel.setFont(new Font("Arial",Font.BOLD,16));
        studentIdLabel.setBackground(Color.RED);
        studentIdLabel.setForeground(Color.WHITE);
        studentIdLabel.setOpaque(true);
        add(studentIdLabel);
        JTextField studentIdField = new JTextField();
        studentIdField.setBounds(430,190,200,30);
        studentIdField.setFont(new Font("Arial",Font.BOLD,16));
        add(studentIdField);

        JLabel passwordLabel = new JLabel("   Password");
        passwordLabel.setBounds(320,225,100,30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,16));
        passwordLabel.setBackground(Color.RED);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setOpaque(true);
        add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(430,225,200,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,16));
        add(passwordField);

        JButton registerButton = new JButton(" Register");
        registerButton.setBounds(340,280,130,30);
        registerButton.setFont(new Font("Arial",Font.BOLD,18));
        registerButton.setBackground(Color.RED);
        registerButton.setForeground(Color.WHITE);
        registerButton.setOpaque(true);
        registerButton.setFocusable(false);
        add(registerButton);

        JButton clear = new JButton(" Clear");
        clear.setBounds(500,280,100,30);
        clear.setFont(new Font("Arial",Font.BOLD,18));
        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        clear.setFocusable(false);
        add(clear);

        JButton back = new JButton("Back");
        add(back);
        back.setBounds(15,15,70,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.setFocusable(false);

        ImageIcon backimg = new ImageIcon("Pictures/CreateAccountBackground.png");
        Image img = backimg.getImage();
        Image tempimg = img.getScaledInstance(750,450, Image.SCALE_SMOOTH);
        backimg = new ImageIcon(tempimg);
        JLabel backim = new JLabel("",backimg,JLabel.CENTER);
        backim.setBounds(0,0,700,450);
        add(backim);

        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                RegisterFrame register = new RegisterFrame(userService);
                register.setVisible(true);
                setVisible(false);
            }
        });

        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LoginFrame log = new LoginFrame(userService);
                log.setVisible(true);
                setVisible(false);
            }
        });

        registerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : other.isSelected() ? "Other" : "";
                String mobile = mobileField.getText();
                String studentId = studentIdField.getText();
                String password = new String(passwordField.getPassword());

                if (userService.register(name, gender, mobile, studentId, password))
                {
                    LoginFrame log = new LoginFrame(userService);
                    log.setVisible(true);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "User already exists.");
                }
            }
        });
        setVisible(true);
    }
}
