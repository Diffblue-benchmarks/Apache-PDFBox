package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GUIDTypeDiffblueTest {
  /**
   * Test {@link GUIDType#GUIDType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GUIDType#GUIDType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new GUIDType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GUIDType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewGUIDType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    GUIDType actualGuidType = new GUIDType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualGuidType.getNamespace());
    assertEquals("Prefix", actualGuidType.getPrefix());
    assertEquals("Property Name", actualGuidType.getPropertyName());
    assertEquals("Value", actualGuidType.getStringValue());
    assertEquals("Value", actualGuidType.getRawValue());
    assertEquals("Value", actualGuidType.getValue());
    assertTrue(actualGuidType.getAllAttributes().isEmpty());
    assertSame(metadata, actualGuidType.getMetadata());
  }
}
