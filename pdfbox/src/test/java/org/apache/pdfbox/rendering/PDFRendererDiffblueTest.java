package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFRendererDiffblueTest {
  /**
   * Test {@link PDFRenderer#PDFRenderer(PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDFRenderer#document} ResourceCache return {@link DefaultResourceCache}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#PDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDFRenderer(PDDocument); then document ResourceCache return DefaultResourceCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.<init>(PDDocument)"})
  void testNewPDFRenderer_thenDocumentResourceCacheReturnDefaultResourceCache() {
    // Arrange and Act
    PDFRenderer actualPdfRenderer = new PDFRenderer(new PDDocument());

    // Assert
    PDDocument pdDocument = actualPdfRenderer.document;
    assertTrue(pdDocument.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualPdfRenderer.getRenderingHints());
    assertNull(actualPdfRenderer.getPageImage());
    assertNull(pdDocument.getDocumentId());
    assertNull(pdDocument.getEncryption());
    assertNull(pdDocument.getLastSignatureDictionary());
    assertNull(actualPdfRenderer.getDefaultDestination());
    assertEquals(0, pdDocument.getNumberOfPages());
    assertEquals(0.5f, actualPdfRenderer.getImageDownscalingOptimizationThreshold());
    assertEquals(1.4f, pdDocument.getVersion());
    assertFalse(pdDocument.isAllSecurityToBeRemoved());
    assertFalse(pdDocument.isEncrypted());
    assertFalse(actualPdfRenderer.isSubsamplingAllowed());
    assertTrue(pdDocument.getSignatureDictionaries().isEmpty());
    assertTrue(pdDocument.getSignatureFields().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFRenderer#setAnnotationsFilter(AnnotationFilter)}
   *   <li>{@link PDFRenderer#setDefaultDestination(RenderDestination)}
   *   <li>{@link PDFRenderer#setImageDownscalingOptimizationThreshold(float)}
   *   <li>{@link PDFRenderer#setRenderingHints(RenderingHints)}
   *   <li>{@link PDFRenderer#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFRenderer#getAnnotationsFilter()}
   *   <li>{@link PDFRenderer#getDefaultDestination()}
   *   <li>{@link PDFRenderer#getImageDownscalingOptimizationThreshold()}
   *   <li>{@link PDFRenderer#getPageImage()}
   *   <li>{@link PDFRenderer#getRenderingHints()}
   *   <li>{@link PDFRenderer#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AnnotationFilter PDFRenderer.getAnnotationsFilter()",
    "RenderDestination PDFRenderer.getDefaultDestination()",
    "float PDFRenderer.getImageDownscalingOptimizationThreshold()",
    "BufferedImage PDFRenderer.getPageImage()",
    "RenderingHints PDFRenderer.getRenderingHints()",
    "boolean PDFRenderer.isSubsamplingAllowed()",
    "void PDFRenderer.setAnnotationsFilter(AnnotationFilter)",
    "void PDFRenderer.setDefaultDestination(RenderDestination)",
    "void PDFRenderer.setImageDownscalingOptimizationThreshold(float)",
    "void PDFRenderer.setRenderingHints(RenderingHints)",
    "void PDFRenderer.setSubsamplingAllowed(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PDFRenderer pdfRenderer = new PDFRenderer(new PDDocument());
    AnnotationFilter annotationsFilter = mock(AnnotationFilter.class);

    // Act
    pdfRenderer.setAnnotationsFilter(annotationsFilter);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);
    pdfRenderer.setImageDownscalingOptimizationThreshold(10.0f);
    pdfRenderer.setRenderingHints(null);
    pdfRenderer.setSubsamplingAllowed(true);
    AnnotationFilter actualAnnotationsFilter = pdfRenderer.getAnnotationsFilter();
    RenderDestination actualDefaultDestination = pdfRenderer.getDefaultDestination();
    float actualImageDownscalingOptimizationThreshold =
        pdfRenderer.getImageDownscalingOptimizationThreshold();
    BufferedImage actualPageImage = pdfRenderer.getPageImage();
    RenderingHints actualRenderingHints = pdfRenderer.getRenderingHints();

    // Assert
    assertNull(actualRenderingHints);
    assertNull(actualPageImage);
    assertEquals(10.0f, actualImageDownscalingOptimizationThreshold);
    assertEquals(RenderDestination.EXPORT, actualDefaultDestination);
    assertTrue(pdfRenderer.isSubsamplingAllowed());
    assertSame(annotationsFilter, actualAnnotationsFilter);
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);

    // Act
    BufferedImage actualRenderImageResult = pdfRenderer.renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex5() throws IOException {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex6() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName(
      "Test renderImage(int) with 'pageIndex'; given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenArrayListAddPDStreamWithDocumentIsCOSDocument()
      throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName(
      "Test renderImage(int) with 'pageIndex'; given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenArrayListAddPDStreamWithDocumentIsCOSDocument2()
      throws IOException {
    // Arrange
    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; given PDPage() Annotations is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenPDPageAnnotationsIsArrayList() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; given PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; given PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; given PDPage() Rotation is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenPDPageRotationIsOne() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(1);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; given PDPage() Rotation is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenPDPageRotationIsZero() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(0);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Then Data DataBuffer return {@link DataBufferInt}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; then Data DataBuffer return DataBufferInt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_thenDataDataBufferReturnDataBufferInt() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    DataBuffer dataBuffer = actualRenderImageResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDFRenderer#renderImage(int)} with {@code pageIndex}.
   *
   * <ul>
   *   <li>Then return TileWidth is four hundred nineteen.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName(
      "Test renderImage(int) with 'pageIndex'; then return TileWidth is four hundred nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_thenReturnTileWidthIsFourHundredNineteen() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A5);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    // Act
    BufferedImage actualRenderImageResult = new PDFRenderer(document).renderImage(1);

    // Assert
    assertEquals(419, actualRenderImageResult.getTileWidth());
    assertEquals(419, actualRenderImageResult.getWidth());
    assertEquals(595, actualRenderImageResult.getHeight());
    assertEquals(595, actualRenderImageResult.getTileHeight());
  }

  /**
   * Test {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}.
   *
   * <p>Method under test: {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(PDOptionalContentGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFRenderer.isGroupEnabled(PDOptionalContentGroup)"})
  void testIsGroupEnabled() {
    // Arrange
    PDFRenderer pdfRenderer = new PDFRenderer(new PDDocument());

    // Act
    boolean actualIsGroupEnabledResult =
        pdfRenderer.isGroupEnabled(new PDOptionalContentGroup("Name"));

    // Assert
    assertTrue(actualIsGroupEnabledResult);
  }

  /**
   * Test {@link PDFRenderer#createPageDrawer(PageDrawerParameters)}.
   *
   * <ul>
   *   <li>Then return Graphics is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#createPageDrawer(PageDrawerParameters)}
   */
  @Test
  @DisplayName("Test createPageDrawer(PageDrawerParameters); then return Graphics is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDrawer PDFRenderer.createPageDrawer(PageDrawerParameters)"})
  void testCreatePageDrawer_thenReturnGraphicsIsNull() throws IOException {
    // Arrange
    PDFRenderer pdfRenderer = new PDFRenderer(new PDDocument());
    PDFRenderer renderer = new PDFRenderer(new PDDocument());
    PageDrawerParameters parameters =
        new PageDrawerParameters(
            renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f);

    // Act
    PageDrawer actualCreatePageDrawerResult = pdfRenderer.createPageDrawer(parameters);

    // Assert
    assertNull(actualCreatePageDrawerResult.getGraphics());
    assertNull(actualCreatePageDrawerResult.getCurrentPoint());
    assertNull(actualCreatePageDrawerResult.getCurrentPage());
    assertNull(actualCreatePageDrawerResult.getResources());
    assertNull(actualCreatePageDrawerResult.getGraphicsState());
    assertNull(actualCreatePageDrawerResult.getInitialMatrix());
    assertEquals(0, actualCreatePageDrawerResult.getGraphicsStackSize());
    assertEquals(0, actualCreatePageDrawerResult.getLevel());
    assertSame(renderer, actualCreatePageDrawerResult.getRenderer());
  }
}
