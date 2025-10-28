package org.apache.pdfbox.pdmodel.graphics.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;

class PDTransparencyGroupAttributesDiffblueTest {
  /**
   * Method under test: {@link PDTransparencyGroupAttributes#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDTransparencyGroupAttributes()).getCOSObject();

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
   * Method under test: {@link PDTransparencyGroupAttributes#getColorSpace()}
   */
  @Test
  void testGetColorSpace() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTransparencyGroupAttributes()).getColorSpace());
  }

  /**
   * Method under test:
   * {@link PDTransparencyGroupAttributes#getColorSpace(PDResources)}
   */
  @Test
  void testGetColorSpace2() throws IOException {
    // Arrange
    PDTransparencyGroupAttributes pdTransparencyGroupAttributes = new PDTransparencyGroupAttributes();

    // Act and Assert
    assertNull(pdTransparencyGroupAttributes.getColorSpace(new PDResources()));
  }

  /**
   * Method under test: {@link PDTransparencyGroupAttributes#isIsolated()}
   */
  @Test
  void testIsIsolated() {
    // Arrange, Act and Assert
    assertFalse((new PDTransparencyGroupAttributes()).isIsolated());
  }

  /**
   * Method under test: {@link PDTransparencyGroupAttributes#isKnockout()}
   */
  @Test
  void testIsKnockout() {
    // Arrange, Act and Assert
    assertFalse((new PDTransparencyGroupAttributes()).isKnockout());
  }

  /**
   * Method under test:
   * {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes(COSDictionary)}
   */
  @Test
  void testNewPDTransparencyGroupAttributes() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDTransparencyGroupAttributes(dic)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}
   */
  @Test
  void testNewPDTransparencyGroupAttributes2() throws IOException {
    // Arrange and Act
    PDTransparencyGroupAttributes actualPdTransparencyGroupAttributes = new PDTransparencyGroupAttributes();

    // Assert
    COSDictionary cOSObject = actualPdTransparencyGroupAttributes.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdTransparencyGroupAttributes.getColorSpace());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdTransparencyGroupAttributes.isIsolated());
    assertFalse(actualPdTransparencyGroupAttributes.isKnockout());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
