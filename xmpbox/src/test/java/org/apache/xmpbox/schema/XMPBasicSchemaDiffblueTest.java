package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.ThumbnailType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPBasicSchemaDiffblueTest {
  /**
   * Test {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPBasicSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.<init>(XMPMetadata)"})
  void testNewXMPBasicSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualXmpBasicSchema = new XMPBasicSchema(metadata);

    // Assert
    assertEquals("", actualXmpBasicSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualXmpBasicSchema.getNamespace());
    assertEquals("xmp", actualXmpBasicSchema.getPreferedPrefix());
    assertEquals("xmp", actualXmpBasicSchema.getPrefix());
    assertNull(actualXmpBasicSchema.getRating());
    assertNull(actualXmpBasicSchema.getBaseURL());
    assertNull(actualXmpBasicSchema.getCreatorTool());
    assertNull(actualXmpBasicSchema.getLabel());
    assertNull(actualXmpBasicSchema.getNickname());
    assertNull(actualXmpBasicSchema.getPropertyName());
    assertNull(actualXmpBasicSchema.getCreateDate());
    assertNull(actualXmpBasicSchema.getMetadataDate());
    assertNull(actualXmpBasicSchema.getModifierDate());
    assertNull(actualXmpBasicSchema.getModifyDate());
    assertNull(actualXmpBasicSchema.getAdvisory());
    assertNull(actualXmpBasicSchema.getIdentifiers());
    assertNull(actualXmpBasicSchema.getThumbnailsProperty());
    assertNull(actualXmpBasicSchema.getAdvisoryProperty());
    assertNull(actualXmpBasicSchema.getIdentifiersProperty());
    assertNull(actualXmpBasicSchema.getAboutAttribute());
    assertNull(actualXmpBasicSchema.getCreateDateProperty());
    assertNull(actualXmpBasicSchema.getMetadataDateProperty());
    assertNull(actualXmpBasicSchema.getModifierDateProperty());
    assertNull(actualXmpBasicSchema.getModifyDateProperty());
    assertNull(actualXmpBasicSchema.getRatingProperty());
    assertNull(actualXmpBasicSchema.getBaseURLProperty());
    assertNull(actualXmpBasicSchema.getCreatorToolProperty());
    assertNull(actualXmpBasicSchema.getLabelProperty());
    assertNull(actualXmpBasicSchema.getNicknameProperty());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpBasicSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpBasicSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/"));
    assertSame(metadata, actualXmpBasicSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code xmp}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new XMPBasicSchema(XMPMetadata, String); when 'null'; then return Prefix is 'xmp'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.<init>(XMPMetadata, String)"})
  void testNewXMPBasicSchema_whenNull_thenReturnPrefixIsXmp() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualXmpBasicSchema = new XMPBasicSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpBasicSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualXmpBasicSchema.getNamespace());
    assertEquals("xmp", actualXmpBasicSchema.getPreferedPrefix());
    assertEquals("xmp", actualXmpBasicSchema.getPrefix());
    assertNull(actualXmpBasicSchema.getRating());
    assertNull(actualXmpBasicSchema.getBaseURL());
    assertNull(actualXmpBasicSchema.getCreatorTool());
    assertNull(actualXmpBasicSchema.getLabel());
    assertNull(actualXmpBasicSchema.getNickname());
    assertNull(actualXmpBasicSchema.getPropertyName());
    assertNull(actualXmpBasicSchema.getCreateDate());
    assertNull(actualXmpBasicSchema.getMetadataDate());
    assertNull(actualXmpBasicSchema.getModifierDate());
    assertNull(actualXmpBasicSchema.getModifyDate());
    assertNull(actualXmpBasicSchema.getAdvisory());
    assertNull(actualXmpBasicSchema.getIdentifiers());
    assertNull(actualXmpBasicSchema.getThumbnailsProperty());
    assertNull(actualXmpBasicSchema.getAdvisoryProperty());
    assertNull(actualXmpBasicSchema.getIdentifiersProperty());
    assertNull(actualXmpBasicSchema.getAboutAttribute());
    assertNull(actualXmpBasicSchema.getCreateDateProperty());
    assertNull(actualXmpBasicSchema.getMetadataDateProperty());
    assertNull(actualXmpBasicSchema.getModifierDateProperty());
    assertNull(actualXmpBasicSchema.getModifyDateProperty());
    assertNull(actualXmpBasicSchema.getRatingProperty());
    assertNull(actualXmpBasicSchema.getBaseURLProperty());
    assertNull(actualXmpBasicSchema.getCreatorToolProperty());
    assertNull(actualXmpBasicSchema.getLabelProperty());
    assertNull(actualXmpBasicSchema.getNicknameProperty());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpBasicSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpBasicSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/"));
    assertSame(metadata, actualXmpBasicSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Own Prefix}.
   *   <li>Then return Prefix is {@code Own Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new XMPBasicSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.<init>(XMPMetadata, String)"})
  void testNewXMPBasicSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix()
      throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualXmpBasicSchema = new XMPBasicSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpBasicSchema.getAboutValue());
    assertEquals("Own Prefix", actualXmpBasicSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualXmpBasicSchema.getNamespace());
    assertEquals("xmp", actualXmpBasicSchema.getPreferedPrefix());
    assertNull(actualXmpBasicSchema.getRating());
    assertNull(actualXmpBasicSchema.getBaseURL());
    assertNull(actualXmpBasicSchema.getCreatorTool());
    assertNull(actualXmpBasicSchema.getLabel());
    assertNull(actualXmpBasicSchema.getNickname());
    assertNull(actualXmpBasicSchema.getPropertyName());
    assertNull(actualXmpBasicSchema.getCreateDate());
    assertNull(actualXmpBasicSchema.getMetadataDate());
    assertNull(actualXmpBasicSchema.getModifierDate());
    assertNull(actualXmpBasicSchema.getModifyDate());
    assertNull(actualXmpBasicSchema.getAdvisory());
    assertNull(actualXmpBasicSchema.getIdentifiers());
    assertNull(actualXmpBasicSchema.getThumbnailsProperty());
    assertNull(actualXmpBasicSchema.getAdvisoryProperty());
    assertNull(actualXmpBasicSchema.getIdentifiersProperty());
    assertNull(actualXmpBasicSchema.getAboutAttribute());
    assertNull(actualXmpBasicSchema.getCreateDateProperty());
    assertNull(actualXmpBasicSchema.getMetadataDateProperty());
    assertNull(actualXmpBasicSchema.getModifierDateProperty());
    assertNull(actualXmpBasicSchema.getModifyDateProperty());
    assertNull(actualXmpBasicSchema.getRatingProperty());
    assertNull(actualXmpBasicSchema.getBaseURLProperty());
    assertNull(actualXmpBasicSchema.getCreatorToolProperty());
    assertNull(actualXmpBasicSchema.getLabelProperty());
    assertNull(actualXmpBasicSchema.getNicknameProperty());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpBasicSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpBasicSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/"));
    assertSame(metadata, actualXmpBasicSchema.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}
   */
  @Test
  @DisplayName("Test addThumbnails(Integer, Integer, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addThumbnails(Integer, Integer, String, String)"})
  void testAddThumbnails() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("xmp", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}
   */
  @Test
  @DisplayName("Test addThumbnails(Integer, Integer, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addThumbnails(Integer, Integer, String, String)"})
  void testAddThumbnails2() throws BadFieldValueException {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.THUMBNAILS, XMPBasicSchema.THUMBNAILS);

    // Act
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals(2, xmpBasicSchema.getThumbnailsProperty().size());
  }

  /**
   * Test {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}
   */
  @Test
  @DisplayName("Test addThumbnails(Integer, Integer, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addThumbnails(Integer, Integer, String, String)"})
  void testAddThumbnails3() throws BadFieldValueException {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.THUMBNAILS, "42");

    // Act
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals(1, xmpBasicSchema.getThumbnailsProperty().size());
  }

  /**
   * Test {@link XMPBasicSchema#addAdvisory(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  @DisplayName("Test addAdvisory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addAdvisory(String)"})
  void testAddAdvisory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(1, advisory.size());
    assertEquals("Xpath", advisory.get(0));
    ArrayProperty advisoryProperty = xmpBasicSchema.getAdvisoryProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/", advisoryProperty.getNamespace());
    assertEquals("xmp", advisoryProperty.getPrefix());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, advisoryProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, advisoryProperty.getArrayType());
    assertTrue(advisoryProperty.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(advisory, advisoryProperty.getElementsAsString());
    assertEquals(XMPBasicSchema.ADVISORY, advisoryProperty.getPropertyName());
    assertSame(advisoryProperty, allProperties.get(0));
    assertSame(metadata, advisoryProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#addAdvisory(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  @DisplayName("Test addAdvisory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addAdvisory(String)"})
  void testAddAdvisory2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(1, advisory.size());
    assertEquals("Xpath", advisory.get(0));
    ArrayProperty advisoryProperty = xmpBasicSchema.getAdvisoryProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/", advisoryProperty.getNamespace());
    assertEquals("xmp", advisoryProperty.getPrefix());
    assertEquals(1, advisoryProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, advisoryProperty.getArrayType());
    assertTrue(advisoryProperty.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(advisory, advisoryProperty.getElementsAsString());
    assertEquals(XMPBasicSchema.ADVISORY, advisoryProperty.getPropertyName());
    assertSame(advisoryProperty, allProperties.get(1));
    assertSame(metadata, advisoryProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#addAdvisory(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  @DisplayName("Test addAdvisory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addAdvisory(String)"})
  void testAddAdvisory3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(2, advisory.size());
    assertEquals("Xpath", advisory.get(1));
    assertEquals(2, xmpBasicSchema.getAllProperties().size());
    assertEquals(2, xmpBasicSchema.getAdvisoryProperty().getAllProperties().size());
  }

  /**
   * Test {@link XMPBasicSchema#addAdvisory(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  @DisplayName("Test addAdvisory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addAdvisory(String)"})
  void testAddAdvisory4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURL(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
  @DisplayName("Test setBaseURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURL(String)"})
  void testSetBaseURL() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.setBaseURL("https://example.org/example");

    // Assert
    TextType baseURLProperty = xmpBasicSchema.getBaseURLProperty();
    assertTrue(baseURLProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpBasicSchema.getBaseURL());
    assertEquals("https://example.org/example", baseURLProperty.getStringValue());
    assertEquals("https://example.org/example", baseURLProperty.getRawValue());
    assertEquals("https://example.org/example", baseURLProperty.getValue());
    assertEquals("xmp", baseURLProperty.getPrefix());
    assertNull(baseURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(baseURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.BASEURL, baseURLProperty.getPropertyName());
    assertSame(metadata, baseURLProperty.getMetadata());
    assertSame(baseURLProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURL(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
  @DisplayName("Test setBaseURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURL(String)"})
  void testSetBaseURL2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act
    xmpBasicSchema.setBaseURL("https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    TextType baseURLProperty = xmpBasicSchema.getBaseURLProperty();
    assertTrue(baseURLProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpBasicSchema.getBaseURL());
    assertEquals("https://example.org/example", baseURLProperty.getStringValue());
    assertEquals("https://example.org/example", baseURLProperty.getRawValue());
    assertEquals("https://example.org/example", baseURLProperty.getValue());
    assertEquals("xmp", baseURLProperty.getPrefix());
    assertNull(baseURLProperty.getNamespace());
    assertTrue(baseURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.BASEURL, baseURLProperty.getPropertyName());
    assertSame(metadata, baseURLProperty.getMetadata());
    assertSame(baseURLProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURL(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
  @DisplayName("Test setBaseURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURL(String)"})
  void testSetBaseURL3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act
    xmpBasicSchema.setBaseURL("https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURL(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
  @DisplayName("Test setBaseURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURL(String)"})
  void testSetBaseURL4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.BASEURL, "42");

    // Act
    xmpBasicSchema.setBaseURL("https://example.org/example");

    // Assert
    TextType baseURLProperty = xmpBasicSchema.getBaseURLProperty();
    assertTrue(baseURLProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpBasicSchema.getBaseURL());
    assertEquals("https://example.org/example", baseURLProperty.getStringValue());
    assertEquals("https://example.org/example", baseURLProperty.getRawValue());
    assertEquals("https://example.org/example", baseURLProperty.getValue());
    assertEquals("xmp", baseURLProperty.getPrefix());
    assertNull(baseURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(baseURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.BASEURL, baseURLProperty.getPropertyName());
    assertSame(metadata, baseURLProperty.getMetadata());
    assertSame(baseURLProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setBaseURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURLProperty(URLType)"})
  void testSetBaseURLProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpBasicSchema.setBaseURLProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(url, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setBaseURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURLProperty(URLType)"})
  void testSetBaseURLProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpBasicSchema.setBaseURLProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setBaseURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURLProperty(URLType)"})
  void testSetBaseURLProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("https://example.org/example");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpBasicSchema.setBaseURLProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(url, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setBaseURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setBaseURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setBaseURLProperty(URLType)"})
  void testSetBaseURLProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("https://example.org/example", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpBasicSchema.setBaseURLProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreateDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDate(Calendar)"})
  void testSetCreateDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setCreateDate(date);

    // Assert
    DateType createDateProperty = xmpBasicSchema.getCreateDateProperty();
    assertEquals("xmp", createDateProperty.getPrefix());
    assertNull(createDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(createDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATEDATE, createDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getCreateDate());
    assertSame(date, createDateProperty.getRawValue());
    assertSame(date, createDateProperty.getValue());
    assertSame(createDateProperty, allProperties.get(0));
    assertSame(metadata, createDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreateDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDate(Calendar)"})
  void testSetCreateDate2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setCreateDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    DateType createDateProperty = xmpBasicSchema.getCreateDateProperty();
    assertEquals("xmp", createDateProperty.getPrefix());
    assertNull(createDateProperty.getNamespace());
    assertTrue(createDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATEDATE, createDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getCreateDate());
    assertSame(date, createDateProperty.getRawValue());
    assertSame(date, createDateProperty.getValue());
    assertSame(createDateProperty, allProperties.get(1));
    assertSame(metadata, createDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreateDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDate(Calendar)"})
  void testSetCreateDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act
    xmpBasicSchema.setCreateDate(new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreateDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDate(Calendar)"})
  void testSetCreateDate4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.CREATEDATE, "42");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setCreateDate(date);

    // Assert
    DateType createDateProperty = xmpBasicSchema.getCreateDateProperty();
    assertEquals("xmp", createDateProperty.getPrefix());
    assertNull(createDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(createDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATEDATE, createDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getCreateDate());
    assertSame(date, createDateProperty.getRawValue());
    assertSame(date, createDateProperty.getValue());
    assertSame(createDateProperty, allProperties.get(0));
    assertSame(metadata, createDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setCreateDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDateProperty(DateType)"})
  void testSetCreateDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setCreateDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setCreateDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDateProperty(DateType)"})
  void testSetCreateDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setCreateDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setCreateDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDateProperty(DateType)"})
  void testSetCreateDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setCreateDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(date, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setCreateDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setCreateDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreateDateProperty(DateType)"})
  void testSetCreateDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setCreateDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorTool(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
  @DisplayName("Test setCreatorTool(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorTool(String)"})
  void testSetCreatorTool() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.setCreatorTool("Creator Tool");

    // Assert
    TextType creatorToolProperty = xmpBasicSchema.getCreatorToolProperty();
    assertTrue(creatorToolProperty instanceof AgentNameType);
    assertEquals("Creator Tool", xmpBasicSchema.getCreatorTool());
    assertEquals("Creator Tool", creatorToolProperty.getStringValue());
    assertEquals("Creator Tool", creatorToolProperty.getRawValue());
    assertEquals("Creator Tool", creatorToolProperty.getValue());
    assertEquals("xmp", creatorToolProperty.getPrefix());
    assertNull(creatorToolProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(creatorToolProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATORTOOL, creatorToolProperty.getPropertyName());
    assertSame(metadata, creatorToolProperty.getMetadata());
    assertSame(creatorToolProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorTool(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
  @DisplayName("Test setCreatorTool(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorTool(String)"})
  void testSetCreatorTool2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act
    xmpBasicSchema.setCreatorTool("Creator Tool");

    // Assert
    TextType creatorToolProperty = xmpBasicSchema.getCreatorToolProperty();
    assertTrue(creatorToolProperty instanceof AgentNameType);
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Creator Tool", xmpBasicSchema.getCreatorTool());
    assertEquals("Creator Tool", creatorToolProperty.getStringValue());
    assertEquals("Creator Tool", creatorToolProperty.getRawValue());
    assertEquals("Creator Tool", creatorToolProperty.getValue());
    assertEquals("xmp", creatorToolProperty.getPrefix());
    assertNull(creatorToolProperty.getNamespace());
    assertTrue(creatorToolProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATORTOOL, creatorToolProperty.getPropertyName());
    assertSame(metadata, creatorToolProperty.getMetadata());
    assertSame(creatorToolProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorTool(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
  @DisplayName("Test setCreatorTool(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorTool(String)"})
  void testSetCreatorTool3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act
    xmpBasicSchema.setCreatorTool("Creator Tool");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorTool(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
  @DisplayName("Test setCreatorTool(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorTool(String)"})
  void testSetCreatorTool4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.CREATORTOOL, "42");

    // Act
    xmpBasicSchema.setCreatorTool("Creator Tool");

    // Assert
    TextType creatorToolProperty = xmpBasicSchema.getCreatorToolProperty();
    assertTrue(creatorToolProperty instanceof AgentNameType);
    assertEquals("Creator Tool", xmpBasicSchema.getCreatorTool());
    assertEquals("Creator Tool", creatorToolProperty.getStringValue());
    assertEquals("Creator Tool", creatorToolProperty.getRawValue());
    assertEquals("Creator Tool", creatorToolProperty.getValue());
    assertEquals("xmp", creatorToolProperty.getPrefix());
    assertNull(creatorToolProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(creatorToolProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATORTOOL, creatorToolProperty.getPropertyName());
    assertSame(metadata, creatorToolProperty.getMetadata());
    assertSame(creatorToolProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setCreatorToolProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorToolProperty(AgentNameType)"})
  void testSetCreatorToolProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    AgentNameType creatorTool =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setCreatorToolProperty(creatorTool);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(creatorTool, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setCreatorToolProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorToolProperty(AgentNameType)"})
  void testSetCreatorToolProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    AgentNameType creatorTool =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setCreatorToolProperty(creatorTool);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(creatorTool, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setCreatorToolProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorToolProperty(AgentNameType)"})
  void testSetCreatorToolProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Property Name");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    AgentNameType creatorTool =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setCreatorToolProperty(creatorTool);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(creatorTool, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setCreatorToolProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setCreatorToolProperty(AgentNameType)"})
  void testSetCreatorToolProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    AgentNameType creatorTool =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setCreatorToolProperty(creatorTool);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
  }

  /**
   * Test {@link XMPBasicSchema#addIdentifier(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  @DisplayName("Test addIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addIdentifier(String)"})
  void testAddIdentifier() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(1, identifiers.size());
    assertEquals("Text", identifiers.get(0));
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/", identifiersProperty.getNamespace());
    assertEquals("xmp", identifiersProperty.getPrefix());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, identifiersProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, identifiersProperty.getArrayType());
    assertTrue(identifiersProperty.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(identifiers, identifiersProperty.getElementsAsString());
    assertEquals(XMPBasicSchema.IDENTIFIER, identifiersProperty.getPropertyName());
    assertSame(identifiersProperty, allProperties.get(0));
    assertSame(metadata, identifiersProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#addIdentifier(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  @DisplayName("Test addIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addIdentifier(String)"})
  void testAddIdentifier2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(1, identifiers.size());
    assertEquals("Text", identifiers.get(0));
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/", identifiersProperty.getNamespace());
    assertEquals("xmp", identifiersProperty.getPrefix());
    assertEquals(1, identifiersProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, identifiersProperty.getArrayType());
    assertTrue(identifiersProperty.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(identifiers, identifiersProperty.getElementsAsString());
    assertEquals(XMPBasicSchema.IDENTIFIER, identifiersProperty.getPropertyName());
    assertSame(identifiersProperty, allProperties.get(1));
    assertSame(metadata, identifiersProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#addIdentifier(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  @DisplayName("Test addIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addIdentifier(String)"})
  void testAddIdentifier3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#addIdentifier(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  @DisplayName("Test addIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.addIdentifier(String)"})
  void testAddIdentifier4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(2, identifiers.size());
    assertEquals("Text", identifiers.get(1));
    assertEquals(2, xmpBasicSchema.getAllProperties().size());
    assertEquals(2, xmpBasicSchema.getIdentifiersProperty().getAllProperties().size());
  }

  /**
   * Test {@link XMPBasicSchema#setLabel(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabel(String)"})
  void testSetLabel() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.setLabel("Text");

    // Assert
    assertEquals("Text", xmpBasicSchema.getLabel());
    TextType labelProperty = xmpBasicSchema.getLabelProperty();
    assertEquals("Text", labelProperty.getStringValue());
    assertEquals("Text", labelProperty.getRawValue());
    assertEquals("Text", labelProperty.getValue());
    assertEquals("xmp", labelProperty.getPrefix());
    assertNull(labelProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(labelProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.LABEL, labelProperty.getPropertyName());
    assertSame(labelProperty, allProperties.get(0));
    assertSame(metadata, labelProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setLabel(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabel(String)"})
  void testSetLabel2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act
    xmpBasicSchema.setLabel("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", xmpBasicSchema.getLabel());
    TextType labelProperty = xmpBasicSchema.getLabelProperty();
    assertEquals("Text", labelProperty.getStringValue());
    assertEquals("Text", labelProperty.getRawValue());
    assertEquals("Text", labelProperty.getValue());
    assertEquals("xmp", labelProperty.getPrefix());
    assertNull(labelProperty.getNamespace());
    assertTrue(labelProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.LABEL, labelProperty.getPropertyName());
    assertSame(labelProperty, allProperties.get(1));
    assertSame(metadata, labelProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setLabel(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabel(String)"})
  void testSetLabel3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act
    xmpBasicSchema.setLabel("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setLabel(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabel(String)"})
  void testSetLabel4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.LABEL, "42");

    // Act
    xmpBasicSchema.setLabel("Text");

    // Assert
    assertEquals("Text", xmpBasicSchema.getLabel());
    TextType labelProperty = xmpBasicSchema.getLabelProperty();
    assertEquals("Text", labelProperty.getStringValue());
    assertEquals("Text", labelProperty.getRawValue());
    assertEquals("Text", labelProperty.getValue());
    assertEquals("xmp", labelProperty.getPrefix());
    assertNull(labelProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(labelProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.LABEL, labelProperty.getPropertyName());
    assertSame(labelProperty, allProperties.get(0));
    assertSame(metadata, labelProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setLabelProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  @DisplayName("Test setLabelProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabelProperty(TextType)"})
  void testSetLabelProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setLabelProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setLabelProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  @DisplayName("Test setLabelProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabelProperty(TextType)"})
  void testSetLabelProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setLabelProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setLabelProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  @DisplayName("Test setLabelProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabelProperty(TextType)"})
  void testSetLabelProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Property Name");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setLabelProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setLabelProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  @DisplayName("Test setLabelProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setLabelProperty(TextType)"})
  void testSetLabelProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setLabelProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
  @DisplayName("Test setMetadataDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDate(Calendar)"})
  void testSetMetadataDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setMetadataDate(date);

    // Assert
    DateType metadataDateProperty = xmpBasicSchema.getMetadataDateProperty();
    assertEquals("xmp", metadataDateProperty.getPrefix());
    assertNull(metadataDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(metadataDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.METADATADATE, metadataDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getMetadataDate());
    assertSame(date, metadataDateProperty.getRawValue());
    assertSame(date, metadataDateProperty.getValue());
    assertSame(metadataDateProperty, allProperties.get(0));
    assertSame(metadata, metadataDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
  @DisplayName("Test setMetadataDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDate(Calendar)"})
  void testSetMetadataDate2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setMetadataDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    DateType metadataDateProperty = xmpBasicSchema.getMetadataDateProperty();
    assertEquals("xmp", metadataDateProperty.getPrefix());
    assertNull(metadataDateProperty.getNamespace());
    assertTrue(metadataDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.METADATADATE, metadataDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getMetadataDate());
    assertSame(date, metadataDateProperty.getRawValue());
    assertSame(date, metadataDateProperty.getValue());
    assertSame(metadataDateProperty, allProperties.get(1));
    assertSame(metadata, metadataDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
  @DisplayName("Test setMetadataDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDate(Calendar)"})
  void testSetMetadataDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act
    xmpBasicSchema.setMetadataDate(new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
  @DisplayName("Test setMetadataDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDate(Calendar)"})
  void testSetMetadataDate4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.METADATADATE, "42");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setMetadataDate(date);

    // Assert
    DateType metadataDateProperty = xmpBasicSchema.getMetadataDateProperty();
    assertEquals("xmp", metadataDateProperty.getPrefix());
    assertNull(metadataDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(metadataDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.METADATADATE, metadataDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getMetadataDate());
    assertSame(date, metadataDateProperty.getRawValue());
    assertSame(date, metadataDateProperty.getValue());
    assertSame(metadataDateProperty, allProperties.get(0));
    assertSame(metadata, metadataDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setMetadataDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDateProperty(DateType)"})
  void testSetMetadataDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setMetadataDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setMetadataDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDateProperty(DateType)"})
  void testSetMetadataDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setMetadataDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setMetadataDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDateProperty(DateType)"})
  void testSetMetadataDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setMetadataDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(date, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setMetadataDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setMetadataDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setMetadataDateProperty(DateType)"})
  void testSetMetadataDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setMetadataDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifyDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDate(Calendar)"})
  void testSetModifyDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifyDate(date);

    // Assert
    DateType modifyDateProperty = xmpBasicSchema.getModifyDateProperty();
    assertEquals("xmp", modifyDateProperty.getPrefix());
    assertNull(modifyDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(modifyDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFYDATE, modifyDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifyDate());
    assertSame(date, modifyDateProperty.getRawValue());
    assertSame(date, modifyDateProperty.getValue());
    assertSame(modifyDateProperty, allProperties.get(0));
    assertSame(metadata, modifyDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifyDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDate(Calendar)"})
  void testSetModifyDate2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifyDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    DateType modifyDateProperty = xmpBasicSchema.getModifyDateProperty();
    assertEquals("xmp", modifyDateProperty.getPrefix());
    assertNull(modifyDateProperty.getNamespace());
    assertTrue(modifyDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFYDATE, modifyDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifyDate());
    assertSame(date, modifyDateProperty.getRawValue());
    assertSame(date, modifyDateProperty.getValue());
    assertSame(modifyDateProperty, allProperties.get(1));
    assertSame(metadata, modifyDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifyDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDate(Calendar)"})
  void testSetModifyDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act
    xmpBasicSchema.setModifyDate(new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifyDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDate(Calendar)"})
  void testSetModifyDate4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.MODIFYDATE, "42");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifyDate(date);

    // Assert
    DateType modifyDateProperty = xmpBasicSchema.getModifyDateProperty();
    assertEquals("xmp", modifyDateProperty.getPrefix());
    assertNull(modifyDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(modifyDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFYDATE, modifyDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifyDate());
    assertSame(date, modifyDateProperty.getRawValue());
    assertSame(date, modifyDateProperty.getValue());
    assertSame(modifyDateProperty, allProperties.get(0));
    assertSame(metadata, modifyDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifierDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDate(Calendar)"})
  void testSetModifierDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifierDate(date);

    // Assert
    DateType modifierDateProperty = xmpBasicSchema.getModifierDateProperty();
    assertEquals("xmp", modifierDateProperty.getPrefix());
    assertNull(modifierDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(modifierDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFIER_DATE, modifierDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifierDate());
    assertSame(date, modifierDateProperty.getRawValue());
    assertSame(date, modifierDateProperty.getValue());
    assertSame(modifierDateProperty, allProperties.get(0));
    assertSame(metadata, modifierDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifierDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDate(Calendar)"})
  void testSetModifierDate2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifierDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    DateType modifierDateProperty = xmpBasicSchema.getModifierDateProperty();
    assertEquals("xmp", modifierDateProperty.getPrefix());
    assertNull(modifierDateProperty.getNamespace());
    assertTrue(modifierDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFIER_DATE, modifierDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifierDate());
    assertSame(date, modifierDateProperty.getRawValue());
    assertSame(date, modifierDateProperty.getValue());
    assertSame(modifierDateProperty, allProperties.get(1));
    assertSame(metadata, modifierDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifierDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDate(Calendar)"})
  void testSetModifierDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act
    xmpBasicSchema.setModifierDate(new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDate(Calendar)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifierDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDate(Calendar)"})
  void testSetModifierDate4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.MODIFIER_DATE, "42");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifierDate(date);

    // Assert
    DateType modifierDateProperty = xmpBasicSchema.getModifierDateProperty();
    assertEquals("xmp", modifierDateProperty.getPrefix());
    assertNull(modifierDateProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(modifierDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFIER_DATE, modifierDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifierDate());
    assertSame(date, modifierDateProperty.getRawValue());
    assertSame(date, modifierDateProperty.getValue());
    assertSame(modifierDateProperty, allProperties.get(0));
    assertSame(metadata, modifierDateProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifyDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDateProperty(DateType)"})
  void testSetModifyDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifyDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifyDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDateProperty(DateType)"})
  void testSetModifyDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifyDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifyDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDateProperty(DateType)"})
  void testSetModifyDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifyDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(date, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setModifyDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifyDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifyDateProperty(DateType)"})
  void testSetModifyDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifyDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifierDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDateProperty(DateType)"})
  void testSetModifierDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifierDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifierDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDateProperty(DateType)"})
  void testSetModifierDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifierDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifierDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDateProperty(DateType)"})
  void testSetModifierDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifierDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(date, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setModifierDateProperty(DateType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  @DisplayName("Test setModifierDateProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setModifierDateProperty(DateType)"})
  void testSetModifierDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifierDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setNickname(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
  @DisplayName("Test setNickname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNickname(String)"})
  void testSetNickname() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.setNickname("Text");

    // Assert
    assertEquals("Text", xmpBasicSchema.getNickname());
    TextType nicknameProperty = xmpBasicSchema.getNicknameProperty();
    assertEquals("Text", nicknameProperty.getStringValue());
    assertEquals("Text", nicknameProperty.getRawValue());
    assertEquals("Text", nicknameProperty.getValue());
    assertEquals("xmp", nicknameProperty.getPrefix());
    assertNull(nicknameProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(nicknameProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.NICKNAME, nicknameProperty.getPropertyName());
    assertSame(nicknameProperty, allProperties.get(0));
    assertSame(metadata, nicknameProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setNickname(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
  @DisplayName("Test setNickname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNickname(String)"})
  void testSetNickname2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act
    xmpBasicSchema.setNickname("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", xmpBasicSchema.getNickname());
    TextType nicknameProperty = xmpBasicSchema.getNicknameProperty();
    assertEquals("Text", nicknameProperty.getStringValue());
    assertEquals("Text", nicknameProperty.getRawValue());
    assertEquals("Text", nicknameProperty.getValue());
    assertEquals("xmp", nicknameProperty.getPrefix());
    assertNull(nicknameProperty.getNamespace());
    assertTrue(nicknameProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.NICKNAME, nicknameProperty.getPropertyName());
    assertSame(nicknameProperty, allProperties.get(1));
    assertSame(metadata, nicknameProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setNickname(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
  @DisplayName("Test setNickname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNickname(String)"})
  void testSetNickname3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act
    xmpBasicSchema.setNickname("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setNickname(String)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
  @DisplayName("Test setNickname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNickname(String)"})
  void testSetNickname4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.NICKNAME, "42");

    // Act
    xmpBasicSchema.setNickname("Text");

    // Assert
    assertEquals("Text", xmpBasicSchema.getNickname());
    TextType nicknameProperty = xmpBasicSchema.getNicknameProperty();
    assertEquals("Text", nicknameProperty.getStringValue());
    assertEquals("Text", nicknameProperty.getRawValue());
    assertEquals("Text", nicknameProperty.getValue());
    assertEquals("xmp", nicknameProperty.getPrefix());
    assertNull(nicknameProperty.getNamespace());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(nicknameProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.NICKNAME, nicknameProperty.getPropertyName());
    assertSame(nicknameProperty, allProperties.get(0));
    assertSame(metadata, nicknameProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setNicknameProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  @DisplayName("Test setNicknameProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNicknameProperty(TextType)"})
  void testSetNicknameProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setNicknameProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setNicknameProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  @DisplayName("Test setNicknameProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNicknameProperty(TextType)"})
  void testSetNicknameProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setNicknameProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setNicknameProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  @DisplayName("Test setNicknameProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNicknameProperty(TextType)"})
  void testSetNicknameProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Property Name");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setNicknameProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setNicknameProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  @DisplayName("Test setNicknameProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setNicknameProperty(TextType)"})
  void testSetNicknameProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setNicknameProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
  }

  /**
   * Test {@link XMPBasicSchema#setRating(Integer)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
  @DisplayName("Test setRating(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRating(Integer)"})
  void testSetRating() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.setRating(1);

    // Assert
    IntegerType ratingProperty = xmpBasicSchema.getRatingProperty();
    assertEquals("1", ratingProperty.getStringValue());
    assertEquals("xmp", ratingProperty.getPrefix());
    assertNull(ratingProperty.getNamespace());
    assertEquals(1, xmpBasicSchema.getRating().intValue());
    assertEquals(1, ratingProperty.getValue().intValue());
    assertEquals(1, ((Integer) ratingProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(0));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setRating(Integer)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
  @DisplayName("Test setRating(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRating(Integer)"})
  void testSetRating2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act
    xmpBasicSchema.setRating(1);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType ratingProperty = xmpBasicSchema.getRatingProperty();
    assertEquals("1", ratingProperty.getStringValue());
    assertEquals("xmp", ratingProperty.getPrefix());
    assertNull(ratingProperty.getNamespace());
    assertEquals(1, xmpBasicSchema.getRating().intValue());
    assertEquals(1, ratingProperty.getValue().intValue());
    assertEquals(1, ((Integer) ratingProperty.getRawValue()).intValue());
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(1));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setRating(Integer)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
  @DisplayName("Test setRating(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRating(Integer)"})
  void testSetRating3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act
    xmpBasicSchema.setRating(1);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPBasicSchema#setRating(Integer)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
  @DisplayName("Test setRating(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRating(Integer)"})
  void testSetRating4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.RATING, "42");

    // Act
    xmpBasicSchema.setRating(1);

    // Assert
    IntegerType ratingProperty = xmpBasicSchema.getRatingProperty();
    assertEquals("1", ratingProperty.getStringValue());
    assertEquals("xmp", ratingProperty.getPrefix());
    assertNull(ratingProperty.getNamespace());
    assertEquals(1, xmpBasicSchema.getRating().intValue());
    assertEquals(1, ratingProperty.getValue().intValue());
    assertEquals(1, ((Integer) ratingProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(0));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#setRatingProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setRatingProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRatingProperty(IntegerType)"})
  void testSetRatingProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    IntegerType rate =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpBasicSchema.setRatingProperty(rate);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(rate, allProperties.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#setRatingProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setRatingProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRatingProperty(IntegerType)"})
  void testSetRatingProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    IntegerType rate =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpBasicSchema.setRatingProperty(rate);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(rate, allProperties.get(1));
  }

  /**
   * Test {@link XMPBasicSchema#setRatingProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setRatingProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRatingProperty(IntegerType)"})
  void testSetRatingProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    IntegerType rate =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpBasicSchema.setRatingProperty(rate);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(rate, allProperties.get(2));
  }

  /**
   * Test {@link XMPBasicSchema#setRatingProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setRatingProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPBasicSchema.setRatingProperty(IntegerType)"})
  void testSetRatingProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    IntegerType rate =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpBasicSchema.setRatingProperty(rate);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#getAdvisoryProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getAdvisoryProperty()}
   */
  @Test
  @DisplayName(
      "Test getAdvisoryProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getAdvisoryProperty()"})
  void testGetAdvisoryProperty_thenReturnNamespaceIsHttpNsAdobeComXap10() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    ArrayProperty actualAdvisoryProperty = xmpBasicSchema.getAdvisoryProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/", actualAdvisoryProperty.getNamespace());
    assertEquals("xmp", actualAdvisoryProperty.getPrefix());
    assertEquals(1, actualAdvisoryProperty.getAllProperties().size());
    assertEquals(1, actualAdvisoryProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualAdvisoryProperty.getArrayType());
    assertTrue(actualAdvisoryProperty.getAllAttributes().isEmpty());
    assertTrue(actualAdvisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.ADVISORY, actualAdvisoryProperty.getPropertyName());
    assertSame(metadata, actualAdvisoryProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#getAdvisoryProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getAdvisoryProperty()}
   */
  @Test
  @DisplayName("Test getAdvisoryProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getAdvisoryProperty()"})
  void testGetAdvisoryProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getAdvisoryProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getAdvisoryProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getAdvisoryProperty()}
   */
  @Test
  @DisplayName("Test getAdvisoryProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getAdvisoryProperty()"})
  void testGetAdvisoryProperty_thenReturnNull2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act and Assert
    assertNull(xmpBasicSchema.getAdvisoryProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getAdvisory()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getAdvisory()}
   */
  @Test
  @DisplayName("Test getAdvisory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getAdvisory()"})
  void testGetAdvisory_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getAdvisory());
  }

  /**
   * Test {@link XMPBasicSchema#getAdvisory()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getAdvisory()}
   */
  @Test
  @DisplayName("Test getAdvisory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getAdvisory()"})
  void testGetAdvisory_thenReturnNull2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act and Assert
    assertNull(xmpBasicSchema.getAdvisory());
  }

  /**
   * Test {@link XMPBasicSchema#getAdvisory()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getAdvisory()}
   */
  @Test
  @DisplayName("Test getAdvisory(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getAdvisory()"})
  void testGetAdvisory_thenReturnSizeIsOne() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    List<String> actualAdvisory = xmpBasicSchema.getAdvisory();

    // Assert
    assertEquals(1, actualAdvisory.size());
    assertEquals(XMPBasicSchema.THUMBNAILS, actualAdvisory.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#getBaseURLProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getBaseURLProperty()}
   */
  @Test
  @DisplayName("Test getBaseURLProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getBaseURLProperty()"})
  void testGetBaseURLProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURLProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getBaseURLProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getBaseURLProperty()}
   */
  @Test
  @DisplayName(
      "Test getBaseURLProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getBaseURLProperty()"})
  void testGetBaseURLProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getBaseURLProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getBaseURLProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getBaseURLProperty()}
   */
  @Test
  @DisplayName(
      "Test getBaseURLProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getBaseURLProperty()"})
  void testGetBaseURLProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURLProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getBaseURL()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getBaseURL()}
   */
  @Test
  @DisplayName("Test getBaseURL()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getBaseURL()"})
  void testGetBaseURL() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURL());
  }

  /**
   * Test {@link XMPBasicSchema#getBaseURL()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getBaseURL()}
   */
  @Test
  @DisplayName(
      "Test getBaseURL(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getBaseURL()"})
  void testGetBaseURL_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getBaseURL());
  }

  /**
   * Test {@link XMPBasicSchema#getBaseURL()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getBaseURL()}
   */
  @Test
  @DisplayName(
      "Test getBaseURL(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getBaseURL()"})
  void testGetBaseURL_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURL());
  }

  /**
   * Test {@link XMPBasicSchema#getCreateDateProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreateDateProperty()}
   */
  @Test
  @DisplayName("Test getCreateDateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getCreateDateProperty()"})
  void testGetCreateDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getCreateDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreateDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getCreateDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getCreateDateProperty()"})
  void testGetCreateDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getCreateDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getCreateDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreateDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getCreateDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getCreateDateProperty()"})
  void testGetCreateDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getCreateDate()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreateDate()}
   */
  @Test
  @DisplayName("Test getCreateDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getCreateDate()"})
  void testGetCreateDate() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDate());
  }

  /**
   * Test {@link XMPBasicSchema#getCreateDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreateDate()}
   */
  @Test
  @DisplayName(
      "Test getCreateDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getCreateDate()"})
  void testGetCreateDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getCreateDate());
  }

  /**
   * Test {@link XMPBasicSchema#getCreateDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreateDate()}
   */
  @Test
  @DisplayName(
      "Test getCreateDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getCreateDate()"})
  void testGetCreateDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDate());
  }

  /**
   * Test {@link XMPBasicSchema#getCreatorToolProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreatorToolProperty()}
   */
  @Test
  @DisplayName("Test getCreatorToolProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getCreatorToolProperty()"})
  void testGetCreatorToolProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorToolProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getCreatorToolProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreatorToolProperty()}
   */
  @Test
  @DisplayName(
      "Test getCreatorToolProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getCreatorToolProperty()"})
  void testGetCreatorToolProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getCreatorToolProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getCreatorToolProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreatorToolProperty()}
   */
  @Test
  @DisplayName(
      "Test getCreatorToolProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getCreatorToolProperty()"})
  void testGetCreatorToolProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorToolProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getCreatorTool()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreatorTool()}
   */
  @Test
  @DisplayName("Test getCreatorTool()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getCreatorTool()"})
  void testGetCreatorTool() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorTool());
  }

  /**
   * Test {@link XMPBasicSchema#getCreatorTool()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreatorTool()}
   */
  @Test
  @DisplayName(
      "Test getCreatorTool(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getCreatorTool()"})
  void testGetCreatorTool_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getCreatorTool());
  }

  /**
   * Test {@link XMPBasicSchema#getCreatorTool()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getCreatorTool()}
   */
  @Test
  @DisplayName(
      "Test getCreatorTool(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getCreatorTool()"})
  void testGetCreatorTool_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorTool());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiersProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  @DisplayName("Test getIdentifiersProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getIdentifiersProperty()"})
  void testGetIdentifiersProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act and Assert
    assertNull(xmpBasicSchema.getIdentifiersProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiersProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  @DisplayName(
      "Test getIdentifiersProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getIdentifiersProperty()"})
  void testGetIdentifiersProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getIdentifiersProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiersProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  @DisplayName(
      "Test getIdentifiersProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getIdentifiersProperty()"})
  void testGetIdentifiersProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act and Assert
    assertNull(xmpBasicSchema.getIdentifiersProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiersProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  @DisplayName(
      "Test getIdentifiersProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPBasicSchema.getIdentifiersProperty()"})
  void testGetIdentifiersProperty_thenReturnNamespaceIsHttpNsAdobeComXap10() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    ArrayProperty actualIdentifiersProperty = xmpBasicSchema.getIdentifiersProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/", actualIdentifiersProperty.getNamespace());
    assertEquals("xmp", actualIdentifiersProperty.getPrefix());
    assertEquals(1, actualIdentifiersProperty.getAllProperties().size());
    assertEquals(1, actualIdentifiersProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualIdentifiersProperty.getArrayType());
    assertTrue(actualIdentifiersProperty.getAllAttributes().isEmpty());
    assertTrue(actualIdentifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.IDENTIFIER, actualIdentifiersProperty.getPropertyName());
    assertSame(metadata, actualIdentifiersProperty.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiers()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiers()}
   */
  @Test
  @DisplayName("Test getIdentifiers(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getIdentifiers()"})
  void testGetIdentifiers_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getIdentifiers());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiers()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiers()}
   */
  @Test
  @DisplayName("Test getIdentifiers(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getIdentifiers()"})
  void testGetIdentifiers_thenReturnNull2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act and Assert
    assertNull(xmpBasicSchema.getIdentifiers());
  }

  /**
   * Test {@link XMPBasicSchema#getIdentifiers()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getIdentifiers()}
   */
  @Test
  @DisplayName("Test getIdentifiers(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getIdentifiers()"})
  void testGetIdentifiers_thenReturnSizeIsOne() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    List<String> actualIdentifiers = xmpBasicSchema.getIdentifiers();

    // Assert
    assertEquals(1, actualIdentifiers.size());
    assertEquals(XMPBasicSchema.THUMBNAILS, actualIdentifiers.get(0));
  }

  /**
   * Test {@link XMPBasicSchema#getLabelProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getLabelProperty()}
   */
  @Test
  @DisplayName("Test getLabelProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getLabelProperty()"})
  void testGetLabelProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabelProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getLabelProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getLabelProperty()}
   */
  @Test
  @DisplayName(
      "Test getLabelProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getLabelProperty()"})
  void testGetLabelProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getLabelProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getLabelProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getLabelProperty()}
   */
  @Test
  @DisplayName(
      "Test getLabelProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getLabelProperty()"})
  void testGetLabelProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabelProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getLabel()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getLabel()"})
  void testGetLabel() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabel());
  }

  /**
   * Test {@link XMPBasicSchema#getLabel()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getLabel()}
   */
  @Test
  @DisplayName(
      "Test getLabel(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getLabel()"})
  void testGetLabel_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getLabel());
  }

  /**
   * Test {@link XMPBasicSchema#getLabel()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getLabel()}
   */
  @Test
  @DisplayName(
      "Test getLabel(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getLabel()"})
  void testGetLabel_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabel());
  }

  /**
   * Test {@link XMPBasicSchema#getMetadataDateProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getMetadataDateProperty()}
   */
  @Test
  @DisplayName("Test getMetadataDateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getMetadataDateProperty()"})
  void testGetMetadataDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getMetadataDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getMetadataDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getMetadataDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getMetadataDateProperty()"})
  void testGetMetadataDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getMetadataDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getMetadataDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getMetadataDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getMetadataDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getMetadataDateProperty()"})
  void testGetMetadataDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getMetadataDate()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getMetadataDate()}
   */
  @Test
  @DisplayName("Test getMetadataDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getMetadataDate()"})
  void testGetMetadataDate() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDate());
  }

  /**
   * Test {@link XMPBasicSchema#getMetadataDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getMetadataDate()}
   */
  @Test
  @DisplayName(
      "Test getMetadataDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getMetadataDate()"})
  void testGetMetadataDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getMetadataDate());
  }

  /**
   * Test {@link XMPBasicSchema#getMetadataDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getMetadataDate()}
   */
  @Test
  @DisplayName(
      "Test getMetadataDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getMetadataDate()"})
  void testGetMetadataDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDate());
  }

  /**
   * Test {@link XMPBasicSchema#getModifyDateProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifyDateProperty()}
   */
  @Test
  @DisplayName("Test getModifyDateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getModifyDateProperty()"})
  void testGetModifyDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getModifyDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifyDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getModifyDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getModifyDateProperty()"})
  void testGetModifyDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getModifyDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getModifyDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifyDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getModifyDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getModifyDateProperty()"})
  void testGetModifyDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getModifierDateProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifierDateProperty()}
   */
  @Test
  @DisplayName("Test getModifierDateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getModifierDateProperty()"})
  void testGetModifierDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getModifierDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifierDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getModifierDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getModifierDateProperty()"})
  void testGetModifierDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getModifierDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getModifierDateProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifierDateProperty()}
   */
  @Test
  @DisplayName(
      "Test getModifierDateProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType XMPBasicSchema.getModifierDateProperty()"})
  void testGetModifierDateProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDateProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getModifyDate()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifyDate()}
   */
  @Test
  @DisplayName("Test getModifyDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getModifyDate()"})
  void testGetModifyDate() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDate());
  }

  /**
   * Test {@link XMPBasicSchema#getModifyDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifyDate()}
   */
  @Test
  @DisplayName(
      "Test getModifyDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getModifyDate()"})
  void testGetModifyDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getModifyDate());
  }

  /**
   * Test {@link XMPBasicSchema#getModifyDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifyDate()}
   */
  @Test
  @DisplayName(
      "Test getModifyDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getModifyDate()"})
  void testGetModifyDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDate());
  }

  /**
   * Test {@link XMPBasicSchema#getModifierDate()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifierDate()}
   */
  @Test
  @DisplayName("Test getModifierDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getModifierDate()"})
  void testGetModifierDate() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDate());
  }

  /**
   * Test {@link XMPBasicSchema#getModifierDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifierDate()}
   */
  @Test
  @DisplayName(
      "Test getModifierDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getModifierDate()"})
  void testGetModifierDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getModifierDate());
  }

  /**
   * Test {@link XMPBasicSchema#getModifierDate()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getModifierDate()}
   */
  @Test
  @DisplayName(
      "Test getModifierDate(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar XMPBasicSchema.getModifierDate()"})
  void testGetModifierDate_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDate());
  }

  /**
   * Test {@link XMPBasicSchema#getNicknameProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getNicknameProperty()}
   */
  @Test
  @DisplayName("Test getNicknameProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getNicknameProperty()"})
  void testGetNicknameProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNicknameProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getNicknameProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getNicknameProperty()}
   */
  @Test
  @DisplayName(
      "Test getNicknameProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getNicknameProperty()"})
  void testGetNicknameProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getNicknameProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getNicknameProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getNicknameProperty()}
   */
  @Test
  @DisplayName(
      "Test getNicknameProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPBasicSchema.getNicknameProperty()"})
  void testGetNicknameProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNicknameProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getNickname()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getNickname()}
   */
  @Test
  @DisplayName("Test getNickname()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getNickname()"})
  void testGetNickname() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNickname());
  }

  /**
   * Test {@link XMPBasicSchema#getNickname()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getNickname()}
   */
  @Test
  @DisplayName(
      "Test getNickname(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getNickname()"})
  void testGetNickname_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getNickname());
  }

  /**
   * Test {@link XMPBasicSchema#getNickname()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getNickname()}
   */
  @Test
  @DisplayName(
      "Test getNickname(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPBasicSchema.getNickname()"})
  void testGetNickname_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNickname());
  }

  /**
   * Test {@link XMPBasicSchema#getRatingProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getRatingProperty()}
   */
  @Test
  @DisplayName("Test getRatingProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType XMPBasicSchema.getRatingProperty()"})
  void testGetRatingProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRatingProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getRatingProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getRatingProperty()}
   */
  @Test
  @DisplayName(
      "Test getRatingProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType XMPBasicSchema.getRatingProperty()"})
  void testGetRatingProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getRatingProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getRatingProperty()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getRatingProperty()}
   */
  @Test
  @DisplayName(
      "Test getRatingProperty(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType XMPBasicSchema.getRatingProperty()"})
  void testGetRatingProperty_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRatingProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getRating()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getRating()}
   */
  @Test
  @DisplayName("Test getRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer XMPBasicSchema.getRating()"})
  void testGetRating() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRating());
  }

  /**
   * Test {@link XMPBasicSchema#getRating()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getRating()}
   */
  @Test
  @DisplayName(
      "Test getRating(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer XMPBasicSchema.getRating()"})
  void testGetRating_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getRating());
  }

  /**
   * Test {@link XMPBasicSchema#getRating()}.
   *
   * <ul>
   *   <li>Given {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getRating()}
   */
  @Test
  @DisplayName(
      "Test getRating(); given XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer XMPBasicSchema.getRating()"})
  void testGetRating_givenXMPBasicSchemaWithMetadataIsCreateXMPMetadata2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRating());
  }

  /**
   * Test {@link XMPBasicSchema#getThumbnailsProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  @DisplayName("Test getThumbnailsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getThumbnailsProperty()"})
  void testGetThumbnailsProperty() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.THUMBNAILS, XMPBasicSchema.THUMBNAILS);

    // Act
    List<ThumbnailType> actualThumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();

    // Assert
    assertEquals(1, actualThumbnailsProperty.size());
    ThumbnailType getResult = actualThumbnailsProperty.get(0);
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult.getNamespace());
    assertEquals("xmpGImg", getResult.getPreferedPrefix());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getPropertyName());
    assertEquals(1, getResult.getWidth().intValue());
    assertEquals(1, getResult.getAllAttributes().size());
    assertEquals(2, getResult.getHeight().intValue());
    assertEquals(4, getResult.getAllProperties().size());
    assertTrue(getResult.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getFormat());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getImage());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPBasicSchema#getThumbnailsProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  @DisplayName("Test getThumbnailsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getThumbnailsProperty()"})
  void testGetThumbnailsProperty2() throws BadFieldValueException {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.THUMBNAILS, "42");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> xmpBasicSchema.getThumbnailsProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getThumbnailsProperty()}.
   *
   * <p>Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  @DisplayName("Test getThumbnailsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getThumbnailsProperty()"})
  void testGetThumbnailsProperty3() throws BadFieldValueException {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            XMPBasicSchema.THUMBNAILS,
            XMPBasicSchema.THUMBNAILS,
            XMPBasicSchema.THUMBNAILS,
            "Value");
    xmpBasicSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> xmpBasicSchema.getThumbnailsProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getThumbnailsProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  @DisplayName("Test getThumbnailsProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getThumbnailsProperty()"})
  void testGetThumbnailsProperty_thenReturnNull() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new XMPBasicSchema(XMPMetadata.createXMPMetadata()).getThumbnailsProperty());
  }

  /**
   * Test {@link XMPBasicSchema#getThumbnailsProperty()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  @DisplayName("Test getThumbnailsProperty(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPBasicSchema.getThumbnailsProperty()"})
  void testGetThumbnailsProperty_thenReturnSizeIsOne() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.THUMBNAILS, XMPBasicSchema.THUMBNAILS);

    // Act
    List<ThumbnailType> actualThumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();

    // Assert
    assertEquals(1, actualThumbnailsProperty.size());
    ThumbnailType getResult = actualThumbnailsProperty.get(0);
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult.getNamespace());
    assertEquals("xmpGImg", getResult.getPreferedPrefix());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getPropertyName());
    assertEquals(1, getResult.getWidth().intValue());
    assertEquals(1, getResult.getAllAttributes().size());
    assertEquals(2, getResult.getHeight().intValue());
    assertEquals(4, getResult.getAllProperties().size());
    assertTrue(getResult.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getFormat());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getImage());
    assertSame(metadata, getResult.getMetadata());
  }
}
