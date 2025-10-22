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

class CFAPatternTypeDiffblueTest {
  /**
   * Test {@link CFAPatternType#CFAPatternType(XMPMetadata)}.
   * <p>
   * Method under test: {@link CFAPatternType#CFAPatternType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new CFAPatternType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFAPatternType.<init>(XMPMetadata)"})
  void testNewCFAPatternType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    CFAPatternType actualCfaPatternType = new CFAPatternType(metadata);

    // Assert
    assertEquals("exif", actualCfaPatternType.getPreferedPrefix());
    assertEquals("exif", actualCfaPatternType.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualCfaPatternType.getNamespace());
    assertNull(actualCfaPatternType.getPropertyName());
    assertTrue(actualCfaPatternType.getAllProperties().isEmpty());
    assertTrue(actualCfaPatternType.getAllAttributes().isEmpty());
    assertTrue(actualCfaPatternType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualCfaPatternType.getMetadata());
  }
}
