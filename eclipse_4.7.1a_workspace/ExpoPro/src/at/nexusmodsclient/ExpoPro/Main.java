package at.nexusmodsclient.ExpoPro;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import at.nexusmodsclient.ExpoPlus.CSpy;
import at.nexusmodsclient.ExpoPlus.Expo;
import at.nexusmodsclient.ExpoPlus.ExpoJoin;

public class Main extends JavaPlugin {
	
	private static char para = (char) 167;
	public static String Prefix = para+"4SuperUser"+para+"6 >> ";
	public static List<Player> superusers;
	
	@Override
	public void onEnable() {
		new Expo(this);
		new ExpoJoin(this);
		new CSpy(this);
	}
	
	@Override
	public void onDisable() {
		
	}

}
