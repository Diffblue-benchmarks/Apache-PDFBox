package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;

class OverlayDiffblueTest {
  /**
   * Method under test: {@link Overlay#overlay(Map)}
   */
  @Test
  void testOverlay() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> overlay.overlay(new HashMap<>()));
  }

  /**
   * Method under test: {@link Overlay#overlay(Map)}
   */
  @Test
  void testOverlay2() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();
    PDDocument inputPDF = new PDDocument();
    overlay.setInputPDF(inputPDF);

    // Act and Assert
    assertSame(inputPDF, overlay.overlay(new HashMap<>()));
  }

  /**
   * Method under test: {@link Overlay#overlay(Map)}
   */
  @Test
  void testOverlay3() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();
    overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
    overlay.setInputFile(null);
    PDDocument inputPDF = new PDDocument();
    overlay.setInputPDF(inputPDF);
    overlay.setDefaultOverlayFile(null);
    overlay.setDefaultOverlayPDF(null);
    overlay.setFirstPageOverlayFile(null);
    overlay.setFirstPageOverlayPDF(null);
    overlay.setLastPageOverlayFile(null);
    overlay.setLastPageOverlayPDF(null);
    overlay.setOddPageOverlayFile(null);
    overlay.setOddPageOverlayPDF(null);
    overlay.setEvenPageOverlayFile(null);
    overlay.setEvenPageOverlayPDF(null);
    overlay.setAllPagesOverlayFile(null);
    overlay.setAllPagesOverlayPDF(new PDDocument());

    // Act and Assert
    assertSame(inputPDF, overlay.overlay(new HashMap<>()));
  }

  /**
   * Method under test: {@link Overlay#overlayDocuments(Map)}
   */
  @Test
  void testOverlayDocuments() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> overlay.overlayDocuments(new HashMap<>()));
  }

  /**
   * Method under test: {@link Overlay#overlayDocuments(Map)}
   */
  @Test
  void testOverlayDocuments2() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();
    PDDocument inputPDF = new PDDocument();
    overlay.setInputPDF(inputPDF);

    // Act and Assert
    assertSame(inputPDF, overlay.overlayDocuments(new HashMap<>()));
  }

  /**
   * Method under test: {@link Overlay#overlayDocuments(Map)}
   */
  @Test
  void testOverlayDocuments3() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();
    overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
    overlay.setInputFile(null);
    PDDocument inputPDF = new PDDocument();
    overlay.setInputPDF(inputPDF);
    overlay.setDefaultOverlayFile(null);
    overlay.setDefaultOverlayPDF(null);
    overlay.setFirstPageOverlayFile(null);
    overlay.setFirstPageOverlayPDF(null);
    overlay.setLastPageOverlayFile(null);
    overlay.setLastPageOverlayPDF(null);
    overlay.setOddPageOverlayFile(null);
    overlay.setOddPageOverlayPDF(null);
    overlay.setEvenPageOverlayFile(null);
    overlay.setEvenPageOverlayPDF(null);
    overlay.setAllPagesOverlayFile(null);
    overlay.setAllPagesOverlayPDF(new PDDocument());

    // Act and Assert
    assertSame(inputPDF, overlay.overlayDocuments(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link Overlay#calculateAffineTransform(PDPage, PDRectangle)}
   */
  @Test
  void testCalculateAffineTransform() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    AffineTransform actualCalculateAffineTransformResult = overlay.calculateAffineTransform(new PDPage(),
        PDRectangle.A0);

    // Assert
    assertEquals(-1289.1968994140625d, actualCalculateAffineTransformResult.getTranslateY());
    assertEquals(-885.968505859375d, actualCalculateAffineTransformResult.getTranslateX());
    assertEquals(0.0d, actualCalculateAffineTransformResult.getShearX());
    assertEquals(0.0d, actualCalculateAffineTransformResult.getShearY());
    assertEquals(1, actualCalculateAffineTransformResult.getType());
    assertEquals(1.0d, actualCalculateAffineTransformResult.getDeterminant());
    assertEquals(1.0d, actualCalculateAffineTransformResult.getScaleX());
    assertEquals(1.0d, actualCalculateAffineTransformResult.getScaleY());
    assertFalse(actualCalculateAffineTransformResult.isIdentity());
  }

  /**
   * Method under test:
   * {@link Overlay#calculateAffineTransform(PDPage, PDRectangle)}
   */
  @Test
  void testCalculateAffineTransform2() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    AffineTransform actualCalculateAffineTransformResult = overlay
        .calculateAffineTransform(new PDPage(new COSDictionary()), PDRectangle.A0);

    // Assert
    assertEquals(-1289.1968994140625d, actualCalculateAffineTransformResult.getTranslateY());
    assertEquals(-885.968505859375d, actualCalculateAffineTransformResult.getTranslateX());
    assertEquals(0.0d, actualCalculateAffineTransformResult.getShearX());
    assertEquals(0.0d, actualCalculateAffineTransformResult.getShearY());
    assertEquals(1, actualCalculateAffineTransformResult.getType());
    assertEquals(1.0d, actualCalculateAffineTransformResult.getDeterminant());
    assertEquals(1.0d, actualCalculateAffineTransformResult.getScaleX());
    assertEquals(1.0d, actualCalculateAffineTransformResult.getScaleY());
    assertFalse(actualCalculateAffineTransformResult.isIdentity());
  }

  /**
   * Method under test: {@link Overlay#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument defaultOverlayPDF = new PDDocument(streamCacheCreateFunction);

    try (Overlay overlay = new Overlay()) {
      overlay.setDefaultOverlayPDF(defaultOverlayPDF);
    }

    // Act and Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link Overlay#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument defaultOverlayPDF = new PDDocument(streamCacheCreateFunction);

    try (Overlay overlay = new Overlay()) {
      overlay.setDefaultOverlayPDF(defaultOverlayPDF);
    }

    // Act and Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link Overlay#close()}
   */
  @Test
  void testClose3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument defaultOverlayPDF = new PDDocument(streamCacheCreateFunction);
    defaultOverlayPDF.save(new ByteArrayOutputStream(3), CompressParameters.DEFAULT_COMPRESSION);

    try (Overlay overlay = new Overlay()) {
      overlay.setDefaultOverlayPDF(defaultOverlayPDF);
    }

    // Act and Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link Overlay#close()}
   */
  @Test
  void testClose4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument defaultOverlayPDF = new PDDocument(streamCacheCreateFunction);
    defaultOverlayPDF.addPage(new PDPage());
    defaultOverlayPDF.addSignature(new PDSignature());

    try (Overlay overlay = new Overlay()) {
      overlay.setDefaultOverlayPDF(defaultOverlayPDF);
    }

    // Act and Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Overlay#setAllPagesOverlayFile(String)}
   *   <li>{@link Overlay#setAllPagesOverlayPDF(PDDocument)}
   *   <li>{@link Overlay#setDefaultOverlayFile(String)}
   *   <li>{@link Overlay#setDefaultOverlayPDF(PDDocument)}
   *   <li>{@link Overlay#setEvenPageOverlayFile(String)}
   *   <li>{@link Overlay#setEvenPageOverlayPDF(PDDocument)}
   *   <li>{@link Overlay#setFirstPageOverlayFile(String)}
   *   <li>{@link Overlay#setFirstPageOverlayPDF(PDDocument)}
   *   <li>{@link Overlay#setInputFile(String)}
   *   <li>{@link Overlay#setInputPDF(PDDocument)}
   *   <li>{@link Overlay#setLastPageOverlayFile(String)}
   *   <li>{@link Overlay#setLastPageOverlayPDF(PDDocument)}
   *   <li>{@link Overlay#setOddPageOverlayFile(String)}
   *   <li>{@link Overlay#setOddPageOverlayPDF(PDDocument)}
   *   <li>{@link Overlay#setOverlayPosition(Overlay.Position)}
   *   <li>{@link Overlay#getDefaultOverlayFile()}
   *   <li>{@link Overlay#getInputFile()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    overlay.setAllPagesOverlayFile("All Pages Overlay File");
    overlay.setAllPagesOverlayPDF(new PDDocument());
    overlay.setDefaultOverlayFile("Default Overlay File");
    overlay.setDefaultOverlayPDF(new PDDocument());
    overlay.setEvenPageOverlayFile("Even Page Overlay File");
    overlay.setEvenPageOverlayPDF(new PDDocument());
    overlay.setFirstPageOverlayFile("First Page Overlay File");
    overlay.setFirstPageOverlayPDF(new PDDocument());
    overlay.setInputFile("Input File");
    overlay.setInputPDF(new PDDocument());
    overlay.setLastPageOverlayFile("Last Page Overlay File");
    overlay.setLastPageOverlayPDF(new PDDocument());
    overlay.setOddPageOverlayFile("Odd Page Overlay File");
    overlay.setOddPageOverlayPDF(new PDDocument());
    overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
    String actualDefaultOverlayFile = overlay.getDefaultOverlayFile();

    // Assert that nothing has changed
    assertEquals("Default Overlay File", actualDefaultOverlayFile);
    assertEquals("Input File", overlay.getInputFile());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Overlay}
   */
  @Test
  void testNewOverlay() {
    // Arrange and Act
    Overlay actualOverlay = new Overlay();

    // Assert
    assertNull(actualOverlay.getDefaultOverlayFile());
    assertNull(actualOverlay.getInputFile());
  }
}
