package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMarkedContentReferenceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDMarkedContentReference#PDMarkedContentReference(COSDictionary)}
   *   <li>{@link PDMarkedContentReference#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkedContentReference.<init>(COSDictionary)",
      "java.lang.String PDMarkedContentReference.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDMarkedContentReference actualPdMarkedContentReference = new PDMarkedContentReference(dictionary);

    // Assert
    assertEquals("mcid=-1", actualPdMarkedContentReference.toString());
    assertSame(dictionary, actualPdMarkedContentReference.getCOSObject());
  }

  /**
   * Test {@link PDMarkedContentReference#PDMarkedContentReference()}.
   * <p>
   * Method under test: {@link PDMarkedContentReference#PDMarkedContentReference()}
   */
  @Test
  @DisplayName("Test new PDMarkedContentReference()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDMarkedContentReference#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDMarkedContentReference.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDMarkedContentReference()).getCOSObject();

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
   * <ul>
   *   <li>Given {@link PDMarkedContentReference#PDMarkedContentReference()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContentReference#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDMarkedContentReference(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDMarkedContentReference.getPage()"})
  void testGetPage_givenPDMarkedContentReference_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDMarkedContentReference()).getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#setPage(PDPage)}.
   * <ul>
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} Page is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); then PDMarkedContentReference() Page is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkedContentReference.setPage(PDPage)"})
  void testSetPage_thenPDMarkedContentReferencePageIsPDPage() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();
    PDPage page = new PDPage();

    // Act
    pdMarkedContentReference.setPage(page);

    // Assert
    assertEquals(page, pdMarkedContentReference.getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#setPage(PDPage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} Page is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContentReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); when 'null'; then PDMarkedContentReference() Page is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkedContentReference.setPage(PDPage)"})
  void testSetPage_whenNull_thenPDMarkedContentReferencePageIsNull() {
    // Arrange
    PDMarkedContentReference pdMarkedContentReference = new PDMarkedContentReference();

    // Act
    pdMarkedContentReference.setPage(null);

    // Assert that nothing has changed
    assertNull(pdMarkedContentReference.getPage());
  }

  /**
   * Test {@link PDMarkedContentReference#getMCID()}.
   * <ul>
   *   <li>Given {@link PDMarkedContentReference#PDMarkedContentReference()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContentReference#getMCID()}
   */
  @Test
  @DisplayName("Test getMCID(); given PDMarkedContentReference(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDMarkedContentReference.getMCID()"})
  void testGetMCID_givenPDMarkedContentReference_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDMarkedContentReference()).getMCID());
  }

  /**
   * Test {@link PDMarkedContentReference#setMCID(int)}.
   * <ul>
   *   <li>Given {@link PDMarkedContentReference#PDMarkedContentReference()}.</li>
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} MCID is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  @DisplayName("Test setMCID(int); given PDMarkedContentReference(); then PDMarkedContentReference() MCID is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkedContentReference.setMCID(int)"})
  void testSetMCID_givenPDMarkedContentReference_thenPDMarkedContentReferenceMcidIsOne() {
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

  /**
   * Test {@link PDMarkedContentReference#setMCID(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDMarkedContentReference#PDMarkedContentReference()} MCID is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContentReference#setMCID(int)}
   */
  @Test
  @DisplayName("Test setMCID(int); when MIN_VALUE; then PDMarkedContentReference() MCID is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
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
}
