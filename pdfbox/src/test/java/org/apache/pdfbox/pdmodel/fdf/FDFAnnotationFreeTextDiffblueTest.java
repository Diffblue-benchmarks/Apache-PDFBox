package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class FDFAnnotationFreeTextDiffblueTest {
  /**
   * Test {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFreeText(COSDictionary)")
  void testNewFDFAnnotationFreeText() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationFreeText(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFreeText()")
  void testNewFDFAnnotationFreeText2() throws IOException {
    // Arrange and Act
    FDFAnnotationFreeText actualFdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Assert
    assertEquals("", actualFdfAnnotationFreeText.getRichContents());
    assertEquals("0", actualFdfAnnotationFreeText.getJustification());
    assertNull(actualFdfAnnotationFreeText.getCallout());
    assertNull(actualFdfAnnotationFreeText.getColor());
    assertNull(actualFdfAnnotationFreeText.getPage());
    assertNull(actualFdfAnnotationFreeText.getContents());
    assertNull(actualFdfAnnotationFreeText.getDate());
    assertNull(actualFdfAnnotationFreeText.getIntent());
    assertNull(actualFdfAnnotationFreeText.getName());
    assertNull(actualFdfAnnotationFreeText.getSubject());
    assertNull(actualFdfAnnotationFreeText.getTitle());
    assertNull(actualFdfAnnotationFreeText.getDefaultAppearance());
    assertNull(actualFdfAnnotationFreeText.getDefaultStyle());
    assertNull(actualFdfAnnotationFreeText.getLineEndingStyle());
    assertNull(actualFdfAnnotationFreeText.getRotation());
    assertNull(actualFdfAnnotationFreeText.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationFreeText.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationFreeText.getRectangle());
    assertNull(actualFdfAnnotationFreeText.getFringe());
    assertNull(actualFdfAnnotationFreeText.getBorderEffect());
    assertNull(actualFdfAnnotationFreeText.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationFreeText.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationFreeText.isHidden());
    assertFalse(actualFdfAnnotationFreeText.isInvisible());
    assertFalse(actualFdfAnnotationFreeText.isLocked());
    assertFalse(actualFdfAnnotationFreeText.isLockedContents());
    assertFalse(actualFdfAnnotationFreeText.isNoRotate());
    assertFalse(actualFdfAnnotationFreeText.isNoView());
    assertFalse(actualFdfAnnotationFreeText.isNoZoom());
    assertFalse(actualFdfAnnotationFreeText.isPrinted());
    assertFalse(actualFdfAnnotationFreeText.isReadOnly());
    assertFalse(actualFdfAnnotationFreeText.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setCallout(float[])}.
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject
   * Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setCallout(float[])}
   */
  @Test
  @DisplayName("Test setCallout(float[]); then FDFAnnotationFreeText() COSObject Values size is three")
  void testSetCallout_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setCallout(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationFreeText.getCallout(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationFreeText#getCallout()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetCallout_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText(new COSDictionary())).getCallout());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getCallout()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout(); given FDFAnnotationFreeText(); then return 'null'")
  void testGetCallout_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText()).getCallout());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getCallout()}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout(); then return array of float with ten and '0.5'")
  void testGetCallout_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setCallout(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationFreeText.getCallout(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationFreeText#setJustification(String)}.
   * <ul>
   *   <li>When {@code centered}.</li>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification
   * is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setJustification(String)}
   */
  @Test
  @DisplayName("Test setJustification(String); when 'centered'; then FDFAnnotationFreeText() Justification is '1'")
  void testSetJustification_whenCentered_thenFDFAnnotationFreeTextJustificationIs1() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setJustification("centered");

    // Assert
    assertEquals("1", fdfAnnotationFreeText.getJustification());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setJustification(String)}.
   * <ul>
   *   <li>When {@code Justification}.</li>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification
   * is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setJustification(String)}
   */
  @Test
  @DisplayName("Test setJustification(String); when 'Justification'; then FDFAnnotationFreeText() Justification is '0'")
  void testSetJustification_whenJustification_thenFDFAnnotationFreeTextJustificationIs0() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setJustification("Justification");

    // Assert
    assertEquals("0", fdfAnnotationFreeText.getJustification());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setJustification(String)}.
   * <ul>
   *   <li>When {@code right}.</li>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification
   * is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setJustification(String)}
   */
  @Test
  @DisplayName("Test setJustification(String); when 'right'; then FDFAnnotationFreeText() Justification is '2'")
  void testSetJustification_whenRight_thenFDFAnnotationFreeTextJustificationIs2() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setJustification("right");

    // Assert
    assertEquals("2", fdfAnnotationFreeText.getJustification());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getJustification()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification
   * is {@code Justification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getJustification()}
   */
  @Test
  @DisplayName("Test getJustification(); given FDFAnnotationFreeText() Justification is 'Justification'")
  void testGetJustification_givenFDFAnnotationFreeTextJustificationIsJustification() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setJustification("Justification");

    // Act and Assert
    assertEquals("0", fdfAnnotationFreeText.getJustification());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getJustification()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getJustification()}
   */
  @Test
  @DisplayName("Test getJustification(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return '0'")
  void testGetJustification_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", (new FDFAnnotationFreeText(new COSDictionary())).getJustification());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getJustification()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getJustification()}
   */
  @Test
  @DisplayName("Test getJustification(); given FDFAnnotationFreeText(); then return '0'")
  void testGetJustification_givenFDFAnnotationFreeText_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", (new FDFAnnotationFreeText()).getJustification());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setRotation(int)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject
   * Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int); then FDFAnnotationFreeText() COSObject Values size is three")
  void testSetRotation_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setRotation(1);

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setRotation(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int); when MIN_VALUE")
  void testSetRotation_whenMin_value() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setRotation(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getRotation()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetRotation_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText(new COSDictionary())).getRotation());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getRotation()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given FDFAnnotationFreeText(); then return 'null'")
  void testGetRotation_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText()).getRotation());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setDefaultAppearance(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}
   * DefaultAppearance is {@code Appearance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName("Test setDefaultAppearance(String); then FDFAnnotationFreeText() DefaultAppearance is 'Appearance'")
  void testSetDefaultAppearance_thenFDFAnnotationFreeTextDefaultAppearanceIsAppearance() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setDefaultAppearance("Appearance");

    // Assert
    assertEquals("Appearance", fdfAnnotationFreeText.getDefaultAppearance());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary()")
  void testGetDefaultAppearance_givenFDFAnnotationFreeTextWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText(new COSDictionary())).getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); given FDFAnnotationFreeText(); then return 'null'")
  void testGetDefaultAppearance_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText()).getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   * <ul>
   *   <li>Then return {@code Appearance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return 'Appearance'")
  void testGetDefaultAppearance_thenReturnAppearance() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultAppearance("Appearance");

    // Act and Assert
    assertEquals("Appearance", fdfAnnotationFreeText.getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   * <ul>
   *   <li>Then return {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return ','")
  void testGetDefaultAppearance_thenReturnComma() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultAppearance(",");

    // Act and Assert
    assertEquals(",", fdfAnnotationFreeText.getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setDefaultStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} DefaultStyle
   * is {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setDefaultStyle(String)}
   */
  @Test
  @DisplayName("Test setDefaultStyle(String); then FDFAnnotationFreeText() DefaultStyle is 'Style'")
  void testSetDefaultStyle_thenFDFAnnotationFreeTextDefaultStyleIsStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setDefaultStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationFreeText.getDefaultStyle());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary()")
  void testGetDefaultStyle_givenFDFAnnotationFreeTextWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText(new COSDictionary())).getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); given FDFAnnotationFreeText(); then return 'null'")
  void testGetDefaultStyle_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText()).getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   * <ul>
   *   <li>Then return {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); then return ','")
  void testGetDefaultStyle_thenReturnComma() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultStyle(",");

    // Act and Assert
    assertEquals(",", fdfAnnotationFreeText.getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   * <ul>
   *   <li>Then return {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); then return 'Style'")
  void testGetDefaultStyle_thenReturnStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultStyle("Style");

    // Act and Assert
    assertEquals("Style", fdfAnnotationFreeText.getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setFringe(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Fringe
   * UpperRightX is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); when A0; then FDFAnnotationFreeText() Fringe UpperRightX is '2383.937'")
  void testSetFringe_whenA0_thenFDFAnnotationFreeTextFringeUpperRightXIs2383937() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationFreeText.getFringe();
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setFringe(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject
   * toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); when 'null'; then FDFAnnotationFreeText() COSObject toIncrement Objects Empty")
  void testSetFringe_whenNull_thenFDFAnnotationFreeTextCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setFringe(null);

    // Assert
    COSIncrement toIncrementResult = fdfAnnotationFreeText.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetFringe_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText(new COSDictionary())).getFringe());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationFreeText(); then return 'null'")
  void testGetFringe_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText()).getFringe());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return COSArray toList third Key is 'null'")
  void testGetFringe_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationFreeText.getFringe();

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
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return Height is zero")
  void testGetFringe_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setFringe(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualFringe = fdfAnnotationFreeText.getFringe();

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

  /**
   * Test {@link FDFAnnotationFreeText#setLineEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}
   * LineEndingStyle is {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setLineEndingStyle(String); then FDFAnnotationFreeText() LineEndingStyle is 'Style'")
  void testSetLineEndingStyle_thenFDFAnnotationFreeTextLineEndingStyleIsStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setLineEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setLineEndingStyle(String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}
   * LineEndingStyle is {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setLineEndingStyle(String); when ','; then FDFAnnotationFreeText() LineEndingStyle is ','")
  void testSetLineEndingStyle_whenComma_thenFDFAnnotationFreeTextLineEndingStyleIsComma() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setLineEndingStyle(",");

    // Assert
    assertEquals(",", fdfAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getLineEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   * with a is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary()")
  void testGetLineEndingStyle_givenFDFAnnotationFreeTextWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText(new COSDictionary())).getLineEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getLineEndingStyle()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle(); given FDFAnnotationFreeText(); then return 'null'")
  void testGetLineEndingStyle_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationFreeText()).getLineEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getLineEndingStyle()}.
   * <ul>
   *   <li>Then return {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle(); then return 'Style'")
  void testGetLineEndingStyle_thenReturnStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setLineEndingStyle("Style");

    // Act and Assert
    assertEquals("Style", fdfAnnotationFreeText.getLineEndingStyle());
  }
}
