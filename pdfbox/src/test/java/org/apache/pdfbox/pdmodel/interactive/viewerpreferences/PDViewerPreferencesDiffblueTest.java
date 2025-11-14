package org.apache.pdfbox.pdmodel.interactive.viewerpreferences;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.BOUNDARY;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.DUPLEX;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.NON_FULL_SCREEN_PAGE_MODE;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.PRINT_SCALING;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.READING_DIRECTION;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDViewerPreferencesDiffblueTest {
  /**
   * Test {@link PDViewerPreferences#PDViewerPreferences(COSDictionary)}.
   *
   * <p>Method under test: {@link PDViewerPreferences#PDViewerPreferences(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDViewerPreferences(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.<init>(COSDictionary)"})
  void testNewPDViewerPreferences() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, new PDViewerPreferences(dic).getCOSObject());
  }

  /**
   * Test {@link PDViewerPreferences#PDViewerPreferences()}.
   *
   * <p>Method under test: {@link PDViewerPreferences#PDViewerPreferences()}
   */
  @Test
  @DisplayName("Test new PDViewerPreferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.<init>()"})
  void testNewPDViewerPreferences2() {
    // Arrange and Act
    PDViewerPreferences actualPdViewerPreferences = new PDViewerPreferences();

    // Assert
    assertEquals("AppDefault", actualPdViewerPreferences.getPrintScaling());
    assertEquals("CropBox", actualPdViewerPreferences.getPrintArea());
    assertEquals("CropBox", actualPdViewerPreferences.getPrintClip());
    assertEquals("CropBox", actualPdViewerPreferences.getViewArea());
    assertEquals("CropBox", actualPdViewerPreferences.getViewClip());
    assertEquals("L2R", actualPdViewerPreferences.getReadingDirection());
    assertEquals("UseNone", actualPdViewerPreferences.getNonFullScreenPageMode());
    assertNull(actualPdViewerPreferences.getDuplex());
    COSDictionary cOSObject = actualPdViewerPreferences.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDViewerPreferences#getCOSObject()}.
   *
   * <p>Method under test: {@link PDViewerPreferences#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDViewerPreferences.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDViewerPreferences().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDViewerPreferences#hideToolbar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideToolbar()}
   */
  @Test
  @DisplayName(
      "Test hideToolbar(); given PDViewerPreferences() HideToolbar is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideToolbar()"})
  void testHideToolbar_givenPDViewerPreferencesHideToolbarIsFalse_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(false);

    // Act and Assert
    assertFalse(pdViewerPreferences.hideToolbar());
  }

  /**
   * Test {@link PDViewerPreferences#hideToolbar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideToolbar()}
   */
  @Test
  @DisplayName(
      "Test hideToolbar(); given PDViewerPreferences() HideToolbar is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideToolbar()"})
  void testHideToolbar_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertTrue(pdViewerPreferences.hideToolbar());
  }

  /**
   * Test {@link PDViewerPreferences#hideToolbar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideToolbar()}
   */
  @Test
  @DisplayName("Test hideToolbar(); given PDViewerPreferences(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideToolbar()"})
  void testHideToolbar_givenPDViewerPreferences_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDViewerPreferences().hideToolbar());
  }

  /**
   * Test {@link PDViewerPreferences#setHideToolbar(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setHideToolbar(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHideToolbar(boolean); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setHideToolbar(boolean)"})
  void testSetHideToolbar_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setHideToolbar(true);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setHideToolbar(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setHideToolbar(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHideToolbar(boolean); when 'false'; then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setHideToolbar(boolean)"})
  void testSetHideToolbar_whenFalse_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setHideToolbar(false);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#hideMenubar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideMenubar is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideMenubar()}
   */
  @Test
  @DisplayName(
      "Test hideMenubar(); given PDViewerPreferences() HideMenubar is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideMenubar()"})
  void testHideMenubar_givenPDViewerPreferencesHideMenubarIsFalse_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideMenubar(false);

    // Act and Assert
    assertFalse(pdViewerPreferences.hideMenubar());
  }

  /**
   * Test {@link PDViewerPreferences#hideMenubar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideMenubar is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideMenubar()}
   */
  @Test
  @DisplayName(
      "Test hideMenubar(); given PDViewerPreferences() HideMenubar is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideMenubar()"})
  void testHideMenubar_givenPDViewerPreferencesHideMenubarIsTrue_thenReturnTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideMenubar(true);

    // Act and Assert
    assertTrue(pdViewerPreferences.hideMenubar());
  }

  /**
   * Test {@link PDViewerPreferences#hideMenubar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideMenubar()}
   */
  @Test
  @DisplayName(
      "Test hideMenubar(); given PDViewerPreferences() HideToolbar is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideMenubar()"})
  void testHideMenubar_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertFalse(pdViewerPreferences.hideMenubar());
  }

  /**
   * Test {@link PDViewerPreferences#hideMenubar()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideMenubar()}
   */
  @Test
  @DisplayName("Test hideMenubar(); given PDViewerPreferences(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideMenubar()"})
  void testHideMenubar_givenPDViewerPreferences_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDViewerPreferences().hideMenubar());
  }

  /**
   * Test {@link PDViewerPreferences#setHideMenubar(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setHideMenubar(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHideMenubar(boolean); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setHideMenubar(boolean)"})
  void testSetHideMenubar_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setHideMenubar(true);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setHideMenubar(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setHideMenubar(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHideMenubar(boolean); when 'false'; then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setHideMenubar(boolean)"})
  void testSetHideMenubar_whenFalse_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setHideMenubar(false);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#hideWindowUI()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideWindowUI()}
   */
  @Test
  @DisplayName(
      "Test hideWindowUI(); given PDViewerPreferences() HideToolbar is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideWindowUI()"})
  void testHideWindowUI_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertFalse(pdViewerPreferences.hideWindowUI());
  }

  /**
   * Test {@link PDViewerPreferences#hideWindowUI()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideWindowUI is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideWindowUI()}
   */
  @Test
  @DisplayName(
      "Test hideWindowUI(); given PDViewerPreferences() HideWindowUI is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideWindowUI()"})
  void testHideWindowUI_givenPDViewerPreferencesHideWindowUIIsFalse_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideWindowUI(false);

    // Act and Assert
    assertFalse(pdViewerPreferences.hideWindowUI());
  }

  /**
   * Test {@link PDViewerPreferences#hideWindowUI()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideWindowUI is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideWindowUI()}
   */
  @Test
  @DisplayName(
      "Test hideWindowUI(); given PDViewerPreferences() HideWindowUI is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideWindowUI()"})
  void testHideWindowUI_givenPDViewerPreferencesHideWindowUIIsTrue_thenReturnTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideWindowUI(true);

    // Act and Assert
    assertTrue(pdViewerPreferences.hideWindowUI());
  }

  /**
   * Test {@link PDViewerPreferences#hideWindowUI()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#hideWindowUI()}
   */
  @Test
  @DisplayName("Test hideWindowUI(); given PDViewerPreferences(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.hideWindowUI()"})
  void testHideWindowUI_givenPDViewerPreferences_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDViewerPreferences().hideWindowUI());
  }

  /**
   * Test {@link PDViewerPreferences#setHideWindowUI(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setHideWindowUI(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHideWindowUI(boolean); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setHideWindowUI(boolean)"})
  void testSetHideWindowUI_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setHideWindowUI(true);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setHideWindowUI(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setHideWindowUI(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHideWindowUI(boolean); when 'false'; then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setHideWindowUI(boolean)"})
  void testSetHideWindowUI_whenFalse_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setHideWindowUI(false);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#fitWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} FitWindow is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#fitWindow()}
   */
  @Test
  @DisplayName(
      "Test fitWindow(); given PDViewerPreferences() FitWindow is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.fitWindow()"})
  void testFitWindow_givenPDViewerPreferencesFitWindowIsFalse_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setFitWindow(false);

    // Act and Assert
    assertFalse(pdViewerPreferences.fitWindow());
  }

  /**
   * Test {@link PDViewerPreferences#fitWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} FitWindow is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#fitWindow()}
   */
  @Test
  @DisplayName(
      "Test fitWindow(); given PDViewerPreferences() FitWindow is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.fitWindow()"})
  void testFitWindow_givenPDViewerPreferencesFitWindowIsTrue_thenReturnTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setFitWindow(true);

    // Act and Assert
    assertTrue(pdViewerPreferences.fitWindow());
  }

  /**
   * Test {@link PDViewerPreferences#fitWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#fitWindow()}
   */
  @Test
  @DisplayName(
      "Test fitWindow(); given PDViewerPreferences() HideToolbar is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.fitWindow()"})
  void testFitWindow_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertFalse(pdViewerPreferences.fitWindow());
  }

  /**
   * Test {@link PDViewerPreferences#fitWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#fitWindow()}
   */
  @Test
  @DisplayName("Test fitWindow(); given PDViewerPreferences(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.fitWindow()"})
  void testFitWindow_givenPDViewerPreferences_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDViewerPreferences().fitWindow());
  }

  /**
   * Test {@link PDViewerPreferences#setFitWindow(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setFitWindow(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFitWindow(boolean); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setFitWindow(boolean)"})
  void testSetFitWindow_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setFitWindow(true);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setFitWindow(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setFitWindow(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFitWindow(boolean); when 'false'; then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setFitWindow(boolean)"})
  void testSetFitWindow_whenFalse_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setFitWindow(false);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#centerWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} CenterWindow is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#centerWindow()}
   */
  @Test
  @DisplayName(
      "Test centerWindow(); given PDViewerPreferences() CenterWindow is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.centerWindow()"})
  void testCenterWindow_givenPDViewerPreferencesCenterWindowIsFalse_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setCenterWindow(false);

    // Act and Assert
    assertFalse(pdViewerPreferences.centerWindow());
  }

  /**
   * Test {@link PDViewerPreferences#centerWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} CenterWindow is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#centerWindow()}
   */
  @Test
  @DisplayName(
      "Test centerWindow(); given PDViewerPreferences() CenterWindow is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.centerWindow()"})
  void testCenterWindow_givenPDViewerPreferencesCenterWindowIsTrue_thenReturnTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setCenterWindow(true);

    // Act and Assert
    assertTrue(pdViewerPreferences.centerWindow());
  }

  /**
   * Test {@link PDViewerPreferences#centerWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#centerWindow()}
   */
  @Test
  @DisplayName(
      "Test centerWindow(); given PDViewerPreferences() HideToolbar is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.centerWindow()"})
  void testCenterWindow_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertFalse(pdViewerPreferences.centerWindow());
  }

  /**
   * Test {@link PDViewerPreferences#centerWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#centerWindow()}
   */
  @Test
  @DisplayName("Test centerWindow(); given PDViewerPreferences(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.centerWindow()"})
  void testCenterWindow_givenPDViewerPreferences_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDViewerPreferences().centerWindow());
  }

  /**
   * Test {@link PDViewerPreferences#setCenterWindow(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setCenterWindow(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCenterWindow(boolean); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setCenterWindow(boolean)"})
  void testSetCenterWindow_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setCenterWindow(true);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setCenterWindow(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setCenterWindow(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCenterWindow(boolean); when 'false'; then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setCenterWindow(boolean)"})
  void testSetCenterWindow_whenFalse_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setCenterWindow(false);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#displayDocTitle()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} DisplayDocTitle is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#displayDocTitle()}
   */
  @Test
  @DisplayName("Test displayDocTitle(); given PDViewerPreferences() DisplayDocTitle is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.displayDocTitle()"})
  void testDisplayDocTitle_givenPDViewerPreferencesDisplayDocTitleIsFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setDisplayDocTitle(false);

    // Act and Assert
    assertFalse(pdViewerPreferences.displayDocTitle());
  }

  /**
   * Test {@link PDViewerPreferences#displayDocTitle()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} DisplayDocTitle is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#displayDocTitle()}
   */
  @Test
  @DisplayName(
      "Test displayDocTitle(); given PDViewerPreferences() DisplayDocTitle is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.displayDocTitle()"})
  void testDisplayDocTitle_givenPDViewerPreferencesDisplayDocTitleIsTrue_thenReturnTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setDisplayDocTitle(true);

    // Act and Assert
    assertTrue(pdViewerPreferences.displayDocTitle());
  }

  /**
   * Test {@link PDViewerPreferences#displayDocTitle()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#displayDocTitle()}
   */
  @Test
  @DisplayName(
      "Test displayDocTitle(); given PDViewerPreferences() HideToolbar is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.displayDocTitle()"})
  void testDisplayDocTitle_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnFalse() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertFalse(pdViewerPreferences.displayDocTitle());
  }

  /**
   * Test {@link PDViewerPreferences#displayDocTitle()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#displayDocTitle()}
   */
  @Test
  @DisplayName("Test displayDocTitle(); given PDViewerPreferences(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDViewerPreferences.displayDocTitle()"})
  void testDisplayDocTitle_givenPDViewerPreferences_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDViewerPreferences().displayDocTitle());
  }

  /**
   * Test {@link PDViewerPreferences#setDisplayDocTitle(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setDisplayDocTitle(boolean)}
   */
  @Test
  @DisplayName(
      "Test setDisplayDocTitle(boolean); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setDisplayDocTitle(boolean)"})
  void testSetDisplayDocTitle_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setDisplayDocTitle(true);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setDisplayDocTitle(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setDisplayDocTitle(boolean)}
   */
  @Test
  @DisplayName(
      "Test setDisplayDocTitle(boolean); when 'false'; then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setDisplayDocTitle(boolean)"})
  void testSetDisplayDocTitle_whenFalse_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setDisplayDocTitle(false);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getNonFullScreenPageMode()}.
   *
   * <p>Method under test: {@link PDViewerPreferences#getNonFullScreenPageMode()}
   */
  @Test
  @DisplayName("Test getNonFullScreenPageMode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getNonFullScreenPageMode()"})
  void testGetNonFullScreenPageMode() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE.UseNone);

    // Act and Assert
    assertEquals("UseNone", pdViewerPreferences.getNonFullScreenPageMode());
  }

  /**
   * Test {@link PDViewerPreferences#getNonFullScreenPageMode()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getNonFullScreenPageMode()}
   */
  @Test
  @DisplayName("Test getNonFullScreenPageMode(); given PDViewerPreferences() HideToolbar is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getNonFullScreenPageMode()"})
  void testGetNonFullScreenPageMode_givenPDViewerPreferencesHideToolbarIsTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("UseNone", pdViewerPreferences.getNonFullScreenPageMode());
  }

  /**
   * Test {@link PDViewerPreferences#getNonFullScreenPageMode()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code UseNone}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getNonFullScreenPageMode()}
   */
  @Test
  @DisplayName(
      "Test getNonFullScreenPageMode(); given PDViewerPreferences(); then return 'UseNone'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getNonFullScreenPageMode()"})
  void testGetNonFullScreenPageMode_givenPDViewerPreferences_thenReturnUseNone() {
    // Arrange, Act and Assert
    assertEquals("UseNone", new PDViewerPreferences().getNonFullScreenPageMode());
  }

  /**
   * Test {@link PDViewerPreferences#setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)}.
   *
   * <p>Method under test: {@link
   * PDViewerPreferences#setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)}
   */
  @Test
  @DisplayName("Test setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDViewerPreferences.setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)"
  })
  void testSetNonFullScreenPageMode() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences(new COSDictionary());

    // Act
    pdViewerPreferences.setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE.UseNone);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDViewerPreferences#setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)}
   */
  @Test
  @DisplayName(
      "Test setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE); then PDViewerPreferences() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDViewerPreferences.setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE)"
  })
  void testSetNonFullScreenPageMode_thenPDViewerPreferencesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE.UseNone);

    // Assert
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getReadingDirection()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code L2R}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getReadingDirection()}
   */
  @Test
  @DisplayName(
      "Test getReadingDirection(); given PDViewerPreferences() HideToolbar is 'true'; then return 'L2R'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getReadingDirection()"})
  void testGetReadingDirection_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnL2r() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("L2R", pdViewerPreferences.getReadingDirection());
  }

  /**
   * Test {@link PDViewerPreferences#getReadingDirection()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} ReadingDirection is {@code L2R}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getReadingDirection()}
   */
  @Test
  @DisplayName("Test getReadingDirection(); given PDViewerPreferences() ReadingDirection is 'L2R'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getReadingDirection()"})
  void testGetReadingDirection_givenPDViewerPreferencesReadingDirectionIsL2r() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setReadingDirection(READING_DIRECTION.L2R);

    // Act and Assert
    assertEquals("L2R", pdViewerPreferences.getReadingDirection());
  }

  /**
   * Test {@link PDViewerPreferences#getReadingDirection()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code L2R}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getReadingDirection()}
   */
  @Test
  @DisplayName("Test getReadingDirection(); given PDViewerPreferences(); then return 'L2R'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getReadingDirection()"})
  void testGetReadingDirection_givenPDViewerPreferences_thenReturnL2r() {
    // Arrange, Act and Assert
    assertEquals("L2R", new PDViewerPreferences().getReadingDirection());
  }

  /**
   * Test {@link PDViewerPreferences#setReadingDirection(READING_DIRECTION)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} ReadingDirection is {@code L2R}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setReadingDirection(READING_DIRECTION)}
   */
  @Test
  @DisplayName(
      "Test setReadingDirection(READING_DIRECTION); then PDViewerPreferences() ReadingDirection is 'L2R'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setReadingDirection(READING_DIRECTION)"})
  void testSetReadingDirection_thenPDViewerPreferencesReadingDirectionIsL2r() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setReadingDirection(READING_DIRECTION.L2R);

    // Assert
    assertEquals("L2R", pdViewerPreferences.getReadingDirection());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#setReadingDirection(READING_DIRECTION)}.
   *
   * <ul>
   *   <li>When {@code R2L}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} ReadingDirection is {@code R2L}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setReadingDirection(READING_DIRECTION)}
   */
  @Test
  @DisplayName(
      "Test setReadingDirection(READING_DIRECTION); when 'R2L'; then PDViewerPreferences() ReadingDirection is 'R2L'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setReadingDirection(READING_DIRECTION)"})
  void testSetReadingDirection_whenR2l_thenPDViewerPreferencesReadingDirectionIsR2l() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setReadingDirection(READING_DIRECTION.R2L);

    // Assert
    assertEquals("R2L", pdViewerPreferences.getReadingDirection());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getViewArea()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getViewArea()}
   */
  @Test
  @DisplayName(
      "Test getViewArea(); given PDViewerPreferences() HideToolbar is 'true'; then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getViewArea()"})
  void testGetViewArea_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnCropBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("CropBox", pdViewerPreferences.getViewArea());
  }

  /**
   * Test {@link PDViewerPreferences#getViewArea()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} ViewArea is {@code MediaBox}.
   *   <li>Then return {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getViewArea()}
   */
  @Test
  @DisplayName(
      "Test getViewArea(); given PDViewerPreferences() ViewArea is 'MediaBox'; then return 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getViewArea()"})
  void testGetViewArea_givenPDViewerPreferencesViewAreaIsMediaBox_thenReturnMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setViewArea(BOUNDARY.MediaBox);

    // Act and Assert
    assertEquals("MediaBox", pdViewerPreferences.getViewArea());
  }

  /**
   * Test {@link PDViewerPreferences#getViewArea()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getViewArea()}
   */
  @Test
  @DisplayName("Test getViewArea(); given PDViewerPreferences(); then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getViewArea()"})
  void testGetViewArea_givenPDViewerPreferences_thenReturnCropBox() {
    // Arrange, Act and Assert
    assertEquals("CropBox", new PDViewerPreferences().getViewArea());
  }

  /**
   * Test {@link PDViewerPreferences#setViewArea(BOUNDARY)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} ViewArea is {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setViewArea(BOUNDARY)}
   */
  @Test
  @DisplayName("Test setViewArea(BOUNDARY); then PDViewerPreferences() ViewArea is 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setViewArea(BOUNDARY)"})
  void testSetViewArea_thenPDViewerPreferencesViewAreaIsMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setViewArea(BOUNDARY.MediaBox);

    // Assert
    assertEquals("MediaBox", pdViewerPreferences.getViewArea());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getViewClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getViewClip()}
   */
  @Test
  @DisplayName(
      "Test getViewClip(); given PDViewerPreferences() HideToolbar is 'true'; then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getViewClip()"})
  void testGetViewClip_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnCropBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("CropBox", pdViewerPreferences.getViewClip());
  }

  /**
   * Test {@link PDViewerPreferences#getViewClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} ViewClip is {@code MediaBox}.
   *   <li>Then return {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getViewClip()}
   */
  @Test
  @DisplayName(
      "Test getViewClip(); given PDViewerPreferences() ViewClip is 'MediaBox'; then return 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getViewClip()"})
  void testGetViewClip_givenPDViewerPreferencesViewClipIsMediaBox_thenReturnMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setViewClip(BOUNDARY.MediaBox);

    // Act and Assert
    assertEquals("MediaBox", pdViewerPreferences.getViewClip());
  }

  /**
   * Test {@link PDViewerPreferences#getViewClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getViewClip()}
   */
  @Test
  @DisplayName("Test getViewClip(); given PDViewerPreferences(); then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getViewClip()"})
  void testGetViewClip_givenPDViewerPreferences_thenReturnCropBox() {
    // Arrange, Act and Assert
    assertEquals("CropBox", new PDViewerPreferences().getViewClip());
  }

  /**
   * Test {@link PDViewerPreferences#setViewClip(BOUNDARY)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} ViewClip is {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setViewClip(BOUNDARY)}
   */
  @Test
  @DisplayName("Test setViewClip(BOUNDARY); then PDViewerPreferences() ViewClip is 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setViewClip(BOUNDARY)"})
  void testSetViewClip_thenPDViewerPreferencesViewClipIsMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setViewClip(BOUNDARY.MediaBox);

    // Assert
    assertEquals("MediaBox", pdViewerPreferences.getViewClip());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintArea()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintArea()}
   */
  @Test
  @DisplayName(
      "Test getPrintArea(); given PDViewerPreferences() HideToolbar is 'true'; then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintArea()"})
  void testGetPrintArea_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnCropBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("CropBox", pdViewerPreferences.getPrintArea());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintArea()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} PrintArea is {@code MediaBox}.
   *   <li>Then return {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintArea()}
   */
  @Test
  @DisplayName(
      "Test getPrintArea(); given PDViewerPreferences() PrintArea is 'MediaBox'; then return 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintArea()"})
  void testGetPrintArea_givenPDViewerPreferencesPrintAreaIsMediaBox_thenReturnMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setPrintArea(BOUNDARY.MediaBox);

    // Act and Assert
    assertEquals("MediaBox", pdViewerPreferences.getPrintArea());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintArea()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintArea()}
   */
  @Test
  @DisplayName("Test getPrintArea(); given PDViewerPreferences(); then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintArea()"})
  void testGetPrintArea_givenPDViewerPreferences_thenReturnCropBox() {
    // Arrange, Act and Assert
    assertEquals("CropBox", new PDViewerPreferences().getPrintArea());
  }

  /**
   * Test {@link PDViewerPreferences#setPrintArea(BOUNDARY)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} PrintArea is {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setPrintArea(BOUNDARY)}
   */
  @Test
  @DisplayName("Test setPrintArea(BOUNDARY); then PDViewerPreferences() PrintArea is 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setPrintArea(BOUNDARY)"})
  void testSetPrintArea_thenPDViewerPreferencesPrintAreaIsMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setPrintArea(BOUNDARY.MediaBox);

    // Assert
    assertEquals("MediaBox", pdViewerPreferences.getPrintArea());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} DisplayDocTitle is {@code true}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintClip()}
   */
  @Test
  @DisplayName(
      "Test getPrintClip(); given PDViewerPreferences() DisplayDocTitle is 'true'; then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintClip()"})
  void testGetPrintClip_givenPDViewerPreferencesDisplayDocTitleIsTrue_thenReturnCropBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setDisplayDocTitle(true);
    pdViewerPreferences.setCenterWindow(true);

    // Act and Assert
    assertEquals("CropBox", pdViewerPreferences.getPrintClip());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintClip()}
   */
  @Test
  @DisplayName(
      "Test getPrintClip(); given PDViewerPreferences() HideToolbar is 'true'; then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintClip()"})
  void testGetPrintClip_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnCropBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("CropBox", pdViewerPreferences.getPrintClip());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} PrintClip is {@code MediaBox}.
   *   <li>Then return {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintClip()}
   */
  @Test
  @DisplayName(
      "Test getPrintClip(); given PDViewerPreferences() PrintClip is 'MediaBox'; then return 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintClip()"})
  void testGetPrintClip_givenPDViewerPreferencesPrintClipIsMediaBox_thenReturnMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setPrintClip(BOUNDARY.MediaBox);

    // Act and Assert
    assertEquals("MediaBox", pdViewerPreferences.getPrintClip());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintClip()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code CropBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintClip()}
   */
  @Test
  @DisplayName("Test getPrintClip(); given PDViewerPreferences(); then return 'CropBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintClip()"})
  void testGetPrintClip_givenPDViewerPreferences_thenReturnCropBox() {
    // Arrange, Act and Assert
    assertEquals("CropBox", new PDViewerPreferences().getPrintClip());
  }

  /**
   * Test {@link PDViewerPreferences#setPrintClip(BOUNDARY)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} PrintClip is {@code MediaBox}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setPrintClip(BOUNDARY)}
   */
  @Test
  @DisplayName("Test setPrintClip(BOUNDARY); then PDViewerPreferences() PrintClip is 'MediaBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setPrintClip(BOUNDARY)"})
  void testSetPrintClip_thenPDViewerPreferencesPrintClipIsMediaBox() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setPrintClip(BOUNDARY.MediaBox);

    // Assert
    assertEquals("MediaBox", pdViewerPreferences.getPrintClip());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getDuplex()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} Duplex is {@code Simplex}.
   *   <li>Then return {@code Simplex}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getDuplex()}
   */
  @Test
  @DisplayName(
      "Test getDuplex(); given PDViewerPreferences() Duplex is 'Simplex'; then return 'Simplex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getDuplex()"})
  void testGetDuplex_givenPDViewerPreferencesDuplexIsSimplex_thenReturnSimplex() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setDuplex(DUPLEX.Simplex);

    // Act and Assert
    assertEquals("Simplex", pdViewerPreferences.getDuplex());
  }

  /**
   * Test {@link PDViewerPreferences#getDuplex()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getDuplex()}
   */
  @Test
  @DisplayName(
      "Test getDuplex(); given PDViewerPreferences() HideToolbar is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getDuplex()"})
  void testGetDuplex_givenPDViewerPreferencesHideToolbarIsTrue_thenReturnNull() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertNull(pdViewerPreferences.getDuplex());
  }

  /**
   * Test {@link PDViewerPreferences#getDuplex()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getDuplex()}
   */
  @Test
  @DisplayName("Test getDuplex(); given PDViewerPreferences(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getDuplex()"})
  void testGetDuplex_givenPDViewerPreferences_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDViewerPreferences().getDuplex());
  }

  /**
   * Test {@link PDViewerPreferences#setDuplex(DUPLEX)}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} Duplex is {@code Simplex}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setDuplex(DUPLEX)}
   */
  @Test
  @DisplayName(
      "Test setDuplex(DUPLEX); given PDViewerPreferences(); then PDViewerPreferences() Duplex is 'Simplex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setDuplex(DUPLEX)"})
  void testSetDuplex_givenPDViewerPreferences_thenPDViewerPreferencesDuplexIsSimplex() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setDuplex(DUPLEX.Simplex);

    // Assert
    assertEquals("Simplex", pdViewerPreferences.getDuplex());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintScaling()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} HideToolbar is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintScaling()}
   */
  @Test
  @DisplayName("Test getPrintScaling(); given PDViewerPreferences() HideToolbar is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintScaling()"})
  void testGetPrintScaling_givenPDViewerPreferencesHideToolbarIsTrue() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setHideToolbar(true);

    // Act and Assert
    assertEquals("AppDefault", pdViewerPreferences.getPrintScaling());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintScaling()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()} PrintScaling is {@code None}.
   *   <li>Then return {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintScaling()}
   */
  @Test
  @DisplayName(
      "Test getPrintScaling(); given PDViewerPreferences() PrintScaling is 'None'; then return 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintScaling()"})
  void testGetPrintScaling_givenPDViewerPreferencesPrintScalingIsNone_thenReturnNone() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();
    pdViewerPreferences.setPrintScaling(PRINT_SCALING.None);

    // Act and Assert
    assertEquals("None", pdViewerPreferences.getPrintScaling());
  }

  /**
   * Test {@link PDViewerPreferences#getPrintScaling()}.
   *
   * <ul>
   *   <li>Given {@link PDViewerPreferences#PDViewerPreferences()}.
   *   <li>Then return {@code AppDefault}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#getPrintScaling()}
   */
  @Test
  @DisplayName("Test getPrintScaling(); given PDViewerPreferences(); then return 'AppDefault'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDViewerPreferences.getPrintScaling()"})
  void testGetPrintScaling_givenPDViewerPreferences_thenReturnAppDefault() {
    // Arrange, Act and Assert
    assertEquals("AppDefault", new PDViewerPreferences().getPrintScaling());
  }

  /**
   * Test {@link PDViewerPreferences#setPrintScaling(PRINT_SCALING)}.
   *
   * <ul>
   *   <li>Then {@link PDViewerPreferences#PDViewerPreferences()} PrintScaling is {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewerPreferences#setPrintScaling(PRINT_SCALING)}
   */
  @Test
  @DisplayName(
      "Test setPrintScaling(PRINT_SCALING); then PDViewerPreferences() PrintScaling is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewerPreferences.setPrintScaling(PRINT_SCALING)"})
  void testSetPrintScaling_thenPDViewerPreferencesPrintScalingIsNone() {
    // Arrange
    PDViewerPreferences pdViewerPreferences = new PDViewerPreferences();

    // Act
    pdViewerPreferences.setPrintScaling(PRINT_SCALING.None);

    // Assert
    assertEquals("None", pdViewerPreferences.getPrintScaling());
    COSDictionary cOSObject = pdViewerPreferences.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
