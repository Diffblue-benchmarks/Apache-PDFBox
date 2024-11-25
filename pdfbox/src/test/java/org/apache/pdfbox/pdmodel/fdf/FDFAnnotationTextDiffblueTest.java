package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFAnnotationTextDiffblueTest {
  /**
   * Test {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationText(COSDictionary)")
  void testNewFDFAnnotationText() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationText(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationText#FDFAnnotationText()}.
   * <p>
   * Method under test: {@link FDFAnnotationText#FDFAnnotationText()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationText()")
  void testNewFDFAnnotationText2() throws IOException {
    // Arrange and Act
    FDFAnnotationText actualFdfAnnotationText = new FDFAnnotationText();

    // Assert
    assertEquals("", actualFdfAnnotationText.getRichContents());
    assertEquals("Note", actualFdfAnnotationText.getIcon());
    assertNull(actualFdfAnnotationText.getColor());
    assertNull(actualFdfAnnotationText.getPage());
    assertNull(actualFdfAnnotationText.getContents());
    assertNull(actualFdfAnnotationText.getDate());
    assertNull(actualFdfAnnotationText.getIntent());
    assertNull(actualFdfAnnotationText.getName());
    assertNull(actualFdfAnnotationText.getSubject());
    assertNull(actualFdfAnnotationText.getTitle());
    assertNull(actualFdfAnnotationText.getState());
    assertNull(actualFdfAnnotationText.getStateModel());
    assertNull(actualFdfAnnotationText.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationText.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationText.getRectangle());
    assertNull(actualFdfAnnotationText.getBorderEffect());
    assertNull(actualFdfAnnotationText.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationText.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationText.isHidden());
    assertFalse(actualFdfAnnotationText.isInvisible());
    assertFalse(actualFdfAnnotationText.isLocked());
    assertFalse(actualFdfAnnotationText.isLockedContents());
    assertFalse(actualFdfAnnotationText.isNoRotate());
    assertFalse(actualFdfAnnotationText.isNoView());
    assertFalse(actualFdfAnnotationText.isNoZoom());
    assertFalse(actualFdfAnnotationText.isPrinted());
    assertFalse(actualFdfAnnotationText.isReadOnly());
    assertFalse(actualFdfAnnotationText.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationText#setIcon(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.</li>
   *   <li>When {@code Icon}.</li>
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} Icon is
   * {@code Icon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#setIcon(String)}
   */
  @Test
  @DisplayName("Test setIcon(String); given FDFAnnotationText(); when 'Icon'; then FDFAnnotationText() Icon is 'Icon'")
  void testSetIcon_givenFDFAnnotationText_whenIcon_thenFDFAnnotationTextIconIsIcon() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setIcon("Icon");

    // Assert
    assertEquals("Icon", fdfAnnotationText.getIcon());
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationText#setIcon(String)}.
   * <ul>
   *   <li>When {@code IconIcon}.</li>
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} Icon is
   * {@code IconIcon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#setIcon(String)}
   */
  @Test
  @DisplayName("Test setIcon(String); when 'IconIcon'; then FDFAnnotationText() Icon is 'IconIcon'")
  void testSetIcon_whenIconIcon_thenFDFAnnotationTextIconIsIconIcon() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setIcon("IconIcon");

    // Assert
    assertEquals("IconIcon", fdfAnnotationText.getIcon());
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationText#getIcon()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} Icon is
   * {@code Note}.</li>
   *   <li>Then return {@code Note}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getIcon()}
   */
  @Test
  @DisplayName("Test getIcon(); given FDFAnnotationText() Icon is 'Note'; then return 'Note'")
  void testGetIcon_givenFDFAnnotationTextIconIsNote_thenReturnNote() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setIcon("Note");

    // Act and Assert
    assertEquals("Note", fdfAnnotationText.getIcon());
  }

  /**
   * Test {@link FDFAnnotationText#getIcon()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code Note}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getIcon()}
   */
  @Test
  @DisplayName("Test getIcon(); given FDFAnnotationText(COSDictionary) with a is COSDictionary(); then return 'Note'")
  void testGetIcon_givenFDFAnnotationTextWithAIsCOSDictionary_thenReturnNote() {
    // Arrange, Act and Assert
    assertEquals("Note", (new FDFAnnotationText(new COSDictionary())).getIcon());
  }

  /**
   * Test {@link FDFAnnotationText#getIcon()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.</li>
   *   <li>Then return {@code Note}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getIcon()}
   */
  @Test
  @DisplayName("Test getIcon(); given FDFAnnotationText(); then return 'Note'")
  void testGetIcon_givenFDFAnnotationText_thenReturnNote() {
    // Arrange, Act and Assert
    assertEquals("Note", (new FDFAnnotationText()).getIcon());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} State is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState(); given FDFAnnotationText() State is empty string; then return empty string")
  void testGetState_givenFDFAnnotationTextStateIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setState("");

    // Act and Assert
    assertEquals("", fdfAnnotationText.getState());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} State is
   * {@code MD}.</li>
   *   <li>Then return {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState(); given FDFAnnotationText() State is 'MD'; then return 'MD'")
  void testGetState_givenFDFAnnotationTextStateIsMd_thenReturnMd() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setState("MD");

    // Act and Assert
    assertEquals("MD", fdfAnnotationText.getState());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState(); given FDFAnnotationText(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetState_givenFDFAnnotationTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationText(new COSDictionary())).getState());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState(); given FDFAnnotationText(); then return 'null'")
  void testGetState_givenFDFAnnotationText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationText()).getState());
  }

  /**
   * Test {@link FDFAnnotationText#setState(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.</li>
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} State is
   * {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String); given FDFAnnotationText(); then FDFAnnotationText() State is 'MD'")
  void testSetState_givenFDFAnnotationText_thenFDFAnnotationTextStateIsMd() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setState("MD");

    // Assert
    assertEquals("MD", fdfAnnotationText.getState());
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} StateModel is
   * {@code MD}.</li>
   *   <li>Then return {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel(); given FDFAnnotationText() StateModel is 'MD'; then return 'MD'")
  void testGetStateModel_givenFDFAnnotationTextStateModelIsMd_thenReturnMd() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setStateModel("MD");

    // Act and Assert
    assertEquals("MD", fdfAnnotationText.getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel(); given FDFAnnotationText(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetStateModel_givenFDFAnnotationTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationText(new COSDictionary())).getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel(); given FDFAnnotationText(); then return 'null'")
  void testGetStateModel_givenFDFAnnotationText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationText()).getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel(); then return empty string")
  void testGetStateModel_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setStateModel("");

    // Act and Assert
    assertEquals("", fdfAnnotationText.getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#setStateModel(String)}.
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.</li>
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} StateModel is
   * {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName("Test setStateModel(String); given FDFAnnotationText(); then FDFAnnotationText() StateModel is 'MD'")
  void testSetStateModel_givenFDFAnnotationText_thenFDFAnnotationTextStateModelIsMd() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setStateModel("MD");

    // Assert
    assertEquals("MD", fdfAnnotationText.getStateModel());
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
