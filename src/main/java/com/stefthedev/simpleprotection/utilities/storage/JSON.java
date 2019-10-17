package com.stefthedev.simpleprotection.utilities.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class JSON<T> {

    private final File file;
    private final Gson gson;

    public JSON(Plugin plugin, String name) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        file = new File(plugin.getDataFolder() + File.separator + name + ".json");
        if(!file.exists()) file.getParentFile().mkdirs();
    }

    public void write(Set<T> set) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(gson.toJson(set));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<T> read(Type type) {
        try {
            return gson.fromJson(new JsonReader(new FileReader(file)), type);
        } catch (FileNotFoundException e) {
            return new HashSet<>();
        }
    }

    public File getFile() {
        return file;
    }
}
