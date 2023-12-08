package games.omg.recording;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import games.omg.Main;
import games.omg.recording.actions.classes.RecordedAction;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Recorder
 * 
 * Listens for the player's actions:
 * Moving
 * Jumping
 * Sneaking
 * Swimming
 * Sprinting
 * Elytra flying
 * Placing blocks
 * Breaking blocks
 * Being on fire
 * Taking damage
 * Wearing armor
 * Switching held items
 * 
 * And records them.
 * 
 * This is used later to create a "replay" of the player's actions.
 * A frame is taken each tick, and the most optimal way to store this data is
 * to store the player's actions in a bitset.
 */
public class Recorder {

  private List<RecordedAction> actions = new ArrayList<>();
  private int lastTick;

  private RecordingListener listener;
  private boolean isRecording = false;

  public void startRecording() {
    if (isRecording) return;
    isRecording = true;


    listener = new RecordingListener(this);
    Bukkit.getPluginManager().registerEvents(listener, Main.getPlugin());
  }

  public void stopRecording() {
    if (!isRecording) return;
    isRecording = false;

    HandlerList.unregisterAll(listener);

    ByteBuf buf = Unpooled.buffer();

    // TODO later we should immediately write to the buffer instead of storing each action
    for (RecordedAction action : actions) {
      action.serialize(buf);
    }

    // TODO
  }

  public Recorder(Player puppet) {
    lastTick = 0;
  }

  protected void record(RecordedAction action) {
    if (!isRecording) return;
    actions.add(action);
  }
}
