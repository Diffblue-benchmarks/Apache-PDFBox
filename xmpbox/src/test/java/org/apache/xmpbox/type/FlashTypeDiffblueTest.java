package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlashTypeDiffblueTest {
  /**
   * Test {@link FlashType#FlashType(XMPMetadata)}.
   * <p>
   * Method under test: {@link FlashType#FlashType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new FlashType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FlashType.<init>(XMPMetadata)"})
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
    assertTrue(actualFlashType.getAllProperties().isEmpty());
    assertTrue(actualFlashType.getAllAttributes().isEmpty());
    assertTrue(actualFlashType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualFlashType.getMetadata());
  }
}
