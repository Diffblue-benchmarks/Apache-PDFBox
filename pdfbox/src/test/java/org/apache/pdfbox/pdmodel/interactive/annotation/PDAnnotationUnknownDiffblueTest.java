package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationUnknownDiffblueTest {
  /**
   * Test {@link PDAnnotationUnknown#PDAnnotationUnknown(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationUnknown#PDAnnotationUnknown(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationUnknown(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationUnknown.<init>(COSDictionary)"})
  void testNewPDAnnotationUnknown_whenCOSDictionary_thenReturnAnnotationNameIsNull() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDAnnotationUnknown actualPdAnnotationUnknown = new PDAnnotationUnknown(dic);

    // Assert
    assertNull(actualPdAnnotationUnknown.getAnnotationName());
    assertNull(actualPdAnnotationUnknown.getContents());
    assertNull(actualPdAnnotationUnknown.getModifiedDate());
    assertNull(actualPdAnnotationUnknown.getSubtype());
    assertNull(actualPdAnnotationUnknown.getAppearanceState());
    assertNull(actualPdAnnotationUnknown.getPage());
    assertNull(actualPdAnnotationUnknown.getRectangle());
    assertNull(actualPdAnnotationUnknown.getOptionalContent());
    assertNull(actualPdAnnotationUnknown.getColor());
    assertNull(actualPdAnnotationUnknown.getAppearance());
    assertNull(actualPdAnnotationUnknown.getNormalAppearanceStream());
    assertEquals(-1, actualPdAnnotationUnknown.getStructParent());
    assertEquals(0, actualPdAnnotationUnknown.getAnnotationFlags());
    assertEquals(1, dic.size());
    assertFalse(actualPdAnnotationUnknown.isHidden());
    assertFalse(actualPdAnnotationUnknown.isInvisible());
    assertFalse(actualPdAnnotationUnknown.isLocked());
    assertFalse(actualPdAnnotationUnknown.isLockedContents());
    assertFalse(actualPdAnnotationUnknown.isNoRotate());
    assertFalse(actualPdAnnotationUnknown.isNoView());
    assertFalse(actualPdAnnotationUnknown.isNoZoom());
    assertFalse(actualPdAnnotationUnknown.isPrinted());
    assertFalse(actualPdAnnotationUnknown.isReadOnly());
    assertFalse(actualPdAnnotationUnknown.isToggleNoView());
    assertSame(dic, actualPdAnnotationUnknown.getCOSObject());
  }
}
