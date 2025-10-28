package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class PDMarkedContentReferenceDiffblueTest {
  /**
   * Method under test: {@link PDMarkedContentReference#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDMarkedContentReference()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDMarkedContentReference#getPage()}
   */
  @Test
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull((new PDMarkedContentReference()).getPage());
  }

  /**
   * Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  void testSetPage() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setPage(null);

    // Assert
    assertNull(pdMarkedContentReference.getPage());
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDMarkedContentReference#getMCID()}
   */
  @Test
  void testGetMCID() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDMarkedContentReference()).getMCID());
  }

  /**
   * Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  void testSetMCID() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setMCID(1);

    // Assert
    assertEquals(1, pdMarkedContentReference.getMCID());
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  void testSetMCID2() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setMCID(4);

    // Assert
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(4, pdMarkedContentReference.getMCID());
  }

  /**
   * Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  void testSetMCID3() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setMCID(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdMarkedContentReference.getMCID());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDMarkedContentReference#PDMarkedContentReference(COSDictionary)}
   *   <li>{@link PDMarkedContentReference#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDMarkedContentReference actualPdMarkedContentReference = new PDMarkedContentReference(dictionary);

    // Assert
    assertEquals("mcid=-1", actualPdMarkedContentReference.toString());
    assertSame(dictionary, actualPdMarkedContentReference.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDMarkedContentReference#PDMarkedContentReference()}
   */
  @Test
  void testNewPDMarkedContentReference() {
    // Arrange and Act
    PDMarkedContentReference actualPdMarkedContentReference = new PDMarkedContentReference();

    // Assert
    COSDictionary cOSObject = actualPdMarkedContentReference.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdMarkedContentReference.getPage());
    assertEquals(-1, actualPdMarkedContentReference.getMCID());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
