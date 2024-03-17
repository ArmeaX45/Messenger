package fr.armeax;

import fr.armeax.cmd.MailboxCommand;
import fr.armeax.sql.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Le plugin de boîte au lettres est activé !");

        this.getCommand("mailbox").setExecutor(new MailboxCommand());


        try(Connection conn = DatabaseManager.openConnection()){
            DatabaseManager.createTables(conn);
            getLogger().info("Connexion à la BDD réussie");
        }catch(Exception e){
            getLogger().severe("Impossible de se connecter à la BDD !");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Le plugin de boîte au lettres est désactivé !");
    }
}
