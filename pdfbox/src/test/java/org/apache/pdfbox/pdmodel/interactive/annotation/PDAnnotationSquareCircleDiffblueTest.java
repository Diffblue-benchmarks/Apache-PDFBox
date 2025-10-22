package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationSquareCircleDiffblueTest {
  /**
   * Test {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); given FALSE; when COSArray() add FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setInteriorColor(PDColor)"})
  void testSetInteriorColor_givenFalse_whenCOSArrayAddFalse() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} InteriorColor ColorSpace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationCircle() InteriorColor ColorSpace is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationCircleInteriorColorColorSpaceIsNull() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} InteriorColor Pattern.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationCircle() InteriorColor Pattern")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationCircleInteriorColorPattern() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setInteriorColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationCircle.getInteriorColor();
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#getInteriorColor()}.
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColor PDAnnotationSquareCircle.getInteriorColor()"})
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCircle()).getInteriorColor());
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenTrue_whenCOSDictionaryDirectIsTrue() {
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
   * Test {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when 'null'; then PDAnnotationCircle() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenNull_thenPDAnnotationCircleCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setBorderEffect(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>When {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when PDBorderEffectDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenPDBorderEffectDictionary() {
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
   * Test {@link PDAnnotationSquareCircle#getBorderEffect()}.
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#getBorderEffect()}
   */
  @Test
  @DisplayName("Test getBorderEffect()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDBorderEffectDictionary PDAnnotationSquareCircle.getBorderEffect()"})
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCircle()).getBorderEffect());
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setRectDifference(PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} COSObject toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setRectDifference(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectDifference(PDRectangle); then PDAnnotationCircle() COSObject toIncrement Objects Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setRectDifference(PDRectangle)"})
  void testSetRectDifference_thenPDAnnotationCircleCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifference(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = pdAnnotationCircle.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[]{}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setRectDifference(PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} RectDifference UpperRightX is {@code 1683.7795}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setRectDifference(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectDifference(PDRectangle); then PDAnnotationCircle() RectDifference UpperRightX is '1683.7795'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setRectDifference(PDRectangle)"})
  void testSetRectDifference_thenPDAnnotationCircleRectDifferenceUpperRightXIs16837795() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifference(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    assertEquals(1683.7795f, rectDifference.getUpperRightX());
    assertEquals(1683.7795f, rectDifference.getWidth());
    assertEquals(2383.937f, rectDifference.getHeight());
    assertEquals(2383.937f, rectDifference.getUpperRightY());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1683.7795f, 2383.937f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#getRectDifference()}.
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#getRectDifference()}
   */
  @Test
  @DisplayName("Test getRectDifference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAnnotationSquareCircle.getRectDifference()"})
  void testGetRectDifference() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCircle()).getRectDifference());
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setRectDifferences(float)} with {@code difference}.
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setRectDifferences(float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float) with 'difference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setRectDifferences(float)"})
  void testSetRectDifferencesWithDifference() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifferences(10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSArray cOSArray = rectDifference.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#setRectDifferences(float, float, float, float)} with {@code differenceLeft}, {@code differenceTop}, {@code differenceRight}, {@code differenceBottom}.
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#setRectDifferences(float, float, float, float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float, float, float, float) with 'differenceLeft', 'differenceTop', 'differenceRight', 'differenceBottom'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquareCircle.setRectDifferences(float, float, float, float)"})
  void testSetRectDifferencesWithDifferenceLeftDifferenceTopDifferenceRightDifferenceBottom() {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();

    // Act
    pdAnnotationCircle.setRectDifferences(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationCircle.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSArray cOSArray = rectDifference.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquareCircle#getRectDifferences()}.
   * <p>
   * Method under test: {@link PDAnnotationSquareCircle#getRectDifferences()}
   */
  @Test
  @DisplayName("Test getRectDifferences()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDAnnotationSquareCircle.getRectDifferences()"})
  void testGetRectDifferences() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{}, (new PDAnnotationCircle()).getRectDifferences(), 0.0f);
  }
}
