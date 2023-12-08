package games.omg.recording.actions.classes;

import io.netty.buffer.ByteBuf;

public interface RecordedAction {
  void serialize(ByteBuf out);
  void execute();
  // Add a method for reverting the action if necessary
}
