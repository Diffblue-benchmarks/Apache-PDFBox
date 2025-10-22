package org.apache.pdfbox.pdmodel.graphics.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.<init>(COSDictionary)",
      "void PDTilingPattern.<init>(COSDictionary, ResourceCache)", "int PDTilingPattern.getPatternType()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.<init>(COSDictionary)",
      "void PDTilingPattern.<init>(COSDictionary, ResourceCache)", "int PDTilingPattern.getPatternType()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.<init>()"})
  void testNewPDTilingPattern() {
    // Arrange and Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern();

    // Assert
    assertTrue(actualPdTilingPattern.getCOSObject() instanceof COSStream);
    assertEquals("Pattern", actualPdTilingPattern.getType());
    assertNull(actualPdTilingPattern.getBBox());
    assertEquals(0, actualPdTilingPattern.getPaintType());
    assertEquals(0, actualPdTilingPattern.getTilingType());
    assertEquals(0.0f, actualPdTilingPattern.getXStep());
    assertEquals(0.0f, actualPdTilingPattern.getYStep());
    assertEquals(1, actualPdTilingPattern.getPatternType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setPaintType(int)"})
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
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} PaintType is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  @DisplayName("Test setPaintType(int); when MIN_VALUE; then PDTilingPattern() PaintType is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setPaintType(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTilingPattern.getPaintType()"})
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
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  @DisplayName("Test getPaintType(); given PDTilingPattern(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTilingPattern.getPaintType()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setTilingType(int)"})
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
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} TilingType is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  @DisplayName("Test setTilingType(int); when MIN_VALUE; then PDTilingPattern() TilingType is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setTilingType(int)"})
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
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getTilingType()}
   */
  @Test
  @DisplayName("Test getTilingType(); given PDTilingPattern(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTilingPattern.getTilingType()"})
  void testGetTilingType_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTilingPattern()).getTilingType());
  }

  /**
   * Test {@link PDTilingPattern#setXStep(float)}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setXStep(float)}
   */
  @Test
  @DisplayName("Test setXStep(float); given PDTilingPattern(); then PDTilingPattern() COSObject COSStream")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setXStep(float)"})
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
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getXStep()}
   */
  @Test
  @DisplayName("Test getXStep(); given PDTilingPattern(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTilingPattern.getXStep()"})
  void testGetXStep_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTilingPattern()).getXStep());
  }

  /**
   * Test {@link PDTilingPattern#setYStep(float)}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setYStep(float)}
   */
  @Test
  @DisplayName("Test setYStep(float); given PDTilingPattern(); then PDTilingPattern() COSObject COSStream")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setYStep(float)"})
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
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getYStep()}
   */
  @Test
  @DisplayName("Test getYStep(); given PDTilingPattern(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTilingPattern.getYStep()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDStream PDTilingPattern.getContentStream()"})
  void testGetContentStream() throws IOException {
    // Arrange and Act
    PDStream actualContentStream = (new PDTilingPattern()).getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Test {@link PDTilingPattern#getContents()}.
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDTilingPattern.getContents()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.io.RandomAccessRead PDTilingPattern.getContentsForRandomAccess()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDResources PDTilingPattern.getResources()"})
  void testGetResources_givenPDTilingPattern_thenColorSpaceNamesReturnSet() {
    // Arrange and Act
    PDResources actualResources = (new PDTilingPattern()).getResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDResources PDTilingPattern.getResources()"})
  void testGetResources_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getResources());
  }

  /**
   * Test {@link PDTilingPattern#setResources(PDResources)}.
   * <ul>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); then PDTilingPattern() COSObject Values size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setResources(PDResources)"})
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
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources); when 'null'; then PDTilingPattern() Resources is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setResources(PDResources)"})
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
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDTilingPattern(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDTilingPattern.getBBox()"})
  void testGetBBox_givenPDTilingPattern_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern()).getBBox());
  }

  /**
   * Test {@link PDTilingPattern#setBBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A1}.</li>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} BBox UpperRightX is {@code 1683.7795}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); when A1; then PDTilingPattern() BBox UpperRightX is '1683.7795'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setBBox(PDRectangle)"})
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
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); when 'null'; then PDTilingPattern() COSObject toIncrement Objects Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTilingPattern.setBBox(PDRectangle)"})
  void testSetBBox_whenNull_thenPDTilingPatternCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
