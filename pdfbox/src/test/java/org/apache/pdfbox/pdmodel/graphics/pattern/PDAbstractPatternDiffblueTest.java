package org.apache.pdfbox.pdmodel.graphics.pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractPatternDiffblueTest {
  /**
   * Test {@link PDAbstractPattern#create(COSDictionary, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractPattern#create(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test create(COSDictionary, ResourceCache); when COSDictionary(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDAbstractPattern.create(COSDictionary, ResourceCache)"})
  void testCreate_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertThrows(
        IOException.class, () -> PDAbstractPattern.create(dictionary, new DefaultResourceCache()));
  }

  /**
   * Test {@link PDAbstractPattern#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAbstractPattern#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAbstractPattern.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDShadingPattern().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAbstractPattern#setPaintType(int)}.
   *
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractPattern#setPaintType(int)}
   */
  @Test
  @DisplayName("Test setPaintType(int); then PDShadingPattern() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractPattern.setPaintType(int)"})
  void testSetPaintType_thenPDShadingPatternCOSObjectValuesSizeIsThree() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setPaintType(1);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAbstractPattern#setPaintType(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractPattern#setPaintType(int)}
   */
  @Test
  @DisplayName(
      "Test setPaintType(int); when MIN_VALUE; then PDShadingPattern() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractPattern.setPaintType(int)"})
  void testSetPaintType_whenMin_value_thenPDShadingPatternCOSObjectValuesSizeIsThree() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setPaintType(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAbstractPattern#getType()}.
   *
   * <p>Method under test: {@link PDAbstractPattern#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDAbstractPattern.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Pattern", new PDShadingPattern().getType());
  }

  /**
   * Test {@link PDAbstractPattern#setPatternType(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)} does nothing.
   *   <li>When one.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractPattern#setPatternType(int)}
   */
  @Test
  @DisplayName(
      "Test setPatternType(int); given COSDictionary setInt(COSName, int) does nothing; when one; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractPattern.setPatternType(int)"})
  void testSetPatternType_givenCOSDictionarySetIntDoesNothing_whenOne_thenCallsSetInt() {
    // Arrange
    COSDictionary resourceDictionary = mock(COSDictionary.class);
    doNothing().when(resourceDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    new PDShadingPattern(resourceDictionary).setPatternType(1);

    // Assert
    verify(resourceDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Test {@link PDAbstractPattern#getMatrix()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.
   *   <li>Then return ShearX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractPattern#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix(); given PDShadingPattern(); then return ShearX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDAbstractPattern.getMatrix()"})
  void testGetMatrix_givenPDShadingPattern_thenReturnShearXIsZero() {
    // Arrange and Act
    Matrix actualMatrix = new PDShadingPattern().getMatrix();

    // Assert
    assertEquals(0.0f, actualMatrix.getShearX());
    assertEquals(0.0f, actualMatrix.getShearY());
    assertEquals(0.0f, actualMatrix.getTranslateX());
    assertEquals(0.0f, actualMatrix.getTranslateY());
    assertEquals(1.0f, actualMatrix.getScaleX());
    assertEquals(1.0f, actualMatrix.getScaleY());
    assertEquals(1.0f, actualMatrix.getScalingFactorX());
    assertEquals(1.0f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractPattern#setMatrix(AffineTransform)}.
   *
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractPattern#setMatrix(AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test setMatrix(AffineTransform); then PDShadingPattern() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractPattern.setMatrix(AffineTransform)"})
  void testSetMatrix_thenPDShadingPatternCOSObjectValuesSizeIsThree() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setMatrix(new AffineTransform());

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
