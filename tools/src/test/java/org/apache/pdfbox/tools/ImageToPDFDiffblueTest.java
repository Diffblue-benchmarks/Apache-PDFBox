package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImageToPDFDiffblueTest {
  /**
   * Test new {@link ImageToPDF} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ImageToPDF}
   */
  @Test
  @DisplayName("Test new ImageToPDF (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageToPDF.<init>()"})
  void testNewImageToPDF() {
    // Arrange and Act
    ImageToPDF actualImageToPDF = new ImageToPDF();

    // Assert
    PDRectangle mediaBox = actualImageToPDF.getMediaBox();
    assertTrue(mediaBox instanceof PDImmutableRectangle);
    assertEquals(0.0f, mediaBox.getLowerLeftX());
    assertEquals(0.0f, mediaBox.getLowerLeftY());
    COSArray cOSArray = mediaBox.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertEquals(612.0f, mediaBox.getUpperRightX());
    assertEquals(612.0f, mediaBox.getWidth());
    assertEquals(792.0f, mediaBox.getHeight());
    assertEquals(792.0f, mediaBox.getUpperRightY());
    assertFalse(actualImageToPDF.isAutoOrientation());
    assertFalse(actualImageToPDF.isLandscape());
    assertSame(cOSArray, mediaBox.getCOSObject());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageToPDF#setLandscape(boolean)}
   *   <li>{@link ImageToPDF#setMediaBox(PDRectangle)}
   *   <li>{@link ImageToPDF#setAutoOrientation(boolean)}
   *   <li>{@link ImageToPDF#getMediaBox()}
   *   <li>{@link ImageToPDF#isAutoOrientation()}
   *   <li>{@link ImageToPDF#isLandscape()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle ImageToPDF.getMediaBox()",
    "boolean ImageToPDF.isAutoOrientation()",
    "boolean ImageToPDF.isLandscape()",
    "void ImageToPDF.setAutoOrientation(boolean)",
    "void ImageToPDF.setLandscape(boolean)",
    "void ImageToPDF.setMediaBox(PDRectangle)"
  })
  void testGettersAndSetters() {
    // Arrange
    ImageToPDF imageToPDF = new ImageToPDF();

    // Act
    imageToPDF.setLandscape(true);
    PDRectangle mediaBox = new PDRectangle();
    imageToPDF.setMediaBox(mediaBox);
    imageToPDF.setAutoOrientation(true);
    PDRectangle actualMediaBox = imageToPDF.getMediaBox();
    boolean actualIsAutoOrientationResult = imageToPDF.isAutoOrientation();

    // Assert
    assertTrue(actualIsAutoOrientationResult);
    assertTrue(imageToPDF.isLandscape());
    assertSame(mediaBox, actualMediaBox);
  }
}
