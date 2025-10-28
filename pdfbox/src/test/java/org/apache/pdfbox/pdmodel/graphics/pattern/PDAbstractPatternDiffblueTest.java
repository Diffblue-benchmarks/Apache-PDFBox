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
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractPatternDiffblueTest {
  /**
   * Method under test:
   * {@link PDAbstractPattern#create(COSDictionary, ResourceCache)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDAbstractPattern.create(dictionary, new DefaultResourceCache()));
  }

  /**
   * Method under test: {@link PDAbstractPattern#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDShadingPattern()).getCOSObject();

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
   * Method under test: {@link PDAbstractPattern#setPaintType(int)}
   */
  @Test
  void testSetPaintType() {
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
   * Method under test: {@link PDAbstractPattern#setPaintType(int)}
   */
  @Test
  void testSetPaintType2() {
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
   * Method under test: {@link PDAbstractPattern#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Pattern", (new PDShadingPattern()).getType());
  }

  /**
   * Method under test: {@link PDAbstractPattern#setPatternType(int)}
   */
  @Test
  void testSetPatternType() {
    // Arrange
    COSDictionary resourceDictionary = mock(COSDictionary.class);
    doNothing().when(resourceDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    (new PDShadingPattern(resourceDictionary)).setPatternType(1);

    // Assert that nothing has changed
    verify(resourceDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Method under test: {@link PDAbstractPattern#getMatrix()}
   */
  @Test
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = (new PDShadingPattern()).getMatrix();

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
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAbstractPattern#setMatrix(AffineTransform)}
   */
  @Test
  void testSetMatrix() {
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
