package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMarkedContentReferenceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDMarkedContentReference#PDMarkedContentReference(COSDictionary)}
   *   <li>{@link PDMarkedContentReference#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDMarkedContentReference.<init>(COSDictionary)",
    "java.lang.String PDMarkedContentReference.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDMarkedContentReference actualPdMarkedContentReference =
        new PDMarkedContentReference(dictionary);

    // Assert
    assertEquals("mcid=-1", actualPdMarkedContentReference.toString());
    assertSame(dictionary, actualPdMarkedContentReference.getCOSObject());
  }

  /**
   * Test {@link PDMarkedContentReference#PDMarkedContentReference()}.
   *
   * <p>Method under test: {@link PDMarkedContentReference#PDMarkedContentReference()}
   */
  @Test
  @DisplayName("Test new PDMarkedContentReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.<init>()"})
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

  /**
   * Test {@link PDMarkedContentReference#getCOSObject()}.
   *
   * <p>Method under test: {@link PDMarkedContentReference#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDMarkedContentReference.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDMarkedContentReference().getCOSObject();

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
   * Test {@link PDMarkedContentReference#getPage()}.
   *
   * <ul>
   *   <li>Given {@link PDMarkedContentReference#PDMarkedContentReference()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDMarkedContentReference(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDMarkedContentReference.getPage()"})
  void testGetPage_givenPDMarkedContentReference_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDMarkedContentReference().getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setPage(PDPage)"})
  void testSetPage_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    // Act
    pdMarkedContentReference.setPage(page);

    // Assert
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(page, pdMarkedContentReference.getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setPage(PDPage)"})
  void testSetPage_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setDirect(true);
    PDPage page = new PDPage(pageDictionary);

    // Act
    pdMarkedContentReference.setPage(page);

    // Assert
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(page, pdMarkedContentReference.getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); when 'null'; then PDMarkedContentReference() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setPage(PDPage)"})
  void testSetPage_whenNull_thenPDMarkedContentReferenceCOSObjectValuesSizeIsOne() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setPage(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDMarkedContentReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} Page is {@link
   *       PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); when PDPage(); then PDMarkedContentReference() Page is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setPage(PDPage)"})
  void testSetPage_whenPDPage_thenPDMarkedContentReferencePageIsPDPage() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();
    PDPage page = new PDPage();

    // Act
    pdMarkedContentReference.setPage(page);

    // Assert
    assertEquals(page, pdMarkedContentReference.getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#getMCID()}.
   *
   * <ul>
   *   <li>Given {@link PDMarkedContentReference#PDMarkedContentReference()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#getMCID()}
   */
  @Test
  @DisplayName("Test getMCID(); given PDMarkedContentReference(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDMarkedContentReference.getMCID()"})
  void testGetMCID_givenPDMarkedContentReference_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDMarkedContentReference().getMCID());
  }

  /**
   * Test {@link PDMarkedContentReference#setMCID(int)}.
   *
   * <ul>
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} MCID is minus one
   *       hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  @DisplayName("Test setMCID(int); then PDMarkedContentReference() MCID is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setMCID(int)"})
  void testSetMCID_thenPDMarkedContentReferenceMcidIsMinusOneHundred() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setMCID(-100);

    // Assert
    assertEquals(-100, pdMarkedContentReference.getMCID());
    COSDictionary cOSObject = pdMarkedContentReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDMarkedContentReference#setMCID(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} MCID is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  @DisplayName(
      "Test setMCID(int); when MIN_VALUE; then PDMarkedContentReference() MCID is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setMCID(int)"})
  void testSetMCID_whenMin_value_thenPDMarkedContentReferenceMcidIsMin_value() {
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
   * Test {@link PDMarkedContentReference#setMCID(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} MCID is one.
   * </ul>
   *
   * <p>Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  @DisplayName("Test setMCID(int); when one; then PDMarkedContentReference() MCID is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMarkedContentReference.setMCID(int)"})
  void testSetMCID_whenOne_thenPDMarkedContentReferenceMcidIsOne() {
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
}
