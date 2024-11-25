package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAppearanceStreamDiffblueTest {
  /**
   * Test {@link PDAppearanceStream#PDAppearanceStream(COSStream)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceStream#PDAppearanceStream(COSStream)}
   */
  @Test
  @DisplayName("Test new PDAppearanceStream(COSStream); when COSStream(); then return Stream DecodeParms is 'null'")
  void testNewPDAppearanceStream_whenCOSStream_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDAppearanceStream actualPdAppearanceStream = new PDAppearanceStream(stream);

    // Assert
    PDStream stream2 = actualPdAppearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = actualPdAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualPdAppearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdAppearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualPdAppearanceStream.getOptionalContent());
    assertNull(actualPdAppearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualPdAppearanceStream.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualPdAppearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualPdAppearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, stream.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, actualPdAppearanceStream.getCOSObject());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAppearanceStream#PDAppearanceStream(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceStream#PDAppearanceStream(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDAppearanceStream(PDDocument); when PDDocument(); then return Stream DecodeParms is 'null'")
  void testNewPDAppearanceStream_whenPDDocument_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDAppearanceStream actualPdAppearanceStream = new PDAppearanceStream(new PDDocument());

    // Assert
    PDStream stream = actualPdAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = actualPdAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    COSStream cOSObject = actualPdAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAppearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdAppearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualPdAppearanceStream.getOptionalContent());
    assertNull(actualPdAppearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualPdAppearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualPdAppearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, actualPdAppearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
