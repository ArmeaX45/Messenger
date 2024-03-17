package fr.armeax.lst;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class AttachmentGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getView().title().equals(Component.text("Ajoutez des pièces jointes"))){
            if(e.getSlot() < 9 || e.getSlot() > 17){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onIntentoryClose(InventoryCloseEvent e){
        if(e.getView().title().equals(Component.text("Ajoutez des pièces jointes"))){
            Inventory inventory = e.getInventory();
        }
    }
}
