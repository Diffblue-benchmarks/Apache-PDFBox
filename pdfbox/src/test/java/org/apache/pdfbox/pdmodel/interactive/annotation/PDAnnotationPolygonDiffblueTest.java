package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
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

class PDAnnotationPolygonDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertEquals(0, interiorColor.getComponents().length);
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor2() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor3() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f, 0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor4() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#getInteriorColor()}
   */
  @Test
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getInteriorColor());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationPolygon.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect2() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setBorderEffect(null);

    // Assert
    assertNull(pdAnnotationPolygon.getBorderEffect());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect3() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationPolygon.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationPolygon.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect4() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationPolygon.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationPolygon.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#getBorderEffect()}
   */
  @Test
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getBorderEffect());
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#getVertices()}
   */
  @Test
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getVertices());
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#setVertices(float[])}
   */
  @Test
  void testSetVertices() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#getPath()}
   */
  @Test
  void testGetPath() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getPath());
  }

  /**
   * Method under test: {@link PDAnnotationPolygon#constructAppearances()}
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

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
