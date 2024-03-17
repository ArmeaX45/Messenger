package fr.armeax.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MailboxManager {

    private static final String CREATE_MAILBOX = "INSERT INTO mailboxes (owner) VALUES (?) ON CONFLICT(owner) DO NOTHING;";
    private static final String CHECK_MAILBOX_EXISTS = "SELECT id FROM mailboxes WHERE owner = ?;";

    public static boolean createMailbox(UUID playerUUID) {
        try (Connection conn = DatabaseManager.openConnection();
             PreparedStatement stmt = conn.prepareStatement(CREATE_MAILBOX)) {
            stmt.setString(1, playerUUID.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean mailboxExists(UUID playerUUID){
        try (Connection conn = DatabaseManager.openConnection();
              PreparedStatement stmt = conn.prepareStatement(CHECK_MAILBOX_EXISTS)){
            stmt.setString(1, playerUUID.toString());
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


}


