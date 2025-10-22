package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractSimplePropertyDiffblueTest {
  /**
   * Test {@link AbstractSimpleProperty#getRawValue()}.
   * <p>
   * Method under test: {@link AbstractSimpleProperty#getRawValue()}
   */
  @Test
  @DisplayName("Test getRawValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object AbstractSimpleProperty.getRawValue()"})
  void testGetRawValue() {
    // Arrange, Act and Assert
    assertEquals("Value",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .getRawValue());
  }

  /**
   * Test {@link AbstractSimpleProperty#toString()}.
   * <p>
   * Method under test: {@link AbstractSimpleProperty#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractSimpleProperty.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[AgentNameType:Value]",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .toString());
  }

  /**
   * Test {@link AbstractSimpleProperty#getNamespace()}.
   * <p>
   * Method under test: {@link AbstractSimpleProperty#getNamespace()}
   */
  @Test
  @DisplayName("Test getNamespace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractSimpleProperty.getNamespace()"})
  void testGetNamespace() {
    // Arrange, Act and Assert
    assertEquals("Namespace URI",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .getNamespace());
  }

  /**
   * Test {@link AbstractSimpleProperty#getPrefix()}.
   * <p>
   * Method under test: {@link AbstractSimpleProperty#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractSimpleProperty.getPrefix()"})
  void testGetPrefix() {
    // Arrange, Act and Assert
    assertEquals("Prefix",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .getPrefix());
  }
}
