package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPageTextSchemaDiffblueTest {
  /**
   * Test {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPageTextSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPageTextSchema.<init>(XMPMetadata)"})
  void testNewXMPageTextSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPageTextSchema actualXmPageTextSchema = new XMPageTextSchema(metadata);

    // Assert
    assertEquals("", actualXmPageTextSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/t/pg/", actualXmPageTextSchema.getNamespace());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPreferedPrefix());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPrefix());
    assertNull(actualXmPageTextSchema.getPropertyName());
    assertNull(actualXmPageTextSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix =
        actualXmPageTextSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmPageTextSchema.getAllProperties().isEmpty());
    assertTrue(actualXmPageTextSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/t/pg/"));
    assertSame(metadata, actualXmPageTextSchema.getMetadata());
  }

  /**
   * Test {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code xmpTPg}.
   * </ul>
   *
   * <p>Method under test: {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new XMPageTextSchema(XMPMetadata, String); when 'null'; then return Prefix is 'xmpTPg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPageTextSchema.<init>(XMPMetadata, String)"})
  void testNewXMPageTextSchema_whenNull_thenReturnPrefixIsXmpTPg() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPageTextSchema actualXmPageTextSchema = new XMPageTextSchema(metadata, null);

    // Assert
    assertEquals("", actualXmPageTextSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/t/pg/", actualXmPageTextSchema.getNamespace());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPreferedPrefix());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPrefix());
    assertNull(actualXmPageTextSchema.getPropertyName());
    assertNull(actualXmPageTextSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix =
        actualXmPageTextSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmPageTextSchema.getAllProperties().isEmpty());
    assertTrue(actualXmPageTextSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/t/pg/"));
    assertSame(metadata, actualXmPageTextSchema.getMetadata());
  }

  /**
   * Test {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Prefix}.
   *   <li>Then return {@code Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link XMPageTextSchema#XMPageTextSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new XMPageTextSchema(XMPMetadata, String); when 'Prefix'; then return 'Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPageTextSchema.<init>(XMPMetadata, String)"})
  void testNewXMPageTextSchema_whenPrefix_thenReturnPrefix() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPageTextSchema actualXmPageTextSchema = new XMPageTextSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualXmPageTextSchema.getAboutValue());
    assertEquals("Prefix", actualXmPageTextSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/t/pg/", actualXmPageTextSchema.getNamespace());
    assertEquals("xmpTPg", actualXmPageTextSchema.getPreferedPrefix());
    assertNull(actualXmPageTextSchema.getPropertyName());
    assertNull(actualXmPageTextSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix =
        actualXmPageTextSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmPageTextSchema.getAllProperties().isEmpty());
    assertTrue(actualXmPageTextSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/t/pg/"));
    assertSame(metadata, actualXmPageTextSchema.getMetadata());
  }
}
