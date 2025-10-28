package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.GlyphTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.IndexToLocationTable;
import org.apache.fontbox.ttf.KerningTable;
import org.apache.fontbox.ttf.MaximumProfileTable;
import org.apache.fontbox.ttf.NameRecord;
import org.apache.fontbox.ttf.NamingTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDType1CFontDiffblueTest {
  /**
   * Method under test: {@link PDType1CFont#getBaseFont()}
   */
  @Test
  void testGetBaseFont() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1CFont(new COSDictionary())).getBaseFont());
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  void testGetPath() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  void testGetPath2() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath(46);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-29, location.y);
    assertEquals(-29, bounds.y);
    assertEquals(-29.0d, location.getY());
    assertEquals(-29.0d, bounds.getY());
    assertEquals(-29.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(135, location.x);
    assertEquals(135, bounds.x);
    assertEquals(135.0d, location.getX());
    assertEquals(135.0d, bounds.getX());
    assertEquals(135.0d, bounds.getMinX());
    assertEquals(213.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(242, size.height);
    assertEquals(242, size.width);
    assertEquals(242, bounds.height);
    assertEquals(242, bounds.width);
    assertEquals(242.0d, size.getHeight());
    assertEquals(242.0d, size.getWidth());
    assertEquals(242.0d, bounds.getHeight());
    assertEquals(242.0d, bounds.getWidth());
    assertEquals(256.0d, bounds.getCenterX());
    assertEquals(377.0d, currentPoint.getX());
    assertEquals(377.0d, bounds.getMaxX());
    assertEquals(377.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(92.0d, currentPoint.getY());
    assertEquals(92.0d, bounds.getCenterY());
    assertEquals(92.0f, ((Point2D.Float) currentPoint).y);
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  void testGetPath3() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(0, location.y);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(136.0d, currentPoint.getX());
    assertEquals(136.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(1365, size.height);
    assertEquals(1365, bounds.height);
    assertEquals(1365.0d, size.getHeight());
    assertEquals(1365.0d, bounds.getHeight());
    assertEquals(1365.0d, bounds.getMaxY());
    assertEquals(340.0d, bounds.getCenterX());
    assertEquals(544, size.width);
    assertEquals(544, bounds.width);
    assertEquals(544.0d, size.getWidth());
    assertEquals(544.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(68, location.x);
    assertEquals(68, bounds.x);
    assertEquals(68.0d, location.getX());
    assertEquals(68.0d, bounds.getX());
    assertEquals(68.0d, currentPoint.getY());
    assertEquals(68.0d, bounds.getMinX());
    assertEquals(68.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(682.5d, bounds.getCenterY());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  void testGetPath4() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("g9");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-20, location.y);
    assertEquals(-20, bounds.y);
    assertEquals(-20.0d, location.getY());
    assertEquals(-20.0d, bounds.getY());
    assertEquals(-20.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(1090.0d, currentPoint.getY());
    assertEquals(1090.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1362.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(1382, size.height);
    assertEquals(1382, bounds.height);
    assertEquals(1382.0d, size.getHeight());
    assertEquals(1382.0d, bounds.getHeight());
    assertEquals(1478, size.width);
    assertEquals(1478, bounds.width);
    assertEquals(1478.0d, size.getWidth());
    assertEquals(1478.0d, bounds.getWidth());
    assertEquals(1556.0d, bounds.getMaxX());
    assertEquals(434.0d, currentPoint.getX());
    assertEquals(434.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(671.0d, bounds.getCenterY());
    assertEquals(78, location.x);
    assertEquals(78, bounds.x);
    assertEquals(78.0d, location.getX());
    assertEquals(78.0d, bounds.getX());
    assertEquals(78.0d, bounds.getMinX());
    assertEquals(817.0d, bounds.getCenterX());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  void testGetPath5() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath(".notdef");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  void testGetPath6() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("sfthyphen");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(0, location.y);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(136.0d, currentPoint.getX());
    assertEquals(136.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(1365, size.height);
    assertEquals(1365, bounds.height);
    assertEquals(1365.0d, size.getHeight());
    assertEquals(1365.0d, bounds.getHeight());
    assertEquals(1365.0d, bounds.getMaxY());
    assertEquals(340.0d, bounds.getCenterX());
    assertEquals(544, size.width);
    assertEquals(544, bounds.width);
    assertEquals(544.0d, size.getWidth());
    assertEquals(544.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(68, location.x);
    assertEquals(68, bounds.x);
    assertEquals(68.0d, location.getX());
    assertEquals(68.0d, bounds.getX());
    assertEquals(68.0d, currentPoint.getY());
    assertEquals(68.0d, bounds.getMinX());
    assertEquals(68.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(682.5d, bounds.getCenterY());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  void testGetPath7() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("nbspace");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#hasGlyph(int)}
   */
  @Test
  void testHasGlyph() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1CFont(new COSDictionary())).hasGlyph(1));
    assertTrue((new PDType1CFont(new COSDictionary())).hasGlyph(46));
    assertFalse((new PDType1CFont(new COSDictionary())).hasGlyph("Name"));
    assertTrue((new PDType1CFont(new COSDictionary())).hasGlyph("g9"));
    assertTrue((new PDType1CFont(new COSDictionary())).hasGlyph("g942"));
  }

  /**
   * Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  void testGetNormalizedPath() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1CFont(new COSDictionary())).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualNormalizedPath.getCurrentPoint());
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
    assertEquals(1, actualNormalizedPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  void testGetNormalizedPath2() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1CFont(new COSDictionary())).getNormalizedPath(46);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualNormalizedPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-29, location.y);
    assertEquals(-29, bounds.y);
    assertEquals(-29.0d, location.getY());
    assertEquals(-29.0d, bounds.getY());
    assertEquals(-29.0d, bounds.getMinY());
    assertEquals(1, actualNormalizedPath.getWindingRule());
    assertEquals(135, location.x);
    assertEquals(135, bounds.x);
    assertEquals(135.0d, location.getX());
    assertEquals(135.0d, bounds.getX());
    assertEquals(135.0d, bounds.getMinX());
    assertEquals(213.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(242, size.height);
    assertEquals(242, size.width);
    assertEquals(242, bounds.height);
    assertEquals(242, bounds.width);
    assertEquals(242.0d, size.getHeight());
    assertEquals(242.0d, size.getWidth());
    assertEquals(242.0d, bounds.getHeight());
    assertEquals(242.0d, bounds.getWidth());
    assertEquals(256.0d, bounds.getCenterX());
    assertEquals(377.0d, currentPoint.getX());
    assertEquals(377.0d, bounds.getMaxX());
    assertEquals(377.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(92.0d, currentPoint.getY());
    assertEquals(92.0d, bounds.getCenterY());
    assertEquals(92.0f, ((Point2D.Float) currentPoint).y);
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDType1CFont#getName()}
   */
  @Test
  void testGetName() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1CFont(new COSDictionary())).getName());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType1CFont(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox2() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox3() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(2383.937f, actualBoundingBox.getUpperRightX());
    assertEquals(2383.937f, actualBoundingBox.getWidth());
    assertEquals(3370.3938f, actualBoundingBox.getHeight());
    assertEquals(3370.3938f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox4() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle());

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox5() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox6() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightY());
    assertEquals(2.14748365E9f, actualBoundingBox.getWidth());
  }

  /**
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox7() throws IOException {
    // Arrange
    PDRectangle rect = new PDRectangle();
    rect.setLowerLeftY(2.14748365E9f);

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(rect);

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualBoundingBox.getHeight());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDType1CFont#codeToName(int)}
   */
  @Test
  void testCodeToName() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new PDType1CFont(new COSDictionary())).codeToName(1));
  }

  /**
   * Method under test: {@link PDType1CFont#readEncodingFromFont()}
   */
  @Test
  void testReadEncodingFromFont() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());

    // Act
    Encoding actualReadEncodingFromFontResult = pdType1CFont.readEncodingFromFont();

    // Assert
    StandardEncoding standardEncoding = ((StandardEncoding) actualReadEncodingFromFontResult).INSTANCE;
    assertSame(standardEncoding, pdType1CFont.getEncoding());
    assertSame(standardEncoding, actualReadEncodingFromFontResult);
  }

  /**
   * Method under test: {@link PDType1CFont#readCode(InputStream)}
   */
  @Test
  void testReadCode() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65, pdType1CFont.readCode(in));
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDType1CFont#readCode(InputStream)}
   */
  @Test
  void testReadCode2() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenReturn(1);

    // Act
    int actualReadCodeResult = pdType1CFont.readCode(in);

    // Assert
    verify(in).read();
    assertEquals(1, actualReadCodeResult);
  }

  /**
   * Method under test: {@link PDType1CFont#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDType1CFont(new COSDictionary())).getFontMatrix();

    // Assert
    assertEquals(0.0f, actualFontMatrix.getShearX());
    assertEquals(0.0f, actualFontMatrix.getShearY());
    assertEquals(0.0f, actualFontMatrix.getTranslateX());
    assertEquals(0.0f, actualFontMatrix.getTranslateY());
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleY());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorY());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDType1CFont#getWidthFromFont(int)}
   */
  @Test
  void testGetWidthFromFont() throws IOException {
    // Arrange, Act and Assert
    assertEquals(365.23438f, (new PDType1CFont(new COSDictionary())).getWidthFromFont(1));
    assertEquals(250.0f, (new PDType1CFont(new COSDictionary())).getWidthFromFont(46));
  }

  /**
   * Method under test: {@link PDType1CFont#getHeight(int)}
   */
  @Test
  void testGetHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1CFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1CFont(new COSDictionary())).encode(1));
    assertThrows(IllegalArgumentException.class, () -> (new PDType1CFont(new COSDictionary())).encode(0));
  }

  /**
   * Method under test: {@link PDType1CFont#getStringWidth(String)}
   */
  @Test
  void testGetStringWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1CFont(new COSDictionary())).getStringWidth("String"));
  }

  /**
   * Method under test: {@link PDType1CFont#getAverageFontWidth()}
   */
  @Test
  void testGetAverageFontWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(500.0f, (new PDType1CFont(new COSDictionary())).getAverageFontWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDType1CFont#getCFFType1Font()}
   *   <li>{@link PDType1CFont#getFontBoxFont()}
   *   <li>{@link PDType1CFont#isDamaged()}
   *   <li>{@link PDType1CFont#isEmbedded()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());

    // Act
    CFFType1Font actualCFFType1Font = pdType1CFont.getCFFType1Font();
    FontBoxFont actualFontBoxFont = pdType1CFont.getFontBoxFont();
    boolean actualIsDamagedResult = pdType1CFont.isDamaged();

    // Assert
    assertTrue(actualFontBoxFont instanceof TrueTypeFont);
    assertNull(actualCFFType1Font);
    assertFalse(actualIsDamagedResult);
    assertFalse(pdType1CFont.isEmbedded());
  }

  /**
   * Method under test: {@link PDType1CFont#PDType1CFont(COSDictionary)}
   */
  @Test
  void testNewPDType1CFont() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType1CFont actualPdType1CFont = new PDType1CFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdType1CFont.getFontBoxFont();
    HeaderTable header = ((TrueTypeFont) fontBoxFont).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    CmapLookup unicodeCmapLookup = ((TrueTypeFont) fontBoxFont).getUnicodeCmapLookup();
    assertTrue(unicodeCmapLookup instanceof CmapSubtable);
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    Encoding encoding = actualPdType1CFont.getEncoding();
    COSBase cOSObject = encoding.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(encoding instanceof StandardEncoding);
    PostScriptTable postScript = ((TrueTypeFont) fontBoxFont).getPostScript();
    String[] glyphNames = postScript.getGlyphNames();
    assertEquals(".notdef", glyphNames[0]);
    assertEquals(".null", glyphNames[1]);
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) fontBoxFont).getOS2Windows();
    assertEquals("1ASC", oS2Windows.getAchVendId());
    TimeZone timeZone = created.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    NamingTable naming = ((TrueTypeFont) fontBoxFont).getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(28, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals("Copyright (c) 2007 Red Hat, Inc. All rights reserved. LIBERATION is a trademark of Red Hat, Inc.",
        getResult.getString());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) fontBoxFont).getGsub();
    assertEquals("GSUB", gsub.getTag());
    NameRecord getResult2 = nameRecords.get(1);
    assertEquals("Liberation Serif", getResult2.getString());
    assertEquals("Liberation Serif", naming.getFontFamily());
    assertEquals("LiberationSerif", fontBoxFont.getName());
    assertEquals("LiberationSerif", naming.getPostScriptName());
    NameRecord getResult3 = nameRecords.get(26);
    assertEquals("Licensed under the Liberation Fonts license, see https://fedoraproject.org/wiki/Licensing/Liberation"
        + "FontLicense", getResult3.getString());
    assertEquals("OS/2", oS2Windows.getTag());
    assertEquals("Regular", naming.getFontSubFamily());
    assertEquals("StandardEncoding", ((COSName) cOSObject).getName());
    assertEquals("StandardEncoding", encoding.getEncodingName());
    assertEquals("UTC", timeZone.getID());
    assertEquals("afii10066.alt1", glyphNames[663]);
    assertEquals("ampersand", glyphNames[9]);
    assertEquals("asterisk", glyphNames[13]);
    assertEquals("caroncommaaccent", glyphNames[671]);
    assertEquals("club", glyphNames[653]);
    CmapTable cmap = ((TrueTypeFont) fontBoxFont).getCmap();
    assertEquals("cmap", cmap.getTag());
    assertEquals("comma", glyphNames[15]);
    assertEquals("commaaccentrotate", glyphNames[672]);
    assertEquals("cyrillicbreve", glyphNames[670]);
    assertEquals("diamond", glyphNames[655]);
    assertEquals("dollar", glyphNames[7]);
    assertEquals("eightsuperior", glyphNames[669]);
    Map<Integer, String> codeToNameMap = encoding.getCodeToNameMap();
    assertEquals(149, codeToNameMap.size());
    assertEquals("exclam", codeToNameMap.get(33));
    assertEquals("exclam", glyphNames[4]);
    assertEquals("female", glyphNames[650]);
    assertEquals("five", glyphNames[24]);
    assertEquals("fivesuperior", glyphNames[667]);
    assertEquals("four", glyphNames[23]);
    assertEquals("foursuperior", glyphNames[666]);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(19, tableMap.size());
    TTFTable getResult4 = tableMap.get("fpgm");
    assertEquals("fpgm", getResult4.getTag());
    GlyphTable glyph = ((TrueTypeFont) fontBoxFont).getGlyph();
    assertEquals("glyf", glyph.getTag());
    assertEquals("gregory", created.getCalendarType());
    assertEquals("gregory", modified.getCalendarType());
    assertEquals("head", header.getTag());
    assertEquals("heart", glyphNames[654]);
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) fontBoxFont).getHorizontalHeader();
    assertEquals("hhea", horizontalHeader.getTag());
    HorizontalMetricsTable horizontalMetrics = ((TrueTypeFont) fontBoxFont).getHorizontalMetrics();
    assertEquals("hmtx", horizontalMetrics.getTag());
    NameRecord getResult5 = nameRecords.get(27);
    assertEquals("https://fedoraproject.org/wiki/Licensing/LiberationFontLicense", getResult5.getString());
    assertEquals("invsmileface", glyphNames[648]);
    KerningTable kerning = ((TrueTypeFont) fontBoxFont).getKerning();
    assertEquals("kern", kerning.getTag());
    assertEquals("latn", gsubData.getActiveScriptName());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) fontBoxFont).getIndexToLocation();
    assertEquals("loca", indexToLocation.getTag());
    assertEquals("male", glyphNames[651]);
    MaximumProfileTable maximumProfile = ((TrueTypeFont) fontBoxFont).getMaximumProfile();
    assertEquals("maxp", maximumProfile.getTag());
    assertEquals("middot", glyphNames[664]);
    assertEquals("musicalnote", glyphNames[656]);
    assertEquals("musicalnotedbl", glyphNames[657]);
    assertEquals("name", naming.getTag());
    assertEquals("nonmarkingreturn", glyphNames[2]);
    assertEquals("numbersign", codeToNameMap.get(35));
    assertEquals("numbersign", glyphNames[6]);
    assertEquals("one", glyphNames[20]);
    assertEquals("parenleft", glyphNames[11]);
    assertEquals("parenright", glyphNames[PDPanose.LENGTH]);
    assertEquals("percent", glyphNames[8]);
    assertEquals("period", glyphNames[17]);
    assertEquals("pi1", glyphNames[665]);
    assertEquals("plus", glyphNames[14]);
    assertEquals("post", postScript.getTag());
    assertEquals("quotedbl", codeToNameMap.get(34));
    assertEquals("quotedbl", glyphNames[5]);
    assertEquals("quotesingle", glyphNames[PDPanoseClassification.LENGTH]);
    assertEquals("sevensuperior", glyphNames[668]);
    assertEquals("slash", glyphNames[18]);
    assertEquals("space", codeToNameMap.get(Integer.SIZE));
    assertEquals("spade", glyphNames[652]);
    assertEquals("sun", glyphNames[649]);
    assertEquals("three", glyphNames[22]);
    assertEquals("two", glyphNames[21]);
    assertEquals("uni00A0", glyphNames[3]);
    assertEquals("uni00AD", glyphNames[Short.SIZE]);
    assertEquals("uni266C", glyphNames[658]);
    assertEquals("uniF004", glyphNames[661]);
    assertEquals("uniF005", glyphNames[662]);
    assertEquals("uniFB01", glyphNames[659]);
    assertEquals("uniFB02", glyphNames[660]);
    assertEquals("zero", glyphNames[19]);
    assertNull(actualPdType1CFont.getSymbolicFlag());
    assertNull(actualPdType1CFont.getSubType());
    assertNull(actualPdType1CFont.getType());
    assertNull(actualPdType1CFont.getBaseFont());
    assertNull(actualPdType1CFont.getName());
    assertNull(actualPdType1CFont.getStandard14AFM());
    assertNull(actualPdType1CFont.getCFFType1Font());
    assertNull(actualPdType1CFont.getToUnicodeCMap());
    assertNull(((TrueTypeFont) fontBoxFont).getVerticalHeader());
    assertNull(((TrueTypeFont) fontBoxFont).getVerticalMetrics());
    assertNull(((TrueTypeFont) fontBoxFont).getVerticalOrigin());
    assertNull(cOSObject.getKey());
    assertNull(actualPdType1CFont.getFontDescriptor());
    assertEquals((short) -123, postScript.getUnderlinePosition());
    BoundingBox fontBBox = fontBoxFont.getFontBBox();
    assertEquals(-176.75781f, fontBBox.getLowerLeftX());
    BoundingBox boundingBox = actualPdType1CFont.getBoundingBox();
    assertEquals(-176.75781f, boundingBox.getLowerLeftX());
    assertEquals(-303.22266f, fontBBox.getLowerLeftY());
    assertEquals(-303.22266f, boundingBox.getLowerLeftY());
    assertEquals((short) -360, horizontalHeader.getMinRightSideBearing());
    assertEquals((short) -362, header.getXMin());
    assertEquals((short) -362, horizontalHeader.getMinLeftSideBearing());
    assertEquals(-442, oS2Windows.getTypoDescender());
    assertEquals((short) -443, horizontalHeader.getDescender());
    assertEquals((short) -621, header.getYMin());
    assertEquals(0, timeZone.getDSTSavings());
    CmapSubtable[] cmaps = cmap.getCmaps();
    CmapSubtable cmapSubtable = cmaps[1];
    assertEquals(0, cmapSubtable.getPlatformEncodingId());
    assertEquals(0, ((CmapSubtable) unicodeCmapLookup).getPlatformId());
    assertEquals(0, header.getMacStyle());
    assertEquals(0, maximumProfile.getMaxInstructionDefs());
    assertEquals(0, getResult.getLanguageId());
    assertEquals(0, getResult2.getLanguageId());
    assertEquals(0, getResult.getNameId());
    assertEquals(0, getResult.getPlatformEncodingId());
    assertEquals(0, getResult2.getPlatformEncodingId());
    assertEquals(0, oS2Windows.getDefaultChar());
    assertEquals(0.0f, postScript.getItalicAngle());
    Matrix fontMatrix = actualPdType1CFont.getFontMatrix();
    assertEquals(0.0f, fontMatrix.getShearX());
    assertEquals(0.0f, fontMatrix.getShearY());
    assertEquals(0.0f, fontMatrix.getTranslateX());
    assertEquals(0.0f, fontMatrix.getTranslateY());
    assertEquals(0L, oS2Windows.getUnicodeRange3());
    assertEquals(0L, oS2Windows.getUnicodeRange4());
    assertEquals(0L, postScript.getIsFixedPitch());
    assertEquals(0L, postScript.getMaxMemType1());
    assertEquals(0L, postScript.getMaxMemType42());
    assertEquals(0L, postScript.getMinMemType1());
    assertEquals(0L, postScript.getMinMemType42());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(0L, offsets[0]);
    assertEquals((short) 0, header.getGlyphDataFormat());
    assertEquals((short) 0, header.getIndexToLocFormat());
    assertEquals((short) 0, horizontalHeader.getCaretSlopeRun());
    assertEquals((short) 0, horizontalHeader.getMetricDataFormat());
    assertEquals((short) 0, horizontalHeader.getReserved1());
    assertEquals((short) 0, horizontalHeader.getReserved2());
    assertEquals((short) 0, horizontalHeader.getReserved3());
    assertEquals((short) 0, horizontalHeader.getReserved4());
    assertEquals((short) 0, horizontalHeader.getReserved5());
    assertEquals((short) 0, oS2Windows.getFsType());
    assertEquals((short) 0, oS2Windows.getSubscriptXOffset());
    assertEquals((short) 0, oS2Windows.getSuperscriptXOffset());
    assertEquals(1, created.getFirstDayOfWeek());
    assertEquals(1, modified.getFirstDayOfWeek());
    assertEquals(1, created.getMinimalDaysInFirstWeek());
    assertEquals(1, modified.getMinimalDaysInFirstWeek());
    CmapSubtable cmapSubtable2 = cmaps[2];
    assertEquals(1, cmapSubtable2.getPlatformEncodingId());
    assertEquals(1, cmapSubtable.getPlatformId());
    assertEquals(1, getResult2.getNameId());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult5.getPlatformEncodingId());
    assertEquals(1, getResult.getPlatformId());
    assertEquals(1, getResult2.getPlatformId());
    assertEquals(1.0699921f, header.getFontRevision());
    assertEquals(1.0f, header.getVersion());
    assertEquals(1.0f, horizontalHeader.getVersion());
    assertEquals(1.0f, maximumProfile.getVersion());
    assertEquals(1.0f, ((TrueTypeFont) fontBoxFont).getVersion());
    assertEquals(1006.83594f, fontBBox.getUpperRightX());
    assertEquals(1006.83594f, boundingBox.getUpperRightX());
    assertEquals((short) 100, oS2Windows.getStrikeoutSize());
    assertEquals((short) 100, postScript.getUnderlineThickness());
    assertEquals(1033, getResult3.getLanguageId());
    assertEquals(1033, getResult5.getLanguageId());
    assertEquals(1035, maximumProfile.getMaxStackElements());
    assertEquals(1123398000000L, created.getTimeInMillis());
    assertEquals((short) 1163, oS2Windows.getAverageCharWidth());
    assertEquals(1183.5938f, fontBBox.getWidth());
    assertEquals(1183.5938f, boundingBox.getWidth());
    assertEquals(119960L, offsets[649]);
    assertEquals(120312L, offsets[650]);
    assertEquals(1205227863L, kerning.getCheckSum());
    assertEquals(120524L, offsets[651]);
    assertEquals(120820L, offsets[652]);
    assertEquals(121604L, offsets[653]);
    assertEquals(122572L, offsets[654]);
    assertEquals(122740L, offsets[655]);
    assertEquals(122856L, offsets[656]);
    assertEquals(122L, gsub.getLength());
    assertEquals(123008L, offsets[657]);
    assertEquals(123224L, offsets[658]);
    assertEquals(123352L, offsets[659]);
    assertEquals(123732L, offsets[660]);
    assertEquals(124, getResult5.getStringLength());
    assertEquals(124128L, offsets[661]);
    assertEquals(124244L, offsets[662]);
    assertEquals(124380L, offsets[663]);
    assertEquals(124564L, offsets[664]);
    assertEquals(124768L, offsets[665]);
    assertEquals(124979259L, maximumProfile.getCheckSum());
    Map<String, Integer> nameToCodeMap = encoding.getNameToCodeMap();
    assertEquals(149, nameToCodeMap.size());
    assertEquals(125, nameToCodeMap.get("braceright").intValue());
    assertEquals(125, maximumProfile.getMaxCompositePoints());
    assertEquals(125008L, offsets[666]);
    assertEquals(125148L, offsets[667]);
    assertEquals(125356L, offsets[668]);
    assertEquals(125460L, offsets[669]);
    assertEquals(125776L, offsets[670]);
    assertEquals(125912L, offsets[671]);
    assertEquals(126036L, offsets[672]);
    assertEquals(126168L, glyph.getLength());
    assertEquals(126168L, offsets[673]);
    assertEquals(1284.668f, fontBBox.getHeight());
    assertEquals(1284.668f, boundingBox.getHeight());
    assertEquals(1299, getResult3.getStringOffset());
    assertEquals(13, getResult3.getNameId());
    assertEquals((short) 1331, oS2Windows.getSubscriptYSize());
    assertEquals((short) 1331, oS2Windows.getSuperscriptYSize());
    assertEquals(1341, oS2Windows.getCapHeight());
    assertEquals(1342208251L, oS2Windows.getUnicodeRange2());
    assertEquals(1348L, indexToLocation.getLength());
    assertEquals(1352L, offsets[8]);
    assertEquals(135480L, kerning.getOffset());
    assertEquals(1386048774000L, modified.getTimeInMillis());
    assertEquals(14, getResult5.getNameId());
    assertEquals(1404621704L, indexToLocation.getCheckSum());
    assertEquals(140700L, naming.getOffset());
    assertEquals(1420, oS2Windows.getTypoAscender());
    assertEquals(142868L, postScript.getOffset());
    assertEquals((short) 1434, oS2Windows.getSubscriptXSize());
    assertEquals((short) 1434, oS2Windows.getSuperscriptXSize());
    assertEquals(148168L, gsub.getOffset());
    assertEquals(152408L, ((TrueTypeFont) fontBoxFont).getOriginalDataSize());
    assertEquals(1593, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(1594834165L, header.getMagicNumber());
    assertEquals(1610612895L, oS2Windows.getCodePageRange1());
    assertEquals(1635, getResult5.getStringOffset());
    assertEquals(1708L, offsets[9]);
    assertEquals(1770L, cmap.getLength());
    assertEquals(1797L, getResult4.getLength());
    assertEquals(1804087085L, cmap.getCheckSum());
    assertEquals(1825, oS2Windows.getWinAscent());
    assertEquals((short) 1825, horizontalHeader.getAscender());
    assertEquals(19, ((TrueTypeFont) fontBoxFont).getTables().size());
    assertEquals(194, getResult.getStringOffset());
    assertEquals(1943217072L, getResult4.getCheckSum());
    assertEquals((short) 1, horizontalHeader.getCaretSlopeRise());
    assertEquals(2, maximumProfile.getMaxComponentDepth());
    assertEquals(2, maximumProfile.getMaxZones());
    assertEquals(2, oS2Windows.getMaxContext());
    assertEquals(2.0f, postScript.getFormatType());
    assertEquals(2005, created.getWeekYear());
    assertEquals((short) 2010, header.getYMax());
    assertEquals(2013, modified.getWeekYear());
    assertEquals(202, nameToCodeMap.get("ring").intValue());
    assertEquals(2048, header.getUnitsPerEm());
    assertEquals(2048, ((TrueTypeFont) fontBoxFont).getUnitsPerEm());
    assertEquals((short) 2062, header.getXMax());
    assertEquals((short) 2062, horizontalHeader.getXMaxExtent());
    assertEquals(2155, horizontalHeader.getAdvanceWidthMax());
    assertEquals(2166L, naming.getLength());
    assertEquals(222, getResult3.getStringLength());
    assertEquals(236914665L, horizontalHeader.getCheckSum());
    assertEquals(250.0f, actualPdType1CFont.getSpaceWidth());
    assertEquals(2501031757L, header.getCheckSumAdjustment());
    assertEquals(2548L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(261, oS2Windows.getFamilyClass());
    assertEquals(2684355247L, oS2Windows.getUnicodeRange1());
    assertEquals(2690L, horizontalMetrics.getLength());
    assertEquals(2759005874L, postScript.getCheckSum());
    assertEquals((short) 293, oS2Windows.getSubscriptYOffset());
    assertEquals((short) 2, header.getFontDirectionHint());
    assertEquals(3, ((CmapSubtable) unicodeCmapLookup).getPlatformEncodingId());
    assertEquals(3, cmapSubtable2.getPlatformId());
    assertEquals(3, maximumProfile.getMaxComponentElements());
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult5.getPlatformId());
    assertEquals(3, oS2Windows.getVersion());
    assertEquals(3, cmaps.length);
    float[][] values = fontMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3000L, offsets[11]);
    assertEquals(307, oS2Windows.getTypoLineGap());
    assertEquals(31, header.getFlags());
    assertEquals(3148L, offsets[PDPanose.LENGTH]);
    assertEquals(316L, header.getOffset());
    assertEquals(3228L, cmap.getOffset());
    assertEquals(325, getResult2.getStringOffset());
    assertEquals(32L, maximumProfile.getLength());
    assertEquals(33, oS2Windows.getFirstCharIndex());
    assertEquals(3304L, offsets[13]);
    assertEquals(338, maximumProfile.getMaxPoints());
    assertEquals(344L, offsets[5]);
    assertEquals(3575500291L, horizontalMetrics.getCheckSum());
    assertEquals(3652L, offsets[14]);
    assertEquals(36L, horizontalHeader.getLength());
    assertEquals(372L, horizontalHeader.getOffset());
    assertEquals(3737457882L, naming.getCheckSum());
    assertEquals(3755409408L, oS2Windows.getCodePageRange2());
    assertEquals(3776L, offsets[15]);
    assertEquals(3912L, offsets[Short.SIZE]);
    Set<String> supportedScriptTags = gsub.getSupportedScriptTags();
    assertEquals(4, supportedScriptTags.size());
    List<Number> fontMatrix2 = fontBoxFont.getFontMatrix();
    assertEquals(6, fontMatrix2.size());
    assertEquals(4.8828125E-4f, fontMatrix2.get(0).floatValue());
    assertEquals(4.8828125E-4f, fontMatrix.getScaleX());
    assertEquals(4.8828125E-4f, fontMatrix.getScaleY());
    assertEquals(4.8828125E-4f, fontMatrix.getScalingFactorX());
    assertEquals(4.8828125E-4f, fontMatrix.getScalingFactorY());
    assertEquals(400, oS2Windows.getWeightClass());
    assertEquals(4036L, offsets[17]);
    assertEquals(4061832304L, glyph.getCheckSum());
    assertEquals(4088781771L, header.getCheckSum());
    assertEquals(408L, maximumProfile.getOffset());
    assertEquals(41, nameToCodeMap.get("parenright").intValue());
    assertEquals(4140L, offsets[18]);
    assertEquals(4193550753L, oS2Windows.getCheckSum());
    assertEquals(42, nameToCodeMap.get("asterisk").intValue());
    assertEquals((short) 420, oS2Windows.getStrikeoutPosition());
    assertEquals(4244L, offsets[19]);
    assertEquals(440L, oS2Windows.getOffset());
    assertEquals(443, oS2Windows.getWinDescent());
    assertEquals(4452L, offsets[20]);
    assertEquals(4564L, offsets[21]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4792L, offsets[22]);
    assertEquals(5, maximumProfile.getMaxCompositeContours());
    assertEquals(5, oS2Windows.getWidthClass());
    assertEquals(500.0f, actualPdType1CFont.getAverageFontWidth());
    assertEquals(5000L, getResult4.getOffset());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) fontBoxFont).getOriginalData().read(byteArray));
    assertEquals(5140L, offsets[23]);
    assertEquals(52, modified.getWeeksInWeekYear());
    assertEquals(5220L, kerning.getLength());
    assertEquals(5244L, postScript.getLength());
    assertEquals(53, created.getWeeksInWeekYear());
    assertEquals(5332L, offsets[24]);
    assertEquals(536L, horizontalMetrics.getOffset());
    assertEquals(54L, header.getLength());
    assertEquals(600L, offsets[6]);
    assertEquals(64258, oS2Windows.getLastCharIndex());
    assertEquals(672, horizontalHeader.getNumberOfHMetrics());
    assertEquals(673, maximumProfile.getNumGlyphs());
    assertEquals(673, ((TrueTypeFont) fontBoxFont).getNumberOfGlyphs());
    assertEquals(673, glyphNames.length);
    assertEquals(674, offsets.length);
    assertEquals(7964L, indexToLocation.getOffset());
    assertEquals(8, header.getLowestRecPPEM());
    assertEquals(84, maximumProfile.getMaxContours());
    assertEquals((short) 87, horizontalHeader.getLineGap());
    assertEquals(880L, offsets[7]);
    assertEquals(88L, offsets[1]);
    assertEquals(88L, offsets[2]);
    assertEquals(88L, offsets[3]);
    assertEquals(88L, offsets[4]);
    assertEquals(90, maximumProfile.getMaxFunctionDefs());
    assertEquals((short) 928, oS2Windows.getSuperscriptYOffset());
    assertEquals(9312L, glyph.getOffset());
    assertEquals(940, oS2Windows.getHeight());
    assertEquals(96, getResult.getStringLength());
    assertEquals(96L, oS2Windows.getLength());
    assertEquals(981.4453f, fontBBox.getUpperRightY());
    assertEquals(981.4453f, boundingBox.getUpperRightY());
    assertEquals(986333945L, gsub.getCheckSum());
    assertEquals(Language.LATIN, gsubData.getLanguage());
    assertFalse(getResult4.getInitialized());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(actualPdType1CFont.isVertical());
    assertFalse(actualPdType1CFont.isDamaged());
    assertFalse(actualPdType1CFont.isEmbedded());
    assertTrue(created.isLenient());
    assertTrue(modified.isLenient());
    assertTrue(created.isWeekDateSupported());
    assertTrue(modified.isWeekDateSupported());
    assertTrue(actualPdType1CFont.getWidths().isEmpty());
    assertTrue(supportedScriptTags.contains("DFLT"));
    assertTrue(supportedScriptTags.contains("cyrl"));
    assertTrue(supportedScriptTags.contains("grek"));
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(kerning.getHorizontalKerningSubtable().isHorizontalKerning());
    assertTrue(cmap.getInitialized());
    assertTrue(glyph.getInitialized());
    assertTrue(gsub.getInitialized());
    assertTrue(header.getInitialized());
    assertTrue(horizontalHeader.getInitialized());
    assertTrue(horizontalMetrics.getInitialized());
    assertTrue(indexToLocation.getInitialized());
    assertTrue(kerning.getInitialized());
    assertTrue(maximumProfile.getInitialized());
    assertTrue(naming.getInitialized());
    assertTrue(oS2Windows.getInitialized());
    assertTrue(postScript.getInitialized());
    assertTrue(((TrueTypeFont) fontBoxFont).isEnableGsub());
    assertEquals(timeZone, modified.getTimeZone());
    assertEquals(Double.SIZE, oS2Windows.getFsSelection());
    assertEquals(Integer.SIZE, oS2Windows.getBreakChar());
    assertEquals(Short.SIZE, maximumProfile.getMaxTwilightPoints());
    assertEquals(Short.SIZE, getResult2.getStringLength());
    assertSame(fontDictionary, actualPdType1CFont.getCOSObject());
    assertSame(glyph, tableMap.get("glyf"));
    assertSame(kerning, tableMap.get("kern"));
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertSame(unicodeCmapLookup, cmaps[0]);
    assertSame(gsubData, gsub.getGsubData());
    assertArrayEquals(new byte[]{2, 2, 6, 3, 5, 4, 5, 2, 3, 4}, oS2Windows.getPanose());
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', '0', 18, '{', 0, 2,
        'S', '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -57, 0, 2, 'B', -96, 0, 0, 0, '&', 'G', 'P', 'O', 'S',
        '\b', -35, -11}, byteArray);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
