package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDFCloneUtilityDiffblueTest {
  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument()))
        .cloneForNewDocument(COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualCloneForNewDocumentResult).FALSE, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument(streamCacheCreateFunction)))
        .cloneForNewDocument(COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((COSBoolean) actualCloneForNewDocumentResult).FALSE, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument(streamCacheCreateFunction)))
        .cloneForNewDocument(COSBoolean.TRUE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((COSBoolean) actualCloneForNewDocumentResult).TRUE, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument(streamCacheCreateFunction)))
        .cloneForNewDocument(COSFloat.ONE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((COSFloat) actualCloneForNewDocumentResult).ONE, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument(streamCacheCreateFunction)))
        .cloneForNewDocument(COSInteger.ONE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((COSInteger) actualCloneForNewDocumentResult).ONE, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument(streamCacheCreateFunction)))
        .cloneForNewDocument(COSName.A);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((COSName) actualCloneForNewDocumentResult).A, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument(streamCacheCreateFunction));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(new COSArray());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCloneForNewDocumentResult instanceof COSArray);
    assertTrue(((COSArray) actualCloneForNewDocumentResult).toList().isEmpty());
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument(streamCacheCreateFunction));
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosObject);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBoolean cosBoolean = ((COSBoolean) actualCloneForNewDocumentResult).FALSE;
    assertSame(cosBoolean, cosObject.getObject());
    assertSame(cosBoolean, actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument(streamCacheCreateFunction)))
        .cloneForNewDocument(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCloneForNewDocumentResult);
  }

  /**
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  void testCloneForNewDocument10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument(streamCacheCreateFunction));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(new COSDictionary());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCloneForNewDocumentResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualCloneForNewDocumentResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCloneForNewDocumentResult.getKey());
    assertEquals(0, ((COSDictionary) actualCloneForNewDocumentResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) actualCloneForNewDocumentResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCloneForNewDocumentResult.isDirect());
    assertFalse(((COSDictionary) actualCloneForNewDocumentResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSDictionary) actualCloneForNewDocumentResult).getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  void testCloneMerge() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  void testCloneMerge2() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSArray());
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  void testCloneMerge3() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  void testCloneMerge4() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSDictionary());
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  void testCloneMerge5() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFCloneUtility#PDFCloneUtility(PDDocument)}
   *   <li>{@link PDFCloneUtility#getDestination()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDDocument dest = new PDDocument();

    // Act and Assert
    assertSame(dest, (new PDFCloneUtility(dest)).getDestination());
  }
}
