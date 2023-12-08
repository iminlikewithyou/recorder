package games.omg.recording;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import games.omg.Main;
import games.omg.recording.actions.BlockPlaceAction;

public class RecordingListener implements Listener {
  
  private Recorder recorder;
  
  public RecordingListener(Recorder recorder) {
    this.recorder = recorder;
    register();
  }

  @EventHandler(ignoreCancelled = true)
  public void onBlockPlace(BlockPlaceEvent event) {
    recorder.record(new BlockPlaceAction(event.getBlock()));
  }

  private void register() {
    Bukkit.getServer().getPluginManager().registerEvents(this, Main.getPlugin());
  }

  private void unregister() {
    HandlerList.unregisterAll(this);
  }

  public void cleanup() {
    unregister();
  }
}
