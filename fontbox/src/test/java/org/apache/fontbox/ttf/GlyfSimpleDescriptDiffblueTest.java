package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyfSimpleDescriptDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GlyfSimpleDescript#GlyfSimpleDescript()}
   *   <li>{@link GlyfSimpleDescript#getPointCount()}
   *   <li>{@link GlyfSimpleDescript#isComposite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlyfSimpleDescript.<init>()",
    "int GlyfSimpleDescript.getPointCount()",
    "boolean GlyfSimpleDescript.isComposite()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlyfSimpleDescript actualGlyfSimpleDescript = new GlyfSimpleDescript();
    int actualPointCount = actualGlyfSimpleDescript.getPointCount();
    boolean actualIsCompositeResult = actualGlyfSimpleDescript.isComposite();

    // Assert
    assertNull(actualGlyfSimpleDescript.getInstructions());
    assertEquals(0, actualGlyfSimpleDescript.getContourCount());
    assertEquals(0, actualPointCount);
    assertFalse(actualIsCompositeResult);
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(1);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 1, bais, (short) 1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
    assertEquals(1, actualGlyfSimpleDescript.getContourCount());
    assertEquals(2, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualGlyfSimpleDescript.getInstructions());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given {@code 65535}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); given '65535'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_given65535() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(65535);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> new GlyfSimpleDescript((short) 1, bais, (short) 1));
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given array of {@code int} with {@code 65535} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName(
      "Test new GlyfSimpleDescript(short, TTFDataStream, short); given array of int with '65535' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_givenArrayOfIntWith65535AndMinusOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {65535, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 1, bais, (short) 1);

    // Assert
    verify(bais).readUnsignedShortArray(1);
    assertNull(actualGlyfSimpleDescript.getInstructions());
    assertEquals(0, actualGlyfSimpleDescript.getPointCount());
    assertEquals(1, actualGlyfSimpleDescript.getContourCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given four.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); given four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_givenFour() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(4);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 1, bais, (short) 1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
    assertEquals(1, actualGlyfSimpleDescript.getContourCount());
    assertEquals(2, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualGlyfSimpleDescript.getInstructions());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); given IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_givenIOException() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedShort()).thenThrow(new IOException());
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> new GlyfSimpleDescript((short) 1, bais, (short) 1));
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); given SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_givenSize() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(Short.SIZE);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 1, bais, (short) 1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
    assertEquals(1, actualGlyfSimpleDescript.getContourCount());
    assertEquals(2, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualGlyfSimpleDescript.getInstructions());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); given SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_givenSize2() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(Integer.SIZE);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 1, bais, (short) 1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
    assertEquals(1, actualGlyfSimpleDescript.getContourCount());
    assertEquals(2, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualGlyfSimpleDescript.getInstructions());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); given two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_givenTwo() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(2);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 1, bais, (short) 1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(1);
    assertEquals(1, actualGlyfSimpleDescript.getContourCount());
    assertEquals(2, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualGlyfSimpleDescript.getInstructions());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>When {@link OS2WindowsMetricsTable#FSTYPE_RESTRICTED}.
   *   <li>Then return ContourCount is two.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName(
      "Test new GlyfSimpleDescript(short, TTFDataStream, short); when FSTYPE_RESTRICTED; then return ContourCount is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_whenFstype_restricted_thenReturnContourCountIsTwo()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});

    // Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, bais, (short) 1);

    // Assert
    verify(bais).readUnsignedByteArray(1);
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(2);
    assertEquals(0, actualGlyfSimpleDescript.getPointCount());
    assertEquals(2, actualGlyfSimpleDescript.getContourCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualGlyfSimpleDescript.getInstructions());
  }

  /**
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return ContourCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream,
   * short)}
   */
  @Test
  @DisplayName(
      "Test new GlyfSimpleDescript(short, TTFDataStream, short); when zero; then return ContourCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_whenZero_thenReturnContourCountIsZero() throws IOException {
    // Arrange and Act
    GlyfSimpleDescript actualGlyfSimpleDescript =
        new GlyfSimpleDescript((short) 0, mock(RandomAccessReadDataStream.class), (short) 1);

    // Assert
    assertNull(actualGlyfSimpleDescript.getInstructions());
    assertEquals(0, actualGlyfSimpleDescript.getContourCount());
    assertEquals(0, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
  }
}
