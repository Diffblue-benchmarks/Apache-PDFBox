package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.cos.ICOSParser;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDActionHideDiffblueTest {
  /**
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  void testGetT() {
    // Arrange, Act and Assert
    assertNull((new PDActionHide()).getT());
  }

  /**
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  void testGetT2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument t = new COSDocument(streamCacheCreateFunction);

    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(t);

    // Act
    COSBase actualT = pdActionHide.getT();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(t, actualT);
  }

  /**
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  void testGetT3() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualT = pdActionHide.getT();

    // Assert
    assertSame(((COSBoolean) actualT).FALSE, actualT);
  }

  /**
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  void testGetT4() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(new COSObject((COSBase) null, (ICOSParser) null));

    // Act and Assert
    assertNull(pdActionHide.getT());
  }

  /**
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  void testGetT5() throws IOException {
    // Arrange
    COSObject t = new COSObject((COSBase) null,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    t.setKey(new COSObjectKey(1L, 1));

    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(t);

    // Act and Assert
    assertNull(pdActionHide.getT());
  }

  /**
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  void testSetT() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSBoolean t = COSBoolean.FALSE;

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedT = t.FALSE;
    assertSame(expectedT, pdActionHide.getT());
  }

  /**
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  void testSetT2() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSDictionary t = new COSDictionary();

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(t, pdActionHide.getT());
  }

  /**
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  void testSetT3() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSArray t = new COSArray();

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(t, pdActionHide.getT());
  }

  /**
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  void testSetT4() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setT(null);

    // Assert
    assertNull(pdActionHide.getT());
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  void testSetT5() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setT(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  void testSetT6() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray t = new COSArray();
    t.add(object);

    // Act
    pdActionHide.setT(t);

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(t, pdActionHide.getT());
  }

  /**
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  void testGetH() {
    // Arrange, Act and Assert
    assertTrue((new PDActionHide()).getH());
  }

  /**
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  void testGetH2() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setH(true);

    // Act and Assert
    assertTrue(pdActionHide.getH());
  }

  /**
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  void testGetH3() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setH(false);

    // Act and Assert
    assertFalse(pdActionHide.getH());
  }

  /**
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  void testGetH4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument t = new COSDocument(streamCacheCreateFunction);

    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(t);

    // Act
    boolean actualH = pdActionHide.getH();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualH);
  }

  /**
   * Method under test: {@link PDActionHide#setH(boolean)}
   */
  @Test
  void testSetH() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setH(true);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionHide.getH());
  }

  /**
   * Method under test: {@link PDActionHide#setH(boolean)}
   */
  @Test
  void testSetH2() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setH(false);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionHide.getH());
  }

  /**
   * Method under test: {@link PDActionHide#setH(boolean)}
   */
  @Test
  void testSetH3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument t = new COSDocument(streamCacheCreateFunction);

    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(t);

    // Act
    pdActionHide.setH(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdActionHide.getH());
  }

  /**
   * Method under test: {@link PDActionHide#PDActionHide(COSDictionary)}
   */
  @Test
  void testNewPDActionHide() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionHide(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionHide#PDActionHide()}
   */
  @Test
  void testNewPDActionHide2() {
    // Arrange and Act
    PDActionHide actualPdActionHide = new PDActionHide();

    // Assert
    assertNull(actualPdActionHide.getNext());
    assertNull(actualPdActionHide.getT());
    COSDictionary cOSObject = actualPdActionHide.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdActionHide.getH());
    assertEquals(PDAction.TYPE, actualPdActionHide.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualPdActionHide.getSubType());
  }
}
