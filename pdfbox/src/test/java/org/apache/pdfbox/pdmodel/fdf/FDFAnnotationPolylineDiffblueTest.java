package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFAnnotationPolylineDiffblueTest {
  /**
   * Test {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolyline(COSDictionary)")
  void testNewFDFAnnotationPolyline() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationPolyline(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolyline()")
  void testNewFDFAnnotationPolyline2() throws IOException {
    // Arrange and Act
    FDFAnnotationPolyline actualFdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Assert
    assertEquals("", actualFdfAnnotationPolyline.getRichContents());
    assertEquals("None", actualFdfAnnotationPolyline.getEndPointEndingStyle());
    assertEquals("None", actualFdfAnnotationPolyline.getStartPointEndingStyle());
    assertNull(actualFdfAnnotationPolyline.getVertices());
    assertNull(actualFdfAnnotationPolyline.getColor());
    assertNull(actualFdfAnnotationPolyline.getInteriorColor());
    assertNull(actualFdfAnnotationPolyline.getPage());
    assertNull(actualFdfAnnotationPolyline.getContents());
    assertNull(actualFdfAnnotationPolyline.getDate());
    assertNull(actualFdfAnnotationPolyline.getIntent());
    assertNull(actualFdfAnnotationPolyline.getName());
    assertNull(actualFdfAnnotationPolyline.getSubject());
    assertNull(actualFdfAnnotationPolyline.getTitle());
    assertNull(actualFdfAnnotationPolyline.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationPolyline.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationPolyline.getRectangle());
    assertNull(actualFdfAnnotationPolyline.getBorderEffect());
    assertNull(actualFdfAnnotationPolyline.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationPolyline.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationPolyline.isHidden());
    assertFalse(actualFdfAnnotationPolyline.isInvisible());
    assertFalse(actualFdfAnnotationPolyline.isLocked());
    assertFalse(actualFdfAnnotationPolyline.isLockedContents());
    assertFalse(actualFdfAnnotationPolyline.isNoRotate());
    assertFalse(actualFdfAnnotationPolyline.isNoView());
    assertFalse(actualFdfAnnotationPolyline.isNoZoom());
    assertFalse(actualFdfAnnotationPolyline.isPrinted());
    assertFalse(actualFdfAnnotationPolyline.isReadOnly());
    assertFalse(actualFdfAnnotationPolyline.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setVertices(float[])}.
   * <ul>
   *   <li>Then {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} COSObject
   * Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#setVertices(float[])}
   */
  @Test
  @DisplayName("Test setVertices(float[]); then FDFAnnotationPolyline() COSObject Values size is three")
  void testSetVertices_thenFDFAnnotationPolylineCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolyline#getVertices()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); given FDFAnnotationPolyline(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetVertices_givenFDFAnnotationPolylineWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolyline(new COSDictionary())).getVertices());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getVertices()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); given FDFAnnotationPolyline(); then return 'null'")
  void testGetVertices_givenFDFAnnotationPolyline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolyline()).getVertices());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getVertices()}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); then return array of float with ten and '0.5'")
  void testGetVertices_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline(new COSDictionary());

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle3() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle4() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle(",|;");

    // Assert
    assertEquals(",|;", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   * EndPointEndingStyle is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String); given FDFAnnotationPolyline() EndPointEndingStyle is 'None'")
  void testSetStartPointEndingStyle_givenFDFAnnotationPolylineEndPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setEndPointEndingStyle("None");

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getStartPointEndingStyle()}.
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle()")
  void testGetStartPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationPolyline.getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getStartPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle(); given FDFAnnotationPolyline(COSDictionary) with a is COSDictionary()")
  void testGetStartPointEndingStyle_givenFDFAnnotationPolylineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationPolyline(new COSDictionary())).getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getStartPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.</li>
   *   <li>Then return {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle(); given FDFAnnotationPolyline(); then return 'None'")
  void testGetStartPointEndingStyle_givenFDFAnnotationPolyline_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationPolyline()).getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String)")
  void testSetEndPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline(new COSDictionary());

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String)")
  void testSetEndPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle(",|;");

    // Assert
    assertEquals(",|;", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   * StartPointEndingStyle is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); given FDFAnnotationPolyline() StartPointEndingStyle is 'None'")
  void testSetEndPointEndingStyle_givenFDFAnnotationPolylineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   * EndPointEndingStyle is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then FDFAnnotationPolyline() EndPointEndingStyle is 'None'")
  void testSetEndPointEndingStyle_thenFDFAnnotationPolylineEndPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   * EndPointEndingStyle is {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then FDFAnnotationPolyline() EndPointEndingStyle is 'Style'")
  void testSetEndPointEndingStyle_thenFDFAnnotationPolylineEndPointEndingStyleIsStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getEndPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   * StartPointEndingStyle is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationPolyline() StartPointEndingStyle is 'None'")
  void testGetEndPointEndingStyle_givenFDFAnnotationPolylineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationPolyline.getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getEndPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationPolyline(COSDictionary) with a is COSDictionary()")
  void testGetEndPointEndingStyle_givenFDFAnnotationPolylineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationPolyline(new COSDictionary())).getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getEndPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.</li>
   *   <li>Then return {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationPolyline(); then return 'None'")
  void testGetEndPointEndingStyle_givenFDFAnnotationPolyline_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationPolyline()).getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationPolyline(COSDictionary) with a is COSDictionary()")
  void testGetInteriorColor_givenFDFAnnotationPolylineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolyline(new COSDictionary())).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationPolyline(); then return 'null'")
  void testGetInteriorColor_givenFDFAnnotationPolyline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolyline()).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getInteriorColor()}.
   * <ul>
   *   <li>Then return decode {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolyline#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); then return decode '42'")
  void testGetInteriorColor_thenReturnDecode42() throws NumberFormatException {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    Color color = Color.decode("42");
    fdfAnnotationPolyline.setInteriorColor(color);

    // Act and Assert
    assertEquals(color, fdfAnnotationPolyline.getInteriorColor());
  }
}
