package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDICCBasedDiffblueTest {
  /**
   * Test {@link PDICCBased#PDICCBased(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDICCBased#PDICCBased(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDICCBased(PDDocument); when PDDocument(); then COSObject return COSArray")
  void testNewPDICCBased_whenPDDocument_thenCOSObjectReturnCOSArray() throws IOException {
    // Arrange and Act
    PDICCBased actualPdiccBased = new PDICCBased(new PDDocument());

    // Assert
    COSBase cOSObject = actualPdiccBased.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("ICCBased", ((COSName) getResult).getName());
    assertEquals("ICCBased", actualPdiccBased.getName());
    PDStream pDStream = actualPdiccBased.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    COSStream cOSObject2 = pDStream.getCOSObject();
    assertNull(cOSObject2.getFilters());
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(actualPdiccBased.getMetadata());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertNull(actualPdiccBased.getInitialColor());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(-1, actualPdiccBased.getNumberOfComponents());
    assertEquals(0, pDStream.getLength());
    assertEquals(0L, cOSObject2.getLength());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
    assertFalse(cOSObject2.hasData());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdiccBased.isSRGB());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(cOSObject2, toListResult.get(1));
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Test {@link PDICCBased#create(COSArray, PDResources)} with {@code iccArray},
   * {@code resources}.
   * <p>
   * Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSArray, PDResources) with 'iccArray', 'resources'")
  void testCreateWithIccArrayResources() throws IOException {
    // Arrange
    COSArray iccArray = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, new PDResources()));
  }

  /**
   * Test {@link PDICCBased#getAlternateColorSpace()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDICCBased#getAlternateColorSpace()}
   */
  @Test
  @DisplayName("Test getAlternateColorSpace(); then throw IOException")
  void testGetAlternateColorSpace_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDICCBased(new PDDocument())).getAlternateColorSpace());
  }
}
