package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDTableAttributeObjectDiffblueTest {
  /**
   * Test {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTableAttributeObject(COSDictionary)")
  void testNewPDTableAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDTableAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDTableAttributeObject#PDTableAttributeObject()}.
   * <p>
   * Method under test: {@link PDTableAttributeObject#PDTableAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDTableAttributeObject()")
  void testNewPDTableAttributeObject2() {
    // Arrange and Act
    PDTableAttributeObject actualPdTableAttributeObject = new PDTableAttributeObject();

    // Assert
    assertNull(actualPdTableAttributeObject.getHeaders());
    assertNull(actualPdTableAttributeObject.getScope());
    assertNull(actualPdTableAttributeObject.getSummary());
    COSDictionary cOSObject = actualPdTableAttributeObject.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, actualPdTableAttributeObject.getColSpan());
    assertEquals(1, actualPdTableAttributeObject.getRowSpan());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdTableAttributeObject.isEmpty());
    assertEquals(PDTableAttributeObject.OWNER_TABLE, actualPdTableAttributeObject.getOwner());
  }

  /**
   * Test {@link PDTableAttributeObject#getRowSpan()}.
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#getRowSpan()}
   */
  @Test
  @DisplayName("Test getRowSpan(); given PDTableAttributeObject(); then return one")
  void testGetRowSpan_givenPDTableAttributeObject_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDTableAttributeObject()).getRowSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#setRowSpan(int)}.
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#setRowSpan(int)}
   */
  @Test
  @DisplayName("Test setRowSpan(int); then PDTableAttributeObject() COSObject Values size is two")
  void testSetRowSpan_thenPDTableAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setRowSpan(1);

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#getColSpan()}.
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#getColSpan()}
   */
  @Test
  @DisplayName("Test getColSpan(); given PDTableAttributeObject(); then return one")
  void testGetColSpan_givenPDTableAttributeObject_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDTableAttributeObject()).getColSpan());
  }

  /**
   * Test {@link PDTableAttributeObject#setColSpan(int)}.
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#setColSpan(int)}
   */
  @Test
  @DisplayName("Test setColSpan(int); then PDTableAttributeObject() COSObject Values size is two")
  void testSetColSpan_thenPDTableAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setColSpan(1);

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#getHeaders()}.
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#getHeaders()}
   */
  @Test
  @DisplayName("Test getHeaders(); given PDTableAttributeObject(); then return 'null'")
  void testGetHeaders_givenPDTableAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTableAttributeObject()).getHeaders());
  }

  /**
   * Test {@link PDTableAttributeObject#setHeaders(String[])}.
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#setHeaders(String[])}
   */
  @Test
  @DisplayName("Test setHeaders(String[]); then PDTableAttributeObject() COSObject Values size is two")
  void testSetHeaders_thenPDTableAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDTableAttributeObject pdTableAttributeObject = new PDTableAttributeObject();

    // Act
    pdTableAttributeObject.setHeaders(new String[]{"Headers"});

    // Assert
    COSDictionary cOSObject = pdTableAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdTableAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDTableAttributeObject#getScope()}.
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#getScope()}
   */
  @Test
  @DisplayName("Test getScope(); given PDTableAttributeObject(); then return 'null'")
  void testGetScope_givenPDTableAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTableAttributeObject()).getScope());
  }

  /**
   * Test {@link PDTableAttributeObject#setScope(String)}.
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} Scope is
   * {@code Scope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#setScope(String)}
   */
  @Test
  @DisplayName("Test setScope(String); given PDTableAttributeObject(); then PDTableAttributeObject() Scope is 'Scope'")
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
   * Test {@link PDTableAttributeObject#getSummary()}.
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#getSummary()}
   */
  @Test
  @DisplayName("Test getSummary(); given PDTableAttributeObject(); then return 'null'")
  void testGetSummary_givenPDTableAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDTableAttributeObject()).getSummary());
  }

  /**
   * Test {@link PDTableAttributeObject#setSummary(String)}.
   * <ul>
   *   <li>Then {@link PDTableAttributeObject#PDTableAttributeObject()} Summary is
   * {@code Summary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#setSummary(String)}
   */
  @Test
  @DisplayName("Test setSummary(String); then PDTableAttributeObject() Summary is 'Summary'")
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
   * <ul>
   *   <li>Given {@link PDTableAttributeObject#PDTableAttributeObject()}.</li>
   *   <li>Then return {@code O=Table}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTableAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDTableAttributeObject(); then return 'O=Table'")
  void testToString_givenPDTableAttributeObject_thenReturnOTable() {
    // Arrange, Act and Assert
    assertEquals("O=Table", (new PDTableAttributeObject()).toString());
  }
}
