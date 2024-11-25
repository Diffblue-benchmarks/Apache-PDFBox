package org.apache.fontbox.ttf;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GlyphDataDiffblueTest {
  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int)")
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
    Point location = glyphData.getPath().getBounds().getBounds().getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(1, location4.getLocation().x);
    assertEquals(1, location4.x);
    assertEquals(1, location3.x);
    assertEquals(1, location2.x);
    assertEquals(1, location.x);
    assertEquals(1.0d, location4.getX());
    assertEquals(1.0d, location3.getX());
    assertEquals(1.0d, location2.getX());
    assertEquals(1.0d, location.getX());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int)")
  void testInitData2() throws IOException {
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
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Point location = path.getBounds().getBounds().getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(0, location4.getLocation().x);
    assertEquals(0, location4.x);
    assertEquals(0, location3.x);
    assertEquals(0, location2.x);
    assertEquals(0, location.x);
    assertEquals(0.0d, location4.getX());
    assertEquals(0.0d, location3.getX());
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int)")
  void testInitData3() throws IOException {
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D = bounds6.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds5.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    Rectangle bounds7 = bounds2D5.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D6 = bounds9.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = path.getBounds2D();
    Rectangle bounds10 = bounds2D7.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D8 = bounds12.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds13 = frame.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D bounds2D10 = bounds2.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle bounds16 = bounds2D10.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D11 = bounds17.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds8.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds18 = frame2.getBounds();
    Rectangle bounds19 = bounds18.getBounds();
    Rectangle2D bounds2D14 = bounds19.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle bounds20 = bounds2D4.getBounds();
    Rectangle2D bounds2D16 = bounds20.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = bounds16.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds7.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds10.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D bounds2D20 = bounds2D5.getBounds2D();
    Rectangle bounds21 = bounds2D20.getBounds();
    Rectangle2D bounds2D21 = bounds21.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D bounds2D22 = bounds2D7.getBounds2D();
    Rectangle bounds22 = bounds2D22.getBounds();
    Rectangle2D bounds2D23 = bounds22.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D bounds2D24 = frame.getBounds2D();
    Rectangle bounds23 = bounds2D24.getBounds();
    Rectangle2D bounds2D25 = bounds23.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D frame3 = bounds3.getFrame();
    Rectangle bounds24 = frame3.getBounds();
    Rectangle2D bounds2D26 = bounds24.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds18.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D frame4 = bounds2D5.getFrame();
    Rectangle bounds25 = frame4.getBounds();
    Rectangle2D bounds2D28 = bounds25.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds13.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D frame5 = bounds2D7.getFrame();
    Rectangle bounds26 = frame5.getBounds();
    Rectangle2D bounds2D30 = bounds26.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D3.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = bounds2D4.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle);
    Rectangle2D bounds2D33 = bounds2D10.getBounds2D();
    assertTrue(bounds2D33 instanceof Rectangle);
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D34 = bounds2D18.getBounds2D();
    assertTrue(bounds2D34 instanceof Rectangle);
    Rectangle2D bounds2D35 = bounds2D19.getBounds2D();
    assertTrue(bounds2D35 instanceof Rectangle);
    Rectangle2D bounds2D36 = bounds2D29.getBounds2D();
    assertTrue(bounds2D36 instanceof Rectangle);
    Rectangle2D bounds2D37 = bounds2D33.getBounds2D();
    assertTrue(bounds2D37 instanceof Rectangle);
    Rectangle2D bounds2D38 = bounds2D20.getBounds2D();
    assertTrue(bounds2D38 instanceof Rectangle);
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D bounds2D39 = frame2.getBounds2D();
    assertTrue(bounds2D39 instanceof Rectangle2D.Double);
    assertTrue(bounds2D24 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds4.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds2D10.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds7.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = bounds10.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    Rectangle2D frame10 = bounds13.getFrame();
    assertTrue(frame10 instanceof Rectangle2D.Double);
    Rectangle2D frame11 = frame2.getFrame();
    assertTrue(frame11 instanceof Rectangle2D.Double);
    Rectangle2D frame12 = frame.getFrame();
    assertTrue(frame12 instanceof Rectangle2D.Double);
    assertTrue(bounds2D7 instanceof Rectangle2D.Float);
    assertTrue(bounds2D22 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D40 = bounds2D22.getBounds2D();
    assertTrue(bounds2D40 instanceof Rectangle2D.Float);
    assertEquals(-4.0d, bounds6.getMaxY());
    assertEquals(-4.0d, bounds5.getMaxY());
    assertEquals(-4.0d, bounds4.getMaxY());
    assertEquals(-4.0d, bounds3.getMaxY());
    assertEquals(-4.0d, bounds9.getMaxY());
    assertEquals(-4.0d, bounds12.getMaxY());
    assertEquals(-4.0d, bounds15.getMaxY());
    assertEquals(-4.0d, bounds2.getMaxY());
    assertEquals(-4.0d, bounds17.getMaxY());
    assertEquals(-4.0d, bounds8.getMaxY());
    assertEquals(-4.0d, bounds11.getMaxY());
    assertEquals(-4.0d, bounds19.getMaxY());
    assertEquals(-4.0d, bounds14.getMaxY());
    assertEquals(-4.0d, bounds2D3.getMaxY());
    assertEquals(-4.0d, bounds2D4.getMaxY());
    assertEquals(-4.0d, bounds2D10.getMaxY());
    assertEquals(-4.0d, bounds2D5.getMaxY());
    assertEquals(-4.0d, bounds2D18.getMaxY());
    assertEquals(-4.0d, bounds2D19.getMaxY());
    assertEquals(-4.0d, bounds2D29.getMaxY());
    assertEquals(-4.0d, bounds.getMaxY());
    assertEquals(-4.0d, bounds2D7.getMaxY());
    assertEquals(-4.0d, bounds2D33.getMaxY());
    assertEquals(-4.0d, bounds2D20.getMaxY());
    assertEquals(-4.0d, bounds2D22.getMaxY());
    assertEquals(-4.0d, bounds2D39.getMaxY());
    assertEquals(-4.0d, bounds2D24.getMaxY());
    assertEquals(-4.0d, bounds20.getMaxY());
    assertEquals(-4.0d, bounds16.getMaxY());
    assertEquals(-4.0d, bounds7.getMaxY());
    assertEquals(-4.0d, bounds10.getMaxY());
    assertEquals(-4.0d, bounds21.getMaxY());
    assertEquals(-4.0d, bounds22.getMaxY());
    assertEquals(-4.0d, bounds23.getMaxY());
    assertEquals(-4.0d, bounds24.getMaxY());
    assertEquals(-4.0d, bounds18.getMaxY());
    assertEquals(-4.0d, bounds25.getMaxY());
    assertEquals(-4.0d, bounds13.getMaxY());
    assertEquals(-4.0d, bounds26.getMaxY());
    assertEquals(-4.0d, frame6.getMaxY());
    assertEquals(-4.0d, frame3.getMaxY());
    assertEquals(-4.0d, frame2.getMaxY());
    assertEquals(-4.0d, frame7.getMaxY());
    assertEquals(-4.0d, frame4.getMaxY());
    assertEquals(-4.0d, frame.getMaxY());
    assertEquals(-4.0d, frame5.getMaxY());
    assertEquals(-4.0d, frame8.getMaxY());
    assertEquals(-4.0d, frame9.getMaxY());
    assertEquals(-4.0d, frame10.getMaxY());
    assertEquals(-4.0d, frame11.getMaxY());
    assertEquals(-4.0d, frame12.getMaxY());
    assertEquals(-6.0d, currentPoint.getY());
    assertEquals(-6.0d, bounds6.getCenterY());
    assertEquals(-6.0d, bounds5.getCenterY());
    assertEquals(-6.0d, bounds4.getCenterY());
    assertEquals(-6.0d, bounds3.getCenterY());
    assertEquals(-6.0d, bounds9.getCenterY());
    assertEquals(-6.0d, bounds12.getCenterY());
    assertEquals(-6.0d, bounds15.getCenterY());
    assertEquals(-6.0d, bounds2.getCenterY());
    assertEquals(-6.0d, bounds17.getCenterY());
    assertEquals(-6.0d, bounds8.getCenterY());
    assertEquals(-6.0d, bounds11.getCenterY());
    assertEquals(-6.0d, bounds19.getCenterY());
    assertEquals(-6.0d, bounds14.getCenterY());
    assertEquals(-6.0d, bounds2D3.getCenterY());
    assertEquals(-6.0d, bounds2D4.getCenterY());
    assertEquals(-6.0d, bounds2D10.getCenterY());
    assertEquals(-6.0d, bounds2D5.getCenterY());
    assertEquals(-6.0d, bounds2D18.getCenterY());
    assertEquals(-6.0d, bounds2D19.getCenterY());
    assertEquals(-6.0d, bounds2D29.getCenterY());
    assertEquals(-6.0d, bounds.getCenterY());
    assertEquals(-6.0d, bounds2D7.getCenterY());
    assertEquals(-6.0d, bounds2D33.getCenterY());
    assertEquals(-6.0d, bounds2D20.getCenterY());
    assertEquals(-6.0d, bounds2D22.getCenterY());
    assertEquals(-6.0d, bounds2D39.getCenterY());
    assertEquals(-6.0d, bounds2D24.getCenterY());
    assertEquals(-6.0d, bounds20.getCenterY());
    assertEquals(-6.0d, bounds16.getCenterY());
    assertEquals(-6.0d, bounds7.getCenterY());
    assertEquals(-6.0d, bounds10.getCenterY());
    assertEquals(-6.0d, bounds21.getCenterY());
    assertEquals(-6.0d, bounds22.getCenterY());
    assertEquals(-6.0d, bounds23.getCenterY());
    assertEquals(-6.0d, bounds24.getCenterY());
    assertEquals(-6.0d, bounds18.getCenterY());
    assertEquals(-6.0d, bounds25.getCenterY());
    assertEquals(-6.0d, bounds13.getCenterY());
    assertEquals(-6.0d, bounds26.getCenterY());
    assertEquals(-6.0d, frame6.getCenterY());
    assertEquals(-6.0d, frame3.getCenterY());
    assertEquals(-6.0d, frame2.getCenterY());
    assertEquals(-6.0d, frame7.getCenterY());
    assertEquals(-6.0d, frame4.getCenterY());
    assertEquals(-6.0d, frame.getCenterY());
    assertEquals(-6.0d, frame5.getCenterY());
    assertEquals(-6.0d, frame8.getCenterY());
    assertEquals(-6.0d, frame9.getCenterY());
    assertEquals(-6.0d, frame10.getCenterY());
    assertEquals(-6.0d, frame11.getCenterY());
    assertEquals(-6.0d, frame12.getCenterY());
    assertEquals(-6.0f, ((Point2D.Float) currentPoint).y);
    Point location = bounds.getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(-8, location4.getLocation().y);
    Point location5 = bounds3.getLocation();
    Point location6 = location5.getLocation();
    Point location7 = location6.getLocation();
    assertEquals(-8, location7.getLocation().y);
    assertEquals(-8, location4.y);
    Point location8 = ((Rectangle) bounds2D5).getLocation();
    Point location9 = location8.getLocation();
    Point location10 = location9.getLocation();
    assertEquals(-8, location10.getLocation().y);
    Point location11 = bounds4.getLocation();
    Point location12 = location11.getLocation();
    assertEquals(-8, location12.getLocation().y);
    assertEquals(-8, location7.y);
    assertEquals(-8, location3.y);
    Point location13 = bounds7.getLocation();
    Point location14 = location13.getLocation();
    assertEquals(-8, location14.getLocation().y);
    Point location15 = bounds10.getLocation();
    Point location16 = location15.getLocation();
    assertEquals(-8, location16.getLocation().y);
    Point location17 = bounds13.getLocation();
    Point location18 = location17.getLocation();
    assertEquals(-8, location18.getLocation().y);
    Point location19 = ((Rectangle) bounds2D10).getLocation();
    Point location20 = location19.getLocation();
    assertEquals(-8, location20.getLocation().y);
    assertEquals(-8, location10.y);
    Point location21 = bounds5.getLocation();
    assertEquals(-8, location21.getLocation().y);
    assertEquals(-8, location12.y);
    assertEquals(-8, location6.y);
    Point location22 = bounds8.getLocation();
    assertEquals(-8, location22.getLocation().y);
    Point location23 = bounds11.getLocation();
    assertEquals(-8, location23.getLocation().y);
    Point location24 = bounds14.getLocation();
    assertEquals(-8, location24.getLocation().y);
    assertEquals(-8, location2.y);
    Point location25 = bounds16.getLocation();
    assertEquals(-8, location25.getLocation().y);
    assertEquals(-8, location14.y);
    assertEquals(-8, location16.y);
    Point location26 = bounds18.getLocation();
    assertEquals(-8, location26.getLocation().y);
    assertEquals(-8, location18.y);
    Point location27 = ((Rectangle) bounds2D4).getLocation();
    assertEquals(-8, location27.getLocation().y);
    assertEquals(-8, location20.y);
    assertEquals(-8, location9.y);
    Point location28 = ((Rectangle) bounds2D20).getLocation();
    assertEquals(-8, location28.getLocation().y);
    assertEquals(-8, bounds6.getLocation().y);
    assertEquals(-8, location21.y);
    assertEquals(-8, location11.y);
    assertEquals(-8, location5.y);
    assertEquals(-8, bounds9.getLocation().y);
    assertEquals(-8, bounds12.getLocation().y);
    assertEquals(-8, bounds15.getLocation().y);
    assertEquals(-8, bounds17.getLocation().y);
    assertEquals(-8, location22.y);
    assertEquals(-8, location23.y);
    assertEquals(-8, bounds19.getLocation().y);
    assertEquals(-8, location24.y);
    assertEquals(-8, location.y);
    assertEquals(-8, bounds20.getLocation().y);
    assertEquals(-8, location25.y);
    assertEquals(-8, location13.y);
    assertEquals(-8, location15.y);
    assertEquals(-8, bounds21.getLocation().y);
    assertEquals(-8, bounds22.getLocation().y);
    assertEquals(-8, bounds23.getLocation().y);
    assertEquals(-8, bounds24.getLocation().y);
    assertEquals(-8, location26.y);
    assertEquals(-8, bounds25.getLocation().y);
    assertEquals(-8, location17.y);
    assertEquals(-8, bounds26.getLocation().y);
    assertEquals(-8, ((Rectangle) bounds2D3).getLocation().y);
    assertEquals(-8, location27.y);
    assertEquals(-8, location19.y);
    assertEquals(-8, location8.y);
    assertEquals(-8, ((Rectangle) bounds2D18).getLocation().y);
    assertEquals(-8, ((Rectangle) bounds2D19).getLocation().y);
    assertEquals(-8, ((Rectangle) bounds2D29).getLocation().y);
    assertEquals(-8, ((Rectangle) bounds2D33).getLocation().y);
    assertEquals(-8, location28.y);
    Rectangle bounds27 = bounds6.getBounds();
    assertEquals(-8, bounds27.y);
    assertEquals(-8, bounds6.y);
    assertEquals(-8, bounds5.y);
    assertEquals(-8, bounds4.y);
    Rectangle bounds28 = bounds9.getBounds();
    assertEquals(-8, bounds28.y);
    Rectangle bounds29 = bounds12.getBounds();
    assertEquals(-8, bounds29.y);
    Rectangle bounds30 = bounds15.getBounds();
    assertEquals(-8, bounds30.y);
    assertEquals(-8, bounds3.y);
    Rectangle bounds31 = bounds17.getBounds();
    assertEquals(-8, bounds31.y);
    assertEquals(-8, bounds9.y);
    assertEquals(-8, bounds12.y);
    Rectangle bounds32 = bounds19.getBounds();
    assertEquals(-8, bounds32.y);
    assertEquals(-8, bounds15.y);
    assertEquals(-8, bounds2.y);
    Rectangle bounds33 = bounds20.getBounds();
    assertEquals(-8, bounds33.y);
    assertEquals(-8, bounds17.y);
    assertEquals(-8, bounds8.y);
    assertEquals(-8, bounds11.y);
    Rectangle bounds34 = bounds21.getBounds();
    assertEquals(-8, bounds34.y);
    Rectangle bounds35 = bounds22.getBounds();
    assertEquals(-8, bounds35.y);
    Rectangle bounds36 = bounds23.getBounds();
    assertEquals(-8, bounds36.y);
    Rectangle bounds37 = bounds24.getBounds();
    assertEquals(-8, bounds37.y);
    assertEquals(-8, bounds19.y);
    Rectangle bounds38 = bounds25.getBounds();
    assertEquals(-8, bounds38.y);
    assertEquals(-8, bounds14.y);
    Rectangle bounds39 = bounds26.getBounds();
    assertEquals(-8, bounds39.y);
    assertEquals(-8, bounds.y);
    Rectangle bounds40 = bounds2D3.getBounds();
    assertEquals(-8, bounds40.y);
    assertEquals(-8, bounds20.y);
    assertEquals(-8, bounds16.y);
    assertEquals(-8, bounds7.y);
    Rectangle bounds41 = bounds2D18.getBounds();
    assertEquals(-8, bounds41.y);
    Rectangle bounds42 = bounds2D19.getBounds();
    assertEquals(-8, bounds42.y);
    Rectangle bounds43 = bounds2D29.getBounds();
    assertEquals(-8, bounds43.y);
    assertEquals(-8, bounds10.y);
    Rectangle bounds44 = bounds2D33.getBounds();
    assertEquals(-8, bounds44.y);
    assertEquals(-8, bounds21.y);
    assertEquals(-8, bounds22.y);
    Rectangle bounds45 = bounds2D39.getBounds();
    assertEquals(-8, bounds45.y);
    assertEquals(-8, bounds23.y);
    Rectangle bounds46 = frame6.getBounds();
    assertEquals(-8, bounds46.y);
    assertEquals(-8, bounds24.y);
    assertEquals(-8, bounds18.y);
    Rectangle bounds47 = frame7.getBounds();
    assertEquals(-8, bounds47.y);
    assertEquals(-8, bounds25.y);
    assertEquals(-8, bounds13.y);
    assertEquals(-8, bounds26.y);
    Rectangle bounds48 = frame8.getBounds();
    assertEquals(-8, bounds48.y);
    Rectangle bounds49 = frame9.getBounds();
    assertEquals(-8, bounds49.y);
    Rectangle bounds50 = frame10.getBounds();
    assertEquals(-8, bounds50.y);
    Rectangle bounds51 = frame11.getBounds();
    assertEquals(-8, bounds51.y);
    Rectangle bounds52 = frame12.getBounds();
    assertEquals(-8, bounds52.y);
    assertEquals(-8, ((Rectangle) bounds2D).y);
    assertEquals(-8, ((Rectangle) bounds2D2).y);
    assertEquals(-8, ((Rectangle) bounds2D3).y);
    assertEquals(-8, ((Rectangle) bounds2D4).y);
    assertEquals(-8, ((Rectangle) bounds2D6).y);
    assertEquals(-8, ((Rectangle) bounds2D8).y);
    assertEquals(-8, ((Rectangle) bounds2D9).y);
    assertEquals(-8, ((Rectangle) bounds2D10).y);
    assertEquals(-8, ((Rectangle) bounds2D11).y);
    assertEquals(-8, ((Rectangle) bounds2D12).y);
    assertEquals(-8, ((Rectangle) bounds2D13).y);
    assertEquals(-8, ((Rectangle) bounds2D14).y);
    assertEquals(-8, ((Rectangle) bounds2D15).y);
    assertEquals(-8, ((Rectangle) bounds2D5).y);
    assertEquals(-8, ((Rectangle) bounds2D16).y);
    assertEquals(-8, ((Rectangle) bounds2D17).y);
    assertEquals(-8, ((Rectangle) bounds2D18).y);
    assertEquals(-8, ((Rectangle) bounds2D19).y);
    assertEquals(-8, ((Rectangle) bounds2D21).y);
    assertEquals(-8, ((Rectangle) bounds2D23).y);
    assertEquals(-8, ((Rectangle) bounds2D25).y);
    assertEquals(-8, ((Rectangle) bounds2D26).y);
    assertEquals(-8, ((Rectangle) bounds2D27).y);
    assertEquals(-8, ((Rectangle) bounds2D28).y);
    assertEquals(-8, ((Rectangle) bounds2D29).y);
    assertEquals(-8, ((Rectangle) bounds2D30).y);
    assertEquals(-8, ((Rectangle) bounds2D31).y);
    assertEquals(-8, ((Rectangle) bounds2D32).y);
    assertEquals(-8, ((Rectangle) bounds2D33).y);
    assertEquals(-8, ((Rectangle) bounds2D20).y);
    assertEquals(-8, ((Rectangle) bounds2D34).y);
    assertEquals(-8, ((Rectangle) bounds2D35).y);
    assertEquals(-8, ((Rectangle) bounds2D36).y);
    assertEquals(-8, ((Rectangle) bounds2D37).y);
    assertEquals(-8, ((Rectangle) bounds2D38).y);
    assertEquals(-8.0d, location4.getY());
    assertEquals(-8.0d, location7.getY());
    assertEquals(-8.0d, location3.getY());
    assertEquals(-8.0d, location10.getY());
    assertEquals(-8.0d, location12.getY());
    assertEquals(-8.0d, location6.getY());
    assertEquals(-8.0d, location2.getY());
    assertEquals(-8.0d, location14.getY());
    assertEquals(-8.0d, location16.getY());
    assertEquals(-8.0d, location18.getY());
    assertEquals(-8.0d, location20.getY());
    assertEquals(-8.0d, location9.getY());
    assertEquals(-8.0d, location21.getY());
    assertEquals(-8.0d, location11.getY());
    assertEquals(-8.0d, location5.getY());
    assertEquals(-8.0d, location22.getY());
    assertEquals(-8.0d, location23.getY());
    assertEquals(-8.0d, location24.getY());
    assertEquals(-8.0d, location.getY());
    assertEquals(-8.0d, location25.getY());
    assertEquals(-8.0d, location13.getY());
    assertEquals(-8.0d, location15.getY());
    assertEquals(-8.0d, location26.getY());
    assertEquals(-8.0d, location17.getY());
    assertEquals(-8.0d, location27.getY());
    assertEquals(-8.0d, location19.getY());
    assertEquals(-8.0d, location8.getY());
    assertEquals(-8.0d, location28.getY());
    assertEquals(-8.0d, bounds6.getY());
    assertEquals(-8.0d, bounds5.getY());
    assertEquals(-8.0d, bounds4.getY());
    assertEquals(-8.0d, bounds3.getY());
    assertEquals(-8.0d, bounds9.getY());
    assertEquals(-8.0d, bounds12.getY());
    assertEquals(-8.0d, bounds15.getY());
    assertEquals(-8.0d, bounds2.getY());
    assertEquals(-8.0d, bounds17.getY());
    assertEquals(-8.0d, bounds8.getY());
    assertEquals(-8.0d, bounds11.getY());
    assertEquals(-8.0d, bounds19.getY());
    assertEquals(-8.0d, bounds14.getY());
    assertEquals(-8.0d, bounds.getY());
    assertEquals(-8.0d, bounds20.getY());
    assertEquals(-8.0d, bounds16.getY());
    assertEquals(-8.0d, bounds7.getY());
    assertEquals(-8.0d, bounds10.getY());
    assertEquals(-8.0d, bounds21.getY());
    assertEquals(-8.0d, bounds22.getY());
    assertEquals(-8.0d, bounds24.getY());
    assertEquals(-8.0d, bounds18.getY());
    assertEquals(-8.0d, bounds25.getY());
    assertEquals(-8.0d, bounds13.getY());
    assertEquals(-8.0d, bounds26.getY());
    assertEquals(-8.0d, bounds6.getMinY());
    assertEquals(-8.0d, bounds5.getMinY());
    assertEquals(-8.0d, bounds4.getMinY());
    assertEquals(-8.0d, bounds3.getMinY());
    assertEquals(-8.0d, bounds9.getMinY());
    assertEquals(-8.0d, bounds12.getMinY());
    assertEquals(-8.0d, bounds15.getMinY());
    assertEquals(-8.0d, bounds2.getMinY());
    assertEquals(-8.0d, bounds17.getMinY());
    assertEquals(-8.0d, bounds8.getMinY());
    assertEquals(-8.0d, bounds11.getMinY());
    assertEquals(-8.0d, bounds19.getMinY());
    assertEquals(-8.0d, bounds14.getMinY());
    assertEquals(-8.0d, bounds2D3.getMinY());
    assertEquals(-8.0d, bounds2D4.getMinY());
    assertEquals(-8.0d, bounds2D10.getMinY());
    assertEquals(-8.0d, bounds2D5.getMinY());
    assertEquals(-8.0d, bounds2D18.getMinY());
    assertEquals(-8.0d, bounds2D19.getMinY());
    assertEquals(-8.0d, bounds2D29.getMinY());
    assertEquals(-8.0d, bounds.getMinY());
    assertEquals(-8.0d, bounds2D7.getMinY());
    assertEquals(-8.0d, bounds2D33.getMinY());
    assertEquals(-8.0d, bounds2D20.getMinY());
    assertEquals(-8.0d, bounds2D22.getMinY());
    assertEquals(-8.0d, bounds2D39.getMinY());
    assertEquals(-8.0d, bounds2D24.getMinY());
    assertEquals(-8.0d, bounds20.getMinY());
    assertEquals(-8.0d, bounds16.getMinY());
    assertEquals(-8.0d, bounds7.getMinY());
    assertEquals(-8.0d, bounds10.getMinY());
    assertEquals(-8.0d, bounds21.getMinY());
    assertEquals(-8.0d, bounds22.getMinY());
    assertEquals(-8.0d, bounds23.getMinY());
    assertEquals(-8.0d, bounds24.getMinY());
    assertEquals(-8.0d, bounds18.getMinY());
    assertEquals(-8.0d, bounds25.getMinY());
    assertEquals(-8.0d, bounds13.getMinY());
    assertEquals(-8.0d, bounds26.getMinY());
    assertEquals(-8.0d, frame6.getMinY());
    assertEquals(-8.0d, frame3.getMinY());
    assertEquals(-8.0d, frame2.getMinY());
    assertEquals(-8.0d, frame7.getMinY());
    assertEquals(-8.0d, frame4.getMinY());
    assertEquals(-8.0d, frame.getMinY());
    assertEquals(-8.0d, frame5.getMinY());
    assertEquals(-8.0d, frame8.getMinY());
    assertEquals(-8.0d, frame9.getMinY());
    assertEquals(-8.0d, frame10.getMinY());
    assertEquals(-8.0d, frame11.getMinY());
    assertEquals(-8.0d, frame12.getMinY());
    assertEquals(-8.0d, bounds2D3.getY());
    assertEquals(-8.0d, bounds2D4.getY());
    assertEquals(-8.0d, bounds2D10.getY());
    assertEquals(-8.0d, bounds2D5.getY());
    assertEquals(-8.0d, bounds2D18.getY());
    assertEquals(-8.0d, bounds2D19.getY());
    assertEquals(-8.0d, bounds2D29.getY());
    assertEquals(-8.0d, bounds2D7.getY());
    assertEquals(-8.0d, bounds2D33.getY());
    assertEquals(-8.0d, bounds2D20.getY());
    assertEquals(-8.0d, bounds2D22.getY());
    assertEquals(-8.0d, bounds2D39.getY());
    assertEquals(-8.0d, bounds2D24.getY());
    assertEquals(-8.0d, frame6.getY());
    assertEquals(-8.0d, frame3.getY());
    assertEquals(-8.0d, frame2.getY());
    assertEquals(-8.0d, frame7.getY());
    assertEquals(-8.0d, frame4.getY());
    assertEquals(-8.0d, frame.getY());
    assertEquals(-8.0d, frame5.getY());
    assertEquals(-8.0d, frame8.getY());
    assertEquals(-8.0d, frame9.getY());
    assertEquals(-8.0d, frame10.getY());
    assertEquals(-8.0d, frame11.getY());
    assertEquals(-8.0d, frame12.getY());
    assertEquals(-8.0f, ((Rectangle2D.Float) bounds2D7).y);
    assertEquals(-8.0f, ((Rectangle2D.Float) bounds2D22).y);
    assertEquals(-8.0f, ((Rectangle2D.Float) bounds2D40).y);
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(4, size4.getSize().height);
    Dimension size5 = bounds3.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(4, size7.getSize().height);
    assertEquals(4, size4.height);
    Dimension size8 = ((Rectangle) bounds2D5).getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(4, size10.getSize().height);
    Dimension size11 = bounds4.getSize();
    Dimension size12 = size11.getSize();
    assertEquals(4, size12.getSize().height);
    assertEquals(4, size7.height);
    assertEquals(4, size3.height);
    Dimension size13 = bounds7.getSize();
    Dimension size14 = size13.getSize();
    assertEquals(4, size14.getSize().height);
    Dimension size15 = bounds10.getSize();
    Dimension size16 = size15.getSize();
    assertEquals(4, size16.getSize().height);
    Dimension size17 = bounds13.getSize();
    Dimension size18 = size17.getSize();
    assertEquals(4, size18.getSize().height);
    Dimension size19 = ((Rectangle) bounds2D10).getSize();
    Dimension size20 = size19.getSize();
    assertEquals(4, size20.getSize().height);
    assertEquals(4, size10.height);
    Dimension size21 = bounds5.getSize();
    assertEquals(4, size21.getSize().height);
    assertEquals(4, size12.height);
    assertEquals(4, size6.height);
    Dimension size22 = bounds8.getSize();
    assertEquals(4, size22.getSize().height);
    Dimension size23 = bounds11.getSize();
    assertEquals(4, size23.getSize().height);
    Dimension size24 = bounds14.getSize();
    assertEquals(4, size24.getSize().height);
    assertEquals(4, size2.height);
    Dimension size25 = bounds16.getSize();
    assertEquals(4, size25.getSize().height);
    assertEquals(4, size14.height);
    assertEquals(4, size16.height);
    Dimension size26 = bounds18.getSize();
    assertEquals(4, size26.getSize().height);
    assertEquals(4, size18.height);
    Dimension size27 = ((Rectangle) bounds2D4).getSize();
    assertEquals(4, size27.getSize().height);
    assertEquals(4, size20.height);
    assertEquals(4, size9.height);
    Dimension size28 = ((Rectangle) bounds2D20).getSize();
    assertEquals(4, size28.getSize().height);
    assertEquals(4, bounds6.getSize().height);
    assertEquals(4, size21.height);
    assertEquals(4, size11.height);
    assertEquals(4, size5.height);
    assertEquals(4, bounds9.getSize().height);
    assertEquals(4, bounds12.getSize().height);
    assertEquals(4, bounds15.getSize().height);
    assertEquals(4, bounds17.getSize().height);
    assertEquals(4, size22.height);
    assertEquals(4, size23.height);
    assertEquals(4, bounds19.getSize().height);
    assertEquals(4, size24.height);
    assertEquals(4, size.height);
    assertEquals(4, bounds20.getSize().height);
    assertEquals(4, size25.height);
    assertEquals(4, size13.height);
    assertEquals(4, size15.height);
    assertEquals(4, bounds21.getSize().height);
    assertEquals(4, bounds22.getSize().height);
    assertEquals(4, bounds24.getSize().height);
    assertEquals(4, size26.height);
    assertEquals(4, bounds25.getSize().height);
    assertEquals(4, size17.height);
    assertEquals(4, bounds26.getSize().height);
    assertEquals(4, ((Rectangle) bounds2D3).getSize().height);
    assertEquals(4, size27.height);
    assertEquals(4, size19.height);
    assertEquals(4, size8.height);
    assertEquals(4, ((Rectangle) bounds2D18).getSize().height);
    assertEquals(4, ((Rectangle) bounds2D19).getSize().height);
    assertEquals(4, ((Rectangle) bounds2D29).getSize().height);
    assertEquals(4, ((Rectangle) bounds2D33).getSize().height);
    assertEquals(4, size28.height);
    assertEquals(4, bounds27.height);
    assertEquals(4, bounds6.height);
    assertEquals(4, bounds5.height);
    assertEquals(4, bounds4.height);
    assertEquals(4, bounds28.height);
    assertEquals(4, bounds29.height);
    assertEquals(4, bounds30.height);
    assertEquals(4, bounds3.height);
    assertEquals(4, bounds31.height);
    assertEquals(4, bounds9.height);
    assertEquals(4, bounds12.height);
    assertEquals(4, bounds32.height);
    assertEquals(4, bounds15.height);
    assertEquals(4, bounds2.height);
    assertEquals(4, bounds33.height);
    assertEquals(4, bounds17.height);
    assertEquals(4, bounds8.height);
    assertEquals(4, bounds11.height);
    assertEquals(4, bounds34.height);
    assertEquals(4, bounds35.height);
    assertEquals(4, bounds36.height);
    assertEquals(4, bounds37.height);
    assertEquals(4, bounds19.height);
    assertEquals(4, bounds38.height);
    assertEquals(4, bounds14.height);
    assertEquals(4, bounds39.height);
    assertEquals(4, bounds.height);
    assertEquals(4, bounds40.height);
    assertEquals(4, bounds20.height);
    assertEquals(4, bounds16.height);
    assertEquals(4, bounds7.height);
    assertEquals(4, bounds41.height);
    assertEquals(4, bounds42.height);
    assertEquals(4, bounds43.height);
    assertEquals(4, bounds10.height);
    assertEquals(4, bounds44.height);
    assertEquals(4, bounds21.height);
    assertEquals(4, bounds22.height);
    assertEquals(4, bounds45.height);
    assertEquals(4, bounds23.height);
    assertEquals(4, bounds46.height);
    assertEquals(4, bounds24.height);
    assertEquals(4, bounds18.height);
    assertEquals(4, bounds47.height);
    assertEquals(4, bounds25.height);
    assertEquals(4, bounds13.height);
    assertEquals(4, bounds26.height);
    assertEquals(4, bounds48.height);
    assertEquals(4, bounds49.height);
    assertEquals(4, bounds50.height);
    assertEquals(4, bounds51.height);
    assertEquals(4, bounds52.height);
    assertEquals(4, ((Rectangle) bounds2D).height);
    assertEquals(4, ((Rectangle) bounds2D2).height);
    assertEquals(4, ((Rectangle) bounds2D3).height);
    assertEquals(4, ((Rectangle) bounds2D4).height);
    assertEquals(4, ((Rectangle) bounds2D6).height);
    assertEquals(4, ((Rectangle) bounds2D8).height);
    assertEquals(4, ((Rectangle) bounds2D9).height);
    assertEquals(4, ((Rectangle) bounds2D10).height);
    assertEquals(4, ((Rectangle) bounds2D11).height);
    assertEquals(4, ((Rectangle) bounds2D12).height);
    assertEquals(4, ((Rectangle) bounds2D13).height);
    assertEquals(4, ((Rectangle) bounds2D14).height);
    assertEquals(4, ((Rectangle) bounds2D15).height);
    assertEquals(4, ((Rectangle) bounds2D5).height);
    assertEquals(4, ((Rectangle) bounds2D16).height);
    assertEquals(4, ((Rectangle) bounds2D17).height);
    assertEquals(4, ((Rectangle) bounds2D18).height);
    assertEquals(4, ((Rectangle) bounds2D19).height);
    assertEquals(4, ((Rectangle) bounds2D21).height);
    assertEquals(4, ((Rectangle) bounds2D23).height);
    assertEquals(4, ((Rectangle) bounds2D25).height);
    assertEquals(4, ((Rectangle) bounds2D26).height);
    assertEquals(4, ((Rectangle) bounds2D27).height);
    assertEquals(4, ((Rectangle) bounds2D28).height);
    assertEquals(4, ((Rectangle) bounds2D29).height);
    assertEquals(4, ((Rectangle) bounds2D30).height);
    assertEquals(4, ((Rectangle) bounds2D31).height);
    assertEquals(4, ((Rectangle) bounds2D32).height);
    assertEquals(4, ((Rectangle) bounds2D33).height);
    assertEquals(4, ((Rectangle) bounds2D20).height);
    assertEquals(4, ((Rectangle) bounds2D34).height);
    assertEquals(4, ((Rectangle) bounds2D35).height);
    assertEquals(4, ((Rectangle) bounds2D36).height);
    assertEquals(4, ((Rectangle) bounds2D37).height);
    assertEquals(4, ((Rectangle) bounds2D38).height);
    assertEquals(4.0d, size4.getHeight());
    assertEquals(4.0d, size7.getHeight());
    assertEquals(4.0d, size3.getHeight());
    assertEquals(4.0d, size10.getHeight());
    assertEquals(4.0d, size12.getHeight());
    assertEquals(4.0d, size6.getHeight());
    assertEquals(4.0d, size2.getHeight());
    assertEquals(4.0d, size14.getHeight());
    assertEquals(4.0d, size16.getHeight());
    assertEquals(4.0d, size18.getHeight());
    assertEquals(4.0d, size20.getHeight());
    assertEquals(4.0d, size9.getHeight());
    assertEquals(4.0d, size21.getHeight());
    assertEquals(4.0d, size11.getHeight());
    assertEquals(4.0d, size5.getHeight());
    assertEquals(4.0d, size22.getHeight());
    assertEquals(4.0d, size23.getHeight());
    assertEquals(4.0d, size24.getHeight());
    assertEquals(4.0d, size.getHeight());
    assertEquals(4.0d, size25.getHeight());
    assertEquals(4.0d, size13.getHeight());
    assertEquals(4.0d, size15.getHeight());
    assertEquals(4.0d, size26.getHeight());
    assertEquals(4.0d, size17.getHeight());
    assertEquals(4.0d, size27.getHeight());
    assertEquals(4.0d, size19.getHeight());
    assertEquals(4.0d, size8.getHeight());
    assertEquals(4.0d, size28.getHeight());
    assertEquals(4.0d, bounds6.getHeight());
    assertEquals(4.0d, bounds5.getHeight());
    assertEquals(4.0d, bounds4.getHeight());
    assertEquals(4.0d, bounds3.getHeight());
    assertEquals(4.0d, bounds9.getHeight());
    assertEquals(4.0d, bounds12.getHeight());
    assertEquals(4.0d, bounds15.getHeight());
    assertEquals(4.0d, bounds2.getHeight());
    assertEquals(4.0d, bounds17.getHeight());
    assertEquals(4.0d, bounds8.getHeight());
    assertEquals(4.0d, bounds11.getHeight());
    assertEquals(4.0d, bounds19.getHeight());
    assertEquals(4.0d, bounds14.getHeight());
    assertEquals(4.0d, bounds.getHeight());
    assertEquals(4.0d, bounds20.getHeight());
    assertEquals(4.0d, bounds16.getHeight());
    assertEquals(4.0d, bounds7.getHeight());
    assertEquals(4.0d, bounds10.getHeight());
    assertEquals(4.0d, bounds21.getHeight());
    assertEquals(4.0d, bounds22.getHeight());
    assertEquals(4.0d, bounds23.getHeight());
    assertEquals(4.0d, bounds24.getHeight());
    assertEquals(4.0d, bounds18.getHeight());
    assertEquals(4.0d, bounds25.getHeight());
    assertEquals(4.0d, bounds13.getHeight());
    assertEquals(4.0d, bounds26.getHeight());
    assertEquals(4.0d, bounds2D3.getHeight());
    assertEquals(4.0d, bounds2D4.getHeight());
    assertEquals(4.0d, bounds2D10.getHeight());
    assertEquals(4.0d, bounds2D5.getHeight());
    assertEquals(4.0d, bounds2D18.getHeight());
    assertEquals(4.0d, bounds2D19.getHeight());
    assertEquals(4.0d, bounds2D29.getHeight());
    assertEquals(4.0d, bounds2D7.getHeight());
    assertEquals(4.0d, bounds2D33.getHeight());
    assertEquals(4.0d, bounds2D20.getHeight());
    assertEquals(4.0d, bounds2D22.getHeight());
    assertEquals(4.0d, bounds2D39.getHeight());
    assertEquals(4.0d, bounds2D24.getHeight());
    assertEquals(4.0d, frame6.getHeight());
    assertEquals(4.0d, frame3.getHeight());
    assertEquals(4.0d, frame2.getHeight());
    assertEquals(4.0d, frame7.getHeight());
    assertEquals(4.0d, frame4.getHeight());
    assertEquals(4.0d, frame.getHeight());
    assertEquals(4.0d, frame5.getHeight());
    assertEquals(4.0d, frame8.getHeight());
    assertEquals(4.0d, frame9.getHeight());
    assertEquals(4.0d, frame10.getHeight());
    assertEquals(4.0d, frame11.getHeight());
    assertEquals(4.0d, frame12.getHeight());
    assertEquals(4.0f, ((Rectangle2D.Float) bounds2D7).height);
    assertEquals(4.0f, ((Rectangle2D.Float) bounds2D22).height);
    assertEquals(4.0f, ((Rectangle2D.Float) bounds2D40).height);
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <ul>
   *   <li>Given {@link OS2WindowsMetricsTable#FSTYPE_RESTRICTED}.</li>
   *   <li>Then {@link GlyphData} (default constructor) Description ContourCount is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); given FSTYPE_RESTRICTED; then GlyphData (default constructor) Description ContourCount is two")
  void testInitData_givenFstype_restricted_thenGlyphDataDescriptionContourCountIsTwo() throws IOException {
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
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <ul>
   *   <li>Given {@link Short#MIN_VALUE}.</li>
   *   <li>Then {@link GlyphData} (default constructor) Description
   * {@link GlyfCompositeDescript}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); given MIN_VALUE; then GlyphData (default constructor) Description GlyfCompositeDescript")
  void testInitData_givenMin_value_thenGlyphDataDescriptionGlyfCompositeDescript() throws IOException {
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
    List<GlyfCompositeComp> components = ((GlyfCompositeDescript) description).getComponents();
    assertEquals(1, components.size());
    GlyfCompositeComp getResult = components.get(0);
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(1, getResult.getGlyphIndex());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertEquals(1.0d, getResult.getXScale());
    assertEquals(1.0d, getResult.getYScale());
    assertEquals((short) 1, getResult.getArgument1());
    assertEquals((short) 1, getResult.getArgument2());
    assertTrue(description.isComposite());
    assertEquals(Short.MIN_VALUE, getResult.getFlags());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then {@link GlyphData} (default constructor) BoundingBox LowerLeftX is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); given zero; then GlyphData (default constructor) BoundingBox LowerLeftX is zero")
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
   * <ul>
   *   <li>Then {@link GlyphData} (default constructor) Path Bounds Bounds Bounds
   * Bounds Bounds Bounds MaxX is minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); then GlyphData (default constructor) Path Bounds Bounds Bounds Bounds Bounds Bounds MaxX is minus two")
  void testInitData_thenGlyphDataPathBoundsBoundsBoundsBoundsBoundsBoundsMaxXIsMinusTwo() throws IOException {
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D = bounds6.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds5.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds3.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    Rectangle bounds7 = bounds2D5.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D6 = bounds9.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = path.getBounds2D();
    Rectangle bounds10 = bounds2D7.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D8 = bounds12.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds13 = frame.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D bounds2D10 = bounds2.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle bounds16 = bounds2D10.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D11 = bounds17.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds8.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds18 = frame2.getBounds();
    Rectangle bounds19 = bounds18.getBounds();
    Rectangle2D bounds2D14 = bounds19.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle bounds20 = bounds2D4.getBounds();
    Rectangle2D bounds2D16 = bounds20.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = bounds16.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds7.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds10.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D bounds2D20 = bounds2D5.getBounds2D();
    Rectangle bounds21 = bounds2D20.getBounds();
    Rectangle2D bounds2D21 = bounds21.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D bounds2D22 = bounds2D7.getBounds2D();
    Rectangle bounds22 = bounds2D22.getBounds();
    Rectangle2D bounds2D23 = bounds22.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D bounds2D24 = frame.getBounds2D();
    Rectangle bounds23 = bounds2D24.getBounds();
    Rectangle2D bounds2D25 = bounds23.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D frame3 = bounds3.getFrame();
    Rectangle bounds24 = frame3.getBounds();
    Rectangle2D bounds2D26 = bounds24.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds18.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D frame4 = bounds2D5.getFrame();
    Rectangle bounds25 = frame4.getBounds();
    Rectangle2D bounds2D28 = bounds25.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds13.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D frame5 = bounds2D7.getFrame();
    Rectangle bounds26 = frame5.getBounds();
    Rectangle2D bounds2D30 = bounds26.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D3.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = bounds2D4.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle);
    Rectangle2D bounds2D33 = bounds2D10.getBounds2D();
    assertTrue(bounds2D33 instanceof Rectangle);
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D34 = bounds2D18.getBounds2D();
    assertTrue(bounds2D34 instanceof Rectangle);
    Rectangle2D bounds2D35 = bounds2D19.getBounds2D();
    assertTrue(bounds2D35 instanceof Rectangle);
    Rectangle2D bounds2D36 = bounds2D29.getBounds2D();
    assertTrue(bounds2D36 instanceof Rectangle);
    Rectangle2D bounds2D37 = bounds2D33.getBounds2D();
    assertTrue(bounds2D37 instanceof Rectangle);
    Rectangle2D bounds2D38 = bounds2D20.getBounds2D();
    assertTrue(bounds2D38 instanceof Rectangle);
    Point2D currentPoint = path.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D bounds2D39 = frame2.getBounds2D();
    assertTrue(bounds2D39 instanceof Rectangle2D.Double);
    assertTrue(bounds2D24 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds4.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds2D10.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds7.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = bounds10.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    Rectangle2D frame10 = bounds13.getFrame();
    assertTrue(frame10 instanceof Rectangle2D.Double);
    Rectangle2D frame11 = frame2.getFrame();
    assertTrue(frame11 instanceof Rectangle2D.Double);
    Rectangle2D frame12 = frame.getFrame();
    assertTrue(frame12 instanceof Rectangle2D.Double);
    assertTrue(bounds2D7 instanceof Rectangle2D.Float);
    assertTrue(bounds2D22 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D40 = bounds2D22.getBounds2D();
    assertTrue(bounds2D40 instanceof Rectangle2D.Float);
    assertEquals(-2.0d, bounds6.getMaxX());
    assertEquals(-2.0d, bounds5.getMaxX());
    assertEquals(-2.0d, bounds4.getMaxX());
    assertEquals(-2.0d, bounds3.getMaxX());
    assertEquals(-2.0d, bounds9.getMaxX());
    assertEquals(-2.0d, bounds12.getMaxX());
    assertEquals(-2.0d, bounds15.getMaxX());
    assertEquals(-2.0d, bounds2.getMaxX());
    assertEquals(-2.0d, bounds17.getMaxX());
    assertEquals(-2.0d, bounds8.getMaxX());
    assertEquals(-2.0d, bounds11.getMaxX());
    assertEquals(-2.0d, bounds19.getMaxX());
    assertEquals(-2.0d, bounds14.getMaxX());
    assertEquals(-2.0d, bounds2D3.getMaxX());
    assertEquals(-2.0d, bounds2D4.getMaxX());
    assertEquals(-2.0d, bounds2D10.getMaxX());
    assertEquals(-2.0d, bounds2D5.getMaxX());
    assertEquals(-2.0d, bounds2D18.getMaxX());
    assertEquals(-2.0d, bounds2D19.getMaxX());
    assertEquals(-2.0d, bounds2D29.getMaxX());
    assertEquals(-2.0d, bounds.getMaxX());
    assertEquals(-2.0d, bounds2D7.getMaxX());
    assertEquals(-2.0d, bounds2D33.getMaxX());
    assertEquals(-2.0d, bounds2D20.getMaxX());
    assertEquals(-2.0d, bounds2D22.getMaxX());
    assertEquals(-2.0d, bounds2D39.getMaxX());
    assertEquals(-2.0d, bounds2D24.getMaxX());
    assertEquals(-2.0d, bounds20.getMaxX());
    assertEquals(-2.0d, bounds16.getMaxX());
    assertEquals(-2.0d, bounds7.getMaxX());
    assertEquals(-2.0d, bounds10.getMaxX());
    assertEquals(-2.0d, bounds21.getMaxX());
    assertEquals(-2.0d, bounds22.getMaxX());
    assertEquals(-2.0d, bounds23.getMaxX());
    assertEquals(-2.0d, bounds24.getMaxX());
    assertEquals(-2.0d, bounds18.getMaxX());
    assertEquals(-2.0d, bounds25.getMaxX());
    assertEquals(-2.0d, bounds13.getMaxX());
    assertEquals(-2.0d, bounds26.getMaxX());
    assertEquals(-2.0d, frame6.getMaxX());
    assertEquals(-2.0d, frame3.getMaxX());
    assertEquals(-2.0d, frame2.getMaxX());
    assertEquals(-2.0d, frame7.getMaxX());
    assertEquals(-2.0d, frame4.getMaxX());
    assertEquals(-2.0d, frame.getMaxX());
    assertEquals(-2.0d, frame5.getMaxX());
    assertEquals(-2.0d, frame8.getMaxX());
    assertEquals(-2.0d, frame9.getMaxX());
    assertEquals(-2.0d, frame10.getMaxX());
    assertEquals(-2.0d, frame11.getMaxX());
    assertEquals(-2.0d, frame12.getMaxX());
    assertEquals(-3.0d, currentPoint.getX());
    assertEquals(-3.0d, bounds6.getCenterX());
    assertEquals(-3.0d, bounds5.getCenterX());
    assertEquals(-3.0d, bounds4.getCenterX());
    assertEquals(-3.0d, bounds3.getCenterX());
    assertEquals(-3.0d, bounds9.getCenterX());
    assertEquals(-3.0d, bounds12.getCenterX());
    assertEquals(-3.0d, bounds15.getCenterX());
    assertEquals(-3.0d, bounds2.getCenterX());
    assertEquals(-3.0d, bounds17.getCenterX());
    assertEquals(-3.0d, bounds8.getCenterX());
    assertEquals(-3.0d, bounds11.getCenterX());
    assertEquals(-3.0d, bounds19.getCenterX());
    assertEquals(-3.0d, bounds14.getCenterX());
    assertEquals(-3.0d, bounds2D3.getCenterX());
    assertEquals(-3.0d, bounds2D4.getCenterX());
    assertEquals(-3.0d, bounds2D10.getCenterX());
    assertEquals(-3.0d, bounds2D5.getCenterX());
    assertEquals(-3.0d, bounds2D18.getCenterX());
    assertEquals(-3.0d, bounds2D19.getCenterX());
    assertEquals(-3.0d, bounds2D29.getCenterX());
    assertEquals(-3.0d, bounds.getCenterX());
    assertEquals(-3.0d, bounds2D7.getCenterX());
    assertEquals(-3.0d, bounds2D33.getCenterX());
    assertEquals(-3.0d, bounds2D20.getCenterX());
    assertEquals(-3.0d, bounds2D22.getCenterX());
    assertEquals(-3.0d, bounds2D39.getCenterX());
    assertEquals(-3.0d, bounds2D24.getCenterX());
    assertEquals(-3.0d, bounds20.getCenterX());
    assertEquals(-3.0d, bounds16.getCenterX());
    assertEquals(-3.0d, bounds7.getCenterX());
    assertEquals(-3.0d, bounds10.getCenterX());
    assertEquals(-3.0d, bounds21.getCenterX());
    assertEquals(-3.0d, bounds22.getCenterX());
    assertEquals(-3.0d, bounds23.getCenterX());
    assertEquals(-3.0d, bounds24.getCenterX());
    assertEquals(-3.0d, bounds18.getCenterX());
    assertEquals(-3.0d, bounds25.getCenterX());
    assertEquals(-3.0d, bounds13.getCenterX());
    assertEquals(-3.0d, bounds26.getCenterX());
    assertEquals(-3.0d, frame6.getCenterX());
    assertEquals(-3.0d, frame3.getCenterX());
    assertEquals(-3.0d, frame2.getCenterX());
    assertEquals(-3.0d, frame7.getCenterX());
    assertEquals(-3.0d, frame4.getCenterX());
    assertEquals(-3.0d, frame.getCenterX());
    assertEquals(-3.0d, frame5.getCenterX());
    assertEquals(-3.0d, frame8.getCenterX());
    assertEquals(-3.0d, frame9.getCenterX());
    assertEquals(-3.0d, frame10.getCenterX());
    assertEquals(-3.0d, frame11.getCenterX());
    assertEquals(-3.0d, frame12.getCenterX());
    assertEquals(-3.0f, ((Point2D.Float) currentPoint).x);
    Point location = bounds.getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(-4, location4.getLocation().x);
    Point location5 = bounds3.getLocation();
    Point location6 = location5.getLocation();
    Point location7 = location6.getLocation();
    assertEquals(-4, location7.getLocation().x);
    assertEquals(-4, location4.x);
    Point location8 = ((Rectangle) bounds2D5).getLocation();
    Point location9 = location8.getLocation();
    Point location10 = location9.getLocation();
    assertEquals(-4, location10.getLocation().x);
    Point location11 = bounds4.getLocation();
    Point location12 = location11.getLocation();
    assertEquals(-4, location12.getLocation().x);
    assertEquals(-4, location7.x);
    assertEquals(-4, location3.x);
    Point location13 = bounds7.getLocation();
    Point location14 = location13.getLocation();
    assertEquals(-4, location14.getLocation().x);
    Point location15 = bounds10.getLocation();
    Point location16 = location15.getLocation();
    assertEquals(-4, location16.getLocation().x);
    Point location17 = bounds13.getLocation();
    Point location18 = location17.getLocation();
    assertEquals(-4, location18.getLocation().x);
    Point location19 = ((Rectangle) bounds2D10).getLocation();
    Point location20 = location19.getLocation();
    assertEquals(-4, location20.getLocation().x);
    assertEquals(-4, location10.x);
    Point location21 = bounds5.getLocation();
    assertEquals(-4, location21.getLocation().x);
    assertEquals(-4, location12.x);
    assertEquals(-4, location6.x);
    Point location22 = bounds8.getLocation();
    assertEquals(-4, location22.getLocation().x);
    Point location23 = bounds11.getLocation();
    assertEquals(-4, location23.getLocation().x);
    Point location24 = bounds14.getLocation();
    assertEquals(-4, location24.getLocation().x);
    assertEquals(-4, location2.x);
    Point location25 = bounds16.getLocation();
    assertEquals(-4, location25.getLocation().x);
    assertEquals(-4, location14.x);
    assertEquals(-4, location16.x);
    Point location26 = bounds18.getLocation();
    assertEquals(-4, location26.getLocation().x);
    assertEquals(-4, location18.x);
    Point location27 = ((Rectangle) bounds2D4).getLocation();
    assertEquals(-4, location27.getLocation().x);
    assertEquals(-4, location20.x);
    assertEquals(-4, location9.x);
    Point location28 = ((Rectangle) bounds2D20).getLocation();
    assertEquals(-4, location28.getLocation().x);
    assertEquals(-4, bounds6.getLocation().x);
    assertEquals(-4, location21.x);
    assertEquals(-4, location11.x);
    assertEquals(-4, location5.x);
    assertEquals(-4, bounds9.getLocation().x);
    assertEquals(-4, bounds12.getLocation().x);
    assertEquals(-4, bounds15.getLocation().x);
    assertEquals(-4, bounds17.getLocation().x);
    assertEquals(-4, location22.x);
    assertEquals(-4, location23.x);
    assertEquals(-4, bounds19.getLocation().x);
    assertEquals(-4, location24.x);
    assertEquals(-4, location.x);
    assertEquals(-4, bounds20.getLocation().x);
    assertEquals(-4, location25.x);
    assertEquals(-4, location13.x);
    assertEquals(-4, location15.x);
    assertEquals(-4, bounds21.getLocation().x);
    assertEquals(-4, bounds22.getLocation().x);
    assertEquals(-4, bounds23.getLocation().x);
    assertEquals(-4, bounds24.getLocation().x);
    assertEquals(-4, location26.x);
    assertEquals(-4, bounds25.getLocation().x);
    assertEquals(-4, location17.x);
    assertEquals(-4, bounds26.getLocation().x);
    assertEquals(-4, ((Rectangle) bounds2D3).getLocation().x);
    assertEquals(-4, location27.x);
    assertEquals(-4, location19.x);
    assertEquals(-4, location8.x);
    assertEquals(-4, ((Rectangle) bounds2D18).getLocation().x);
    assertEquals(-4, ((Rectangle) bounds2D19).getLocation().x);
    assertEquals(-4, ((Rectangle) bounds2D29).getLocation().x);
    assertEquals(-4, ((Rectangle) bounds2D33).getLocation().x);
    assertEquals(-4, location28.x);
    Rectangle bounds27 = bounds6.getBounds();
    assertEquals(-4, bounds27.x);
    assertEquals(-4, bounds6.x);
    assertEquals(-4, bounds5.x);
    assertEquals(-4, bounds4.x);
    Rectangle bounds28 = bounds9.getBounds();
    assertEquals(-4, bounds28.x);
    Rectangle bounds29 = bounds12.getBounds();
    assertEquals(-4, bounds29.x);
    Rectangle bounds30 = bounds15.getBounds();
    assertEquals(-4, bounds30.x);
    assertEquals(-4, bounds3.x);
    Rectangle bounds31 = bounds17.getBounds();
    assertEquals(-4, bounds31.x);
    assertEquals(-4, bounds9.x);
    assertEquals(-4, bounds12.x);
    Rectangle bounds32 = bounds19.getBounds();
    assertEquals(-4, bounds32.x);
    assertEquals(-4, bounds15.x);
    assertEquals(-4, bounds2.x);
    Rectangle bounds33 = bounds20.getBounds();
    assertEquals(-4, bounds33.x);
    assertEquals(-4, bounds17.x);
    assertEquals(-4, bounds8.x);
    assertEquals(-4, bounds11.x);
    Rectangle bounds34 = bounds21.getBounds();
    assertEquals(-4, bounds34.x);
    Rectangle bounds35 = bounds22.getBounds();
    assertEquals(-4, bounds35.x);
    Rectangle bounds36 = bounds23.getBounds();
    assertEquals(-4, bounds36.x);
    Rectangle bounds37 = bounds24.getBounds();
    assertEquals(-4, bounds37.x);
    assertEquals(-4, bounds19.x);
    Rectangle bounds38 = bounds25.getBounds();
    assertEquals(-4, bounds38.x);
    assertEquals(-4, bounds14.x);
    Rectangle bounds39 = bounds26.getBounds();
    assertEquals(-4, bounds39.x);
    assertEquals(-4, bounds.x);
    Rectangle bounds40 = bounds2D3.getBounds();
    assertEquals(-4, bounds40.x);
    assertEquals(-4, bounds20.x);
    assertEquals(-4, bounds16.x);
    assertEquals(-4, bounds7.x);
    Rectangle bounds41 = bounds2D18.getBounds();
    assertEquals(-4, bounds41.x);
    Rectangle bounds42 = bounds2D19.getBounds();
    assertEquals(-4, bounds42.x);
    Rectangle bounds43 = bounds2D29.getBounds();
    assertEquals(-4, bounds43.x);
    assertEquals(-4, bounds10.x);
    Rectangle bounds44 = bounds2D33.getBounds();
    assertEquals(-4, bounds44.x);
    assertEquals(-4, bounds21.x);
    assertEquals(-4, bounds22.x);
    Rectangle bounds45 = bounds2D39.getBounds();
    assertEquals(-4, bounds45.x);
    assertEquals(-4, bounds23.x);
    Rectangle bounds46 = frame6.getBounds();
    assertEquals(-4, bounds46.x);
    assertEquals(-4, bounds24.x);
    assertEquals(-4, bounds18.x);
    Rectangle bounds47 = frame7.getBounds();
    assertEquals(-4, bounds47.x);
    assertEquals(-4, bounds25.x);
    assertEquals(-4, bounds13.x);
    assertEquals(-4, bounds26.x);
    Rectangle bounds48 = frame8.getBounds();
    assertEquals(-4, bounds48.x);
    Rectangle bounds49 = frame9.getBounds();
    assertEquals(-4, bounds49.x);
    Rectangle bounds50 = frame10.getBounds();
    assertEquals(-4, bounds50.x);
    Rectangle bounds51 = frame11.getBounds();
    assertEquals(-4, bounds51.x);
    Rectangle bounds52 = frame12.getBounds();
    assertEquals(-4, bounds52.x);
    assertEquals(-4, ((Rectangle) bounds2D).x);
    assertEquals(-4, ((Rectangle) bounds2D2).x);
    assertEquals(-4, ((Rectangle) bounds2D3).x);
    assertEquals(-4, ((Rectangle) bounds2D4).x);
    assertEquals(-4, ((Rectangle) bounds2D6).x);
    assertEquals(-4, ((Rectangle) bounds2D8).x);
    assertEquals(-4, ((Rectangle) bounds2D9).x);
    assertEquals(-4, ((Rectangle) bounds2D10).x);
    assertEquals(-4, ((Rectangle) bounds2D11).x);
    assertEquals(-4, ((Rectangle) bounds2D12).x);
    assertEquals(-4, ((Rectangle) bounds2D13).x);
    assertEquals(-4, ((Rectangle) bounds2D14).x);
    assertEquals(-4, ((Rectangle) bounds2D15).x);
    assertEquals(-4, ((Rectangle) bounds2D5).x);
    assertEquals(-4, ((Rectangle) bounds2D16).x);
    assertEquals(-4, ((Rectangle) bounds2D17).x);
    assertEquals(-4, ((Rectangle) bounds2D18).x);
    assertEquals(-4, ((Rectangle) bounds2D19).x);
    assertEquals(-4, ((Rectangle) bounds2D21).x);
    assertEquals(-4, ((Rectangle) bounds2D23).x);
    assertEquals(-4, ((Rectangle) bounds2D25).x);
    assertEquals(-4, ((Rectangle) bounds2D26).x);
    assertEquals(-4, ((Rectangle) bounds2D27).x);
    assertEquals(-4, ((Rectangle) bounds2D28).x);
    assertEquals(-4, ((Rectangle) bounds2D29).x);
    assertEquals(-4, ((Rectangle) bounds2D30).x);
    assertEquals(-4, ((Rectangle) bounds2D31).x);
    assertEquals(-4, ((Rectangle) bounds2D32).x);
    assertEquals(-4, ((Rectangle) bounds2D33).x);
    assertEquals(-4, ((Rectangle) bounds2D20).x);
    assertEquals(-4, ((Rectangle) bounds2D34).x);
    assertEquals(-4, ((Rectangle) bounds2D35).x);
    assertEquals(-4, ((Rectangle) bounds2D36).x);
    assertEquals(-4, ((Rectangle) bounds2D37).x);
    assertEquals(-4, ((Rectangle) bounds2D38).x);
    assertEquals(-4.0d, location4.getX());
    assertEquals(-4.0d, location7.getX());
    assertEquals(-4.0d, location3.getX());
    assertEquals(-4.0d, location10.getX());
    assertEquals(-4.0d, location12.getX());
    assertEquals(-4.0d, location6.getX());
    assertEquals(-4.0d, location2.getX());
    assertEquals(-4.0d, location14.getX());
    assertEquals(-4.0d, location16.getX());
    assertEquals(-4.0d, location18.getX());
    assertEquals(-4.0d, location20.getX());
    assertEquals(-4.0d, location9.getX());
    assertEquals(-4.0d, location21.getX());
    assertEquals(-4.0d, location11.getX());
    assertEquals(-4.0d, location5.getX());
    assertEquals(-4.0d, location22.getX());
    assertEquals(-4.0d, location23.getX());
    assertEquals(-4.0d, location24.getX());
    assertEquals(-4.0d, location.getX());
    assertEquals(-4.0d, location25.getX());
    assertEquals(-4.0d, location13.getX());
    assertEquals(-4.0d, location15.getX());
    assertEquals(-4.0d, location26.getX());
    assertEquals(-4.0d, location17.getX());
    assertEquals(-4.0d, location27.getX());
    assertEquals(-4.0d, location19.getX());
    assertEquals(-4.0d, location8.getX());
    assertEquals(-4.0d, location28.getX());
    assertEquals(-4.0d, bounds6.getX());
    assertEquals(-4.0d, bounds5.getX());
    assertEquals(-4.0d, bounds4.getX());
    assertEquals(-4.0d, bounds3.getX());
    assertEquals(-4.0d, bounds9.getX());
    assertEquals(-4.0d, bounds12.getX());
    assertEquals(-4.0d, bounds15.getX());
    assertEquals(-4.0d, bounds2.getX());
    assertEquals(-4.0d, bounds17.getX());
    assertEquals(-4.0d, bounds8.getX());
    assertEquals(-4.0d, bounds11.getX());
    assertEquals(-4.0d, bounds19.getX());
    assertEquals(-4.0d, bounds14.getX());
    assertEquals(-4.0d, bounds.getX());
    assertEquals(-4.0d, bounds20.getX());
    assertEquals(-4.0d, bounds16.getX());
    assertEquals(-4.0d, bounds7.getX());
    assertEquals(-4.0d, bounds10.getX());
    assertEquals(-4.0d, bounds21.getX());
    assertEquals(-4.0d, bounds22.getX());
    assertEquals(-4.0d, bounds24.getX());
    assertEquals(-4.0d, bounds18.getX());
    assertEquals(-4.0d, bounds25.getX());
    assertEquals(-4.0d, bounds13.getX());
    assertEquals(-4.0d, bounds26.getX());
    assertEquals(-4.0d, bounds6.getMinX());
    assertEquals(-4.0d, bounds5.getMinX());
    assertEquals(-4.0d, bounds4.getMinX());
    assertEquals(-4.0d, bounds3.getMinX());
    assertEquals(-4.0d, bounds9.getMinX());
    assertEquals(-4.0d, bounds12.getMinX());
    assertEquals(-4.0d, bounds15.getMinX());
    assertEquals(-4.0d, bounds2.getMinX());
    assertEquals(-4.0d, bounds17.getMinX());
    assertEquals(-4.0d, bounds8.getMinX());
    assertEquals(-4.0d, bounds11.getMinX());
    assertEquals(-4.0d, bounds19.getMinX());
    assertEquals(-4.0d, bounds14.getMinX());
    assertEquals(-4.0d, bounds2D3.getMinX());
    assertEquals(-4.0d, bounds2D4.getMinX());
    assertEquals(-4.0d, bounds2D10.getMinX());
    assertEquals(-4.0d, bounds2D5.getMinX());
    assertEquals(-4.0d, bounds2D18.getMinX());
    assertEquals(-4.0d, bounds2D19.getMinX());
    assertEquals(-4.0d, bounds2D29.getMinX());
    assertEquals(-4.0d, bounds.getMinX());
    assertEquals(-4.0d, bounds2D7.getMinX());
    assertEquals(-4.0d, bounds2D33.getMinX());
    assertEquals(-4.0d, bounds2D20.getMinX());
    assertEquals(-4.0d, bounds2D22.getMinX());
    assertEquals(-4.0d, bounds2D39.getMinX());
    assertEquals(-4.0d, bounds2D24.getMinX());
    assertEquals(-4.0d, bounds20.getMinX());
    assertEquals(-4.0d, bounds16.getMinX());
    assertEquals(-4.0d, bounds7.getMinX());
    assertEquals(-4.0d, bounds10.getMinX());
    assertEquals(-4.0d, bounds21.getMinX());
    assertEquals(-4.0d, bounds22.getMinX());
    assertEquals(-4.0d, bounds23.getMinX());
    assertEquals(-4.0d, bounds24.getMinX());
    assertEquals(-4.0d, bounds18.getMinX());
    assertEquals(-4.0d, bounds25.getMinX());
    assertEquals(-4.0d, bounds13.getMinX());
    assertEquals(-4.0d, bounds26.getMinX());
    assertEquals(-4.0d, frame6.getMinX());
    assertEquals(-4.0d, frame3.getMinX());
    assertEquals(-4.0d, frame2.getMinX());
    assertEquals(-4.0d, frame7.getMinX());
    assertEquals(-4.0d, frame4.getMinX());
    assertEquals(-4.0d, frame.getMinX());
    assertEquals(-4.0d, frame5.getMinX());
    assertEquals(-4.0d, frame8.getMinX());
    assertEquals(-4.0d, frame9.getMinX());
    assertEquals(-4.0d, frame10.getMinX());
    assertEquals(-4.0d, frame11.getMinX());
    assertEquals(-4.0d, frame12.getMinX());
    assertEquals(-4.0d, bounds2D3.getX());
    assertEquals(-4.0d, bounds2D4.getX());
    assertEquals(-4.0d, bounds2D10.getX());
    assertEquals(-4.0d, bounds2D5.getX());
    assertEquals(-4.0d, bounds2D18.getX());
    assertEquals(-4.0d, bounds2D19.getX());
    assertEquals(-4.0d, bounds2D29.getX());
    assertEquals(-4.0d, bounds2D7.getX());
    assertEquals(-4.0d, bounds2D33.getX());
    assertEquals(-4.0d, bounds2D20.getX());
    assertEquals(-4.0d, bounds2D22.getX());
    assertEquals(-4.0d, bounds2D39.getX());
    assertEquals(-4.0d, bounds2D24.getX());
    assertEquals(-4.0d, frame6.getX());
    assertEquals(-4.0d, frame3.getX());
    assertEquals(-4.0d, frame2.getX());
    assertEquals(-4.0d, frame7.getX());
    assertEquals(-4.0d, frame4.getX());
    assertEquals(-4.0d, frame.getX());
    assertEquals(-4.0d, frame5.getX());
    assertEquals(-4.0d, frame8.getX());
    assertEquals(-4.0d, frame9.getX());
    assertEquals(-4.0d, frame10.getX());
    assertEquals(-4.0d, frame11.getX());
    assertEquals(-4.0d, frame12.getX());
    assertEquals(-4.0f, ((Rectangle2D.Float) bounds2D7).x);
    assertEquals(-4.0f, ((Rectangle2D.Float) bounds2D22).x);
    assertEquals(-4.0f, ((Rectangle2D.Float) bounds2D40).x);
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(2, size4.getSize().width);
    Dimension size5 = bounds3.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(2, size7.getSize().width);
    assertEquals(2, size4.width);
    Dimension size8 = ((Rectangle) bounds2D5).getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(2, size10.getSize().width);
    Dimension size11 = bounds4.getSize();
    Dimension size12 = size11.getSize();
    assertEquals(2, size12.getSize().width);
    assertEquals(2, size7.width);
    assertEquals(2, size3.width);
    Dimension size13 = bounds7.getSize();
    Dimension size14 = size13.getSize();
    assertEquals(2, size14.getSize().width);
    Dimension size15 = bounds10.getSize();
    Dimension size16 = size15.getSize();
    assertEquals(2, size16.getSize().width);
    Dimension size17 = bounds13.getSize();
    Dimension size18 = size17.getSize();
    assertEquals(2, size18.getSize().width);
    Dimension size19 = ((Rectangle) bounds2D10).getSize();
    Dimension size20 = size19.getSize();
    assertEquals(2, size20.getSize().width);
    assertEquals(2, size10.width);
    Dimension size21 = bounds5.getSize();
    assertEquals(2, size21.getSize().width);
    assertEquals(2, size12.width);
    assertEquals(2, size6.width);
    Dimension size22 = bounds8.getSize();
    assertEquals(2, size22.getSize().width);
    Dimension size23 = bounds11.getSize();
    assertEquals(2, size23.getSize().width);
    Dimension size24 = bounds14.getSize();
    assertEquals(2, size24.getSize().width);
    assertEquals(2, size2.width);
    Dimension size25 = bounds16.getSize();
    assertEquals(2, size25.getSize().width);
    assertEquals(2, size14.width);
    assertEquals(2, size16.width);
    Dimension size26 = bounds18.getSize();
    assertEquals(2, size26.getSize().width);
    assertEquals(2, size18.width);
    Dimension size27 = ((Rectangle) bounds2D4).getSize();
    assertEquals(2, size27.getSize().width);
    assertEquals(2, size20.width);
    assertEquals(2, size9.width);
    Dimension size28 = ((Rectangle) bounds2D20).getSize();
    assertEquals(2, size28.getSize().width);
    assertEquals(2, bounds6.getSize().width);
    assertEquals(2, size21.width);
    assertEquals(2, size11.width);
    assertEquals(2, size5.width);
    assertEquals(2, bounds9.getSize().width);
    assertEquals(2, bounds12.getSize().width);
    assertEquals(2, bounds15.getSize().width);
    assertEquals(2, bounds17.getSize().width);
    assertEquals(2, size22.width);
    assertEquals(2, size23.width);
    assertEquals(2, bounds19.getSize().width);
    assertEquals(2, size24.width);
    assertEquals(2, size.width);
    assertEquals(2, bounds20.getSize().width);
    assertEquals(2, size25.width);
    assertEquals(2, size13.width);
    assertEquals(2, size15.width);
    assertEquals(2, bounds21.getSize().width);
    assertEquals(2, bounds22.getSize().width);
    assertEquals(2, bounds24.getSize().width);
    assertEquals(2, size26.width);
    assertEquals(2, bounds25.getSize().width);
    assertEquals(2, size17.width);
    assertEquals(2, bounds26.getSize().width);
    assertEquals(2, ((Rectangle) bounds2D3).getSize().width);
    assertEquals(2, size27.width);
    assertEquals(2, size19.width);
    assertEquals(2, size8.width);
    assertEquals(2, ((Rectangle) bounds2D18).getSize().width);
    assertEquals(2, ((Rectangle) bounds2D19).getSize().width);
    assertEquals(2, ((Rectangle) bounds2D29).getSize().width);
    assertEquals(2, ((Rectangle) bounds2D33).getSize().width);
    assertEquals(2, size28.width);
    assertEquals(2, bounds27.width);
    assertEquals(2, bounds6.width);
    assertEquals(2, bounds5.width);
    assertEquals(2, bounds4.width);
    assertEquals(2, bounds28.width);
    assertEquals(2, bounds29.width);
    assertEquals(2, bounds30.width);
    assertEquals(2, bounds3.width);
    assertEquals(2, bounds31.width);
    assertEquals(2, bounds9.width);
    assertEquals(2, bounds12.width);
    assertEquals(2, bounds32.width);
    assertEquals(2, bounds15.width);
    assertEquals(2, bounds2.width);
    assertEquals(2, bounds33.width);
    assertEquals(2, bounds17.width);
    assertEquals(2, bounds8.width);
    assertEquals(2, bounds11.width);
    assertEquals(2, bounds34.width);
    assertEquals(2, bounds35.width);
    assertEquals(2, bounds36.width);
    assertEquals(2, bounds37.width);
    assertEquals(2, bounds19.width);
    assertEquals(2, bounds38.width);
    assertEquals(2, bounds14.width);
    assertEquals(2, bounds39.width);
    assertEquals(2, bounds.width);
    assertEquals(2, bounds40.width);
    assertEquals(2, bounds20.width);
    assertEquals(2, bounds16.width);
    assertEquals(2, bounds7.width);
    assertEquals(2, bounds41.width);
    assertEquals(2, bounds42.width);
    assertEquals(2, bounds43.width);
    assertEquals(2, bounds10.width);
    assertEquals(2, bounds44.width);
    assertEquals(2, bounds21.width);
    assertEquals(2, bounds22.width);
    assertEquals(2, bounds45.width);
    assertEquals(2, bounds23.width);
    assertEquals(2, bounds46.width);
    assertEquals(2, bounds24.width);
    assertEquals(2, bounds18.width);
    assertEquals(2, bounds47.width);
    assertEquals(2, bounds25.width);
    assertEquals(2, bounds13.width);
    assertEquals(2, bounds26.width);
    assertEquals(2, bounds48.width);
    assertEquals(2, bounds49.width);
    assertEquals(2, bounds50.width);
    assertEquals(2, bounds51.width);
    assertEquals(2, bounds52.width);
    assertEquals(2, ((Rectangle) bounds2D).width);
    assertEquals(2, ((Rectangle) bounds2D2).width);
    assertEquals(2, ((Rectangle) bounds2D3).width);
    assertEquals(2, ((Rectangle) bounds2D4).width);
    assertEquals(2, ((Rectangle) bounds2D6).width);
    assertEquals(2, ((Rectangle) bounds2D8).width);
    assertEquals(2, ((Rectangle) bounds2D9).width);
    assertEquals(2, ((Rectangle) bounds2D10).width);
    assertEquals(2, ((Rectangle) bounds2D11).width);
    assertEquals(2, ((Rectangle) bounds2D12).width);
    assertEquals(2, ((Rectangle) bounds2D13).width);
    assertEquals(2, ((Rectangle) bounds2D14).width);
    assertEquals(2, ((Rectangle) bounds2D15).width);
    assertEquals(2, ((Rectangle) bounds2D5).width);
    assertEquals(2, ((Rectangle) bounds2D16).width);
    assertEquals(2, ((Rectangle) bounds2D17).width);
    assertEquals(2, ((Rectangle) bounds2D18).width);
    assertEquals(2, ((Rectangle) bounds2D19).width);
    assertEquals(2, ((Rectangle) bounds2D21).width);
    assertEquals(2, ((Rectangle) bounds2D23).width);
    assertEquals(2, ((Rectangle) bounds2D25).width);
    assertEquals(2, ((Rectangle) bounds2D26).width);
    assertEquals(2, ((Rectangle) bounds2D27).width);
    assertEquals(2, ((Rectangle) bounds2D28).width);
    assertEquals(2, ((Rectangle) bounds2D29).width);
    assertEquals(2, ((Rectangle) bounds2D30).width);
    assertEquals(2, ((Rectangle) bounds2D31).width);
    assertEquals(2, ((Rectangle) bounds2D32).width);
    assertEquals(2, ((Rectangle) bounds2D33).width);
    assertEquals(2, ((Rectangle) bounds2D20).width);
    assertEquals(2, ((Rectangle) bounds2D34).width);
    assertEquals(2, ((Rectangle) bounds2D35).width);
    assertEquals(2, ((Rectangle) bounds2D36).width);
    assertEquals(2, ((Rectangle) bounds2D37).width);
    assertEquals(2, ((Rectangle) bounds2D38).width);
    assertEquals(2.0d, size4.getWidth());
    assertEquals(2.0d, size7.getWidth());
    assertEquals(2.0d, size3.getWidth());
    assertEquals(2.0d, size10.getWidth());
    assertEquals(2.0d, size12.getWidth());
    assertEquals(2.0d, size6.getWidth());
    assertEquals(2.0d, size2.getWidth());
    assertEquals(2.0d, size14.getWidth());
    assertEquals(2.0d, size16.getWidth());
    assertEquals(2.0d, size18.getWidth());
    assertEquals(2.0d, size20.getWidth());
    assertEquals(2.0d, size9.getWidth());
    assertEquals(2.0d, size21.getWidth());
    assertEquals(2.0d, size11.getWidth());
    assertEquals(2.0d, size5.getWidth());
    assertEquals(2.0d, size22.getWidth());
    assertEquals(2.0d, size23.getWidth());
    assertEquals(2.0d, size24.getWidth());
    assertEquals(2.0d, size.getWidth());
    assertEquals(2.0d, size25.getWidth());
    assertEquals(2.0d, size13.getWidth());
    assertEquals(2.0d, size15.getWidth());
    assertEquals(2.0d, size26.getWidth());
    assertEquals(2.0d, size17.getWidth());
    assertEquals(2.0d, size27.getWidth());
    assertEquals(2.0d, size19.getWidth());
    assertEquals(2.0d, size8.getWidth());
    assertEquals(2.0d, size28.getWidth());
    assertEquals(2.0d, bounds6.getWidth());
    assertEquals(2.0d, bounds5.getWidth());
    assertEquals(2.0d, bounds4.getWidth());
    assertEquals(2.0d, bounds3.getWidth());
    assertEquals(2.0d, bounds9.getWidth());
    assertEquals(2.0d, bounds12.getWidth());
    assertEquals(2.0d, bounds15.getWidth());
    assertEquals(2.0d, bounds2.getWidth());
    assertEquals(2.0d, bounds17.getWidth());
    assertEquals(2.0d, bounds8.getWidth());
    assertEquals(2.0d, bounds11.getWidth());
    assertEquals(2.0d, bounds19.getWidth());
    assertEquals(2.0d, bounds14.getWidth());
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds20.getWidth());
    assertEquals(2.0d, bounds16.getWidth());
    assertEquals(2.0d, bounds7.getWidth());
    assertEquals(2.0d, bounds10.getWidth());
    assertEquals(2.0d, bounds21.getWidth());
    assertEquals(2.0d, bounds22.getWidth());
    assertEquals(2.0d, bounds24.getWidth());
    assertEquals(2.0d, bounds18.getWidth());
    assertEquals(2.0d, bounds25.getWidth());
    assertEquals(2.0d, bounds13.getWidth());
    assertEquals(2.0d, bounds26.getWidth());
    assertEquals(2.0d, bounds2D3.getWidth());
    assertEquals(2.0d, bounds2D4.getWidth());
    assertEquals(2.0d, bounds2D10.getWidth());
    assertEquals(2.0d, bounds2D5.getWidth());
    assertEquals(2.0d, bounds2D18.getWidth());
    assertEquals(2.0d, bounds2D19.getWidth());
    assertEquals(2.0d, bounds2D29.getWidth());
    assertEquals(2.0d, bounds2D7.getWidth());
    assertEquals(2.0d, bounds2D33.getWidth());
    assertEquals(2.0d, bounds2D20.getWidth());
    assertEquals(2.0d, bounds2D22.getWidth());
    assertEquals(2.0d, bounds2D39.getWidth());
    assertEquals(2.0d, bounds2D24.getWidth());
    assertEquals(2.0d, frame6.getWidth());
    assertEquals(2.0d, frame3.getWidth());
    assertEquals(2.0d, frame2.getWidth());
    assertEquals(2.0d, frame7.getWidth());
    assertEquals(2.0d, frame4.getWidth());
    assertEquals(2.0d, frame.getWidth());
    assertEquals(2.0d, frame5.getWidth());
    assertEquals(2.0d, frame8.getWidth());
    assertEquals(2.0d, frame9.getWidth());
    assertEquals(2.0d, frame10.getWidth());
    assertEquals(2.0d, frame11.getWidth());
    assertEquals(2.0d, frame12.getWidth());
    assertEquals(2.0f, ((Rectangle2D.Float) bounds2D7).width);
    assertEquals(2.0f, ((Rectangle2D.Float) bounds2D22).width);
    assertEquals(2.0f, ((Rectangle2D.Float) bounds2D40).width);
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <ul>
   *   <li>Then {@link GlyphData} (default constructor) Path Bounds Frame Bounds2D
   * Bounds Size {@link Dimension#height} is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); then GlyphData (default constructor) Path Bounds Frame Bounds2D Bounds Size height is zero")
  void testInitData_thenGlyphDataPathBoundsFrameBounds2DBoundsSizeHeightIsZero() throws IOException {
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
    Rectangle2D frame = glyphData.getPath().getBounds().getFrame();
    Rectangle2D bounds2D = frame.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertEquals(0, description.getPointCount());
    Rectangle bounds = bounds2D.getBounds();
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.getLocation().y);
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinY());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <ul>
   *   <li>When {@link GlyphTable} {@link GlyphTable#getGlyph(int, int)} return
   * {@link GlyphData} (default constructor).</li>
   *   <li>Then calls {@link GlyphTable#getGlyph(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); when GlyphTable getGlyph(int, int) return GlyphData (default constructor); then calls getGlyph(int, int)")
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
    verify(glyphTable).getGlyph(eq(1), eq(2));
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
    List<GlyfCompositeComp> components = ((GlyfCompositeDescript) description).getComponents();
    assertEquals(1, components.size());
    GlyfCompositeComp getResult = components.get(0);
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(1, getResult.getGlyphIndex());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertEquals(1.0d, getResult.getXScale());
    assertEquals(1.0d, getResult.getYScale());
    assertEquals((short) 1, getResult.getArgument1());
    assertEquals((short) 1, getResult.getArgument2());
    assertTrue(description.isComposite());
    assertEquals(Short.MIN_VALUE, getResult.getFlags());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   * <ul>
   *   <li>When {@link GlyphTable} {@link GlyphTable#getGlyph(int, int)} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then calls {@link GlyphTable#getGlyph(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName("Test initData(GlyphTable, TTFDataStream, int, int); when GlyphTable getGlyph(int, int) throw IOException(String) with 'foo'; then calls getGlyph(int, int)")
  void testInitData_whenGlyphTableGetGlyphThrowIOExceptionWithFoo_thenCallsGetGlyph() throws IOException {
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
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfCompositeDescript);
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
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(1, getResult.getGlyphIndex());
    assertEquals(1, ((GlyfCompositeDescript) description).getComponentCount());
    assertEquals(1.0d, getResult.getXScale());
    assertEquals(1.0d, getResult.getYScale());
    assertEquals((short) 1, getResult.getArgument1());
    assertEquals((short) 1, getResult.getArgument2());
    assertTrue(description.isComposite());
    assertEquals(Short.MIN_VALUE, getResult.getFlags());
    assertEquals(Short.MIN_VALUE, glyphData.getNumberOfContours());
    assertEquals(Short.MIN_VALUE, glyphData.getXMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getXMinimum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMaximum());
    assertEquals(Short.MIN_VALUE, glyphData.getYMinimum());
  }

  /**
   * Test {@link GlyphData#initEmptyData()}.
   * <p>
   * Method under test: {@link GlyphData#initEmptyData()}
   */
  @Test
  @DisplayName("Test initEmptyData()")
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

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
