package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDParentTreeValueDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then return toString is {@code COSArray{[]}}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDParentTreeValue#PDParentTreeValue(COSArray)}
   *   <li>{@link PDParentTreeValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSArray(); then return toString is 'COSArray{[]}'")
  void testGettersAndSetters_whenCOSArray_thenReturnToStringIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals("COSArray{[]}", (new PDParentTreeValue(new COSArray())).toString());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return toString is {@code COSDictionary{}}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDParentTreeValue#PDParentTreeValue(COSDictionary)}
   *   <li>{@link PDParentTreeValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSDictionary(); then return toString is 'COSDictionary{}'")
  void testGettersAndSetters_whenCOSDictionary_thenReturnToStringIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("COSDictionary{}", (new PDParentTreeValue(new COSDictionary())).toString());
  }

  /**
   * Test {@link PDParentTreeValue#getCOSObject()}.
   * <ul>
   *   <li>Given {@link PDParentTreeValue#PDParentTreeValue(COSArray)} with obj is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDParentTreeValue#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject(); given PDParentTreeValue(COSArray) with obj is COSArray(); then return COSArray")
  void testGetCOSObject_givenPDParentTreeValueWithObjIsCOSArray_thenReturnCOSArray() {
    // Arrange
    PDParentTreeValue pdParentTreeValue = new PDParentTreeValue(new COSArray());

    // Act
    COSBase actualCOSObject = pdParentTreeValue.getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSArray);
    assertTrue(((COSArray) actualCOSObject).toList().isEmpty());
    assertSame(pdParentTreeValue.obj, actualCOSObject);
  }
}
