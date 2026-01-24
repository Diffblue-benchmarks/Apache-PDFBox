package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationRubberStampDiffblueTest {
  /**
   * Test {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()}.
   *
   * <p>Method under test: {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()}
   */
  @Test
  @DisplayName("Test new PDAnnotationRubberStamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationRubberStamp.<init>()"})
  void testNewPDAnnotationRubberStamp() throws IOException {
    // Arrange and Act
    PDAnnotationRubberStamp actualPdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Assert
    assertNull(actualPdAnnotationRubberStamp.getAnnotationName());
    assertNull(actualPdAnnotationRubberStamp.getContents());
    assertNull(actualPdAnnotationRubberStamp.getModifiedDate());
    assertNull(actualPdAnnotationRubberStamp.getIntent());
    assertNull(actualPdAnnotationRubberStamp.getRichContents());
    assertNull(actualPdAnnotationRubberStamp.getSubject());
    assertNull(actualPdAnnotationRubberStamp.getTitlePopup());
    assertNull(actualPdAnnotationRubberStamp.getCreationDate());
    assertNull(actualPdAnnotationRubberStamp.getAppearanceState());
    assertNull(actualPdAnnotationRubberStamp.getPage());
    assertNull(actualPdAnnotationRubberStamp.getRectangle());
    assertNull(actualPdAnnotationRubberStamp.getOptionalContent());
    assertNull(actualPdAnnotationRubberStamp.getColor());
    assertNull(actualPdAnnotationRubberStamp.getInReplyTo());
    assertNull(actualPdAnnotationRubberStamp.getPopup());
    assertNull(actualPdAnnotationRubberStamp.getAppearance());
    assertNull(actualPdAnnotationRubberStamp.getNormalAppearanceStream());
    assertNull(actualPdAnnotationRubberStamp.getBorderStyle());
    assertNull(actualPdAnnotationRubberStamp.getExternalData());
    assertEquals(-1, actualPdAnnotationRubberStamp.getStructParent());
    assertEquals(0, actualPdAnnotationRubberStamp.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationRubberStamp.getConstantOpacity());
    assertFalse(actualPdAnnotationRubberStamp.isHidden());
    assertFalse(actualPdAnnotationRubberStamp.isInvisible());
    assertFalse(actualPdAnnotationRubberStamp.isLocked());
    assertFalse(actualPdAnnotationRubberStamp.isLockedContents());
    assertFalse(actualPdAnnotationRubberStamp.isNoRotate());
    assertFalse(actualPdAnnotationRubberStamp.isNoView());
    assertFalse(actualPdAnnotationRubberStamp.isNoZoom());
    assertFalse(actualPdAnnotationRubberStamp.isPrinted());
    assertFalse(actualPdAnnotationRubberStamp.isReadOnly());
    assertFalse(actualPdAnnotationRubberStamp.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationRubberStamp.getReplyType());
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, actualPdAnnotationRubberStamp.getName());
    assertEquals(PDAnnotationRubberStamp.SUB_TYPE, actualPdAnnotationRubberStamp.getSubtype());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationRubberStamp(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationRubberStamp.<init>(COSDictionary)"})
  void testNewPDAnnotationRubberStamp_whenCOSDictionary_thenReturnAnnotationNameIsNull()
      throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationRubberStamp actualPdAnnotationRubberStamp = new PDAnnotationRubberStamp(field);

    // Assert
    assertNull(actualPdAnnotationRubberStamp.getAnnotationName());
    assertNull(actualPdAnnotationRubberStamp.getContents());
    assertNull(actualPdAnnotationRubberStamp.getModifiedDate());
    assertNull(actualPdAnnotationRubberStamp.getSubtype());
    assertNull(actualPdAnnotationRubberStamp.getIntent());
    assertNull(actualPdAnnotationRubberStamp.getRichContents());
    assertNull(actualPdAnnotationRubberStamp.getSubject());
    assertNull(actualPdAnnotationRubberStamp.getTitlePopup());
    assertNull(actualPdAnnotationRubberStamp.getCreationDate());
    assertNull(actualPdAnnotationRubberStamp.getAppearanceState());
    assertNull(actualPdAnnotationRubberStamp.getPage());
    assertNull(actualPdAnnotationRubberStamp.getRectangle());
    assertNull(actualPdAnnotationRubberStamp.getOptionalContent());
    assertNull(actualPdAnnotationRubberStamp.getColor());
    assertNull(actualPdAnnotationRubberStamp.getInReplyTo());
    assertNull(actualPdAnnotationRubberStamp.getPopup());
    assertNull(actualPdAnnotationRubberStamp.getAppearance());
    assertNull(actualPdAnnotationRubberStamp.getNormalAppearanceStream());
    assertNull(actualPdAnnotationRubberStamp.getBorderStyle());
    assertNull(actualPdAnnotationRubberStamp.getExternalData());
    assertEquals(-1, actualPdAnnotationRubberStamp.getStructParent());
    assertEquals(0, actualPdAnnotationRubberStamp.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationRubberStamp.getConstantOpacity());
    assertFalse(actualPdAnnotationRubberStamp.isHidden());
    assertFalse(actualPdAnnotationRubberStamp.isInvisible());
    assertFalse(actualPdAnnotationRubberStamp.isLocked());
    assertFalse(actualPdAnnotationRubberStamp.isLockedContents());
    assertFalse(actualPdAnnotationRubberStamp.isNoRotate());
    assertFalse(actualPdAnnotationRubberStamp.isNoView());
    assertFalse(actualPdAnnotationRubberStamp.isNoZoom());
    assertFalse(actualPdAnnotationRubberStamp.isPrinted());
    assertFalse(actualPdAnnotationRubberStamp.isReadOnly());
    assertFalse(actualPdAnnotationRubberStamp.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationRubberStamp.getReplyType());
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, actualPdAnnotationRubberStamp.getName());
    assertSame(field, actualPdAnnotationRubberStamp.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#setName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()} Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when '42'; then PDAnnotationRubberStamp() Name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationRubberStamp.setName(String)"})
  void testSetName_when42_thenPDAnnotationRubberStampNameIs42() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName("42");

    // Assert
    assertEquals("42", pdAnnotationRubberStamp.getName());
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDAnnotationRubberStamp() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationRubberStamp.setName(String)"})
  void testSetName_whenName_thenPDAnnotationRubberStampNameIsName() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName("Name");

    // Assert
    assertEquals("Name", pdAnnotationRubberStamp.getName());
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'null'; then PDAnnotationRubberStamp() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationRubberStamp.setName(String)"})
  void testSetName_whenNull_thenPDAnnotationRubberStampCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, pdAnnotationRubberStamp.getName());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#getName()}.
   *
   * <p>Method under test: {@link PDAnnotationRubberStamp#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationRubberStamp.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, new PDAnnotationRubberStamp().getName());
  }
}
