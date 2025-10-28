package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDDocumentNameDestinationDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDDocumentNameDestinationDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDDocumentNameDestinationDictionary(dict)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentNameDestinationDictionary#PDDocumentNameDestinationDictionary(COSDictionary)}
   */
  @Test
  void testNewPDDocumentNameDestinationDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDDocumentNameDestinationDictionary(dict)).getCOSObject());
  }
}
