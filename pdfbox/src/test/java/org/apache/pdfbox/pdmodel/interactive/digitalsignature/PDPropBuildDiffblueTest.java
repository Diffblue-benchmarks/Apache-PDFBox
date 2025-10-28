package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDPropBuildDiffblueTest {
  /**
   * Method under test: {@link PDPropBuild#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDPropBuild#getFilter()}
   */
  @Test
  void testGetFilter() {
    // Arrange, Act and Assert
    assertNull((new PDPropBuild()).getFilter());
  }

  /**
   * Method under test: {@link PDPropBuild#getFilter()}
   */
  @Test
  void testGetFilter2() {
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualFilter.getMinimumRevision());
    assertEquals(-1L, actualFilter.getRevision());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFilter.getPreRelease());
    assertFalse(actualFilter.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualFilter.getNonEFontNoWarn());
  }

  /**
   * Method under test:
   * {@link PDPropBuild#setPDPropBuildFilter(PDPropBuildDataDict)}
   */
  @Test
  void testSetPDPropBuildFilter() {
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
   * Method under test:
   * {@link PDPropBuild#setPDPropBuildFilter(PDPropBuildDataDict)}
   */
  @Test
  void testSetPDPropBuildFilter2() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildFilter(null);

    // Assert
    assertNull(pdPropBuild.getFilter());
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPropBuild#getPubSec()}
   */
  @Test
  void testGetPubSec() {
    // Arrange, Act and Assert
    assertNull((new PDPropBuild()).getPubSec());
  }

  /**
   * Method under test: {@link PDPropBuild#getPubSec()}
   */
  @Test
  void testGetPubSec2() {
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualPubSec.getMinimumRevision());
    assertEquals(-1L, actualPubSec.getRevision());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPubSec.getPreRelease());
    assertFalse(actualPubSec.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualPubSec.getNonEFontNoWarn());
  }

  /**
   * Method under test:
   * {@link PDPropBuild#setPDPropBuildPubSec(PDPropBuildDataDict)}
   */
  @Test
  void testSetPDPropBuildPubSec() {
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
   * Method under test:
   * {@link PDPropBuild#setPDPropBuildPubSec(PDPropBuildDataDict)}
   */
  @Test
  void testSetPDPropBuildPubSec2() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildPubSec(null);

    // Assert
    assertNull(pdPropBuild.getPubSec());
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPropBuild#getApp()}
   */
  @Test
  void testGetApp() {
    // Arrange, Act and Assert
    assertNull((new PDPropBuild()).getApp());
  }

  /**
   * Method under test: {@link PDPropBuild#getApp()}
   */
  @Test
  void testGetApp2() {
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualApp.getMinimumRevision());
    assertEquals(-1L, actualApp.getRevision());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualApp.getPreRelease());
    assertFalse(actualApp.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualApp.getNonEFontNoWarn());
  }

  /**
   * Method under test: {@link PDPropBuild#setPDPropBuildApp(PDPropBuildDataDict)}
   */
  @Test
  void testSetPDPropBuildApp() {
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

  /**
   * Method under test: {@link PDPropBuild#setPDPropBuildApp(PDPropBuildDataDict)}
   */
  @Test
  void testSetPDPropBuildApp2() {
    // Arrange
    PDPropBuild pdPropBuild = new PDPropBuild();

    // Act
    pdPropBuild.setPDPropBuildApp(null);

    // Assert
    assertNull(pdPropBuild.getApp());
    COSDictionary cOSObject = pdPropBuild.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPropBuild#PDPropBuild()}
   */
  @Test
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
   * Method under test: {@link PDPropBuild#PDPropBuild(COSDictionary)}
   */
  @Test
  void testNewPDPropBuild2() {
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
}
