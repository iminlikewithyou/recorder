package games.omg;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage("welcome in!");
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
}
