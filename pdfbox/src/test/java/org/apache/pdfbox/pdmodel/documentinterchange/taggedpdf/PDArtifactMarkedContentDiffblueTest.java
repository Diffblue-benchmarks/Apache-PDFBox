package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDArtifactMarkedContentDiffblueTest {
  /**
   * Test {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDArtifactMarkedContent(COSDictionary)")
  void testNewPDArtifactMarkedContent() {
    // Arrange
    COSDictionary properties = new COSDictionary();

    // Act
    PDArtifactMarkedContent actualPdArtifactMarkedContent = new PDArtifactMarkedContent(properties);

    // Assert
    assertEquals("Artifact", actualPdArtifactMarkedContent.getTag());
    assertNull(actualPdArtifactMarkedContent.getActualText());
    assertNull(actualPdArtifactMarkedContent.getAlternateDescription());
    assertNull(actualPdArtifactMarkedContent.getExpandedForm());
    assertNull(actualPdArtifactMarkedContent.getLanguage());
    assertNull(actualPdArtifactMarkedContent.getSubtype());
    assertNull(actualPdArtifactMarkedContent.getType());
    assertNull(actualPdArtifactMarkedContent.getBBox());
    assertEquals(-1, actualPdArtifactMarkedContent.getMCID());
    assertFalse(actualPdArtifactMarkedContent.isBottomAttached());
    assertFalse(actualPdArtifactMarkedContent.isLeftAttached());
    assertFalse(actualPdArtifactMarkedContent.isRightAttached());
    assertFalse(actualPdArtifactMarkedContent.isTopAttached());
    assertTrue(actualPdArtifactMarkedContent.getContents().isEmpty());
    assertSame(properties, actualPdArtifactMarkedContent.getProperties());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getType()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testGetType_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getType()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream(); then return 'null'")
  void testGetType_givenPDArtifactMarkedContentWithPropertiesIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSStream())).getType());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getBBox()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testGetBBox_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSDictionary())).getBBox());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getBBox()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream(); then return 'null'")
  void testGetBBox_givenPDArtifactMarkedContentWithPropertiesIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSStream())).getBBox());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isTopAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isTopAttached()}
   */
  @Test
  @DisplayName("Test isTopAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testIsTopAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isTopAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isTopAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isTopAttached()}
   */
  @Test
  @DisplayName("Test isTopAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream()")
  void testIsTopAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSStream())).isTopAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isBottomAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isBottomAttached()}
   */
  @Test
  @DisplayName("Test isBottomAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testIsBottomAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isBottomAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isBottomAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isBottomAttached()}
   */
  @Test
  @DisplayName("Test isBottomAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream()")
  void testIsBottomAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSStream())).isBottomAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isLeftAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isLeftAttached()}
   */
  @Test
  @DisplayName("Test isLeftAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testIsLeftAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isLeftAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isLeftAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isLeftAttached()}
   */
  @Test
  @DisplayName("Test isLeftAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream()")
  void testIsLeftAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSStream())).isLeftAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isRightAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isRightAttached()}
   */
  @Test
  @DisplayName("Test isRightAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testIsRightAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isRightAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isRightAttached()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isRightAttached()}
   */
  @Test
  @DisplayName("Test isRightAttached(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream()")
  void testIsRightAttached_givenPDArtifactMarkedContentWithPropertiesIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSStream())).isRightAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getSubtype()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDArtifactMarkedContent(COSDictionary) with properties is COSDictionary()")
  void testGetSubtype_givenPDArtifactMarkedContentWithPropertiesIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSDictionary())).getSubtype());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getSubtype()}.
   * <ul>
   *   <li>Given
   * {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)} with
   * properties is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDArtifactMarkedContent(COSDictionary) with properties is COSStream()")
  void testGetSubtype_givenPDArtifactMarkedContentWithPropertiesIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSStream())).getSubtype());
  }
}
