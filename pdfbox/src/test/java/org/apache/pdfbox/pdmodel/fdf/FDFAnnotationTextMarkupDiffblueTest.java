package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFAnnotationTextMarkupDiffblueTest {
  /**
   * Test {@link FDFAnnotationTextMarkup#setCoords(float[])}.
   * <ul>
   *   <li>Then {@link FDFAnnotationHighlight#FDFAnnotationHighlight()} COSObject
   * Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationTextMarkup#setCoords(float[])}
   */
  @Test
  @DisplayName("Test setCoords(float[]); then FDFAnnotationHighlight() COSObject Values size is three")
  void testSetCoords_thenFDFAnnotationHighlightCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationHighlight fdfAnnotationHighlight = new FDFAnnotationHighlight();

    // Act
    fdfAnnotationHighlight.setCoords(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationHighlight.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationHighlight.getCoords(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationTextMarkup#getCoords()}.
   * <ul>
   *   <li>Given
   * {@link FDFAnnotationHighlight#FDFAnnotationHighlight(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationTextMarkup#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); given FDFAnnotationHighlight(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetCoords_givenFDFAnnotationHighlightWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationHighlight(new COSDictionary())).getCoords());
  }

  /**
   * Test {@link FDFAnnotationTextMarkup#getCoords()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationHighlight#FDFAnnotationHighlight()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationTextMarkup#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); given FDFAnnotationHighlight(); then return 'null'")
  void testGetCoords_givenFDFAnnotationHighlight_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationHighlight()).getCoords());
  }

  /**
   * Test {@link FDFAnnotationTextMarkup#getCoords()}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationTextMarkup#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); then return array of float with ten and '0.5'")
  void testGetCoords_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationHighlight fdfAnnotationHighlight = new FDFAnnotationHighlight();
    fdfAnnotationHighlight.setCoords(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationHighlight.getCoords(), 0.0f);
  }
}
