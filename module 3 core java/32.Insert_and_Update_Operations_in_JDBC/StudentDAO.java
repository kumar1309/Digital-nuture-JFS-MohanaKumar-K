import java.sql.*;

public class StudentDAO {

    private Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertStudent(String name, int age) throws SQLException {
        String query = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.executeUpdate();
        }
    }

    public void updateStudent(int id, String newName) throws SQLException {
        String query = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "Kumar@1309";

        try {
            // Load driver (optional for recent MySQL drivers, but safe to keep)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                StudentDAO dao = new StudentDAO(conn);

                // Insert a student
                dao.insertStudent("John Doe", 22);

                // Update student with id=1
                dao.updateStudent(1, "Jane Doe");

                System.out.println("Insert and update operations completed successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
