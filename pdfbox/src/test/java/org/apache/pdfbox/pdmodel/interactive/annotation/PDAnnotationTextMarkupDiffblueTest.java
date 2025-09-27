package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

class PDAnnotationTextMarkupDiffblueTest {
  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return QuadPoints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationTextMarkup(COSDictionary); when COSDictionary(); then return QuadPoints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationTextMarkup.<init>(COSDictionary)"})
  void testNewPDAnnotationTextMarkup_whenCOSDictionary_thenReturnQuadPointsIsNull()
      throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup(field);

    // Assert
    assertNull(actualPdAnnotationTextMarkup.getQuadPoints());
    assertNull(actualPdAnnotationTextMarkup.getAnnotationName());
    assertNull(actualPdAnnotationTextMarkup.getContents());
    assertNull(actualPdAnnotationTextMarkup.getModifiedDate());
    assertNull(actualPdAnnotationTextMarkup.getSubtype());
    assertNull(actualPdAnnotationTextMarkup.getIntent());
    assertNull(actualPdAnnotationTextMarkup.getRichContents());
    assertNull(actualPdAnnotationTextMarkup.getSubject());
    assertNull(actualPdAnnotationTextMarkup.getTitlePopup());
    assertNull(actualPdAnnotationTextMarkup.getCreationDate());
    assertNull(actualPdAnnotationTextMarkup.getAppearanceState());
    assertNull(actualPdAnnotationTextMarkup.getPage());
    assertNull(actualPdAnnotationTextMarkup.getRectangle());
    assertNull(actualPdAnnotationTextMarkup.getOptionalContent());
    assertNull(actualPdAnnotationTextMarkup.getColor());
    assertNull(actualPdAnnotationTextMarkup.getInReplyTo());
    assertNull(actualPdAnnotationTextMarkup.getPopup());
    assertNull(actualPdAnnotationTextMarkup.getAppearance());
    assertNull(actualPdAnnotationTextMarkup.getNormalAppearanceStream());
    assertNull(actualPdAnnotationTextMarkup.getBorderStyle());
    assertNull(actualPdAnnotationTextMarkup.getExternalData());
    assertEquals(-1, actualPdAnnotationTextMarkup.getStructParent());
    assertEquals(0, actualPdAnnotationTextMarkup.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationTextMarkup.getConstantOpacity());
    assertFalse(actualPdAnnotationTextMarkup.isHidden());
    assertFalse(actualPdAnnotationTextMarkup.isInvisible());
    assertFalse(actualPdAnnotationTextMarkup.isLocked());
    assertFalse(actualPdAnnotationTextMarkup.isLockedContents());
    assertFalse(actualPdAnnotationTextMarkup.isNoRotate());
    assertFalse(actualPdAnnotationTextMarkup.isNoView());
    assertFalse(actualPdAnnotationTextMarkup.isNoZoom());
    assertFalse(actualPdAnnotationTextMarkup.isPrinted());
    assertFalse(actualPdAnnotationTextMarkup.isReadOnly());
    assertFalse(actualPdAnnotationTextMarkup.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationTextMarkup.getReplyType());
    assertSame(field, actualPdAnnotationTextMarkup.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Subtype is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationTextMarkup(String); when empty string; then return Subtype is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationTextMarkup.<init>(String)"})
  void testNewPDAnnotationTextMarkup_whenEmptyString_thenReturnSubtypeIsEmptyString()
      throws IOException {
    // Arrange and Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup("");

    // Assert
    assertEquals("", actualPdAnnotationTextMarkup.getSubtype());
    assertNull(actualPdAnnotationTextMarkup.getAnnotationName());
    assertNull(actualPdAnnotationTextMarkup.getContents());
    assertNull(actualPdAnnotationTextMarkup.getModifiedDate());
    assertNull(actualPdAnnotationTextMarkup.getIntent());
    assertNull(actualPdAnnotationTextMarkup.getRichContents());
    assertNull(actualPdAnnotationTextMarkup.getSubject());
    assertNull(actualPdAnnotationTextMarkup.getTitlePopup());
    assertNull(actualPdAnnotationTextMarkup.getCreationDate());
    assertNull(actualPdAnnotationTextMarkup.getAppearanceState());
    assertNull(actualPdAnnotationTextMarkup.getPage());
    assertNull(actualPdAnnotationTextMarkup.getRectangle());
    assertNull(actualPdAnnotationTextMarkup.getOptionalContent());
    assertNull(actualPdAnnotationTextMarkup.getColor());
    assertNull(actualPdAnnotationTextMarkup.getInReplyTo());
    assertNull(actualPdAnnotationTextMarkup.getPopup());
    assertNull(actualPdAnnotationTextMarkup.getAppearance());
    assertNull(actualPdAnnotationTextMarkup.getNormalAppearanceStream());
    assertNull(actualPdAnnotationTextMarkup.getBorderStyle());
    assertNull(actualPdAnnotationTextMarkup.getExternalData());
    assertEquals(-1, actualPdAnnotationTextMarkup.getStructParent());
    assertEquals(0, actualPdAnnotationTextMarkup.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationTextMarkup.getConstantOpacity());
    assertFalse(actualPdAnnotationTextMarkup.isHidden());
    assertFalse(actualPdAnnotationTextMarkup.isInvisible());
    assertFalse(actualPdAnnotationTextMarkup.isLocked());
    assertFalse(actualPdAnnotationTextMarkup.isLockedContents());
    assertFalse(actualPdAnnotationTextMarkup.isNoRotate());
    assertFalse(actualPdAnnotationTextMarkup.isNoView());
    assertFalse(actualPdAnnotationTextMarkup.isNoZoom());
    assertFalse(actualPdAnnotationTextMarkup.isPrinted());
    assertFalse(actualPdAnnotationTextMarkup.isReadOnly());
    assertFalse(actualPdAnnotationTextMarkup.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationTextMarkup.getReplyType());
    assertArrayEquals(new float[] {}, actualPdAnnotationTextMarkup.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}.
   *
   * <ul>
   *   <li>When {@code Sub Type}.
   *   <li>Then return {@code Sub Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}
   */
  @Test
  @DisplayName("Test new PDAnnotationTextMarkup(String); when 'Sub Type'; then return 'Sub Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationTextMarkup.<init>(String)"})
  void testNewPDAnnotationTextMarkup_whenSubType_thenReturnSubType() throws IOException {
    // Arrange and Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup("Sub Type");

    // Assert
    assertEquals("Sub Type", actualPdAnnotationTextMarkup.getSubtype());
    assertNull(actualPdAnnotationTextMarkup.getAnnotationName());
    assertNull(actualPdAnnotationTextMarkup.getContents());
    assertNull(actualPdAnnotationTextMarkup.getModifiedDate());
    assertNull(actualPdAnnotationTextMarkup.getIntent());
    assertNull(actualPdAnnotationTextMarkup.getRichContents());
    assertNull(actualPdAnnotationTextMarkup.getSubject());
    assertNull(actualPdAnnotationTextMarkup.getTitlePopup());
    assertNull(actualPdAnnotationTextMarkup.getCreationDate());
    assertNull(actualPdAnnotationTextMarkup.getAppearanceState());
    assertNull(actualPdAnnotationTextMarkup.getPage());
    assertNull(actualPdAnnotationTextMarkup.getRectangle());
    assertNull(actualPdAnnotationTextMarkup.getOptionalContent());
    assertNull(actualPdAnnotationTextMarkup.getColor());
    assertNull(actualPdAnnotationTextMarkup.getInReplyTo());
    assertNull(actualPdAnnotationTextMarkup.getPopup());
    assertNull(actualPdAnnotationTextMarkup.getAppearance());
    assertNull(actualPdAnnotationTextMarkup.getNormalAppearanceStream());
    assertNull(actualPdAnnotationTextMarkup.getBorderStyle());
    assertNull(actualPdAnnotationTextMarkup.getExternalData());
    assertEquals(-1, actualPdAnnotationTextMarkup.getStructParent());
    assertEquals(0, actualPdAnnotationTextMarkup.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationTextMarkup.getConstantOpacity());
    assertFalse(actualPdAnnotationTextMarkup.isHidden());
    assertFalse(actualPdAnnotationTextMarkup.isInvisible());
    assertFalse(actualPdAnnotationTextMarkup.isLocked());
    assertFalse(actualPdAnnotationTextMarkup.isLockedContents());
    assertFalse(actualPdAnnotationTextMarkup.isNoRotate());
    assertFalse(actualPdAnnotationTextMarkup.isNoView());
    assertFalse(actualPdAnnotationTextMarkup.isNoZoom());
    assertFalse(actualPdAnnotationTextMarkup.isPrinted());
    assertFalse(actualPdAnnotationTextMarkup.isReadOnly());
    assertFalse(actualPdAnnotationTextMarkup.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationTextMarkup.getReplyType());
    assertArrayEquals(new float[] {}, actualPdAnnotationTextMarkup.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationTextMarkup#setQuadPoints(float[])}.
   *
   * <p>Method under test: {@link PDAnnotationTextMarkup#setQuadPoints(float[])}
   */
  @Test
  @DisplayName("Test setQuadPoints(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationTextMarkup.setQuadPoints(float[])"})
  void testSetQuadPoints() {
    // Arrange
    PDAnnotationTextMarkup pdAnnotationTextMarkup = new PDAnnotationTextMarkup("Sub Type");

    // Act
    pdAnnotationTextMarkup.setQuadPoints(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationTextMarkup.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationTextMarkup#getQuadPoints()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationTextMarkup#getQuadPoints()}
   */
  @Test
  @DisplayName("Test getQuadPoints(); then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationTextMarkup.getQuadPoints()"})
  void testGetQuadPoints_thenReturnEmptyArrayOfFloat() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {}, new PDAnnotationTextMarkup("Sub Type").getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationTextMarkup#getQuadPoints()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationTextMarkup#getQuadPoints()}
   */
  @Test
  @DisplayName("Test getQuadPoints(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationTextMarkup.getQuadPoints()"})
  void testGetQuadPoints_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationTextMarkup(new COSDictionary()).getQuadPoints());
  }
}
