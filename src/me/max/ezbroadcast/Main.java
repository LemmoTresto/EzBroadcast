package me.max.ezbroadcast;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getPluginManager;


/**
 * Created by max on 25-3-2017.
 */
public class Main extends JavaPlugin{

    FileConfiguration config = getConfig();

    public static Main getPlugin() {
        return getPlugin(Main.class);
    }

    @Override
    public void onEnable(){
        // When server enables the plugin.
        getLogger().info("Reading/Writing Config");
        try{
            config.addDefault("prefix", "[EzBroadcast]");
            config.addDefault("messageColor", "&f&l");
            config.addDefault("defaultPrefix", "[EzBroadcast]");
            config.addDefault("defaultMessageColor", "&f&l");
            config.options().copyDefaults(true);
            saveConfig();
        }
        catch (Exception e){
            getLogger().info("Couldn't generate/read config. \n Please restart if it still doesn't work contact the developer.");
            getPluginManager().disablePlugin(this);
        }
        getLogger().info("Enabling commands..");
        try{
            this.getCommand("ezbroadcast").setExecutor(new CommandMain());
            getLogger().info("Successfully Enabled!");
        }
        catch (Exception e){
            getLogger().info("Error in enabling commands!");
            getLogger().info("Please restart server. \n If this continuous please contact the developer.");
            getPluginManager().disablePlugin(this);
        }


    }

    @Override
    public void onDisable(){
        // When server disables the plugin.
        getLogger().info("Disabling...");
        getLogger().info("Successfully Disabled!");

    }

}

