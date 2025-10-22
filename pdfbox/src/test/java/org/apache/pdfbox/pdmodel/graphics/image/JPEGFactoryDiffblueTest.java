package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JPEGFactoryDiffblueTest {
  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document}, {@code image}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'; when PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage_whenPDDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult = JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    ColorModel colorModel = image.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    ColorModel colorModel2 = opaqueImage.getColorModel();
    assertTrue(colorModel2 instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = opaqueImage.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    assertEquals(1, image.getWritableTileIndices().length);
    assertEquals(1, opaqueImage.getWritableTileIndices().length);
    assertEquals(colorModel, colorModel2);
    assertEquals(sampleModel, sampleModel2);
  }
}
