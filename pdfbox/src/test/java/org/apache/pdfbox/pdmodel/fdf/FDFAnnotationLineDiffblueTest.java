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

class FDFAnnotationLineDiffblueTest {
  /**
   * Test {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationLine(COSDictionary)")
  void testNewFDFAnnotationLine() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationLine(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationLine#FDFAnnotationLine()}.
   * <p>
   * Method under test: {@link FDFAnnotationLine#FDFAnnotationLine()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationLine()")
  void testNewFDFAnnotationLine2() throws IOException {
    // Arrange and Act
    FDFAnnotationLine actualFdfAnnotationLine = new FDFAnnotationLine();

    // Assert
    assertEquals("", actualFdfAnnotationLine.getRichContents());
    assertEquals("None", actualFdfAnnotationLine.getEndPointEndingStyle());
    assertEquals("None", actualFdfAnnotationLine.getStartPointEndingStyle());
    assertNull(actualFdfAnnotationLine.getLine());
    assertNull(actualFdfAnnotationLine.getColor());
    assertNull(actualFdfAnnotationLine.getInteriorColor());
    assertNull(actualFdfAnnotationLine.getPage());
    assertNull(actualFdfAnnotationLine.getContents());
    assertNull(actualFdfAnnotationLine.getDate());
    assertNull(actualFdfAnnotationLine.getIntent());
    assertNull(actualFdfAnnotationLine.getName());
    assertNull(actualFdfAnnotationLine.getSubject());
    assertNull(actualFdfAnnotationLine.getTitle());
    assertNull(actualFdfAnnotationLine.getCaptionStyle());
    assertNull(actualFdfAnnotationLine.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationLine.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationLine.getRectangle());
    assertNull(actualFdfAnnotationLine.getBorderEffect());
    assertNull(actualFdfAnnotationLine.getBorderStyle());
    assertEquals(-1.0f, actualFdfAnnotationLine.getLeaderExtend());
    assertEquals(-1.0f, actualFdfAnnotationLine.getLeaderLength());
    assertEquals(-1.0f, actualFdfAnnotationLine.getLeaderOffset());
    assertEquals(0.0f, actualFdfAnnotationLine.getCaptionHorizontalOffset());
    assertEquals(0.0f, actualFdfAnnotationLine.getCaptionVerticalOffset());
    assertEquals(1.0f, actualFdfAnnotationLine.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationLine.isHidden());
    assertFalse(actualFdfAnnotationLine.isInvisible());
    assertFalse(actualFdfAnnotationLine.isLocked());
    assertFalse(actualFdfAnnotationLine.isLockedContents());
    assertFalse(actualFdfAnnotationLine.isNoRotate());
    assertFalse(actualFdfAnnotationLine.isNoView());
    assertFalse(actualFdfAnnotationLine.isNoZoom());
    assertFalse(actualFdfAnnotationLine.isPrinted());
    assertFalse(actualFdfAnnotationLine.isReadOnly());
    assertFalse(actualFdfAnnotationLine.isToggleNoView());
    assertFalse(actualFdfAnnotationLine.getCaption());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationLine#setLine(float[])}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} COSObject Values size
   * is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setLine(float[])}
   */
  @Test
  @DisplayName("Test setLine(float[]); then FDFAnnotationLine() COSObject Values size is three")
  void testSetLine_thenFDFAnnotationLineCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setLine(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationLine.getLine(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationLine#getLine()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLine()}
   */
  @Test
  @DisplayName("Test getLine(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetLine_givenFDFAnnotationLineWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationLine(new COSDictionary())).getLine());
  }

  /**
   * Test {@link FDFAnnotationLine#getLine()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLine()}
   */
  @Test
  @DisplayName("Test getLine(); given FDFAnnotationLine(); then return 'null'")
  void testGetLine_givenFDFAnnotationLine_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationLine()).getLine());
  }

  /**
   * Test {@link FDFAnnotationLine#getLine()}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLine()}
   */
  @Test
  @DisplayName("Test getLine(); then return array of float with ten and '0.5'")
  void testGetLine_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setLine(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationLine.getLine(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationLine#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test: {@link FDFAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine(new COSDictionary());

    // Act
    fdfAnnotationLine.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setStartPointEndingStyle(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} EndPointEndingStyle
   * is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String); given FDFAnnotationLine() EndPointEndingStyle is 'None'")
  void testSetStartPointEndingStyle_givenFDFAnnotationLineEndPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setEndPointEndingStyle("None");

    // Act
    fdfAnnotationLine.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setStartPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} StartPointEndingStyle
   * is {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String); then FDFAnnotationLine() StartPointEndingStyle is ','")
  void testSetStartPointEndingStyle_thenFDFAnnotationLineStartPointEndingStyleIsComma() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setStartPointEndingStyle(",");

    // Assert
    assertEquals(",", fdfAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setStartPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} StartPointEndingStyle
   * is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String); then FDFAnnotationLine() StartPointEndingStyle is 'None'")
  void testSetStartPointEndingStyle_thenFDFAnnotationLineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setStartPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setStartPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} StartPointEndingStyle
   * is {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String); then FDFAnnotationLine() StartPointEndingStyle is 'Style'")
  void testSetStartPointEndingStyle_thenFDFAnnotationLineStartPointEndingStyleIsStyle() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getStartPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} StartPointEndingStyle
   * is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle(); given FDFAnnotationLine() StartPointEndingStyle is 'None'")
  void testGetStartPointEndingStyle_givenFDFAnnotationLineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationLine.getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getStartPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetStartPointEndingStyle_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationLine(new COSDictionary())).getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getStartPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle(); given FDFAnnotationLine(); then return 'None'")
  void testGetStartPointEndingStyle_givenFDFAnnotationLine_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationLine()).getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#setEndPointEndingStyle(String)}.
   * <p>
   * Method under test: {@link FDFAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String)")
  void testSetEndPointEndingStyle() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine(new COSDictionary());

    // Act
    fdfAnnotationLine.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} StartPointEndingStyle
   * is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); given FDFAnnotationLine() StartPointEndingStyle is 'None'")
  void testSetEndPointEndingStyle_givenFDFAnnotationLineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setStartPointEndingStyle("None");

    // Act
    fdfAnnotationLine.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} EndPointEndingStyle is
   * {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then FDFAnnotationLine() EndPointEndingStyle is ','")
  void testSetEndPointEndingStyle_thenFDFAnnotationLineEndPointEndingStyleIsComma() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setEndPointEndingStyle(",");

    // Assert
    assertEquals(",", fdfAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} EndPointEndingStyle is
   * {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then FDFAnnotationLine() EndPointEndingStyle is 'None'")
  void testSetEndPointEndingStyle_thenFDFAnnotationLineEndPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setEndPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} EndPointEndingStyle is
   * {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then FDFAnnotationLine() EndPointEndingStyle is 'Style'")
  void testSetEndPointEndingStyle_thenFDFAnnotationLineEndPointEndingStyleIsStyle() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getEndPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} StartPointEndingStyle
   * is {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationLine() StartPointEndingStyle is 'None'")
  void testGetEndPointEndingStyle_givenFDFAnnotationLineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationLine.getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getEndPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetEndPointEndingStyle_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationLine(new COSDictionary())).getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getEndPointEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return {@code None}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationLine(); then return 'None'")
  void testGetEndPointEndingStyle_givenFDFAnnotationLine_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationLine()).getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetInteriorColor_givenFDFAnnotationLineWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationLine(new COSDictionary())).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationLine#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationLine(); then return 'null'")
  void testGetInteriorColor_givenFDFAnnotationLine_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationLine()).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationLine#getInteriorColor()}.
   * <ul>
   *   <li>Then return decode {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); then return decode '42'")
  void testGetInteriorColor_thenReturnDecode42() throws NumberFormatException {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    Color color = Color.decode("42");
    fdfAnnotationLine.setInteriorColor(color);

    // Act and Assert
    assertEquals(color, fdfAnnotationLine.getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaption(boolean)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link FDFAnnotationLine#FDFAnnotationLine()} Caption.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setCaption(boolean)}
   */
  @Test
  @DisplayName("Test setCaption(boolean); given FDFAnnotationLine(); when 'false'; then not FDFAnnotationLine() Caption")
  void testSetCaption_givenFDFAnnotationLine_whenFalse_thenNotFDFAnnotationLineCaption() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setCaption(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationLine.getCaption());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaption(boolean)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} Caption.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setCaption(boolean)}
   */
  @Test
  @DisplayName("Test setCaption(boolean); given FDFAnnotationLine(); when 'true'; then FDFAnnotationLine() Caption")
  void testSetCaption_givenFDFAnnotationLine_whenTrue_thenFDFAnnotationLineCaption() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setCaption(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationLine.getCaption());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaption()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} Caption is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaption()}
   */
  @Test
  @DisplayName("Test getCaption(); given FDFAnnotationLine() Caption is 'false'; then return 'false'")
  void testGetCaption_givenFDFAnnotationLineCaptionIsFalse_thenReturnFalse() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaption(false);

    // Act and Assert
    assertFalse(fdfAnnotationLine.getCaption());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaption()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} Caption is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaption()}
   */
  @Test
  @DisplayName("Test getCaption(); given FDFAnnotationLine() Caption is 'true'; then return 'true'")
  void testGetCaption_givenFDFAnnotationLineCaptionIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaption(true);

    // Act and Assert
    assertTrue(fdfAnnotationLine.getCaption());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaption()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaption()}
   */
  @Test
  @DisplayName("Test getCaption(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary(); then return 'false'")
  void testGetCaption_givenFDFAnnotationLineWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationLine(new COSDictionary())).getCaption());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaption()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaption()}
   */
  @Test
  @DisplayName("Test getCaption(); given FDFAnnotationLine(); then return 'false'")
  void testGetCaption_givenFDFAnnotationLine_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationLine()).getCaption());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderLength()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} LeaderLength is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderLength()}
   */
  @Test
  @DisplayName("Test getLeaderLength(); given FDFAnnotationLine() LeaderLength is minus one")
  void testGetLeaderLength_givenFDFAnnotationLineLeaderLengthIsMinusOne() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setLeaderLength(-1.0f);

    // Act and Assert
    assertEquals(-1.0f, fdfAnnotationLine.getLeaderLength());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderLength()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderLength()}
   */
  @Test
  @DisplayName("Test getLeaderLength(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetLeaderLength_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new FDFAnnotationLine(new COSDictionary())).getLeaderLength());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderLength()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderLength()}
   */
  @Test
  @DisplayName("Test getLeaderLength(); given FDFAnnotationLine(); then return minus one")
  void testGetLeaderLength_givenFDFAnnotationLine_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new FDFAnnotationLine()).getLeaderLength());
  }

  /**
   * Test {@link FDFAnnotationLine#setLeaderLength(float)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} LeaderLength is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setLeaderLength(float)}
   */
  @Test
  @DisplayName("Test setLeaderLength(float); then FDFAnnotationLine() LeaderLength is ten")
  void testSetLeaderLength_thenFDFAnnotationLineLeaderLengthIsTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setLeaderLength(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getLeaderLength());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderExtend()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} LeaderExtend is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderExtend()}
   */
  @Test
  @DisplayName("Test getLeaderExtend(); given FDFAnnotationLine() LeaderExtend is minus one")
  void testGetLeaderExtend_givenFDFAnnotationLineLeaderExtendIsMinusOne() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setLeaderExtend(-1.0f);

    // Act and Assert
    assertEquals(-1.0f, fdfAnnotationLine.getLeaderExtend());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderExtend()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderExtend()}
   */
  @Test
  @DisplayName("Test getLeaderExtend(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetLeaderExtend_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new FDFAnnotationLine(new COSDictionary())).getLeaderExtend());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderExtend()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderExtend()}
   */
  @Test
  @DisplayName("Test getLeaderExtend(); given FDFAnnotationLine(); then return minus one")
  void testGetLeaderExtend_givenFDFAnnotationLine_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new FDFAnnotationLine()).getLeaderExtend());
  }

  /**
   * Test {@link FDFAnnotationLine#setLeaderExtend(float)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} LeaderExtend is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setLeaderExtend(float)}
   */
  @Test
  @DisplayName("Test setLeaderExtend(float); then FDFAnnotationLine() LeaderExtend is ten")
  void testSetLeaderExtend_thenFDFAnnotationLineLeaderExtendIsTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setLeaderExtend(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getLeaderExtend());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} LeaderOffset is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderOffset()}
   */
  @Test
  @DisplayName("Test getLeaderOffset(); given FDFAnnotationLine() LeaderOffset is minus one")
  void testGetLeaderOffset_givenFDFAnnotationLineLeaderOffsetIsMinusOne() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setLeaderOffset(-1.0f);

    // Act and Assert
    assertEquals(-1.0f, fdfAnnotationLine.getLeaderOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderOffset()}
   */
  @Test
  @DisplayName("Test getLeaderOffset(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetLeaderOffset_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new FDFAnnotationLine(new COSDictionary())).getLeaderOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#getLeaderOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getLeaderOffset()}
   */
  @Test
  @DisplayName("Test getLeaderOffset(); given FDFAnnotationLine(); then return minus one")
  void testGetLeaderOffset_givenFDFAnnotationLine_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new FDFAnnotationLine()).getLeaderOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#setLeaderOffset(float)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} LeaderOffset is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setLeaderOffset(float)}
   */
  @Test
  @DisplayName("Test setLeaderOffset(float); then FDFAnnotationLine() LeaderOffset is ten")
  void testSetLeaderOffset_thenFDFAnnotationLineLeaderOffsetIsTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setLeaderOffset(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getLeaderOffset());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} CaptionStyle is
   * {@code ,}.</li>
   *   <li>Then return {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionStyle()}
   */
  @Test
  @DisplayName("Test getCaptionStyle(); given FDFAnnotationLine() CaptionStyle is ','; then return ','")
  void testGetCaptionStyle_givenFDFAnnotationLineCaptionStyleIsComma_thenReturnComma() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaptionStyle(",");

    // Act and Assert
    assertEquals(",", fdfAnnotationLine.getCaptionStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionStyle()}
   */
  @Test
  @DisplayName("Test getCaptionStyle(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetCaptionStyle_givenFDFAnnotationLineWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationLine(new COSDictionary())).getCaptionStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionStyle()}
   */
  @Test
  @DisplayName("Test getCaptionStyle(); given FDFAnnotationLine(); then return 'null'")
  void testGetCaptionStyle_givenFDFAnnotationLine_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationLine()).getCaptionStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionStyle()}.
   * <ul>
   *   <li>Then return {@code Caption Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionStyle()}
   */
  @Test
  @DisplayName("Test getCaptionStyle(); then return 'Caption Style'")
  void testGetCaptionStyle_thenReturnCaptionStyle() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaptionStyle("Caption Style");

    // Act and Assert
    assertEquals("Caption Style", fdfAnnotationLine.getCaptionStyle());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationLine#FDFAnnotationLine()} CaptionStyle is
   * {@code Caption Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setCaptionStyle(String)}
   */
  @Test
  @DisplayName("Test setCaptionStyle(String); then FDFAnnotationLine() CaptionStyle is 'Caption Style'")
  void testSetCaptionStyle_thenFDFAnnotationLineCaptionStyleIsCaptionStyle() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setCaptionStyle("Caption Style");

    // Assert
    assertEquals("Caption Style", fdfAnnotationLine.getCaptionStyle());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionHorizontalOffset(float)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationLine#setCaptionHorizontalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionHorizontalOffset(float)")
  void testSetCaptionHorizontalOffset() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine(new COSDictionary());

    // Act
    fdfAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Assert
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(10.0f, fdfAnnotationLine.getCaptionHorizontalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionHorizontalOffset(float)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFAnnotationLine#setCaptionHorizontalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionHorizontalOffset(float); given FDFAnnotationLine()")
  void testSetCaptionHorizontalOffset_givenFDFAnnotationLine() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getCaptionHorizontalOffset());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionHorizontalOffset(float)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()} CaptionVerticalOffset
   * is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFAnnotationLine#setCaptionHorizontalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionHorizontalOffset(float); given FDFAnnotationLine() CaptionVerticalOffset is ten")
  void testSetCaptionHorizontalOffset_givenFDFAnnotationLineCaptionVerticalOffsetIsTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaptionVerticalOffset(10.0f);

    // Act
    fdfAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getCaptionHorizontalOffset());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionHorizontalOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionHorizontalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionHorizontalOffset(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetCaptionHorizontalOffset_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FDFAnnotationLine(new COSDictionary())).getCaptionHorizontalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionHorizontalOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionHorizontalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionHorizontalOffset(); given FDFAnnotationLine(); then return zero")
  void testGetCaptionHorizontalOffset_givenFDFAnnotationLine_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FDFAnnotationLine()).getCaptionHorizontalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionHorizontalOffset()}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionHorizontalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionHorizontalOffset(); then return ten")
  void testGetCaptionHorizontalOffset_thenReturnTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Act and Assert
    assertEquals(10.0f, fdfAnnotationLine.getCaptionHorizontalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionVerticalOffset(float)}.
   * <p>
   * Method under test: {@link FDFAnnotationLine#setCaptionVerticalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionVerticalOffset(float)")
  void testSetCaptionVerticalOffset() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine(new COSDictionary());

    // Act
    fdfAnnotationLine.setCaptionVerticalOffset(10.0f);

    // Assert
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(10.0f, fdfAnnotationLine.getCaptionVerticalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionVerticalOffset(float)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setCaptionVerticalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionVerticalOffset(float); given FDFAnnotationLine()")
  void testSetCaptionVerticalOffset_givenFDFAnnotationLine() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();

    // Act
    fdfAnnotationLine.setCaptionVerticalOffset(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getCaptionVerticalOffset());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#setCaptionVerticalOffset(float)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}
   * CaptionHorizontalOffset is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#setCaptionVerticalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionVerticalOffset(float); given FDFAnnotationLine() CaptionHorizontalOffset is ten")
  void testSetCaptionVerticalOffset_givenFDFAnnotationLineCaptionHorizontalOffsetIsTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Act
    fdfAnnotationLine.setCaptionVerticalOffset(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationLine.getCaptionVerticalOffset());
    COSDictionary cOSObject = fdfAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionVerticalOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}
   * CaptionHorizontalOffset is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionVerticalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionVerticalOffset(); given FDFAnnotationLine() CaptionHorizontalOffset is ten")
  void testGetCaptionVerticalOffset_givenFDFAnnotationLineCaptionHorizontalOffsetIsTen() {
    // Arrange
    FDFAnnotationLine fdfAnnotationLine = new FDFAnnotationLine();
    fdfAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Act and Assert
    assertEquals(0.0f, fdfAnnotationLine.getCaptionVerticalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionVerticalOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionVerticalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionVerticalOffset(); given FDFAnnotationLine(COSDictionary) with a is COSDictionary()")
  void testGetCaptionVerticalOffset_givenFDFAnnotationLineWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FDFAnnotationLine(new COSDictionary())).getCaptionVerticalOffset());
  }

  /**
   * Test {@link FDFAnnotationLine#getCaptionVerticalOffset()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationLine#FDFAnnotationLine()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationLine#getCaptionVerticalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionVerticalOffset(); given FDFAnnotationLine(); then return zero")
  void testGetCaptionVerticalOffset_givenFDFAnnotationLine_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FDFAnnotationLine()).getCaptionVerticalOffset());
  }
}
