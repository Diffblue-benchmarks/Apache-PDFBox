package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFJavaScriptDiffblueTest {
  /**
   * Test {@link FDFJavaScript#FDFJavaScript(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFJavaScript#FDFJavaScript(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFJavaScript(COSDictionary)")
  void testNewFDFJavaScript() {
    // Arrange
    COSDictionary javaScript = new COSDictionary();

    // Act and Assert
    assertSame(javaScript, (new FDFJavaScript(javaScript)).getCOSObject());
  }

  /**
   * Test {@link FDFJavaScript#FDFJavaScript()}.
   * <p>
   * Method under test: {@link FDFJavaScript#FDFJavaScript()}
   */
  @Test
  @DisplayName("Test new FDFJavaScript()")
  void testNewFDFJavaScript2() {
    // Arrange and Act
    FDFJavaScript actualFdfJavaScript = new FDFJavaScript();

    // Assert
    assertNull(actualFdfJavaScript.getAfter());
    assertNull(actualFdfJavaScript.getBefore());
    assertNull(actualFdfJavaScript.getDoc());
    COSDictionary cOSObject = actualFdfJavaScript.getCOSObject();
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
   * Test {@link FDFJavaScript#getCOSObject()}.
   * <p>
   * Method under test: {@link FDFJavaScript#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFJavaScript()).getCOSObject();

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
   * Test {@link FDFJavaScript#getBefore()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} Before is
   * {@code Before}.</li>
   *   <li>Then return {@code Before}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); given FDFJavaScript() Before is 'Before'; then return 'Before'")
  void testGetBefore_givenFDFJavaScriptBeforeIsBefore_thenReturnBefore() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setBefore("Before");

    // Act and Assert
    assertEquals("Before", fdfJavaScript.getBefore());
  }

  /**
   * Test {@link FDFJavaScript#getBefore()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} Before is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); given FDFJavaScript() Before is empty string; then return empty string")
  void testGetBefore_givenFDFJavaScriptBeforeIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setBefore("");

    // Act and Assert
    assertEquals("", fdfJavaScript.getBefore());
  }

  /**
   * Test {@link FDFJavaScript#getBefore()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); given FDFJavaScript(); then return 'null'")
  void testGetBefore_givenFDFJavaScript_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFJavaScript()).getBefore());
  }

  /**
   * Test {@link FDFJavaScript#setBefore(String)}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()}.</li>
   *   <li>Then {@link FDFJavaScript#FDFJavaScript()} Before is {@code Before}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#setBefore(String)}
   */
  @Test
  @DisplayName("Test setBefore(String); given FDFJavaScript(); then FDFJavaScript() Before is 'Before'")
  void testSetBefore_givenFDFJavaScript_thenFDFJavaScriptBeforeIsBefore() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    // Act
    fdfJavaScript.setBefore("Before");

    // Assert
    assertEquals("Before", fdfJavaScript.getBefore());
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFJavaScript#getAfter()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} After is {@code After}.</li>
   *   <li>Then return {@code After}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); given FDFJavaScript() After is 'After'; then return 'After'")
  void testGetAfter_givenFDFJavaScriptAfterIsAfter_thenReturnAfter() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setAfter("After");

    // Act and Assert
    assertEquals("After", fdfJavaScript.getAfter());
  }

  /**
   * Test {@link FDFJavaScript#getAfter()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} After is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); given FDFJavaScript() After is empty string; then return empty string")
  void testGetAfter_givenFDFJavaScriptAfterIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setAfter("");

    // Act and Assert
    assertEquals("", fdfJavaScript.getAfter());
  }

  /**
   * Test {@link FDFJavaScript#getAfter()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} Before is
   * {@code Before}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); given FDFJavaScript() Before is 'Before'; then return 'null'")
  void testGetAfter_givenFDFJavaScriptBeforeIsBefore_thenReturnNull() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setBefore("Before");

    // Act and Assert
    assertNull(fdfJavaScript.getAfter());
  }

  /**
   * Test {@link FDFJavaScript#getAfter()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); given FDFJavaScript(); then return 'null'")
  void testGetAfter_givenFDFJavaScript_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFJavaScript()).getAfter());
  }

  /**
   * Test {@link FDFJavaScript#setAfter(String)}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()}.</li>
   *   <li>Then {@link FDFJavaScript#FDFJavaScript()} After is {@code After}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#setAfter(String)}
   */
  @Test
  @DisplayName("Test setAfter(String); given FDFJavaScript(); then FDFJavaScript() After is 'After'")
  void testSetAfter_givenFDFJavaScript_thenFDFJavaScriptAfterIsAfter() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    // Act
    fdfJavaScript.setAfter("After");

    // Assert
    assertEquals("After", fdfJavaScript.getAfter());
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFJavaScript#getDoc()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} Before is
   * {@code Before}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  @DisplayName("Test getDoc(); given FDFJavaScript() Before is 'Before'; then return 'null'")
  void testGetDoc_givenFDFJavaScriptBeforeIsBefore_thenReturnNull() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setBefore("Before");

    // Act and Assert
    assertNull(fdfJavaScript.getDoc());
  }

  /**
   * Test {@link FDFJavaScript#getDoc()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()} Doc is
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  @DisplayName("Test getDoc(); given FDFJavaScript() Doc is HashMap(); then return Empty")
  void testGetDoc_givenFDFJavaScriptDocIsHashMap_thenReturnEmpty() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(new HashMap<>());

    // Act and Assert
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Test {@link FDFJavaScript#getDoc()}.
   * <ul>
   *   <li>Given {@link FDFJavaScript#FDFJavaScript()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  @DisplayName("Test getDoc(); given FDFJavaScript(); then return 'null'")
  void testGetDoc_givenFDFJavaScript_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFJavaScript()).getDoc());
  }

  /**
   * Test {@link FDFJavaScript#getDoc()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDActionJavaScript#PDActionJavaScript()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  @DisplayName("Test getDoc(); given HashMap() 'foo' is PDActionJavaScript(); then return Empty")
  void testGetDoc_givenHashMapFooIsPDActionJavaScript_thenReturnEmpty() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.put("foo", new PDActionJavaScript());

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act and Assert
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Test {@link FDFJavaScript#setDoc(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is
   * {@link PDActionJavaScript#PDActionJavaScript()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  @DisplayName("Test setDoc(Map); given '42'; when HashMap() '42' is PDActionJavaScript()")
  void testSetDoc_given42_whenHashMap42IsPDActionJavaScript() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.put("42", new PDActionJavaScript());
    map.put("foo", new PDActionJavaScript());

    // Act
    fdfJavaScript.setDoc(map);

    // Assert
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Test {@link FDFJavaScript#setDoc(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  @DisplayName("Test setDoc(Map); given 'null'; when HashMap() 'foo' is 'null'")
  void testSetDoc_givenNull_whenHashMapFooIsNull() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.put("foo", null);

    // Act
    fdfJavaScript.setDoc(map);

    // Assert
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Test {@link FDFJavaScript#setDoc(Map)}.
   * <ul>
   *   <li>Given {@link PDActionJavaScript#PDActionJavaScript()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is
   * {@link PDActionJavaScript#PDActionJavaScript()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  @DisplayName("Test setDoc(Map); given PDActionJavaScript(); when HashMap() 'foo' is PDActionJavaScript()")
  void testSetDoc_givenPDActionJavaScript_whenHashMapFooIsPDActionJavaScript() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.put("foo", new PDActionJavaScript());

    // Act
    fdfJavaScript.setDoc(map);

    // Assert
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Test {@link FDFJavaScript#setDoc(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link FDFJavaScript#FDFJavaScript()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  @DisplayName("Test setDoc(Map); when HashMap(); then FDFJavaScript() COSObject Values size is one")
  void testSetDoc_whenHashMap_thenFDFJavaScriptCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    // Act
    fdfJavaScript.setDoc(new HashMap<>());

    // Assert
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }
}
