package games.omg.recording.actions;

import org.bukkit.Location;

import games.omg.recording.actions.classes.ActionTypes;
import games.omg.recording.actions.classes.RecordedAction;
import io.netty.buffer.ByteBuf;

public class MovementAction implements RecordedAction {
  private final Location location;

  public MovementAction(Location location) {
    this.location = location;
  }

  @Override
  public void serialize(ByteBuf out) {
    // Serialize the location and material into the ByteBuf
    // You can create your own protocol for how this data is structured
    
    ActionTypes.MOVEMENT.writeTo(out);

    out.writeDouble(location.getX());
    out.writeDouble(location.getY());
    out.writeDouble(location.getZ());
    out.writeFloat(location.getYaw());
    out.writeFloat(location.getPitch());
  }

  @Override
  public void execute() {
    // needs the puppet to send a movement packet
  }

  // Additional methods
}
