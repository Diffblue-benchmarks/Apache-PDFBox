package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class DataInputDiffblueTest {
  /**
   * Method under test: {@link DataInput#readShort()}
   */
  @Test
  void testReadShort() throws IOException {
    // Arrange, Act and Assert
    assertEquals((short) 16728, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readShort());
  }

  /**
   * Method under test: {@link DataInput#readUnsignedShort()}
   */
  @Test
  void testReadUnsignedShort() throws IOException {
    // Arrange, Act and Assert
    assertEquals(16728, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readUnsignedShort());
  }

  /**
   * Method under test: {@link DataInput#readInt()}
   */
  @Test
  void testReadInt() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1096302936, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readInt());
  }

  /**
   * Method under test: {@link DataInput#readOffset(int)}
   */
  @Test
  void testReadOffset() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4282433, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readOffset(3));
  }
}
