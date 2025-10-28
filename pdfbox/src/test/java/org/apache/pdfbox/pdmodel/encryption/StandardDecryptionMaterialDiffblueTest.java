package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StandardDecryptionMaterialDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StandardDecryptionMaterial#StandardDecryptionMaterial(String)}
   *   <li>{@link StandardDecryptionMaterial#getPassword()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Pwd", (new StandardDecryptionMaterial("Pwd")).getPassword());
  }
}
