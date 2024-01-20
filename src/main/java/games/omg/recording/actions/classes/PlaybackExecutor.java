package games.omg.recording.actions.classes;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;

public class PlaybackExecutor {

  public Set<Location> locations = new HashSet<>();

  // This should be called if an executor needs to record a block update
  private boolean recordBlockUpdate(Location location) {
    return locations.add(location);
  }

  public void destroyBlock(Location location) {
    if (!recordBlockUpdate(location)) return;

    // send packets to players who have the chunk loaded to destroy the block
    // record that the block was destroyed so that players who load the chunk later will see the block as destroyed
  }

  public void placeBlock(Location location) {
    if (!recordBlockUpdate(location)) return;

    // send packets to players who have the chunk loaded to place the block
    // record that the block was placed so that players who load the chunk later will see the block as placed
  }

  public void revertChanges() {
    for (Location location : locations) {
      // send packets to players who have the chunk loaded to revert the block
    }
  }
}
