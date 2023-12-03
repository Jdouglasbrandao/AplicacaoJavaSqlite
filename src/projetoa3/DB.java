package projetoa3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public DB(String filename) {
        this.openConnection(filename);
    }

    private void openConnection(String filename) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  
        } catch (SQLException ex) {
            System.out.println("Erro de conexão!");
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro na conexão!");
        }
    }

    public void query(String query) {
        try {
            rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Erro na chamada QUERY!");
            System.out.println("Detalhes do erro: " + ex.getMessage());
        }
    }

    public int execQuery(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Erro chamada execQuery!");
            System.out.println("Detalhes do erro: " + ex.getMessage());
        }
        return 0;
    }

    public boolean next() {
        try {
            return rs != null && rs.next();
        } catch (SQLException ex) {
            System.out.println("Erro na chamada NEXT!");
            
        }
        return false;
    }

    public String getString(String fieldName) {
        try {
            return rs != null ? rs.getString(fieldName) : "";
        } catch (SQLException ex) {
            System.out.println("Erro na chamada getString!");
        }
        return "";
    }

    public int getInt(String fieldName) {
        try {
            return rs != null ? rs.getInt(fieldName) : 0;
        } catch (SQLException ex) {
            System.out.println("Erro na chamada getInt!");
        }
        return 0;
    }

    public double getDouble(String fieldName) {
        try {
            return rs != null ? rs.getDouble(fieldName) : 0;
        } catch (SQLException ex) {
            System.out.println("Erro na chamada getDouble!");
        }
        return 0;
    }
}
