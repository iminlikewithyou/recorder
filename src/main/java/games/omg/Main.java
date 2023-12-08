package games.omg;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;

public class Main extends JavaPlugin implements Listener {

	private static Plugin plugin = null;
	
	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage("welcome in!");
	}

	@Override
	public void onEnable() {
		plugin = this;

		getServer().getPluginManager().registerEvents(this, this);
		// PacketTest.setup(this);
	}

	public static Plugin getPlugin() {
		return plugin;
	}
}
