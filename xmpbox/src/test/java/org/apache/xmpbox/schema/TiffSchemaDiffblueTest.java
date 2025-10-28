package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Attribute;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.Test;

class TiffSchemaDiffblueTest {
  /**
   * Method under test: {@link TiffSchema#getArtistProperty()}
   */
  @Test
  void testGetArtistProperty() {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getArtistProperty());
  }

  /**
   * Method under test: {@link TiffSchema#getArtistProperty()}
   */
  @Test
  void testGetArtistProperty2() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtistProperty());
  }

  /**
   * Method under test: {@link TiffSchema#getArtistProperty()}
   */
  @Test
  void testGetArtistProperty3() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.ARTIST);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtistProperty());
  }

  /**
   * Method under test: {@link TiffSchema#getArtist()}
   */
  @Test
  void testGetArtist() {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getArtist());
  }

  /**
   * Method under test: {@link TiffSchema#getArtist()}
   */
  @Test
  void testGetArtist2() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtist());
  }

  /**
   * Method under test: {@link TiffSchema#getArtist()}
   */
  @Test
  void testGetArtist3() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.ARTIST);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtist());
  }

  /**
   * Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  void testSetArtist() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  void testSetArtist2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  void testSetArtist3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.ARTIST);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(2);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  void testSetArtist4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addBagValueAsSimple(TiffSchema.ARTIST, "42");

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionProperty()}
   */
  @Test
  void testGetImageDescriptionProperty() {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getImageDescriptionProperty());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionProperty()}
   */
  @Test
  void testGetImageDescriptionProperty2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    ArrayProperty actualImageDescriptionProperty = tiffSchema.getImageDescriptionProperty();

    // Assert
    List<AbstractField> allProperties = actualImageDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualImageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualImageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", actualImageDescriptionProperty.getPrefix());
    assertEquals(Cardinality.Alt, actualImageDescriptionProperty.getArrayType());
    assertTrue(actualImageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(actualImageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionProperty.getPropertyName());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult2.getValue());
    assertSame(allProperties, actualImageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualImageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionProperty()}
   */
  @Test
  void testGetImageDescriptionProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("Lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    ArrayProperty actualImageDescriptionProperty = tiffSchema.getImageDescriptionProperty();

    // Assert
    List<AbstractField> allProperties = actualImageDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualImageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualImageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", actualImageDescriptionProperty.getPrefix());
    assertEquals(Cardinality.Alt, actualImageDescriptionProperty.getArrayType());
    assertTrue(actualImageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(actualImageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionProperty.getPropertyName());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult2.getValue());
    assertSame(allProperties, actualImageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualImageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  void testGetImageDescriptionLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getImageDescriptionLanguages());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  void testGetImageDescriptionLanguages2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    List<String> actualImageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();

    // Assert
    assertEquals(1, actualImageDescriptionLanguages.size());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionLanguages.get(0));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  void testGetImageDescriptionLanguages3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    List<String> actualImageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();

    // Assert
    assertEquals(1, actualImageDescriptionLanguages.size());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionLanguages.get(0));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  void testGetImageDescriptionLanguages4() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    List<String> actualImageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();

    // Assert
    assertEquals(1, actualImageDescriptionLanguages.size());
    assertEquals("x-default", actualImageDescriptionLanguages.get(0));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  void testGetImageDescription() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getImageDescription());
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getImageDescription("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  void testGetImageDescription2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  void testGetImageDescription3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription("x-default", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, tiffSchema.getImageDescription());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  void testGetImageDescription4() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("x-default", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  void testGetImageDescription5() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription());
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  void testGetImageDescription6() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  void testGetImageDescription7() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  void testGetImageDescription8() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  void testGetImageDescription9() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription("Lang", "42");

    // Act and Assert
    assertEquals("42", tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(1, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertNull(tiffSchema.getImageDescription());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertNull(tiffSchema.getImageDescription());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionLanguages.get(0));
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult4.getValue());
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertNull(tiffSchema.getImageDescription());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionLanguages.get(0));
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult4.getValue());
    assertSame(imageDescriptionProperty, allProperties2.get(1));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(1, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertNull(tiffSchema.getImageDescription());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(imageDescriptionProperty, allProperties2.get(1));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription("Lang", "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(1, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertNull(tiffSchema.getImageDescription());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription("x-default", "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", tiffSchema.getImageDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertEquals("x-default", imageDescriptionLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription7() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.addImageDescription("", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", tiffSchema.getImageDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(1, imageDescriptionLanguages.size());
    assertEquals("x-default", imageDescriptionLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription8() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("x-default", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", tiffSchema.getImageDescription());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("x-default", imageDescriptionLanguages.get(0));
    assertEquals("x-default", getResult3.getValue());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionLanguages.get(1));
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult4.getValue());
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, imageDescriptionProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  void testAddImageDescription9() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), TiffSchema.IMAGE_DESCRIPTION,
        TiffSchema.IMAGE_DESCRIPTION, TiffSchema.IMAGE_DESCRIPTION, "Value");

    tiffSchema.addProperty(obj);

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertSame(obj, getResult);
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightProperty()}
   */
  @Test
  void testGetCopyrightProperty() {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getCopyrightProperty());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightProperty()}
   */
  @Test
  void testGetCopyrightProperty2() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyrightProperty());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightProperty()}
   */
  @Test
  void testGetCopyrightProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    ArrayProperty actualCopyrightProperty = tiffSchema.getCopyrightProperty();

    // Assert
    List<AbstractField> allProperties = actualCopyrightProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualCopyrightProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", actualCopyrightProperty.getPrefix());
    List<String> elementsAsString = actualCopyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Alt, actualCopyrightProperty.getArrayType());
    assertTrue(actualCopyrightProperty.getAllAttributes().isEmpty());
    assertTrue(actualCopyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, elementsAsString.get(0));
    assertEquals(TiffSchema.COPYRIGHT, actualCopyrightProperty.getPropertyName());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getStringValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getRawValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getValue());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult2.getValue());
    assertSame(allProperties, actualCopyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualCopyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  void testGetCopyrightLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getCopyrightLanguages());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  void testGetCopyrightLanguages2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyrightLanguages());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  void testGetCopyrightLanguages3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    List<String> actualCopyrightLanguages = tiffSchema.getCopyrightLanguages();

    // Assert
    assertEquals(1, actualCopyrightLanguages.size());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualCopyrightLanguages.get(0));
  }

  /**
   * Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  void testGetCopyrightLanguages4() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.COPYRIGHT, "42");

    // Act
    List<String> actualCopyrightLanguages = tiffSchema.getCopyrightLanguages();

    // Assert
    assertEquals(1, actualCopyrightLanguages.size());
    assertEquals("x-default", actualCopyrightLanguages.get(0));
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  void testGetCopyright() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getCopyright());
    assertNull((new TiffSchema(XMPMetadata.createXMPMetadata())).getCopyright("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  void testGetCopyright2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  void testGetCopyright3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("x-default", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertEquals(TiffSchema.COPYRIGHT, tiffSchema.getCopyright());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  void testGetCopyright4() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  void testGetCopyright5() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright());
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  void testGetCopyright6() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  void testGetCopyright7() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  void testGetCopyright8() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  void testGetCopyright9() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("Lang", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertEquals(TiffSchema.COPYRIGHT, tiffSchema.getCopyright("Lang"));
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertNull(tiffSchema.getCopyright());
    assertNull(tiffSchema.getImageDescriptionProperty());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties2.get(0));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertNull(tiffSchema.getCopyright());
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties2.get(1));
    assertSame(imageDescriptionProperty, allProperties2.get(0));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(2, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertNull(tiffSchema.getCopyright());
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, elementsAsString.get(0));
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getStringValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getRawValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getValue());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, copyrightLanguages.get(0));
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult4.getValue());
    assertSame(copyrightProperty, allProperties2.get(0));
    assertSame(imageDescriptionProperty, allProperties2.get(1));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("Lang", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertNull(tiffSchema.getCopyright());
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties2.get(0));
    assertSame(imageDescriptionProperty, allProperties2.get(1));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("x-default", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(2, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertEquals("x-default", copyrightLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, elementsAsString.get(0));
    assertEquals(TiffSchema.COPYRIGHT, tiffSchema.getCopyright());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getStringValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getRawValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult).getValue());
    assertSame(copyrightProperty, allProperties2.get(0));
    assertSame(imageDescriptionProperty, allProperties2.get(1));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addBagValueAsSimple("Simple Name", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties2 = copyrightProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertNull(tiffSchema.getCopyright());
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties.get(2));
    assertSame(imageDescriptionProperty, allProperties.get(1));
    assertSame(allProperties2, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright7() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.addCopyright("", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", tiffSchema.getCopyright());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("x-default", copyrightLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    assertNull(tiffSchema.getImageDescriptionProperty());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties2.get(0));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright8() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("x-default", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", tiffSchema.getCopyright());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals("tiff", getResult2.getPrefix());
    assertEquals("tiff", copyrightProperty.getPrefix());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(2, copyrightLanguages.size());
    assertEquals("x-default", copyrightLanguages.get(0));
    assertEquals("x-default", getResult3.getValue());
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = tiffSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, elementsAsString.get(1));
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult2).getStringValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult2).getRawValue());
    assertEquals(TiffSchema.COPYRIGHT, ((TextType) getResult2).getValue());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, copyrightLanguages.get(1));
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, getResult4.getValue());
    assertSame(copyrightProperty, allProperties2.get(0));
    assertSame(imageDescriptionProperty, allProperties2.get(1));
    assertSame(allProperties, copyrightProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  void testAddCopyright9() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), TiffSchema.COPYRIGHT, TiffSchema.COPYRIGHT,
        TiffSchema.COPYRIGHT, "Value");

    tiffSchema.addProperty(obj);

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertSame(obj, getResult);
  }

  /**
   * Method under test: {@link TiffSchema#TiffSchema(XMPMetadata)}
   */
  @Test
  void testNewTiffSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TiffSchema actualTiffSchema = new TiffSchema(metadata);

    // Assert
    assertEquals("", actualTiffSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualTiffSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualTiffSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("tiff", allNamespacesWithPrefix.get("http://ns.adobe.com/tiff/1.0/"));
    assertEquals("tiff", actualTiffSchema.getPreferedPrefix());
    assertEquals("tiff", actualTiffSchema.getPrefix());
    assertNull(actualTiffSchema.getArtist());
    assertNull(actualTiffSchema.getCopyright());
    assertNull(actualTiffSchema.getImageDescription());
    assertNull(actualTiffSchema.getPropertyName());
    assertNull(actualTiffSchema.getCopyrightLanguages());
    assertNull(actualTiffSchema.getImageDescriptionLanguages());
    assertNull(actualTiffSchema.getCopyrightProperty());
    assertNull(actualTiffSchema.getImageDescriptionProperty());
    assertNull(actualTiffSchema.getAboutAttribute());
    assertNull(actualTiffSchema.getArtistProperty());
    List<AbstractField> allProperties = actualTiffSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualTiffSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualTiffSchema.getContainer().getAllProperties());
    assertSame(metadata, actualTiffSchema.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#TiffSchema(XMPMetadata, String)}
   */
  @Test
  void testNewTiffSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TiffSchema actualTiffSchema = new TiffSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualTiffSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualTiffSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/tiff/1.0/"));
    assertEquals("Prefix", actualTiffSchema.getPrefix());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualTiffSchema.getNamespace());
    assertEquals("tiff", actualTiffSchema.getPreferedPrefix());
    assertNull(actualTiffSchema.getArtist());
    assertNull(actualTiffSchema.getCopyright());
    assertNull(actualTiffSchema.getImageDescription());
    assertNull(actualTiffSchema.getPropertyName());
    assertNull(actualTiffSchema.getCopyrightLanguages());
    assertNull(actualTiffSchema.getImageDescriptionLanguages());
    assertNull(actualTiffSchema.getCopyrightProperty());
    assertNull(actualTiffSchema.getImageDescriptionProperty());
    assertNull(actualTiffSchema.getAboutAttribute());
    assertNull(actualTiffSchema.getArtistProperty());
    List<AbstractField> allProperties = actualTiffSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualTiffSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualTiffSchema.getContainer().getAllProperties());
    assertSame(metadata, actualTiffSchema.getMetadata());
  }

  /**
   * Method under test: {@link TiffSchema#TiffSchema(XMPMetadata, String)}
   */
  @Test
  void testNewTiffSchema3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TiffSchema actualTiffSchema = new TiffSchema(metadata, null);

    // Assert
    assertEquals("", actualTiffSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualTiffSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualTiffSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("tiff", allNamespacesWithPrefix.get("http://ns.adobe.com/tiff/1.0/"));
    assertEquals("tiff", actualTiffSchema.getPreferedPrefix());
    assertEquals("tiff", actualTiffSchema.getPrefix());
    assertNull(actualTiffSchema.getArtist());
    assertNull(actualTiffSchema.getCopyright());
    assertNull(actualTiffSchema.getImageDescription());
    assertNull(actualTiffSchema.getPropertyName());
    assertNull(actualTiffSchema.getCopyrightLanguages());
    assertNull(actualTiffSchema.getImageDescriptionLanguages());
    assertNull(actualTiffSchema.getCopyrightProperty());
    assertNull(actualTiffSchema.getImageDescriptionProperty());
    assertNull(actualTiffSchema.getAboutAttribute());
    assertNull(actualTiffSchema.getArtistProperty());
    List<AbstractField> allProperties = actualTiffSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualTiffSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualTiffSchema.getContainer().getAllProperties());
    assertSame(metadata, actualTiffSchema.getMetadata());
  }
}
