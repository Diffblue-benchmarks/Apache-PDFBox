package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataInputDiffblueTest {
  /**
   * Test {@link DataInput#readShort()}.
   *
   * <ul>
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link DataInput#readShort()}
   */
  @Test
  @DisplayName("Test readShort(); then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short DataInput.readShort()"})
  void testReadShort_thenReturn16728() throws IOException {
    // Arrange, Act and Assert
    assertEquals((short) 16728, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readShort());
  }

  /**
   * Test {@link DataInput#readUnsignedShort()}.
   *
   * <ul>
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link DataInput#readUnsignedShort()}
   */
  @Test
  @DisplayName("Test readUnsignedShort(); then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInput.readUnsignedShort()"})
  void testReadUnsignedShort_thenReturn16728() throws IOException {
    // Arrange, Act and Assert
    assertEquals(16728, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readUnsignedShort());
  }

  /**
   * Test {@link DataInput#readInt()}.
   *
   * <ul>
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link DataInput#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); then return '1096302936'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInput.readInt()"})
  void testReadInt_thenReturn1096302936() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1096302936, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readInt());
  }

  /**
   * Test {@link DataInput#readOffset(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 4282433}.
   * </ul>
   *
   * <p>Method under test: {@link DataInput#readOffset(int)}
   */
  @Test
  @DisplayName("Test readOffset(int); when three; then return '4282433'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInput.readOffset(int)"})
  void testReadOffset_whenThree_thenReturn4282433() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4282433, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readOffset(3));
  }
}
