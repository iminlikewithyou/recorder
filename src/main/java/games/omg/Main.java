package games.omg;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class Main extends JavaPlugin implements Listener {
	
	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage("welcome in!");
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

		ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

        protocolManager.addPacketListener(new PacketAdapter(this, PacketType.Play.Client.BLOCK_DIG, PacketType.Play.Server.BLOCK_CHANGE) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
								event.getPlayer().sendMessage("PACKET " + event.getPacketType());
            }

						@Override
						public void onPacketSending(PacketEvent event) {
								event.getPlayer().sendMessage("PACKET " + event.getPacketType());
						}
        });

	}
}
