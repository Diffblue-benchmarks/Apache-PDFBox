package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdfparser.XrefTrailerResolver.XRefType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XrefTrailerResolverDiffblueTest {
  /**
   * Test {@link XrefTrailerResolver#getFirstTrailer()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getFirstTrailer()}
   */
  @Test
  @DisplayName("Test getFirstTrailer(); given XrefTrailerResolver (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getFirstTrailer()"})
  void testGetFirstTrailer_givenXrefTrailerResolver() {
    // Arrange, Act and Assert
    assertNull(new XrefTrailerResolver().getFirstTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#getFirstTrailer()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor) nextXrefObj one and {@code
   *       TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getFirstTrailer()}
   */
  @Test
  @DisplayName(
      "Test getFirstTrailer(); given XrefTrailerResolver (default constructor) nextXrefObj one and 'TABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getFirstTrailer()"})
  void testGetFirstTrailer_givenXrefTrailerResolverNextXrefObjOneAndTable() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(1L, XRefType.TABLE);

    // Act and Assert
    assertNull(xrefTrailerResolver.getFirstTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#getLastTrailer()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getLastTrailer()}
   */
  @Test
  @DisplayName("Test getLastTrailer(); given XrefTrailerResolver (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getLastTrailer()"})
  void testGetLastTrailer_givenXrefTrailerResolver() {
    // Arrange, Act and Assert
    assertNull(new XrefTrailerResolver().getLastTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#getLastTrailer()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor) nextXrefObj one and {@code
   *       TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getLastTrailer()}
   */
  @Test
  @DisplayName(
      "Test getLastTrailer(); given XrefTrailerResolver (default constructor) nextXrefObj one and 'TABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getLastTrailer()"})
  void testGetLastTrailer_givenXrefTrailerResolverNextXrefObjOneAndTable() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(1L, XRefType.TABLE);

    // Act and Assert
    assertNull(xrefTrailerResolver.getLastTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#getTrailerCount()}.
   *
   * <p>Method under test: {@link XrefTrailerResolver#getTrailerCount()}
   */
  @Test
  @DisplayName("Test getTrailerCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int XrefTrailerResolver.getTrailerCount()"})
  void testGetTrailerCount() {
    // Arrange, Act and Assert
    assertEquals(0, new XrefTrailerResolver().getTrailerCount());
  }

  /**
   * Test {@link XrefTrailerResolver#nextXrefObj(long, XRefType)}.
   *
   * <p>Method under test: {@link XrefTrailerResolver#nextXrefObj(long, XRefType)}
   */
  @Test
  @DisplayName("Test nextXrefObj(long, XRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.nextXrefObj(long, XRefType)"})
  void testNextXrefObj() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();

    // Act
    xrefTrailerResolver.nextXrefObj(1L, XRefType.TABLE);

    // Assert
    assertNull(xrefTrailerResolver.getCurrentTrailer());
    assertEquals(1, xrefTrailerResolver.getTrailerCount());
  }

  /**
   * Test {@link XrefTrailerResolver#getXrefType()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor) Startxref is one.
   *   <li>Then return {@code TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getXrefType()}
   */
  @Test
  @DisplayName(
      "Test getXrefType(); given XrefTrailerResolver (default constructor) Startxref is one; then return 'TABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XRefType XrefTrailerResolver.getXrefType()"})
  void testGetXrefType_givenXrefTrailerResolverStartxrefIsOne_thenReturnTable() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act and Assert
    assertEquals(XRefType.TABLE, xrefTrailerResolver.getXrefType());
  }

  /**
   * Test {@link XrefTrailerResolver#getXrefType()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getXrefType()}
   */
  @Test
  @DisplayName(
      "Test getXrefType(); given XrefTrailerResolver (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XRefType XrefTrailerResolver.getXrefType()"})
  void testGetXrefType_givenXrefTrailerResolver_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XrefTrailerResolver().getXrefType());
  }

  /**
   * Test {@link XrefTrailerResolver#setTrailer(COSDictionary)}.
   *
   * <ul>
   *   <li>Then {@link XrefTrailerResolver} (default constructor) CurrentTrailer is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test setTrailer(COSDictionary); then XrefTrailerResolver (default constructor) CurrentTrailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.setTrailer(COSDictionary)"})
  void testSetTrailer_thenXrefTrailerResolverCurrentTrailerIsCOSDictionary() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(300L, XRefType.TABLE);
    COSDictionary trailer = new COSDictionary();

    // Act
    xrefTrailerResolver.setTrailer(trailer);

    // Assert
    assertSame(trailer, xrefTrailerResolver.getCurrentTrailer());
    assertSame(trailer, xrefTrailerResolver.getFirstTrailer());
    assertSame(trailer, xrefTrailerResolver.getLastTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#setTrailer(COSDictionary)}.
   *
   * <ul>
   *   <li>Then {@link XrefTrailerResolver} (default constructor) FirstTrailer is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test setTrailer(COSDictionary); then XrefTrailerResolver (default constructor) FirstTrailer is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.setTrailer(COSDictionary)"})
  void testSetTrailer_thenXrefTrailerResolverFirstTrailerIsNull() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();

    // Act
    xrefTrailerResolver.setTrailer(new COSDictionary());

    // Assert that nothing has changed
    assertNull(xrefTrailerResolver.getFirstTrailer());
    assertNull(xrefTrailerResolver.getLastTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#getCurrentTrailer()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getCurrentTrailer()}
   */
  @Test
  @DisplayName("Test getCurrentTrailer(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getCurrentTrailer()"})
  void testGetCurrentTrailer_thenReturnNull() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(1L, XRefType.TABLE);

    // Act and Assert
    assertNull(xrefTrailerResolver.getCurrentTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#setStartxref(long)}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor) nextXrefObj three hundred and
   *       {@code TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#setStartxref(long)}
   */
  @Test
  @DisplayName(
      "Test setStartxref(long); given XrefTrailerResolver (default constructor) nextXrefObj three hundred and 'TABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.setStartxref(long)"})
  void testSetStartxref_givenXrefTrailerResolverNextXrefObjThreeHundredAndTable() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(300L, XRefType.TABLE);

    // Act
    xrefTrailerResolver.setStartxref(42L);

    // Assert
    COSDictionary trailer = xrefTrailerResolver.getTrailer();
    COSUpdateState updateState = trailer.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(trailer.getKey());
    assertEquals(0, trailer.size());
    assertEquals(XRefType.TABLE, xrefTrailerResolver.getXrefType());
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
   * Test {@link XrefTrailerResolver#setStartxref(long)}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#setStartxref(long)}
   */
  @Test
  @DisplayName(
      "Test setStartxref(long); given XrefTrailerResolver (default constructor); when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.setStartxref(long)"})
  void testSetStartxref_givenXrefTrailerResolver_whenFortyTwo() {
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
    assertEquals(XRefType.TABLE, xrefTrailerResolver.getXrefType());
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
   * Test {@link XrefTrailerResolver#setStartxref(long)}.
   *
   * <ul>
   *   <li>When three hundred.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#setStartxref(long)}
   */
  @Test
  @DisplayName("Test setStartxref(long); when three hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.setStartxref(long)"})
  void testSetStartxref_whenThreeHundred() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.nextXrefObj(300L, XRefType.TABLE);

    // Act
    xrefTrailerResolver.setStartxref(300L);

    // Assert
    COSDictionary trailer = xrefTrailerResolver.getTrailer();
    COSUpdateState updateState = trailer.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(trailer.getKey());
    assertEquals(0, trailer.size());
    assertEquals(XRefType.TABLE, xrefTrailerResolver.getXrefType());
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
   * Test {@link XrefTrailerResolver#getTrailer()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getTrailer()}
   */
  @Test
  @DisplayName(
      "Test getTrailer(); given XrefTrailerResolver (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getTrailer()"})
  void testGetTrailer_givenXrefTrailerResolver_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XrefTrailerResolver().getTrailer());
  }

  /**
   * Test {@link XrefTrailerResolver#getTrailer()}.
   *
   * <ul>
   *   <li>Then return UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getTrailer()}
   */
  @Test
  @DisplayName("Test getTrailer(); then return UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefTrailerResolver.getTrailer()"})
  void testGetTrailer_thenReturnUpdateStateOriginDocumentStateIsNull() {
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
   * Test {@link XrefTrailerResolver#getXrefTable()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor) Startxref is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getXrefTable()}
   */
  @Test
  @DisplayName(
      "Test getXrefTable(); given XrefTrailerResolver (default constructor) Startxref is one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map XrefTrailerResolver.getXrefTable()"})
  void testGetXrefTable_givenXrefTrailerResolverStartxrefIsOne_thenReturnEmpty() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act and Assert
    assertTrue(xrefTrailerResolver.getXrefTable().isEmpty());
  }

  /**
   * Test {@link XrefTrailerResolver#getXrefTable()}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getXrefTable()}
   */
  @Test
  @DisplayName(
      "Test getXrefTable(); given XrefTrailerResolver (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map XrefTrailerResolver.getXrefTable()"})
  void testGetXrefTable_givenXrefTrailerResolver_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XrefTrailerResolver().getXrefTable());
  }

  /**
   * Test {@link XrefTrailerResolver#getContainedObjectNumbers(int)}.
   *
   * <ul>
   *   <li>Given {@link XrefTrailerResolver} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getContainedObjectNumbers(int)}
   */
  @Test
  @DisplayName(
      "Test getContainedObjectNumbers(int); given XrefTrailerResolver (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set XrefTrailerResolver.getContainedObjectNumbers(int)"})
  void testGetContainedObjectNumbers_givenXrefTrailerResolver_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XrefTrailerResolver().getContainedObjectNumbers(1));
  }

  /**
   * Test {@link XrefTrailerResolver#getContainedObjectNumbers(int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link XrefTrailerResolver#getContainedObjectNumbers(int)}
   */
  @Test
  @DisplayName("Test getContainedObjectNumbers(int); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set XrefTrailerResolver.getContainedObjectNumbers(int)"})
  void testGetContainedObjectNumbers_thenReturnEmpty() {
    // Arrange
    XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();
    xrefTrailerResolver.setStartxref(1L);

    // Act and Assert
    assertTrue(xrefTrailerResolver.getContainedObjectNumbers(1).isEmpty());
  }

  /**
   * Test new {@link XrefTrailerResolver} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link XrefTrailerResolver}
   */
  @Test
  @DisplayName("Test new XrefTrailerResolver (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefTrailerResolver.<init>()"})
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
