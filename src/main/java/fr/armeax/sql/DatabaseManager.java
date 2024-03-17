package fr.armeax.sql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    public static Connection openConnection() throws SQLException{
        File databaseDir = new File("plugins/MailboxPlugin/");
        if(!databaseDir.exists()){
            databaseDir.mkdirs();
        }

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:sqlite:plugins/MailboxPlugin/mailboxes.db");
    }

    public static void createTables(Connection connection) {
        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS mailboxes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "owner UUID NOT NULL," +
                    "UNIQUE(owner)" +
                    ");");

            statement.execute("CREATE TABLE IF NOT EXISTS mails (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "sender UUID NOT NULL," +
                    "receiver UUID NOT NULL," +
                    "content TEXT," +
                    "attachment TEXT," +
                    "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP" +
                    ");");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
