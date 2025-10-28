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
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDTilingPatternDiffblueTest {
  /**
   * Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  void testSetPaintType() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setPaintType(1);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdTilingPattern.getPaintType());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  void testSetPaintType2() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setPaintType(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdTilingPattern.getPaintType());
  }

  /**
   * Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  void testGetPaintType() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern()).getPaintType());
  }

  /**
   * Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  void testGetPaintType2() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();
    pdTilingPattern.setPaintType(1);

    // Act and Assert
    assertEquals(1, pdTilingPattern.getPaintType());
  }

  /**
   * Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  void testSetTilingType() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setTilingType(1);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdTilingPattern.getTilingType());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  void testSetTilingType2() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setTilingType(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdTilingPattern.getTilingType());
  }

  /**
   * Method under test: {@link PDTilingPattern#getTilingType()}
   */
  @Test
  void testGetTilingType() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern()).getTilingType());
  }

  /**
   * Method under test: {@link PDTilingPattern#setXStep(float)}
   */
  @Test
  void testSetXStep() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setXStep(10.0f);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(10.0f, pdTilingPattern.getXStep());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#getXStep()}
   */
  @Test
  void testGetXStep() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern()).getXStep());
  }

  /**
   * Method under test: {@link PDTilingPattern#setYStep(float)}
   */
  @Test
  void testSetYStep() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setYStep(10.0f);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(10.0f, pdTilingPattern.getYStep());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#getYStep()}
   */
  @Test
  void testGetYStep() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern()).getYStep());
  }

  /**
   * Method under test: {@link PDTilingPattern#getContentStream()}
   */
  @Test
  void testGetContentStream() throws IOException {
    // Arrange and Act
    PDStream actualContentStream = (new PDTilingPattern()).getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    COSStream cOSObject = actualContentStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  void testGetContents() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getContents());
  }

  /**
   * Method under test: {@link PDTilingPattern#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getContentsForRandomAccess());
  }

  /**
   * Method under test: {@link PDTilingPattern#getResources()}
   */
  @Test
  void testGetResources() {
    // Arrange and Act
    PDResources actualResources = (new PDTilingPattern()).getResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualResources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, actualResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualResources.getFontNames());
    assertSame(colorSpaceNames, actualResources.getPatternNames());
    assertSame(colorSpaceNames, actualResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualResources.getShadingNames());
    assertSame(colorSpaceNames, actualResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDTilingPattern#getResources()}
   */
  @Test
  void testGetResources2() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getResources());
  }

  /**
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  void testSetResources() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setResources(new PDResources());

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  void testSetResources2() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setResources(null);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(pdTilingPattern.getResources());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  void testSetResources3() throws IOException {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDImageXObject image = new PDImageXObject(new PDDocument(streamCacheCreateFunction));

    PDResources resources = new PDResources();
    resources.add(image);

    // Act
    pdTilingPattern.setResources(resources);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTilingPattern#getBBox()}
   */
  @Test
  void testGetBBox() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern()).getBBox());
  }

  /**
   * Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(PDRectangle.A1);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDRectangle bBox = pdTilingPattern.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(1683.7795f, bBox.getUpperRightX());
    assertEquals(1683.7795f, bBox.getWidth());
    assertEquals(2383.937f, bBox.getHeight());
    assertEquals(2383.937f, bBox.getUpperRightY());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox2() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(null);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(pdTilingPattern.getBBox());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDTilingPattern#PDTilingPattern(COSDictionary)}
   *   <li>{@link PDTilingPattern#getPatternType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern(dictionary);

    // Assert
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertSame(dictionary, actualPdTilingPattern.getCOSObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDTilingPattern#PDTilingPattern(COSDictionary, ResourceCache)}
   *   <li>{@link PDTilingPattern#getPatternType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern(dictionary, new DefaultResourceCache());

    // Assert
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertSame(dictionary, actualPdTilingPattern.getCOSObject());
  }

  /**
   * Method under test: {@link PDTilingPattern#PDTilingPattern()}
   */
  @Test
  void testNewPDTilingPattern() throws IOException {
    // Arrange and Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern();

    // Assert
    PDResources resources = actualPdTilingPattern.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualPdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals("Pattern", actualPdTilingPattern.getType());
    PDStream contentStream = actualPdTilingPattern.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdTilingPattern.getBBox());
    assertNull(contentStream.getFile());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(0, cOSObject2.size());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, actualPdTilingPattern.getPaintType());
    assertEquals(0, actualPdTilingPattern.getTilingType());
    assertEquals(0.0f, actualPdTilingPattern.getXStep());
    assertEquals(0.0f, actualPdTilingPattern.getYStep());
    Matrix matrix = actualPdTilingPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
