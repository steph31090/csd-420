import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FansApp extends JFrame {

    private JTextField txtID = new JTextField(10);
    private JTextField txtFirst = new JTextField(15);
    private JTextField txtLast = new JTextField(15);
    private JTextField txtTeam = new JTextField(15);

    private JButton btnDisplay = new JButton("Display");
    private JButton btnUpdate = new JButton("Update");

    private Connection conn;

    public FansApp() {
        connect();
        buildUI();
        addActions();
    }

    private void connect() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/databasedb",
                "student1",
                "pass"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Connection failed");
        }
    }

    private void buildUI() {
        setTitle("Fans");
        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID"));
        add(txtID);

        add(new JLabel("First Name"));
        add(txtFirst);

        add(new JLabel("Last Name"));
        add(txtLast);

        add(new JLabel("Favorite Team"));
        add(txtTeam);

        add(btnDisplay);
        add(btnUpdate);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addActions() {

        btnDisplay.addActionListener(e -> {
            try {
                String sql = "SELECT * FROM fans WHERE ID = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtID.getText()));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    txtFirst.setText(rs.getString("firstname"));
                    txtLast.setText(rs.getString("lastname"));
                    txtTeam.setText(rs.getString("favoriteteam"));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Display error");
            }
        });

        btnUpdate.addActionListener(e -> {
            try {
                String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtFirst.getText());
                ps.setString(2, txtLast.getText());
                ps.setString(3, txtTeam.getText());
                ps.setInt(4, Integer.parseInt(txtID.getText()));
                ps.executeUpdate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Update error");
            }
        });
    }

    public static void main(String[] args) {
        new FansApp();
    }
}