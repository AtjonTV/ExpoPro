package at.nexusmodsclient.ExpoPro.Mans;

import org.bukkit.plugin.Plugin;

import at.nexusmodsclient.ExpoPro.Main;

public class PlugMan {

	protected static Main main;
	
	public PlugMan(Main mainX)
	{
		main = mainX;
	}
	
	public static boolean disable(Plugin p)
	{
		if(main != null && isEnabled(p))
		{
			main.getServer().getPluginManager().disablePlugin(p);
			return true;
		}
		else
			return false;
	}
	
	public static boolean disableAll()
	{
		if(main != null)
		{
			main.getServer().getPluginManager().disablePlugins();
			return true;
		}
		else
			return false;
	}
	
	public static boolean enable(Plugin p)
	{
		if(main != null && !isEnabled(p))
		{
			main.getServer().getPluginManager().enablePlugin(p);
			return true;
		}
		else
			return false;
	}
	
	public static boolean isEnabled(Plugin p)
	{
		if(main != null)
		{
			return main.getServer().getPluginManager().isPluginEnabled(p);
		}
		else
			return false;
	}
	
}
