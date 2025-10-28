package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

class XmpSerializerDiffblueTest {
  /**
   * Method under test:
   * {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  void testSerialize() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ByteArrayOutputStream os = new ByteArrayOutputStream(1);

    // Act
    xmpSerializer.serialize(metadata, os, true);

    // Assert that nothing has changed
    byte[] toByteArrayResult = os.toByteArray();
    assertEquals((byte) -17, toByteArrayResult[17]);
    assertEquals((byte) -65, toByteArrayResult[19]);
    assertEquals((byte) -69, toByteArrayResult[18]);
    assertEquals(191, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[180]);
    assertEquals(' ', toByteArrayResult[21]);
    assertEquals(' ', toByteArrayResult[9]);
    assertEquals('<', toByteArrayResult[0]);
    assertEquals('<', toByteArrayResult[171]);
    assertEquals('=', toByteArrayResult[15]);
    assertEquals('=', toByteArrayResult[184]);
    assertEquals('=', toByteArrayResult[24]);
    assertEquals('>', toByteArrayResult[170]);
    assertEquals('>', toByteArrayResult[189]);
    assertEquals('?', toByteArrayResult[1]);
    assertEquals('?', toByteArrayResult[172]);
    assertEquals('?', toByteArrayResult[188]);
    assertEquals('"', toByteArrayResult[185]);
    assertEquals('"', toByteArrayResult[187]);
    assertEquals('"', toByteArrayResult[20]);
    assertEquals('"', toByteArrayResult[Short.SIZE]);
    assertEquals('\n', toByteArrayResult[190]);
    assertEquals('a', toByteArrayResult[169]);
    assertEquals('a', toByteArrayResult[175]);
    assertEquals('a', toByteArrayResult[4]);
    assertEquals('b', toByteArrayResult[10]);
    assertEquals('c', toByteArrayResult[176]);
    assertEquals('c', toByteArrayResult[5]);
    assertEquals('d', toByteArrayResult[183]);
    assertEquals('d', toByteArrayResult[23]);
    assertEquals('e', toByteArrayResult[11]);
    assertEquals('e', toByteArrayResult[167]);
    assertEquals('e', toByteArrayResult[178]);
    assertEquals('e', toByteArrayResult[181]);
    assertEquals('e', toByteArrayResult[7]);
    assertEquals('g', toByteArrayResult[12]);
    assertEquals('i', toByteArrayResult[13]);
    assertEquals('i', toByteArrayResult[22]);
    assertEquals('k', toByteArrayResult[177]);
    assertEquals('k', toByteArrayResult[6]);
    assertEquals('m', toByteArrayResult[166]);
    assertEquals('n', toByteArrayResult[14]);
    assertEquals('n', toByteArrayResult[182]);
    assertEquals('p', toByteArrayResult[174]);
    assertEquals('p', toByteArrayResult[3]);
    assertEquals('t', toByteArrayResult[168]);
    assertEquals('t', toByteArrayResult[179]);
    assertEquals('t', toByteArrayResult[8]);
    assertEquals('w', toByteArrayResult[186]);
    assertEquals('x', toByteArrayResult[173]);
    assertEquals('x', toByteArrayResult[2]);
  }

  /**
   * Method under test:
   * {@link XmpSerializer#serialize(XMPMetadata, OutputStream, boolean)}
   */
  @Test
  void testSerialize2() throws TransformerException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ByteArrayOutputStream os = new ByteArrayOutputStream(1);

    // Act
    xmpSerializer.serialize(metadata, os, false);

    // Assert that nothing has changed
    byte[] toByteArrayResult = os.toByteArray();
    assertEquals(119, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[10]);
    assertEquals('#', toByteArrayResult[101]);
    assertEquals('-', toByteArrayResult[98]);
    assertEquals('/', toByteArrayResult[103]);
    assertEquals('/', toByteArrayResult[107]);
    assertEquals(':', toByteArrayResult[109]);
    assertEquals(':', toByteArrayResult[2]);
    assertEquals(':', toByteArrayResult[Short.SIZE]);
    assertEquals('<', toByteArrayResult[0]);
    assertEquals('<', toByteArrayResult[106]);
    assertEquals('=', toByteArrayResult[18]);
    assertEquals('>', toByteArrayResult[104]);
    assertEquals('>', toByteArrayResult[117]);
    assertEquals('"', toByteArrayResult[102]);
    assertEquals('"', toByteArrayResult[19]);
    assertEquals('\n', toByteArrayResult[105]);
    assertEquals('\n', toByteArrayResult[118]);
    assertEquals('a', toByteArrayResult[116]);
    assertEquals('a', toByteArrayResult[20]);
    assertEquals('a', toByteArrayResult[9]);
    assertEquals('a', toByteArrayResult[96]);
    assertEquals('b', toByteArrayResult[23]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('e', toByteArrayResult[114]);
    assertEquals('e', toByteArrayResult[24]);
    assertEquals('e', toByteArrayResult[7]);
    assertEquals('l', toByteArrayResult[13]);
    assertEquals('m', toByteArrayResult[111]);
    assertEquals('m', toByteArrayResult[113]);
    assertEquals('m', toByteArrayResult[12]);
    assertEquals('m', toByteArrayResult[4]);
    assertEquals('m', toByteArrayResult[6]);
    assertEquals('n', toByteArrayResult[14]);
    assertEquals('n', toByteArrayResult[94]);
    assertEquals('n', toByteArrayResult[99]);
    assertEquals('o', toByteArrayResult[22]);
    assertEquals('p', toByteArrayResult[112]);
    assertEquals('p', toByteArrayResult[5]);
    assertEquals('s', toByteArrayResult[100]);
    assertEquals('s', toByteArrayResult[15]);
    assertEquals('t', toByteArrayResult[115]);
    assertEquals('t', toByteArrayResult[8]);
    assertEquals('t', toByteArrayResult[95]);
    assertEquals('x', toByteArrayResult[1]);
    assertEquals('x', toByteArrayResult[108]);
    assertEquals('x', toByteArrayResult[11]);
    assertEquals('x', toByteArrayResult[110]);
    assertEquals('x', toByteArrayResult[17]);
    assertEquals('x', toByteArrayResult[3]);
    assertEquals('x', toByteArrayResult[97]);
  }

  /**
   * Method under test: {@link XmpSerializer#serializeSchema(Document, XMPSchema)}
   */
  @Test
  void testSerializeSchema() throws DOMException {
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
   * Method under test: {@link XmpSerializer#serializeSchema(Document, XMPSchema)}
   */
  @Test
  void testSerializeSchema2() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields() {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    // Act
    xmpSerializer.serializeFields(doc, parent, new ArrayList<>(), "Resource NS", "Prefix", true);

    // Assert that nothing has changed
    assertEquals(0, parent.getLength());
    assertFalse(parent.hasChildNodes());
  }

  /**
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields2() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElement(Mockito.<String>any())).thenReturn(iioMetadataNode);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", null, false);

    // Assert that nothing has changed
    verify(doc).createElement(eq("rdf:li"));
    assertEquals(1, parent.getLength());
    assertTrue(parent.hasChildNodes());
    assertSame(iioMetadataNode, parent.getFirstChild());
    assertSame(iioMetadataNode, parent.getLastChild());
  }

  /**
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields3() throws DOMException {
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

    // Assert that nothing has changed
    verify(doc, atLeast(1)).createElement(Mockito.<String>any());
    assertEquals(1, parent.getLength());
    assertTrue(parent.hasChildNodes());
    assertSame(iioMetadataNode, parent.getFirstChild());
    assertSame(iioMetadataNode, parent.getLastChild());
  }

  /**
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields4() throws DOMException {
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

    // Assert that nothing has changed
    verify(doc, atLeast(1)).createElement(Mockito.<String>any());
    assertEquals(1, parent.getLength());
    assertTrue(parent.hasChildNodes());
    assertSame(iioMetadataNode, parent.getFirstChild());
    assertSame(iioMetadataNode, parent.getLastChild());
  }

  /**
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields5() throws DOMException {
    // Arrange
    XmpSerializer xmpSerializer = new XmpSerializer();
    Document doc = mock(Document.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(doc.createElement(Mockito.<String>any())).thenReturn(iioMetadataNode);
    IIOMetadataNode parent = new IIOMetadataNode("foo");

    ArrayList<AbstractField> fields = new ArrayList<>();
    fields.add(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    xmpSerializer.serializeFields(doc, parent, fields, "Resource NS", "", false);

    // Assert that nothing has changed
    verify(doc).createElement(eq("rdf:li"));
    assertEquals(1, parent.getLength());
    assertTrue(parent.hasChildNodes());
    assertSame(iioMetadataNode, parent.getFirstChild());
    assertSame(iioMetadataNode, parent.getLastChild());
  }

  /**
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields6() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields7() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields8() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields9() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#serializeFields(Document, Element, List, String, String, boolean)}
   */
  @Test
  void testSerializeFields10() throws DOMException {
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

    // Assert that nothing has changed
    verify(doc, atLeast(1)).createElement(Mockito.<String>any());
    assertEquals(1, parent.getLength());
    assertTrue(parent.hasChildNodes());
    assertSame(iioMetadataNode, parent.getFirstChild());
    assertSame(iioMetadataNode, parent.getLastChild());
  }

  /**
   * Method under test:
   * {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  void testCreateRdfElement() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  void testCreateRdfElement2() throws DOMException {
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

  /**
   * Method under test:
   * {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  void testCreateRdfElement3() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  void testCreateRdfElement4() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  void testCreateRdfElement5() throws DOMException {
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
   * Method under test:
   * {@link XmpSerializer#createRdfElement(Document, XMPMetadata, boolean)}
   */
  @Test
  void testCreateRdfElement6() throws DOMException {
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
}
