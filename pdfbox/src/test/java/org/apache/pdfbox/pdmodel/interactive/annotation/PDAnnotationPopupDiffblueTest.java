package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationPopupDiffblueTest {
  /**
   * Test {@link PDAnnotationPopup#PDAnnotationPopup()}.
   *
   * <p>Method under test: {@link PDAnnotationPopup#PDAnnotationPopup()}
   */
  @Test
  @DisplayName("Test new PDAnnotationPopup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.<init>()"})
  void testNewPDAnnotationPopup() {
    // Arrange and Act
    PDAnnotationPopup actualPdAnnotationPopup = new PDAnnotationPopup();

    // Assert
    assertNull(actualPdAnnotationPopup.getAnnotationName());
    assertNull(actualPdAnnotationPopup.getContents());
    assertNull(actualPdAnnotationPopup.getModifiedDate());
    assertNull(actualPdAnnotationPopup.getAppearanceState());
    assertNull(actualPdAnnotationPopup.getPage());
    assertNull(actualPdAnnotationPopup.getRectangle());
    assertNull(actualPdAnnotationPopup.getOptionalContent());
    assertNull(actualPdAnnotationPopup.getColor());
    assertNull(actualPdAnnotationPopup.getParent());
    assertNull(actualPdAnnotationPopup.getAppearance());
    assertNull(actualPdAnnotationPopup.getNormalAppearanceStream());
    assertEquals(-1, actualPdAnnotationPopup.getStructParent());
    assertEquals(0, actualPdAnnotationPopup.getAnnotationFlags());
    assertFalse(actualPdAnnotationPopup.isHidden());
    assertFalse(actualPdAnnotationPopup.isInvisible());
    assertFalse(actualPdAnnotationPopup.isLocked());
    assertFalse(actualPdAnnotationPopup.isLockedContents());
    assertFalse(actualPdAnnotationPopup.isNoRotate());
    assertFalse(actualPdAnnotationPopup.isNoView());
    assertFalse(actualPdAnnotationPopup.isNoZoom());
    assertFalse(actualPdAnnotationPopup.isPrinted());
    assertFalse(actualPdAnnotationPopup.isReadOnly());
    assertFalse(actualPdAnnotationPopup.isToggleNoView());
    assertFalse(actualPdAnnotationPopup.getOpen());
    assertEquals(PDAnnotationPopup.SUB_TYPE, actualPdAnnotationPopup.getSubtype());
  }

  /**
   * Test {@link PDAnnotationPopup#PDAnnotationPopup(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPopup#PDAnnotationPopup(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationPopup(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.<init>(COSDictionary)"})
  void testNewPDAnnotationPopup_whenCOSDictionary_thenReturnAnnotationNameIsNull() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationPopup actualPdAnnotationPopup = new PDAnnotationPopup(field);

    // Assert
    assertNull(actualPdAnnotationPopup.getAnnotationName());
    assertNull(actualPdAnnotationPopup.getContents());
    assertNull(actualPdAnnotationPopup.getModifiedDate());
    assertNull(actualPdAnnotationPopup.getSubtype());
    assertNull(actualPdAnnotationPopup.getAppearanceState());
    assertNull(actualPdAnnotationPopup.getPage());
    assertNull(actualPdAnnotationPopup.getRectangle());
    assertNull(actualPdAnnotationPopup.getOptionalContent());
    assertNull(actualPdAnnotationPopup.getColor());
    assertNull(actualPdAnnotationPopup.getParent());
    assertNull(actualPdAnnotationPopup.getAppearance());
    assertNull(actualPdAnnotationPopup.getNormalAppearanceStream());
    assertEquals(-1, actualPdAnnotationPopup.getStructParent());
    assertEquals(0, actualPdAnnotationPopup.getAnnotationFlags());
    assertEquals(1, field.size());
    assertFalse(actualPdAnnotationPopup.isHidden());
    assertFalse(actualPdAnnotationPopup.isInvisible());
    assertFalse(actualPdAnnotationPopup.isLocked());
    assertFalse(actualPdAnnotationPopup.isLockedContents());
    assertFalse(actualPdAnnotationPopup.isNoRotate());
    assertFalse(actualPdAnnotationPopup.isNoView());
    assertFalse(actualPdAnnotationPopup.isNoZoom());
    assertFalse(actualPdAnnotationPopup.isPrinted());
    assertFalse(actualPdAnnotationPopup.isReadOnly());
    assertFalse(actualPdAnnotationPopup.isToggleNoView());
    assertFalse(actualPdAnnotationPopup.getOpen());
    assertSame(field, actualPdAnnotationPopup.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationPopup#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDAnnotationPopup#PDAnnotationPopup()} Open.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPopup#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then not PDAnnotationPopup() Open")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.setOpen(boolean)"})
  void testSetOpen_whenFalse_thenNotPDAnnotationPopupOpen() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setOpen(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationPopup.getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationPopup#PDAnnotationPopup()} Open.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPopup#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then PDAnnotationPopup() Open")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.setOpen(boolean)"})
  void testSetOpen_whenTrue_thenPDAnnotationPopupOpen() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setOpen(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationPopup.getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#getOpen()}.
   *
   * <p>Method under test: {@link PDAnnotationPopup#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotationPopup.getOpen()"})
  void testGetOpen() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationPopup().getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} Direct is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDAnnotationMarkup); given 'false'; when COSDictionary(COSDictionary) with dict is COSDictionary() Direct is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.setParent(PDAnnotationMarkup)"})
  void testSetParent_givenFalse_whenCOSDictionaryWithDictIsCOSDictionaryDirectIsFalse() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    COSDictionary dict = new COSDictionary(new COSDictionary());
    dict.setDirect(false);
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup(dict));

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDAnnotationMarkup); given 'true'; when COSDictionary(COSDictionary) with dict is COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.setParent(PDAnnotationMarkup)"})
  void testSetParent_givenTrue_whenCOSDictionaryWithDictIsCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    COSDictionary dict = new COSDictionary(new COSDictionary());
    dict.setDirect(true);
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup(dict));

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}.
   *
   * <ul>
   *   <li>When {@link PDAnnotationMarkup#PDAnnotationMarkup()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  @DisplayName("Test setParent(PDAnnotationMarkup); when PDAnnotationMarkup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPopup.setParent(PDAnnotationMarkup)"})
  void testSetParent_whenPDAnnotationMarkup() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup());

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPopup#getParent()}.
   *
   * <p>Method under test: {@link PDAnnotationPopup#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotationMarkup PDAnnotationPopup.getParent()"})
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPopup().getParent());
  }
}
