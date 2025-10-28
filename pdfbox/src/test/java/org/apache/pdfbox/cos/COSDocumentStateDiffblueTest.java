package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class COSDocumentStateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link COSDocumentState}
   *   <li>{@link COSDocumentState#setParsing(boolean)}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    COSDocumentState actualCosDocumentState = new COSDocumentState();
    actualCosDocumentState.setParsing(true);

    // Assert
    assertFalse(actualCosDocumentState.isAcceptingUpdates());
  }

  /**
   * Method under test: {@link COSDocumentState#isAcceptingUpdates()}
   */
  @Test
  void testIsAcceptingUpdates() {
    // Arrange, Act and Assert
    assertFalse((new COSDocumentState()).isAcceptingUpdates());
  }

  /**
   * Method under test: {@link COSDocumentState#isAcceptingUpdates()}
   */
  @Test
  void testIsAcceptingUpdates2() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(false);

    // Act and Assert
    assertTrue(cosDocumentState.isAcceptingUpdates());
  }
}
