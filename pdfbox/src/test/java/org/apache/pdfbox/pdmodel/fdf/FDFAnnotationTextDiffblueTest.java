package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFAnnotationTextDiffblueTest {
  /**
   * Test {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationText#FDFAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationText(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.<init>(COSDictionary)"})
  void testNewFDFAnnotationText() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationText(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationText#FDFAnnotationText()}.
   *
   * <p>Method under test: {@link FDFAnnotationText#FDFAnnotationText()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.<init>()"})
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
    assertNull(actualFdfAnnotationText.getRectangle());
    assertNull(actualFdfAnnotationText.getBorderEffect());
    assertNull(actualFdfAnnotationText.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationText.getOpacity());
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
  }

  /**
   * Test {@link FDFAnnotationText#FDFAnnotationText(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#FDFAnnotationText(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationText(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.<init>(Element)"})
  void testNewFDFAnnotationText_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationText(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationText#setIcon(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>When {@code Icon}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} Icon is {@code Icon}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setIcon(String)}
   */
  @Test
  @DisplayName(
      "Test setIcon(String); given FDFAnnotationText(); when 'Icon'; then FDFAnnotationText() Icon is 'Icon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setIcon(String)"})
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
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} Icon is {@code Note}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setIcon(String)}
   */
  @Test
  @DisplayName(
      "Test setIcon(String); given FDFAnnotationText(); when 'null'; then FDFAnnotationText() Icon is 'Note'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setIcon(String)"})
  void testSetIcon_givenFDFAnnotationText_whenNull_thenFDFAnnotationTextIconIsNote() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setIcon(null);

    // Assert that nothing has changed
    assertEquals("Note", fdfAnnotationText.getIcon());
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationText#setIcon(String)}.
   *
   * <ul>
   *   <li>When {@code statemodel}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} Icon is {@code statemodel}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setIcon(String)}
   */
  @Test
  @DisplayName(
      "Test setIcon(String); when 'statemodel'; then FDFAnnotationText() Icon is 'statemodel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setIcon(String)"})
  void testSetIcon_whenStatemodel_thenFDFAnnotationTextIconIsStatemodel() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setIcon("statemodel");

    // Assert
    assertEquals("statemodel", fdfAnnotationText.getIcon());
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationText#getIcon()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} Icon is {@code Note}.
   *   <li>Then return {@code Note}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getIcon()}
   */
  @Test
  @DisplayName("Test getIcon(); given FDFAnnotationText() Icon is 'Note'; then return 'Note'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getIcon()"})
  void testGetIcon_givenFDFAnnotationTextIconIsNote_thenReturnNote() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setIcon("Note");

    // Act and Assert
    assertEquals("Note", fdfAnnotationText.getIcon());
  }

  /**
   * Test {@link FDFAnnotationText#getIcon()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>Then return {@code Note}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getIcon()}
   */
  @Test
  @DisplayName("Test getIcon(); given FDFAnnotationText(); then return 'Note'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getIcon()"})
  void testGetIcon_givenFDFAnnotationText_thenReturnNote() {
    // Arrange, Act and Assert
    assertEquals("Note", new FDFAnnotationText().getIcon());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} State is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName(
      "Test getState(); given FDFAnnotationText() State is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getState()"})
  void testGetState_givenFDFAnnotationTextStateIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setState("");

    // Act and Assert
    assertEquals("", fdfAnnotationText.getState());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} State is {@code MD}.
   *   <li>Then return {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState(); given FDFAnnotationText() State is 'MD'; then return 'MD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getState()"})
  void testGetState_givenFDFAnnotationTextStateIsMd_thenReturnMd() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setState("MD");

    // Act and Assert
    assertEquals("MD", fdfAnnotationText.getState());
  }

  /**
   * Test {@link FDFAnnotationText#getState()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState(); given FDFAnnotationText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getState()"})
  void testGetState_givenFDFAnnotationText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationText().getState());
  }

  /**
   * Test {@link FDFAnnotationText#setState(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>When {@code MD}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} State is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setState(String)}
   */
  @Test
  @DisplayName(
      "Test setState(String); given FDFAnnotationText(); when 'MD'; then FDFAnnotationText() State is 'MD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setState(String)"})
  void testSetState_givenFDFAnnotationText_whenMd_thenFDFAnnotationTextStateIsMd() {
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
   * Test {@link FDFAnnotationText#setState(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setState(String)}
   */
  @Test
  @DisplayName(
      "Test setState(String); when 'null'; then FDFAnnotationText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setState(String)"})
  void testSetState_whenNull_thenFDFAnnotationTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setState(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()} StateModel is {@code MD}.
   *   <li>Then return {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName(
      "Test getStateModel(); given FDFAnnotationText() StateModel is 'MD'; then return 'MD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getStateModel()"})
  void testGetStateModel_givenFDFAnnotationTextStateModelIsMd_thenReturnMd() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setStateModel("MD");

    // Act and Assert
    assertEquals("MD", fdfAnnotationText.getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel(); given FDFAnnotationText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getStateModel()"})
  void testGetStateModel_givenFDFAnnotationText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationText().getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#getStateModel()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationText.getStateModel()"})
  void testGetStateModel_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();
    fdfAnnotationText.setStateModel("");

    // Act and Assert
    assertEquals("", fdfAnnotationText.getStateModel());
  }

  /**
   * Test {@link FDFAnnotationText#setStateModel(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationText#FDFAnnotationText()}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} StateModel is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName(
      "Test setStateModel(String); given FDFAnnotationText(); then FDFAnnotationText() StateModel is 'MD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setStateModel(String)"})
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

  /**
   * Test {@link FDFAnnotationText#setStateModel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationText#FDFAnnotationText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName(
      "Test setStateModel(String); when 'null'; then FDFAnnotationText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationText.setStateModel(String)"})
  void testSetStateModel_whenNull_thenFDFAnnotationTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationText fdfAnnotationText = new FDFAnnotationText();

    // Act
    fdfAnnotationText.setStateModel(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
