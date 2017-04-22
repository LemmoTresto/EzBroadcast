package me.max.ezbroadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by max on 25-3-2017.
 */
public class CommandMain implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (args.length == 0){
            commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "/EzBroadcast Help");
            return true;
        }

        if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?") || args[0].equalsIgnoreCase("h")){
            if (commandSender.hasPermission("EzBroadcast.Help")) {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "---------------EzBroadcast-Help---------------" +
                        "\n/EzBc Help |-| Shows this screen." +
                        "\n/EzBc Bc |-| Broadcasts a message." +
                        "\n/EzBc Set/Current |-| Set or see current prefix or msgcolor." +
                        "\n/EzBc Default Set/Current |-| Set or see current default prefix/msgcolor" +
                        "\n/EzBc Reset |-| Reset to the default prefix and msgcolor" +
                        "\nThis plugin was made by Max :)" +
                        "\nGithub: github.com/MaxiMiniJaniJos" +
                        "\nSpigot: https://www.spigotmc.org/members/lemmotresto.284186/" +
                        "\n---------------EzBroadcast-Help---------------");
                return true;
            }
            else {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have permission to do this. Node: EzBroadcast.Help");
                return true;
            }
        }

        if (args[0].equalsIgnoreCase("bc") || args[0].equalsIgnoreCase("broadcast")) {
            if (commandSender.hasPermission("EzBroadcast.Broadcast")) {
                String text = String.join(" ", args);
                String text2 = text.replaceFirst("bc ", "");
                String text3 = text2.replaceFirst("broadcast ", "");
                String prefix = Main.getPlugin().getConfig().getString("prefix");
                String messageColor = Main.getPlugin().getConfig().getString("messageColor");
                String coloredPrefix = ChatColor.translateAlternateColorCodes('&', prefix);
                String coloredMessageColor = ChatColor.translateAlternateColorCodes('&', messageColor);
                String coloredText = ChatColor.translateAlternateColorCodes('&', text3);
                Bukkit.broadcastMessage(coloredPrefix + " " + coloredMessageColor + "" + coloredText);
                return true;
            }
            else {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have permission to do this. Node: EzBroadcast.Broadcast");
                return true;
            }
        }

        if (args[0].equalsIgnoreCase("current") || args[0].equalsIgnoreCase("c")) {
            if (commandSender.hasPermission("EzBroadcast.Current")) {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "The current prefix is: " + ChatColor.RESET + "" + Main.getPlugin().getConfig().getString("prefix") + ChatColor.DARK_RED + "" + ChatColor.BOLD + " and the current messagecolor is: " + ChatColor.RESET + "" + Main.getPlugin().getConfig().getString("messageColor") + "This");
                return true;


            } else {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have permission to do this. Node: EzBroadcast.Current");
                return true;
            }
        }


        if (args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("s")){
            if (commandSender.hasPermission("EzBroadcast.Set")){
                if (args.length < 3){
                    commandSender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You haven't given enough arguments. \nYou gave " + (args.length - 1) + " Arguments but you should give more than 1.");
                    return true;
                }
                else if (args[1].equalsIgnoreCase("prefix")){
                    String settingtext = String.join("", args);
                    String settingtext2 = settingtext.replaceAll("set|prefix|s", "");
                    Main.getPlugin().getConfig().set("prefix", settingtext2);
                    commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Successfully set Prefix to: " + ChatColor.RESET + "" + settingtext2);
                    return true;
                }
                else if (args[1].equalsIgnoreCase("msgcolor") || args[1].equalsIgnoreCase("messagecolor")){
                    String settingtext = String.join("", args);
                    String settingtext2 = settingtext.replaceAll("set|msgcolor|messagecolor|s", "");
                    Main.getPlugin().getConfig().set("messageColor", settingtext2);
                    commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Successfully set MessageColor to: " + ChatColor.RESET + "" + settingtext2 + "This");
                    return true;
                }
                else {
                    commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Usage /EzBroadcast Set <Prefix/MessageColor>");
                    return true;
                }
            }
            else {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have permission to do this. Node: EzBroadcast.Set");
                return true;
            }
        }

        if (args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("r")) {
            if (commandSender.hasPermission("EzBroadcast.Reset")) {
                Main.getPlugin().getConfig().set("prefix", Main.getPlugin().getConfig().getString("defaultPrefix"));
                Main.getPlugin().getConfig().set("messageColor", Main.getPlugin().getConfig().getString("defaultMessageColor"));
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Successfully reset to default.");
                return true;
            } else {
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have permission to do this. Node: EzBroadcast.Reset");
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("default")){
            if (commandSender.hasPermission("EzBroadcast.Default")){
                if (args[1].equalsIgnoreCase("current")){
                    commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "The default prefix is: " + ChatColor.RESET + "" + Main.getPlugin().getConfig().getString("defaultPrefix") + ChatColor.DARK_RED + "" + ChatColor.BOLD + " and the default messagecolor is: " + ChatColor.RESET + "" + Main.getPlugin().getConfig().getString("defaultMessageColor") + "This");
                    return true;
                }
                else if (args[1].equalsIgnoreCase("set")) {
                    if (args.length < 3) {
                        commandSender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You haven't given enough arguments. \nYou gave " + (args.length) + " Arguments but you should give more than 2.");
                        return true;
                    }
                    else if (args[2].equalsIgnoreCase("prefix")) {
                        String newdefaultprefix = String.join("", args);
                        String newdefaultprefix2 = newdefaultprefix.replaceAll("default|set|prefix", "");
                        Main.getPlugin().getConfig().set("defaultPrefix", newdefaultprefix2);
                        commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Successfully set the default prefix to: " + ChatColor.RESET + "" + newdefaultprefix2);
                        return true;
                    }
                    else if (args[2].equalsIgnoreCase("messagecolor") || args[2].equalsIgnoreCase("msgcolor")){
                        String newdefaultmsgcolor = String.join("", args);
                        String newdefaultmsgcolor2 = newdefaultmsgcolor.replaceAll("default|set|messagecolor|msgcolor", "");
                        Main.getPlugin().getConfig().set("defaultMessageColor", newdefaultmsgcolor2);
                        commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Successfully set the default messagecolor to: " + ChatColor.RESET + "" + newdefaultmsgcolor2 + "This");
                        return true;
                    }
                    else {
                        commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Usage /EzBroadcast Default Set <Prefix/MessageColor>");
                        return true;
                    }
                }

            }
            else{
                commandSender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have permission to do this. Node: EzBroadcast.Default");
                return true;
            }
        }
    return false;
    }

}