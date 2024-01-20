package games.omg.recording;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

// detects when players are in chunks so that they may receive packets and events
// does this in a lightweight way so that it doesn't cause lag
// this means detecting every couple seconds or listening to relevant events such as teleports
public class PlaybackRadiusHandler implements Listener {

  public static boolean canReceiveEvents(Player player, Location location) {
    // check if the chunk is loaded
    return true;
  }

  // if a playback is running with nobody in the radius, it should run minimally
  // this means that it should pause the playback but record how long it was paused
  // so when it resumes, it can fast forward to the correct time

  // each playback should note down which chunks it uses so that this playbackradiushandler
  // can know if a player has strayed too far from the playback

  // playback should run if a player is within the radius of any of the chunks used by the playback
  // but if the player is not in the radius of the active chunks that the playback is currently using, they
  // wouldn't receive any packets still, but the playback would still be running and the player would see it
  // as soon as the playback enters the radius of the player
  // if a player is not within the radius of any of the chunks used by the playback, the playback should pause (see above)

  public static void updatePlayer(Player player) {
    
  }

  public static void updatePlayers() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      updatePlayer(player);
    }
  }
  
  @EventHandler
  public void onPlayerTeleport(PlayerTeleportEvent event) {
    // ignore teleports that don't substantially change the player's location
    switch (event.getCause()) {
      case CHORUS_FRUIT:
      case DISMOUNT:
      case EXIT_BED:
        return;
      default:
        break;
    }

    updatePlayer(event.getPlayer());
  }

  public static void initialize() {

  }
}
