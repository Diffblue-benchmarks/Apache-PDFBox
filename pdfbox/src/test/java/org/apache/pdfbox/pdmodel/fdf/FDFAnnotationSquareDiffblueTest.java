package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFAnnotationSquareDiffblueTest {
  /**
   * Test {@link FDFAnnotationSquare#FDFAnnotationSquare(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationSquare#FDFAnnotationSquare(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSquare(COSDictionary)")
  void testNewFDFAnnotationSquare() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationSquare(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationSquare#FDFAnnotationSquare()}.
   * <p>
   * Method under test: {@link FDFAnnotationSquare#FDFAnnotationSquare()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSquare()")
  void testNewFDFAnnotationSquare2() throws IOException {
    // Arrange and Act
    FDFAnnotationSquare actualFdfAnnotationSquare = new FDFAnnotationSquare();

    // Assert
    assertEquals("", actualFdfAnnotationSquare.getRichContents());
    assertNull(actualFdfAnnotationSquare.getColor());
    assertNull(actualFdfAnnotationSquare.getInteriorColor());
    assertNull(actualFdfAnnotationSquare.getPage());
    assertNull(actualFdfAnnotationSquare.getContents());
    assertNull(actualFdfAnnotationSquare.getDate());
    assertNull(actualFdfAnnotationSquare.getIntent());
    assertNull(actualFdfAnnotationSquare.getName());
    assertNull(actualFdfAnnotationSquare.getSubject());
    assertNull(actualFdfAnnotationSquare.getTitle());
    assertNull(actualFdfAnnotationSquare.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationSquare.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationSquare.getRectangle());
    assertNull(actualFdfAnnotationSquare.getFringe());
    assertNull(actualFdfAnnotationSquare.getBorderEffect());
    assertNull(actualFdfAnnotationSquare.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationSquare.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationSquare.isHidden());
    assertFalse(actualFdfAnnotationSquare.isInvisible());
    assertFalse(actualFdfAnnotationSquare.isLocked());
    assertFalse(actualFdfAnnotationSquare.isLockedContents());
    assertFalse(actualFdfAnnotationSquare.isNoRotate());
    assertFalse(actualFdfAnnotationSquare.isNoView());
    assertFalse(actualFdfAnnotationSquare.isNoZoom());
    assertFalse(actualFdfAnnotationSquare.isPrinted());
    assertFalse(actualFdfAnnotationSquare.isReadOnly());
    assertFalse(actualFdfAnnotationSquare.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationSquare#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationSquare#FDFAnnotationSquare(COSDictionary)} with
   * a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationSquare(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetInteriorColor_givenFDFAnnotationSquareWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationSquare(new COSDictionary())).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationSquare#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationSquare#FDFAnnotationSquare()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationSquare(); then return 'null'")
  void testGetInteriorColor_givenFDFAnnotationSquare_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationSquare()).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationSquare#getInteriorColor()}.
   * <ul>
   *   <li>Then return decode {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); then return decode '42'")
  void testGetInteriorColor_thenReturnDecode42() throws NumberFormatException {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();
    Color color = Color.decode("42");
    fdfAnnotationSquare.setInteriorColor(color);

    // Act and Assert
    assertEquals(color, fdfAnnotationSquare.getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationSquare#setFringe(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link FDFAnnotationSquare#FDFAnnotationSquare()} Fringe UpperRightX
   * is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); when A0; then FDFAnnotationSquare() Fringe UpperRightX is '2383.937'")
  void testSetFringe_whenA0_thenFDFAnnotationSquareFringeUpperRightXIs2383937() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();

    // Act
    fdfAnnotationSquare.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationSquare.getFringe();
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
  }

  /**
   * Test {@link FDFAnnotationSquare#setFringe(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFAnnotationSquare#FDFAnnotationSquare()} COSObject
   * toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); when 'null'; then FDFAnnotationSquare() COSObject toIncrement Objects Empty")
  void testSetFringe_whenNull_thenFDFAnnotationSquareCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();

    // Act
    fdfAnnotationSquare.setFringe(null);

    // Assert
    COSIncrement toIncrementResult = fdfAnnotationSquare.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationSquare#FDFAnnotationSquare(COSDictionary)} with
   * a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationSquare(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetFringe_givenFDFAnnotationSquareWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationSquare(new COSDictionary())).getFringe());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationSquare#FDFAnnotationSquare()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationSquare(); then return 'null'")
  void testGetFringe_givenFDFAnnotationSquare_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationSquare()).getFringe());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return COSArray toList third Key is 'null'")
  void testGetFringe_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();
    fdfAnnotationSquare.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationSquare.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualFringe.getLowerLeftX());
    assertEquals(0.0f, actualFringe.getLowerLeftY());
    assertEquals(2383.937f, actualFringe.getUpperRightX());
    assertEquals(2383.937f, actualFringe.getWidth());
    assertEquals(3370.3938f, actualFringe.getHeight());
    assertEquals(3370.3938f, actualFringe.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return Height is zero")
  void testGetFringe_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();
    fdfAnnotationSquare.setFringe(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualFringe = fdfAnnotationSquare.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFringe.getHeight());
    assertEquals(0.0f, actualFringe.getWidth());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightX());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }
}
