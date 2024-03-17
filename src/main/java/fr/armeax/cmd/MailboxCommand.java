package fr.armeax.cmd;

import fr.armeax.sql.MailboxManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MailboxCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Reservé aux joueurs !");
            return true;
        }

        Player player = (Player) sender;

        if(!MailboxManager.mailboxExists(player.getUniqueId())){
            if(MailboxManager.createMailbox(player.getUniqueId())){
                player.sendMessage("Votre boîte aux lettres a été créée avec succès. Vous pouvez désormais recevoir des messages !");
                return true;
            }else{
                player.sendMessage("Une erreur est survenue lors de la création de votre boîte aux lettres.");
                return true;
            }
        }

        player.sendMessage("Voici vos messages :");
        return false;
    }
}
