package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

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

class PDPropBuildDiffblueTest {
  /**
   * Test {@link PDPropBuild#PDPropBuild()}.
   * <p>
   * Method under test: {@link PDPropBuild#PDPropBuild()}
   */
  @Test
  @DisplayName("Test new PDPropBuild()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.<init>()"})
  void testNewPDPropBuild() {
    // Arrange and Act
    PDPropBuild actualPdPropBuild = new PDPropBuild();

    // Assert
    COSDictionary cOSObject = actualPdPropBuild.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdPropBuild.getApp());
    assertNull(actualPdPropBuild.getFilter());
    assertNull(actualPdPropBuild.getPubSec());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Test {@link PDPropBuild#PDPropBuild(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return App is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#PDPropBuild(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPropBuild(COSDictionary); when COSDictionary(); then return App is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.<init>(COSDictionary)"})
  void testNewPDPropBuild_whenCOSDictionary_thenReturnAppIsNull() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDPropBuild actualPdPropBuild = new PDPropBuild(dict);

    // Assert
    assertNull(actualPdPropBuild.getApp());
    assertNull(actualPdPropBuild.getFilter());
    assertNull(actualPdPropBuild.getPubSec());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdPropBuild.getCOSObject());
  }

  /**
   * Test {@link PDPropBuild#getCOSObject()}.
   * <p>
   * Method under test: {@link PDPropBuild#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDPropBuild.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDPropBuild()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCOSObject.isDirect());
  }

  /**
   * Test {@link PDPropBuild#getFilter()}.
   * <ul>
   *   <li>Given {@link PDPropBuild#PDPropBuild()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDPropBuild(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropBuildDataDict PDPropBuild.getFilter()"})
  void testGetFilter_givenPDPropBuild_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPropBuild()).getFilter());
  }

  /**
   * Test {@link PDPropBuild#getFilter()}.
   * <ul>
   *   <li>Then return Date is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); then return Date is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropBuildDataDict PDPropBuild.getFilter()"})
  void testGetFilter_thenReturnDateIsNull() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();
    pdPropBuild.setPDPropBuildFilter(new PDPropBuildDataDict());

    // Act
    PDPropBuildDataDict actualFilter = pdPropBuild.getFilter();

    // Assert
    assertNull(actualFilter.getDate());
    assertNull(actualFilter.getName());
    assertNull(actualFilter.getOS());
    assertNull(actualFilter.getVersion());
    COSDictionary cOSObject = actualFilter.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualFilter.getMinimumRevision());
    assertEquals(-1L, actualFilter.getRevision());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(actualFilter.getPreRelease());
    assertFalse(actualFilter.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualFilter.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuild#setPDPropBuildFilter(PDPropBuildDataDict)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPropBuild#PDPropBuild()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#setPDPropBuildFilter(PDPropBuildDataDict)}
   */
  @Test
  @DisplayName("Test setPDPropBuildFilter(PDPropBuildDataDict); when 'null'; then PDPropBuild() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.setPDPropBuildFilter(PDPropBuildDataDict)"})
  void testSetPDPropBuildFilter_whenNull_thenPDPropBuildCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildFilter(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuild#setPDPropBuildFilter(PDPropBuildDataDict)}.
   * <ul>
   *   <li>When {@link PDPropBuildDataDict#PDPropBuildDataDict()}.</li>
   *   <li>Then {@link PDPropBuild#PDPropBuild()} Filter Date is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#setPDPropBuildFilter(PDPropBuildDataDict)}
   */
  @Test
  @DisplayName("Test setPDPropBuildFilter(PDPropBuildDataDict); when PDPropBuildDataDict(); then PDPropBuild() Filter Date is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.setPDPropBuildFilter(PDPropBuildDataDict)"})
  void testSetPDPropBuildFilter_whenPDPropBuildDataDict_thenPDPropBuildFilterDateIsNull() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildFilter(new PDPropBuildDataDict());

    // Assert
    PDPropBuildDataDict filter = pdPropBuild.getFilter();
    assertNull(filter.getDate());
    assertNull(filter.getName());
    assertNull(filter.getOS());
    assertNull(filter.getVersion());
    assertEquals(-1L, filter.getMinimumRevision());
    assertEquals(-1L, filter.getRevision());
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(filter.getPreRelease());
    assertFalse(filter.getTrustedMode());
    assertTrue(filter.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuild#getPubSec()}.
   * <ul>
   *   <li>Given {@link PDPropBuild#PDPropBuild()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#getPubSec()}
   */
  @Test
  @DisplayName("Test getPubSec(); given PDPropBuild(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropBuildDataDict PDPropBuild.getPubSec()"})
  void testGetPubSec_givenPDPropBuild_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPropBuild()).getPubSec());
  }

  /**
   * Test {@link PDPropBuild#getPubSec()}.
   * <ul>
   *   <li>Then return Date is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#getPubSec()}
   */
  @Test
  @DisplayName("Test getPubSec(); then return Date is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropBuildDataDict PDPropBuild.getPubSec()"})
  void testGetPubSec_thenReturnDateIsNull() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();
    pdPropBuild.setPDPropBuildPubSec(new PDPropBuildDataDict());

    // Act
    PDPropBuildDataDict actualPubSec = pdPropBuild.getPubSec();

    // Assert
    assertNull(actualPubSec.getDate());
    assertNull(actualPubSec.getName());
    assertNull(actualPubSec.getOS());
    assertNull(actualPubSec.getVersion());
    COSDictionary cOSObject = actualPubSec.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualPubSec.getMinimumRevision());
    assertEquals(-1L, actualPubSec.getRevision());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(actualPubSec.getPreRelease());
    assertFalse(actualPubSec.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualPubSec.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuild#setPDPropBuildPubSec(PDPropBuildDataDict)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPropBuild#PDPropBuild()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#setPDPropBuildPubSec(PDPropBuildDataDict)}
   */
  @Test
  @DisplayName("Test setPDPropBuildPubSec(PDPropBuildDataDict); when 'null'; then PDPropBuild() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.setPDPropBuildPubSec(PDPropBuildDataDict)"})
  void testSetPDPropBuildPubSec_whenNull_thenPDPropBuildCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildPubSec(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuild#setPDPropBuildPubSec(PDPropBuildDataDict)}.
   * <ul>
   *   <li>When {@link PDPropBuildDataDict#PDPropBuildDataDict()}.</li>
   *   <li>Then {@link PDPropBuild#PDPropBuild()} PubSec Date is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#setPDPropBuildPubSec(PDPropBuildDataDict)}
   */
  @Test
  @DisplayName("Test setPDPropBuildPubSec(PDPropBuildDataDict); when PDPropBuildDataDict(); then PDPropBuild() PubSec Date is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.setPDPropBuildPubSec(PDPropBuildDataDict)"})
  void testSetPDPropBuildPubSec_whenPDPropBuildDataDict_thenPDPropBuildPubSecDateIsNull() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildPubSec(new PDPropBuildDataDict());

    // Assert
    PDPropBuildDataDict pubSec = pdPropBuild.getPubSec();
    assertNull(pubSec.getDate());
    assertNull(pubSec.getName());
    assertNull(pubSec.getOS());
    assertNull(pubSec.getVersion());
    assertEquals(-1L, pubSec.getMinimumRevision());
    assertEquals(-1L, pubSec.getRevision());
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pubSec.getPreRelease());
    assertFalse(pubSec.getTrustedMode());
    assertTrue(pubSec.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuild#getApp()}.
   * <ul>
   *   <li>Given {@link PDPropBuild#PDPropBuild()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#getApp()}
   */
  @Test
  @DisplayName("Test getApp(); given PDPropBuild(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropBuildDataDict PDPropBuild.getApp()"})
  void testGetApp_givenPDPropBuild_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPropBuild()).getApp());
  }

  /**
   * Test {@link PDPropBuild#getApp()}.
   * <ul>
   *   <li>Then return Date is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#getApp()}
   */
  @Test
  @DisplayName("Test getApp(); then return Date is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropBuildDataDict PDPropBuild.getApp()"})
  void testGetApp_thenReturnDateIsNull() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();
    pdPropBuild.setPDPropBuildApp(new PDPropBuildDataDict());

    // Act
    PDPropBuildDataDict actualApp = pdPropBuild.getApp();

    // Assert
    assertNull(actualApp.getDate());
    assertNull(actualApp.getName());
    assertNull(actualApp.getOS());
    assertNull(actualApp.getVersion());
    COSDictionary cOSObject = actualApp.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualApp.getMinimumRevision());
    assertEquals(-1L, actualApp.getRevision());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(actualApp.getPreRelease());
    assertFalse(actualApp.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualApp.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuild#setPDPropBuildApp(PDPropBuildDataDict)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPropBuild#PDPropBuild()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#setPDPropBuildApp(PDPropBuildDataDict)}
   */
  @Test
  @DisplayName("Test setPDPropBuildApp(PDPropBuildDataDict); when 'null'; then PDPropBuild() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.setPDPropBuildApp(PDPropBuildDataDict)"})
  void testSetPDPropBuildApp_whenNull_thenPDPropBuildCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildApp(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuild#setPDPropBuildApp(PDPropBuildDataDict)}.
   * <ul>
   *   <li>When {@link PDPropBuildDataDict#PDPropBuildDataDict()}.</li>
   *   <li>Then {@link PDPropBuild#PDPropBuild()} App Date is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPropBuild#setPDPropBuildApp(PDPropBuildDataDict)}
   */
  @Test
  @DisplayName("Test setPDPropBuildApp(PDPropBuildDataDict); when PDPropBuildDataDict(); then PDPropBuild() App Date is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPropBuild.setPDPropBuildApp(PDPropBuildDataDict)"})
  void testSetPDPropBuildApp_whenPDPropBuildDataDict_thenPDPropBuildAppDateIsNull() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildApp(new PDPropBuildDataDict());

    // Assert
    PDPropBuildDataDict app = pdPropBuild.getApp();
    assertNull(app.getDate());
    assertNull(app.getName());
    assertNull(app.getOS());
    assertNull(app.getVersion());
    assertEquals(-1L, app.getMinimumRevision());
    assertEquals(-1L, app.getRevision());
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(app.getPreRelease());
    assertFalse(app.getTrustedMode());
    assertTrue(app.getNonEFontNoWarn());
  }
}
