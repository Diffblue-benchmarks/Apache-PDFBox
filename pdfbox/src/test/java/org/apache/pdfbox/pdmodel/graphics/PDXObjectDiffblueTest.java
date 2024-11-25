package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDXObjectDiffblueTest {
  /**
   * Test {@link PDXObject#createXObject(COSBase, PDResources)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXObject#createXObject(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test createXObject(COSBase, PDResources); when COSStream(); then throw IOException")
  void testCreateXObject_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    COSStream base = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDXObject.createXObject(base, new PDResources()));
  }

  /**
   * Test {@link PDXObject#createXObject(COSBase, PDResources)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXObject#createXObject(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test createXObject(COSBase, PDResources); when FALSE; then throw IOException")
  void testCreateXObject_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDXObject.createXObject(COSBoolean.FALSE, new PDResources()));
  }

  /**
   * Test {@link PDXObject#createXObject(COSBase, PDResources)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXObject#createXObject(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test createXObject(COSBase, PDResources); when 'null'; then return 'null'")
  void testCreateXObject_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDXObject.createXObject(null, new PDResources()));
  }

  /**
   * Test {@link PDXObject#PDXObject(PDStream, COSName)}.
   * <ul>
   *   <li>Then return COSObject Filters is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXObject#PDXObject(PDStream, COSName)}
   */
  @Test
  @DisplayName("Test new PDXObject(PDStream, COSName); then return COSObject Filters is 'null'")
  void testNewPDXObject_thenReturnCOSObjectFiltersIsNull() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act
    PDXObject actualPdxObject = new PDXObject(stream, COSName.A);

    // Assert
    COSStream cOSObject = actualPdxObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(stream, actualPdxObject.getStream());
  }

  /**
   * Test {@link PDXObject#PDXObject(COSStream, COSName)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXObject#PDXObject(COSStream, COSName)}
   */
  @Test
  @DisplayName("Test new PDXObject(COSStream, COSName); when COSStream(); then return Stream DecodeParms is 'null'")
  void testNewPDXObject_whenCOSStream_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDXObject actualPdxObject = new PDXObject(stream, COSName.A);

    // Assert
    PDStream stream2 = actualPdxObject.getStream();
    assertNull(stream2.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream2.getMetadata());
    assertNull(stream2.getFile());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(0, stream2.getLength());
    assertEquals(3, stream.size());
    List<String> fileFilters = stream2.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, actualPdxObject.getCOSObject());
    assertSame(fileFilters, stream2.getFilters());
  }

  /**
   * Test {@link PDXObject#PDXObject(PDDocument, COSName)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXObject#PDXObject(PDDocument, COSName)}
   */
  @Test
  @DisplayName("Test new PDXObject(PDDocument, COSName); when PDDocument(); then return Stream DecodeParms is 'null'")
  void testNewPDXObject_whenPDDocument_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDXObject actualPdxObject = new PDXObject(new PDDocument(), COSName.A);

    // Assert
    PDStream stream = actualPdxObject.getStream();
    assertNull(stream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    COSStream cOSObject = actualPdxObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(stream.getMetadata());
    assertNull(stream.getFile());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(0, stream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = stream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, stream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
  }

  /**
   * Test {@link PDXObject#getCOSObject()}.
   * <p>
   * Method under test: {@link PDXObject#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    COSStream stream = new COSStream();

    // Act and Assert
    assertSame(stream, (new PDXObject(stream, COSName.A)).getCOSObject());
  }

  /**
   * Test {@link PDXObject#getStream()}.
   * <p>
   * Method under test: {@link PDXObject#getStream()}
   */
  @Test
  @DisplayName("Test getStream()")
  void testGetStream() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDStream actualStream = (new PDXObject(stream, COSName.A)).getStream();

    // Assert
    assertNull(actualStream.getDecodeParms());
    assertNull(actualStream.getFileDecodeParams());
    assertNull(actualStream.getMetadata());
    assertNull(actualStream.getFile());
    assertEquals(-1, actualStream.getDecodedStreamLength());
    assertEquals(0, actualStream.getLength());
    assertTrue(actualStream.getFileFilters().isEmpty());
    assertSame(stream, actualStream.getCOSObject());
  }
}
