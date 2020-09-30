package de.tobi.main;

import de.tobi.commands.ReportCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

@Override
 public void onEnable() {

    getCommand("report").setExecutor(new ReportCommand());
    getCommand("Report").setExecutor(new ReportCommand());


  }
}
