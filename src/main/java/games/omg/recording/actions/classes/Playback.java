package games.omg.recording.actions.classes;

import org.bukkit.entity.Player;

public class Playback {
  
  // public static void getUsedChunks() {
  //   // Get the chunks that were used in the recording
  // }

  public static boolean isPlayerWithinAnyChunkRadius(Player player) {
    // return if the player is within the radius of ANY chunk that this recording uses
    // try to optimize this so that it doesn't have to check every chunk
    return true;
  }

  public static boolean isPlayerWithinChunkRadius(Player player, int chunkX, int chunkZ) {
    // return if the player is within the radius of the chunk at chunkX, chunkZ
    return true;
  }
}
