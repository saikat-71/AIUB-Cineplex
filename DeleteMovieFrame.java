import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteMovieFrame extends JFrame
{
    UserService userService;

    DeleteMovieFrame(UserService userService)
    {
        this.userService = userService;

        setTitle("Delete Movie");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel title = new JLabel("   Wanna delete the movie?");
        title.setFont(new Font("Arial",Font.BOLD,35));
        title.setBounds(50, 30, 570, 50);
		title.setBackground(Color.RED);
		title.setForeground(Color.WHITE);
		title.setOpaque(true);
        add(title);

        JComboBox<String> movieDropdown = new JComboBox<>(userService.currentUser.wallet.toArray(new String[0]));
        movieDropdown.setBounds(250, 150, 200, 40);
        movieDropdown.setFont(new Font("Arial",Font.BOLD,25));        
        movieDropdown.setOpaque(true);
        add(movieDropdown);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 150, 170, 40);
        deleteButton.setFont(new Font("Arial",Font.BOLD,25));
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setOpaque(true);
        deleteButton.setFocusable(false);
        add(deleteButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(530, 350, 100, 40);
		backButton.setFont(new Font("Arial", Font.BOLD, 18));
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setOpaque(true);
        backButton.setFocusable(false);
		add(backButton);

        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedMovie = (String) movieDropdown.getSelectedItem();
                userService.deleteMovie(selectedMovie);
                JOptionPane.showMessageDialog(null, "Deleted: " + selectedMovie);
                DashboardFrame dashboardFrame = new DashboardFrame(userService);
                dashboardFrame.setVisible(true);
                setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DashboardFrame dashboardFrame = new DashboardFrame(userService);
                dashboardFrame.setVisible(true);
                setVisible(false);
            }
        });
        setVisible(true);
    }
}
