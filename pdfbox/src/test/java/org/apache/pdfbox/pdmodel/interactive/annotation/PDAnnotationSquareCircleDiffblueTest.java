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
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.Test;

class PDAnnotationSquareCircleDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertEquals(0, interiorColor.getComponents().length);
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor2() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor3() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f, 0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor4() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#getInteriorColor()}
   */
  @Test
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCircle()).getInteriorColor());
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationCircle.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect2() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setBorderEffect(null);

    // Assert
    assertNull(pdAnnotationCircle.getBorderEffect());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect3() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationCircle.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationCircle.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect4() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationCircle.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationCircle.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#getBorderEffect()}
   */
  @Test
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCircle()).getBorderEffect());
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setRectDifference(PDRectangle)}
   */
  @Test
  void testSetRectDifference() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifference(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    assertEquals(0.0f, rectDifference.getLowerLeftX());
    assertEquals(0.0f, rectDifference.getLowerLeftY());
    assertEquals(1683.7795f, rectDifference.getUpperRightX());
    assertEquals(1683.7795f, rectDifference.getWidth());
    assertEquals(2383.937f, rectDifference.getHeight());
    assertEquals(2383.937f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray expectedCOSObject = rectDifference.getCOSArray();
    assertSame(expectedCOSObject, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1683.7795f, 2383.937f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setRectDifference(PDRectangle)}
   */
  @Test
  void testSetRectDifference2() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifference(null);

    // Assert
    assertNull(pdAnnotationCircle.getRectDifference());
    assertEquals(0, pdAnnotationCircle.getRectDifferences().length);
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#getRectDifference()}
   */
  @Test
  void testGetRectDifference() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCircle()).getRectDifference());
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#setRectDifferences(float)}
   */
  @Test
  void testSetRectDifferences() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifferences(10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    COSArray cOSArray = rectDifference.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationSquareCircle#setRectDifferences(float, float, float, float)}
   */
  @Test
  void testSetRectDifferences2() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifferences(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    COSArray cOSArray = rectDifference.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationSquareCircle#getRectDifferences()}
   */
  @Test
  void testGetRectDifferences() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationCircle()).getRectDifferences().length);
  }
}
