package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTableAttributeObjectDiffblueTest {
  /**
   * Test {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)}.
   *
   * <p>Method under test: {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTableAttributeObject(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.<init>(COSDictionary)"})
  void testNewPDTableAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDTableAttributeObject(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *
   * <p>Method under test: {@link PDTableAttributeObject#PDTableAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDTableAttributeObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.<init>()"})
  void testNewPDTableAttributeObject2() {
    // Arrange and Act
    PDTableAttributeObject actualPdTableAttributeObject = new PDTableAttributeObject();

    // Assert
    assertNull(actualPdTableAttributeObject.getScope());
    assertNull(actualPdTableAttributeObject.getSummary());
    assertNull(actualPdTableAttributeObject.getHeaders());
    COSDictionary cOSObject = actualPdTableAttributeObject.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, actualPdTableAttributeObject.getColSpan());
    assertEquals(1, actualPdTableAttributeObject.getRowSpan());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(actualPdTableAttributeObject.isEmpty());
    assertEquals(PDTableAttributeObject.OWNER_TABLE, actualPdTableAttributeObject.getOwner());
  }

  /**
   * Test {@link PDTableAttributeObject#getRowSpan()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getRowSpan()}
   */
  @Test
  @DisplayName(
      "Test getRowSpan(); given PDTableAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTableAttributeObject.getRowSpan()"})
  void testGetRowSpan_givenPDTableAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(1, new PDTableAttributeObject(new COSDictionary()).getRowSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#getRowSpan()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getRowSpan()}
   */
  @Test
  @DisplayName("Test getRowSpan(); given PDTableAttributeObject(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTableAttributeObject.getRowSpan()"})
  void testGetRowSpan_givenPDTableAttributeObject_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new PDTableAttributeObject().getRowSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#setRowSpan(int)}.
   *
   * <p>Method under test: {@link PDTableAttributeObject#setRowSpan(int)}
   */
  @Test
  @DisplayName("Test setRowSpan(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setRowSpan(int)"})
  void testSetRowSpan() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject(new COSDictionary());

    // Act
    pdTableAttributeObject.setRowSpan(1);

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdTableAttributeObject.getRowSpan());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setRowSpan(int)}.
   *
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} RowSpan is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setRowSpan(int)}
   */
  @Test
  @DisplayName("Test setRowSpan(int); then PDTableAttributeObject() RowSpan is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setRowSpan(int)"})
  void testSetRowSpan_thenPDTableAttributeObjectRowSpanIsOne() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setRowSpan(1);

    // Assert
    assertEquals(1, pdTableAttributeObject.getRowSpan());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setRowSpan(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} RowSpan is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setRowSpan(int)}
   */
  @Test
  @DisplayName(
      "Test setRowSpan(int); when MIN_VALUE; then PDTableAttributeObject() RowSpan is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setRowSpan(int)"})
  void testSetRowSpan_whenMin_value_thenPDTableAttributeObjectRowSpanIsMin_value() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setRowSpan(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
    assertEquals(Integer.MIN_VALUE, pdTableAttributeObject.getRowSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#getColSpan()}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} addAll {@link COSDictionary#COSDictionary()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getColSpan()}
   */
  @Test
  @DisplayName("Test getColSpan(); given COSStream() addAll COSDictionary(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTableAttributeObject.getColSpan()"})
  void testGetColSpan_givenCOSStreamAddAllCOSDictionary_thenReturnOne() {
    // Arrange
    COSStream dictionary = new COSStream();
    dictionary.addAll(new COSDictionary());

    // Act and Assert
    assertEquals(1, new PDTableAttributeObject(dictionary).getColSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#getColSpan()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getColSpan()}
   */
  @Test
  @DisplayName(
      "Test getColSpan(); given PDTableAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTableAttributeObject.getColSpan()"})
  void testGetColSpan_givenPDTableAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(1, new PDTableAttributeObject(new COSDictionary()).getColSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#getColSpan()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getColSpan()}
   */
  @Test
  @DisplayName("Test getColSpan(); given PDTableAttributeObject(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTableAttributeObject.getColSpan()"})
  void testGetColSpan_givenPDTableAttributeObject_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new PDTableAttributeObject().getColSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#setColSpan(int)}.
   *
   * <p>Method under test: {@link PDTableAttributeObject#setColSpan(int)}
   */
  @Test
  @DisplayName("Test setColSpan(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setColSpan(int)"})
  void testSetColSpan() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject(new COSDictionary());

    // Act
    pdTableAttributeObject.setColSpan(1);

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdTableAttributeObject.getColSpan());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setColSpan(int)}.
   *
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} ColSpan is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setColSpan(int)}
   */
  @Test
  @DisplayName("Test setColSpan(int); then PDTableAttributeObject() ColSpan is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setColSpan(int)"})
  void testSetColSpan_thenPDTableAttributeObjectColSpanIsOne() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setColSpan(1);

    // Assert
    assertEquals(1, pdTableAttributeObject.getColSpan());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setColSpan(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} ColSpan is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setColSpan(int)}
   */
  @Test
  @DisplayName(
      "Test setColSpan(int); when MIN_VALUE; then PDTableAttributeObject() ColSpan is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setColSpan(int)"})
  void testSetColSpan_whenMin_value_thenPDTableAttributeObjectColSpanIsMin_value() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setColSpan(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
    assertEquals(Integer.MIN_VALUE, pdTableAttributeObject.getColSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#getHeaders()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getHeaders()}
   */
  @Test
  @DisplayName(
      "Test getHeaders(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDTableAttributeObject.getHeaders()"})
  void testGetHeaders_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act and Assert
    assertNull(new PDTableAttributeObject(dictionary).getHeaders());
  }

  /**
   * Test {@link PDTableAttributeObject#getHeaders()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getHeaders()}
   */
  @Test
  @DisplayName(
      "Test getHeaders(); given PDTableAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDTableAttributeObject.getHeaders()"})
  void testGetHeaders_givenPDTableAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDTableAttributeObject(new COSDictionary()).getHeaders());
  }

  /**
   * Test {@link PDTableAttributeObject#getHeaders()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getHeaders()}
   */
  @Test
  @DisplayName("Test getHeaders(); given PDTableAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDTableAttributeObject.getHeaders()"})
  void testGetHeaders_givenPDTableAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTableAttributeObject().getHeaders());
  }

  /**
   * Test {@link PDTableAttributeObject#setHeaders(String[])}.
   *
   * <p>Method under test: {@link PDTableAttributeObject#setHeaders(String[])}
   */
  @Test
  @DisplayName("Test setHeaders(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setHeaders(String[])"})
  void testSetHeaders() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject(new COSDictionary());

    // Act
    pdTableAttributeObject.setHeaders(new String[] {"Headers"});

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setHeaders(String[])}.
   *
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setHeaders(String[])}
   */
  @Test
  @DisplayName(
      "Test setHeaders(String[]); then PDTableAttributeObject() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setHeaders(String[])"})
  void testSetHeaders_thenPDTableAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setHeaders(new String[] {"Headers"});

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#getScope()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getScope()}
   */
  @Test
  @DisplayName(
      "Test getScope(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.getScope()"})
  void testGetScope_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act and Assert
    assertNull(new PDTableAttributeObject(dictionary).getScope());
  }

  /**
   * Test {@link PDTableAttributeObject#getScope()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getScope()}
   */
  @Test
  @DisplayName(
      "Test getScope(); given PDTableAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.getScope()"})
  void testGetScope_givenPDTableAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDTableAttributeObject(new COSDictionary()).getScope());
  }

  /**
   * Test {@link PDTableAttributeObject#getScope()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getScope()}
   */
  @Test
  @DisplayName("Test getScope(); given PDTableAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.getScope()"})
  void testGetScope_givenPDTableAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTableAttributeObject().getScope());
  }

  /**
   * Test {@link PDTableAttributeObject#setScope(String)}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} Scope is {@code Scope}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setScope(String)}
   */
  @Test
  @DisplayName(
      "Test setScope(String); given PDTableAttributeObject(); then PDTableAttributeObject() Scope is 'Scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setScope(String)"})
  void testSetScope_givenPDTableAttributeObject_thenPDTableAttributeObjectScopeIsScope() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setScope("Scope");

    // Assert
    assertEquals("Scope", pdTableAttributeObject.getScope());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setScope(String)}.
   *
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)} with dictionary
   *       is {@link COSDictionary#COSDictionary()} Scope is {@code Scope}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setScope(String)}
   */
  @Test
  @DisplayName(
      "Test setScope(String); then PDTableAttributeObject(COSDictionary) with dictionary is COSDictionary() Scope is 'Scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setScope(String)"})
  void testSetScope_thenPDTableAttributeObjectWithDictionaryIsCOSDictionaryScopeIsScope() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject(new COSDictionary());

    // Act
    pdTableAttributeObject.setScope("Scope");

    // Assert
    assertEquals("Scope", pdTableAttributeObject.getScope());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setScope(String)}.
   *
   * <ul>
   *   <li>When {@code ScopeScope}.
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} Scope is {@code ScopeScope}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setScope(String)}
   */
  @Test
  @DisplayName(
      "Test setScope(String); when 'ScopeScope'; then PDTableAttributeObject() Scope is 'ScopeScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setScope(String)"})
  void testSetScope_whenScopeScope_thenPDTableAttributeObjectScopeIsScopeScope() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setScope("ScopeScope");

    // Assert
    assertEquals("ScopeScope", pdTableAttributeObject.getScope());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#getSummary()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getSummary()}
   */
  @Test
  @DisplayName(
      "Test getSummary(); given PDTableAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.getSummary()"})
  void testGetSummary_givenPDTableAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDTableAttributeObject(new COSDictionary()).getSummary());
  }

  /**
   * Test {@link PDTableAttributeObject#getSummary()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#getSummary()}
   */
  @Test
  @DisplayName("Test getSummary(); given PDTableAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.getSummary()"})
  void testGetSummary_givenPDTableAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTableAttributeObject().getSummary());
  }

  /**
   * Test {@link PDTableAttributeObject#setSummary(String)}.
   *
   * <p>Method under test: {@link PDTableAttributeObject#setSummary(String)}
   */
  @Test
  @DisplayName("Test setSummary(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setSummary(String)"})
  void testSetSummary() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject(new COSDictionary());

    // Act
    pdTableAttributeObject.setSummary("Summary");

    // Assert
    assertEquals("Summary", pdTableAttributeObject.getSummary());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#setSummary(String)}.
   *
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} Summary is {@code Summary}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#setSummary(String)}
   */
  @Test
  @DisplayName("Test setSummary(String); then PDTableAttributeObject() Summary is 'Summary'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTableAttributeObject.setSummary(String)"})
  void testSetSummary_thenPDTableAttributeObjectSummaryIsSummary() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setSummary("Summary");

    // Assert
    assertEquals("Summary", pdTableAttributeObject.getSummary());
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.
   *   <li>Then return {@code O=Table}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDTableAttributeObject(); then return 'O=Table'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.toString()"})
  void testToString_givenPDTableAttributeObject_thenReturnOTable() {
    // Arrange, Act and Assert
    assertEquals("O=Table", new PDTableAttributeObject().toString());
  }

  /**
   * Test {@link PDTableAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Then return {@code O=null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTableAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTableAttributeObject.toString()"})
  void testToString_thenReturnONull() {
    // Arrange, Act and Assert
    assertEquals("O=null", new PDTableAttributeObject(new COSDictionary()).toString());
  }
}
