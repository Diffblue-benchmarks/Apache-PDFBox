package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAppearanceEntryDiffblueTest {
  /**
   * Test {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)}.
   * <p>
   * Method under test: {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAppearanceEntry(COSDictionary)")
  void testNewPDAppearanceEntry() {
    // Arrange
    COSDictionary entry = new COSDictionary();

    // Act and Assert
    assertSame(entry, (new PDAppearanceEntry(entry)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceEntry#getCOSObject()}.
   * <p>
   * Method under test: {@link PDAppearanceEntry#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    COSDictionary entry = new COSDictionary();

    // Act and Assert
    assertSame(entry, (new PDAppearanceEntry(entry)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceEntry#isSubDictionary()}.
   * <ul>
   *   <li>Given {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)} with
   * entry is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isSubDictionary()}
   */
  @Test
  @DisplayName("Test isSubDictionary(); given PDAppearanceEntry(COSDictionary) with entry is COSStream(); then return 'false'")
  void testIsSubDictionary_givenPDAppearanceEntryWithEntryIsCOSStream_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDAppearanceEntry(new COSStream())).isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceEntry#isSubDictionary()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isSubDictionary()}
   */
  @Test
  @DisplayName("Test isSubDictionary(); then return 'true'")
  void testIsSubDictionary_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceEntry(new COSDictionary())).isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceEntry#isStream()}.
   * <ul>
   *   <li>Given {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)} with
   * entry is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isStream()}
   */
  @Test
  @DisplayName("Test isStream(); given PDAppearanceEntry(COSDictionary) with entry is COSDictionary(); then return 'false'")
  void testIsStream_givenPDAppearanceEntryWithEntryIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDAppearanceEntry(new COSDictionary())).isStream());
  }

  /**
   * Test {@link PDAppearanceEntry#isStream()}.
   * <ul>
   *   <li>Given {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)} with
   * entry is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isStream()}
   */
  @Test
  @DisplayName("Test isStream(); given PDAppearanceEntry(COSDictionary) with entry is COSStream(); then return 'true'")
  void testIsStream_givenPDAppearanceEntryWithEntryIsCOSStream_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceEntry(new COSStream())).isStream());
  }

  /**
   * Test {@link PDAppearanceEntry#getAppearanceStream()}.
   * <ul>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getAppearanceStream()}
   */
  @Test
  @DisplayName("Test getAppearanceStream(); then return Stream DecodeParms is 'null'")
  void testGetAppearanceStream_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    COSStream entry = new COSStream();

    // Act
    PDAppearanceStream actualAppearanceStream = (new PDAppearanceEntry(entry)).getAppearanceStream();

    // Assert
    PDStream stream = actualAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = actualAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualAppearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualAppearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualAppearanceStream.getOptionalContent());
    assertNull(actualAppearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualAppearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualAppearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualAppearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(entry, stream.getCOSObject());
    assertSame(entry, contentStream.getCOSObject());
    assertSame(entry, actualAppearanceStream.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAppearanceEntry#getAppearanceStream()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getAppearanceStream()}
   */
  @Test
  @DisplayName("Test getAppearanceStream(); then throw IllegalStateException")
  void testGetAppearanceStream_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDAppearanceEntry(new COSDictionary())).getAppearanceStream());
  }

  /**
   * Test {@link PDAppearanceEntry#getSubDictionary()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getSubDictionary()}
   */
  @Test
  @DisplayName("Test getSubDictionary(); then return Empty")
  void testGetSubDictionary_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceEntry(new COSDictionary())).getSubDictionary().isEmpty());
  }

  /**
   * Test {@link PDAppearanceEntry#getSubDictionary()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getSubDictionary()}
   */
  @Test
  @DisplayName("Test getSubDictionary(); then throw IllegalStateException")
  void testGetSubDictionary_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDAppearanceEntry(new COSStream())).getSubDictionary());
  }
}
