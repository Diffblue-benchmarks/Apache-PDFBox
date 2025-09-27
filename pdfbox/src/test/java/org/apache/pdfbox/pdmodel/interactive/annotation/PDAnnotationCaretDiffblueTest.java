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

class PDAnnotationCaretDiffblueTest {
  /**
   * Test {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *
   * <p>Method under test: {@link PDAnnotationCaret#PDAnnotationCaret()}
   */
  @Test
  @DisplayName("Test new PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCaret.<init>()"})
  void testNewPDAnnotationCaret() throws IOException {
    // Arrange and Act
    PDAnnotationCaret actualPdAnnotationCaret = new PDAnnotationCaret();

    // Assert
    assertNull(actualPdAnnotationCaret.getAnnotationName());
    assertNull(actualPdAnnotationCaret.getContents());
    assertNull(actualPdAnnotationCaret.getModifiedDate());
    assertNull(actualPdAnnotationCaret.getIntent());
    assertNull(actualPdAnnotationCaret.getRichContents());
    assertNull(actualPdAnnotationCaret.getSubject());
    assertNull(actualPdAnnotationCaret.getTitlePopup());
    assertNull(actualPdAnnotationCaret.getCreationDate());
    assertNull(actualPdAnnotationCaret.getAppearanceState());
    assertNull(actualPdAnnotationCaret.getPage());
    assertNull(actualPdAnnotationCaret.getRectangle());
    assertNull(actualPdAnnotationCaret.getOptionalContent());
    assertNull(actualPdAnnotationCaret.getColor());
    assertNull(actualPdAnnotationCaret.getInReplyTo());
    assertNull(actualPdAnnotationCaret.getPopup());
    assertNull(actualPdAnnotationCaret.getAppearance());
    assertNull(actualPdAnnotationCaret.getNormalAppearanceStream());
    assertNull(actualPdAnnotationCaret.getBorderStyle());
    assertNull(actualPdAnnotationCaret.getExternalData());
    assertEquals(-1, actualPdAnnotationCaret.getStructParent());
    assertEquals(0, actualPdAnnotationCaret.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationCaret.getConstantOpacity());
    assertFalse(actualPdAnnotationCaret.isHidden());
    assertFalse(actualPdAnnotationCaret.isInvisible());
    assertFalse(actualPdAnnotationCaret.isLocked());
    assertFalse(actualPdAnnotationCaret.isLockedContents());
    assertFalse(actualPdAnnotationCaret.isNoRotate());
    assertFalse(actualPdAnnotationCaret.isNoView());
    assertFalse(actualPdAnnotationCaret.isNoZoom());
    assertFalse(actualPdAnnotationCaret.isPrinted());
    assertFalse(actualPdAnnotationCaret.isReadOnly());
    assertFalse(actualPdAnnotationCaret.isToggleNoView());
    assertEquals(PDAnnotationCaret.SUB_TYPE, actualPdAnnotationCaret.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCaret.getReplyType());
    assertArrayEquals(new float[] {}, actualPdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationCaret(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCaret.<init>(COSDictionary)"})
  void testNewPDAnnotationCaret_whenCOSDictionary_thenReturnAnnotationNameIsNull()
      throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationCaret actualPdAnnotationCaret = new PDAnnotationCaret(field);

    // Assert
    assertNull(actualPdAnnotationCaret.getAnnotationName());
    assertNull(actualPdAnnotationCaret.getContents());
    assertNull(actualPdAnnotationCaret.getModifiedDate());
    assertNull(actualPdAnnotationCaret.getSubtype());
    assertNull(actualPdAnnotationCaret.getIntent());
    assertNull(actualPdAnnotationCaret.getRichContents());
    assertNull(actualPdAnnotationCaret.getSubject());
    assertNull(actualPdAnnotationCaret.getTitlePopup());
    assertNull(actualPdAnnotationCaret.getCreationDate());
    assertNull(actualPdAnnotationCaret.getAppearanceState());
    assertNull(actualPdAnnotationCaret.getPage());
    assertNull(actualPdAnnotationCaret.getRectangle());
    assertNull(actualPdAnnotationCaret.getOptionalContent());
    assertNull(actualPdAnnotationCaret.getColor());
    assertNull(actualPdAnnotationCaret.getInReplyTo());
    assertNull(actualPdAnnotationCaret.getPopup());
    assertNull(actualPdAnnotationCaret.getAppearance());
    assertNull(actualPdAnnotationCaret.getNormalAppearanceStream());
    assertNull(actualPdAnnotationCaret.getBorderStyle());
    assertNull(actualPdAnnotationCaret.getExternalData());
    assertEquals(-1, actualPdAnnotationCaret.getStructParent());
    assertEquals(0, actualPdAnnotationCaret.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationCaret.getConstantOpacity());
    assertFalse(actualPdAnnotationCaret.isHidden());
    assertFalse(actualPdAnnotationCaret.isInvisible());
    assertFalse(actualPdAnnotationCaret.isLocked());
    assertFalse(actualPdAnnotationCaret.isLockedContents());
    assertFalse(actualPdAnnotationCaret.isNoRotate());
    assertFalse(actualPdAnnotationCaret.isNoView());
    assertFalse(actualPdAnnotationCaret.isNoZoom());
    assertFalse(actualPdAnnotationCaret.isPrinted());
    assertFalse(actualPdAnnotationCaret.isReadOnly());
    assertFalse(actualPdAnnotationCaret.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCaret.getReplyType());
    assertSame(field, actualPdAnnotationCaret.getCOSObject());
    assertArrayEquals(new float[] {}, actualPdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#setRectDifferences(float)} with {@code difference}.
   *
   * <p>Method under test: {@link PDAnnotationCaret#setRectDifferences(float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float) with 'difference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCaret.setRectDifferences(float)"})
  void testSetRectDifferencesWithDifference() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setRectDifferences(10.0f);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#setRectDifferences(float, float, float, float)} with {@code
   * differenceLeft}, {@code differenceTop}, {@code differenceRight}, {@code differenceBottom}.
   *
   * <p>Method under test: {@link PDAnnotationCaret#setRectDifferences(float, float, float, float)}
   */
  @Test
  @DisplayName(
      "Test setRectDifferences(float, float, float, float) with 'differenceLeft', 'differenceTop', 'differenceRight', 'differenceBottom'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCaret.setRectDifferences(float, float, float, float)"})
  void testSetRectDifferencesWithDifferenceLeftDifferenceTopDifferenceRightDifferenceBottom() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setRectDifferences(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#getRectDifferences()}.
   *
   * <p>Method under test: {@link PDAnnotationCaret#getRectDifferences()}
   */
  @Test
  @DisplayName("Test getRectDifferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationCaret.getRectDifferences()"})
  void testGetRectDifferences() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {}, new PDAnnotationCaret().getRectDifferences(), 0.0f);
  }
}
