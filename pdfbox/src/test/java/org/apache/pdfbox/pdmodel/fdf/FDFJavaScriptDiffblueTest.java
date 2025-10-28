package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.junit.jupiter.api.Test;

class FDFJavaScriptDiffblueTest {
  /**
   * Method under test: {@link FDFJavaScript#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link FDFJavaScript#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act
    COSDictionary actualCOSObject = fdfJavaScript.getCOSObject();

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
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  void testGetBefore() {
    // Arrange, Act and Assert
    assertNull((new FDFJavaScript()).getBefore());
  }

  /**
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  void testGetBefore2() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setBefore("Before");

    // Act and Assert
    assertEquals("Before", fdfJavaScript.getBefore());
  }

  /**
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  void testGetBefore3() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setBefore("");

    // Act and Assert
    assertEquals("", fdfJavaScript.getBefore());
  }

  /**
   * Method under test: {@link FDFJavaScript#getBefore()}
   */
  @Test
  void testGetBefore4() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act and Assert
    assertNull(fdfJavaScript.getBefore());
  }

  /**
   * Method under test: {@link FDFJavaScript#setBefore(String)}
   */
  @Test
  void testSetBefore() {
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
   * Method under test: {@link FDFJavaScript#setBefore(String)}
   */
  @Test
  void testSetBefore2() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act
    fdfJavaScript.setBefore("Before");

    // Assert
    assertEquals("Before", fdfJavaScript.getBefore());
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  void testGetAfter() {
    // Arrange, Act and Assert
    assertNull((new FDFJavaScript()).getAfter());
  }

  /**
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  void testGetAfter2() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setAfter("After");

    // Act and Assert
    assertEquals("After", fdfJavaScript.getAfter());
  }

  /**
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  void testGetAfter3() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setAfter("");

    // Act and Assert
    assertEquals("", fdfJavaScript.getAfter());
  }

  /**
   * Method under test: {@link FDFJavaScript#getAfter()}
   */
  @Test
  void testGetAfter4() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act and Assert
    assertNull(fdfJavaScript.getAfter());
  }

  /**
   * Method under test: {@link FDFJavaScript#setAfter(String)}
   */
  @Test
  void testSetAfter() {
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
   * Method under test: {@link FDFJavaScript#setAfter(String)}
   */
  @Test
  void testSetAfter2() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act
    fdfJavaScript.setAfter("After");

    // Assert
    assertEquals("After", fdfJavaScript.getAfter());
    COSDictionary cOSObject = fdfJavaScript.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  void testGetDoc() {
    // Arrange, Act and Assert
    assertNull((new FDFJavaScript()).getDoc());
  }

  /**
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  void testGetDoc2() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(new HashMap<>());

    // Act and Assert
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  void testGetDoc3() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.put("foo", new PDActionJavaScript());

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act and Assert
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Method under test: {@link FDFJavaScript#getDoc()}
   */
  @Test
  void testGetDoc4() {
    // Arrange
    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));
    map.put("foo", new PDActionJavaScript());

    FDFJavaScript fdfJavaScript = new FDFJavaScript();
    fdfJavaScript.setDoc(map);

    // Act and Assert
    assertTrue(fdfJavaScript.getDoc().isEmpty());
  }

  /**
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  void testSetDoc() {
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

  /**
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  void testSetDoc2() {
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
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  void testSetDoc3() {
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
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  void testSetDoc4() {
    // Arrange
    FDFJavaScript fdfJavaScript = new FDFJavaScript();

    HashMap<String, PDActionJavaScript> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));
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
   * Method under test: {@link FDFJavaScript#setDoc(Map)}
   */
  @Test
  void testSetDoc5() {
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
   * Method under test: {@link FDFJavaScript#FDFJavaScript(COSDictionary)}
   */
  @Test
  void testNewFDFJavaScript() {
    // Arrange
    COSDictionary javaScript = new COSDictionary();

    // Act and Assert
    assertSame(javaScript, (new FDFJavaScript(javaScript)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFJavaScript#FDFJavaScript()}
   */
  @Test
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
}
