package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDPageLabelRangeDiffblueTest {
  /**
   * Method under test: {@link PDPageLabelRange#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDPageLabelRange()).getCOSObject();

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
   * Method under test: {@link PDPageLabelRange#getStyle()}
   */
  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    assertNull((new PDPageLabelRange()).getStyle());
  }

  /**
   * Method under test: {@link PDPageLabelRange#getStyle()}
   */
  @Test
  void testGetStyle2() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setStyle("Style");

    // Act and Assert
    assertEquals("Style", pdPageLabelRange.getStyle());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  void testSetStyle() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStyle("Style");

    // Assert
    assertEquals("Style", pdPageLabelRange.getStyle());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  void testSetStyle2() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStyle(null);

    // Assert
    assertNull(pdPageLabelRange.getStyle());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  void testSetStyle3() {
    // Arrange
    COSDictionary dict = COSDictionaryMap.convert(new HashMap<>());
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange(dict);

    // Act
    pdPageLabelRange.setStyle("42");

    // Assert
    assertEquals("42", pdPageLabelRange.getStyle());
    assertSame(dict, pdPageLabelRange.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  void testSetStyle4() {
    // Arrange
    HashMap<String, Object> someMap = new HashMap<>();
    someMap.computeIfPresent("foo", mock(BiFunction.class));
    COSDictionary dict = COSDictionaryMap.convert(someMap);
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange(dict);

    // Act
    pdPageLabelRange.setStyle("42");

    // Assert
    assertEquals("42", pdPageLabelRange.getStyle());
    assertSame(dict, pdPageLabelRange.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageLabelRange#getStart()}
   */
  @Test
  void testGetStart() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDPageLabelRange()).getStart());
  }

  /**
   * Method under test: {@link PDPageLabelRange#getStart()}
   */
  @Test
  void testGetStart2() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setStart(1);

    // Act and Assert
    assertEquals(1, pdPageLabelRange.getStart());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setStart(int)}
   */
  @Test
  void testSetStart() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStart(1);

    // Assert
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setStart(int)}
   */
  @Test
  void testSetStart2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDPageLabelRange()).setStart(-100));
  }

  /**
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  void testGetPrefix() {
    // Arrange, Act and Assert
    assertNull((new PDPageLabelRange()).getPrefix());
  }

  /**
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  void testGetPrefix2() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix", pdPageLabelRange.getPrefix());
  }

  /**
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  void testGetPrefix3() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setPrefix("");

    // Act and Assert
    assertEquals("", pdPageLabelRange.getPrefix());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setPrefix(String)}
   */
  @Test
  void testSetPrefix() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setPrefix("Prefix");

    // Assert
    assertEquals("Prefix", pdPageLabelRange.getPrefix());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDPageLabelRange#setPrefix(String)}
   */
  @Test
  void testSetPrefix2() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setPrefix(null);

    // Assert
    assertNull(pdPageLabelRange.getPrefix());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPageLabelRange#PDPageLabelRange(COSDictionary)}
   */
  @Test
  void testNewPDPageLabelRange() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDPageLabelRange(dict)).getCOSObject());
  }

  /**
   * Method under test: {@link PDPageLabelRange#PDPageLabelRange()}
   */
  @Test
  void testNewPDPageLabelRange2() {
    // Arrange and Act
    PDPageLabelRange actualPdPageLabelRange = new PDPageLabelRange();

    // Assert
    assertNull(actualPdPageLabelRange.getPrefix());
    assertNull(actualPdPageLabelRange.getStyle());
    COSDictionary cOSObject = actualPdPageLabelRange.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertEquals(1, actualPdPageLabelRange.getStart());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
