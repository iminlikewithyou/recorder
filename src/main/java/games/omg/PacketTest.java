package games.omg;

import org.bukkit.plugin.Plugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class PacketTest {
  public static void setup(Plugin plugin) {
    ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

		protocolManager.addPacketListener(new PacketAdapter(plugin, PacketType.Play.Client.BLOCK_DIG, PacketType.Play.Server.BLOCK_CHANGE) {
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
