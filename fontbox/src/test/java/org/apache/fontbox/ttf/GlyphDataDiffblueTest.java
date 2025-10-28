package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.Test;

class GlyphDataDiffblueTest {
  /**
   * Methods under test:
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

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(1);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(eq(1));
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(1));
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, description.getContourCount());
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1, bounds.x);
    assertEquals(1, bounds.y);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0f, boundingBox.getLowerLeftX());
    assertEquals(1.0f, boundingBox.getLowerLeftY());
    assertEquals(1.0f, boundingBox.getUpperRightX());
    assertEquals(1.0f, boundingBox.getUpperRightY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1.5d, bounds.getCenterX());
    assertEquals(1.5d, bounds.getCenterY());
    assertEquals((short) 1, glyphData.getNumberOfContours());
    assertEquals((short) 1, glyphData.getXMaximum());
    assertEquals((short) 1, glyphData.getXMinimum());
    assertEquals((short) 1, glyphData.getYMaximum());
    assertEquals((short) 1, glyphData.getYMinimum());
    assertEquals(2, description.getPointCount());
    assertEquals(2.0d, bounds.getMaxX());
    assertEquals(2.0d, bounds.getMaxY());
    assertFalse(bounds.isEmpty());
    assertFalse(description.isComposite());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
    assertArrayEquals(new int[]{1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData2() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(2);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(eq(1));
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(1));
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertEquals(-2.0d, bounds.getMaxX());
    assertEquals(-3.0d, currentPoint.getX());
    assertEquals(-3.0d, bounds.getCenterX());
    assertEquals(-3.0f, ((Point2D.Float) currentPoint).x);
    Point location = bounds.getLocation();
    assertEquals(-4, location.x);
    assertEquals(-4, bounds.x);
    assertEquals(-4.0d, location.getX());
    assertEquals(-4.0d, bounds.getX());
    assertEquals(-4.0d, bounds.getMinX());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, description.getContourCount());
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, location.y);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.y);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, location.getY());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0f, boundingBox.getLowerLeftX());
    assertEquals(1.0f, boundingBox.getLowerLeftY());
    assertEquals(1.0f, boundingBox.getUpperRightX());
    assertEquals(1.0f, boundingBox.getUpperRightY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1.5d, bounds.getCenterY());
    assertEquals((short) 1, glyphData.getNumberOfContours());
    assertEquals((short) 1, glyphData.getXMaximum());
    assertEquals((short) 1, glyphData.getXMinimum());
    assertEquals((short) 1, glyphData.getYMaximum());
    assertEquals((short) 1, glyphData.getYMinimum());
    assertEquals(2, description.getPointCount());
    assertEquals(2, size.width);
    assertEquals(2, bounds.width);
    assertEquals(2.0d, size.getWidth());
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds.getMaxY());
    assertFalse(bounds.isEmpty());
    assertFalse(description.isComposite());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertArrayEquals(new int[]{1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData3() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(Short.SIZE);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(eq(1));
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(1));
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    Dimension size = bounds.getSize();
    assertEquals(0, size.width);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMinX());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(1, path.getWindingRule());
    assertEquals(1, description.getContourCount());
    assertEquals(1, size.height);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.y);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0f, boundingBox.getLowerLeftX());
    assertEquals(1.0f, boundingBox.getLowerLeftY());
    assertEquals(1.0f, boundingBox.getUpperRightX());
    assertEquals(1.0f, boundingBox.getUpperRightY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1.5d, bounds.getCenterY());
    assertEquals((short) 1, glyphData.getNumberOfContours());
    assertEquals((short) 1, glyphData.getXMaximum());
    assertEquals((short) 1, glyphData.getXMinimum());
    assertEquals((short) 1, glyphData.getYMaximum());
    assertEquals((short) 1, glyphData.getYMinimum());
    assertEquals(2, description.getPointCount());
    assertEquals(2.0d, bounds.getMaxY());
    assertFalse(description.isComposite());
    assertTrue(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
    assertArrayEquals(new int[]{1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData4() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedByte()).thenReturn(4);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedByte();
    verify(data).readUnsignedByteArray(eq(1));
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(1));
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertEquals(-4.0d, bounds.getMaxY());
    assertEquals(-6.0d, currentPoint.getY());
    assertEquals(-6.0d, bounds.getCenterY());
    assertEquals(-6.0f, ((Point2D.Float) currentPoint).y);
    Point location = bounds.getLocation();
    assertEquals(-8, location.y);
    assertEquals(-8, bounds.y);
    assertEquals(-8.0d, location.getY());
    assertEquals(-8.0d, bounds.getY());
    assertEquals(-8.0d, bounds.getMinY());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, description.getContourCount());
    Dimension size = bounds.getSize();
    assertEquals(1, size.width);
    assertEquals(1, location.x);
    assertEquals(1, bounds.width);
    assertEquals(1, bounds.x);
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, location.getX());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0f, boundingBox.getLowerLeftX());
    assertEquals(1.0f, boundingBox.getLowerLeftY());
    assertEquals(1.0f, boundingBox.getUpperRightX());
    assertEquals(1.0f, boundingBox.getUpperRightY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(1.5d, bounds.getCenterX());
    assertEquals((short) 1, glyphData.getNumberOfContours());
    assertEquals((short) 1, glyphData.getXMaximum());
    assertEquals((short) 1, glyphData.getXMinimum());
    assertEquals((short) 1, glyphData.getYMaximum());
    assertEquals((short) 1, glyphData.getYMinimum());
    assertEquals(2, description.getPointCount());
    assertEquals(2.0d, bounds.getMaxX());
    assertEquals(4, size.height);
    assertEquals(4, bounds.height);
    assertEquals(4.0d, size.getHeight());
    assertEquals(4.0d, bounds.getHeight());
    assertFalse(bounds.isEmpty());
    assertFalse(description.isComposite());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertArrayEquals(new int[]{1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData5() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{65535, -1, 1, -1});
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShortArray(eq(1));
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertNull(((GlyfSimpleDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, description.getContourCount());
    assertEquals(1.0f, boundingBox.getLowerLeftX());
    assertEquals(1.0f, boundingBox.getLowerLeftY());
    assertEquals(1.0f, boundingBox.getUpperRightX());
    assertEquals(1.0f, boundingBox.getUpperRightY());
    assertEquals((short) 1, glyphData.getNumberOfContours());
    assertEquals((short) 1, glyphData.getXMaximum());
    assertEquals((short) 1, glyphData.getXMinimum());
    assertEquals((short) 1, glyphData.getYMaximum());
    assertEquals((short) 1, glyphData.getYMinimum());
    assertFalse(description.isComposite());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData6() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(data.readSignedShort()).thenReturn(OS2WindowsMetricsTable.FSTYPE_RESTRICTED);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedByteArray(eq(1));
    verify(data).readUnsignedShort();
    verify(data).readUnsignedShortArray(eq(2));
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertNull(path.getCurrentPoint());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(2, description.getContourCount());
    assertEquals(2.0f, boundingBox.getLowerLeftX());
    assertEquals(2.0f, boundingBox.getLowerLeftY());
    assertEquals(2.0f, boundingBox.getUpperRightX());
    assertEquals(2.0f, boundingBox.getUpperRightY());
    assertFalse(description.isComposite());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getNumberOfContours());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getXMaximum());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getXMinimum());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getYMaximum());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, glyphData.getYMinimum());
    assertArrayEquals(new int[]{1, -1, 1, -1}, ((GlyfSimpleDescript) description).getInstructions());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData7() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedShort()).thenReturn((short) 0);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(data, atLeast(1)).readSignedShort();
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertNull(((GlyfSimpleDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals((short) 0, glyphData.getNumberOfContours());
    assertEquals((short) 0, glyphData.getXMaximum());
    assertEquals((short) 0, glyphData.getXMinimum());
    assertEquals((short) 0, glyphData.getYMaximum());
    assertEquals((short) 0, glyphData.getYMinimum());
    assertEquals(1, path.getWindingRule());
    assertFalse(description.isComposite());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData8() throws IOException {
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
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
    assertNull(((GlyfCompositeDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(-32768.0f, boundingBox.getLowerLeftX());
    assertEquals(-32768.0f, boundingBox.getLowerLeftY());
    assertEquals(-32768.0f, boundingBox.getUpperRightX());
    assertEquals(-32768.0f, boundingBox.getUpperRightY());
    List<GlyfCompositeComp> components = ((GlyfCompositeDescript) description).getComponents();
    assertEquals(1, components.size());
    GlyfCompositeComp getResult = components.get(0);
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, getResult.getGlyphIndex());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertEquals(1.0d, getResult.getXScale());
    assertEquals(1.0d, getResult.getYScale());
    assertEquals((short) 1, getResult.getArgument1());
    assertEquals((short) 1, getResult.getArgument2());
    assertTrue(bounds.isEmpty());
    assertTrue(description.isComposite());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(Short.MIN_VALUE, getResult.getFlags());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData9() throws IOException {
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
    verify(glyphTable).getGlyph(eq(1), eq(2));
    verify(data, atLeast(1)).readSignedByte();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
    assertNull(((GlyfCompositeDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(-32768.0f, boundingBox.getLowerLeftX());
    assertEquals(-32768.0f, boundingBox.getLowerLeftY());
    assertEquals(-32768.0f, boundingBox.getUpperRightX());
    assertEquals(-32768.0f, boundingBox.getUpperRightY());
    List<GlyfCompositeComp> components = ((GlyfCompositeDescript) description).getComponents();
    assertEquals(1, components.size());
    GlyfCompositeComp getResult = components.get(0);
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, getResult.getGlyphIndex());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertEquals(1.0d, getResult.getXScale());
    assertEquals(1.0d, getResult.getYScale());
    assertEquals((short) 1, getResult.getArgument1());
    assertEquals((short) 1, getResult.getArgument2());
    assertTrue(bounds.isEmpty());
    assertTrue(description.isComposite());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(Short.MIN_VALUE, getResult.getFlags());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  void testInitData10() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt(), anyInt())).thenThrow(new IOException("foo"));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readSignedByte()).thenReturn(1);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn(Short.MIN_VALUE);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    verify(glyphTable).getGlyph(eq(1), eq(2));
    verify(data, atLeast(1)).readSignedByte();
    verify(data, atLeast(1)).readSignedShort();
    verify(data).readUnsignedShort();
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
    assertNull(((GlyfCompositeDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(-32768.0f, boundingBox.getLowerLeftX());
    assertEquals(-32768.0f, boundingBox.getLowerLeftY());
    assertEquals(-32768.0f, boundingBox.getUpperRightX());
    assertEquals(-32768.0f, boundingBox.getUpperRightY());
    List<GlyfCompositeComp> components = ((GlyfCompositeDescript) description).getComponents();
    assertEquals(1, components.size());
    GlyfCompositeComp getResult = components.get(0);
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertEquals(1, getResult.getGlyphIndex());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertEquals(1.0d, getResult.getXScale());
    assertEquals(1.0d, getResult.getYScale());
    assertEquals((short) 1, getResult.getArgument1());
    assertEquals((short) 1, getResult.getArgument2());
    assertTrue(bounds.isEmpty());
    assertTrue(description.isComposite());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(Short.MIN_VALUE, getResult.getFlags());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Method under test: {@link GlyphData#initEmptyData()}
   */
  @Test
  void testInitEmptyData() {
    // Arrange
    GlyphData glyphData = new GlyphData();

    // Act
    glyphData.initEmptyData();

    // Assert
    GeneralPath path = glyphData.getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertNull(((GlyfSimpleDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertFalse(description.isComposite());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }
}
