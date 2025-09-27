package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.transform.TransformerException;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.CFAPatternType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class XmpSerializerDiffblueTest {
  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>Then array length is four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); then array length is four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_thenArrayLengthIsFourHundredFifteen() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();

    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("xpacket", "xpacket");

    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    metadata.addSchema(obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(415, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>Then array length is four hundred seventeen.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); then array length is four hundred seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_thenArrayLengthIsFourHundredSeventeen() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();

    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValue("RDF", new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    metadata.addSchema(obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(417, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>Then array length is three hundred eighty.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); then array length is three hundred eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_thenArrayLengthIsThreeHundredEighty() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();

    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    metadata.addSchema(obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(380, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>Then array length is three hundred eleven.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); then array length is three hundred eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_thenArrayLengthIsThreeHundredEleven() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();

    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.addNamespace("adobe:ns:meta/", "xpacket");

    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    metadata.addSchema(obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(311, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>Then array length is three hundred forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); then array length is three hundred forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_thenArrayLengthIsThreeHundredFortyNine() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();

    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj2 =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "xpacket", "xpacket", "xpacket", "Value");
    obj.addProperty(obj2);

    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    metadata.addSchema(obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(349, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>Then array length is two hundred eighty.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); then array length is two hundred eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_thenArrayLengthIsTwoHundredEighty() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();

    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    metadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(280, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>When createXMPMetadata.
   *   <li>Then array length is one hundred ninety-one.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); when createXMPMetadata; then array length is one hundred ninety-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_whenCreateXMPMetadata_thenArrayLengthIsOneHundredNinetyOne()
      throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(191, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then array length is one hundred nineteen.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test serialize(XMPMetadata, OutputStream, boolean); when 'false'; then array length is one hundred nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_whenFalse_thenArrayLengthIsOneHundredNineteen() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Act
    xmpSerializer.serialize(metadata, os, false);

    // Assert
    assertEquals(119, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AbstractField}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link AbstractField}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test serializeFields(Document, Element, List, String, String, boolean); given AbstractField; when ArrayList() add AbstractField")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"
  })
  void testSerializeFields_givenAbstractField_whenArrayListAddAbstractField() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    IIOMetadataNode parent = new IIOMetadataNode();

    AgentNameType agentNameType = mock(AgentNameType.class);
    when(agentNameType.getPrefix()).thenReturn("Prefix");
    when(agentNameType.getPropertyName()).thenThrow(new RuntimeException());

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(mock(AbstractField.class));
    fields.add(agentNameType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> xmpSerializer.serializeFields(null, parent, fields, "Resource NS", null, true));
    verify(agentNameType).getPropertyName();
    verify(agentNameType).getPrefix();
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AgentNameType} {@link AgentNameType#getPrefix()} return {@code Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test serializeFields(Document, Element, List, String, String, boolean); given AgentNameType getPrefix() return 'Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"
  })
  void testSerializeFields_givenAgentNameTypeGetPrefixReturnPrefix() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    IIOMetadataNode parent = new IIOMetadataNode();

    AgentNameType agentNameType = mock(AgentNameType.class);
    when(agentNameType.getPrefix()).thenReturn("Prefix");
    when(agentNameType.getPropertyName()).thenThrow(new RuntimeException());

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(agentNameType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> xmpSerializer.serializeFields(null, parent, fields, "Resource NS", null, true));
    verify(agentNameType).getPropertyName();
    verify(agentNameType).getPrefix();
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AgentNameType} {@link AgentNameType#getPrefix()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test serializeFields(Document, Element, List, String, String, boolean); given AgentNameType getPrefix() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"
  })
  void testSerializeFields_givenAgentNameTypeGetPrefixThrowRuntimeException() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    IIOMetadataNode parent = new IIOMetadataNode();

    AgentNameType agentNameType = mock(AgentNameType.class);
    when(agentNameType.getPrefix()).thenThrow(new RuntimeException());

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(agentNameType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> xmpSerializer.serializeFields(null, parent, fields, "Resource NS", null, true));
    verify(agentNameType).getPrefix();
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link CFAPatternType#getAllProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test serializeFields(Document, Element, List, String, String, boolean); then calls getAllProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"
  })
  void testSerializeFields_thenCallsGetAllProperties() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    IIOMetadataNode parent = new IIOMetadataNode();

    CFAPatternType cfaPatternType = mock(CFAPatternType.class);
    when(cfaPatternType.getAllProperties()).thenThrow(new RuntimeException());

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(cfaPatternType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> xmpSerializer.serializeFields(null, parent, fields, "Resource NS", "", false));
    verify(cfaPatternType).getAllProperties();
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayProperty#getPrefix()}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test serializeFields(Document, Element, List, String, String, boolean); then calls getPrefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"
  })
  void testSerializeFields_thenCallsGetPrefix() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    IIOMetadataNode parent = new IIOMetadataNode();

    ArrayProperty arrayProperty = mock(ArrayProperty.class);
    when(arrayProperty.getPrefix()).thenThrow(new RuntimeException());

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(arrayProperty);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> xmpSerializer.serializeFields(null, parent, fields, "Resource NS", null, false));
    verify(arrayProperty).getPrefix();
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link AgentNameType#getPropertyName()}.
   * </ul>
   *
   * <p>Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test serializeFields(Document, Element, List, String, String, boolean); then calls getPropertyName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"
  })
  void testSerializeFields_thenCallsGetPropertyName() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    IIOMetadataNode parent = new IIOMetadataNode();

    AgentNameType agentNameType = mock(AgentNameType.class);
    when(agentNameType.getPropertyName()).thenThrow(new RuntimeException());

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(agentNameType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> xmpSerializer.serializeFields(null, parent, fields, "Resource NS", "Prefix", true));
    verify(agentNameType).getPropertyName();
  }
}
