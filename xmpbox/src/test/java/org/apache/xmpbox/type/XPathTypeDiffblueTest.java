package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XPathTypeDiffblueTest {
  /**
   * Test {@link XPathType#XPathType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link XPathType#XPathType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new XPathType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XPathType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewXPathType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new XPathType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link XPathType#XPathType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Namespace is {@code Namespace URI}.
   * </ul>
   *
   * <p>Method under test: {@link XPathType#XPathType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new XPathType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XPathType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewXPathType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XPathType actualXPathType =
        new XPathType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualXPathType.getNamespace());
    assertEquals("Prefix", actualXPathType.getPrefix());
    assertEquals("Property Name", actualXPathType.getPropertyName());
    assertEquals("Value", actualXPathType.getStringValue());
    assertEquals("Value", actualXPathType.getRawValue());
    assertEquals("Value", actualXPathType.getValue());
    assertTrue(actualXPathType.getAllAttributes().isEmpty());
    assertSame(metadata, actualXPathType.getMetadata());
  }
}
