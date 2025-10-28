package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.Test;

class AnnotationBorderDiffblueTest {
  /**
   * Method under test:
   * {@link AnnotationBorder#getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)}
   */
  @Test
  void testGetAnnotationBorder() {
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
   * Method under test:
   * {@link AnnotationBorder#getAnnotationBorder(PDAnnotation, PDBorderStyleDictionary)}
   */
  @Test
  void testGetAnnotationBorder2() {
    // Arrange and Act
    AnnotationBorder actualAnnotationBorder = AnnotationBorder.getAnnotationBorder(new PDAnnotationCaret(), null);

    // Assert
    assertNull(actualAnnotationBorder.dashArray);
    assertEquals(1.0f, actualAnnotationBorder.width);
    assertFalse(actualAnnotationBorder.underline);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AnnotationBorder}
   */
  @Test
  void testNewAnnotationBorder() {
    // Arrange and Act
    AnnotationBorder actualAnnotationBorder = new AnnotationBorder();

    // Assert
    assertNull(actualAnnotationBorder.dashArray);
    assertEquals(0.0f, actualAnnotationBorder.width);
    assertFalse(actualAnnotationBorder.underline);
  }
}
