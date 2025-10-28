package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class XrefTrailerResolverDiffblueTest {
  /**
   * Method under test: {@link XrefTrailerResolver#getFirstTrailer()}
   */
  @Test
  void testGetFirstTrailer() {
    // Arrange, Act and Assert
    assertNull((new XrefTrailerResolver()).getFirstTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getFirstTrailer()}
   */
  @Test
  void testGetFirstTrailer2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(1L, XrefTrailerResolver.XRefType.TABLE);

    // Act and Assert
    assertNull(xrefTrailerResolver.getFirstTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getLastTrailer()}
   */
  @Test
  void testGetLastTrailer() {
    // Arrange, Act and Assert
    assertNull((new XrefTrailerResolver()).getLastTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getLastTrailer()}
   */
  @Test
  void testGetLastTrailer2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(1L, XrefTrailerResolver.XRefType.TABLE);

    // Act and Assert
    assertNull(xrefTrailerResolver.getLastTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getTrailerCount()}
   */
  @Test
  void testGetTrailerCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new XrefTrailerResolver()).getTrailerCount());
  }

  /**
   * Method under test:
   * {@link XrefTrailerResolver#nextXrefObj(long, XrefTrailerResolver.XRefType)}
   */
  @Test
  void testNextXrefObj() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();

    // Act
    xrefTrailerResolver.nextXrefObj(1L, XrefTrailerResolver.XRefType.TABLE);

    // Assert
    assertNull(xrefTrailerResolver.getCurrentTrailer());
    assertEquals(1, xrefTrailerResolver.getTrailerCount());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getXrefType()}
   */
  @Test
  void testGetXrefType() {
    // Arrange, Act and Assert
    assertNull((new XrefTrailerResolver()).getXrefType());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getXrefType()}
   */
  @Test
  void testGetXrefType2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act and Assert
    assertEquals(XrefTrailerResolver.XRefType.TABLE, xrefTrailerResolver.getXrefType());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#setTrailer(COSDictionary)}
   */
  @Test
  void testSetTrailer() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();

    // Act
    xrefTrailerResolver.setTrailer(new COSDictionary());

    // Assert
    assertNull(xrefTrailerResolver.getFirstTrailer());
    assertNull(xrefTrailerResolver.getLastTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#setTrailer(COSDictionary)}
   */
  @Test
  void testSetTrailer2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(300L, XrefTrailerResolver.XRefType.TABLE);
    COSDictionary trailer = new COSDictionary();

    // Act
    xrefTrailerResolver.setTrailer(trailer);

    // Assert
    assertSame(trailer, xrefTrailerResolver.getCurrentTrailer());
    assertSame(trailer, xrefTrailerResolver.getFirstTrailer());
    assertSame(trailer, xrefTrailerResolver.getLastTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getCurrentTrailer()}
   */
  @Test
  void testGetCurrentTrailer() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(1L, XrefTrailerResolver.XRefType.TABLE);

    // Act and Assert
    assertNull(xrefTrailerResolver.getCurrentTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#setStartxref(long)}
   */
  @Test
  void testSetStartxref() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();

    // Act
    xrefTrailerResolver.setStartxref(42L);

    // Assert
    COSDictionary trailer = xrefTrailerResolver.getTrailer();
    COSUpdateState updateState = trailer.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(trailer.getKey());
    assertEquals(0, trailer.size());
    assertEquals(XrefTrailerResolver.XRefType.TABLE, xrefTrailerResolver.getXrefType());
    COSIncrement toIncrementResult = trailer.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(trailer.isDirect());
    assertFalse(trailer.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(xrefTrailerResolver.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#setStartxref(long)}
   */
  @Test
  void testSetStartxref2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(300L, XrefTrailerResolver.XRefType.TABLE);

    // Act
    xrefTrailerResolver.setStartxref(42L);

    // Assert
    COSDictionary trailer = xrefTrailerResolver.getTrailer();
    COSUpdateState updateState = trailer.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(trailer.getKey());
    assertEquals(0, trailer.size());
    assertEquals(XrefTrailerResolver.XRefType.TABLE, xrefTrailerResolver.getXrefType());
    COSIncrement toIncrementResult = trailer.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(trailer.isDirect());
    assertFalse(trailer.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(xrefTrailerResolver.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#setStartxref(long)}
   */
  @Test
  void testSetStartxref3() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(300L, XrefTrailerResolver.XRefType.TABLE);

    // Act
    xrefTrailerResolver.setStartxref(300L);

    // Assert
    COSDictionary trailer = xrefTrailerResolver.getTrailer();
    COSUpdateState updateState = trailer.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(trailer.getKey());
    assertEquals(0, trailer.size());
    assertEquals(XrefTrailerResolver.XRefType.TABLE, xrefTrailerResolver.getXrefType());
    COSIncrement toIncrementResult = trailer.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(trailer.isDirect());
    assertFalse(trailer.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(xrefTrailerResolver.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getTrailer()}
   */
  @Test
  void testGetTrailer() {
    // Arrange, Act and Assert
    assertNull((new XrefTrailerResolver()).getTrailer());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getTrailer()}
   */
  @Test
  void testGetTrailer2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act
    COSDictionary actualTrailer = xrefTrailerResolver.getTrailer();

    // Assert
    COSUpdateState updateState = actualTrailer.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualTrailer.getKey());
    assertEquals(0, actualTrailer.size());
    COSIncrement toIncrementResult = actualTrailer.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualTrailer.isDirect());
    assertFalse(actualTrailer.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualTrailer.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getXrefTable()}
   */
  @Test
  void testGetXrefTable() {
    // Arrange, Act and Assert
    assertNull((new XrefTrailerResolver()).getXrefTable());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getXrefTable()}
   */
  @Test
  void testGetXrefTable2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act and Assert
    assertTrue(xrefTrailerResolver.getXrefTable().isEmpty());
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getContainedObjectNumbers(int)}
   */
  @Test
  void testGetContainedObjectNumbers() {
    // Arrange, Act and Assert
    assertNull((new XrefTrailerResolver()).getContainedObjectNumbers(1));
  }

  /**
   * Method under test: {@link XrefTrailerResolver#getContainedObjectNumbers(int)}
   */
  @Test
  void testGetContainedObjectNumbers2() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act and Assert
    assertTrue(xrefTrailerResolver.getContainedObjectNumbers(1).isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link XrefTrailerResolver}
   */
  @Test
  void testNewXrefTrailerResolver() {
    // Arrange and Act
    XrefTrailerResolver actualXrefTrailerResolver = new XrefTrailerResolver();

    // Assert
    assertNull(actualXrefTrailerResolver.getXrefTable());
    assertNull(actualXrefTrailerResolver.getFirstTrailer());
    assertNull(actualXrefTrailerResolver.getLastTrailer());
    assertNull(actualXrefTrailerResolver.getTrailer());
    assertNull(actualXrefTrailerResolver.getXrefType());
    assertEquals(0, actualXrefTrailerResolver.getTrailerCount());
  }
}
