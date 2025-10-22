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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMarkInfoDiffblueTest {
  /**
   * Test {@link PDMarkInfo#PDMarkInfo(COSDictionary)}.
   * <p>
   * Method under test: {@link PDMarkInfo#PDMarkInfo(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDMarkInfo(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.<init>(COSDictionary)"})
  void testNewPDMarkInfo() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDMarkInfo(dic)).getCOSObject());
  }

  /**
   * Test {@link PDMarkInfo#PDMarkInfo()}.
   * <p>
   * Method under test: {@link PDMarkInfo#PDMarkInfo()}
   */
  @Test
  @DisplayName("Test new PDMarkInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.<init>()"})
  void testNewPDMarkInfo2() {
    // Arrange and Act
    PDMarkInfo actualPdMarkInfo = new PDMarkInfo();

    // Assert
    COSDictionary cOSObject = actualPdMarkInfo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdMarkInfo.isMarked());
    assertFalse(actualPdMarkInfo.isSuspect());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDMarkInfo#getCOSObject()}.
   * <p>
   * Method under test: {@link PDMarkInfo#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDMarkInfo.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDMarkInfo()).getCOSObject();

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
   * Test {@link PDMarkInfo#isMarked()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()} Marked is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  @DisplayName("Test isMarked(); given PDMarkInfo() Marked is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isMarked()"})
  void testIsMarked_givenPDMarkInfoMarkedIsFalse_thenReturnFalse() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setMarked(false);

    // Act and Assert
    assertFalse(pdMarkInfo.isMarked());
  }

  /**
   * Test {@link PDMarkInfo#isMarked()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()} Marked is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  @DisplayName("Test isMarked(); given PDMarkInfo() Marked is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isMarked()"})
  void testIsMarked_givenPDMarkInfoMarkedIsTrue_thenReturnTrue() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setMarked(true);

    // Act and Assert
    assertTrue(pdMarkInfo.isMarked());
  }

  /**
   * Test {@link PDMarkInfo#isMarked()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo(COSDictionary)} with dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  @DisplayName("Test isMarked(); given PDMarkInfo(COSDictionary) with dic is COSDictionary(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isMarked()"})
  void testIsMarked_givenPDMarkInfoWithDicIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo(new COSDictionary())).isMarked());
  }

  /**
   * Test {@link PDMarkInfo#isMarked()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  @DisplayName("Test isMarked(); given PDMarkInfo(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isMarked()"})
  void testIsMarked_givenPDMarkInfo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo()).isMarked());
  }

  /**
   * Test {@link PDMarkInfo#setMarked(boolean)}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDMarkInfo#PDMarkInfo()} Marked.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#setMarked(boolean)}
   */
  @Test
  @DisplayName("Test setMarked(boolean); given PDMarkInfo(); when 'false'; then not PDMarkInfo() Marked")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.setMarked(boolean)"})
  void testSetMarked_givenPDMarkInfo_whenFalse_thenNotPDMarkInfoMarked() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setMarked(false);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdMarkInfo.isMarked());
  }

  /**
   * Test {@link PDMarkInfo#setMarked(boolean)}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDMarkInfo#PDMarkInfo()} Marked.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#setMarked(boolean)}
   */
  @Test
  @DisplayName("Test setMarked(boolean); given PDMarkInfo(); when 'true'; then PDMarkInfo() Marked")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.setMarked(boolean)"})
  void testSetMarked_givenPDMarkInfo_whenTrue_thenPDMarkInfoMarked() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setMarked(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdMarkInfo.isMarked());
  }

  /**
   * Test {@link PDMarkInfo#setMarked(boolean)}.
   * <ul>
   *   <li>Then {@link PDMarkInfo#PDMarkInfo(COSDictionary)} with dic is {@link COSDictionary#COSDictionary()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#setMarked(boolean)}
   */
  @Test
  @DisplayName("Test setMarked(boolean); then PDMarkInfo(COSDictionary) with dic is COSDictionary() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.setMarked(boolean)"})
  void testSetMarked_thenPDMarkInfoWithDicIsCOSDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo(new COSDictionary());

    // Act
    pdMarkInfo.setMarked(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdMarkInfo.isMarked());
  }

  /**
   * Test {@link PDMarkInfo#usesUserProperties()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()} UserProperties is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#usesUserProperties()}
   */
  @Test
  @DisplayName("Test usesUserProperties(); given PDMarkInfo() UserProperties is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.usesUserProperties()"})
  void testUsesUserProperties_givenPDMarkInfoUserPropertiesIsFalse_thenReturnFalse() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setUserProperties(false);

    // Act and Assert
    assertFalse(pdMarkInfo.usesUserProperties());
  }

  /**
   * Test {@link PDMarkInfo#usesUserProperties()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()} UserProperties is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#usesUserProperties()}
   */
  @Test
  @DisplayName("Test usesUserProperties(); given PDMarkInfo() UserProperties is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.usesUserProperties()"})
  void testUsesUserProperties_givenPDMarkInfoUserPropertiesIsTrue_thenReturnTrue() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setUserProperties(true);

    // Act and Assert
    assertTrue(pdMarkInfo.usesUserProperties());
  }

  /**
   * Test {@link PDMarkInfo#usesUserProperties()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#usesUserProperties()}
   */
  @Test
  @DisplayName("Test usesUserProperties(); given PDMarkInfo(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.usesUserProperties()"})
  void testUsesUserProperties_givenPDMarkInfo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo()).usesUserProperties());
  }

  /**
   * Test {@link PDMarkInfo#setUserProperties(boolean)}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>Then {@link PDMarkInfo#PDMarkInfo()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#setUserProperties(boolean)}
   */
  @Test
  @DisplayName("Test setUserProperties(boolean); given PDMarkInfo(); then PDMarkInfo() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.setUserProperties(boolean)"})
  void testSetUserProperties_givenPDMarkInfo_thenPDMarkInfoCOSObjectValuesSizeIsOne() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setUserProperties(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDMarkInfo#setUserProperties(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDMarkInfo#PDMarkInfo()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#setUserProperties(boolean)}
   */
  @Test
  @DisplayName("Test setUserProperties(boolean); when 'false'; then PDMarkInfo() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.setUserProperties(boolean)"})
  void testSetUserProperties_whenFalse_thenPDMarkInfoCOSObjectValuesSizeIsOne() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setUserProperties(false);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDMarkInfo#isSuspect()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()} Suspect is {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isSuspect()}
   */
  @Test
  @DisplayName("Test isSuspect(); given PDMarkInfo() Suspect is 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isSuspect()"})
  void testIsSuspect_givenPDMarkInfoSuspectIsTrue_thenReturnFalse() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setSuspect(true);

    // Act and Assert
    assertFalse(pdMarkInfo.isSuspect());
  }

  /**
   * Test {@link PDMarkInfo#isSuspect()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo(COSDictionary)} with dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isSuspect()}
   */
  @Test
  @DisplayName("Test isSuspect(); given PDMarkInfo(COSDictionary) with dic is COSDictionary(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isSuspect()"})
  void testIsSuspect_givenPDMarkInfoWithDicIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo(new COSDictionary())).isSuspect());
  }

  /**
   * Test {@link PDMarkInfo#isSuspect()}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#isSuspect()}
   */
  @Test
  @DisplayName("Test isSuspect(); given PDMarkInfo(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDMarkInfo.isSuspect()"})
  void testIsSuspect_givenPDMarkInfo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo()).isSuspect());
  }

  /**
   * Test {@link PDMarkInfo#setSuspect(boolean)}.
   * <ul>
   *   <li>Given {@link PDMarkInfo#PDMarkInfo()}.</li>
   *   <li>Then {@link PDMarkInfo#PDMarkInfo()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkInfo#setSuspect(boolean)}
   */
  @Test
  @DisplayName("Test setSuspect(boolean); given PDMarkInfo(); then PDMarkInfo() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMarkInfo.setSuspect(boolean)"})
  void testSetSuspect_givenPDMarkInfo_thenPDMarkInfoCOSObjectValuesSizeIsOne() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setSuspect(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
