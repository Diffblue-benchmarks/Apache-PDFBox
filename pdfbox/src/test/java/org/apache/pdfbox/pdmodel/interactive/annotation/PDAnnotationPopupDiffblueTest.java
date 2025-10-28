package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.Test;

class PDAnnotationPopupDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationPopup#setOpen(boolean)}
   */
  @Test
  void testSetOpen() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setOpen(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationPopup.getOpen());
  }

  /**
   * Method under test: {@link PDAnnotationPopup#setOpen(boolean)}
   */
  @Test
  void testSetOpen2() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setOpen(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationPopup.getOpen());
  }

  /**
   * Method under test: {@link PDAnnotationPopup#getOpen()}
   */
  @Test
  void testGetOpen() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationPopup()).getOpen());
  }

  /**
   * Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  void testSetParent() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup());

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  void testSetParent2() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup(dict));

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  void testSetParent3() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup(dict));

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationPopup#getParent()}
   */
  @Test
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPopup()).getParent());
  }
}
