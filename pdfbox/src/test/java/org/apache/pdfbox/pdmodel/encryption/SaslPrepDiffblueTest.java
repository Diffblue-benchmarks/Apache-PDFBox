package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SaslPrepDiffblueTest {
  /**
   * Method under test: {@link SaslPrep#saslPrepQuery(String)}
   */
  @Test
  void testSaslPrepQuery() {
    // Arrange, Act and Assert
    assertEquals("Str", SaslPrep.saslPrepQuery("Str"));
    assertEquals("42", SaslPrep.saslPrepQuery("42"));
  }

  /**
   * Method under test: {@link SaslPrep#saslPrepStored(String)}
   */
  @Test
  void testSaslPrepStored() {
    // Arrange, Act and Assert
    assertEquals("Str", SaslPrep.saslPrepStored("Str"));
    assertEquals("42", SaslPrep.saslPrepStored("42"));
  }

  /**
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  void testProhibited() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1));
    assertTrue(SaslPrep.prohibited(128));
    assertTrue(SaslPrep.prohibited(Float.MAX_EXPONENT));
    assertTrue(SaslPrep.prohibited(160));
    assertTrue(SaslPrep.prohibited(1757));
    assertTrue(SaslPrep.prohibited(1807));
    assertTrue(SaslPrep.prohibited(6158));
    assertTrue(SaslPrep.prohibited(8204));
    assertTrue(SaslPrep.prohibited(8205));
    assertTrue(SaslPrep.prohibited(8232));
    assertTrue(SaslPrep.prohibited(8233));
    assertTrue(SaslPrep.prohibited(8288));
    assertTrue(SaslPrep.prohibited(8289));
    assertTrue(SaslPrep.prohibited(8290));
    assertTrue(SaslPrep.prohibited(8291));
    assertTrue(SaslPrep.prohibited(8298));
    assertFalse(SaslPrep.prohibited(8297));
    assertFalse(SaslPrep.prohibited(8304));
    assertTrue(SaslPrep.prohibited(65279));
    assertTrue(SaslPrep.prohibited(65529));
    assertFalse(SaslPrep.prohibited(65528));
    assertTrue(SaslPrep.prohibited(65533));
    assertTrue(SaslPrep.prohibited(119155));
    assertFalse(SaslPrep.prohibited(119154));
    assertFalse(SaslPrep.prohibited(119163));
    assertTrue(SaslPrep.prohibited(57344));
    assertTrue(SaslPrep.prohibited(57343));
    assertTrue(SaslPrep.prohibited(983039));
    assertTrue(SaslPrep.prohibited(1048573));
    assertTrue(SaslPrep.prohibited(1048574));
    assertTrue(SaslPrep.prohibited(1114109));
    assertTrue(SaslPrep.prohibited(1114110));
    assertTrue(SaslPrep.prohibited(64976));
    assertTrue(SaslPrep.prohibited(65534));
    assertTrue(SaslPrep.prohibited(131070));
    assertTrue(SaslPrep.prohibited(5760));
    assertTrue(SaslPrep.prohibited(8192));
    assertTrue(SaslPrep.prohibited(8239));
    assertTrue(SaslPrep.prohibited(8287));
    assertFalse(SaslPrep.prohibited(-1));
    assertTrue(SaslPrep.prohibited(12288));
  }
}
