package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDURIDictionaryDiffblueTest {
  /**
   * Test {@link PDURIDictionary#PDURIDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link PDURIDictionary#PDURIDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDURIDictionary(COSDictionary)")
  void testNewPDURIDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDURIDictionary(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDURIDictionary#PDURIDictionary()}.
   * <p>
   * Method under test: {@link PDURIDictionary#PDURIDictionary()}
   */
  @Test
  @DisplayName("Test new PDURIDictionary()")
  void testNewPDURIDictionary2() {
    // Arrange and Act
    PDURIDictionary actualPduriDictionary = new PDURIDictionary();

    // Assert
    assertNull(actualPduriDictionary.getBase());
    COSDictionary cOSObject = actualPduriDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDURIDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link PDURIDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDURIDictionary()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDURIDictionary#getBase()}.
   * <ul>
   *   <li>Given {@link PDURIDictionary#PDURIDictionary(COSDictionary)} with
   * dictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDURIDictionary#getBase()}
   */
  @Test
  @DisplayName("Test getBase(); given PDURIDictionary(COSDictionary) with dictionary is COSStream(); then return 'null'")
  void testGetBase_givenPDURIDictionaryWithDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDURIDictionary(new COSStream())).getBase());
  }

  /**
   * Test {@link PDURIDictionary#getBase()}.
   * <ul>
   *   <li>Given {@link PDURIDictionary#PDURIDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDURIDictionary#getBase()}
   */
  @Test
  @DisplayName("Test getBase(); given PDURIDictionary(); then return 'null'")
  void testGetBase_givenPDURIDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDURIDictionary()).getBase());
  }

  /**
   * Test {@link PDURIDictionary#setBase(String)}.
   * <ul>
   *   <li>Given {@link PDURIDictionary#PDURIDictionary()}.</li>
   *   <li>Then {@link PDURIDictionary#PDURIDictionary()} Base is {@code Base}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDURIDictionary#setBase(String)}
   */
  @Test
  @DisplayName("Test setBase(String); given PDURIDictionary(); then PDURIDictionary() Base is 'Base'")
  void testSetBase_givenPDURIDictionary_thenPDURIDictionaryBaseIsBase() {
    // Arrange
    PDURIDictionary pduriDictionary = new PDURIDictionary();

    // Act
    pduriDictionary.setBase("Base");

    // Assert
    assertEquals("Base", pduriDictionary.getBase());
    COSDictionary cOSObject = pduriDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDURIDictionary#setBase(String)}.
   * <ul>
   *   <li>Then {@link PDURIDictionary#PDURIDictionary(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()} Base is
   * {@code Base}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDURIDictionary#setBase(String)}
   */
  @Test
  @DisplayName("Test setBase(String); then PDURIDictionary(COSDictionary) with dictionary is COSDictionary() Base is 'Base'")
  void testSetBase_thenPDURIDictionaryWithDictionaryIsCOSDictionaryBaseIsBase() {
    // Arrange
    PDURIDictionary pduriDictionary = new PDURIDictionary(new COSDictionary());

    // Act
    pduriDictionary.setBase("Base");

    // Assert
    assertEquals("Base", pduriDictionary.getBase());
    COSDictionary cOSObject = pduriDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
