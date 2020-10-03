package de.tobi.commands;

import de.tobi.util.WriteFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Seekable;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    if (sender instanceof Player)
    {
        Player player = (Player) sender;
        if (args.length == 0){
            player.sendMessage("§cUsage: /report <Username> <Reason>");
        }else if (args.length == 1){
            player.sendMessage("§cUsage: /report <Username> <Reason>");
        }else if (args.length == 2){
            String name = args[0];
            String reason = args[1];
            for(Player player1: Bukkit.getOnlinePlayers())
            {
                if (player1.getName().equals(name))
                {
                    UUID UUID1 = player1.getUniqueId();
                    UUID UUID2 = player.getUniqueId();
                    try {
                        Date today1 = Calendar.getInstance().getTime();
                        DateFormat tm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String gettime = tm.format(today1);
                        File fileReporter1 = new File("C:\\Users\\Tobi\\Desktop\\Server\\plugins\\reports", player.getName() + "-" + UUID2 + ".txt");
                        File fileReported2 = new File("C:\\Users\\Tobi\\Desktop\\Server\\plugins\\reports", player1.getName() + "-" + UUID1 + ".txt");
                        if(fileReporter1.exists()) {
                            WriteFile writeFile1 = new WriteFile("C:\\Users\\Tobi\\Desktop\\Server\\plugins\\reports" + player.getName() + "-" + UUID2, true);
                            writeFile1.writeToFile("[" + gettime + "] Reported Player: " + player1.getName() +  "| Reason: " + reason);
                        }else {
                            fileReporter1.createNewFile();
                            WriteFile writeFile1 = new WriteFile("C:\\Users\\Tobi\\Desktop\\Server\\plugins\\reports" + player.getName() + "-" + UUID2, false);
                            writeFile1.writeToFile("[" + gettime + "] Reported Player: " + player1.getName() +  "| Reason: " + reason);
                        }
                        if(fileReported2.exists()){
                            WriteFile writeFile2 = new WriteFile("C:\\Users\\Tobi\\Desktop\\Server\\plugins\\reports" + player1.getName() + "-" + UUID1, true);
                            writeFile2.writeToFile("[" + gettime + "] Reported by: " +  player1.getName() + "| Reason: " + reason);
                            }else{
                            fileReported2.createNewFile();
                            WriteFile writeFile2 = new WriteFile("C:\\Users\\Tobi\\Desktop\\Server\\plugins\\reports" + player1.getName() + "-" + UUID1, false);
                            writeFile2.writeToFile("[" + gettime + "] Reported by: " +  player1.getName() + "| Reason: " + reason);
                        }









                    } catch (IOException e) {
                        e.printStackTrace();
                        player.sendMessage("Your report could not be received.");
                    }
                    player.sendMessage("§c" + name + " reported for " + reason + ".");
                }
            }
        }
    }
        return false;
    }
}
