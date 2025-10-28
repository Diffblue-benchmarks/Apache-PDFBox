package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDPrintFieldAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDPrintFieldAttributeObject#getRole()}
   */
  @Test
  void testGetRole() {
    // Arrange, Act and Assert
    assertNull((new PDPrintFieldAttributeObject()).getRole());
  }

  /**
   * Method under test: {@link PDPrintFieldAttributeObject#setRole(String)}
   */
  @Test
  void testSetRole() {
    // Arrange
    PDPrintFieldAttributeObject pdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Act
    pdPrintFieldAttributeObject.setRole("Role");

    // Assert
    assertEquals("Role", pdPrintFieldAttributeObject.getRole());
    COSDictionary cOSObject = pdPrintFieldAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdPrintFieldAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDPrintFieldAttributeObject#getCheckedState()}
   */
  @Test
  void testGetCheckedState() {
    // Arrange, Act and Assert
    assertEquals(PDPrintFieldAttributeObject.CHECKED_STATE_OFF, (new PDPrintFieldAttributeObject()).getCheckedState());
  }

  /**
   * Method under test:
   * {@link PDPrintFieldAttributeObject#setCheckedState(String)}
   */
  @Test
  void testSetCheckedState() {
    // Arrange
    PDPrintFieldAttributeObject pdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Act
    pdPrintFieldAttributeObject.setCheckedState("Checked State");

    // Assert
    assertEquals("Checked State", pdPrintFieldAttributeObject.getCheckedState());
    COSDictionary cOSObject = pdPrintFieldAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdPrintFieldAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDPrintFieldAttributeObject#getAlternateName()}
   */
  @Test
  void testGetAlternateName() {
    // Arrange, Act and Assert
    assertNull((new PDPrintFieldAttributeObject()).getAlternateName());
  }

  /**
   * Method under test:
   * {@link PDPrintFieldAttributeObject#setAlternateName(String)}
   */
  @Test
  void testSetAlternateName() {
    // Arrange
    PDPrintFieldAttributeObject pdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Act
    pdPrintFieldAttributeObject.setAlternateName("Alternate Name");

    // Assert
    assertEquals("Alternate Name", pdPrintFieldAttributeObject.getAlternateName());
    COSDictionary cOSObject = pdPrintFieldAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdPrintFieldAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDPrintFieldAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=PrintField", (new PDPrintFieldAttributeObject()).toString());
  }

  /**
   * Method under test:
   * {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject(COSDictionary)}
   */
  @Test
  void testNewPDPrintFieldAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDPrintFieldAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}
   */
  @Test
  void testNewPDPrintFieldAttributeObject2() {
    // Arrange and Act
    PDPrintFieldAttributeObject actualPdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Assert
    assertNull(actualPdPrintFieldAttributeObject.getAlternateName());
    assertNull(actualPdPrintFieldAttributeObject.getRole());
    COSDictionary cOSObject = actualPdPrintFieldAttributeObject.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdPrintFieldAttributeObject.isEmpty());
    assertEquals(PDPrintFieldAttributeObject.CHECKED_STATE_OFF, actualPdPrintFieldAttributeObject.getCheckedState());
    assertEquals(PDPrintFieldAttributeObject.OWNER_PRINT_FIELD, actualPdPrintFieldAttributeObject.getOwner());
  }
}
