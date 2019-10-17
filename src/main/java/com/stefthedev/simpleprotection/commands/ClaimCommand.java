package com.stefthedev.simpleprotection.commands;

import com.stefthedev.simpleprotection.managers.SelectionManager;
import com.stefthedev.simpleprotection.utilities.command.CommandAnnotation;
import com.stefthedev.simpleprotection.utilities.command.CommandExecutor;
import com.stefthedev.simpleprotection.utilities.general.Selection;
import org.bukkit.entity.Player;

@CommandAnnotation(name = "claim", aliases = "protect")
public class ClaimCommand extends CommandExecutor {

    private SelectionManager selectionManager;

    public ClaimCommand(SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
    }

    @Override
    public boolean execute(Player player, String[] args) {
        Selection selection = selectionManager.get(player.getUniqueId());
        if(selection == null) {
            player.sendMessage("You have not started to make a selection.");
        } else {
            if(selection.getOne() == null || selection.getTwo() == null) {
                player.sendMessage("You not created a proper selection.");
            } else {
                //Check if selection is in another region
                //Check if selection Overlaps with current region.
                //More checks...
                //Execute region claim
                //if region is overlapping with owned region add new region + overlapped region.
            }
        }
        return false;
    }
}
