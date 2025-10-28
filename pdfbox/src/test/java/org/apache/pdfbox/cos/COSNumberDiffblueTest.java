package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class COSNumberDiffblueTest {
  /**
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  void testGet() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> COSNumber.get("+"));
    assertThrows(IOException.class, () -> COSNumber.get("--"));
    assertThrows(IOException.class, () -> COSNumber.get("++"));
  }

  /**
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  void testGet2() throws IOException {
    // Arrange and Act
    COSNumber actualGetResult = COSNumber.get("9");

    // Assert
    assertTrue(actualGetResult instanceof COSInteger);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(((COSInteger) actualGetResult).isValid());
  }

  /**
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  void testGet3() throws IOException {
    // Arrange and Act
    COSNumber actualGetResult = COSNumber.get("4242");

    // Assert
    assertTrue(actualGetResult instanceof COSInteger);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(((COSInteger) actualGetResult).isValid());
  }

  /**
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  void testGet4() throws IOException {
    // Arrange and Act
    COSNumber actualGetResult = COSNumber.get("-4242");

    // Assert
    assertTrue(actualGetResult instanceof COSInteger);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(((COSInteger) actualGetResult).isValid());
  }
}
