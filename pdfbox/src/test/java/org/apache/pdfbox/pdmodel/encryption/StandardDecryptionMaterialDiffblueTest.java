package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StandardDecryptionMaterialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StandardDecryptionMaterial#StandardDecryptionMaterial(String)}
   *   <li>{@link StandardDecryptionMaterial#getPassword()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Pwd", (new StandardDecryptionMaterial("Pwd")).getPassword());
  }
}
