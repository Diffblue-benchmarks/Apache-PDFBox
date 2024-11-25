package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImageToPDFDiffblueTest {
  /**
   * Test new {@link ImageToPDF} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImageToPDF}
   */
  @Test
  @DisplayName("Test new ImageToPDF (default constructor)")
  void testNewImageToPDF() {
    // Arrange and Act
    ImageToPDF actualImageToPDF = new ImageToPDF();

    // Assert
    PDRectangle mediaBox = actualImageToPDF.getMediaBox();
    COSArray cOSArray = mediaBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertTrue(mediaBox instanceof PDImmutableRectangle);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, mediaBox.getLowerLeftX());
    assertEquals(0.0f, mediaBox.getLowerLeftY());
    assertEquals(612.0f, mediaBox.getUpperRightX());
    assertEquals(612.0f, mediaBox.getWidth());
    assertEquals(792.0f, mediaBox.getHeight());
    assertEquals(792.0f, mediaBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(actualImageToPDF.isAutoOrientation());
    assertFalse(actualImageToPDF.isLandscape());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, mediaBox.getCOSObject());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertTrue(actualIsAutoOrientationResult);
    assertTrue(imageToPDF.isLandscape());
    assertSame(mediaBox, actualMediaBox);
  }
}
