package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class LocaleTypeDiffblueTest {
  /**
   * Method under test:
   * {@link LocaleType#LocaleType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewLocaleType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    LocaleType actualLocaleType = new LocaleType(metadata, "en", "en", "en", "Value");

    // Assert
    assertEquals("Value", actualLocaleType.getStringValue());
    assertEquals("Value", actualLocaleType.getRawValue());
    assertEquals("Value", actualLocaleType.getValue());
    assertEquals("en", actualLocaleType.getPropertyName());
    assertEquals("en", actualLocaleType.getNamespace());
    assertEquals("en", actualLocaleType.getPrefix());
    assertTrue(actualLocaleType.getAllAttributes().isEmpty());
    assertSame(metadata, actualLocaleType.getMetadata());
  }
}
