package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCaretAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationPolylineDiffblueTest {
  /**
   * Method under test:
   * {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle2() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationPolyline.getStartPointEndingStyle());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle3() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle("NoneNone");

    // Assert
    assertEquals("NoneNone", pdAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  void testGetStartPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationPolyline()).getStartPointEndingStyle());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle2() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationPolyline.getEndPointEndingStyle());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle3() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  void testGetEndPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationPolyline()).getEndPointEndingStyle());
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertEquals(0, interiorColor.getComponents().length);
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor2() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor3() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f, 0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor4() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#getInteriorColor()}
   */
  @Test
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolyline()).getInteriorColor());
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#getVertices()}
   */
  @Test
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolyline()).getVertices());
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#setVertices(float[])}
   */
  @Test
  void testSetVertices() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L)));
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation,
        new PDDocument(streamCacheCreateFunction));

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
