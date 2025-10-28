package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.Test;

class AbstractFieldDiffblueTest {
  /**
   * Method under test: {@link AbstractField#getPropertyName()}
   */
  @Test
  void testGetPropertyName() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPropertyName());
  }

  /**
   * Method under test: {@link AbstractField#setPropertyName(String)}
   */
  @Test
  void testSetPropertyName() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setPropertyName("42");

    // Assert
    assertEquals("42", adobePDFSchema.getPropertyName());
  }

  /**
   * Method under test: {@link AbstractField#setAttribute(Attribute)}
   */
  @Test
  void testSetAttribute() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    Attribute value = new Attribute("Ns URI", "Local Name", "42");

    // Act
    adobePDFSchema.setAttribute(value);

    // Assert
    List<Attribute> allAttributes = adobePDFSchema.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertSame(value, allAttributes.get(0));
    assertSame(metadata, adobePDFSchema.getMetadata());
  }

  /**
   * Method under test: {@link AbstractField#containsAttribute(String)}
   */
  @Test
  void testContainsAttribute() {
    // Arrange, Act and Assert
    assertFalse((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).containsAttribute("Qualified Name"));
  }

  /**
   * Method under test: {@link AbstractField#getAttribute(String)}
   */
  @Test
  void testGetAttribute() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAttribute("Qualified Name"));
  }

  /**
   * Method under test: {@link AbstractField#getAllAttributes()}
   */
  @Test
  void testGetAllAttributes() {
    // Arrange, Act and Assert
    assertTrue((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAllAttributes().isEmpty());
  }

  /**
   * Method under test: {@link AbstractField#getMetadata()}
   */
  @Test
  void testGetMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act and Assert
    assertSame(metadata, (new AdobePDFSchema(metadata)).getMetadata());
  }
}
