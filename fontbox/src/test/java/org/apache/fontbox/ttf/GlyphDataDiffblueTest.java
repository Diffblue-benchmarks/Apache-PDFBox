package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphDataDiffblueTest {
  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenThrow(new IOException());
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act and Assert
    assertThrows(IOException.class, () -> glyphData.initData(glyphTable, data, 1, 1));
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShortArray(1);
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedByte()} return four.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); given four; when RandomAccessReadDataStream readUnsignedByte() return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_givenFour_whenRandomAccessReadDataStreamReadUnsignedByteReturnFour()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(4);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(1);
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(1);
    GeneralPath path = glyphData.getPath();
    assertTrue(path.getCurrentPoint() instanceof Float);
    assertTrue(path.getBounds2D() instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertArrayEquals(
        new int[] {1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Given {@link OS2WindowsMetricsTable#FSTYPE_RESTRICTED}.
   *   <li>Then {@link GlyphData} (default constructor) Description ContourCount is two.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); given FSTYPE_RESTRICTED; then GlyphData (default constructor) Description ContourCount is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_givenFstype_restricted_thenGlyphDataDescriptionContourCountIsTwo()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn(OS2WindowsMetricsTable.FSTYPE_RESTRICTED);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedByteArray(1);
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(2);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertEquals(2, description.getContourCount());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(2.0f, boundingBox.getLowerLeftX());
    assertEquals(2.0f, boundingBox.getLowerLeftY());
    assertEquals(2.0f, boundingBox.getUpperRightX());
    assertEquals(2.0f, boundingBox.getUpperRightY());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getNumberOfContours());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getXMaximum());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getXMinimum());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getYMaximum());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getYMinimum());
    assertArrayEquals(
        new int[] {1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Given {@link Short#MIN_VALUE}.
   *   <li>Then {@link GlyphData} (default constructor) Description {@link GlyfCompositeDescript}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); given MIN_VALUE; then GlyphData (default constructor) Description GlyfCompositeDescript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_givenMin_value_thenGlyphDataDescriptionGlyfCompositeDescript()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedByte()).thenReturn(1);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedByte();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(-32768.0f, boundingBox.getLowerLeftX());
    assertEquals(-32768.0f, boundingBox.getLowerLeftY());
    assertEquals(-32768.0f, boundingBox.getUpperRightX());
    assertEquals(-32768.0f, boundingBox.getUpperRightY());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponents().size());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertTrue(description.isComposite());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedByte()} return two.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); given two; when RandomAccessReadDataStream readUnsignedByte() return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_givenTwo_whenRandomAccessReadDataStreamReadUnsignedByteReturnTwo()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(2);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(1);
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(1);
    GeneralPath path = glyphData.getPath();
    assertTrue(path.getCurrentPoint() instanceof Float);
    assertTrue(path.getBounds2D() instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertArrayEquals(
        new int[] {1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then {@link GlyphData} (default constructor) BoundingBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); given zero; then GlyphData (default constructor) BoundingBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_givenZero_thenGlyphDataBoundingBoxLowerLeftXIsZero() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedShort()).thenReturn((short) 0);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertEquals(0, description.getContourCount());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals((short) 0, glyphData.getNumberOfContours());
    assertEquals((short) 0, glyphData.getXMaximum());
    assertEquals((short) 0, glyphData.getXMinimum());
    assertEquals((short) 0, glyphData.getYMaximum());
    assertEquals((short) 0, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Then {@link GlyphData} (default constructor) Path Bounds Bounds Location Location
   *       Location {@link Point#x} is zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); then GlyphData (default constructor) Path Bounds Bounds Location Location Location x is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_thenGlyphDataPathBoundsBoundsLocationLocationLocationXIsZero()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(Short.SIZE);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(1);
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(1);
    GeneralPath path = glyphData.getPath();
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    Point location = path.getBounds().getBounds().getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    assertEquals(0, location3.x);
    assertEquals(0, location2.x);
    assertEquals(0, location.x);
    assertEquals(0.0d, location3.getX());
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0f, ((Float) currentPoint).x);
    assertArrayEquals(
        new int[] {1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Then {@link GlyphData} (default constructor) Path Bounds Bounds Location Location
   *       Location {@link Point#y} is zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); then GlyphData (default constructor) Path Bounds Bounds Location Location Location y is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_thenGlyphDataPathBoundsBoundsLocationLocationLocationYIsZero()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(Integer.SIZE);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(1);
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(1);
    GeneralPath path = glyphData.getPath();
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    Point location = path.getBounds().getBounds().getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    assertEquals(0, location3.y);
    assertEquals(0, location2.y);
    assertEquals(0, location.y);
    assertEquals(0.0d, location3.getY());
    assertEquals(0.0d, location2.getY());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0f, ((Float) currentPoint).y);
    assertArrayEquals(
        new int[] {1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Then {@link GlyphData} (default constructor) Path Bounds Bounds Location Location {@link
   *       Point#x} is one.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); then GlyphData (default constructor) Path Bounds Bounds Location Location x is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_thenGlyphDataPathBoundsBoundsLocationLocationXIsOne() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(1);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(1);
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(1);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    Point location = glyphData.getPath().getBounds().getBounds().getLocation();
    Point location2 = location.getLocation();
    assertEquals(1, location2.x);
    assertEquals(1, location.x);
    assertEquals(1, location2.y);
    assertEquals(1, location.y);
    assertEquals(1.0d, location2.getX());
    assertEquals(1.0d, location.getX());
    assertEquals(1.0d, location2.getY());
    assertEquals(1.0d, location.getY());
    assertArrayEquals(
        new int[] {1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>Then {@link GlyphData} (default constructor) Path Bounds Frame Bounds2D {@link
   *       Rectangle2D.Double}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); then GlyphData (default constructor) Path Bounds Frame Bounds2D Double")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_thenGlyphDataPathBoundsFrameBounds2DDouble() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {65535, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShortArray(1);
    Rectangle2D frame = glyphData.getPath().getBounds().getFrame();
    Rectangle2D bounds2D = frame.getBounds2D();
    assertTrue(bounds2D instanceof Double);
    assertTrue(frame instanceof Double);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertEquals(0, description.getPointCount());
    Rectangle bounds = bounds2D.getBounds();
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, bounds.getWidth());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>When {@link GlyphTable} {@link GlyphTable#getGlyph(int, int)} return {@link GlyphData}
   *       (default constructor).
   *   <li>Then calls {@link GlyphTable#getGlyph(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); when GlyphTable getGlyph(int, int) return GlyphData (default constructor); then calls getGlyph(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_whenGlyphTableGetGlyphReturnGlyphData_thenCallsGetGlyph() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();

    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt(), anyInt())).thenReturn(new GlyphData());

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedByte()).thenReturn(1);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(glyphTable).getGlyph(1, 2);
    verify(data, atLeast(1)).readSignedByte();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(-32768.0f, boundingBox.getLowerLeftX());
    assertEquals(-32768.0f, boundingBox.getLowerLeftY());
    assertEquals(-32768.0f, boundingBox.getUpperRightX());
    assertEquals(-32768.0f, boundingBox.getUpperRightY());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponents().size());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertTrue(description.isComposite());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>When {@link GlyphTable} {@link GlyphTable#getGlyph(int, int)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link GlyphTable#getGlyph(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); when GlyphTable getGlyph(int, int) throw IOException(); then calls getGlyph(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_whenGlyphTableGetGlyphThrowIOException_thenCallsGetGlyph() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();

    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt(), anyInt())).thenThrow(new IOException());

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedByte()).thenReturn(1);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(glyphTable).getGlyph(1, 2);
    verify(data, atLeast(1)).readSignedByte();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(-32768.0f, boundingBox.getLowerLeftX());
    assertEquals(-32768.0f, boundingBox.getLowerLeftY());
    assertEquals(-32768.0f, boundingBox.getUpperRightX());
    assertEquals(-32768.0f, boundingBox.getUpperRightY());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponents().size());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertTrue(description.isComposite());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readSignedByte()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); when RandomAccessReadDataStream readSignedByte() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_whenRandomAccessReadDataStreamReadSignedByteThrowIOException()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedByte()).thenThrow(new IOException());
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);

    // Act and Assert
    assertThrows(IOException.class, () -> glyphData.initData(glyphTable, data, 1, 1));
    verify(data).readSignedByte();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShort()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); when RandomAccessReadDataStream readUnsignedShort() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_whenRandomAccessReadDataStreamReadUnsignedShortThrowIOException()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenThrow(new IOException());
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[] {1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act and Assert
    assertThrows(IOException.class, () -> glyphData.initData(glyphTable, data, 1, 1));
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(1);
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShort()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); when RandomAccessReadDataStream readUnsignedShort() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_whenRandomAccessReadDataStreamReadUnsignedShortThrowIOException2()
      throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenThrow(new IOException());
    when(data.readSignedShort()).thenReturn((short) -1);

    // Act and Assert
    assertThrows(IOException.class, () -> glyphData.initData(glyphTable, data, 1, 1));
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
  }

  /**
   * Test {@link GlyphData#initEmptyData()}.
   *
   * <p>Method under test: {@link GlyphData#initEmptyData()}
   */
  @Test
  @DisplayName("Test initEmptyData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initEmptyData()"})
  void testInitEmptyData() {
    // Arrange
    GlyphData glyphData = new GlyphData();

    // Act
    glyphData.initEmptyData();

    // Assert
    GeneralPath path = glyphData.getPath();
    assertTrue(path.getBounds2D() instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertNull(((GlyfSimpleDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertFalse(description.isComposite());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphData}
   *   <li>{@link GlyphData#getBoundingBox()}
   *   <li>{@link GlyphData#getDescription()}
   *   <li>{@link GlyphData#getNumberOfContours()}
   *   <li>{@link GlyphData#getXMaximum()}
   *   <li>{@link GlyphData#getXMinimum()}
   *   <li>{@link GlyphData#getYMaximum()}
   *   <li>{@link GlyphData#getYMinimum()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlyphData.<init>()",
    "BoundingBox GlyphData.getBoundingBox()",
    "GlyphDescription GlyphData.getDescription()",
    "short GlyphData.getNumberOfContours()",
    "short GlyphData.getXMaximum()",
    "short GlyphData.getXMinimum()",
    "short GlyphData.getYMaximum()",
    "short GlyphData.getYMinimum()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphData actualGlyphData = new GlyphData();
    BoundingBox actualBoundingBox = actualGlyphData.getBoundingBox();
    GlyphDescription actualDescription = actualGlyphData.getDescription();
    short actualNumberOfContours = actualGlyphData.getNumberOfContours();
    short actualXMaximum = actualGlyphData.getXMaximum();
    short actualXMinimum = actualGlyphData.getXMinimum();
    short actualYMaximum = actualGlyphData.getYMaximum();

    // Assert
    assertNull(actualDescription);
    assertNull(actualBoundingBox);
    assertEquals((short) 0, actualNumberOfContours);
    assertEquals((short) 0, actualXMaximum);
    assertEquals((short) 0, actualXMinimum);
    assertEquals((short) 0, actualYMaximum);
    assertEquals((short) 0, actualGlyphData.getYMinimum());
  }
}
