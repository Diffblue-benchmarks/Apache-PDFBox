package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnnotationBorderDiffblueTest {
  /**
   * Test {@link AnnotationBorder#getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link AnnotationBorder#dashArray} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotationBorder#getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary); when 'null'; then return dashArray is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AnnotationBorder AnnotationBorder.getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)"})
  void testGetAnnotationBorder_whenNull_thenReturnDashArrayIsNull() {
    // Arrange and Act
    AnnotationBorder actualAnnotationBorder = AnnotationBorder.getAnnotationBorder(new PDAnnotationCaret(), null);

    // Assert
    assertNull(actualAnnotationBorder.dashArray);
    assertEquals(1.0f, actualAnnotationBorder.width);
    assertFalse(actualAnnotationBorder.underline);
  }

  /**
   * Test {@link AnnotationBorder#getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)}.
   * <ul>
   *   <li>When {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.</li>
   *   <li>Then return {@link AnnotationBorder#dashArray} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotationBorder#getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary); when PDBorderStyleDictionary(); then return dashArray is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AnnotationBorder AnnotationBorder.getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)"})
  void testGetAnnotationBorder_whenPDBorderStyleDictionary_thenReturnDashArrayIsNull() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    AnnotationBorder actualAnnotationBorder = AnnotationBorder.getAnnotationBorder(annotation,
        new PDBorderStyleDictionary());

    // Assert
    assertNull(actualAnnotationBorder.dashArray);
    assertEquals(1.0f, actualAnnotationBorder.width);
    assertFalse(actualAnnotationBorder.underline);
  }

  /**
   * Test new {@link AnnotationBorder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AnnotationBorder}
   */
  @Test
  @DisplayName("Test new AnnotationBorder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AnnotationBorder.<init>()"})
  void testNewAnnotationBorder() {
    // Arrange and Act
    AnnotationBorder actualAnnotationBorder = new AnnotationBorder();

    // Assert
    assertNull(actualAnnotationBorder.dashArray);
    assertEquals(0.0f, actualAnnotationBorder.width);
    assertFalse(actualAnnotationBorder.underline);
  }
}
