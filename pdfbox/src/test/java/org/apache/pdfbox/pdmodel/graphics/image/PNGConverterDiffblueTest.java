package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.image.PNGConverter.Chunk;
import org.apache.pdfbox.pdmodel.graphics.image.PNGConverter.PNGConverterState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PNGConverterDiffblueTest {
  /**
   * Test Chunk new {@link Chunk} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Chunk}
   */
  @Test
  @DisplayName("Test Chunk new Chunk (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Chunk.<init>()"})
  void testChunkNewChunk() {
    // Arrange and Act
    Chunk actualChunk = new Chunk();

    // Assert
    assertNull(actualChunk.bytes);
    assertEquals(0, actualChunk.chunkType);
    assertEquals(0, actualChunk.crc);
    assertEquals(0, actualChunk.length);
    assertEquals(0, actualChunk.start);
  }

  /**
   * Test {@link PNGConverter#convertPNGImage(PDDocument, byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#convertPNGImage(PDDocument, byte[])}
   */
  @Test
  @DisplayName("Test convertPNGImage(PDDocument, byte[]); when 'A'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject PNGConverter.convertPNGImage(PDDocument, byte[])"})
  void testConvertPNGImage_whenA_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(PNGConverter.convertPNGImage(new PDDocument(), new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20,
        'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20}));
  }

  /**
   * Test {@link PNGConverter#convertPNGImage(PDDocument, byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#convertPNGImage(PDDocument, byte[])}
   */
  @Test
  @DisplayName("Test convertPNGImage(PDDocument, byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject PNGConverter.convertPNGImage(PDDocument, byte[])"})
  void testConvertPNGImage_whenAxaxaxaxBytesIsUtf8_thenReturnNull() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull(PNGConverter.convertPNGImage(doc, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PNGConverter#mapPNGRenderIntent(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  @DisplayName("Test mapPNGRenderIntent(int); when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PNGConverter.mapPNGRenderIntent(int)"})
  void testMapPNGRenderIntent_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PNGConverter.mapPNGRenderIntent(-1));
  }

  /**
   * Test {@link PNGConverter#mapPNGRenderIntent(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return Name is {@code AbsoluteColorimetric}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  @DisplayName("Test mapPNGRenderIntent(int); when three; then return Name is 'AbsoluteColorimetric'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PNGConverter.mapPNGRenderIntent(int)"})
  void testMapPNGRenderIntent_whenThree_thenReturnNameIsAbsoluteColorimetric() {
    // Arrange and Act
    COSName actualMapPNGRenderIntentResult = PNGConverter.mapPNGRenderIntent(3);

    // Assert
    assertEquals("AbsoluteColorimetric", actualMapPNGRenderIntentResult.getName());
    assertNull(actualMapPNGRenderIntentResult.getKey());
    assertFalse(actualMapPNGRenderIntentResult.isDirect());
    assertFalse(actualMapPNGRenderIntentResult.isEmpty());
  }

  /**
   * Test {@link PNGConverter#mapPNGRenderIntent(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return Name is {@code Saturation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  @DisplayName("Test mapPNGRenderIntent(int); when two; then return Name is 'Saturation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PNGConverter.mapPNGRenderIntent(int)"})
  void testMapPNGRenderIntent_whenTwo_thenReturnNameIsSaturation() {
    // Arrange and Act
    COSName actualMapPNGRenderIntentResult = PNGConverter.mapPNGRenderIntent(2);

    // Assert
    assertEquals("Saturation", actualMapPNGRenderIntentResult.getName());
    assertNull(actualMapPNGRenderIntentResult.getKey());
    assertFalse(actualMapPNGRenderIntentResult.isDirect());
    assertFalse(actualMapPNGRenderIntentResult.isEmpty());
  }

  /**
   * Test {@link PNGConverter#mapPNGRenderIntent(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Name is {@code Perceptual}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  @DisplayName("Test mapPNGRenderIntent(int); when zero; then return Name is 'Perceptual'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PNGConverter.mapPNGRenderIntent(int)"})
  void testMapPNGRenderIntent_whenZero_thenReturnNameIsPerceptual() {
    // Arrange and Act
    COSName actualMapPNGRenderIntentResult = PNGConverter.mapPNGRenderIntent(0);

    // Assert
    assertEquals("Perceptual", actualMapPNGRenderIntentResult.getName());
    assertNull(actualMapPNGRenderIntentResult.getKey());
    assertFalse(actualMapPNGRenderIntentResult.isDirect());
    assertFalse(actualMapPNGRenderIntentResult.isEmpty());
  }

  /**
   * Test {@link PNGConverter#checkConverterState(PNGConverterState)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#checkConverterState(PNGConverterState)}
   */
  @Test
  @DisplayName("Test checkConverterState(PNGConverterState); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PNGConverter.checkConverterState(PNGConverterState)"})
  void testCheckConverterState_whenNull() {
    // Arrange, Act and Assert
    assertFalse(PNGConverter.checkConverterState(null));
  }

  /**
   * Test {@link PNGConverter#checkConverterState(PNGConverterState)}.
   * <ul>
   *   <li>When {@link PNGConverterState} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#checkConverterState(PNGConverterState)}
   */
  @Test
  @DisplayName("Test checkConverterState(PNGConverterState); when PNGConverterState (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PNGConverter.checkConverterState(PNGConverterState)"})
  void testCheckConverterState_whenPNGConverterState() {
    // Arrange, Act and Assert
    assertFalse(PNGConverter.checkConverterState(new PNGConverterState()));
  }

  /**
   * Test {@link PNGConverter#checkChunkSane(Chunk)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#checkChunkSane(Chunk)}
   */
  @Test
  @DisplayName("Test checkChunkSane(Chunk); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PNGConverter.checkChunkSane(Chunk)"})
  void testCheckChunkSane_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PNGConverter.checkChunkSane(null));
  }

  /**
   * Test {@link PNGConverter#crc(byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code -39806785}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PNGConverter#crc(byte[], int, int)}
   */
  @Test
  @DisplayName("Test crc(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '-39806785'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PNGConverter.crc(byte[], int, int)"})
  void testCrc_whenAxaxaxaxBytesIsUtf8_thenReturn39806785() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-39806785, PNGConverter.crc("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test PNGConverterState new {@link PNGConverterState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PNGConverterState}
   */
  @Test
  @DisplayName("Test PNGConverterState new PNGConverterState (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PNGConverterState.<init>()"})
  void testPNGConverterStateNewPNGConverterState() {
    // Arrange, Act and Assert
    assertTrue((new PNGConverterState()).IDATs.isEmpty());
  }
}
