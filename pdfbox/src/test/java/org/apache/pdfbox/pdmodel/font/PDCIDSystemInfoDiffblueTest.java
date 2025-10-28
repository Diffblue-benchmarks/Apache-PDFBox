package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDCIDSystemInfoDiffblueTest {
  /**
   * Method under test: {@link PDCIDSystemInfo#getRegistry()}
   */
  @Test
  void testGetRegistry() {
    // Arrange, Act and Assert
    assertEquals("Registry", (new PDCIDSystemInfo("Registry", "Ordering", 1)).getRegistry());
    assertEquals("", (new PDCIDSystemInfo("", "Ordering", 1)).getRegistry());
    assertNull((new PDCIDSystemInfo(new COSDictionary())).getRegistry());
  }

  /**
   * Method under test: {@link PDCIDSystemInfo#getOrdering()}
   */
  @Test
  void testGetOrdering() {
    // Arrange, Act and Assert
    assertEquals("Ordering", (new PDCIDSystemInfo("Registry", "Ordering", 1)).getOrdering());
    assertEquals("", (new PDCIDSystemInfo("Registry", "", 1)).getOrdering());
    assertNull((new PDCIDSystemInfo(new COSDictionary())).getOrdering());
  }

  /**
   * Method under test: {@link PDCIDSystemInfo#getSupplement()}
   */
  @Test
  void testGetSupplement() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDCIDSystemInfo("Registry", "Ordering", 1)).getSupplement());
    assertEquals(-1, (new PDCIDSystemInfo(new COSDictionary())).getSupplement());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDCIDSystemInfo#PDCIDSystemInfo(COSDictionary)}
   *   <li>{@link PDCIDSystemInfo#toString()}
   *   <li>{@link PDCIDSystemInfo#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo(dictionary);
    String actualToStringResult = actualPdcidSystemInfo.toString();

    // Assert
    assertEquals("null-null--1", actualToStringResult);
    assertSame(dictionary, actualPdcidSystemInfo.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  void testNewPDCIDSystemInfo() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertEquals("Ordering", actualPdcidSystemInfo.getOrdering());
    assertEquals("Registry", actualPdcidSystemInfo.getRegistry());
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, actualPdcidSystemInfo.getSupplement());
    assertEquals(3, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(3, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  void testNewPDCIDSystemInfo2() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo(null, null, 1);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertNull(actualPdcidSystemInfo.getOrdering());
    assertNull(actualPdcidSystemInfo.getRegistry());
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdcidSystemInfo.getSupplement());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  void testNewPDCIDSystemInfo3() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 6);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertEquals("Ordering", actualPdcidSystemInfo.getOrdering());
    assertEquals("Registry", actualPdcidSystemInfo.getRegistry());
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(3, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(3, ((COSDictionary) cOSObject).size());
    assertEquals(6, actualPdcidSystemInfo.getSupplement());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  void testNewPDCIDSystemInfo4() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", Integer.MIN_VALUE);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertEquals("Ordering", actualPdcidSystemInfo.getOrdering());
    assertEquals("Registry", actualPdcidSystemInfo.getRegistry());
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(3, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(3, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(Integer.MIN_VALUE, actualPdcidSystemInfo.getSupplement());
  }
}
