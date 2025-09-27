package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LosslessFactoryDiffblueTest {
  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenPDDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    BufferedImage opaqueImage =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1)).getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument(COSDocument)} with doc is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when PDDocument(COSDocument) with doc is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenPDDocumentWithDocIsCOSDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument(new COSDocument());

    // Act and Assert
    BufferedImage opaqueImage =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1)).getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject() throws IOException {
    // Arrange and Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    assertTrue(
        actualPrepareImageXObjectResult.getOpaqueImage().getSampleModel()
            instanceof PixelInterleavedSampleModel);
    assertTrue(
        actualPrepareImageXObjectResult.getRawRaster().getSampleModel()
            instanceof PixelInterleavedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return COSObject Values size is seven.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when 'A'; then return COSObject Values size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject_whenA_thenReturnCOSObjectValuesSizeIsSeven() throws IOException {
    // Arrange and Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, null);

    // Assert
    COSDictionary cOSObject = actualPrepareImageXObjectResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDStream stream = actualPrepareImageXObjectResult.getStream();
    assertEquals(1, stream.getFilters().size());
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertSame(cOSObject, stream.getCOSObject());
  }
}
