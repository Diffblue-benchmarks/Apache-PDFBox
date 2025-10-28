package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDDocumentOutlineDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDocumentOutline#closeNode()}
   *   <li>{@link PDDocumentOutline#openNode()}
   *   <li>{@link PDDocumentOutline#isNodeOpen()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.closeNode();
    pdDocumentOutline.openNode();

    // Assert that nothing has changed
    assertTrue(pdDocumentOutline.isNodeOpen());
  }

  /**
   * Method under test: {@link PDDocumentOutline#PDDocumentOutline()}
   */
  @Test
  void testNewPDDocumentOutline() {
    // Arrange and Act
    PDDocumentOutline actualPdDocumentOutline = new PDDocumentOutline();

    // Assert
    COSDictionary cOSObject = actualPdDocumentOutline.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdDocumentOutline.getFirstChild());
    assertNull(actualPdDocumentOutline.getLastChild());
    assertNull(actualPdDocumentOutline.getParent());
    assertEquals(0, actualPdDocumentOutline.getOpenCount());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdDocumentOutline.hasChildren());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdDocumentOutline.isNodeOpen());
  }

  /**
   * Method under test: {@link PDDocumentOutline#PDDocumentOutline(COSDictionary)}
   */
  @Test
  void testNewPDDocumentOutline2() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDDocumentOutline actualPdDocumentOutline = new PDDocumentOutline(dic);

    // Assert
    assertNull(actualPdDocumentOutline.getFirstChild());
    assertNull(actualPdDocumentOutline.getLastChild());
    assertNull(actualPdDocumentOutline.getParent());
    assertEquals(0, actualPdDocumentOutline.getOpenCount());
    assertEquals(1, dic.size());
    assertFalse(actualPdDocumentOutline.hasChildren());
    assertTrue(actualPdDocumentOutline.isNodeOpen());
    assertSame(dic, actualPdDocumentOutline.getCOSObject());
  }
}
