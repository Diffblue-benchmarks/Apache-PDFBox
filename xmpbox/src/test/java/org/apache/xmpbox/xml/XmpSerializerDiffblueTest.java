package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.transform.TransformerException;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.apache.xmpbox.schema.XMPSchema;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Cardinality;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

class XmpSerializerDiffblueTest {
  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   * <ul>
   *   <li>When createXMPMetadata.</li>
   *   <li>Then array length is one hundred ninety-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName("Test serialize(XMPMetadata, OutputStream, boolean); when createXMPMetadata; then array length is one hundred ninety-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_whenCreateXMPMetadata_thenArrayLengthIsOneHundredNinetyOne() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ByteArrayOutputStream os = new ByteArrayOutputStream(1);

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert
    assertEquals(191, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then array length is one hundred nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  @DisplayName("Test serialize(XMPMetadata, OutputStream, boolean); when 'false'; then array length is one hundred nineteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serialize(XMPMetadata, OutputStream, boolean)"})
  void testSerialize_whenFalse_thenArrayLengthIsOneHundredNineteen() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ByteArrayOutputStream os = new ByteArrayOutputStream(1);

    // Act
    xmpSerializer.serialize(metadata, os, false);

    // Assert
    assertEquals(119, os.toByteArray().length);
  }

  /**
   * Test {@link XmpSerializer#serializeSchema(Document, XMPSchema)}.
   * <ul>
   *   <li>Then return {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeSchema(Document, XMPSchema)}
   */
  @Test
  @DisplayName("Test serializeSchema(Document, XMPSchema); then return IIOMetadataNode(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.serializeSchema(Document, XMPSchema)"})
  void testSerializeSchema_thenReturnIIOMetadataNodeWithFoo() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElementNS(Mockito.<String>any(), Mockito.<String>any())).thenReturn(iioMetadataNode);

    // Act
    Element actualSerializeSchemaResult = xmpSerializer.serializeSchema(doc,
        new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Assert
    verify(doc).createElementNS(eq("http://www.w3.org/1999/02/22-rdf-syntax-ns#"), eq("rdf:Description"));
    assertSame(iioMetadataNode, actualSerializeSchemaResult);
  }

  /**
   * Test {@link XmpSerializer#serializeSchema(Document, XMPSchema)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeSchema(Document, XMPSchema)}
   */
  @Test
  @DisplayName("Test serializeSchema(Document, XMPSchema); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.serializeSchema(Document, XMPSchema)"})
  void testSerializeSchema_thenThrowRuntimeException() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any()))
        .thenThrow(new RuntimeException("http://www.w3.org/1999/02/22-rdf-syntax-ns#"));
    when(doc.createElementNS(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));

    AdobePDFSchema schema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    schema.addBagValueAsSimple("rdf:Description", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> xmpSerializer.serializeSchema(doc, schema));
    verify(doc).createElement(eq("pdf:rdf:Description"));
    verify(doc).createElementNS(eq("http://www.w3.org/1999/02/22-rdf-syntax-ns#"), eq("rdf:Description"));
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any())).thenThrow(new RuntimeException("rdf:li"));
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AgentNameType(XMPMetadata.createXMPMetadata(), "rdf:li", "rdf:li", "rdf:li", "Value"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false));
    verify(doc).createElement(eq("rdf:li:rdf:li"));
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields2() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any())).thenThrow(new RuntimeException("rdf:li"));
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new ArrayProperty(XMPMetadata.createXMPMetadata(), "rdf:li", "rdf:li", "rdf:li", Cardinality.Simple));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false));
    verify(doc).createElement(eq("rdf:li:rdf:li"));
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields3() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElement(Mockito.<String>any())).thenReturn(iioMetadataNode);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayProperty arrayProperty = new ArrayProperty(XMPMetadata.createXMPMetadata(), "Namespace", "Prefix",
        "Property Name", Cardinality.Simple);
    arrayProperty.addNamespace("Namespace", "Prefix");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(arrayProperty);

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false);

    // Assert
    verify(doc, atLeast(1)).createElement(Mockito.<String>any());
    Node firstChild = parent.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertEquals(1, ((IIOMetadataNode) firstChild).getLength());
    assertTrue(firstChild.hasChildNodes());
    assertSame(iioMetadataNode, firstChild.getFirstChild());
    assertSame(iioMetadataNode, firstChild.getLastChild());
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code rdf:li}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); given RuntimeException(String) with 'rdf:li'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_givenRuntimeExceptionWithRdfLi_thenThrowRuntimeException() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any())).thenThrow(new RuntimeException("rdf:li"));
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false));
    verify(doc).createElement(eq("rdf:li"));
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} FirstChild FirstChild is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); then IIOMetadataNode(String) with 'foo' FirstChild FirstChild is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_thenIIOMetadataNodeWithFooFirstChildFirstChildIsNull() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false);

    // Assert
    verify(doc).createElement(eq("rdf:li"));
    Node firstChild = parent.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertEquals(0, ((IIOMetadataNode) firstChild).getLength());
    assertFalse(firstChild.hasChildNodes());
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} FirstChild Length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); then IIOMetadataNode(String) with 'foo' FirstChild Length is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_thenIIOMetadataNodeWithFooFirstChildLengthIsTwo() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElement(Mockito.<String>any())).thenReturn(iioMetadataNode);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(adobePDFSchema);

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false);

    // Assert
    verify(doc, atLeast(1)).createElement(Mockito.<String>any());
    Node firstChild = parent.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertEquals(2, ((IIOMetadataNode) firstChild).getLength());
    assertTrue(firstChild.hasChildNodes());
    assertSame(iioMetadataNode, firstChild.getFirstChild());
    assertSame(iioMetadataNode, firstChild.getLastChild());
    assertSame(iioMetadataNode, firstChild.getPreviousSibling());
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>Then not {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} FirstChild hasAttributes.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); then not IIOMetadataNode(String) with 'foo' FirstChild hasAttributes")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_thenNotIIOMetadataNodeWithFooFirstChildHasAttributes() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElement(Mockito.<String>any())).thenReturn(iioMetadataNode);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new ArrayProperty(XMPMetadata.createXMPMetadata(), "rdf:li", "rdf:li", "rdf:li", Cardinality.Simple));

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false);

    // Assert
    verify(doc, atLeast(1)).createElement(Mockito.<String>any());
    Node firstChild = parent.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertEquals(1, ((IIOMetadataNode) firstChild).getLength());
    assertFalse(firstChild.hasAttributes());
    assertTrue(firstChild.hasChildNodes());
    assertSame(iioMetadataNode, firstChild.getFirstChild());
    assertSame(iioMetadataNode, firstChild.getLastChild());
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>When {@link Document}.</li>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} FirstChild is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); when Document; then IIOMetadataNode(String) with 'foo' FirstChild is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_whenDocument_thenIIOMetadataNodeWithFooFirstChildIsNull() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    // Act
    xmpSerializer.serializeFields(doc, parent, new ArrayList<>(), "Resource NS", "Prefix", true);

    // Assert that nothing has changed
    assertNull(parent.getFirstChild());
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_whenEmptyString() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", "", false);

    // Assert
    verify(doc).createElement(eq("rdf:li"));
    Node firstChild = parent.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertEquals(0, ((IIOMetadataNode) firstChild).getLength());
    assertFalse(firstChild.hasChildNodes());
  }

  /**
   * Test {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  @DisplayName("Test serializeFields(Document, Element, List, String, String, boolean); when 'true'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmpSerializer.serializeFields(Document, Element, List, String, String, boolean)"})
  void testSerializeFields_whenTrue_thenThrowRuntimeException() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElement(Mockito.<String>any())).thenThrow(new RuntimeException("rdf:li"));
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, true));
    verify(doc).createElement(eq("Resource NS:null"));
  }

  /**
   * Test {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}.
   * <p>
   * Method under test: {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  @DisplayName("Test createRdfElement(Document, XMPMetadata, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.createRdfElement(Document, XMPMetadata, boolean)"})
  void testCreateRdfElement() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createProcessingInstruction(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("xpacket"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.createRdfElement(doc, XMPMetadata.createXMPMetadata(), true));
    verify(doc).createProcessingInstruction(eq("xpacket"), eq("begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\""));
  }

  /**
   * Test {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}.
   * <ul>
   *   <li>Given {@link ProcessingInstruction}.</li>
   *   <li>Then return {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  @DisplayName("Test createRdfElement(Document, XMPMetadata, boolean); given ProcessingInstruction; then return IIOMetadataNode(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.createRdfElement(Document, XMPMetadata, boolean)"})
  void testCreateRdfElement_givenProcessingInstruction_thenReturnIIOMetadataNodeWithFoo() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElementNS(Mockito.<String>any(), Mockito.<String>any())).thenReturn(iioMetadataNode);
    when(doc.appendChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(doc.createProcessingInstruction(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(mock(ProcessingInstruction.class));

    // Act
    Element actualCreateRdfElementResult = xmpSerializer.createRdfElement(doc, XMPMetadata.createXMPMetadata(), true);

    // Assert
    verify(doc, atLeast(1)).createElementNS(Mockito.<String>any(), Mockito.<String>any());
    verify(doc, atLeast(1)).createProcessingInstruction(eq("xpacket"), Mockito.<String>any());
    verify(doc, atLeast(1)).appendChild(Mockito.<Node>any());
    assertSame(iioMetadataNode, actualCreateRdfElementResult);
  }

  /**
   * Test {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}.
   * <ul>
   *   <li>When {@link Document} {@link Node#appendChild(Node)} throw {@link RuntimeException#RuntimeException(String)} with {@code xpacket}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  @DisplayName("Test createRdfElement(Document, XMPMetadata, boolean); when Document appendChild(Node) throw RuntimeException(String) with 'xpacket'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.createRdfElement(Document, XMPMetadata, boolean)"})
  void testCreateRdfElement_whenDocumentAppendChildThrowRuntimeExceptionWithXpacket() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.appendChild(Mockito.<Node>any())).thenThrow(new RuntimeException("xpacket"));
    when(doc.createElementNS(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.createRdfElement(doc, XMPMetadata.createXMPMetadata(), false));
    verify(doc).createElementNS(eq("adobe:ns:meta/"), eq("x:xmpmeta"));
    verify(doc).appendChild(isA(Node.class));
  }

  /**
   * Test {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}.
   * <ul>
   *   <li>When {@link Document} {@link Node#appendChild(Node)} throw {@link RuntimeException#RuntimeException(String)} with {@code xpacket}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  @DisplayName("Test createRdfElement(Document, XMPMetadata, boolean); when Document appendChild(Node) throw RuntimeException(String) with 'xpacket'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.createRdfElement(Document, XMPMetadata, boolean)"})
  void testCreateRdfElement_whenDocumentAppendChildThrowRuntimeExceptionWithXpacket2() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createProcessingInstruction(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(mock(ProcessingInstruction.class));
    when(doc.appendChild(Mockito.<Node>any())).thenThrow(new RuntimeException("xpacket"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.createRdfElement(doc, XMPMetadata.createXMPMetadata(), true));
    verify(doc).createProcessingInstruction(eq("xpacket"), eq("begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\""));
    verify(doc).appendChild(isA(Node.class));
  }

  /**
   * Test {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}.
   * <ul>
   *   <li>When {@link Document} {@link Document#createElementNS(String, String)} throw {@link RuntimeException#RuntimeException(String)} with {@code xpacket}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  @DisplayName("Test createRdfElement(Document, XMPMetadata, boolean); when Document createElementNS(String, String) throw RuntimeException(String) with 'xpacket'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.createRdfElement(Document, XMPMetadata, boolean)"})
  void testCreateRdfElement_whenDocumentCreateElementNSThrowRuntimeExceptionWithXpacket() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    when(doc.createElementNS(Mockito.<String>any(), Mockito.<String>any())).thenThrow(new RuntimeException("xpacket"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> xmpSerializer.createRdfElement(doc, XMPMetadata.createXMPMetadata(), false));
    verify(doc).createElementNS(eq("adobe:ns:meta/"), eq("x:xmpmeta"));
  }

  /**
   * Test {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  @DisplayName("Test createRdfElement(Document, XMPMetadata, boolean); when 'false'; then return IIOMetadataNode(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element XmpSerializer.createRdfElement(Document, XMPMetadata, boolean)"})
  void testCreateRdfElement_whenFalse_thenReturnIIOMetadataNodeWithFoo() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElementNS(Mockito.<String>any(), Mockito.<String>any())).thenReturn(iioMetadataNode);
    when(doc.appendChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));

    // Act
    Element actualCreateRdfElementResult = xmpSerializer.createRdfElement(doc, XMPMetadata.createXMPMetadata(), false);

    // Assert
    verify(doc, atLeast(1)).createElementNS(Mockito.<String>any(), Mockito.<String>any());
    verify(doc).appendChild(isA(Node.class));
    assertSame(iioMetadataNode, actualCreateRdfElementResult);
  }
}
