package games.omg.recording.actions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import games.omg.recording.actions.classes.ActionTypes;
import games.omg.recording.actions.classes.RecordedAction;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BlockPlaceAction implements RecordedAction {
  private final Location location;
  private final Material material;

  public BlockPlaceAction(Block block) {
    this.location = block.getLocation();
    this.material = block.getType();
  }

  @Override
  public void serialize(ByteBuf out) {
    // Serialize the location and material into the ByteBuf
    // You can create your own protocol for how this data is structured
    
    ActionTypes.BLOCK_PLACE.writeTo(out);

    out.writeLong(location.toVector().toBlockVector().asLong()); // WTF!!!
    out.writeInt(material.ordinal());
  }

  @Override
  public void execute() {
    location.getBlock().setType(material);
  }

  // Additional methods
}
