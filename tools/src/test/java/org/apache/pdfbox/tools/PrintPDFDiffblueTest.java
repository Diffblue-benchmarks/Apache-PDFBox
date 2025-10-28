package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertSame;
import javax.print.attribute.standard.Sides;
import org.junit.jupiter.api.Test;

class PrintPDFDiffblueTest {
  /**
   * Method under test: {@link PrintPDF.Duplex#toSides()}
   */
  @Test
  void testDuplexToSides() {
    // Arrange and Act
    Sides actualToSidesResult = PrintPDF.Duplex.valueOf("SIMPLEX").toSides();

    // Assert
    assertSame(actualToSidesResult.ONE_SIDED, actualToSidesResult);
  }
}
