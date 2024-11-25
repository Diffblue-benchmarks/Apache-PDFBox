package org.apache.pdfbox.pdmodel.graphics.pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDTilingPatternDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDTilingPattern#PDTilingPattern(COSDictionary)}
   *   <li>{@link PDTilingPattern#getPatternType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSDictionary()")
  void testGettersAndSetters_whenCOSDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern(dictionary);

    // Assert
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertSame(dictionary, actualPdTilingPattern.getCOSObject());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link DefaultResourceCache} (default constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDTilingPattern#PDTilingPattern(COSDictionary, ResourceCache)}
   *   <li>{@link PDTilingPattern#getPatternType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when DefaultResourceCache (default constructor)")
  void testGettersAndSetters_whenDefaultResourceCache() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern(dictionary, new DefaultResourceCache());

    // Assert
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertSame(dictionary, actualPdTilingPattern.getCOSObject());
  }

  /**
   * Test {@link PDTilingPattern#PDTilingPattern()}.
   * <p>
   * Method under test: {@link PDTilingPattern#PDTilingPattern()}
   */
  @Test
  @DisplayName("Test new PDTilingPattern()")
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

  /**
   * Test {@link PDTilingPattern#setPaintType(int)}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>When one.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} PaintType is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  @DisplayName("Test setPaintType(int); given PDTilingPattern(); when one; then PDTilingPattern() PaintType is one")
  void testSetPaintType_givenPDTilingPattern_whenOne_thenPDTilingPatternPaintTypeIsOne() {
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
   * Test {@link PDTilingPattern#setPaintType(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} PaintType is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  @DisplayName("Test setPaintType(int); when MIN_VALUE; then PDTilingPattern() PaintType is MIN_VALUE")
  void testSetPaintType_whenMin_value_thenPDTilingPatternPaintTypeIsMin_value() {
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
   * Test {@link PDTilingPattern#getPaintType()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()} PaintType is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  @DisplayName("Test getPaintType(); given PDTilingPattern() PaintType is one; then return one")
  void testGetPaintType_givenPDTilingPatternPaintTypeIsOne_thenReturnOne() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();
    pdTilingPattern.setPaintType(1);

    // Act and Assert
    assertEquals(1, pdTilingPattern.getPaintType());
  }

  /**
   * Test {@link PDTilingPattern#getPaintType()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  @DisplayName("Test getPaintType(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary()")
  void testGetPaintType_givenPDTilingPatternWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern(new COSDictionary())).getPaintType());
  }

  /**
   * Test {@link PDTilingPattern#getPaintType()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  @DisplayName("Test getPaintType(); given PDTilingPattern(); then return zero")
  void testGetPaintType_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern()).getPaintType());
  }

  /**
   * Test {@link PDTilingPattern#setTilingType(int)}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} TilingType is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  @DisplayName("Test setTilingType(int); given PDTilingPattern(); then PDTilingPattern() TilingType is one")
  void testSetTilingType_givenPDTilingPattern_thenPDTilingPatternTilingTypeIsOne() {
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
   * Test {@link PDTilingPattern#setTilingType(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} TilingType is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  @DisplayName("Test setTilingType(int); when MIN_VALUE; then PDTilingPattern() TilingType is MIN_VALUE")
  void testSetTilingType_whenMin_value_thenPDTilingPatternTilingTypeIsMin_value() {
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
   * Test {@link PDTilingPattern#getTilingType()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getTilingType()}
   */
  @Test
  @DisplayName("Test getTilingType(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary()")
  void testGetTilingType_givenPDTilingPatternWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern(new COSDictionary())).getTilingType());
  }

  /**
   * Test {@link PDTilingPattern#getTilingType()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getTilingType()}
   */
  @Test
  @DisplayName("Test getTilingType(); given PDTilingPattern(); then return zero")
  void testGetTilingType_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern()).getTilingType());
  }

  /**
   * Test {@link PDTilingPattern#setXStep(float)}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject
   * {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setXStep(float)}
   */
  @Test
  @DisplayName("Test setXStep(float); given PDTilingPattern(); then PDTilingPattern() COSObject COSStream")
  void testSetXStep_givenPDTilingPattern_thenPDTilingPatternCOSObjectCOSStream() {
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
   * Test {@link PDTilingPattern#getXStep()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getXStep()}
   */
  @Test
  @DisplayName("Test getXStep(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return zero")
  void testGetXStep_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern(new COSDictionary())).getXStep());
  }

  /**
   * Test {@link PDTilingPattern#getXStep()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getXStep()}
   */
  @Test
  @DisplayName("Test getXStep(); given PDTilingPattern(); then return zero")
  void testGetXStep_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern()).getXStep());
  }

  /**
   * Test {@link PDTilingPattern#setYStep(float)}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject
   * {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setYStep(float)}
   */
  @Test
  @DisplayName("Test setYStep(float); given PDTilingPattern(); then PDTilingPattern() COSObject COSStream")
  void testSetYStep_givenPDTilingPattern_thenPDTilingPatternCOSObjectCOSStream() {
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
   * Test {@link PDTilingPattern#getYStep()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getYStep()}
   */
  @Test
  @DisplayName("Test getYStep(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return zero")
  void testGetYStep_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern(new COSDictionary())).getYStep());
  }

  /**
   * Test {@link PDTilingPattern#getYStep()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getYStep()}
   */
  @Test
  @DisplayName("Test getYStep(); given PDTilingPattern(); then return zero")
  void testGetYStep_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern()).getYStep());
  }

  /**
   * Test {@link PDTilingPattern#getContentStream()}.
   * <p>
   * Method under test: {@link PDTilingPattern#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
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
   * Test {@link PDTilingPattern#getContents()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  void testGetContents_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getContents());
  }

  /**
   * Test {@link PDTilingPattern#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); then return 'null'")
  void testGetContentsForRandomAccess_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getContentsForRandomAccess());
  }

  /**
   * Test {@link PDTilingPattern#getResources()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then ColorSpaceNames return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDTilingPattern(); then ColorSpaceNames return Set")
  void testGetResources_givenPDTilingPattern_thenColorSpaceNamesReturnSet() {
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
   * Test {@link PDTilingPattern#getResources()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); then return 'null'")
  void testGetResources_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getResources());
  }

  /**
   * Test {@link PDTilingPattern#setResources(PDResources)}.
   * <ul>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject Values size is
   * four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); then PDTilingPattern() COSObject Values size is four")
  void testSetResources_thenPDTilingPatternCOSObjectValuesSizeIsFour() {
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
   * Test {@link PDTilingPattern#setResources(PDResources)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} Resources is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); when 'null'; then PDTilingPattern() Resources is 'null'")
  void testSetResources_whenNull_thenPDTilingPatternResourcesIsNull() {
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
   * Test {@link PDTilingPattern#getBBox()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  void testGetBBox_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getBBox());
  }

  /**
   * Test {@link PDTilingPattern#getBBox()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDTilingPattern(); then return 'null'")
  void testGetBBox_givenPDTilingPattern_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern()).getBBox());
  }

  /**
   * Test {@link PDTilingPattern#setBBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A1}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} BBox UpperRightX is
   * {@code 1683.7795}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); when A1; then PDTilingPattern() BBox UpperRightX is '1683.7795'")
  void testSetBBox_whenA1_thenPDTilingPatternBBoxUpperRightXIs16837795() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(PDRectangle.A1);

    // Assert
    PDRectangle bBox = pdTilingPattern.getBBox();
    assertEquals(1683.7795f, bBox.getUpperRightX());
    assertEquals(1683.7795f, bBox.getWidth());
    assertEquals(2383.937f, bBox.getHeight());
    assertEquals(2383.937f, bBox.getUpperRightY());
  }

  /**
   * Test {@link PDTilingPattern#setBBox(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject toIncrement
   * Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); when 'null'; then PDTilingPattern() COSObject toIncrement Objects Empty")
  void testSetBBox_whenNull_thenPDTilingPatternCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(null);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
