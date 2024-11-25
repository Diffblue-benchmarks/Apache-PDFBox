package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LegacyPDFStreamEngineDiffblueTest {
  /**
   * Test new {@link LegacyPDFStreamEngine} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link LegacyPDFStreamEngine}
   */
  @Test
  @DisplayName("Test new LegacyPDFStreamEngine (default constructor)")
  void testNewLegacyPDFStreamEngine() {
    // Arrange and Act
    LegacyPDFStreamEngine actualLegacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Assert
    assertNull(actualLegacyPDFStreamEngine.getCurrentPage());
    assertNull(actualLegacyPDFStreamEngine.getResources());
    assertNull(actualLegacyPDFStreamEngine.getGraphicsState());
    assertNull(actualLegacyPDFStreamEngine.getInitialMatrix());
    assertEquals(0, actualLegacyPDFStreamEngine.getGraphicsStackSize());
    assertEquals(0, actualLegacyPDFStreamEngine.getLevel());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    legacyPDFStreamEngine.processPage(new PDPage());

    // Assert
    Rectangle bounds = legacyPDFStreamEngine.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D bounds2D = bounds2.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds3 = frame.getBounds();
    Rectangle2D bounds2D2 = bounds3.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds3.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds3.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0.0d, bounds2.getLocation().getLocation().getLocation().getX());
    Point location2 = ((Rectangle) bounds2D).getLocation();
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location2.getY());
    assertEquals(0.0d, bounds3.getX());
    Rectangle bounds4 = bounds2D.getBounds();
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds3.getY());
    assertEquals(0.0d, bounds3.getMinX());
    assertEquals(0.0d, bounds3.getMinY());
    assertEquals(306.0d, bounds3.getCenterX());
    assertEquals(396.0d, bounds3.getCenterY());
    Dimension size = bounds3.getSize();
    assertEquals(612, size.width);
    Dimension size2 = ((Rectangle) bounds2D).getSize();
    assertEquals(612.0d, size2.getWidth());
    assertEquals(612.0d, bounds3.getWidth());
    assertEquals(612.0d, bounds3.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, bounds3.getHeight());
    assertEquals(792.0d, bounds3.getMaxY());
    assertFalse(bounds4.isEmpty());
    assertFalse(bounds3.isEmpty());
    assertEquals(bounds, bounds3.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage2() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    PDPage page = new PDPage(new COSDictionary());

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    COSBase cOSObject = legacyPDFStreamEngine.getGraphicsState().getLineDashPattern().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(page, legacyPDFStreamEngine.getCurrentPage());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage3() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
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
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    Rectangle bounds7 = getResult.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D5 = bounds9.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = currentClippingPath.getBounds2D();
    Rectangle bounds10 = bounds2D6.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds8.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D bounds2D10 = bounds.getBounds2D();
    Rectangle bounds13 = bounds2D10.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle2D bounds2D11 = bounds14.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds11.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds15 = frame.getBounds();
    Rectangle bounds16 = bounds15.getBounds();
    Rectangle2D bounds2D13 = bounds16.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D14 = bounds7.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle bounds17 = bounds2D8.getBounds();
    Rectangle2D bounds2D15 = bounds17.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds13.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = getResult.getBounds2D();
    Rectangle bounds18 = bounds2D17.getBounds();
    Rectangle2D bounds2D18 = bounds18.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds10.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D bounds2D20 = bounds2D6.getBounds2D();
    Rectangle bounds19 = bounds2D20.getBounds();
    Rectangle2D bounds2D21 = bounds19.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds20 = frame2.getBounds();
    Rectangle2D bounds2D22 = bounds20.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D bounds2D23 = bounds15.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D frame3 = bounds2D6.getFrame();
    Rectangle bounds21 = frame3.getBounds();
    Rectangle2D bounds2D24 = bounds21.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D3.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D4.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D8.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D10.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D14.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D19.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    assertTrue(bounds2D17 instanceof Rectangle2D.Double);
    assertTrue(bounds2D6 instanceof Rectangle2D.Double);
    assertTrue(bounds2D20 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds3.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds2D10.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds10.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = frame.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Point location = bounds.getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(0, location4.getLocation().y);
    Point location5 = bounds2.getLocation();
    Point location6 = location5.getLocation();
    Point location7 = location6.getLocation();
    assertEquals(0, location7.getLocation().y);
    assertEquals(0, location4.y);
    Point location8 = bounds3.getLocation();
    Point location9 = location8.getLocation();
    assertEquals(0, location9.getLocation().y);
    assertEquals(0, location7.y);
    assertEquals(0, location3.y);
    Point location10 = bounds7.getLocation();
    Point location11 = location10.getLocation();
    assertEquals(0, location11.getLocation().y);
    Point location12 = bounds10.getLocation();
    Point location13 = location12.getLocation();
    assertEquals(0, location13.getLocation().y);
    Point location14 = ((Rectangle) bounds2D10).getLocation();
    Point location15 = location14.getLocation();
    assertEquals(0, location15.getLocation().y);
    Point location16 = bounds5.getLocation();
    assertEquals(0, location16.getLocation().y);
    Point location17 = bounds4.getLocation();
    assertEquals(0, location17.getLocation().y);
    assertEquals(0, location9.y);
    assertEquals(0, location6.y);
    Point location18 = bounds8.getLocation();
    assertEquals(0, location18.getLocation().y);
    Point location19 = bounds11.getLocation();
    assertEquals(0, location19.getLocation().y);
    assertEquals(0, location2.y);
    assertEquals(0, location11.y);
    Point location20 = bounds13.getLocation();
    assertEquals(0, location20.getLocation().y);
    assertEquals(0, location13.y);
    Point location21 = bounds15.getLocation();
    assertEquals(0, location21.getLocation().y);
    Point location22 = ((Rectangle) bounds2D8).getLocation();
    assertEquals(0, location22.getLocation().y);
    assertEquals(0, location15.y);
    assertEquals(0, bounds6.getLocation().y);
    assertEquals(0, location16.y);
    assertEquals(0, location17.y);
    assertEquals(0, location8.y);
    assertEquals(0, bounds9.getLocation().y);
    assertEquals(0, bounds12.getLocation().y);
    assertEquals(0, location5.y);
    assertEquals(0, location18.y);
    assertEquals(0, bounds14.getLocation().y);
    assertEquals(0, location19.y);
    assertEquals(0, bounds16.getLocation().y);
    assertEquals(0, location.y);
    assertEquals(0, location10.y);
    assertEquals(0, bounds17.getLocation().y);
    assertEquals(0, location20.y);
    assertEquals(0, bounds18.getLocation().y);
    assertEquals(0, location12.y);
    assertEquals(0, bounds19.getLocation().y);
    assertEquals(0, bounds20.getLocation().y);
    assertEquals(0, location21.y);
    assertEquals(0, bounds21.getLocation().y);
    assertEquals(0, ((Rectangle) bounds2D3).getLocation().y);
    assertEquals(0, ((Rectangle) bounds2D4).getLocation().y);
    assertEquals(0, location22.y);
    assertEquals(0, location14.y);
    assertEquals(0, ((Rectangle) bounds2D14).getLocation().y);
    assertEquals(0, ((Rectangle) bounds2D19).getLocation().y);
    assertEquals(0, ((Rectangle) bounds2D28).getLocation().y);
    Rectangle bounds22 = bounds6.getBounds();
    assertEquals(0, bounds22.y);
    assertEquals(0, bounds6.y);
    assertEquals(0, bounds5.y);
    assertEquals(0, bounds4.y);
    Rectangle bounds23 = bounds9.getBounds();
    assertEquals(0, bounds23.y);
    Rectangle bounds24 = bounds12.getBounds();
    assertEquals(0, bounds24.y);
    assertEquals(0, bounds3.y);
    assertEquals(0, bounds9.y);
    Rectangle bounds25 = bounds14.getBounds();
    assertEquals(0, bounds25.y);
    assertEquals(0, bounds12.y);
    Rectangle bounds26 = bounds16.getBounds();
    assertEquals(0, bounds26.y);
    assertEquals(0, bounds2.y);
    assertEquals(0, bounds8.y);
    Rectangle bounds27 = bounds17.getBounds();
    assertEquals(0, bounds27.y);
    assertEquals(0, bounds14.y);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(0, bounds28.y);
    assertEquals(0, bounds11.y);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(0, bounds29.y);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(0, bounds30.y);
    assertEquals(0, bounds16.y);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(0, bounds31.y);
    assertEquals(0, bounds.y);
    assertEquals(0, bounds7.y);
    Rectangle bounds32 = bounds2D3.getBounds();
    assertEquals(0, bounds32.y);
    Rectangle bounds33 = bounds2D4.getBounds();
    assertEquals(0, bounds33.y);
    assertEquals(0, bounds17.y);
    assertEquals(0, bounds13.y);
    Rectangle bounds34 = bounds2D14.getBounds();
    assertEquals(0, bounds34.y);
    Rectangle bounds35 = bounds2D19.getBounds();
    assertEquals(0, bounds35.y);
    assertEquals(0, bounds18.y);
    assertEquals(0, bounds10.y);
    Rectangle bounds36 = bounds2D28.getBounds();
    assertEquals(0, bounds36.y);
    assertEquals(0, bounds19.y);
    Rectangle bounds37 = bounds2D32.getBounds();
    assertEquals(0, bounds37.y);
    Rectangle bounds38 = frame4.getBounds();
    assertEquals(0, bounds38.y);
    assertEquals(0, bounds20.y);
    Rectangle bounds39 = frame5.getBounds();
    assertEquals(0, bounds39.y);
    assertEquals(0, bounds15.y);
    assertEquals(0, bounds21.y);
    Rectangle bounds40 = frame6.getBounds();
    assertEquals(0, bounds40.y);
    Rectangle bounds41 = frame7.getBounds();
    assertEquals(0, bounds41.y);
    Rectangle bounds42 = frame8.getBounds();
    assertEquals(0, bounds42.y);
    assertEquals(0, ((Rectangle) bounds2D).y);
    assertEquals(0, ((Rectangle) bounds2D2).y);
    assertEquals(0, ((Rectangle) bounds2D3).y);
    assertEquals(0, ((Rectangle) bounds2D4).y);
    assertEquals(0, ((Rectangle) bounds2D5).y);
    assertEquals(0, ((Rectangle) bounds2D7).y);
    assertEquals(0, ((Rectangle) bounds2D8).y);
    assertEquals(0, ((Rectangle) bounds2D9).y);
    assertEquals(0, ((Rectangle) bounds2D11).y);
    assertEquals(0, ((Rectangle) bounds2D12).y);
    assertEquals(0, ((Rectangle) bounds2D13).y);
    assertEquals(0, ((Rectangle) bounds2D10).y);
    assertEquals(0, ((Rectangle) bounds2D14).y);
    assertEquals(0, ((Rectangle) bounds2D15).y);
    assertEquals(0, ((Rectangle) bounds2D16).y);
    assertEquals(0, ((Rectangle) bounds2D18).y);
    assertEquals(0, ((Rectangle) bounds2D19).y);
    assertEquals(0, ((Rectangle) bounds2D21).y);
    assertEquals(0, ((Rectangle) bounds2D22).y);
    assertEquals(0, ((Rectangle) bounds2D23).y);
    assertEquals(0, ((Rectangle) bounds2D24).y);
    assertEquals(0, ((Rectangle) bounds2D25).y);
    assertEquals(0, ((Rectangle) bounds2D26).y);
    assertEquals(0, ((Rectangle) bounds2D27).y);
    assertEquals(0, ((Rectangle) bounds2D28).y);
    assertEquals(0, ((Rectangle) bounds2D29).y);
    assertEquals(0, ((Rectangle) bounds2D30).y);
    assertEquals(0, ((Rectangle) bounds2D31).y);
    assertEquals(0.0d, location4.getY());
    assertEquals(0.0d, location7.getY());
    assertEquals(0.0d, location3.getY());
    assertEquals(0.0d, location9.getY());
    assertEquals(0.0d, location6.getY());
    assertEquals(0.0d, location2.getY());
    assertEquals(0.0d, location11.getY());
    assertEquals(0.0d, location13.getY());
    assertEquals(0.0d, location15.getY());
    assertEquals(0.0d, location16.getY());
    assertEquals(0.0d, location17.getY());
    assertEquals(0.0d, location8.getY());
    assertEquals(0.0d, location5.getY());
    assertEquals(0.0d, location18.getY());
    assertEquals(0.0d, location19.getY());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, location10.getY());
    assertEquals(0.0d, location20.getY());
    assertEquals(0.0d, location12.getY());
    assertEquals(0.0d, location21.getY());
    assertEquals(0.0d, location22.getY());
    assertEquals(0.0d, location14.getY());
    assertEquals(0.0d, bounds6.getY());
    assertEquals(0.0d, bounds5.getY());
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds3.getY());
    assertEquals(0.0d, bounds9.getY());
    assertEquals(0.0d, bounds12.getY());
    assertEquals(0.0d, bounds2.getY());
    assertEquals(0.0d, bounds8.getY());
    assertEquals(0.0d, bounds14.getY());
    assertEquals(0.0d, bounds11.getY());
    assertEquals(0.0d, bounds16.getY());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds7.getY());
    assertEquals(0.0d, bounds17.getY());
    assertEquals(0.0d, bounds13.getY());
    assertEquals(0.0d, bounds18.getY());
    assertEquals(0.0d, bounds10.getY());
    assertEquals(0.0d, bounds19.getY());
    assertEquals(0.0d, bounds20.getY());
    assertEquals(0.0d, bounds15.getY());
    assertEquals(0.0d, bounds21.getY());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0d, bounds6.getMinY());
    assertEquals(0.0d, bounds5.getMinY());
    assertEquals(0.0d, bounds4.getMinY());
    assertEquals(0.0d, bounds3.getMinY());
    assertEquals(0.0d, bounds9.getMinY());
    assertEquals(0.0d, bounds12.getMinY());
    assertEquals(0.0d, bounds2.getMinY());
    assertEquals(0.0d, bounds8.getMinY());
    assertEquals(0.0d, bounds14.getMinY());
    assertEquals(0.0d, bounds11.getMinY());
    assertEquals(0.0d, bounds16.getMinY());
    assertEquals(0.0d, bounds2D4.getMinY());
    assertEquals(0.0d, bounds2D8.getMinY());
    assertEquals(0.0d, bounds2D10.getMinY());
    assertEquals(0.0d, bounds2D14.getMinY());
    assertEquals(0.0d, bounds2D19.getMinY());
    assertEquals(0.0d, bounds2D17.getMinY());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, bounds2D6.getMinY());
    assertEquals(0.0d, bounds7.getMinY());
    assertEquals(0.0d, bounds2D28.getMinY());
    assertEquals(0.0d, bounds2D20.getMinY());
    assertEquals(0.0d, bounds2D32.getMinY());
    assertEquals(0.0d, bounds17.getMinY());
    assertEquals(0.0d, bounds13.getMinY());
    assertEquals(0.0d, bounds18.getMinY());
    assertEquals(0.0d, bounds10.getMinY());
    assertEquals(0.0d, bounds19.getMinY());
    assertEquals(0.0d, bounds20.getMinY());
    assertEquals(0.0d, bounds15.getMinY());
    assertEquals(0.0d, bounds21.getMinY());
    assertEquals(0.0d, frame4.getMinY());
    assertEquals(0.0d, frame2.getMinY());
    assertEquals(0.0d, frame5.getMinY());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame3.getMinY());
    assertEquals(0.0d, frame6.getMinY());
    assertEquals(0.0d, frame7.getMinY());
    assertEquals(0.0d, frame8.getMinY());
    assertEquals(0.0d, bounds2D4.getY());
    assertEquals(0.0d, bounds2D8.getY());
    assertEquals(0.0d, bounds2D10.getY());
    assertEquals(0.0d, bounds2D14.getY());
    assertEquals(0.0d, bounds2D19.getY());
    assertEquals(0.0d, bounds2D17.getY());
    assertEquals(0.0d, bounds2D6.getY());
    assertEquals(0.0d, bounds2D28.getY());
    assertEquals(0.0d, bounds2D20.getY());
    assertEquals(0.0d, bounds2D32.getY());
    assertEquals(0.0d, frame4.getY());
    assertEquals(0.0d, frame2.getY());
    assertEquals(0.0d, frame5.getY());
    assertEquals(0.0d, frame.getY());
    assertEquals(0.0d, frame3.getY());
    assertEquals(0.0d, frame6.getY());
    assertEquals(0.0d, frame7.getY());
    assertEquals(0.0d, frame8.getY());
    assertEquals(396.0d, bounds6.getCenterY());
    assertEquals(396.0d, bounds5.getCenterY());
    assertEquals(396.0d, bounds4.getCenterY());
    assertEquals(396.0d, bounds3.getCenterY());
    assertEquals(396.0d, bounds9.getCenterY());
    assertEquals(396.0d, bounds12.getCenterY());
    assertEquals(396.0d, bounds2.getCenterY());
    assertEquals(396.0d, bounds8.getCenterY());
    assertEquals(396.0d, bounds14.getCenterY());
    assertEquals(396.0d, bounds11.getCenterY());
    assertEquals(396.0d, bounds16.getCenterY());
    assertEquals(396.0d, bounds2D3.getCenterY());
    assertEquals(396.0d, bounds2D4.getCenterY());
    assertEquals(396.0d, bounds2D8.getCenterY());
    assertEquals(396.0d, bounds2D10.getCenterY());
    assertEquals(396.0d, bounds2D14.getCenterY());
    assertEquals(396.0d, bounds2D19.getCenterY());
    assertEquals(396.0d, bounds2D17.getCenterY());
    assertEquals(396.0d, bounds.getCenterY());
    assertEquals(396.0d, bounds2D6.getCenterY());
    assertEquals(396.0d, bounds7.getCenterY());
    assertEquals(396.0d, bounds2D28.getCenterY());
    assertEquals(396.0d, bounds2D20.getCenterY());
    assertEquals(396.0d, bounds2D32.getCenterY());
    assertEquals(396.0d, bounds17.getCenterY());
    assertEquals(396.0d, bounds13.getCenterY());
    assertEquals(396.0d, bounds18.getCenterY());
    assertEquals(396.0d, bounds10.getCenterY());
    assertEquals(396.0d, bounds19.getCenterY());
    assertEquals(396.0d, bounds20.getCenterY());
    assertEquals(396.0d, bounds15.getCenterY());
    assertEquals(396.0d, bounds21.getCenterY());
    assertEquals(396.0d, frame4.getCenterY());
    assertEquals(396.0d, frame2.getCenterY());
    assertEquals(396.0d, frame5.getCenterY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(396.0d, frame3.getCenterY());
    assertEquals(396.0d, frame6.getCenterY());
    assertEquals(396.0d, frame7.getCenterY());
    assertEquals(396.0d, frame8.getCenterY());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(792, size4.getSize().height);
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(792, size7.getSize().height);
    assertEquals(792, size4.height);
    Dimension size8 = bounds3.getSize();
    Dimension size9 = size8.getSize();
    assertEquals(792, size9.getSize().height);
    assertEquals(792, size7.height);
    assertEquals(792, size3.height);
    Dimension size10 = bounds7.getSize();
    Dimension size11 = size10.getSize();
    assertEquals(792, size11.getSize().height);
    Dimension size12 = bounds10.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(792, size13.getSize().height);
    Dimension size14 = ((Rectangle) bounds2D10).getSize();
    Dimension size15 = size14.getSize();
    assertEquals(792, size15.getSize().height);
    Dimension size16 = bounds5.getSize();
    assertEquals(792, size16.getSize().height);
    Dimension size17 = bounds4.getSize();
    assertEquals(792, size17.getSize().height);
    assertEquals(792, size9.height);
    assertEquals(792, size6.height);
    Dimension size18 = bounds8.getSize();
    assertEquals(792, size18.getSize().height);
    Dimension size19 = bounds11.getSize();
    assertEquals(792, size19.getSize().height);
    assertEquals(792, size2.height);
    assertEquals(792, size11.height);
    Dimension size20 = bounds13.getSize();
    assertEquals(792, size20.getSize().height);
    assertEquals(792, size13.height);
    Dimension size21 = bounds15.getSize();
    assertEquals(792, size21.getSize().height);
    Dimension size22 = ((Rectangle) bounds2D8).getSize();
    assertEquals(792, size22.getSize().height);
    assertEquals(792, size15.height);
    assertEquals(792, bounds6.getSize().height);
    assertEquals(792, size16.height);
    assertEquals(792, size17.height);
    assertEquals(792, size8.height);
    assertEquals(792, bounds9.getSize().height);
    assertEquals(792, bounds12.getSize().height);
    assertEquals(792, size5.height);
    assertEquals(792, size18.height);
    assertEquals(792, bounds14.getSize().height);
    assertEquals(792, size19.height);
    assertEquals(792, bounds16.getSize().height);
    assertEquals(792, size.height);
    assertEquals(792, size10.height);
    assertEquals(792, bounds17.getSize().height);
    assertEquals(792, size20.height);
    assertEquals(792, bounds18.getSize().height);
    assertEquals(792, size12.height);
    assertEquals(792, bounds19.getSize().height);
    assertEquals(792, bounds20.getSize().height);
    assertEquals(792, size21.height);
    assertEquals(792, bounds21.getSize().height);
    assertEquals(792, ((Rectangle) bounds2D4).getSize().height);
    assertEquals(792, size22.height);
    assertEquals(792, size14.height);
    assertEquals(792, ((Rectangle) bounds2D14).getSize().height);
    assertEquals(792, ((Rectangle) bounds2D19).getSize().height);
    assertEquals(792, ((Rectangle) bounds2D28).getSize().height);
    assertEquals(792, bounds22.height);
    assertEquals(792, bounds6.height);
    assertEquals(792, bounds5.height);
    assertEquals(792, bounds4.height);
    assertEquals(792, bounds23.height);
    assertEquals(792, bounds24.height);
    assertEquals(792, bounds3.height);
    assertEquals(792, bounds9.height);
    assertEquals(792, bounds25.height);
    assertEquals(792, bounds12.height);
    assertEquals(792, bounds26.height);
    assertEquals(792, bounds2.height);
    assertEquals(792, bounds8.height);
    assertEquals(792, bounds27.height);
    assertEquals(792, bounds14.height);
    assertEquals(792, bounds28.height);
    assertEquals(792, bounds11.height);
    assertEquals(792, bounds29.height);
    assertEquals(792, bounds30.height);
    assertEquals(792, bounds16.height);
    assertEquals(792, bounds31.height);
    assertEquals(792, bounds.height);
    assertEquals(792, bounds7.height);
    assertEquals(792, bounds32.height);
    assertEquals(792, bounds33.height);
    assertEquals(792, bounds17.height);
    assertEquals(792, bounds13.height);
    assertEquals(792, bounds34.height);
    assertEquals(792, bounds35.height);
    assertEquals(792, bounds18.height);
    assertEquals(792, bounds10.height);
    assertEquals(792, bounds36.height);
    assertEquals(792, bounds19.height);
    assertEquals(792, bounds37.height);
    assertEquals(792, bounds38.height);
    assertEquals(792, bounds20.height);
    assertEquals(792, bounds39.height);
    assertEquals(792, bounds15.height);
    assertEquals(792, bounds21.height);
    assertEquals(792, bounds40.height);
    assertEquals(792, bounds41.height);
    assertEquals(792, bounds42.height);
    assertEquals(792, ((Rectangle) bounds2D).height);
    assertEquals(792, ((Rectangle) bounds2D2).height);
    assertEquals(792, ((Rectangle) bounds2D3).height);
    assertEquals(792, ((Rectangle) bounds2D4).height);
    assertEquals(792, ((Rectangle) bounds2D5).height);
    assertEquals(792, ((Rectangle) bounds2D7).height);
    assertEquals(792, ((Rectangle) bounds2D8).height);
    assertEquals(792, ((Rectangle) bounds2D9).height);
    assertEquals(792, ((Rectangle) bounds2D11).height);
    assertEquals(792, ((Rectangle) bounds2D12).height);
    assertEquals(792, ((Rectangle) bounds2D13).height);
    assertEquals(792, ((Rectangle) bounds2D10).height);
    assertEquals(792, ((Rectangle) bounds2D14).height);
    assertEquals(792, ((Rectangle) bounds2D15).height);
    assertEquals(792, ((Rectangle) bounds2D16).height);
    assertEquals(792, ((Rectangle) bounds2D18).height);
    assertEquals(792, ((Rectangle) bounds2D19).height);
    assertEquals(792, ((Rectangle) bounds2D21).height);
    assertEquals(792, ((Rectangle) bounds2D22).height);
    assertEquals(792, ((Rectangle) bounds2D23).height);
    assertEquals(792, ((Rectangle) bounds2D24).height);
    assertEquals(792, ((Rectangle) bounds2D25).height);
    assertEquals(792, ((Rectangle) bounds2D26).height);
    assertEquals(792, ((Rectangle) bounds2D27).height);
    assertEquals(792, ((Rectangle) bounds2D28).height);
    assertEquals(792, ((Rectangle) bounds2D29).height);
    assertEquals(792, ((Rectangle) bounds2D30).height);
    assertEquals(792, ((Rectangle) bounds2D31).height);
    assertEquals(792.0d, size4.getHeight());
    assertEquals(792.0d, size7.getHeight());
    assertEquals(792.0d, size3.getHeight());
    assertEquals(792.0d, size9.getHeight());
    assertEquals(792.0d, size6.getHeight());
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, size11.getHeight());
    assertEquals(792.0d, size13.getHeight());
    assertEquals(792.0d, size15.getHeight());
    assertEquals(792.0d, size16.getHeight());
    assertEquals(792.0d, size17.getHeight());
    assertEquals(792.0d, size8.getHeight());
    assertEquals(792.0d, size5.getHeight());
    assertEquals(792.0d, size18.getHeight());
    assertEquals(792.0d, size19.getHeight());
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, size10.getHeight());
    assertEquals(792.0d, size20.getHeight());
    assertEquals(792.0d, size12.getHeight());
    assertEquals(792.0d, size21.getHeight());
    assertEquals(792.0d, size22.getHeight());
    assertEquals(792.0d, size14.getHeight());
    assertEquals(792.0d, bounds6.getHeight());
    assertEquals(792.0d, bounds5.getHeight());
    assertEquals(792.0d, bounds4.getHeight());
    assertEquals(792.0d, bounds3.getHeight());
    assertEquals(792.0d, bounds9.getHeight());
    assertEquals(792.0d, bounds12.getHeight());
    assertEquals(792.0d, bounds2.getHeight());
    assertEquals(792.0d, bounds8.getHeight());
    assertEquals(792.0d, bounds14.getHeight());
    assertEquals(792.0d, bounds11.getHeight());
    assertEquals(792.0d, bounds16.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds7.getHeight());
    assertEquals(792.0d, bounds17.getHeight());
    assertEquals(792.0d, bounds13.getHeight());
    assertEquals(792.0d, bounds18.getHeight());
    assertEquals(792.0d, bounds10.getHeight());
    assertEquals(792.0d, bounds19.getHeight());
    assertEquals(792.0d, bounds20.getHeight());
    assertEquals(792.0d, bounds15.getHeight());
    assertEquals(792.0d, bounds21.getHeight());
    assertEquals(792.0d, bounds2D3.getHeight());
    assertEquals(792.0d, bounds2D4.getHeight());
    assertEquals(792.0d, bounds2D8.getHeight());
    assertEquals(792.0d, bounds2D10.getHeight());
    assertEquals(792.0d, bounds2D14.getHeight());
    assertEquals(792.0d, bounds2D19.getHeight());
    assertEquals(792.0d, bounds2D17.getHeight());
    assertEquals(792.0d, bounds2D6.getHeight());
    assertEquals(792.0d, bounds2D28.getHeight());
    assertEquals(792.0d, bounds2D20.getHeight());
    assertEquals(792.0d, bounds2D32.getHeight());
    assertEquals(792.0d, frame4.getHeight());
    assertEquals(792.0d, frame2.getHeight());
    assertEquals(792.0d, frame5.getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame3.getHeight());
    assertEquals(792.0d, frame6.getHeight());
    assertEquals(792.0d, frame7.getHeight());
    assertEquals(792.0d, frame8.getHeight());
    assertEquals(792.0d, bounds6.getMaxY());
    assertEquals(792.0d, bounds5.getMaxY());
    assertEquals(792.0d, bounds4.getMaxY());
    assertEquals(792.0d, bounds3.getMaxY());
    assertEquals(792.0d, bounds9.getMaxY());
    assertEquals(792.0d, bounds12.getMaxY());
    assertEquals(792.0d, bounds2.getMaxY());
    assertEquals(792.0d, bounds8.getMaxY());
    assertEquals(792.0d, bounds14.getMaxY());
    assertEquals(792.0d, bounds11.getMaxY());
    assertEquals(792.0d, bounds16.getMaxY());
    assertEquals(792.0d, bounds2D4.getMaxY());
    assertEquals(792.0d, bounds2D8.getMaxY());
    assertEquals(792.0d, bounds2D10.getMaxY());
    assertEquals(792.0d, bounds2D14.getMaxY());
    assertEquals(792.0d, bounds2D19.getMaxY());
    assertEquals(792.0d, bounds2D17.getMaxY());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(792.0d, bounds2D6.getMaxY());
    assertEquals(792.0d, bounds7.getMaxY());
    assertEquals(792.0d, bounds2D28.getMaxY());
    assertEquals(792.0d, bounds2D20.getMaxY());
    assertEquals(792.0d, bounds2D32.getMaxY());
    assertEquals(792.0d, bounds17.getMaxY());
    assertEquals(792.0d, bounds13.getMaxY());
    assertEquals(792.0d, bounds18.getMaxY());
    assertEquals(792.0d, bounds10.getMaxY());
    assertEquals(792.0d, bounds19.getMaxY());
    assertEquals(792.0d, bounds20.getMaxY());
    assertEquals(792.0d, bounds15.getMaxY());
    assertEquals(792.0d, bounds21.getMaxY());
    assertEquals(792.0d, frame4.getMaxY());
    assertEquals(792.0d, frame2.getMaxY());
    assertEquals(792.0d, frame5.getMaxY());
    assertEquals(792.0d, frame.getMaxY());
    assertEquals(792.0d, frame3.getMaxY());
    assertEquals(792.0d, frame6.getMaxY());
    assertEquals(792.0d, frame7.getMaxY());
    assertEquals(792.0d, frame8.getMaxY());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage4() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
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
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    Rectangle bounds7 = getResult.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D5 = bounds9.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = currentClippingPath.getBounds2D();
    Rectangle bounds10 = bounds2D6.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds8.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D bounds2D10 = bounds.getBounds2D();
    Rectangle bounds13 = bounds2D10.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle2D bounds2D11 = bounds14.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds11.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds15 = frame.getBounds();
    Rectangle bounds16 = bounds15.getBounds();
    Rectangle2D bounds2D13 = bounds16.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D14 = bounds7.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle bounds17 = bounds2D8.getBounds();
    Rectangle2D bounds2D15 = bounds17.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds13.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = getResult.getBounds2D();
    Rectangle bounds18 = bounds2D17.getBounds();
    Rectangle2D bounds2D18 = bounds18.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds10.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D bounds2D20 = bounds2D6.getBounds2D();
    Rectangle bounds19 = bounds2D20.getBounds();
    Rectangle2D bounds2D21 = bounds19.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds20 = frame2.getBounds();
    Rectangle2D bounds2D22 = bounds20.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D bounds2D23 = bounds15.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D frame3 = bounds2D6.getFrame();
    Rectangle bounds21 = frame3.getBounds();
    Rectangle2D bounds2D24 = bounds21.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D3.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D4.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D8.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D10.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D14.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D19.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    assertTrue(bounds2D17 instanceof Rectangle2D.Double);
    assertTrue(bounds2D6 instanceof Rectangle2D.Double);
    assertTrue(bounds2D20 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds3.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds2D10.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds10.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = frame.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    assertEquals(1.07374213E9d, bounds6.getCenterX());
    assertEquals(1.07374213E9d, bounds5.getCenterX());
    assertEquals(1.07374213E9d, bounds4.getCenterX());
    assertEquals(1.07374213E9d, bounds3.getCenterX());
    assertEquals(1.07374213E9d, bounds9.getCenterX());
    assertEquals(1.07374213E9d, bounds12.getCenterX());
    assertEquals(1.07374213E9d, bounds2.getCenterX());
    assertEquals(1.07374213E9d, bounds8.getCenterX());
    assertEquals(1.07374213E9d, bounds14.getCenterX());
    assertEquals(1.07374213E9d, bounds11.getCenterX());
    assertEquals(1.07374213E9d, bounds16.getCenterX());
    assertEquals(1.07374213E9d, bounds2D3.getCenterX());
    assertEquals(1.07374213E9d, bounds2D4.getCenterX());
    assertEquals(1.07374213E9d, bounds2D8.getCenterX());
    assertEquals(1.07374213E9d, bounds2D10.getCenterX());
    assertEquals(1.07374213E9d, bounds2D14.getCenterX());
    assertEquals(1.07374213E9d, bounds2D19.getCenterX());
    assertEquals(1.07374213E9d, bounds2D17.getCenterX());
    assertEquals(1.07374213E9d, bounds.getCenterX());
    assertEquals(1.07374213E9d, bounds2D6.getCenterX());
    assertEquals(1.07374213E9d, bounds7.getCenterX());
    assertEquals(1.07374213E9d, bounds2D28.getCenterX());
    assertEquals(1.07374213E9d, bounds2D20.getCenterX());
    assertEquals(1.07374213E9d, bounds2D32.getCenterX());
    assertEquals(1.07374213E9d, bounds17.getCenterX());
    assertEquals(1.07374213E9d, bounds13.getCenterX());
    assertEquals(1.07374213E9d, bounds18.getCenterX());
    assertEquals(1.07374213E9d, bounds10.getCenterX());
    assertEquals(1.07374213E9d, bounds19.getCenterX());
    assertEquals(1.07374213E9d, bounds20.getCenterX());
    assertEquals(1.07374213E9d, bounds15.getCenterX());
    assertEquals(1.07374213E9d, bounds21.getCenterX());
    assertEquals(1.07374213E9d, frame4.getCenterX());
    assertEquals(1.07374213E9d, frame2.getCenterX());
    assertEquals(1.07374213E9d, frame5.getCenterX());
    assertEquals(1.07374213E9d, frame.getCenterX());
    assertEquals(1.07374213E9d, frame3.getCenterX());
    assertEquals(1.07374213E9d, frame6.getCenterX());
    assertEquals(1.07374213E9d, frame7.getCenterX());
    assertEquals(1.07374213E9d, frame8.getCenterX());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(2.147483036E9d, size4.getWidth());
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(2.147483036E9d, size7.getWidth());
    assertEquals(2.147483036E9d, size3.getWidth());
    Dimension size8 = bounds3.getSize();
    Dimension size9 = size8.getSize();
    assertEquals(2.147483036E9d, size9.getWidth());
    assertEquals(2.147483036E9d, size6.getWidth());
    assertEquals(2.147483036E9d, size2.getWidth());
    Dimension size10 = bounds7.getSize();
    Dimension size11 = size10.getSize();
    assertEquals(2.147483036E9d, size11.getWidth());
    Dimension size12 = bounds10.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(2.147483036E9d, size13.getWidth());
    Dimension size14 = ((Rectangle) bounds2D10).getSize();
    Dimension size15 = size14.getSize();
    assertEquals(2.147483036E9d, size15.getWidth());
    Dimension size16 = bounds5.getSize();
    assertEquals(2.147483036E9d, size16.getWidth());
    Dimension size17 = bounds4.getSize();
    assertEquals(2.147483036E9d, size17.getWidth());
    assertEquals(2.147483036E9d, size8.getWidth());
    assertEquals(2.147483036E9d, size5.getWidth());
    Dimension size18 = bounds8.getSize();
    assertEquals(2.147483036E9d, size18.getWidth());
    Dimension size19 = bounds11.getSize();
    assertEquals(2.147483036E9d, size19.getWidth());
    assertEquals(2.147483036E9d, size.getWidth());
    assertEquals(2.147483036E9d, size10.getWidth());
    Dimension size20 = bounds13.getSize();
    assertEquals(2.147483036E9d, size20.getWidth());
    assertEquals(2.147483036E9d, size12.getWidth());
    Dimension size21 = bounds15.getSize();
    assertEquals(2.147483036E9d, size21.getWidth());
    Dimension size22 = ((Rectangle) bounds2D8).getSize();
    assertEquals(2.147483036E9d, size22.getWidth());
    assertEquals(2.147483036E9d, size14.getWidth());
    assertEquals(2.147483036E9d, bounds6.getWidth());
    assertEquals(2.147483036E9d, bounds5.getWidth());
    assertEquals(2.147483036E9d, bounds4.getWidth());
    assertEquals(2.147483036E9d, bounds3.getWidth());
    assertEquals(2.147483036E9d, bounds9.getWidth());
    assertEquals(2.147483036E9d, bounds12.getWidth());
    assertEquals(2.147483036E9d, bounds2.getWidth());
    assertEquals(2.147483036E9d, bounds8.getWidth());
    assertEquals(2.147483036E9d, bounds14.getWidth());
    assertEquals(2.147483036E9d, bounds11.getWidth());
    assertEquals(2.147483036E9d, bounds16.getWidth());
    assertEquals(2.147483036E9d, bounds.getWidth());
    assertEquals(2.147483036E9d, bounds7.getWidth());
    assertEquals(2.147483036E9d, bounds17.getWidth());
    assertEquals(2.147483036E9d, bounds13.getWidth());
    assertEquals(2.147483036E9d, bounds18.getWidth());
    assertEquals(2.147483036E9d, bounds10.getWidth());
    assertEquals(2.147483036E9d, bounds19.getWidth());
    assertEquals(2.147483036E9d, bounds20.getWidth());
    assertEquals(2.147483036E9d, bounds15.getWidth());
    assertEquals(2.147483036E9d, bounds21.getWidth());
    assertEquals(2.147483036E9d, bounds2D4.getWidth());
    assertEquals(2.147483036E9d, bounds2D8.getWidth());
    assertEquals(2.147483036E9d, bounds2D10.getWidth());
    assertEquals(2.147483036E9d, bounds2D14.getWidth());
    assertEquals(2.147483036E9d, bounds2D19.getWidth());
    assertEquals(2.147483036E9d, bounds2D17.getWidth());
    assertEquals(2.147483036E9d, bounds2D6.getWidth());
    assertEquals(2.147483036E9d, bounds2D28.getWidth());
    assertEquals(2.147483036E9d, bounds2D20.getWidth());
    assertEquals(2.147483036E9d, bounds2D32.getWidth());
    assertEquals(2.147483036E9d, frame4.getWidth());
    assertEquals(2.147483036E9d, frame2.getWidth());
    assertEquals(2.147483036E9d, frame5.getWidth());
    assertEquals(2.147483036E9d, frame.getWidth());
    assertEquals(2.147483036E9d, frame3.getWidth());
    assertEquals(2.147483036E9d, frame6.getWidth());
    assertEquals(2.147483036E9d, frame7.getWidth());
    assertEquals(2.147483036E9d, frame8.getWidth());
    assertEquals(2.147483648E9d, currentPoint.getX());
    assertEquals(2.147483648E9d, bounds6.getMaxX());
    assertEquals(2.147483648E9d, bounds5.getMaxX());
    assertEquals(2.147483648E9d, bounds4.getMaxX());
    assertEquals(2.147483648E9d, bounds3.getMaxX());
    assertEquals(2.147483648E9d, bounds9.getMaxX());
    assertEquals(2.147483648E9d, bounds12.getMaxX());
    assertEquals(2.147483648E9d, bounds2.getMaxX());
    assertEquals(2.147483648E9d, bounds8.getMaxX());
    assertEquals(2.147483648E9d, bounds14.getMaxX());
    assertEquals(2.147483648E9d, bounds11.getMaxX());
    assertEquals(2.147483648E9d, bounds16.getMaxX());
    assertEquals(2.147483648E9d, bounds2D3.getMaxX());
    assertEquals(2.147483648E9d, bounds2D4.getMaxX());
    assertEquals(2.147483648E9d, bounds2D8.getMaxX());
    assertEquals(2.147483648E9d, bounds2D10.getMaxX());
    assertEquals(2.147483648E9d, bounds2D14.getMaxX());
    assertEquals(2.147483648E9d, bounds2D19.getMaxX());
    assertEquals(2.147483648E9d, bounds2D17.getMaxX());
    assertEquals(2.147483648E9d, bounds.getMaxX());
    assertEquals(2.147483648E9d, bounds2D6.getMaxX());
    assertEquals(2.147483648E9d, bounds7.getMaxX());
    assertEquals(2.147483648E9d, bounds2D28.getMaxX());
    assertEquals(2.147483648E9d, bounds2D20.getMaxX());
    assertEquals(2.147483648E9d, bounds2D32.getMaxX());
    assertEquals(2.147483648E9d, bounds17.getMaxX());
    assertEquals(2.147483648E9d, bounds13.getMaxX());
    assertEquals(2.147483648E9d, bounds18.getMaxX());
    assertEquals(2.147483648E9d, bounds10.getMaxX());
    assertEquals(2.147483648E9d, bounds19.getMaxX());
    assertEquals(2.147483648E9d, bounds20.getMaxX());
    assertEquals(2.147483648E9d, bounds15.getMaxX());
    assertEquals(2.147483648E9d, bounds21.getMaxX());
    assertEquals(2.147483648E9d, frame4.getMaxX());
    assertEquals(2.147483648E9d, frame2.getMaxX());
    assertEquals(2.147483648E9d, frame5.getMaxX());
    assertEquals(2.147483648E9d, frame.getMaxX());
    assertEquals(2.147483648E9d, frame3.getMaxX());
    assertEquals(2.147483648E9d, frame6.getMaxX());
    assertEquals(2.147483648E9d, frame7.getMaxX());
    assertEquals(2.147483648E9d, frame8.getMaxX());
    assertEquals(2147483036, size4.getSize().width);
    assertEquals(2147483036, size7.getSize().width);
    assertEquals(2147483036, size4.width);
    assertEquals(2147483036, size9.getSize().width);
    assertEquals(2147483036, size7.width);
    assertEquals(2147483036, size3.width);
    assertEquals(2147483036, size11.getSize().width);
    assertEquals(2147483036, size13.getSize().width);
    assertEquals(2147483036, size15.getSize().width);
    assertEquals(2147483036, size16.getSize().width);
    assertEquals(2147483036, size17.getSize().width);
    assertEquals(2147483036, size9.width);
    assertEquals(2147483036, size6.width);
    assertEquals(2147483036, size18.getSize().width);
    assertEquals(2147483036, size19.getSize().width);
    assertEquals(2147483036, size2.width);
    assertEquals(2147483036, size11.width);
    assertEquals(2147483036, size20.getSize().width);
    assertEquals(2147483036, size13.width);
    assertEquals(2147483036, size21.getSize().width);
    assertEquals(2147483036, size22.getSize().width);
    assertEquals(2147483036, size15.width);
    assertEquals(2147483036, bounds6.getSize().width);
    assertEquals(2147483036, size16.width);
    assertEquals(2147483036, size17.width);
    assertEquals(2147483036, size8.width);
    assertEquals(2147483036, bounds9.getSize().width);
    assertEquals(2147483036, bounds12.getSize().width);
    assertEquals(2147483036, size5.width);
    assertEquals(2147483036, size18.width);
    assertEquals(2147483036, bounds14.getSize().width);
    assertEquals(2147483036, size19.width);
    assertEquals(2147483036, bounds16.getSize().width);
    assertEquals(2147483036, size.width);
    assertEquals(2147483036, size10.width);
    assertEquals(2147483036, bounds17.getSize().width);
    assertEquals(2147483036, size20.width);
    assertEquals(2147483036, bounds18.getSize().width);
    assertEquals(2147483036, size12.width);
    assertEquals(2147483036, bounds19.getSize().width);
    assertEquals(2147483036, bounds20.getSize().width);
    assertEquals(2147483036, size21.width);
    assertEquals(2147483036, bounds21.getSize().width);
    assertEquals(2147483036, ((Rectangle) bounds2D4).getSize().width);
    assertEquals(2147483036, size22.width);
    assertEquals(2147483036, size14.width);
    assertEquals(2147483036, ((Rectangle) bounds2D14).getSize().width);
    assertEquals(2147483036, ((Rectangle) bounds2D19).getSize().width);
    assertEquals(2147483036, ((Rectangle) bounds2D28).getSize().width);
    Rectangle bounds22 = bounds6.getBounds();
    assertEquals(2147483036, bounds22.width);
    assertEquals(2147483036, bounds6.width);
    assertEquals(2147483036, bounds5.width);
    assertEquals(2147483036, bounds4.width);
    Rectangle bounds23 = bounds9.getBounds();
    assertEquals(2147483036, bounds23.width);
    Rectangle bounds24 = bounds12.getBounds();
    assertEquals(2147483036, bounds24.width);
    assertEquals(2147483036, bounds3.width);
    assertEquals(2147483036, bounds9.width);
    Rectangle bounds25 = bounds14.getBounds();
    assertEquals(2147483036, bounds25.width);
    assertEquals(2147483036, bounds12.width);
    Rectangle bounds26 = bounds16.getBounds();
    assertEquals(2147483036, bounds26.width);
    assertEquals(2147483036, bounds2.width);
    assertEquals(2147483036, bounds8.width);
    Rectangle bounds27 = bounds17.getBounds();
    assertEquals(2147483036, bounds27.width);
    assertEquals(2147483036, bounds14.width);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(2147483036, bounds28.width);
    assertEquals(2147483036, bounds11.width);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(2147483036, bounds29.width);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(2147483036, bounds30.width);
    assertEquals(2147483036, bounds16.width);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(2147483036, bounds31.width);
    assertEquals(2147483036, bounds.width);
    assertEquals(2147483036, bounds7.width);
    Rectangle bounds32 = bounds2D3.getBounds();
    assertEquals(2147483036, bounds32.width);
    Rectangle bounds33 = bounds2D4.getBounds();
    assertEquals(2147483036, bounds33.width);
    assertEquals(2147483036, bounds17.width);
    assertEquals(2147483036, bounds13.width);
    Rectangle bounds34 = bounds2D14.getBounds();
    assertEquals(2147483036, bounds34.width);
    Rectangle bounds35 = bounds2D19.getBounds();
    assertEquals(2147483036, bounds35.width);
    assertEquals(2147483036, bounds18.width);
    assertEquals(2147483036, bounds10.width);
    Rectangle bounds36 = bounds2D28.getBounds();
    assertEquals(2147483036, bounds36.width);
    assertEquals(2147483036, bounds19.width);
    Rectangle bounds37 = bounds2D32.getBounds();
    assertEquals(2147483036, bounds37.width);
    Rectangle bounds38 = frame4.getBounds();
    assertEquals(2147483036, bounds38.width);
    assertEquals(2147483036, bounds20.width);
    Rectangle bounds39 = frame5.getBounds();
    assertEquals(2147483036, bounds39.width);
    assertEquals(2147483036, bounds15.width);
    assertEquals(2147483036, bounds21.width);
    Rectangle bounds40 = frame6.getBounds();
    assertEquals(2147483036, bounds40.width);
    Rectangle bounds41 = frame7.getBounds();
    assertEquals(2147483036, bounds41.width);
    Rectangle bounds42 = frame8.getBounds();
    assertEquals(2147483036, bounds42.width);
    assertEquals(2147483036, ((Rectangle) bounds2D).width);
    assertEquals(2147483036, ((Rectangle) bounds2D2).width);
    assertEquals(2147483036, ((Rectangle) bounds2D3).width);
    assertEquals(2147483036, ((Rectangle) bounds2D4).width);
    assertEquals(2147483036, ((Rectangle) bounds2D5).width);
    assertEquals(2147483036, ((Rectangle) bounds2D7).width);
    assertEquals(2147483036, ((Rectangle) bounds2D8).width);
    assertEquals(2147483036, ((Rectangle) bounds2D9).width);
    assertEquals(2147483036, ((Rectangle) bounds2D11).width);
    assertEquals(2147483036, ((Rectangle) bounds2D12).width);
    assertEquals(2147483036, ((Rectangle) bounds2D13).width);
    assertEquals(2147483036, ((Rectangle) bounds2D10).width);
    assertEquals(2147483036, ((Rectangle) bounds2D14).width);
    assertEquals(2147483036, ((Rectangle) bounds2D15).width);
    assertEquals(2147483036, ((Rectangle) bounds2D16).width);
    assertEquals(2147483036, ((Rectangle) bounds2D18).width);
    assertEquals(2147483036, ((Rectangle) bounds2D19).width);
    assertEquals(2147483036, ((Rectangle) bounds2D21).width);
    assertEquals(2147483036, ((Rectangle) bounds2D22).width);
    assertEquals(2147483036, ((Rectangle) bounds2D23).width);
    assertEquals(2147483036, ((Rectangle) bounds2D24).width);
    assertEquals(2147483036, ((Rectangle) bounds2D25).width);
    assertEquals(2147483036, ((Rectangle) bounds2D26).width);
    assertEquals(2147483036, ((Rectangle) bounds2D27).width);
    assertEquals(2147483036, ((Rectangle) bounds2D28).width);
    assertEquals(2147483036, ((Rectangle) bounds2D29).width);
    assertEquals(2147483036, ((Rectangle) bounds2D30).width);
    assertEquals(2147483036, ((Rectangle) bounds2D31).width);
    Point location = bounds.getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(612, location4.getLocation().x);
    Point location5 = bounds2.getLocation();
    Point location6 = location5.getLocation();
    Point location7 = location6.getLocation();
    assertEquals(612, location7.getLocation().x);
    assertEquals(612, location4.x);
    Point location8 = bounds3.getLocation();
    Point location9 = location8.getLocation();
    assertEquals(612, location9.getLocation().x);
    assertEquals(612, location7.x);
    assertEquals(612, location3.x);
    Point location10 = bounds7.getLocation();
    Point location11 = location10.getLocation();
    assertEquals(612, location11.getLocation().x);
    Point location12 = bounds10.getLocation();
    Point location13 = location12.getLocation();
    assertEquals(612, location13.getLocation().x);
    Point location14 = ((Rectangle) bounds2D10).getLocation();
    Point location15 = location14.getLocation();
    assertEquals(612, location15.getLocation().x);
    Point location16 = bounds5.getLocation();
    assertEquals(612, location16.getLocation().x);
    Point location17 = bounds4.getLocation();
    assertEquals(612, location17.getLocation().x);
    assertEquals(612, location9.x);
    assertEquals(612, location6.x);
    Point location18 = bounds8.getLocation();
    assertEquals(612, location18.getLocation().x);
    Point location19 = bounds11.getLocation();
    assertEquals(612, location19.getLocation().x);
    assertEquals(612, location2.x);
    assertEquals(612, location11.x);
    Point location20 = bounds13.getLocation();
    assertEquals(612, location20.getLocation().x);
    assertEquals(612, location13.x);
    Point location21 = bounds15.getLocation();
    assertEquals(612, location21.getLocation().x);
    Point location22 = ((Rectangle) bounds2D8).getLocation();
    assertEquals(612, location22.getLocation().x);
    assertEquals(612, location15.x);
    assertEquals(612, bounds6.getLocation().x);
    assertEquals(612, location16.x);
    assertEquals(612, location17.x);
    assertEquals(612, location8.x);
    assertEquals(612, bounds9.getLocation().x);
    assertEquals(612, bounds12.getLocation().x);
    assertEquals(612, location5.x);
    assertEquals(612, location18.x);
    assertEquals(612, bounds14.getLocation().x);
    assertEquals(612, location19.x);
    assertEquals(612, bounds16.getLocation().x);
    assertEquals(612, location.x);
    assertEquals(612, location10.x);
    assertEquals(612, bounds17.getLocation().x);
    assertEquals(612, location20.x);
    assertEquals(612, bounds18.getLocation().x);
    assertEquals(612, location12.x);
    assertEquals(612, bounds19.getLocation().x);
    assertEquals(612, bounds20.getLocation().x);
    assertEquals(612, location21.x);
    assertEquals(612, bounds21.getLocation().x);
    assertEquals(612, ((Rectangle) bounds2D3).getLocation().x);
    assertEquals(612, ((Rectangle) bounds2D4).getLocation().x);
    assertEquals(612, location22.x);
    assertEquals(612, location14.x);
    assertEquals(612, ((Rectangle) bounds2D14).getLocation().x);
    assertEquals(612, ((Rectangle) bounds2D19).getLocation().x);
    assertEquals(612, ((Rectangle) bounds2D28).getLocation().x);
    assertEquals(612, bounds22.x);
    assertEquals(612, bounds6.x);
    assertEquals(612, bounds5.x);
    assertEquals(612, bounds4.x);
    assertEquals(612, bounds23.x);
    assertEquals(612, bounds24.x);
    assertEquals(612, bounds3.x);
    assertEquals(612, bounds9.x);
    assertEquals(612, bounds25.x);
    assertEquals(612, bounds12.x);
    assertEquals(612, bounds26.x);
    assertEquals(612, bounds2.x);
    assertEquals(612, bounds8.x);
    assertEquals(612, bounds27.x);
    assertEquals(612, bounds14.x);
    assertEquals(612, bounds28.x);
    assertEquals(612, bounds11.x);
    assertEquals(612, bounds29.x);
    assertEquals(612, bounds30.x);
    assertEquals(612, bounds16.x);
    assertEquals(612, bounds31.x);
    assertEquals(612, bounds.x);
    assertEquals(612, bounds7.x);
    assertEquals(612, bounds32.x);
    assertEquals(612, bounds33.x);
    assertEquals(612, bounds17.x);
    assertEquals(612, bounds13.x);
    assertEquals(612, bounds34.x);
    assertEquals(612, bounds35.x);
    assertEquals(612, bounds18.x);
    assertEquals(612, bounds10.x);
    assertEquals(612, bounds36.x);
    assertEquals(612, bounds19.x);
    assertEquals(612, bounds37.x);
    assertEquals(612, bounds38.x);
    assertEquals(612, bounds20.x);
    assertEquals(612, bounds39.x);
    assertEquals(612, bounds15.x);
    assertEquals(612, bounds21.x);
    assertEquals(612, bounds40.x);
    assertEquals(612, bounds41.x);
    assertEquals(612, bounds42.x);
    assertEquals(612, ((Rectangle) bounds2D).x);
    assertEquals(612, ((Rectangle) bounds2D2).x);
    assertEquals(612, ((Rectangle) bounds2D3).x);
    assertEquals(612, ((Rectangle) bounds2D4).x);
    assertEquals(612, ((Rectangle) bounds2D5).x);
    assertEquals(612, ((Rectangle) bounds2D7).x);
    assertEquals(612, ((Rectangle) bounds2D8).x);
    assertEquals(612, ((Rectangle) bounds2D9).x);
    assertEquals(612, ((Rectangle) bounds2D11).x);
    assertEquals(612, ((Rectangle) bounds2D12).x);
    assertEquals(612, ((Rectangle) bounds2D13).x);
    assertEquals(612, ((Rectangle) bounds2D10).x);
    assertEquals(612, ((Rectangle) bounds2D14).x);
    assertEquals(612, ((Rectangle) bounds2D15).x);
    assertEquals(612, ((Rectangle) bounds2D16).x);
    assertEquals(612, ((Rectangle) bounds2D18).x);
    assertEquals(612, ((Rectangle) bounds2D19).x);
    assertEquals(612, ((Rectangle) bounds2D21).x);
    assertEquals(612, ((Rectangle) bounds2D22).x);
    assertEquals(612, ((Rectangle) bounds2D23).x);
    assertEquals(612, ((Rectangle) bounds2D24).x);
    assertEquals(612, ((Rectangle) bounds2D25).x);
    assertEquals(612, ((Rectangle) bounds2D26).x);
    assertEquals(612, ((Rectangle) bounds2D27).x);
    assertEquals(612, ((Rectangle) bounds2D28).x);
    assertEquals(612, ((Rectangle) bounds2D29).x);
    assertEquals(612, ((Rectangle) bounds2D30).x);
    assertEquals(612, ((Rectangle) bounds2D31).x);
    assertEquals(612.0d, location4.getX());
    assertEquals(612.0d, location7.getX());
    assertEquals(612.0d, location3.getX());
    assertEquals(612.0d, location9.getX());
    assertEquals(612.0d, location6.getX());
    assertEquals(612.0d, location2.getX());
    assertEquals(612.0d, location11.getX());
    assertEquals(612.0d, location13.getX());
    assertEquals(612.0d, location15.getX());
    assertEquals(612.0d, location16.getX());
    assertEquals(612.0d, location17.getX());
    assertEquals(612.0d, location8.getX());
    assertEquals(612.0d, location5.getX());
    assertEquals(612.0d, location18.getX());
    assertEquals(612.0d, location19.getX());
    assertEquals(612.0d, location.getX());
    assertEquals(612.0d, location10.getX());
    assertEquals(612.0d, location20.getX());
    assertEquals(612.0d, location12.getX());
    assertEquals(612.0d, location21.getX());
    assertEquals(612.0d, location22.getX());
    assertEquals(612.0d, location14.getX());
    assertEquals(612.0d, bounds6.getX());
    assertEquals(612.0d, bounds5.getX());
    assertEquals(612.0d, bounds4.getX());
    assertEquals(612.0d, bounds3.getX());
    assertEquals(612.0d, bounds9.getX());
    assertEquals(612.0d, bounds12.getX());
    assertEquals(612.0d, bounds2.getX());
    assertEquals(612.0d, bounds8.getX());
    assertEquals(612.0d, bounds14.getX());
    assertEquals(612.0d, bounds11.getX());
    assertEquals(612.0d, bounds16.getX());
    assertEquals(612.0d, bounds.getX());
    assertEquals(612.0d, bounds7.getX());
    assertEquals(612.0d, bounds17.getX());
    assertEquals(612.0d, bounds13.getX());
    assertEquals(612.0d, bounds18.getX());
    assertEquals(612.0d, bounds10.getX());
    assertEquals(612.0d, bounds19.getX());
    assertEquals(612.0d, bounds20.getX());
    assertEquals(612.0d, bounds15.getX());
    assertEquals(612.0d, bounds21.getX());
    assertEquals(612.0d, bounds6.getMinX());
    assertEquals(612.0d, bounds5.getMinX());
    assertEquals(612.0d, bounds4.getMinX());
    assertEquals(612.0d, bounds3.getMinX());
    assertEquals(612.0d, bounds9.getMinX());
    assertEquals(612.0d, bounds12.getMinX());
    assertEquals(612.0d, bounds2.getMinX());
    assertEquals(612.0d, bounds8.getMinX());
    assertEquals(612.0d, bounds14.getMinX());
    assertEquals(612.0d, bounds11.getMinX());
    assertEquals(612.0d, bounds16.getMinX());
    assertEquals(612.0d, bounds2D4.getMinX());
    assertEquals(612.0d, bounds2D8.getMinX());
    assertEquals(612.0d, bounds2D10.getMinX());
    assertEquals(612.0d, bounds2D14.getMinX());
    assertEquals(612.0d, bounds2D19.getMinX());
    assertEquals(612.0d, bounds2D17.getMinX());
    assertEquals(612.0d, bounds.getMinX());
    assertEquals(612.0d, bounds2D6.getMinX());
    assertEquals(612.0d, bounds7.getMinX());
    assertEquals(612.0d, bounds2D28.getMinX());
    assertEquals(612.0d, bounds2D20.getMinX());
    assertEquals(612.0d, bounds2D32.getMinX());
    assertEquals(612.0d, bounds17.getMinX());
    assertEquals(612.0d, bounds13.getMinX());
    assertEquals(612.0d, bounds18.getMinX());
    assertEquals(612.0d, bounds10.getMinX());
    assertEquals(612.0d, bounds19.getMinX());
    assertEquals(612.0d, bounds20.getMinX());
    assertEquals(612.0d, bounds15.getMinX());
    assertEquals(612.0d, bounds21.getMinX());
    assertEquals(612.0d, frame4.getMinX());
    assertEquals(612.0d, frame2.getMinX());
    assertEquals(612.0d, frame5.getMinX());
    assertEquals(612.0d, frame.getMinX());
    assertEquals(612.0d, frame3.getMinX());
    assertEquals(612.0d, frame6.getMinX());
    assertEquals(612.0d, frame7.getMinX());
    assertEquals(612.0d, frame8.getMinX());
    assertEquals(612.0d, bounds2D4.getX());
    assertEquals(612.0d, bounds2D8.getX());
    assertEquals(612.0d, bounds2D10.getX());
    assertEquals(612.0d, bounds2D14.getX());
    assertEquals(612.0d, bounds2D19.getX());
    assertEquals(612.0d, bounds2D17.getX());
    assertEquals(612.0d, bounds2D6.getX());
    assertEquals(612.0d, bounds2D28.getX());
    assertEquals(612.0d, bounds2D20.getX());
    assertEquals(612.0d, bounds2D32.getX());
    assertEquals(612.0d, frame4.getX());
    assertEquals(612.0d, frame2.getX());
    assertEquals(612.0d, frame5.getX());
    assertEquals(612.0d, frame.getX());
    assertEquals(612.0d, frame3.getX());
    assertEquals(612.0d, frame6.getX());
    assertEquals(612.0d, frame7.getX());
    assertEquals(612.0d, frame8.getX());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage5() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
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
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    Rectangle bounds7 = getResult.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D5 = bounds9.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = currentClippingPath.getBounds2D();
    Rectangle bounds10 = bounds2D6.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds8.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D bounds2D10 = bounds.getBounds2D();
    Rectangle bounds13 = bounds2D10.getBounds();
    Rectangle bounds14 = bounds13.getBounds();
    Rectangle2D bounds2D11 = bounds14.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds11.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds15 = frame.getBounds();
    Rectangle bounds16 = bounds15.getBounds();
    Rectangle2D bounds2D13 = bounds16.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D14 = bounds7.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle bounds17 = bounds2D8.getBounds();
    Rectangle2D bounds2D15 = bounds17.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds13.getBounds2D();
    assertTrue(bounds2D16 instanceof Rectangle);
    Rectangle2D bounds2D17 = getResult.getBounds2D();
    Rectangle bounds18 = bounds2D17.getBounds();
    Rectangle2D bounds2D18 = bounds18.getBounds2D();
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D19 = bounds10.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D bounds2D20 = bounds2D6.getBounds2D();
    Rectangle bounds19 = bounds2D20.getBounds();
    Rectangle2D bounds2D21 = bounds19.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds20 = frame2.getBounds();
    Rectangle2D bounds2D22 = bounds20.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D bounds2D23 = bounds15.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    Rectangle2D frame3 = bounds2D6.getFrame();
    Rectangle bounds21 = frame3.getBounds();
    Rectangle2D bounds2D24 = bounds21.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D3.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D4.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D8.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D10.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D14.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D19.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    assertTrue(bounds2D17 instanceof Rectangle2D.Double);
    assertTrue(bounds2D6 instanceof Rectangle2D.Double);
    assertTrue(bounds2D20 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds3.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds2D10.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds10.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = frame.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    assertEquals(1.07374222E9d, bounds6.getCenterY());
    assertEquals(1.07374222E9d, bounds5.getCenterY());
    assertEquals(1.07374222E9d, bounds4.getCenterY());
    assertEquals(1.07374222E9d, bounds3.getCenterY());
    assertEquals(1.07374222E9d, bounds9.getCenterY());
    assertEquals(1.07374222E9d, bounds12.getCenterY());
    assertEquals(1.07374222E9d, bounds2.getCenterY());
    assertEquals(1.07374222E9d, bounds8.getCenterY());
    assertEquals(1.07374222E9d, bounds14.getCenterY());
    assertEquals(1.07374222E9d, bounds11.getCenterY());
    assertEquals(1.07374222E9d, bounds16.getCenterY());
    assertEquals(1.07374222E9d, bounds2D3.getCenterY());
    assertEquals(1.07374222E9d, bounds2D4.getCenterY());
    assertEquals(1.07374222E9d, bounds2D8.getCenterY());
    assertEquals(1.07374222E9d, bounds2D10.getCenterY());
    assertEquals(1.07374222E9d, bounds2D14.getCenterY());
    assertEquals(1.07374222E9d, bounds2D19.getCenterY());
    assertEquals(1.07374222E9d, bounds2D17.getCenterY());
    assertEquals(1.07374222E9d, bounds.getCenterY());
    assertEquals(1.07374222E9d, bounds2D6.getCenterY());
    assertEquals(1.07374222E9d, bounds7.getCenterY());
    assertEquals(1.07374222E9d, bounds2D28.getCenterY());
    assertEquals(1.07374222E9d, bounds2D20.getCenterY());
    assertEquals(1.07374222E9d, bounds2D32.getCenterY());
    assertEquals(1.07374222E9d, bounds17.getCenterY());
    assertEquals(1.07374222E9d, bounds13.getCenterY());
    assertEquals(1.07374222E9d, bounds18.getCenterY());
    assertEquals(1.07374222E9d, bounds10.getCenterY());
    assertEquals(1.07374222E9d, bounds19.getCenterY());
    assertEquals(1.07374222E9d, bounds20.getCenterY());
    assertEquals(1.07374222E9d, bounds15.getCenterY());
    assertEquals(1.07374222E9d, bounds21.getCenterY());
    assertEquals(1.07374222E9d, frame4.getCenterY());
    assertEquals(1.07374222E9d, frame2.getCenterY());
    assertEquals(1.07374222E9d, frame5.getCenterY());
    assertEquals(1.07374222E9d, frame.getCenterY());
    assertEquals(1.07374222E9d, frame3.getCenterY());
    assertEquals(1.07374222E9d, frame6.getCenterY());
    assertEquals(1.07374222E9d, frame7.getCenterY());
    assertEquals(1.07374222E9d, frame8.getCenterY());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(2.147482856E9d, size4.getHeight());
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(2.147482856E9d, size7.getHeight());
    assertEquals(2.147482856E9d, size3.getHeight());
    Dimension size8 = bounds3.getSize();
    Dimension size9 = size8.getSize();
    assertEquals(2.147482856E9d, size9.getHeight());
    assertEquals(2.147482856E9d, size6.getHeight());
    assertEquals(2.147482856E9d, size2.getHeight());
    Dimension size10 = bounds7.getSize();
    Dimension size11 = size10.getSize();
    assertEquals(2.147482856E9d, size11.getHeight());
    Dimension size12 = bounds10.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(2.147482856E9d, size13.getHeight());
    Dimension size14 = ((Rectangle) bounds2D10).getSize();
    Dimension size15 = size14.getSize();
    assertEquals(2.147482856E9d, size15.getHeight());
    Dimension size16 = bounds5.getSize();
    assertEquals(2.147482856E9d, size16.getHeight());
    Dimension size17 = bounds4.getSize();
    assertEquals(2.147482856E9d, size17.getHeight());
    assertEquals(2.147482856E9d, size8.getHeight());
    assertEquals(2.147482856E9d, size5.getHeight());
    Dimension size18 = bounds8.getSize();
    assertEquals(2.147482856E9d, size18.getHeight());
    Dimension size19 = bounds11.getSize();
    assertEquals(2.147482856E9d, size19.getHeight());
    assertEquals(2.147482856E9d, size.getHeight());
    assertEquals(2.147482856E9d, size10.getHeight());
    Dimension size20 = bounds13.getSize();
    assertEquals(2.147482856E9d, size20.getHeight());
    assertEquals(2.147482856E9d, size12.getHeight());
    Dimension size21 = bounds15.getSize();
    assertEquals(2.147482856E9d, size21.getHeight());
    Dimension size22 = ((Rectangle) bounds2D8).getSize();
    assertEquals(2.147482856E9d, size22.getHeight());
    assertEquals(2.147482856E9d, size14.getHeight());
    assertEquals(2.147482856E9d, bounds6.getHeight());
    assertEquals(2.147482856E9d, bounds5.getHeight());
    assertEquals(2.147482856E9d, bounds4.getHeight());
    assertEquals(2.147482856E9d, bounds3.getHeight());
    assertEquals(2.147482856E9d, bounds9.getHeight());
    assertEquals(2.147482856E9d, bounds12.getHeight());
    assertEquals(2.147482856E9d, bounds2.getHeight());
    assertEquals(2.147482856E9d, bounds8.getHeight());
    assertEquals(2.147482856E9d, bounds14.getHeight());
    assertEquals(2.147482856E9d, bounds11.getHeight());
    assertEquals(2.147482856E9d, bounds16.getHeight());
    assertEquals(2.147482856E9d, bounds.getHeight());
    assertEquals(2.147482856E9d, bounds7.getHeight());
    assertEquals(2.147482856E9d, bounds17.getHeight());
    assertEquals(2.147482856E9d, bounds13.getHeight());
    assertEquals(2.147482856E9d, bounds18.getHeight());
    assertEquals(2.147482856E9d, bounds10.getHeight());
    assertEquals(2.147482856E9d, bounds19.getHeight());
    assertEquals(2.147482856E9d, bounds20.getHeight());
    assertEquals(2.147482856E9d, bounds15.getHeight());
    assertEquals(2.147482856E9d, bounds21.getHeight());
    assertEquals(2.147482856E9d, bounds2D3.getHeight());
    assertEquals(2.147482856E9d, bounds2D4.getHeight());
    assertEquals(2.147482856E9d, bounds2D8.getHeight());
    assertEquals(2.147482856E9d, bounds2D10.getHeight());
    assertEquals(2.147482856E9d, bounds2D14.getHeight());
    assertEquals(2.147482856E9d, bounds2D19.getHeight());
    assertEquals(2.147482856E9d, bounds2D17.getHeight());
    assertEquals(2.147482856E9d, bounds2D6.getHeight());
    assertEquals(2.147482856E9d, bounds2D28.getHeight());
    assertEquals(2.147482856E9d, bounds2D20.getHeight());
    assertEquals(2.147482856E9d, bounds2D32.getHeight());
    assertEquals(2.147482856E9d, frame4.getHeight());
    assertEquals(2.147482856E9d, frame2.getHeight());
    assertEquals(2.147482856E9d, frame5.getHeight());
    assertEquals(2.147482856E9d, frame.getHeight());
    assertEquals(2.147482856E9d, frame3.getHeight());
    assertEquals(2.147482856E9d, frame6.getHeight());
    assertEquals(2.147482856E9d, frame7.getHeight());
    assertEquals(2.147482856E9d, frame8.getHeight());
    assertEquals(2.147483648E9d, currentPoint.getY());
    assertEquals(2.147483648E9d, bounds6.getMaxY());
    assertEquals(2.147483648E9d, bounds5.getMaxY());
    assertEquals(2.147483648E9d, bounds4.getMaxY());
    assertEquals(2.147483648E9d, bounds3.getMaxY());
    assertEquals(2.147483648E9d, bounds9.getMaxY());
    assertEquals(2.147483648E9d, bounds12.getMaxY());
    assertEquals(2.147483648E9d, bounds2.getMaxY());
    assertEquals(2.147483648E9d, bounds8.getMaxY());
    assertEquals(2.147483648E9d, bounds14.getMaxY());
    assertEquals(2.147483648E9d, bounds11.getMaxY());
    assertEquals(2.147483648E9d, bounds16.getMaxY());
    assertEquals(2.147483648E9d, bounds2D4.getMaxY());
    assertEquals(2.147483648E9d, bounds2D8.getMaxY());
    assertEquals(2.147483648E9d, bounds2D10.getMaxY());
    assertEquals(2.147483648E9d, bounds2D14.getMaxY());
    assertEquals(2.147483648E9d, bounds2D19.getMaxY());
    assertEquals(2.147483648E9d, bounds2D17.getMaxY());
    assertEquals(2.147483648E9d, bounds.getMaxY());
    assertEquals(2.147483648E9d, bounds2D6.getMaxY());
    assertEquals(2.147483648E9d, bounds7.getMaxY());
    assertEquals(2.147483648E9d, bounds2D28.getMaxY());
    assertEquals(2.147483648E9d, bounds2D20.getMaxY());
    assertEquals(2.147483648E9d, bounds2D32.getMaxY());
    assertEquals(2.147483648E9d, bounds17.getMaxY());
    assertEquals(2.147483648E9d, bounds13.getMaxY());
    assertEquals(2.147483648E9d, bounds18.getMaxY());
    assertEquals(2.147483648E9d, bounds10.getMaxY());
    assertEquals(2.147483648E9d, bounds19.getMaxY());
    assertEquals(2.147483648E9d, bounds20.getMaxY());
    assertEquals(2.147483648E9d, bounds15.getMaxY());
    assertEquals(2.147483648E9d, bounds21.getMaxY());
    assertEquals(2.147483648E9d, frame4.getMaxY());
    assertEquals(2.147483648E9d, frame2.getMaxY());
    assertEquals(2.147483648E9d, frame5.getMaxY());
    assertEquals(2.147483648E9d, frame.getMaxY());
    assertEquals(2.147483648E9d, frame3.getMaxY());
    assertEquals(2.147483648E9d, frame6.getMaxY());
    assertEquals(2.147483648E9d, frame7.getMaxY());
    assertEquals(2.147483648E9d, frame8.getMaxY());
    assertEquals(2147482856, size4.getSize().height);
    assertEquals(2147482856, size7.getSize().height);
    assertEquals(2147482856, size4.height);
    assertEquals(2147482856, size9.getSize().height);
    assertEquals(2147482856, size7.height);
    assertEquals(2147482856, size3.height);
    assertEquals(2147482856, size11.getSize().height);
    assertEquals(2147482856, size13.getSize().height);
    assertEquals(2147482856, size15.getSize().height);
    assertEquals(2147482856, size16.getSize().height);
    assertEquals(2147482856, size17.getSize().height);
    assertEquals(2147482856, size9.height);
    assertEquals(2147482856, size6.height);
    assertEquals(2147482856, size18.getSize().height);
    assertEquals(2147482856, size19.getSize().height);
    assertEquals(2147482856, size2.height);
    assertEquals(2147482856, size11.height);
    assertEquals(2147482856, size20.getSize().height);
    assertEquals(2147482856, size13.height);
    assertEquals(2147482856, size21.getSize().height);
    assertEquals(2147482856, size22.getSize().height);
    assertEquals(2147482856, size15.height);
    assertEquals(2147482856, bounds6.getSize().height);
    assertEquals(2147482856, size16.height);
    assertEquals(2147482856, size17.height);
    assertEquals(2147482856, size8.height);
    assertEquals(2147482856, bounds9.getSize().height);
    assertEquals(2147482856, bounds12.getSize().height);
    assertEquals(2147482856, size5.height);
    assertEquals(2147482856, size18.height);
    assertEquals(2147482856, bounds14.getSize().height);
    assertEquals(2147482856, size19.height);
    assertEquals(2147482856, bounds16.getSize().height);
    assertEquals(2147482856, size.height);
    assertEquals(2147482856, size10.height);
    assertEquals(2147482856, bounds17.getSize().height);
    assertEquals(2147482856, size20.height);
    assertEquals(2147482856, bounds18.getSize().height);
    assertEquals(2147482856, size12.height);
    assertEquals(2147482856, bounds19.getSize().height);
    assertEquals(2147482856, bounds20.getSize().height);
    assertEquals(2147482856, size21.height);
    assertEquals(2147482856, bounds21.getSize().height);
    assertEquals(2147482856, ((Rectangle) bounds2D4).getSize().height);
    assertEquals(2147482856, size22.height);
    assertEquals(2147482856, size14.height);
    assertEquals(2147482856, ((Rectangle) bounds2D14).getSize().height);
    assertEquals(2147482856, ((Rectangle) bounds2D19).getSize().height);
    assertEquals(2147482856, ((Rectangle) bounds2D28).getSize().height);
    Rectangle bounds22 = bounds6.getBounds();
    assertEquals(2147482856, bounds22.height);
    assertEquals(2147482856, bounds6.height);
    assertEquals(2147482856, bounds5.height);
    assertEquals(2147482856, bounds4.height);
    Rectangle bounds23 = bounds9.getBounds();
    assertEquals(2147482856, bounds23.height);
    Rectangle bounds24 = bounds12.getBounds();
    assertEquals(2147482856, bounds24.height);
    assertEquals(2147482856, bounds3.height);
    assertEquals(2147482856, bounds9.height);
    Rectangle bounds25 = bounds14.getBounds();
    assertEquals(2147482856, bounds25.height);
    assertEquals(2147482856, bounds12.height);
    Rectangle bounds26 = bounds16.getBounds();
    assertEquals(2147482856, bounds26.height);
    assertEquals(2147482856, bounds2.height);
    assertEquals(2147482856, bounds8.height);
    Rectangle bounds27 = bounds17.getBounds();
    assertEquals(2147482856, bounds27.height);
    assertEquals(2147482856, bounds14.height);
    Rectangle bounds28 = bounds18.getBounds();
    assertEquals(2147482856, bounds28.height);
    assertEquals(2147482856, bounds11.height);
    Rectangle bounds29 = bounds19.getBounds();
    assertEquals(2147482856, bounds29.height);
    Rectangle bounds30 = bounds20.getBounds();
    assertEquals(2147482856, bounds30.height);
    assertEquals(2147482856, bounds16.height);
    Rectangle bounds31 = bounds21.getBounds();
    assertEquals(2147482856, bounds31.height);
    assertEquals(2147482856, bounds.height);
    assertEquals(2147482856, bounds7.height);
    Rectangle bounds32 = bounds2D3.getBounds();
    assertEquals(2147482856, bounds32.height);
    Rectangle bounds33 = bounds2D4.getBounds();
    assertEquals(2147482856, bounds33.height);
    assertEquals(2147482856, bounds17.height);
    assertEquals(2147482856, bounds13.height);
    Rectangle bounds34 = bounds2D14.getBounds();
    assertEquals(2147482856, bounds34.height);
    Rectangle bounds35 = bounds2D19.getBounds();
    assertEquals(2147482856, bounds35.height);
    assertEquals(2147482856, bounds18.height);
    assertEquals(2147482856, bounds10.height);
    Rectangle bounds36 = bounds2D28.getBounds();
    assertEquals(2147482856, bounds36.height);
    assertEquals(2147482856, bounds19.height);
    Rectangle bounds37 = bounds2D32.getBounds();
    assertEquals(2147482856, bounds37.height);
    Rectangle bounds38 = frame4.getBounds();
    assertEquals(2147482856, bounds38.height);
    assertEquals(2147482856, bounds20.height);
    Rectangle bounds39 = frame5.getBounds();
    assertEquals(2147482856, bounds39.height);
    assertEquals(2147482856, bounds15.height);
    assertEquals(2147482856, bounds21.height);
    Rectangle bounds40 = frame6.getBounds();
    assertEquals(2147482856, bounds40.height);
    Rectangle bounds41 = frame7.getBounds();
    assertEquals(2147482856, bounds41.height);
    Rectangle bounds42 = frame8.getBounds();
    assertEquals(2147482856, bounds42.height);
    assertEquals(2147482856, ((Rectangle) bounds2D).height);
    assertEquals(2147482856, ((Rectangle) bounds2D2).height);
    assertEquals(2147482856, ((Rectangle) bounds2D3).height);
    assertEquals(2147482856, ((Rectangle) bounds2D4).height);
    assertEquals(2147482856, ((Rectangle) bounds2D5).height);
    assertEquals(2147482856, ((Rectangle) bounds2D7).height);
    assertEquals(2147482856, ((Rectangle) bounds2D8).height);
    assertEquals(2147482856, ((Rectangle) bounds2D9).height);
    assertEquals(2147482856, ((Rectangle) bounds2D11).height);
    assertEquals(2147482856, ((Rectangle) bounds2D12).height);
    assertEquals(2147482856, ((Rectangle) bounds2D13).height);
    assertEquals(2147482856, ((Rectangle) bounds2D10).height);
    assertEquals(2147482856, ((Rectangle) bounds2D14).height);
    assertEquals(2147482856, ((Rectangle) bounds2D15).height);
    assertEquals(2147482856, ((Rectangle) bounds2D16).height);
    assertEquals(2147482856, ((Rectangle) bounds2D18).height);
    assertEquals(2147482856, ((Rectangle) bounds2D19).height);
    assertEquals(2147482856, ((Rectangle) bounds2D21).height);
    assertEquals(2147482856, ((Rectangle) bounds2D22).height);
    assertEquals(2147482856, ((Rectangle) bounds2D23).height);
    assertEquals(2147482856, ((Rectangle) bounds2D24).height);
    assertEquals(2147482856, ((Rectangle) bounds2D25).height);
    assertEquals(2147482856, ((Rectangle) bounds2D26).height);
    assertEquals(2147482856, ((Rectangle) bounds2D27).height);
    assertEquals(2147482856, ((Rectangle) bounds2D28).height);
    assertEquals(2147482856, ((Rectangle) bounds2D29).height);
    assertEquals(2147482856, ((Rectangle) bounds2D30).height);
    assertEquals(2147482856, ((Rectangle) bounds2D31).height);
    Point location = bounds.getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    Point location4 = location3.getLocation();
    assertEquals(792, location4.getLocation().y);
    Point location5 = bounds2.getLocation();
    Point location6 = location5.getLocation();
    Point location7 = location6.getLocation();
    assertEquals(792, location7.getLocation().y);
    assertEquals(792, location4.y);
    Point location8 = bounds3.getLocation();
    Point location9 = location8.getLocation();
    assertEquals(792, location9.getLocation().y);
    assertEquals(792, location7.y);
    assertEquals(792, location3.y);
    Point location10 = bounds7.getLocation();
    Point location11 = location10.getLocation();
    assertEquals(792, location11.getLocation().y);
    Point location12 = bounds10.getLocation();
    Point location13 = location12.getLocation();
    assertEquals(792, location13.getLocation().y);
    Point location14 = ((Rectangle) bounds2D10).getLocation();
    Point location15 = location14.getLocation();
    assertEquals(792, location15.getLocation().y);
    Point location16 = bounds5.getLocation();
    assertEquals(792, location16.getLocation().y);
    Point location17 = bounds4.getLocation();
    assertEquals(792, location17.getLocation().y);
    assertEquals(792, location9.y);
    assertEquals(792, location6.y);
    Point location18 = bounds8.getLocation();
    assertEquals(792, location18.getLocation().y);
    Point location19 = bounds11.getLocation();
    assertEquals(792, location19.getLocation().y);
    assertEquals(792, location2.y);
    assertEquals(792, location11.y);
    Point location20 = bounds13.getLocation();
    assertEquals(792, location20.getLocation().y);
    assertEquals(792, location13.y);
    Point location21 = bounds15.getLocation();
    assertEquals(792, location21.getLocation().y);
    Point location22 = ((Rectangle) bounds2D8).getLocation();
    assertEquals(792, location22.getLocation().y);
    assertEquals(792, location15.y);
    assertEquals(792, bounds6.getLocation().y);
    assertEquals(792, location16.y);
    assertEquals(792, location17.y);
    assertEquals(792, location8.y);
    assertEquals(792, bounds9.getLocation().y);
    assertEquals(792, bounds12.getLocation().y);
    assertEquals(792, location5.y);
    assertEquals(792, location18.y);
    assertEquals(792, bounds14.getLocation().y);
    assertEquals(792, location19.y);
    assertEquals(792, bounds16.getLocation().y);
    assertEquals(792, location.y);
    assertEquals(792, location10.y);
    assertEquals(792, bounds17.getLocation().y);
    assertEquals(792, location20.y);
    assertEquals(792, bounds18.getLocation().y);
    assertEquals(792, location12.y);
    assertEquals(792, bounds19.getLocation().y);
    assertEquals(792, bounds20.getLocation().y);
    assertEquals(792, location21.y);
    assertEquals(792, bounds21.getLocation().y);
    assertEquals(792, ((Rectangle) bounds2D3).getLocation().y);
    assertEquals(792, ((Rectangle) bounds2D4).getLocation().y);
    assertEquals(792, location22.y);
    assertEquals(792, location14.y);
    assertEquals(792, ((Rectangle) bounds2D14).getLocation().y);
    assertEquals(792, ((Rectangle) bounds2D19).getLocation().y);
    assertEquals(792, ((Rectangle) bounds2D28).getLocation().y);
    assertEquals(792, bounds22.y);
    assertEquals(792, bounds6.y);
    assertEquals(792, bounds5.y);
    assertEquals(792, bounds4.y);
    assertEquals(792, bounds23.y);
    assertEquals(792, bounds24.y);
    assertEquals(792, bounds3.y);
    assertEquals(792, bounds9.y);
    assertEquals(792, bounds25.y);
    assertEquals(792, bounds12.y);
    assertEquals(792, bounds26.y);
    assertEquals(792, bounds2.y);
    assertEquals(792, bounds8.y);
    assertEquals(792, bounds27.y);
    assertEquals(792, bounds14.y);
    assertEquals(792, bounds28.y);
    assertEquals(792, bounds11.y);
    assertEquals(792, bounds29.y);
    assertEquals(792, bounds30.y);
    assertEquals(792, bounds16.y);
    assertEquals(792, bounds31.y);
    assertEquals(792, bounds.y);
    assertEquals(792, bounds7.y);
    assertEquals(792, bounds32.y);
    assertEquals(792, bounds33.y);
    assertEquals(792, bounds17.y);
    assertEquals(792, bounds13.y);
    assertEquals(792, bounds34.y);
    assertEquals(792, bounds35.y);
    assertEquals(792, bounds18.y);
    assertEquals(792, bounds10.y);
    assertEquals(792, bounds36.y);
    assertEquals(792, bounds19.y);
    assertEquals(792, bounds37.y);
    assertEquals(792, bounds38.y);
    assertEquals(792, bounds20.y);
    assertEquals(792, bounds39.y);
    assertEquals(792, bounds15.y);
    assertEquals(792, bounds21.y);
    assertEquals(792, bounds40.y);
    assertEquals(792, bounds41.y);
    assertEquals(792, bounds42.y);
    assertEquals(792, ((Rectangle) bounds2D).y);
    assertEquals(792, ((Rectangle) bounds2D2).y);
    assertEquals(792, ((Rectangle) bounds2D3).y);
    assertEquals(792, ((Rectangle) bounds2D4).y);
    assertEquals(792, ((Rectangle) bounds2D5).y);
    assertEquals(792, ((Rectangle) bounds2D7).y);
    assertEquals(792, ((Rectangle) bounds2D8).y);
    assertEquals(792, ((Rectangle) bounds2D9).y);
    assertEquals(792, ((Rectangle) bounds2D11).y);
    assertEquals(792, ((Rectangle) bounds2D12).y);
    assertEquals(792, ((Rectangle) bounds2D13).y);
    assertEquals(792, ((Rectangle) bounds2D10).y);
    assertEquals(792, ((Rectangle) bounds2D14).y);
    assertEquals(792, ((Rectangle) bounds2D15).y);
    assertEquals(792, ((Rectangle) bounds2D16).y);
    assertEquals(792, ((Rectangle) bounds2D18).y);
    assertEquals(792, ((Rectangle) bounds2D19).y);
    assertEquals(792, ((Rectangle) bounds2D21).y);
    assertEquals(792, ((Rectangle) bounds2D22).y);
    assertEquals(792, ((Rectangle) bounds2D23).y);
    assertEquals(792, ((Rectangle) bounds2D24).y);
    assertEquals(792, ((Rectangle) bounds2D25).y);
    assertEquals(792, ((Rectangle) bounds2D26).y);
    assertEquals(792, ((Rectangle) bounds2D27).y);
    assertEquals(792, ((Rectangle) bounds2D28).y);
    assertEquals(792, ((Rectangle) bounds2D29).y);
    assertEquals(792, ((Rectangle) bounds2D30).y);
    assertEquals(792, ((Rectangle) bounds2D31).y);
    assertEquals(792.0d, location4.getY());
    assertEquals(792.0d, location7.getY());
    assertEquals(792.0d, location3.getY());
    assertEquals(792.0d, location9.getY());
    assertEquals(792.0d, location6.getY());
    assertEquals(792.0d, location2.getY());
    assertEquals(792.0d, location11.getY());
    assertEquals(792.0d, location13.getY());
    assertEquals(792.0d, location15.getY());
    assertEquals(792.0d, location16.getY());
    assertEquals(792.0d, location17.getY());
    assertEquals(792.0d, location8.getY());
    assertEquals(792.0d, location5.getY());
    assertEquals(792.0d, location18.getY());
    assertEquals(792.0d, location19.getY());
    assertEquals(792.0d, location.getY());
    assertEquals(792.0d, location10.getY());
    assertEquals(792.0d, location20.getY());
    assertEquals(792.0d, location12.getY());
    assertEquals(792.0d, location21.getY());
    assertEquals(792.0d, location22.getY());
    assertEquals(792.0d, location14.getY());
    assertEquals(792.0d, bounds6.getY());
    assertEquals(792.0d, bounds5.getY());
    assertEquals(792.0d, bounds4.getY());
    assertEquals(792.0d, bounds3.getY());
    assertEquals(792.0d, bounds9.getY());
    assertEquals(792.0d, bounds12.getY());
    assertEquals(792.0d, bounds2.getY());
    assertEquals(792.0d, bounds8.getY());
    assertEquals(792.0d, bounds14.getY());
    assertEquals(792.0d, bounds11.getY());
    assertEquals(792.0d, bounds16.getY());
    assertEquals(792.0d, bounds.getY());
    assertEquals(792.0d, bounds7.getY());
    assertEquals(792.0d, bounds17.getY());
    assertEquals(792.0d, bounds13.getY());
    assertEquals(792.0d, bounds18.getY());
    assertEquals(792.0d, bounds10.getY());
    assertEquals(792.0d, bounds19.getY());
    assertEquals(792.0d, bounds20.getY());
    assertEquals(792.0d, bounds15.getY());
    assertEquals(792.0d, bounds21.getY());
    assertEquals(792.0d, bounds6.getMinY());
    assertEquals(792.0d, bounds5.getMinY());
    assertEquals(792.0d, bounds4.getMinY());
    assertEquals(792.0d, bounds3.getMinY());
    assertEquals(792.0d, bounds9.getMinY());
    assertEquals(792.0d, bounds12.getMinY());
    assertEquals(792.0d, bounds2.getMinY());
    assertEquals(792.0d, bounds8.getMinY());
    assertEquals(792.0d, bounds14.getMinY());
    assertEquals(792.0d, bounds11.getMinY());
    assertEquals(792.0d, bounds16.getMinY());
    assertEquals(792.0d, bounds2D4.getMinY());
    assertEquals(792.0d, bounds2D8.getMinY());
    assertEquals(792.0d, bounds2D10.getMinY());
    assertEquals(792.0d, bounds2D14.getMinY());
    assertEquals(792.0d, bounds2D19.getMinY());
    assertEquals(792.0d, bounds2D17.getMinY());
    assertEquals(792.0d, bounds.getMinY());
    assertEquals(792.0d, bounds2D6.getMinY());
    assertEquals(792.0d, bounds7.getMinY());
    assertEquals(792.0d, bounds2D28.getMinY());
    assertEquals(792.0d, bounds2D20.getMinY());
    assertEquals(792.0d, bounds2D32.getMinY());
    assertEquals(792.0d, bounds17.getMinY());
    assertEquals(792.0d, bounds13.getMinY());
    assertEquals(792.0d, bounds18.getMinY());
    assertEquals(792.0d, bounds10.getMinY());
    assertEquals(792.0d, bounds19.getMinY());
    assertEquals(792.0d, bounds20.getMinY());
    assertEquals(792.0d, bounds15.getMinY());
    assertEquals(792.0d, bounds21.getMinY());
    assertEquals(792.0d, frame4.getMinY());
    assertEquals(792.0d, frame2.getMinY());
    assertEquals(792.0d, frame5.getMinY());
    assertEquals(792.0d, frame.getMinY());
    assertEquals(792.0d, frame3.getMinY());
    assertEquals(792.0d, frame6.getMinY());
    assertEquals(792.0d, frame7.getMinY());
    assertEquals(792.0d, frame8.getMinY());
    assertEquals(792.0d, bounds2D4.getY());
    assertEquals(792.0d, bounds2D8.getY());
    assertEquals(792.0d, bounds2D10.getY());
    assertEquals(792.0d, bounds2D14.getY());
    assertEquals(792.0d, bounds2D19.getY());
    assertEquals(792.0d, bounds2D17.getY());
    assertEquals(792.0d, bounds2D6.getY());
    assertEquals(792.0d, bounds2D28.getY());
    assertEquals(792.0d, bounds2D20.getY());
    assertEquals(792.0d, bounds2D32.getY());
    assertEquals(792.0d, frame4.getY());
    assertEquals(792.0d, frame2.getY());
    assertEquals(792.0d, frame5.getY());
    assertEquals(792.0d, frame.getY());
    assertEquals(792.0d, frame3.getY());
    assertEquals(792.0d, frame6.getY());
    assertEquals(792.0d, frame7.getY());
    assertEquals(792.0d, frame8.getY());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage6() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDStream contents = new PDStream(new COSDocument());
    ArrayList<COSName> filters = new ArrayList<>();
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    COSBase cOSObject = legacyPDFStreamEngine.getGraphicsState().getLineDashPattern().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(filters, ((COSArray) getResult).toList());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage7() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    Rectangle bounds = legacyPDFStreamEngine.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle bounds4 = bounds2D2.getBounds();
    Rectangle2D bounds2D3 = bounds4.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D frame = bounds3.getFrame();
    Rectangle2D bounds2D4 = frame.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds4.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = frame.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Point location = bounds4.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    Point location2 = bounds3.getLocation().getLocation();
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location2.getY());
    assertEquals(0.0d, bounds2D.getMinX());
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, bounds2D.getMinY());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, bounds2D.getX());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, bounds2D.getY());
    assertEquals(0.0d, frame.getY());
    assertEquals(306.0d, bounds4.getCenterX());
    assertEquals(306.0d, frame.getCenterX());
    assertEquals(396.0d, bounds4.getCenterY());
    assertEquals(396.0d, frame.getCenterY());
    Dimension size = ((Rectangle) bounds2D).getSize();
    assertEquals(612, size.width);
    Dimension size2 = bounds3.getSize().getSize();
    assertEquals(612.0d, size2.getWidth());
    assertEquals(612.0d, bounds4.getMaxX());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, bounds2D.getWidth());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792, size.height);
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, bounds4.getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, bounds2D.getMaxY());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(bounds2D.isEmpty());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, bounds4.getBounds());
    assertEquals(bounds, frame.getBounds());
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, bounds2D4);
    assertEquals(bounds, frame2);
    assertEquals(bounds, frame3);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList()")
  void testProcessPage_givenArrayList() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D bounds2D = bounds2.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    Rectangle bounds3 = frame.getBounds();
    Rectangle2D bounds2D2 = bounds3.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds3.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    COSBase cOSObject = graphicsState.getLineDashPattern().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    Point location = bounds3.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0.0d, bounds2.getLocation().getLocation().getLocation().getX());
    Point location2 = ((Rectangle) bounds2D).getLocation();
    assertEquals(0.0d, location2.getX());
    assertEquals(0.0d, location2.getY());
    assertEquals(0.0d, bounds3.getX());
    Rectangle bounds4 = bounds2D.getBounds();
    assertEquals(0.0d, bounds4.getY());
    assertEquals(0.0d, bounds3.getY());
    assertEquals(0.0d, bounds3.getMinX());
    assertEquals(0.0d, bounds3.getMinY());
    assertEquals(306.0d, bounds3.getCenterX());
    assertEquals(396.0d, bounds3.getCenterY());
    Dimension size = bounds3.getSize();
    assertEquals(612, size.width);
    Dimension size2 = ((Rectangle) bounds2D).getSize();
    assertEquals(612.0d, size2.getWidth());
    assertEquals(612.0d, bounds3.getWidth());
    assertEquals(612.0d, bounds3.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792.0d, size2.getHeight());
    assertEquals(792.0d, bounds3.getHeight());
    assertEquals(792.0d, bounds3.getMaxY());
    assertFalse(bounds4.isEmpty());
    assertFalse(bounds3.isEmpty());
    assertEquals(contents, ((COSArray) getResult).toList());
    assertEquals(bounds, bounds3.getBounds());
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList() add 'null'")
  void testProcessPage_givenArrayListAddNull() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    Rectangle2D bounds2D = legacyPDFStreamEngine.getGraphicsState()
        .getCurrentClippingPath()
        .getBounds()
        .getBounds()
        .getBounds()
        .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(792, size.height);
    assertEquals(792.0d, bounds.getMaxY());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testProcessPage_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    Rectangle2D bounds2D = legacyPDFStreamEngine.getGraphicsState()
        .getCurrentClippingPath()
        .getBounds()
        .getBounds()
        .getBounds()
        .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(792, size.height);
    assertEquals(792.0d, bounds.getMaxY());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given PDStream(COSDocument) with document is COSDocument()")
  void testProcessPage_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    Rectangle2D bounds2D = legacyPDFStreamEngine.getGraphicsState()
        .getCurrentClippingPath()
        .getBounds()
        .getBounds()
        .getBounds()
        .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(792, size.height);
    assertEquals(792.0d, bounds.getMaxY());
  }

  /**
   * Test {@link LegacyPDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyPDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showGlyph(Matrix, PDFont, int, Vector); given IOException(String) with 'foo'; then throw IOException")
  void testShowGlyph_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDFont font = mock(PDFont.class);
    when(font.getWidth(anyInt())).thenThrow(new IOException("foo"));
    when(font.isVertical()).thenReturn(true);

    // Act and Assert
    assertThrows(IOException.class,
        () -> legacyPDFStreamEngine.showGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
    verify(font).getWidth(eq(1));
    verify(font).isVertical();
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testComputeFontHeight_whenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.6730957f, legacyPDFStreamEngine.computeFontHeight(new PDMMType1Font(new COSDictionary())));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testComputeFontHeight_whenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.6730957f, legacyPDFStreamEngine.computeFontHeight(new PDTrueTypeFont(new COSDictionary())));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code SYMBOL}.</li>
   *   <li>Then return {@code 0.6515}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDType1Font(FontName) with baseFont is 'SYMBOL'; then return '0.6515'")
  void testComputeFontHeight_whenPDType1FontWithBaseFontIsSymbol_thenReturn06515() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act and Assert
    assertEquals(0.6515f, legacyPDFStreamEngine.computeFontHeight(new PDType1Font(Standard14Fonts.FontName.SYMBOL)));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code 0.558}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return '0.558'")
  void testComputeFontHeight_whenPDType1FontWithBaseFontIsTimesRoman_thenReturn0558() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act and Assert
    assertEquals(0.558f,
        legacyPDFStreamEngine.computeFontHeight(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testComputeFontHeight_whenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.0f, legacyPDFStreamEngine.computeFontHeight(new PDType3Font(new COSDictionary())));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testComputeFontHeight_whenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.0f, legacyPDFStreamEngine.computeFontHeight(new PDType3Font(new COSStream())));
  }
}
