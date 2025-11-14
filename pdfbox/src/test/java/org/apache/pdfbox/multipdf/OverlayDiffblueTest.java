package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.multipdf.Overlay.Position;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OverlayDiffblueTest {
  /**
   * Test {@link Overlay#overlay(Map)}.
   *
   * <p>Method under test: {@link Overlay#overlay(Map)}
   */
  @Test
  @DisplayName("Test overlay(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument Overlay.overlay(Map)"})
  void testOverlay() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> overlay.overlay(new HashMap<>()));
  }

  /**
   * Test {@link Overlay#overlayDocuments(Map)}.
   *
   * <p>Method under test: {@link Overlay#overlayDocuments(Map)}
   */
  @Test
  @DisplayName("Test overlayDocuments(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument Overlay.overlayDocuments(Map)"})
  void testOverlayDocuments() throws IOException {
    // Arrange
    Overlay overlay = new Overlay();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> overlay.overlayDocuments(new HashMap<>()));
  }

  /**
   * Test {@link Overlay#close()}.
   *
   * <p>Method under test: {@link Overlay#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Overlay.close()"})
  void testClose() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument defaultOverlayPDF = new PDDocument(streamCacheCreateFunction);
    defaultOverlayPDF.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    try (Overlay overlay = new Overlay()) {
      overlay.setDefaultOverlayPDF(defaultOverlayPDF);
    }

    // Act and Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link Overlay#close()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument(StreamCacheCreateFunction)} with {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction} addPage {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link Overlay#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given PDDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction addPage PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Overlay.close()"})
  void testClose_givenPDDocumentWithStreamCacheCreateFunctionAddPagePDPage() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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
   * Test {@link Overlay#close()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link Overlay#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given StreamCacheCreateFunction create() return 'null'; then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Overlay.close()"})
  void testClose_givenStreamCacheCreateFunctionCreateReturnNull_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument defaultOverlayPDF = new PDDocument(streamCacheCreateFunction);

    try (Overlay overlay = new Overlay()) {
      overlay.setDefaultOverlayPDF(defaultOverlayPDF);
    }

    // Act and Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link Overlay#calculateAffineTransform(PDPage, PDRectangle)}.
   *
   * <ul>
   *   <li>Then return TranslateY is {@code -1289.1968994140625}.
   * </ul>
   *
   * <p>Method under test: {@link Overlay#calculateAffineTransform(PDPage, PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test calculateAffineTransform(PDPage, PDRectangle); then return TranslateY is '-1289.1968994140625'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AffineTransform Overlay.calculateAffineTransform(PDPage, PDRectangle)"})
  void testCalculateAffineTransform_thenReturnTranslateYIs12891968994140625() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    AffineTransform actualCalculateAffineTransformResult =
        overlay.calculateAffineTransform(new PDPage(), PDRectangle.A0);

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
   * Test {@link Overlay#calculateAffineTransform(PDPage, PDRectangle)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link Overlay#calculateAffineTransform(PDPage, PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test calculateAffineTransform(PDPage, PDRectangle); when PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AffineTransform Overlay.calculateAffineTransform(PDPage, PDRectangle)"})
  void testCalculateAffineTransform_whenPDPageWithPageDictionaryIsCOSDictionary() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    AffineTransform actualCalculateAffineTransformResult =
        overlay.calculateAffineTransform(new PDPage(new COSDictionary()), PDRectangle.A0);

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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *   <li>{@link Overlay#setOverlayPosition(Position)}
   *   <li>{@link Overlay#getDefaultOverlayFile()}
   *   <li>{@link Overlay#getInputFile()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Overlay.getDefaultOverlayFile()",
    "String Overlay.getInputFile()",
    "void Overlay.setAllPagesOverlayFile(String)",
    "void Overlay.setAllPagesOverlayPDF(PDDocument)",
    "void Overlay.setDefaultOverlayFile(String)",
    "void Overlay.setDefaultOverlayPDF(PDDocument)",
    "void Overlay.setEvenPageOverlayFile(String)",
    "void Overlay.setEvenPageOverlayPDF(PDDocument)",
    "void Overlay.setFirstPageOverlayFile(String)",
    "void Overlay.setFirstPageOverlayPDF(PDDocument)",
    "void Overlay.setInputFile(String)",
    "void Overlay.setInputPDF(PDDocument)",
    "void Overlay.setLastPageOverlayFile(String)",
    "void Overlay.setLastPageOverlayPDF(PDDocument)",
    "void Overlay.setOddPageOverlayFile(String)",
    "void Overlay.setOddPageOverlayPDF(PDDocument)",
    "void Overlay.setOverlayPosition(Position)"
  })
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
    overlay.setOverlayPosition(Position.FOREGROUND);
    String actualDefaultOverlayFile = overlay.getDefaultOverlayFile();

    // Assert
    assertEquals("Default Overlay File", actualDefaultOverlayFile);
    assertEquals("Input File", overlay.getInputFile());
  }

  /**
   * Test new {@link Overlay} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Overlay}
   */
  @Test
  @DisplayName("Test new Overlay (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Overlay.<init>()"})
  void testNewOverlay() {
    // Arrange and Act
    Overlay actualOverlay = new Overlay();

    // Assert
    assertNull(actualOverlay.getDefaultOverlayFile());
    assertNull(actualOverlay.getInputFile());
  }
}
