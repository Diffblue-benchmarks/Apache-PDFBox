package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Attribute;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.LayerType;
import org.apache.xmpbox.type.ProperNameType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URIType;
import org.junit.jupiter.api.Test;

class PhotoshopSchemaDiffblueTest {
  /**
   * Method under test: {@link PhotoshopSchema#getAncestorIDProperty()}
   */
  @Test
  void testGetAncestorIDProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getAncestorIDProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAncestorIDProperty()}
   */
  @Test
  void testGetAncestorIDProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorIDProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAncestorIDProperty()}
   */
  @Test
  void testGetAncestorIDProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorIDProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAncestorID()}
   */
  @Test
  void testGetAncestorID() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getAncestorID());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAncestorID()}
   */
  @Test
  void testGetAncestorID2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorID());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAncestorID()}
   */
  @Test
  void testGetAncestorID3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorID());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  void testSetAncestorID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(0));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  void testSetAncestorID2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(1));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  void testSetAncestorID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(2));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  void testSetAncestorID4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.ANCESTORID, "42");

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(0));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  void testSetAncestorIDProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    URIType text = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  void testSetAncestorIDProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    URIType text = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  void testSetAncestorIDProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    URIType text = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  void testSetAncestorIDProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    URIType text = new URIType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAuthorsPositionProperty()}
   */
  @Test
  void testGetAuthorsPositionProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getAuthorsPositionProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAuthorsPositionProperty()}
   */
  @Test
  void testGetAuthorsPositionProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPositionProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAuthorsPositionProperty()}
   */
  @Test
  void testGetAuthorsPositionProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPositionProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAuthorsPosition()}
   */
  @Test
  void testGetAuthorsPosition() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getAuthorsPosition());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAuthorsPosition()}
   */
  @Test
  void testGetAuthorsPosition2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPosition());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getAuthorsPosition()}
   */
  @Test
  void testGetAuthorsPosition3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPosition());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  void testSetAuthorsPosition() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(0));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  void testSetAuthorsPosition2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(1));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  void testSetAuthorsPosition3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(2));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  void testSetAuthorsPosition4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.AUTHORS_POSITION, "42");

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(0));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  void testSetAuthorsPositionProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  void testSetAuthorsPositionProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  void testSetAuthorsPositionProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  void testSetAuthorsPositionProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCaptionWriterProperty()}
   */
  @Test
  void testGetCaptionWriterProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCaptionWriterProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCaptionWriterProperty()}
   */
  @Test
  void testGetCaptionWriterProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriterProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCaptionWriterProperty()}
   */
  @Test
  void testGetCaptionWriterProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriterProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCaptionWriter()}
   */
  @Test
  void testGetCaptionWriter() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCaptionWriter());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCaptionWriter()}
   */
  @Test
  void testGetCaptionWriter2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriter());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCaptionWriter()}
   */
  @Test
  void testGetCaptionWriter3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriter());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  void testSetCaptionWriter() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  void testSetCaptionWriter2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  void testSetCaptionWriter3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  void testSetCaptionWriter4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CAPTION_WRITER, "42");

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  void testSetCaptionWriterProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    ProperNameType text = new ProperNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  void testSetCaptionWriterProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    ProperNameType text = new ProperNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  void testSetCaptionWriterProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    ProperNameType text = new ProperNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  void testSetCaptionWriterProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    ProperNameType text = new ProperNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCategoryProperty()}
   */
  @Test
  void testGetCategoryProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCategoryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCategoryProperty()}
   */
  @Test
  void testGetCategoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategoryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCategoryProperty()}
   */
  @Test
  void testGetCategoryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategoryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCategory()}
   */
  @Test
  void testGetCategory() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCategory());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCategory()}
   */
  @Test
  void testGetCategory2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategory());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCategory()}
   */
  @Test
  void testGetCategory3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategory());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  void testSetCategory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(0));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  void testSetCategory2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(1));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  void testSetCategory3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(2));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  void testSetCategory4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CATEGORY, "42");

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(0));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  void testSetCategoryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  void testSetCategoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  void testSetCategoryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  void testSetCategoryProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCityProperty()}
   */
  @Test
  void testGetCityProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCityProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCityProperty()}
   */
  @Test
  void testGetCityProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCityProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCityProperty()}
   */
  @Test
  void testGetCityProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCityProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCity()}
   */
  @Test
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCity());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCity()}
   */
  @Test
  void testGetCity2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCity());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCity()}
   */
  @Test
  void testGetCity3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCity());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  void testSetCity() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(0));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  void testSetCity2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(1));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  void testSetCity3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(2));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  void testSetCity4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CITY, "42");

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(0));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  void testSetCityProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  void testSetCityProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  void testSetCityProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  void testSetCityProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getColorModeProperty()}
   */
  @Test
  void testGetColorModeProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getColorModeProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getColorModeProperty()}
   */
  @Test
  void testGetColorModeProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorModeProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getColorModeProperty()}
   */
  @Test
  void testGetColorModeProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorModeProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getColorMode()}
   */
  @Test
  void testGetColorMode() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getColorMode());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getColorMode()}
   */
  @Test
  void testGetColorMode2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorMode());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getColorMode()}
   */
  @Test
  void testGetColorMode3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorMode());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  void testSetColorMode() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(0));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  void testSetColorMode2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(1));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  void testSetColorMode3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.COLOR_MODE, PhotoshopSchema.COLOR_MODE);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(2));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  void testSetColorMode4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.COLOR_MODE, "42");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(1));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  void testSetColorModeProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  void testSetColorModeProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  void testSetColorModeProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  void testSetColorModeProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.TEXT_LAYERS);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCountryProperty()}
   */
  @Test
  void testGetCountryProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCountryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCountryProperty()}
   */
  @Test
  void testGetCountryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCountryProperty()}
   */
  @Test
  void testGetCountryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCountry()}
   */
  @Test
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCountry());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCountry()}
   */
  @Test
  void testGetCountry2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountry());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCountry()}
   */
  @Test
  void testGetCountry3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountry());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  void testSetCountry() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(0));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  void testSetCountry2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(1));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  void testSetCountry3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(2));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  void testSetCountry4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.COUNTRY, "42");

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(0));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  void testSetCountryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  void testSetCountryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  void testSetCountryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  void testSetCountryProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCreditProperty()}
   */
  @Test
  void testGetCreditProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCreditProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCreditProperty()}
   */
  @Test
  void testGetCreditProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCreditProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCreditProperty()}
   */
  @Test
  void testGetCreditProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCreditProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCredit()}
   */
  @Test
  void testGetCredit() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getCredit());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCredit()}
   */
  @Test
  void testGetCredit2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCredit());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getCredit()}
   */
  @Test
  void testGetCredit3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCredit());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  void testSetCredit() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(0));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  void testSetCredit2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(1));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  void testSetCredit3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(2));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  void testSetCredit4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CREDIT, "42");

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(0));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  void testSetCreditProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  void testSetCreditProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  void testSetCreditProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  void testSetCreditProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDateCreatedProperty()}
   */
  @Test
  void testGetDateCreatedProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getDateCreatedProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDateCreatedProperty()}
   */
  @Test
  void testGetDateCreatedProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreatedProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDateCreatedProperty()}
   */
  @Test
  void testGetDateCreatedProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreatedProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDateCreated()}
   */
  @Test
  void testGetDateCreated() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getDateCreated());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDateCreated()}
   */
  @Test
  void testGetDateCreated2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreated());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDateCreated()}
   */
  @Test
  void testGetDateCreated3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreated());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setDateCreated(String)}
   */
  @Test
  void testSetDateCreated() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setDateCreated("");

    // Assert
    DateType dateCreatedProperty = photoshopSchema.getDateCreatedProperty();
    assertEquals("", dateCreatedProperty.getRawValue());
    assertEquals("photoshop", dateCreatedProperty.getPrefix());
    assertNull(dateCreatedProperty.getNamespace());
    assertNull(dateCreatedProperty.getValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(dateCreatedProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.DATE_CREATED, dateCreatedProperty.getPropertyName());
    assertSame(dateCreatedProperty, allProperties.get(0));
    assertSame(metadata, dateCreatedProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  void testSetDateCreatedProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    DateType text = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  void testSetDateCreatedProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    DateType text = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  void testSetDateCreatedProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    DateType text = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  void testSetDateCreatedProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.TEXT_LAYERS);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    DateType text = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  void testAddDocumentAncestors() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    List<AbstractField> allProperties = documentAncestorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(1, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(0));
    List<String> elementsAsString = documentAncestorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    assertNull(photoshopSchema.getTextLayers());
    List<AbstractField> allProperties2 = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(documentAncestorsProperty, allProperties2.get(0));
    assertSame(allProperties, documentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  void testAddDocumentAncestors2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    List<AbstractField> allProperties = documentAncestorsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(2, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(1));
    assertEquals("Text", ((TextType) getResult2).getStringValue());
    assertEquals("Text", ((TextType) getResult2).getRawValue());
    assertEquals("Text", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", getResult2.getPrefix());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    assertNull(photoshopSchema.getTextLayers());
    List<AbstractField> allProperties2 = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestors.get(0));
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getStringValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getRawValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getValue());
    assertSame(documentAncestorsProperty, allProperties2.get(0));
    assertSame(allProperties, documentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  void testAddDocumentAncestors3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers("li", "li");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    List<AbstractField> allProperties2 = documentAncestorsProperty.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof TextType);
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(2, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(1));
    assertEquals("Text", ((TextType) getResult3).getStringValue());
    assertEquals("Text", ((TextType) getResult3).getRawValue());
    assertEquals("Text", ((TextType) getResult3).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("photoshop", getResult2.getPrefix());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(textLayers.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestors.get(0));
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult2).getStringValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult2).getRawValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult2).getValue());
    assertSame(documentAncestorsProperty, allProperties.get(1));
    assertSame(allProperties2, documentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  void testAddDocumentAncestors4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    List<AbstractField> allProperties2 = documentAncestorsProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(1, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(0));
    List<String> elementsAsString = documentAncestorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult2).getStringValue());
    assertEquals("Text", ((TextType) getResult2).getRawValue());
    assertEquals("Text", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("photoshop", getResult2.getPrefix());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(textLayers.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(documentAncestorsProperty, allProperties.get(1));
    assertSame(allProperties2, documentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  void testAddDocumentAncestors5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple("Simple Name", "42");
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    List<AbstractField> allProperties2 = documentAncestorsProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(1, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(0));
    List<String> elementsAsString = documentAncestorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult3).getStringValue());
    assertEquals("Text", ((TextType) getResult3).getRawValue());
    assertEquals("Text", ((TextType) getResult3).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(textLayers.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(documentAncestorsProperty, allProperties.get(2));
    assertSame(allProperties2, documentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDocumentAncestorsProperty()}
   */
  @Test
  void testGetDocumentAncestorsProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getDocumentAncestorsProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDocumentAncestorsProperty()}
   */
  @Test
  void testGetDocumentAncestorsProperty2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    ArrayProperty actualDocumentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();

    // Assert
    List<AbstractField> allProperties = actualDocumentAncestorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualDocumentAncestorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", actualDocumentAncestorsProperty.getPrefix());
    List<String> elementsAsString = actualDocumentAncestorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualDocumentAncestorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualDocumentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualDocumentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, elementsAsString.get(0));
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestorsProperty.getPropertyName());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getStringValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getRawValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualDocumentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualDocumentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDocumentAncestorsProperty()}
   */
  @Test
  void testGetDocumentAncestorsProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    ArrayProperty actualDocumentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();

    // Assert
    List<AbstractField> allProperties = actualDocumentAncestorsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualDocumentAncestorsProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", actualDocumentAncestorsProperty.getPrefix());
    List<String> elementsAsString = actualDocumentAncestorsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualDocumentAncestorsProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualDocumentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualDocumentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, elementsAsString.get(0));
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestorsProperty.getPropertyName());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getStringValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getRawValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualDocumentAncestorsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualDocumentAncestorsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDocumentAncestors()}
   */
  @Test
  void testGetDocumentAncestors() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getDocumentAncestors());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDocumentAncestors()}
   */
  @Test
  void testGetDocumentAncestors2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    List<String> actualDocumentAncestors = photoshopSchema.getDocumentAncestors();

    // Assert
    assertEquals(1, actualDocumentAncestors.size());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestors.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getDocumentAncestors()}
   */
  @Test
  void testGetDocumentAncestors3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    List<String> actualDocumentAncestors = photoshopSchema.getDocumentAncestors();

    // Assert
    assertEquals(1, actualDocumentAncestors.size());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestors.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHeadlineProperty()}
   */
  @Test
  void testGetHeadlineProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getHeadlineProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHeadlineProperty()}
   */
  @Test
  void testGetHeadlineProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadlineProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHeadlineProperty()}
   */
  @Test
  void testGetHeadlineProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadlineProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHeadline()}
   */
  @Test
  void testGetHeadline() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getHeadline());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHeadline()}
   */
  @Test
  void testGetHeadline2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadline());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHeadline()}
   */
  @Test
  void testGetHeadline3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadline());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  void testSetHeadline() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(0));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  void testSetHeadline2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(1));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  void testSetHeadline3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(2));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  void testSetHeadline4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.HEADLINE, "42");

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(0));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  void testSetHeadlineProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  void testSetHeadlineProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  void testSetHeadlineProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  void testSetHeadlineProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHistoryProperty()}
   */
  @Test
  void testGetHistoryProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getHistoryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHistoryProperty()}
   */
  @Test
  void testGetHistoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistoryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHistoryProperty()}
   */
  @Test
  void testGetHistoryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistoryProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHistory()}
   */
  @Test
  void testGetHistory() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getHistory());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHistory()}
   */
  @Test
  void testGetHistory2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistory());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getHistory()}
   */
  @Test
  void testGetHistory3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistory());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  void testSetHistory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(0));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  void testSetHistory2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(1));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  void testSetHistory3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(2));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  void testSetHistory4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.HISTORY, "42");

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(0));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  void testSetHistoryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  void testSetHistoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  void testSetHistoryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  void testSetHistoryProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getICCProfileProperty()}
   */
  @Test
  void testGetICCProfileProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getICCProfileProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getICCProfileProperty()}
   */
  @Test
  void testGetICCProfileProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfileProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getICCProfileProperty()}
   */
  @Test
  void testGetICCProfileProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfileProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getICCProfile()}
   */
  @Test
  void testGetICCProfile() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getICCProfile());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getICCProfile()}
   */
  @Test
  void testGetICCProfile2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfile());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getICCProfile()}
   */
  @Test
  void testGetICCProfile3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfile());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  void testSetICCProfile() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(0));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  void testSetICCProfile2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(1));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  void testSetICCProfile3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(2));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  void testSetICCProfile4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.ICC_PROFILE, "42");

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(0));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  void testSetICCProfileProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  void testSetICCProfileProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  void testSetICCProfileProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  void testSetICCProfileProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getInstructionsProperty()}
   */
  @Test
  void testGetInstructionsProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getInstructionsProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getInstructionsProperty()}
   */
  @Test
  void testGetInstructionsProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructionsProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getInstructionsProperty()}
   */
  @Test
  void testGetInstructionsProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructionsProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getInstructions()}
   */
  @Test
  void testGetInstructions() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getInstructions());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getInstructions()}
   */
  @Test
  void testGetInstructions2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructions());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getInstructions()}
   */
  @Test
  void testGetInstructions3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructions());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  void testSetInstructions() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(0));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  void testSetInstructions2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(1));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  void testSetInstructions3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(2));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  void testSetInstructions4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.INSTRUCTIONS, "42");

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(0));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  void testSetInstructionsProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  void testSetInstructionsProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  void testSetInstructionsProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  void testSetInstructionsProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSourceProperty()}
   */
  @Test
  void testGetSourceProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getSourceProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSourceProperty()}
   */
  @Test
  void testGetSourceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSourceProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSourceProperty()}
   */
  @Test
  void testGetSourceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSourceProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSource()}
   */
  @Test
  void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getSource());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSource()}
   */
  @Test
  void testGetSource2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSource());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSource()}
   */
  @Test
  void testGetSource3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSource());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  void testSetSource() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(0));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  void testSetSource2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(1));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  void testSetSource3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(2));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  void testSetSource4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.SOURCE, "42");

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(0));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  void testSetSourceProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getStateProperty()}
   */
  @Test
  void testGetStateProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getStateProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getStateProperty()}
   */
  @Test
  void testGetStateProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getStateProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getStateProperty()}
   */
  @Test
  void testGetStateProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getStateProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getState()}
   */
  @Test
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getState());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getState()}
   */
  @Test
  void testGetState2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getState());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getState()}
   */
  @Test
  void testGetState3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getState());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  void testSetState() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setState("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(0));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  void testSetState2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act
    photoshopSchema.setState("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(1));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  void testSetState3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act
    photoshopSchema.setState("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(2));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  void testSetState4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.STATE, "42");

    // Act
    photoshopSchema.setState("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(0));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  void testSetStateProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  void testSetStateProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  void testSetStateProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  void testSetStateProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#getSupplementalCategoriesProperty()}
   */
  @Test
  void testGetSupplementalCategoriesProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getSupplementalCategoriesProperty());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#getSupplementalCategoriesProperty()}
   */
  @Test
  void testGetSupplementalCategoriesProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategoriesProperty());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#getSupplementalCategoriesProperty()}
   */
  @Test
  void testGetSupplementalCategoriesProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategoriesProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSupplementalCategories()}
   */
  @Test
  void testGetSupplementalCategories() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getSupplementalCategories());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSupplementalCategories()}
   */
  @Test
  void testGetSupplementalCategories2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategories());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getSupplementalCategories()}
   */
  @Test
  void testGetSupplementalCategories3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategories());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  void testSetSupplementalCategories() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(0));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  void testSetSupplementalCategories2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(1));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  void testSetSupplementalCategories3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(2));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  void testSetSupplementalCategories4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, "42");

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(0));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  void testSetSupplementalCategoriesProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  void testSetSupplementalCategoriesProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  void testSetSupplementalCategoriesProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  void testSetSupplementalCategoriesProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  void testAddTextLayers() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    LayerType getResult2 = textLayers.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    assertEquals("Layer Name", getResult2.getLayerName());
    assertEquals("Layer Name", ((TextType) getResult3).getStringValue());
    assertEquals("Layer Name", ((TextType) getResult3).getRawValue());
    assertEquals("Layer Name", ((TextType) getResult3).getValue());
    assertEquals("Layer Text", getResult2.getLayerText());
    assertEquals("Layer Text", ((TextType) getResult4).getStringValue());
    assertEquals("Layer Text", ((TextType) getResult4).getRawValue());
    assertEquals("Layer Text", ((TextType) getResult4).getValue());
    assertEquals("LayerName", getResult3.getPropertyName());
    assertEquals("LayerText", getResult4.getPropertyName());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult5 = allAttributes.get(0);
    assertEquals("Resource", getResult5.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult5.getNamespace());
    assertEquals("parseType", getResult5.getName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", getResult4.getPrefix());
    assertEquals("photoshop", getResult2.getPreferedPrefix());
    assertEquals("photoshop", getResult2.getPrefix());
    assertNull(getResult2.getPropertyName());
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(getResult2, allProperties3.get(0));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  void testAddTextLayers2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.TEXT_LAYERS, PhotoshopSchema.TEXT_LAYERS);

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(2, textLayers.size());
    LayerType getResult2 = textLayers.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    LayerType getResult5 = textLayers.get(1);
    List<AbstractField> allProperties3 = getResult5.getAllProperties();
    assertEquals(2, allProperties3.size());
    AbstractField getResult6 = allProperties3.get(0);
    assertTrue(getResult6 instanceof TextType);
    AbstractField getResult7 = allProperties3.get(1);
    assertTrue(getResult7 instanceof TextType);
    assertEquals("Layer Name", getResult5.getLayerName());
    assertEquals("Layer Name", ((TextType) getResult6).getStringValue());
    assertEquals("Layer Name", ((TextType) getResult6).getRawValue());
    assertEquals("Layer Name", ((TextType) getResult6).getValue());
    assertEquals("Layer Text", getResult5.getLayerText());
    assertEquals("Layer Text", ((TextType) getResult7).getStringValue());
    assertEquals("Layer Text", ((TextType) getResult7).getRawValue());
    assertEquals("Layer Text", ((TextType) getResult7).getValue());
    assertEquals("LayerName", getResult3.getPropertyName());
    assertEquals("LayerName", getResult6.getPropertyName());
    assertEquals("LayerText", getResult4.getPropertyName());
    assertEquals("LayerText", getResult7.getPropertyName());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult8 = allAttributes.get(0);
    assertEquals("Resource", getResult8.getValue());
    List<Attribute> allAttributes2 = getResult5.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult9 = allAttributes2.get(0);
    assertEquals("Resource", getResult9.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult6.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult7.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult5.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult8.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult9.getNamespace());
    assertEquals("parseType", getResult8.getName());
    assertEquals("parseType", getResult9.getName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", getResult4.getPrefix());
    assertEquals("photoshop", getResult6.getPrefix());
    assertEquals("photoshop", getResult7.getPrefix());
    assertEquals("photoshop", getResult2.getPreferedPrefix());
    assertEquals("photoshop", getResult5.getPreferedPrefix());
    assertEquals("photoshop", getResult2.getPrefix());
    assertEquals("photoshop", getResult5.getPrefix());
    assertNull(getResult2.getPropertyName());
    assertNull(getResult5.getPropertyName());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult7.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(getResult5.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(textLayers, ((ArrayProperty) getResult).getAllProperties());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult2.getLayerName());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult2.getLayerText());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, ((TextType) getResult3).getStringValue());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, ((TextType) getResult4).getStringValue());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, ((TextType) getResult3).getRawValue());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, ((TextType) getResult4).getRawValue());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, ((TextType) getResult3).getValue());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, ((TextType) getResult4).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult7.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  void testAddTextLayers3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TEXT_LAYERS, "42");

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    LayerType getResult2 = textLayers.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    assertEquals("Layer Name", getResult2.getLayerName());
    assertEquals("Layer Name", ((TextType) getResult3).getStringValue());
    assertEquals("Layer Name", ((TextType) getResult3).getRawValue());
    assertEquals("Layer Name", ((TextType) getResult3).getValue());
    assertEquals("Layer Text", getResult2.getLayerText());
    assertEquals("Layer Text", ((TextType) getResult4).getStringValue());
    assertEquals("Layer Text", ((TextType) getResult4).getRawValue());
    assertEquals("Layer Text", ((TextType) getResult4).getValue());
    assertEquals("LayerName", getResult3.getPropertyName());
    assertEquals("LayerText", getResult4.getPropertyName());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult5 = allAttributes.get(0);
    assertEquals("Resource", getResult5.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult5.getNamespace());
    assertEquals("parseType", getResult5.getName());
    assertEquals("photoshop", getResult.getPrefix());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", getResult4.getPrefix());
    assertEquals("photoshop", getResult2.getPreferedPrefix());
    assertEquals("photoshop", getResult2.getPrefix());
    assertNull(getResult2.getPropertyName());
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(getResult2, allProperties3.get(0));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  void testAddTextLayers4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors("parseType");
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TEXT_LAYERS, "42");

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    LayerType getResult2 = textLayers.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    AbstractField getResult4 = allProperties2.get(1);
    assertTrue(getResult4 instanceof TextType);
    assertEquals("Layer Name", getResult2.getLayerName());
    assertEquals("Layer Name", ((TextType) getResult3).getStringValue());
    assertEquals("Layer Name", ((TextType) getResult3).getRawValue());
    assertEquals("Layer Name", ((TextType) getResult3).getValue());
    assertEquals("Layer Text", getResult2.getLayerText());
    assertEquals("Layer Text", ((TextType) getResult4).getStringValue());
    assertEquals("Layer Text", ((TextType) getResult4).getRawValue());
    assertEquals("Layer Text", ((TextType) getResult4).getValue());
    assertEquals("LayerName", getResult3.getPropertyName());
    assertEquals("LayerText", getResult4.getPropertyName());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult5 = allAttributes.get(0);
    assertEquals("Resource", getResult5.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult5.getNamespace());
    assertEquals("parseType", getResult5.getName());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", getResult4.getPrefix());
    assertEquals("photoshop", getResult2.getPreferedPrefix());
    assertEquals("photoshop", getResult2.getPrefix());
    assertNull(getResult2.getPropertyName());
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertSame(getResult2, allProperties3.get(0));
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  void testGetTextLayers() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getTextLayers());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  void testGetTextLayers2() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TEXT_LAYERS);

    // Act and Assert
    assertNull(photoshopSchema.getTextLayers());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  void testGetTextLayers3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TEXT_LAYERS);

    // Act
    List<LayerType> actualTextLayers = photoshopSchema.getTextLayers();

    // Assert
    assertEquals(1, actualTextLayers.size());
    LayerType getResult = actualTextLayers.get(0);
    List<AbstractField> allProperties = getResult.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult2 = allProperties.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties.get(1);
    assertTrue(getResult3 instanceof TextType);
    assertEquals("LayerName", getResult2.getPropertyName());
    assertEquals("LayerText", getResult3.getPropertyName());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult4 = allAttributes.get(0);
    assertEquals("Resource", getResult4.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult4.getNamespace());
    assertEquals("parseType", getResult4.getName());
    assertEquals("photoshop", getResult2.getPrefix());
    assertEquals("photoshop", getResult3.getPrefix());
    assertEquals("photoshop", getResult.getPreferedPrefix());
    assertEquals("photoshop", getResult.getPrefix());
    assertNull(getResult.getPropertyName());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, getResult.getLayerName());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, getResult.getLayerText());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult2).getStringValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult3).getStringValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult2).getRawValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult3).getRawValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult2).getValue());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, ((TextType) getResult3).getValue());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  void testGetTextLayers4() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TEXT_LAYERS, "42");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> photoshopSchema.getTextLayers());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTransmissionReferenceProperty()}
   */
  @Test
  void testGetTransmissionReferenceProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getTransmissionReferenceProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTransmissionReferenceProperty()}
   */
  @Test
  void testGetTransmissionReferenceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReferenceProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTransmissionReferenceProperty()}
   */
  @Test
  void testGetTransmissionReferenceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReferenceProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTransmissionReference()}
   */
  @Test
  void testGetTransmissionReference() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getTransmissionReference());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTransmissionReference()}
   */
  @Test
  void testGetTransmissionReference2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReference());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getTransmissionReference()}
   */
  @Test
  void testGetTransmissionReference3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReference());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  void testSetTransmissionReference() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(0));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  void testSetTransmissionReference2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(1));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  void testSetTransmissionReference3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(2));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  void testSetTransmissionReference4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TRANSMISSION_REFERENCE, "42");

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(0));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  void testSetTransmissionReferenceProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  void testSetTransmissionReferenceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  void testSetTransmissionReferenceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  void testSetTransmissionReferenceProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#getUrgencyProperty()}
   */
  @Test
  void testGetUrgencyProperty() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getUrgencyProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getUrgencyProperty()}
   */
  @Test
  void testGetUrgencyProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgencyProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getUrgencyProperty()}
   */
  @Test
  void testGetUrgencyProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgencyProperty());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getUrgency()}
   */
  @Test
  void testGetUrgency() {
    // Arrange, Act and Assert
    assertNull((new PhotoshopSchema(XMPMetadata.createXMPMetadata())).getUrgency());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getUrgency()}
   */
  @Test
  void testGetUrgency2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgency());
  }

  /**
   * Method under test: {@link PhotoshopSchema#getUrgency()}
   */
  @Test
  void testGetUrgency3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgency());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  void testSetUrgency() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(0));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  void testSetUrgency2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(1));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  void testSetUrgency3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(2));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  void testSetUrgency4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.URGENCY, "42");

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(0));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  void testSetUrgency5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(0));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  void testSetUrgency6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(1));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  void testSetUrgency7() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(PhotoshopSchema.URGENCY, PhotoshopSchema.URGENCY);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(2));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  void testSetUrgency8() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.URGENCY, "42");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(1));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  void testSetUrgencyProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  void testSetUrgencyProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  void testSetUrgencyProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  void testSetUrgencyProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.TEXT_LAYERS);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)}
   */
  @Test
  void testNewPhotoshopSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualPhotoshopSchema = new PhotoshopSchema(metadata);

    // Assert
    assertEquals("", actualPhotoshopSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualPhotoshopSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualPhotoshopSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("photoshop", allNamespacesWithPrefix.get("http://ns.adobe.com/photoshop/1.0/"));
    assertEquals("photoshop", actualPhotoshopSchema.getPreferedPrefix());
    assertEquals("photoshop", actualPhotoshopSchema.getPrefix());
    assertNull(actualPhotoshopSchema.getColorMode());
    assertNull(actualPhotoshopSchema.getUrgency());
    assertNull(actualPhotoshopSchema.getAncestorID());
    assertNull(actualPhotoshopSchema.getAuthorsPosition());
    assertNull(actualPhotoshopSchema.getCaptionWriter());
    assertNull(actualPhotoshopSchema.getCategory());
    assertNull(actualPhotoshopSchema.getCity());
    assertNull(actualPhotoshopSchema.getCountry());
    assertNull(actualPhotoshopSchema.getCredit());
    assertNull(actualPhotoshopSchema.getDateCreated());
    assertNull(actualPhotoshopSchema.getHeadline());
    assertNull(actualPhotoshopSchema.getHistory());
    assertNull(actualPhotoshopSchema.getICCProfile());
    assertNull(actualPhotoshopSchema.getInstructions());
    assertNull(actualPhotoshopSchema.getSource());
    assertNull(actualPhotoshopSchema.getState());
    assertNull(actualPhotoshopSchema.getSupplementalCategories());
    assertNull(actualPhotoshopSchema.getTransmissionReference());
    assertNull(actualPhotoshopSchema.getPropertyName());
    assertNull(actualPhotoshopSchema.getDocumentAncestors());
    assertNull(actualPhotoshopSchema.getTextLayers());
    assertNull(actualPhotoshopSchema.getDocumentAncestorsProperty());
    assertNull(actualPhotoshopSchema.getAboutAttribute());
    assertNull(actualPhotoshopSchema.getDateCreatedProperty());
    assertNull(actualPhotoshopSchema.getColorModeProperty());
    assertNull(actualPhotoshopSchema.getUrgencyProperty());
    assertNull(actualPhotoshopSchema.getAuthorsPositionProperty());
    assertNull(actualPhotoshopSchema.getCaptionWriterProperty());
    assertNull(actualPhotoshopSchema.getCategoryProperty());
    assertNull(actualPhotoshopSchema.getCityProperty());
    assertNull(actualPhotoshopSchema.getCountryProperty());
    assertNull(actualPhotoshopSchema.getCreditProperty());
    assertNull(actualPhotoshopSchema.getHeadlineProperty());
    assertNull(actualPhotoshopSchema.getHistoryProperty());
    assertNull(actualPhotoshopSchema.getICCProfileProperty());
    assertNull(actualPhotoshopSchema.getInstructionsProperty());
    assertNull(actualPhotoshopSchema.getSourceProperty());
    assertNull(actualPhotoshopSchema.getStateProperty());
    assertNull(actualPhotoshopSchema.getSupplementalCategoriesProperty());
    assertNull(actualPhotoshopSchema.getTransmissionReferenceProperty());
    assertNull(actualPhotoshopSchema.getAncestorIDProperty());
    List<AbstractField> allProperties = actualPhotoshopSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPhotoshopSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPhotoshopSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPhotoshopSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata, String)}
   */
  @Test
  void testNewPhotoshopSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualPhotoshopSchema = new PhotoshopSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualPhotoshopSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualPhotoshopSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/photoshop/1.0/"));
    assertEquals("Own Prefix", actualPhotoshopSchema.getPrefix());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualPhotoshopSchema.getNamespace());
    assertEquals("photoshop", actualPhotoshopSchema.getPreferedPrefix());
    assertNull(actualPhotoshopSchema.getColorMode());
    assertNull(actualPhotoshopSchema.getUrgency());
    assertNull(actualPhotoshopSchema.getAncestorID());
    assertNull(actualPhotoshopSchema.getAuthorsPosition());
    assertNull(actualPhotoshopSchema.getCaptionWriter());
    assertNull(actualPhotoshopSchema.getCategory());
    assertNull(actualPhotoshopSchema.getCity());
    assertNull(actualPhotoshopSchema.getCountry());
    assertNull(actualPhotoshopSchema.getCredit());
    assertNull(actualPhotoshopSchema.getDateCreated());
    assertNull(actualPhotoshopSchema.getHeadline());
    assertNull(actualPhotoshopSchema.getHistory());
    assertNull(actualPhotoshopSchema.getICCProfile());
    assertNull(actualPhotoshopSchema.getInstructions());
    assertNull(actualPhotoshopSchema.getSource());
    assertNull(actualPhotoshopSchema.getState());
    assertNull(actualPhotoshopSchema.getSupplementalCategories());
    assertNull(actualPhotoshopSchema.getTransmissionReference());
    assertNull(actualPhotoshopSchema.getPropertyName());
    assertNull(actualPhotoshopSchema.getDocumentAncestors());
    assertNull(actualPhotoshopSchema.getTextLayers());
    assertNull(actualPhotoshopSchema.getDocumentAncestorsProperty());
    assertNull(actualPhotoshopSchema.getAboutAttribute());
    assertNull(actualPhotoshopSchema.getDateCreatedProperty());
    assertNull(actualPhotoshopSchema.getColorModeProperty());
    assertNull(actualPhotoshopSchema.getUrgencyProperty());
    assertNull(actualPhotoshopSchema.getAuthorsPositionProperty());
    assertNull(actualPhotoshopSchema.getCaptionWriterProperty());
    assertNull(actualPhotoshopSchema.getCategoryProperty());
    assertNull(actualPhotoshopSchema.getCityProperty());
    assertNull(actualPhotoshopSchema.getCountryProperty());
    assertNull(actualPhotoshopSchema.getCreditProperty());
    assertNull(actualPhotoshopSchema.getHeadlineProperty());
    assertNull(actualPhotoshopSchema.getHistoryProperty());
    assertNull(actualPhotoshopSchema.getICCProfileProperty());
    assertNull(actualPhotoshopSchema.getInstructionsProperty());
    assertNull(actualPhotoshopSchema.getSourceProperty());
    assertNull(actualPhotoshopSchema.getStateProperty());
    assertNull(actualPhotoshopSchema.getSupplementalCategoriesProperty());
    assertNull(actualPhotoshopSchema.getTransmissionReferenceProperty());
    assertNull(actualPhotoshopSchema.getAncestorIDProperty());
    List<AbstractField> allProperties = actualPhotoshopSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPhotoshopSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPhotoshopSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPhotoshopSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata, String)}
   */
  @Test
  void testNewPhotoshopSchema3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualPhotoshopSchema = new PhotoshopSchema(metadata, null);

    // Assert
    assertEquals("", actualPhotoshopSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualPhotoshopSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualPhotoshopSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("photoshop", allNamespacesWithPrefix.get("http://ns.adobe.com/photoshop/1.0/"));
    assertEquals("photoshop", actualPhotoshopSchema.getPreferedPrefix());
    assertEquals("photoshop", actualPhotoshopSchema.getPrefix());
    assertNull(actualPhotoshopSchema.getColorMode());
    assertNull(actualPhotoshopSchema.getUrgency());
    assertNull(actualPhotoshopSchema.getAncestorID());
    assertNull(actualPhotoshopSchema.getAuthorsPosition());
    assertNull(actualPhotoshopSchema.getCaptionWriter());
    assertNull(actualPhotoshopSchema.getCategory());
    assertNull(actualPhotoshopSchema.getCity());
    assertNull(actualPhotoshopSchema.getCountry());
    assertNull(actualPhotoshopSchema.getCredit());
    assertNull(actualPhotoshopSchema.getDateCreated());
    assertNull(actualPhotoshopSchema.getHeadline());
    assertNull(actualPhotoshopSchema.getHistory());
    assertNull(actualPhotoshopSchema.getICCProfile());
    assertNull(actualPhotoshopSchema.getInstructions());
    assertNull(actualPhotoshopSchema.getSource());
    assertNull(actualPhotoshopSchema.getState());
    assertNull(actualPhotoshopSchema.getSupplementalCategories());
    assertNull(actualPhotoshopSchema.getTransmissionReference());
    assertNull(actualPhotoshopSchema.getPropertyName());
    assertNull(actualPhotoshopSchema.getDocumentAncestors());
    assertNull(actualPhotoshopSchema.getTextLayers());
    assertNull(actualPhotoshopSchema.getDocumentAncestorsProperty());
    assertNull(actualPhotoshopSchema.getAboutAttribute());
    assertNull(actualPhotoshopSchema.getDateCreatedProperty());
    assertNull(actualPhotoshopSchema.getColorModeProperty());
    assertNull(actualPhotoshopSchema.getUrgencyProperty());
    assertNull(actualPhotoshopSchema.getAuthorsPositionProperty());
    assertNull(actualPhotoshopSchema.getCaptionWriterProperty());
    assertNull(actualPhotoshopSchema.getCategoryProperty());
    assertNull(actualPhotoshopSchema.getCityProperty());
    assertNull(actualPhotoshopSchema.getCountryProperty());
    assertNull(actualPhotoshopSchema.getCreditProperty());
    assertNull(actualPhotoshopSchema.getHeadlineProperty());
    assertNull(actualPhotoshopSchema.getHistoryProperty());
    assertNull(actualPhotoshopSchema.getICCProfileProperty());
    assertNull(actualPhotoshopSchema.getInstructionsProperty());
    assertNull(actualPhotoshopSchema.getSourceProperty());
    assertNull(actualPhotoshopSchema.getStateProperty());
    assertNull(actualPhotoshopSchema.getSupplementalCategoriesProperty());
    assertNull(actualPhotoshopSchema.getTransmissionReferenceProperty());
    assertNull(actualPhotoshopSchema.getAncestorIDProperty());
    List<AbstractField> allProperties = actualPhotoshopSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualPhotoshopSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualPhotoshopSchema.getContainer().getAllProperties());
    assertSame(metadata, actualPhotoshopSchema.getMetadata());
  }
}
