package com.stefthedev.simpleprotection.managers;

import com.stefthedev.simpleprotection.utilities.Manager;
import com.stefthedev.simpleprotection.utilities.command.CommandExecutor;

import java.util.List;

public class CommandManager extends Manager<CommandExecutor> {


    //TODO: Get index based on how many commands to display as a page.
    public List<CommandExecutor> getFormat(int index, int size) {
        int page = (int) Math.ceil((double) asSet().size() / size);

        for(int i = 0; i < asSet().size(); i++)
        {
            if(i >= size) break;

        }
        return null;
    }
}
