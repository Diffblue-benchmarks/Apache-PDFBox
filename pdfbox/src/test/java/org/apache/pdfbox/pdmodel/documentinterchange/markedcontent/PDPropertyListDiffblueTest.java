package org.apache.pdfbox.pdmodel.documentinterchange.markedcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPropertyListDiffblueTest {
  /**
   * Test {@link PDPropertyList#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropertyList#create(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test create(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDPropertyList.create(COSDictionary)"})
  void testCreate_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDPropertyList actualCreateResult = PDPropertyList.create(dict);

    // Assert
    assertSame(dict, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDPropertyList#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropertyList#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDPropertyList.create(COSDictionary)"})
  void testCreate_whenCOSStream_thenReturnCOSObjectIsCOSStream() {
    // Arrange
    COSStream dict = new COSStream();

    // Act
    PDPropertyList actualCreateResult = PDPropertyList.create(dict);

    // Assert
    assertSame(dict, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDPropertyList#PDPropertyList(COSDictionary)}.
   *
   * <p>Method under test: {@link PDPropertyList#PDPropertyList(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPropertyList(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropertyList.<init>(COSDictionary)"})
  void testNewPDPropertyList() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDPropertyList(dict).getCOSObject());
  }

  /**
   * Test {@link PDPropertyList#PDPropertyList()}.
   *
   * <p>Method under test: {@link PDPropertyList#PDPropertyList()}
   */
  @Test
  @DisplayName("Test new PDPropertyList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropertyList.<init>()"})
  void testNewPDPropertyList2() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDPropertyList().getCOSObject();

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
   * Test {@link PDPropertyList#getCOSObject()}.
   *
   * <p>Method under test: {@link PDPropertyList#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDPropertyList.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    PDPropertyList pdPropertyList = new PDPropertyList();

    // Act
    COSDictionary actualCOSObject = pdPropertyList.getCOSObject();

    // Assert
    assertSame(pdPropertyList.dict, actualCOSObject);
  }
}
