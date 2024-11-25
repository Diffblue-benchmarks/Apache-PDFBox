package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractFieldDiffblueTest {
  /**
   * Test {@link AbstractField#getPropertyName()}.
   * <p>
   * Method under test: {@link AbstractField#getPropertyName()}
   */
  @Test
  @DisplayName("Test getPropertyName()")
  void testGetPropertyName() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPropertyName());
  }

  /**
   * Test {@link AbstractField#setPropertyName(String)}.
   * <p>
   * Method under test: {@link AbstractField#setPropertyName(String)}
   */
  @Test
  @DisplayName("Test setPropertyName(String)")
  void testSetPropertyName() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setPropertyName("42");

    // Assert
    assertEquals("42", adobePDFSchema.getPropertyName());
  }

  /**
   * Test {@link AbstractField#setAttribute(Attribute)}.
   * <p>
   * Method under test: {@link AbstractField#setAttribute(Attribute)}
   */
  @Test
  @DisplayName("Test setAttribute(Attribute)")
  void testSetAttribute() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    Attribute value = new Attribute("Ns URI", "Local Name", "42");

    // Act
    adobePDFSchema.setAttribute(value);

    // Assert
    List<Attribute> allAttributes = adobePDFSchema.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertSame(value, allAttributes.get(0));
  }

  /**
   * Test {@link AbstractField#containsAttribute(String)}.
   * <p>
   * Method under test: {@link AbstractField#containsAttribute(String)}
   */
  @Test
  @DisplayName("Test containsAttribute(String)")
  void testContainsAttribute() {
    // Arrange, Act and Assert
    assertFalse((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).containsAttribute("Qualified Name"));
  }

  /**
   * Test {@link AbstractField#getAttribute(String)}.
   * <p>
   * Method under test: {@link AbstractField#getAttribute(String)}
   */
  @Test
  @DisplayName("Test getAttribute(String)")
  void testGetAttribute() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAttribute("Qualified Name"));
  }

  /**
   * Test {@link AbstractField#getAllAttributes()}.
   * <p>
   * Method under test: {@link AbstractField#getAllAttributes()}
   */
  @Test
  @DisplayName("Test getAllAttributes()")
  void testGetAllAttributes() {
    // Arrange, Act and Assert
    assertTrue((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAllAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractField#getMetadata()}.
   * <p>
   * Method under test: {@link AbstractField#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata()")
  void testGetMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act and Assert
    assertSame(metadata, (new AdobePDFSchema(metadata)).getMetadata());
  }
}
