package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlashTypeDiffblueTest {
  /**
   * Test {@link FlashType#FlashType(XMPMetadata)}.
   * <p>
   * Method under test: {@link FlashType#FlashType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new FlashType(XMPMetadata)")
  void testNewFlashType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    FlashType actualFlashType = new FlashType(metadata);

    // Assert
    assertEquals("exif", actualFlashType.getPreferedPrefix());
    assertEquals("exif", actualFlashType.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualFlashType.getNamespace());
    assertNull(actualFlashType.getPropertyName());
    List<AbstractField> allProperties = actualFlashType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualFlashType.getAllAttributes().isEmpty());
    assertTrue(actualFlashType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualFlashType.getContainer().getAllProperties());
    assertSame(metadata, actualFlashType.getMetadata());
  }
}
