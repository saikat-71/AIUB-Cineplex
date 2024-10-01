import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DashboardFrame extends JFrame
{
    UserService userService;

    DashboardFrame(UserService userService) {
        this.userService = userService;

        setTitle("DashBoard");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + userService.currentUser.name + " !");
        welcomeLabel.setBounds(50, 300, 300, 50);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        add(welcomeLabel);

        JLabel title = new JLabel("  WELCOME TO YOUR ACCOUNT");
        title.setFont(new Font("Arial",Font.BOLD,35));
        title.setBounds(50, 30, 570, 50);
		title.setBackground(Color.RED);
		title.setForeground(Color.WHITE);
		title.setOpaque(true);
        add(title);


        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(50,120,200,40);
		profileButton.setFont(new Font("Arial", Font.BOLD, 24));
        profileButton.setFocusable(false);
		profileButton.setBackground(Color.RED);
		profileButton.setForeground(Color.WHITE);
		profileButton.setOpaque(true);
        profileButton.setFocusable(false);
        add(profileButton);

        JButton purchaseMovieButton = new JButton("Movie");
        purchaseMovieButton.setBounds(50,170,200,40);
		purchaseMovieButton.setFont(new Font("Arial", Font.BOLD, 24));
        purchaseMovieButton.setFocusable(false);
		purchaseMovieButton.setBackground(Color.RED);
		purchaseMovieButton.setForeground(Color.WHITE);
		purchaseMovieButton.setOpaque(true);
        purchaseMovieButton.setFocusable(false);
        add(purchaseMovieButton);

        JButton walletButton = new JButton("View Wallet");
        walletButton.setBounds(50, 220, 200, 40);
		walletButton.setFont(new Font("Arial", Font.BOLD, 24));
        walletButton.setFocusable(false);
		walletButton.setBackground(Color.RED);
		walletButton.setForeground(Color.WHITE);
		walletButton.setOpaque(true);
        walletButton.setFocusable(false);
        add(walletButton);

        JButton searchMovieButton = new JButton("Search Movie");
        searchMovieButton.setBounds(400,120,200,40);
		searchMovieButton.setFont(new Font("Arial", Font.BOLD, 24));
        searchMovieButton.setFocusable(false);
		searchMovieButton.setBackground(Color.RED);
		searchMovieButton.setForeground(Color.WHITE);
		searchMovieButton.setOpaque(true);
        searchMovieButton.setFocusable(false);
        add(searchMovieButton);

        JButton deleteMovieButton = new JButton("Delete Movie");
        deleteMovieButton.setBounds(400,170,200,40);
		deleteMovieButton.setFont(new Font("Arial", Font.BOLD, 24));
        deleteMovieButton.setFocusable(false);
		deleteMovieButton.setBackground(Color.RED);
		deleteMovieButton.setForeground(Color.WHITE);
		deleteMovieButton.setOpaque(true);
        deleteMovieButton.setFocusable(false);
        add(deleteMovieButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(530, 350, 100, 40);
		logoutButton.setFont(new Font("Arial", Font.BOLD, 18));
        logoutButton.setFocusable(false);
		logoutButton.setBackground(Color.RED);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setOpaque(true);
        logoutButton.setFocusable(false);
        add(logoutButton);

        ImageIcon background_image = new ImageIcon("Pictures/PortalBG.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(700, 450, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 700, 450);
		add(background);

        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, userService.currentUser.displayProfile(),"My Profile",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        purchaseMovieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PurchaseMovieFrame purchaseMovieFrame = new PurchaseMovieFrame(userService);
                purchaseMovieFrame.setVisible(true);
                setVisible(false);
            }
        });

        walletButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> wallet = userService.getUserWallet();
                if (wallet.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wallet is empty.","My Wallet",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Movies in Wallet: " + wallet,"My Wallet",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        searchMovieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchMovieFrame searchMovieFrame = new SearchMovieFrame(userService);
                searchMovieFrame.setVisible(true);
                setVisible(false);
            }
        });

        deleteMovieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteMovieFrame deleteMovieFrame = new DeleteMovieFrame(userService);
                deleteMovieFrame.setVisible(true);
                setVisible(false);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userService.logout();
                LoginFrame loginFrame = new LoginFrame(userService);
                loginFrame.setVisible(true);
                setVisible(false);
            }
        });
        setVisible(true);
    }
}
