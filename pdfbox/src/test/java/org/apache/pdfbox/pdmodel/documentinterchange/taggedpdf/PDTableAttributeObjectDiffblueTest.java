package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDTableAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDTableAttributeObject#getRowSpan()}
   */
  @Test
  void testGetRowSpan() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDTableAttributeObject()).getRowSpan());
  }

  /**
   * Method under test: {@link PDTableAttributeObject#setRowSpan(int)}
   */
  @Test
  void testSetRowSpan() {
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
   * Method under test: {@link PDTableAttributeObject#getColSpan()}
   */
  @Test
  void testGetColSpan() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDTableAttributeObject()).getColSpan());
  }

  /**
   * Method under test: {@link PDTableAttributeObject#setColSpan(int)}
   */
  @Test
  void testSetColSpan() {
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
   * Method under test: {@link PDTableAttributeObject#getHeaders()}
   */
  @Test
  void testGetHeaders() {
    // Arrange, Act and Assert
    assertNull((new PDTableAttributeObject()).getHeaders());
  }

  /**
   * Method under test: {@link PDTableAttributeObject#setHeaders(String[])}
   */
  @Test
  void testSetHeaders() {
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
   * Method under test: {@link PDTableAttributeObject#getScope()}
   */
  @Test
  void testGetScope() {
    // Arrange, Act and Assert
    assertNull((new PDTableAttributeObject()).getScope());
  }

  /**
   * Method under test: {@link PDTableAttributeObject#setScope(String)}
   */
  @Test
  void testSetScope() {
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
   * Method under test: {@link PDTableAttributeObject#getSummary()}
   */
  @Test
  void testGetSummary() {
    // Arrange, Act and Assert
    assertNull((new PDTableAttributeObject()).getSummary());
  }

  /**
   * Method under test: {@link PDTableAttributeObject#setSummary(String)}
   */
  @Test
  void testSetSummary() {
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
   * Method under test: {@link PDTableAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=Table", (new PDTableAttributeObject()).toString());
  }

  /**
   * Method under test:
   * {@link PDTableAttributeObject#PDTableAttributeObject(COSDictionary)}
   */
  @Test
  void testNewPDTableAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDTableAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDTableAttributeObject#PDTableAttributeObject()}
   */
  @Test
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
}
