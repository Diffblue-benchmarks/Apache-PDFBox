package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RationalTypeDiffblueTest {
  /**
   * Test {@link RationalType#RationalType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RationalType#RationalType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new RationalType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RationalType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewRationalType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RationalType actualRationalType = new RationalType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualRationalType.getNamespace());
    assertEquals("Prefix", actualRationalType.getPrefix());
    assertEquals("Property Name", actualRationalType.getPropertyName());
    assertEquals("Value", actualRationalType.getStringValue());
    assertEquals("Value", actualRationalType.getRawValue());
    assertEquals("Value", actualRationalType.getValue());
    assertTrue(actualRationalType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRationalType.getMetadata());
  }
}
