package fr.armeax.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AttachmentGUI {

    public static void openAttachmentGUI(Player player){
        Inventory gui = Bukkit.createInventory(player, 27, "Ajoutez des pièces jointes");
        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for(int i = 0; i < gui.getSize(); i++){
            if (i<9 || i>17){
                gui.setItem(i, glassPane);
            }
        }
        player.openInventory(gui);

    }

}
