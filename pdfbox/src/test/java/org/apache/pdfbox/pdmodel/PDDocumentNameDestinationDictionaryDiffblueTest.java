package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDocumentNameDestinationDictionaryDiffblueTest {
  /**
   * Test
   * {@link PDDocumentNameDestinationDictionary#PDDocumentNameDestinationDictionary(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDocumentNameDestinationDictionary#PDDocumentNameDestinationDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentNameDestinationDictionary(COSDictionary)")
  void testNewPDDocumentNameDestinationDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDDocumentNameDestinationDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDDocumentNameDestinationDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link PDDocumentNameDestinationDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDDocumentNameDestinationDictionary(dict)).getCOSObject());
  }
}
