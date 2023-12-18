package games.omg.recording.actions.classes;

import games.omg.recording.actions.BlockPlaceAction;
import games.omg.recording.actions.MovementAction;
import io.netty.buffer.ByteBuf;

public enum ActionTypes {
  MOVEMENT(1, MovementAction.class),
  // JUMP(2, JumpAction.class),
  // SNEAK(3, SneakAction.class),
  // SPRINT(4, SprintAction.class),
  // SWIM(5, SwimAction.class),
  // ELYTRA(6, ElytraAction.class),
  // FIRE(7, FireAction.class),
  // DAMAGE(8, DamageAction.class),
  // ARMOR(9, ArmorAction.class),
  // HELD_ITEM(10, HeldItemAction.class),
  // BLOCK_BREAK(11, BlockBreakAction.class),
  BLOCK_PLACE(12, BlockPlaceAction.class);

  private final byte id;
  private final Class<? extends RecordedAction> clazz;

  private ActionTypes(int id, Class<? extends RecordedAction> clazz) {
    this.id = (byte) id;
    this.clazz = clazz;
  }

  public byte getID() {
    return id;
  }

  public Class<? extends RecordedAction> getClazz() {
    return clazz;
  }

  public void writeTo(ByteBuf out) {
    out.writeByte(id);

    // it needs to write the data
    clazz.writeTo(out);
  }

  // is this necessary?
  public static Class<? extends RecordedAction> getActionClass(int id) {
    return getActionType(id).getClazz();
  }

  public static ActionTypes getActionType(int id) {
    for (ActionTypes type : values()) {
      if (type.getID() == id) {
        return type;
      }
    }
    return null;
  }
}
