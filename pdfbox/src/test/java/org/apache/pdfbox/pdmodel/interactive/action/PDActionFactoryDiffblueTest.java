package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDActionFactoryDiffblueTest {
  /**
   * Method under test: {@link PDActionFactory#createAction(COSDictionary)}
   */
  @Test
  void testCreateAction() {
    // Arrange, Act and Assert
    assertNull(PDActionFactory.createAction(new COSDictionary()));
    assertNull(PDActionFactory.createAction(null));
  }
}
