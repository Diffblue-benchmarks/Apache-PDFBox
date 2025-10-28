package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDICCBasedDiffblueTest {
  /**
   * Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange
    COSArray iccArray = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, new PDResources()));
  }

  /**
   * Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  void testCreate2() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray iccArray = new COSArray();
    iccArray.add(COSBoolean.FALSE);
    iccArray.add(object);

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, new PDResources()));
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link PDICCBased#PDICCBased(PDDocument)}
   */
  @Test
  void testNewPDICCBased() throws IOException {
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
   * Method under test: {@link PDICCBased#PDICCBased(PDDocument)}
   */
  @Test
  void testNewPDICCBased2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDICCBased actualPdiccBased = new PDICCBased(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
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
}
