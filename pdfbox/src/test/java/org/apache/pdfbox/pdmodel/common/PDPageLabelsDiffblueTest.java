package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Map;
import java.util.NavigableSet;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class PDPageLabelsDiffblueTest {
  /**
   * Method under test: {@link PDPageLabels#getPageRangeCount()}
   */
  @Test
  void testGetPageRangeCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDPageLabels(new PDDocument())).getPageRangeCount());
  }

  /**
   * Method under test: {@link PDPageLabels#getPageRangeCount()}
   */
  @Test
  void testGetPageRangeCount2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualPageRangeCount = (new PDPageLabels(new PDDocument(streamCacheCreateFunction))).getPageRangeCount();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPageRangeCount);
  }

  /**
   * Method under test: {@link PDPageLabels#getPageLabelRange(int)}
   */
  @Test
  void testGetPageLabelRange() {
    // Arrange, Act and Assert
    assertNull((new PDPageLabels(new PDDocument())).getPageLabelRange(1));
  }

  /**
   * Method under test: {@link PDPageLabels#getPageLabelRange(int)}
   */
  @Test
  void testGetPageLabelRange2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDPageLabelRange actualPageLabelRange = (new PDPageLabels(new PDDocument(streamCacheCreateFunction)))
        .getPageLabelRange(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPageLabelRange);
  }

  /**
   * Method under test: {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}
   */
  @Test
  void testSetLabelItem() {
    // Arrange
    PDPageLabels pdPageLabels = new PDPageLabels(new PDDocument());

    // Act
    pdPageLabels.setLabelItem(1, new PDPageLabelRange());

    // Assert
    Map<String, Integer> pageIndicesByLabels = pdPageLabels.getPageIndicesByLabels();
    assertEquals(1, pageIndicesByLabels.size());
    assertEquals(0, pageIndicesByLabels.get("1").intValue());
    NavigableSet<Integer> pageIndices = pdPageLabels.getPageIndices();
    assertEquals(2, pageIndices.size());
    assertEquals(2, pdPageLabels.getPageRangeCount());
    assertTrue(pageIndices.contains(1));
  }

  /**
   * Method under test: {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}
   */
  @Test
  void testSetLabelItem2() {
    // Arrange
    PDPageLabels pdPageLabels = new PDPageLabels(new PDDocument());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageLabels.setLabelItem(-1, new PDPageLabelRange()));
  }

  /**
   * Method under test: {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}
   */
  @Test
  void testSetLabelItem3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDPageLabels pdPageLabels = new PDPageLabels(new PDDocument(streamCacheCreateFunction));

    // Act
    pdPageLabels.setLabelItem(1, new PDPageLabelRange());

    // Assert
    verify(streamCacheCreateFunction).create();
    Map<String, Integer> pageIndicesByLabels = pdPageLabels.getPageIndicesByLabels();
    assertEquals(1, pageIndicesByLabels.size());
    assertEquals(0, pageIndicesByLabels.get("1").intValue());
    NavigableSet<Integer> pageIndices = pdPageLabels.getPageIndices();
    assertEquals(2, pageIndices.size());
    assertEquals(2, pdPageLabels.getPageRangeCount());
    assertTrue(pageIndices.contains(1));
  }

  /**
   * Method under test: {@link PDPageLabels#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDPageLabels(new PDDocument())).getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualCOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, ((COSDictionary) actualCOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) actualCOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) actualCOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(((COSDictionary) actualCOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabels#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCOSObject = (new PDPageLabels(new PDDocument(streamCacheCreateFunction))).getCOSObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualCOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, ((COSDictionary) actualCOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) actualCOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) actualCOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(((COSDictionary) actualCOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabels#getPageIndicesByLabels()}
   */
  @Test
  void testGetPageIndicesByLabels() {
    // Arrange, Act and Assert
    assertTrue((new PDPageLabels(new PDDocument())).getPageIndicesByLabels().isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabels#getPageIndicesByLabels()}
   */
  @Test
  void testGetPageIndicesByLabels2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Map<String, Integer> actualPageIndicesByLabels = (new PDPageLabels(new PDDocument(streamCacheCreateFunction)))
        .getPageIndicesByLabels();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPageIndicesByLabels.isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabels#getPageIndicesByLabels()}
   */
  @Test
  void testGetPageIndicesByLabels3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    Map<String, Integer> actualPageIndicesByLabels = (new PDPageLabels(document)).getPageIndicesByLabels();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPageIndicesByLabels.size());
    assertEquals(0, actualPageIndicesByLabels.get("1").intValue());
  }

  /**
   * Method under test: {@link PDPageLabels#getLabelsByPageIndices()}
   */
  @Test
  void testGetLabelsByPageIndices() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPageLabels(new PDDocument())).getLabelsByPageIndices().length);
  }

  /**
   * Method under test: {@link PDPageLabels#getLabelsByPageIndices()}
   */
  @Test
  void testGetLabelsByPageIndices2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String[] actualLabelsByPageIndices = (new PDPageLabels(new PDDocument(streamCacheCreateFunction)))
        .getLabelsByPageIndices();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualLabelsByPageIndices.length);
  }

  /**
   * Method under test: {@link PDPageLabels#getLabelsByPageIndices()}
   */
  @Test
  void testGetLabelsByPageIndices3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    String[] actualLabelsByPageIndices = (new PDPageLabels(document)).getLabelsByPageIndices();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertArrayEquals(new String[]{"1"}, actualLabelsByPageIndices);
  }

  /**
   * Method under test: {@link PDPageLabels#getPageIndices()}
   */
  @Test
  void testGetPageIndices() {
    // Arrange and Act
    NavigableSet<Integer> actualPageIndices = (new PDPageLabels(new PDDocument())).getPageIndices();

    // Assert
    assertEquals(1, actualPageIndices.size());
    assertTrue(actualPageIndices.contains(0));
  }

  /**
   * Method under test: {@link PDPageLabels#getPageIndices()}
   */
  @Test
  void testGetPageIndices2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    NavigableSet<Integer> actualPageIndices = (new PDPageLabels(new PDDocument(streamCacheCreateFunction)))
        .getPageIndices();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPageIndices.size());
    assertTrue(actualPageIndices.contains(0));
  }

  /**
   * Method under test: {@link PDPageLabels#PDPageLabels(PDDocument)}
   */
  @Test
  void testNewPDPageLabels() {
    // Arrange and Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(new PDDocument());

    // Assert
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabels#PDPageLabels(PDDocument)}
   */
  @Test
  void testNewPDPageLabels2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}
   */
  @Test
  void testNewPDPageLabels3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(document, new COSDictionary());

    // Assert
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}
   */
  @Test
  void testNewPDPageLabels4() throws IOException {
    // Arrange and Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(new PDDocument(), null);

    // Assert
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}
   */
  @Test
  void testNewPDPageLabels5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(document, new COSDictionary());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
