package com.stefthedev.simpleprotection.listeners;

import com.stefthedev.simpleprotection.managers.SelectionManager;
import com.stefthedev.simpleprotection.utilities.general.Selection;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SelectionListener implements Listener {

    private SelectionManager selectionManager;

    public SelectionListener(SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {

        //Spigot is weird, need to check this...
        if(event.getItem() == null) return;
        if (event.getItem().getType() != Material.STICK) return;

        Player player = event.getPlayer();
        Selection selection = selectionManager.get(player.getUniqueId());
        if (selection == null) selection = selectionManager.add(player.getUniqueId());

        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
            selection.setOne(selectionManager.convert(event.getClickedBlock().getLocation()));
            player.sendMessage("Selected first position.");
            event.setCancelled(true);

        } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            selection.setTwo(selectionManager.convert(event.getClickedBlock().getLocation()));
            player.sendMessage("Selected second position.");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (selectionManager.get(event.getPlayer().getUniqueId()) != null) selectionManager.remove(event.getPlayer().getUniqueId());
    }
}
