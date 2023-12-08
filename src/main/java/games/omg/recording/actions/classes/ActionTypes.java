package games.omg.recording.actions.classes;

import games.omg.recording.actions.BlockPlaceAction;
import io.netty.buffer.ByteBuf;

public enum ActionTypes {
  BLOCK_PLACE(0, BlockPlaceAction.class);

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
