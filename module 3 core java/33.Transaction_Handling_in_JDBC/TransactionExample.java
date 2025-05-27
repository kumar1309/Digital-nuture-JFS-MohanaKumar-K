import java.sql.*;

public class TransactionExample {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "#";

    public void transferMoney(int fromAcc, int toAcc, double amount) {
        String debit = "UPDATE accounts SET balance = balance - ? WHERE acc_id = ?";
        String credit = "UPDATE accounts SET balance = balance + ? WHERE acc_id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            con.setAutoCommit(false);

            try (PreparedStatement psDebit = con.prepareStatement(debit);
                 PreparedStatement psCredit = con.prepareStatement(credit)) {

                psDebit.setDouble(1, amount);
                psDebit.setInt(2, fromAcc);
                psDebit.executeUpdate();

                psCredit.setDouble(1, amount);
                psCredit.setInt(2, toAcc);
                psCredit.executeUpdate();

                con.commit();
                System.out.println("Transaction successful!");

            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaction failed, rollback done.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TransactionExample te = new TransactionExample();
        te.transferMoney(101, 102, 500);
    }
}
