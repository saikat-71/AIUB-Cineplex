import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PurchaseMovieFrame extends JFrame {
    UserService userService;

    PurchaseMovieFrame(UserService userService) {
        this.userService = userService;

        setTitle("Purchase movie");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel title = new JLabel("                Purchase Movie");
        title.setFont(new Font("Arial",Font.BOLD,35));
        title.setBounds(50, 30, 570, 50);
		title.setBackground(Color.RED);
		title.setForeground(Color.WHITE);
		title.setOpaque(true);
        add(title);

        ImageIcon toofan = new ImageIcon("Pictures/Toofan.png");
        Image img1 = toofan.getImage();
        Image temp_img1 = img1.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        toofan = new ImageIcon(temp_img1);
        JLabel Toofan = new JLabel("", toofan, JLabel.CENTER);
        Toofan.setBounds(50, 100, 100, 150);
		add(Toofan);
        JLabel show1 = new JLabel("     TOOFAN");
        show1.setFont(new Font("Arial", Font.BOLD, 14));
		show1.setBounds(50, 260, 100, 30);
		show1.setBackground(Color.RED);
		show1.setForeground(Color.WHITE);
		show1.setOpaque(true);
		add(show1);

        ImageIcon nobab = new ImageIcon("Pictures/Nobab.png");
        Image img5 = nobab.getImage();
        Image temp_img5 = img5.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        nobab = new ImageIcon(temp_img5);
        JLabel Nobab = new JLabel("", nobab, JLabel.CENTER);
        Nobab.setBounds(290, 100, 100, 150);
		add(Nobab);
        JLabel show2 = new JLabel("     NOBAB");
        show2.setFont(new Font("Arial", Font.BOLD, 14));
		show2.setBounds(290, 260, 100, 30);
		show2.setBackground(Color.RED);
		show2.setForeground(Color.WHITE);
		show2.setOpaque(true);
		add(show2);

        ImageIcon dintheday = new ImageIcon("Pictures/dintheday.png");
        Image img3 = dintheday.getImage();
        Image temp_img3 = img3.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        dintheday = new ImageIcon(temp_img3);
        JLabel DinTheDay = new JLabel("", dintheday, JLabel.CENTER);
		DinTheDay.setBounds(520, 100, 100, 150);
		add(DinTheDay);
        JLabel show3 = new JLabel("   DIN-THE-DAY");
        show3.setFont(new Font("Arial", Font.BOLD, 12));
		show3.setBounds(520, 260, 100, 30);
		show3.setBackground(Color.RED);
		show3.setForeground(Color.WHITE);
		show3.setOpaque(true);
		add(show3);

		
        JComboBox<String> movieDropdown = new JComboBox<>(userService.availableMovies);
        movieDropdown.setBounds(250, 350, 200, 40);
        movieDropdown.setFont(new Font("Arial",Font.BOLD,25));
        movieDropdown.setOpaque(true);
        add(movieDropdown);

        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.setBounds(50, 350,  170, 40);
        purchaseButton.setFont(new Font("Arial",Font.BOLD,25));
        purchaseButton.setBackground(Color.RED);
        purchaseButton.setForeground(Color.WHITE);
        purchaseButton.setOpaque(true);
        purchaseButton.setFocusable(false);
        add(purchaseButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(530, 350, 100, 40);
		backButton.setFont(new Font("Arial", Font.BOLD, 18));
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setOpaque(true);
        backButton.setFocusable(false);
		add(backButton);

        purchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieDropdown.getSelectedItem();
                userService.purchaseMovie(selectedMovie);
                JOptionPane.showMessageDialog(null, "Purchased: " + selectedMovie);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DashboardFrame dashboardFrame = new DashboardFrame(userService);
                dashboardFrame.setVisible(true);
                setVisible(false);
            }
        });
        ImageIcon backimg = new ImageIcon("Pictures/Movie.jpg");
        Image img = backimg.getImage();
        Image tempimg = img.getScaledInstance(750,450, Image.SCALE_SMOOTH);
        backimg = new ImageIcon(tempimg);
        JLabel back = new JLabel("",backimg,JLabel.CENTER);
        back.setBounds(0,0,700,450);
        add(back);

        setVisible(true);
    }
}
    


