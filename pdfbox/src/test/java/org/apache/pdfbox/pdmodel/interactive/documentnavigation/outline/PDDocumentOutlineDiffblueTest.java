package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

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

class PDDocumentOutlineDiffblueTest {
  /**
   * Test {@link PDDocumentOutline#PDDocumentOutline()}.
   * <p>
   * Method under test: {@link PDDocumentOutline#PDDocumentOutline()}
   */
  @Test
  @DisplayName("Test new PDDocumentOutline()")
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
   * Test {@link PDDocumentOutline#PDDocumentOutline(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return FirstChild is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentOutline#PDDocumentOutline(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentOutline(COSDictionary); when COSDictionary(); then return FirstChild is 'null'")
  void testNewPDDocumentOutline_whenCOSDictionary_thenReturnFirstChildIsNull() {
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDocumentOutline#closeNode()}
   *   <li>{@link PDDocumentOutline#openNode()}
   *   <li>{@link PDDocumentOutline#isNodeOpen()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.closeNode();
    pdDocumentOutline.openNode();

    // Assert that nothing has changed
    assertTrue(pdDocumentOutline.isNodeOpen());
  }
}
