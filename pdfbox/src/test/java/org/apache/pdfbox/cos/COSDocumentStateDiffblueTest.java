package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSDocumentStateDiffblueTest {
  /**
   * Test {@link COSDocumentState#isAcceptingUpdates()}.
   * <ul>
   *   <li>Given {@link COSDocumentState} (default constructor) Parsing is {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocumentState#isAcceptingUpdates()}
   */
  @Test
  @DisplayName("Test isAcceptingUpdates(); given COSDocumentState (default constructor) Parsing is 'false'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSDocumentState.isAcceptingUpdates()"})
  void testIsAcceptingUpdates_givenCOSDocumentStateParsingIsFalse_thenReturnTrue() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(false);

    // Act and Assert
    assertTrue(cosDocumentState.isAcceptingUpdates());
  }

  /**
   * Test {@link COSDocumentState#isAcceptingUpdates()}.
   * <ul>
   *   <li>Given {@link COSDocumentState} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocumentState#isAcceptingUpdates()}
   */
  @Test
  @DisplayName("Test isAcceptingUpdates(); given COSDocumentState (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSDocumentState.isAcceptingUpdates()"})
  void testIsAcceptingUpdates_givenCOSDocumentState_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSDocumentState()).isAcceptingUpdates());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link COSDocumentState}
   *   <li>{@link COSDocumentState#setParsing(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocumentState.<init>()", "void COSDocumentState.setParsing(boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    COSDocumentState actualCosDocumentState = new COSDocumentState();
    actualCosDocumentState.setParsing(true);

    // Assert
    assertFalse(actualCosDocumentState.isAcceptingUpdates());
  }
}
