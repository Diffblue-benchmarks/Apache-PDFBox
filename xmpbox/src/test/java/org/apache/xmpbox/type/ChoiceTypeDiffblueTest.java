package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChoiceTypeDiffblueTest {
  /**
   * Test {@link ChoiceType#ChoiceType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChoiceType#ChoiceType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new ChoiceType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChoiceType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewChoiceType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ChoiceType actualChoiceType = new ChoiceType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualChoiceType.getNamespace());
    assertEquals("Prefix", actualChoiceType.getPrefix());
    assertEquals("Property Name", actualChoiceType.getPropertyName());
    assertEquals("Value", actualChoiceType.getStringValue());
    assertEquals("Value", actualChoiceType.getRawValue());
    assertEquals("Value", actualChoiceType.getValue());
    assertTrue(actualChoiceType.getAllAttributes().isEmpty());
    assertSame(metadata, actualChoiceType.getMetadata());
  }
}
