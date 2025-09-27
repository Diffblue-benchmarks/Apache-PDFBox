package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDParentTreeValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return toString is {@code COSArray{[]}}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDParentTreeValue#PDParentTreeValue(COSArray)}
   *   <li>{@link PDParentTreeValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSArray(); then return toString is 'COSArray{[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDParentTreeValue.<init>(COSArray)",
    "void PDParentTreeValue.<init>(COSDictionary)",
    "java.lang.String PDParentTreeValue.toString()"
  })
  void testGettersAndSetters_whenCOSArray_thenReturnToStringIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals("COSArray{[]}", new PDParentTreeValue(new COSArray()).toString());
  }

  /**
   * Test {@link PDParentTreeValue#PDParentTreeValue(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link PDParentTreeValue#obj} return {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDParentTreeValue#PDParentTreeValue(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDParentTreeValue(COSDictionary); when COSDictionary(); then obj return COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDParentTreeValue.<init>(COSArray)",
    "void PDParentTreeValue.<init>(COSDictionary)",
    "java.lang.String PDParentTreeValue.toString()"
  })
  void testNewPDParentTreeValue_whenCOSDictionary_thenObjReturnCOSDictionary() {
    // Arrange and Act
    PDParentTreeValue actualPdParentTreeValue = new PDParentTreeValue(new COSDictionary());

    // Assert
    COSObjectable cosObjectable = actualPdParentTreeValue.obj;
    assertTrue(cosObjectable instanceof COSDictionary);
    assertNull(((COSDictionary) cosObjectable).getKey());
    assertEquals(0, ((COSDictionary) cosObjectable).size());
    COSIncrement toIncrementResult = ((COSDictionary) cosObjectable).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSDictionary) cosObjectable).isDirect());
    assertFalse(((COSDictionary) cosObjectable).isNeedToBeUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSObjectable expectedCOSObject = actualPdParentTreeValue.obj;
    assertSame(expectedCOSObject, actualPdParentTreeValue.getCOSObject());
  }

  /**
   * Test {@link PDParentTreeValue#getCOSObject()}.
   *
   * <ul>
   *   <li>Given {@link PDParentTreeValue#PDParentTreeValue(COSArray)} with obj is {@link
   *       COSArray#COSArray()}.
   *   <li>Then return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDParentTreeValue#getCOSObject()}
   */
  @Test
  @DisplayName(
      "Test getCOSObject(); given PDParentTreeValue(COSArray) with obj is COSArray(); then return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDParentTreeValue.getCOSObject()"})
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
