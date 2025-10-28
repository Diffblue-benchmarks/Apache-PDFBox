package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.junit.jupiter.api.Test;

class XMPageTextSchemaDiffblueTest {
  /**
   * Method under test: {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata)}
   */
  @Test
  void testNewXMPageTextSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPageTextSchema actualXmPageTextSchema = new XMPageTextSchema(metadata);

    // Assert
    assertEquals("", actualXmPageTextSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/t/pg/", actualXmPageTextSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmPageTextSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpTPg", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/t/pg/"));
    assertEquals("xmpTPg", actualXmPageTextSchema.getPreferedPrefix());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPrefix());
    assertNull(actualXmPageTextSchema.getPropertyName());
    assertNull(actualXmPageTextSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmPageTextSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmPageTextSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmPageTextSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmPageTextSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata, String)}
   */
  @Test
  void testNewXMPageTextSchema2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPageTextSchema actualXmPageTextSchema = new XMPageTextSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualXmPageTextSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualXmPageTextSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/t/pg/"));
    assertEquals("Prefix", actualXmPageTextSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/t/pg/", actualXmPageTextSchema.getNamespace());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPreferedPrefix());
    assertNull(actualXmPageTextSchema.getPropertyName());
    assertNull(actualXmPageTextSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmPageTextSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmPageTextSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmPageTextSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmPageTextSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata, String)}
   */
  @Test
  void testNewXMPageTextSchema3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPageTextSchema actualXmPageTextSchema = new XMPageTextSchema(metadata, null);

    // Assert
    assertEquals("", actualXmPageTextSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/t/pg/", actualXmPageTextSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmPageTextSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpTPg", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/t/pg/"));
    assertEquals("xmpTPg", actualXmPageTextSchema.getPreferedPrefix());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPrefix());
    assertNull(actualXmPageTextSchema.getPropertyName());
    assertNull(actualXmPageTextSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmPageTextSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmPageTextSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmPageTextSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmPageTextSchema.getMetadata());
  }
}
