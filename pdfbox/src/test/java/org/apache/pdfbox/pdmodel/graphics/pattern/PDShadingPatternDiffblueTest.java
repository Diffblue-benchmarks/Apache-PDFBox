package org.apache.pdfbox.pdmodel.graphics.pattern;

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
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType1;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingPatternDiffblueTest {
  /**
   * Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  void testGetExtendedGraphicsState() {
    // Arrange, Act and Assert
    assertNull((new PDShadingPattern()).getExtendedGraphicsState());
  }

  /**
   * Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  void testGetExtendedGraphicsState2() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Act and Assert
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  void testGetExtendedGraphicsState3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument transfer = new COSDocument(streamCacheCreateFunction);

    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
    extendedGraphicsState.setTransfer(transfer);

    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Act
    PDExtendedGraphicsState actualExtendedGraphicsState = pdShadingPattern.getExtendedGraphicsState();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(extendedGraphicsState, actualExtendedGraphicsState);
  }

  /**
   * Method under test:
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  void testSetExtendedGraphicsState() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Method under test:
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  void testSetExtendedGraphicsState2() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setExtendedGraphicsState(null);

    // Assert
    assertNull(pdShadingPattern.getExtendedGraphicsState());
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  void testSetExtendedGraphicsState3() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument transfer = new COSDocument(streamCacheCreateFunction);

    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
    extendedGraphicsState.setTransfer(transfer);

    // Act
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  void testGetShading() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDShadingPattern()).getShading());
  }

  /**
   * Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  void testGetShading2() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(new COSDictionary());
    pdShadingPattern.setShading(shadingResources);

    // Act and Assert
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  void testSetShading() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  void testSetShading2() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(null);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  void testSetShading3() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setShading(null);

    // Assert
    assertNull(pdShadingPattern.getShading());
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  void testSetShading4() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);
    PDShadingType1 shadingResources = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  void testSetShading5() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));
    PDShadingType1 shadingResources = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingPattern#PDShadingPattern(COSDictionary)}
   *   <li>{@link PDShadingPattern#getPatternType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act
    PDShadingPattern actualPdShadingPattern = new PDShadingPattern(resourceDictionary);

    // Assert
    assertEquals(2, actualPdShadingPattern.getPatternType());
    assertSame(resourceDictionary, actualPdShadingPattern.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingPattern#PDShadingPattern()}
   */
  @Test
  void testNewPDShadingPattern() throws IOException {
    // Arrange and Act
    PDShadingPattern actualPdShadingPattern = new PDShadingPattern();

    // Assert
    assertEquals("Pattern", actualPdShadingPattern.getType());
    COSDictionary cOSObject = actualPdShadingPattern.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdShadingPattern.getShading());
    assertNull(actualPdShadingPattern.getExtendedGraphicsState());
    Matrix matrix = actualPdShadingPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, actualPdShadingPattern.getPatternType());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
