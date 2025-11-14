package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex7() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    AnnotationFilter annotationsFilter = mock(AnnotationFilter.class);
    when(annotationsFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setAnnotationsFilter(annotationsFilter);

    // Act
    BufferedImage actualRenderImageResult = pdfRenderer.renderImage(1);

    // Assert
    verify(annotationsFilter).accept(isA(PDAnnotation.class));
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName("Test renderImage(int) with 'pageIndex'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenArrayListAddNull() throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(null);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setAnnotationsFilter(mock(AnnotationFilter.class));

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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImage(int)}
   */
  @Test
  @DisplayName(
      "Test renderImage(int) with 'pageIndex'; given ArrayList() add PDAnnotationFileAttachment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImage(int)"})
  void testRenderImageWithPageIndex_givenArrayListAddPDAnnotationFileAttachment()
      throws IOException {
    // Arrange
    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);

    AnnotationFilter annotationsFilter = mock(AnnotationFilter.class);
    when(annotationsFilter.accept(Mockito.<PDAnnotation>any())).thenReturn(true);

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setAnnotationsFilter(annotationsFilter);

    // Act
    BufferedImage actualRenderImageResult = pdfRenderer.renderImage(1);

    // Assert
    verify(annotationsFilter).accept(isA(PDAnnotation.class));
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
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName("Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName("Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName("Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName("Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage(new COSDictionary()));
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName("Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics5() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName("Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics6() throws IOException {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(page);
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale2() throws IOException {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(page);
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale4() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale5() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale6() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale7() throws IOException {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(0);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(page);
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(pageDictionary).isDirect();
    verify(pageDictionary).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale8() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(page);
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(pageDictionary).isDirect();
    verify(pageDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'; given PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale_givenPDPageCropBoxIsA0()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'; given PDPage() Rotation is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale_givenPDPageRotationIsOne()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(1);

    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <ul>
   *   <li>Given RotateInstance is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'; given RotateInstance is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale_givenRotateInstanceIsOne()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(AffineTransform.getRotateInstance(1.0d));
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <ul>
   *   <li>Then calls {@link GroupGraphics#addRenderingHints(Map)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'; then calls addRenderingHints(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale_thenCallsAddRenderingHints()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <ul>
   *   <li>Then calls {@link GroupGraphics#addRenderingHints(Map)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'; then calls addRenderingHints(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale_thenCallsAddRenderingHints2()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)} with {@code pageIndex},
   * {@code graphics}, {@code scale}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#set(int, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D, float)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D, float) with 'pageIndex', 'graphics', 'scale'; then calls set(int, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D, float)"})
  void testRenderPageToGraphicsWithPageIndexGraphicsScale_thenCallsSet() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(null);
    doNothing().when(cosArray).set(anyInt(), Mockito.<COSBase>any());
    when(cosArray.size()).thenReturn(3);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.setDocumentInformation(new PDDocumentInformation());
    document.addPage(page);
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics, 10.0f);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).set(anyInt(), Mockito.<COSBase>any());
    verify(cosArray).size();
    verify(pageDictionary).isDirect();
    verify(pageDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(anyDouble(), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <ul>
   *   <li>Given {@link AffineTransform#AffineTransform()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'; given AffineTransform()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics_givenAffineTransform() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'; given PDPage() Annotations is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics_givenPDPageAnnotationsIsArrayList()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'; given PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics_givenPDPageContentsIsArrayList()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'; given PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics_givenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'; given PDPage() Rotation is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics_givenPDPageRotationIsOne() throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setRotation(1);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(new AffineTransform());
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)} with {@code pageIndex}, {@code
   * graphics}.
   *
   * <ul>
   *   <li>Given RotateInstance is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderPageToGraphics(int, Graphics2D)}
   */
  @Test
  @DisplayName(
      "Test renderPageToGraphics(int, Graphics2D) with 'pageIndex', 'graphics'; given RotateInstance is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFRenderer.renderPageToGraphics(int, Graphics2D)"})
  void testRenderPageToGraphicsWithPageIndexGraphics_givenRotateInstanceIsOne() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    GroupGraphics groupGraphics = mock(GroupGraphics.class);
    when(groupGraphics.getClip()).thenReturn(new Double());
    doNothing().when(groupGraphics).addRenderingHints(Mockito.<Map<?, ?>>any());
    doNothing().when(groupGraphics).translate(anyDouble(), anyDouble());
    when(groupGraphics.getDeviceConfiguration()).thenReturn(null);
    when(groupGraphics.getTransform()).thenReturn(AffineTransform.getRotateInstance(1.0d));
    doNothing().when(groupGraphics).clearRect(anyInt(), anyInt(), anyInt(), anyInt());
    doNothing().when(groupGraphics).scale(anyDouble(), anyDouble());
    GroupGraphics groupGraphics2 = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics);
    GroupGraphics graphics = new GroupGraphics(new BufferedImage(1, 1, 1), groupGraphics2);

    // Act
    pdfRenderer.renderPageToGraphics(1, graphics);

    // Assert
    verify(groupGraphics).addRenderingHints(isA(Map.class));
    verify(groupGraphics).clearRect(0, 0, 612, 792);
    verify(groupGraphics).getClip();
    verify(groupGraphics).getDeviceConfiguration();
    verify(groupGraphics).getTransform();
    verify(groupGraphics, atLeast(1)).scale(eq(1.0d), anyDouble());
    verify(groupGraphics, atLeast(1)).translate(anyDouble(), anyDouble());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName("Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName("Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);

    // Act
    BufferedImage actualRenderImageWithDPIResult = pdfRenderer.renderImageWithDPI(1, 10.0f);

    // Assert
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName("Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName("Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    PDFRenderer pdfRenderer = new PDFRenderer(document);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        pdfRenderer.renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage(new COSDictionary()));
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType6() throws IOException {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(0);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    verify(pageDictionary).isDirect();
    verify(pageDictionary).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType7() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(pageDictionary).isDirect();
    verify(pageDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)} with {@code pageIndex},
   * {@code dpi}, {@code imageType}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#set(int, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float, ImageType)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float, ImageType) with 'pageIndex', 'dpi', 'imageType'; then calls set(int, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float, ImageType)"})
  void testRenderImageWithDPIWithPageIndexDpiImageType_thenCallsSet() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(null);
    doNothing().when(cosArray).set(anyInt(), Mockito.<COSBase>any());
    when(cosArray.size()).thenReturn(3);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f, ImageType.BINARY);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).set(anyInt(), Mockito.<COSBase>any());
    verify(cosArray).size();
    verify(pageDictionary).isDirect();
    verify(pageDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertTrue(colorModel instanceof IndexColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
    assertTrue(sampleModel instanceof MultiPixelPackedSampleModel);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[] {1}, sampleModel.getSampleSize());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'; given COSArray getObject(int) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi_givenCOSArrayGetObjectReturnCOSDictionary()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(pageDictionary).isDirect();
    verify(pageDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'; given COSDictionary getInt(COSName, int) return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi_givenCOSDictionaryGetIntReturnZero()
      throws IOException {
    // Arrange
    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(0);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    verify(pageDictionary).isDirect();
    verify(pageDictionary).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#set(int, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'; then calls set(int, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi_thenCallsSet() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(null);
    doNothing().when(cosArray).set(anyInt(), Mockito.<COSBase>any());
    when(cosArray.size()).thenReturn(3);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(pageDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(pageDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(pageDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(pageDictionary).getIndirectObjectKeys(Mockito.<Collection<COSObjectKey>>any());
    when(pageDictionary.isDirect()).thenReturn(true);
    when(pageDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(pageDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = new PDPage(pageDictionary);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(page);
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).set(anyInt(), Mockito.<COSBase>any());
    verify(cosArray).size();
    verify(pageDictionary).isDirect();
    verify(pageDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(pageDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(pageDictionary).getIndirectObjectKeys(isA(Collection.class));
    verify(pageDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(pageDictionary).getUpdateState();
    verify(pageDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
   * Test {@link PDFRenderer#renderImageWithDPI(int, float)} with {@code pageIndex}, {@code dpi}.
   *
   * <ul>
   *   <li>Then Data DataBuffer return {@link DataBufferInt}.
   * </ul>
   *
   * <p>Method under test: {@link PDFRenderer#renderImageWithDPI(int, float)}
   */
  @Test
  @DisplayName(
      "Test renderImageWithDPI(int, float) with 'pageIndex', 'dpi'; then Data DataBuffer return DataBufferInt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage PDFRenderer.renderImageWithDPI(int, float)"})
  void testRenderImageWithDPIWithPageIndexDpi_thenDataDataBufferReturnDataBufferInt()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    BufferedImage actualRenderImageWithDPIResult =
        new PDFRenderer(document).renderImageWithDPI(1, 10.0f);

    // Assert
    DataBuffer dataBuffer = actualRenderImageWithDPIResult.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualRenderImageWithDPIResult.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualRenderImageWithDPIResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRenderImageWithDPIResult.getSampleModel();
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
