package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Attribute;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.ChoiceType;
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.ThumbnailType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.Test;

class XMPBasicSchemaDiffblueTest {
  /**
   * Method under test:
   * {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}
   */
  @Test
  void testAddThumbnails() throws BadFieldValueException {
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
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    ThumbnailType getResult2 = thumbnailsProperty.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(4, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(2);
    assertTrue(getResult3 instanceof ChoiceType);
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof IntegerType);
    AbstractField getResult5 = allProperties2.get(1);
    assertTrue(getResult5 instanceof IntegerType);
    AbstractField getResult6 = allProperties2.get(3);
    assertTrue(getResult6 instanceof TextType);
    assertEquals("1", ((IntegerType) getResult5).getStringValue());
    assertEquals("2", ((IntegerType) getResult4).getStringValue());
    assertEquals("Format", ((ChoiceType) getResult3).getStringValue());
    assertEquals("Format", getResult2.getFormat());
    assertEquals("Format", ((ChoiceType) getResult3).getRawValue());
    assertEquals("Format", ((ChoiceType) getResult3).getValue());
    assertEquals("Img", ((TextType) getResult6).getStringValue());
    assertEquals("Img", getResult2.getImage());
    assertEquals("Img", ((TextType) getResult6).getRawValue());
    assertEquals("Img", ((TextType) getResult6).getValue());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult7 = allAttributes.get(0);
    assertEquals("Resource", getResult7.getValue());
    assertEquals("height", getResult4.getPropertyName());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult2.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult7.getNamespace());
    assertEquals("image", getResult6.getPropertyName());
    assertEquals("parseType", getResult7.getName());
    assertEquals("width", getResult5.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmpGImg", getResult4.getPrefix());
    assertEquals("xmpGImg", getResult5.getPrefix());
    assertEquals("xmpGImg", getResult3.getPrefix());
    assertEquals("xmpGImg", getResult6.getPrefix());
    assertEquals("xmpGImg", getResult2.getPreferedPrefix());
    assertEquals("xmpGImg", getResult2.getPrefix());
    assertNull(getResult4.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult3.getNamespace());
    assertNull(getResult6.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertEquals(1, ((IntegerType) getResult5).getValue().intValue());
    assertEquals(1, getResult2.getWidth().intValue());
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    assertEquals(2, ((IntegerType) getResult4).getValue().intValue());
    assertEquals(2, getResult2.getHeight().intValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, getResult3.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(getResult2, allProperties3.get(0));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}
   */
  @Test
  void testAddThumbnails2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.THUMBNAILS, XMPBasicSchema.THUMBNAILS);

    // Act
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(2, thumbnailsProperty.size());
    ThumbnailType getResult2 = thumbnailsProperty.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(4, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(2);
    assertTrue(getResult3 instanceof ChoiceType);
    ThumbnailType getResult4 = thumbnailsProperty.get(1);
    List<AbstractField> allProperties3 = getResult4.getAllProperties();
    assertEquals(4, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(2);
    assertTrue(getResult5 instanceof ChoiceType);
    AbstractField getResult6 = allProperties2.get(0);
    assertTrue(getResult6 instanceof IntegerType);
    AbstractField getResult7 = allProperties2.get(1);
    assertTrue(getResult7 instanceof IntegerType);
    AbstractField getResult8 = allProperties3.get(0);
    assertTrue(getResult8 instanceof IntegerType);
    AbstractField getResult9 = allProperties3.get(1);
    assertTrue(getResult9 instanceof IntegerType);
    AbstractField getResult10 = allProperties2.get(3);
    assertTrue(getResult10 instanceof TextType);
    AbstractField getResult11 = allProperties3.get(3);
    assertTrue(getResult11 instanceof TextType);
    assertEquals("1", ((IntegerType) getResult7).getStringValue());
    assertEquals("1", ((IntegerType) getResult9).getStringValue());
    assertEquals("2", ((IntegerType) getResult6).getStringValue());
    assertEquals("2", ((IntegerType) getResult8).getStringValue());
    assertEquals("Format", ((ChoiceType) getResult5).getStringValue());
    assertEquals("Format", getResult4.getFormat());
    assertEquals("Format", ((ChoiceType) getResult5).getRawValue());
    assertEquals("Format", ((ChoiceType) getResult5).getValue());
    assertEquals("Img", ((TextType) getResult11).getStringValue());
    assertEquals("Img", getResult4.getImage());
    assertEquals("Img", ((TextType) getResult11).getRawValue());
    assertEquals("Img", ((TextType) getResult11).getValue());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult12 = allAttributes.get(0);
    assertEquals("Resource", getResult12.getValue());
    List<Attribute> allAttributes2 = getResult4.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult13 = allAttributes2.get(0);
    assertEquals("Resource", getResult13.getValue());
    assertEquals("height", getResult6.getPropertyName());
    assertEquals("height", getResult8.getPropertyName());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult4.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult12.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult13.getNamespace());
    assertEquals("image", getResult10.getPropertyName());
    assertEquals("image", getResult11.getPropertyName());
    assertEquals("parseType", getResult12.getName());
    assertEquals("parseType", getResult13.getName());
    assertEquals("width", getResult7.getPropertyName());
    assertEquals("width", getResult9.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmpGImg", getResult6.getPrefix());
    assertEquals("xmpGImg", getResult7.getPrefix());
    assertEquals("xmpGImg", getResult3.getPrefix());
    assertEquals("xmpGImg", getResult10.getPrefix());
    assertEquals("xmpGImg", getResult8.getPrefix());
    assertEquals("xmpGImg", getResult9.getPrefix());
    assertEquals("xmpGImg", getResult5.getPrefix());
    assertEquals("xmpGImg", getResult11.getPrefix());
    assertEquals("xmpGImg", getResult2.getPreferedPrefix());
    assertEquals("xmpGImg", getResult4.getPreferedPrefix());
    assertEquals("xmpGImg", getResult2.getPrefix());
    assertEquals("xmpGImg", getResult4.getPrefix());
    assertNull(getResult6.getNamespace());
    assertNull(getResult7.getNamespace());
    assertNull(getResult3.getNamespace());
    assertNull(getResult10.getNamespace());
    assertNull(getResult8.getNamespace());
    assertNull(getResult9.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult11.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertNull(getResult4.getPropertyName());
    assertEquals(1, ((IntegerType) getResult7).getValue().intValue());
    assertEquals(1, ((IntegerType) getResult9).getValue().intValue());
    assertEquals(1, getResult2.getWidth().intValue());
    assertEquals(1, getResult4.getWidth().intValue());
    assertEquals(2, ((IntegerType) getResult6).getValue().intValue());
    assertEquals(2, ((IntegerType) getResult8).getValue().intValue());
    assertEquals(2, getResult2.getHeight().intValue());
    assertEquals(2, getResult4.getHeight().intValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult7.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult10.getAllAttributes().isEmpty());
    assertTrue(getResult8.getAllAttributes().isEmpty());
    assertTrue(getResult9.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult11.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(getResult4.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(thumbnailsProperty, ((ArrayProperty) getResult).getAllProperties());
    assertEquals(DublinCoreSchema.FORMAT, getResult3.getPropertyName());
    assertEquals(DublinCoreSchema.FORMAT, getResult5.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult3).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult10).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult2.getFormat());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult2.getImage());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult3).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult10).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult3).getValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult10).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult7.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult10.getMetadata());
    assertSame(metadata, getResult8.getMetadata());
    assertSame(metadata, getResult9.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult11.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPBasicSchema#addThumbnails(Integer, Integer, String, String)}
   */
  @Test
  void testAddThumbnails3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.THUMBNAILS, "42");

    // Act
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    ThumbnailType getResult2 = thumbnailsProperty.get(0);
    List<AbstractField> allProperties2 = getResult2.getAllProperties();
    assertEquals(4, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(2);
    assertTrue(getResult3 instanceof ChoiceType);
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof IntegerType);
    AbstractField getResult5 = allProperties2.get(1);
    assertTrue(getResult5 instanceof IntegerType);
    AbstractField getResult6 = allProperties2.get(3);
    assertTrue(getResult6 instanceof TextType);
    assertEquals("1", ((IntegerType) getResult5).getStringValue());
    assertEquals("2", ((IntegerType) getResult4).getStringValue());
    assertEquals("Format", ((ChoiceType) getResult3).getStringValue());
    assertEquals("Format", getResult2.getFormat());
    assertEquals("Format", ((ChoiceType) getResult3).getRawValue());
    assertEquals("Format", ((ChoiceType) getResult3).getValue());
    assertEquals("Img", ((TextType) getResult6).getStringValue());
    assertEquals("Img", getResult2.getImage());
    assertEquals("Img", ((TextType) getResult6).getRawValue());
    assertEquals("Img", ((TextType) getResult6).getValue());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult7 = allAttributes.get(0);
    assertEquals("Resource", getResult7.getValue());
    assertEquals("height", getResult4.getPropertyName());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult2.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult7.getNamespace());
    assertEquals("image", getResult6.getPropertyName());
    assertEquals("parseType", getResult7.getName());
    assertEquals("width", getResult5.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmpGImg", getResult4.getPrefix());
    assertEquals("xmpGImg", getResult5.getPrefix());
    assertEquals("xmpGImg", getResult3.getPrefix());
    assertEquals("xmpGImg", getResult6.getPrefix());
    assertEquals("xmpGImg", getResult2.getPreferedPrefix());
    assertEquals("xmpGImg", getResult2.getPrefix());
    assertNull(getResult4.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult3.getNamespace());
    assertNull(getResult6.getNamespace());
    assertNull(getResult2.getPropertyName());
    assertEquals(1, ((IntegerType) getResult5).getValue().intValue());
    assertEquals(1, getResult2.getWidth().intValue());
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    assertEquals(2, ((IntegerType) getResult4).getValue().intValue());
    assertEquals(2, getResult2.getHeight().intValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, getResult3.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getPropertyName());
    assertSame(getResult2, allProperties3.get(0));
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  void testAddAdvisory() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    ArrayProperty advisoryProperty = xmpBasicSchema.getAdvisoryProperty();
    List<AbstractField> allProperties = advisoryProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(1, advisory.size());
    assertEquals("Xpath", advisory.get(0));
    List<String> elementsAsString = advisoryProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Xpath", elementsAsString.get(0));
    assertEquals("Xpath", ((TextType) getResult).getStringValue());
    assertEquals("Xpath", ((TextType) getResult).getRawValue());
    assertEquals("Xpath", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", advisoryProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmp", advisoryProperty.getPrefix());
    assertNull(xmpBasicSchema.getThumbnailsProperty());
    assertNull(xmpBasicSchema.getIdentifiersProperty());
    List<AbstractField> allProperties2 = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, advisoryProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.ADVISORY, advisoryProperty.getPropertyName());
    assertSame(advisoryProperty, allProperties2.get(0));
    assertSame(allProperties, advisoryProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, advisoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  void testAddAdvisory2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty advisoryProperty = xmpBasicSchema.getAdvisoryProperty();
    List<AbstractField> allProperties2 = advisoryProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(1, advisory.size());
    assertEquals("Xpath", advisory.get(0));
    List<String> elementsAsString = advisoryProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Xpath", elementsAsString.get(0));
    assertEquals("Xpath", ((TextType) getResult2).getStringValue());
    assertEquals("Xpath", ((TextType) getResult2).getRawValue());
    assertEquals("Xpath", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", advisoryProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmp", getResult2.getPrefix());
    assertEquals("xmp", advisoryProperty.getPrefix());
    assertNull(xmpBasicSchema.getIdentifiersProperty());
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    assertEquals(Cardinality.Bag, advisoryProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllAttributes().isEmpty());
    assertTrue(thumbnailsProperty.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(advisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.ADVISORY, advisoryProperty.getPropertyName());
    assertSame(advisoryProperty, allProperties.get(1));
    assertSame(allProperties2, advisoryProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, advisoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  void testAddAdvisory3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty advisoryProperty = xmpBasicSchema.getAdvisoryProperty();
    List<AbstractField> allProperties2 = advisoryProperty.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof TextType);
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(2, advisory.size());
    assertEquals("Xpath", advisory.get(1));
    assertEquals("Xpath", ((TextType) getResult3).getStringValue());
    assertEquals("Xpath", ((TextType) getResult3).getRawValue());
    assertEquals("Xpath", ((TextType) getResult3).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", advisoryProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("xmp", getResult2.getPrefix());
    assertEquals("xmp", getResult3.getPrefix());
    assertEquals("xmp", advisoryProperty.getPrefix());
    assertNull(xmpBasicSchema.getIdentifiersProperty());
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    assertEquals(Cardinality.Bag, advisoryProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllAttributes().isEmpty());
    assertTrue(thumbnailsProperty.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(advisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(advisory, advisoryProperty.getElementsAsString());
    assertEquals(XMPBasicSchema.ADVISORY, advisoryProperty.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, advisory.get(0));
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult2).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult2).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult2).getValue());
    assertSame(advisoryProperty, allProperties.get(0));
    assertSame(allProperties2, advisoryProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, advisoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addAdvisory(String)}
   */
  @Test
  void testAddAdvisory4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    xmpBasicSchema.addAdvisory("Xpath");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty advisoryProperty = xmpBasicSchema.getAdvisoryProperty();
    List<AbstractField> allProperties2 = advisoryProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> advisory = xmpBasicSchema.getAdvisory();
    assertEquals(1, advisory.size());
    assertEquals("Xpath", advisory.get(0));
    List<String> elementsAsString = advisoryProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Xpath", elementsAsString.get(0));
    assertEquals("Xpath", ((TextType) getResult2).getStringValue());
    assertEquals("Xpath", ((TextType) getResult2).getRawValue());
    assertEquals("Xpath", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", advisoryProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmp", getResult2.getPrefix());
    assertEquals("xmp", advisoryProperty.getPrefix());
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    assertEquals(Cardinality.Bag, advisoryProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(advisoryProperty.getAllAttributes().isEmpty());
    assertTrue(thumbnailsProperty.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(advisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.ADVISORY, advisoryProperty.getPropertyName());
    assertSame(advisoryProperty, allProperties.get(2));
    assertSame(identifiersProperty, allProperties.get(0));
    assertSame(allProperties2, advisoryProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, advisoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
  void testSetBaseURL3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act
    xmpBasicSchema.setBaseURL("https://example.org/example");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
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
    assertSame(baseURLProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setBaseURL(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  void testSetBaseURLProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpBasicSchema.setBaseURLProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(url, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  void testSetBaseURLProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

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
   * Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  void testSetBaseURLProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("https://example.org/example");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpBasicSchema.setBaseURLProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(url, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setBaseURLProperty(URLType)}
   */
  @Test
  void testSetBaseURLProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("https://example.org/example", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

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
   * Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
  void testSetCreateDate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setCreateDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    DateType createDateProperty = xmpBasicSchema.getCreateDateProperty();
    assertEquals("xmp", createDateProperty.getPrefix());
    assertNull(createDateProperty.getNamespace());
    assertTrue(createDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATEDATE, createDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getCreateDate());
    assertSame(date, createDateProperty.getRawValue());
    assertSame(date, createDateProperty.getValue());
    assertSame(createDateProperty, allProperties.get(2));
    assertSame(metadata, createDateProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setCreateDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  void testSetCreateDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setCreateDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  void testSetCreateDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setCreateDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  void testSetCreateDateProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setCreateDateProperty(DateType)}
   */
  @Test
  void testSetCreateDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
  void testSetCreatorTool3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act
    xmpBasicSchema.setCreatorTool("Creator Tool");

    // Assert
    TextType creatorToolProperty = xmpBasicSchema.getCreatorToolProperty();
    assertTrue(creatorToolProperty instanceof AgentNameType);
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertEquals("Creator Tool", xmpBasicSchema.getCreatorTool());
    assertEquals("Creator Tool", creatorToolProperty.getStringValue());
    assertEquals("Creator Tool", creatorToolProperty.getRawValue());
    assertEquals("Creator Tool", creatorToolProperty.getValue());
    assertEquals("xmp", creatorToolProperty.getPrefix());
    assertNull(creatorToolProperty.getNamespace());
    assertTrue(creatorToolProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.CREATORTOOL, creatorToolProperty.getPropertyName());
    assertSame(metadata, creatorToolProperty.getMetadata());
    assertSame(creatorToolProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setCreatorTool(String)}
   */
  @Test
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
   * Method under test:
   * {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  void testSetCreatorToolProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    AgentNameType creatorTool = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    xmpBasicSchema.setCreatorToolProperty(creatorTool);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(creatorTool, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  void testSetCreatorToolProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    AgentNameType creatorTool = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

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
   * Method under test:
   * {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  void testSetCreatorToolProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Property Name");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    AgentNameType creatorTool = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Act
    xmpBasicSchema.setCreatorToolProperty(creatorTool);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(creatorTool, allProperties.get(2));
  }

  /**
   * Method under test:
   * {@link XMPBasicSchema#setCreatorToolProperty(AgentNameType)}
   */
  @Test
  void testSetCreatorToolProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    AgentNameType creatorTool = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "Value");

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
   * Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  void testAddIdentifier() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    List<AbstractField> allProperties = identifiersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(1, identifiers.size());
    assertEquals("Text", identifiers.get(0));
    List<String> elementsAsString = identifiersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", identifiersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmp", identifiersProperty.getPrefix());
    assertNull(xmpBasicSchema.getThumbnailsProperty());
    List<AbstractField> allProperties2 = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, identifiersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.IDENTIFIER, identifiersProperty.getPropertyName());
    assertSame(identifiersProperty, allProperties2.get(0));
    assertSame(allProperties, identifiersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, identifiersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  void testAddIdentifier2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    List<AbstractField> allProperties2 = identifiersProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(1, identifiers.size());
    assertEquals("Text", identifiers.get(0));
    List<String> elementsAsString = identifiersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult2).getStringValue());
    assertEquals("Text", ((TextType) getResult2).getRawValue());
    assertEquals("Text", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", identifiersProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmp", getResult2.getPrefix());
    assertEquals("xmp", identifiersProperty.getPrefix());
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    assertEquals(Cardinality.Bag, identifiersProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllAttributes().isEmpty());
    assertTrue(thumbnailsProperty.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.IDENTIFIER, identifiersProperty.getPropertyName());
    assertSame(identifiersProperty, allProperties.get(1));
    assertSame(allProperties2, identifiersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, identifiersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  void testAddIdentifier3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    List<AbstractField> allProperties2 = identifiersProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult = allProperties2.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(1, identifiers.size());
    assertEquals("Text", identifiers.get(0));
    List<String> elementsAsString = identifiersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Text", elementsAsString.get(0));
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", identifiersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmp", identifiersProperty.getPrefix());
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    assertEquals(Cardinality.Bag, identifiersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllAttributes().isEmpty());
    assertTrue(thumbnailsProperty.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.IDENTIFIER, identifiersProperty.getPropertyName());
    assertSame(identifiersProperty, allProperties.get(2));
    assertSame(allProperties2, identifiersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, identifiersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#addIdentifier(String)}
   */
  @Test
  void testAddIdentifier4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    xmpBasicSchema.addIdentifier("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    ArrayProperty identifiersProperty = xmpBasicSchema.getIdentifiersProperty();
    List<AbstractField> allProperties2 = identifiersProperty.getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult = allProperties2.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties2.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> identifiers = xmpBasicSchema.getIdentifiers();
    assertEquals(2, identifiers.size());
    assertEquals("Text", identifiers.get(1));
    assertEquals("Text", ((TextType) getResult2).getStringValue());
    assertEquals("Text", ((TextType) getResult2).getRawValue());
    assertEquals("Text", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", identifiersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmp", getResult2.getPrefix());
    assertEquals("xmp", identifiersProperty.getPrefix());
    List<ThumbnailType> thumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();
    assertEquals(1, thumbnailsProperty.size());
    assertEquals(Cardinality.Bag, identifiersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(identifiersProperty.getAllAttributes().isEmpty());
    assertTrue(thumbnailsProperty.get(0).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(identifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(identifiers, identifiersProperty.getElementsAsString());
    assertEquals(XMPBasicSchema.IDENTIFIER, identifiersProperty.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, identifiers.get(0));
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getValue());
    assertSame(identifiersProperty, allProperties.get(0));
    assertSame(allProperties2, identifiersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, identifiersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
  void testSetLabel3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act
    xmpBasicSchema.setLabel("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertEquals("Text", xmpBasicSchema.getLabel());
    TextType labelProperty = xmpBasicSchema.getLabelProperty();
    assertEquals("Text", labelProperty.getStringValue());
    assertEquals("Text", labelProperty.getRawValue());
    assertEquals("Text", labelProperty.getValue());
    assertEquals("xmp", labelProperty.getPrefix());
    assertNull(labelProperty.getNamespace());
    assertTrue(labelProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.LABEL, labelProperty.getPropertyName());
    assertSame(labelProperty, allProperties.get(2));
    assertSame(metadata, labelProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setLabel(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  void testSetLabelProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setLabelProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  void testSetLabelProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

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
   * Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  void testSetLabelProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Property Name");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setLabelProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setLabelProperty(TextType)}
   */
  @Test
  void testSetLabelProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

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
   * Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
  void testSetMetadataDate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setMetadataDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    DateType metadataDateProperty = xmpBasicSchema.getMetadataDateProperty();
    assertEquals("xmp", metadataDateProperty.getPrefix());
    assertNull(metadataDateProperty.getNamespace());
    assertTrue(metadataDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.METADATADATE, metadataDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getMetadataDate());
    assertSame(date, metadataDateProperty.getRawValue());
    assertSame(date, metadataDateProperty.getValue());
    assertSame(metadataDateProperty, allProperties.get(2));
    assertSame(metadata, metadataDateProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setMetadataDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  void testSetMetadataDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setMetadataDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  void testSetMetadataDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setMetadataDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  void testSetMetadataDateProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setMetadataDateProperty(DateType)}
   */
  @Test
  void testSetMetadataDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
  void testSetModifyDate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifyDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    DateType modifyDateProperty = xmpBasicSchema.getModifyDateProperty();
    assertEquals("xmp", modifyDateProperty.getPrefix());
    assertNull(modifyDateProperty.getNamespace());
    assertTrue(modifyDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFYDATE, modifyDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifyDate());
    assertSame(date, modifyDateProperty.getRawValue());
    assertSame(date, modifyDateProperty.getValue());
    assertSame(modifyDateProperty, allProperties.get(2));
    assertSame(metadata, modifyDateProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifyDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
  void testSetModifierDate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    xmpBasicSchema.setModifierDate(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    DateType modifierDateProperty = xmpBasicSchema.getModifierDateProperty();
    assertEquals("xmp", modifierDateProperty.getPrefix());
    assertNull(modifierDateProperty.getNamespace());
    assertTrue(modifierDateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.MODIFIER_DATE, modifierDateProperty.getPropertyName());
    assertSame(date, xmpBasicSchema.getModifierDate());
    assertSame(date, modifierDateProperty.getRawValue());
    assertSame(date, modifierDateProperty.getValue());
    assertSame(modifierDateProperty, allProperties.get(2));
    assertSame(metadata, modifierDateProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifierDate(Calendar)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  void testSetModifyDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifyDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  void testSetModifyDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifyDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  void testSetModifyDateProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifyDateProperty(DateType)}
   */
  @Test
  void testSetModifyDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  void testSetModifierDateProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifierDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(date, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  void testSetModifierDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    xmpBasicSchema.setModifierDateProperty(date);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(date, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  void testSetModifierDateProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setModifierDateProperty(DateType)}
   */
  @Test
  void testSetModifierDateProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    DateType date = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

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
    assertSame(date, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
  void testSetNickname3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act
    xmpBasicSchema.setNickname("Text");

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertEquals("Text", xmpBasicSchema.getNickname());
    TextType nicknameProperty = xmpBasicSchema.getNicknameProperty();
    assertEquals("Text", nicknameProperty.getStringValue());
    assertEquals("Text", nicknameProperty.getRawValue());
    assertEquals("Text", nicknameProperty.getValue());
    assertEquals("xmp", nicknameProperty.getPrefix());
    assertNull(nicknameProperty.getNamespace());
    assertTrue(nicknameProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.NICKNAME, nicknameProperty.getPropertyName());
    assertSame(nicknameProperty, allProperties.get(2));
    assertSame(metadata, nicknameProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setNickname(String)}
   */
  @Test
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
   * Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  void testSetNicknameProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setNicknameProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  void testSetNicknameProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

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
   * Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  void testSetNicknameProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory("Property Name");
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpBasicSchema.setNicknameProperty(text);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setNicknameProperty(TextType)}
   */
  @Test
  void testSetNicknameProperty4() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, "Format", "Img");
    TextType text = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

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
   * Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
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
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(0));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
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
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(1));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
  void testSetRating3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act
    xmpBasicSchema.setRating(1);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    IntegerType ratingProperty = xmpBasicSchema.getRatingProperty();
    assertEquals("1", ratingProperty.getStringValue());
    assertEquals("xmp", ratingProperty.getPrefix());
    assertNull(ratingProperty.getNamespace());
    assertEquals(1, xmpBasicSchema.getRating().intValue());
    assertEquals(1, ratingProperty.getValue().intValue());
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(2));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRating(Integer)}
   */
  @Test
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
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ratingProperty.getAllAttributes().isEmpty());
    assertEquals(XMPBasicSchema.RATING, ratingProperty.getPropertyName());
    assertSame(ratingProperty, allProperties.get(0));
    assertSame(metadata, ratingProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  void testSetRatingProperty() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    IntegerType rate = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpBasicSchema.setRatingProperty(rate);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(rate, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  void testSetRatingProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    IntegerType rate = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpBasicSchema.setRatingProperty(rate);

    // Assert
    List<AbstractField> allProperties = xmpBasicSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(rate, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  void testSetRatingProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    IntegerType rate = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

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
    assertSame(rate, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#setRatingProperty(IntegerType)}
   */
  @Test
  void testSetRatingProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addBagValueAsSimple("Property Name", XMPBasicSchema.ADVISORY);
    xmpBasicSchema.addAdvisory("Xpath");
    xmpBasicSchema.addThumbnails(1, 2, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);
    IntegerType rate = new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

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
    assertSame(rate, allProperties.get(2));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getAdvisoryProperty()}
   */
  @Test
  void testGetAdvisoryProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getAdvisoryProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getAdvisoryProperty()}
   */
  @Test
  void testGetAdvisoryProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act and Assert
    assertNull(xmpBasicSchema.getAdvisoryProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getAdvisoryProperty()}
   */
  @Test
  void testGetAdvisoryProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act
    ArrayProperty actualAdvisoryProperty = xmpBasicSchema.getAdvisoryProperty();

    // Assert
    List<AbstractField> allProperties = actualAdvisoryProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualAdvisoryProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmp", actualAdvisoryProperty.getPrefix());
    List<String> elementsAsString = actualAdvisoryProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualAdvisoryProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualAdvisoryProperty.getAllAttributes().isEmpty());
    assertTrue(actualAdvisoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.ADVISORY, actualAdvisoryProperty.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, elementsAsString.get(0));
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualAdvisoryProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualAdvisoryProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getAdvisory()}
   */
  @Test
  void testGetAdvisory() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getAdvisory());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getAdvisory()}
   */
  @Test
  void testGetAdvisory2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.ADVISORY, XMPBasicSchema.ADVISORY);

    // Act and Assert
    assertNull(xmpBasicSchema.getAdvisory());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getAdvisory()}
   */
  @Test
  void testGetAdvisory3() {
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
   * Method under test: {@link XMPBasicSchema#getBaseURLProperty()}
   */
  @Test
  void testGetBaseURLProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getBaseURLProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getBaseURLProperty()}
   */
  @Test
  void testGetBaseURLProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURLProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getBaseURLProperty()}
   */
  @Test
  void testGetBaseURLProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURLProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getBaseURL()}
   */
  @Test
  void testGetBaseURL() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getBaseURL());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getBaseURL()}
   */
  @Test
  void testGetBaseURL2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURL());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getBaseURL()}
   */
  @Test
  void testGetBaseURL3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.BASEURL, XMPBasicSchema.BASEURL);

    // Act and Assert
    assertNull(xmpBasicSchema.getBaseURL());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreateDateProperty()}
   */
  @Test
  void testGetCreateDateProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getCreateDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreateDateProperty()}
   */
  @Test
  void testGetCreateDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreateDateProperty()}
   */
  @Test
  void testGetCreateDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreateDate()}
   */
  @Test
  void testGetCreateDate() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getCreateDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreateDate()}
   */
  @Test
  void testGetCreateDate2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreateDate()}
   */
  @Test
  void testGetCreateDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATEDATE, XMPBasicSchema.CREATEDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreateDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreatorToolProperty()}
   */
  @Test
  void testGetCreatorToolProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getCreatorToolProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreatorToolProperty()}
   */
  @Test
  void testGetCreatorToolProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorToolProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreatorToolProperty()}
   */
  @Test
  void testGetCreatorToolProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorToolProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreatorTool()}
   */
  @Test
  void testGetCreatorTool() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getCreatorTool());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreatorTool()}
   */
  @Test
  void testGetCreatorTool2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorTool());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getCreatorTool()}
   */
  @Test
  void testGetCreatorTool3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.CREATORTOOL, XMPBasicSchema.CREATORTOOL);

    // Act and Assert
    assertNull(xmpBasicSchema.getCreatorTool());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  void testGetIdentifiersProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getIdentifiersProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  void testGetIdentifiersProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act and Assert
    assertNull(xmpBasicSchema.getIdentifiersProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  void testGetIdentifiersProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act and Assert
    assertNull(xmpBasicSchema.getIdentifiersProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiersProperty()}
   */
  @Test
  void testGetIdentifiersProperty4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addIdentifier(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act
    ArrayProperty actualIdentifiersProperty = xmpBasicSchema.getIdentifiersProperty();

    // Assert
    List<AbstractField> allProperties = actualIdentifiersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualIdentifiersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmp", getResult.getPrefix());
    assertEquals("xmp", actualIdentifiersProperty.getPrefix());
    List<String> elementsAsString = actualIdentifiersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Bag, actualIdentifiersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualIdentifiersProperty.getAllAttributes().isEmpty());
    assertTrue(actualIdentifiersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPBasicSchema.IDENTIFIER, actualIdentifiersProperty.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, elementsAsString.get(0));
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualIdentifiersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualIdentifiersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiers()}
   */
  @Test
  void testGetIdentifiers() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getIdentifiers());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiers()}
   */
  @Test
  void testGetIdentifiers2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.IDENTIFIER, XMPBasicSchema.IDENTIFIER);

    // Act and Assert
    assertNull(xmpBasicSchema.getIdentifiers());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getIdentifiers()}
   */
  @Test
  void testGetIdentifiers3() {
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
   * Method under test: {@link XMPBasicSchema#getLabelProperty()}
   */
  @Test
  void testGetLabelProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getLabelProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getLabelProperty()}
   */
  @Test
  void testGetLabelProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabelProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getLabelProperty()}
   */
  @Test
  void testGetLabelProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabelProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getLabel()}
   */
  @Test
  void testGetLabel() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getLabel());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getLabel()}
   */
  @Test
  void testGetLabel2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabel());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getLabel()}
   */
  @Test
  void testGetLabel3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.LABEL, XMPBasicSchema.LABEL);

    // Act and Assert
    assertNull(xmpBasicSchema.getLabel());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getMetadataDateProperty()}
   */
  @Test
  void testGetMetadataDateProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getMetadataDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getMetadataDateProperty()}
   */
  @Test
  void testGetMetadataDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getMetadataDateProperty()}
   */
  @Test
  void testGetMetadataDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getMetadataDate()}
   */
  @Test
  void testGetMetadataDate() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getMetadataDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getMetadataDate()}
   */
  @Test
  void testGetMetadataDate2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getMetadataDate()}
   */
  @Test
  void testGetMetadataDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.METADATADATE, XMPBasicSchema.METADATADATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getMetadataDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifyDateProperty()}
   */
  @Test
  void testGetModifyDateProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getModifyDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifyDateProperty()}
   */
  @Test
  void testGetModifyDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifyDateProperty()}
   */
  @Test
  void testGetModifyDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifierDateProperty()}
   */
  @Test
  void testGetModifierDateProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getModifierDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifierDateProperty()}
   */
  @Test
  void testGetModifierDateProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifierDateProperty()}
   */
  @Test
  void testGetModifierDateProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDateProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifyDate()}
   */
  @Test
  void testGetModifyDate() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getModifyDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifyDate()}
   */
  @Test
  void testGetModifyDate2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifyDate()}
   */
  @Test
  void testGetModifyDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFYDATE, XMPBasicSchema.MODIFYDATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifyDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifierDate()}
   */
  @Test
  void testGetModifierDate() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getModifierDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifierDate()}
   */
  @Test
  void testGetModifierDate2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getModifierDate()}
   */
  @Test
  void testGetModifierDate3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.MODIFIER_DATE, XMPBasicSchema.MODIFIER_DATE);

    // Act and Assert
    assertNull(xmpBasicSchema.getModifierDate());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getNicknameProperty()}
   */
  @Test
  void testGetNicknameProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getNicknameProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getNicknameProperty()}
   */
  @Test
  void testGetNicknameProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNicknameProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getNicknameProperty()}
   */
  @Test
  void testGetNicknameProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNicknameProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getNickname()}
   */
  @Test
  void testGetNickname() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getNickname());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getNickname()}
   */
  @Test
  void testGetNickname2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNickname());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getNickname()}
   */
  @Test
  void testGetNickname3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.NICKNAME, XMPBasicSchema.NICKNAME);

    // Act and Assert
    assertNull(xmpBasicSchema.getNickname());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getRatingProperty()}
   */
  @Test
  void testGetRatingProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getRatingProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getRatingProperty()}
   */
  @Test
  void testGetRatingProperty2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRatingProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getRatingProperty()}
   */
  @Test
  void testGetRatingProperty3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRatingProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getRating()}
   */
  @Test
  void testGetRating() {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getRating());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getRating()}
   */
  @Test
  void testGetRating2() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRating());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getRating()}
   */
  @Test
  void testGetRating3() {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addAdvisory(XMPBasicSchema.THUMBNAILS);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.RATING, XMPBasicSchema.RATING);

    // Act and Assert
    assertNull(xmpBasicSchema.getRating());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  void testGetThumbnailsProperty() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPBasicSchema(XMPMetadata.createXMPMetadata())).getThumbnailsProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  void testGetThumbnailsProperty2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(metadata);
    xmpBasicSchema.addThumbnails(2, 1, XMPBasicSchema.THUMBNAILS, XMPBasicSchema.THUMBNAILS);

    // Act
    List<ThumbnailType> actualThumbnailsProperty = xmpBasicSchema.getThumbnailsProperty();

    // Assert
    assertEquals(1, actualThumbnailsProperty.size());
    ThumbnailType getResult = actualThumbnailsProperty.get(0);
    List<AbstractField> allProperties = getResult.getAllProperties();
    assertEquals(4, allProperties.size());
    AbstractField getResult2 = allProperties.get(2);
    assertTrue(getResult2 instanceof ChoiceType);
    AbstractField getResult3 = allProperties.get(0);
    assertTrue(getResult3 instanceof IntegerType);
    AbstractField getResult4 = allProperties.get(1);
    assertTrue(getResult4 instanceof IntegerType);
    AbstractField getResult5 = allProperties.get(3);
    assertTrue(getResult5 instanceof TextType);
    assertEquals("1", ((IntegerType) getResult4).getStringValue());
    assertEquals("2", ((IntegerType) getResult3).getStringValue());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult6 = allAttributes.get(0);
    assertEquals("Resource", getResult6.getValue());
    assertEquals("height", getResult3.getPropertyName());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult6.getNamespace());
    assertEquals("image", getResult5.getPropertyName());
    assertEquals("parseType", getResult6.getName());
    assertEquals("width", getResult4.getPropertyName());
    assertEquals("xmpGImg", getResult3.getPrefix());
    assertEquals("xmpGImg", getResult4.getPrefix());
    assertEquals("xmpGImg", getResult2.getPrefix());
    assertEquals("xmpGImg", getResult5.getPrefix());
    assertEquals("xmpGImg", getResult.getPreferedPrefix());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult2.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult.getPropertyName());
    assertEquals(1, ((IntegerType) getResult4).getValue().intValue());
    assertEquals(1, getResult.getWidth().intValue());
    assertEquals(2, ((IntegerType) getResult3).getValue().intValue());
    assertEquals(2, getResult.getHeight().intValue());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, getResult2.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult2).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult5).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getFormat());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getImage());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult2).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult5).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult2).getValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult5).getValue());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  void testGetThumbnailsProperty3() throws BadFieldValueException {
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
    List<AbstractField> allProperties = getResult.getAllProperties();
    assertEquals(4, allProperties.size());
    AbstractField getResult2 = allProperties.get(2);
    assertTrue(getResult2 instanceof ChoiceType);
    AbstractField getResult3 = allProperties.get(0);
    assertTrue(getResult3 instanceof IntegerType);
    AbstractField getResult4 = allProperties.get(1);
    assertTrue(getResult4 instanceof IntegerType);
    AbstractField getResult5 = allProperties.get(3);
    assertTrue(getResult5 instanceof TextType);
    assertEquals("1", ((IntegerType) getResult4).getStringValue());
    assertEquals("2", ((IntegerType) getResult3).getStringValue());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult6 = allAttributes.get(0);
    assertEquals("Resource", getResult6.getValue());
    assertEquals("height", getResult3.getPropertyName());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", getResult.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult6.getNamespace());
    assertEquals("image", getResult5.getPropertyName());
    assertEquals("parseType", getResult6.getName());
    assertEquals("width", getResult4.getPropertyName());
    assertEquals("xmpGImg", getResult3.getPrefix());
    assertEquals("xmpGImg", getResult4.getPrefix());
    assertEquals("xmpGImg", getResult2.getPrefix());
    assertEquals("xmpGImg", getResult5.getPrefix());
    assertEquals("xmpGImg", getResult.getPreferedPrefix());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult3.getNamespace());
    assertNull(getResult4.getNamespace());
    assertNull(getResult2.getNamespace());
    assertNull(getResult5.getNamespace());
    assertNull(getResult.getPropertyName());
    assertEquals(1, ((IntegerType) getResult4).getValue().intValue());
    assertEquals(1, getResult.getWidth().intValue());
    assertEquals(2, ((IntegerType) getResult3).getValue().intValue());
    assertEquals(2, getResult.getHeight().intValue());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(DublinCoreSchema.FORMAT, getResult2.getPropertyName());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult2).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult5).getStringValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getFormat());
    assertEquals(XMPBasicSchema.THUMBNAILS, getResult.getImage());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult2).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult5).getRawValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((ChoiceType) getResult2).getValue());
    assertEquals(XMPBasicSchema.THUMBNAILS, ((TextType) getResult5).getValue());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#getThumbnailsProperty()}
   */
  @Test
  void testGetThumbnailsProperty4() throws BadFieldValueException {
    // Arrange
    XMPBasicSchema xmpBasicSchema = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpBasicSchema.addBagValueAsSimple(XMPBasicSchema.THUMBNAILS, "42");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> xmpBasicSchema.getThumbnailsProperty());
  }

  /**
   * Method under test: {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)}
   */
  @Test
  void testNewXMPBasicSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualXmpBasicSchema = new XMPBasicSchema(metadata);

    // Assert
    assertEquals("", actualXmpBasicSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualXmpBasicSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmp", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/"));
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
    List<AbstractField> allProperties = actualXmpBasicSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpBasicSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpBasicSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpBasicSchema.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata, String)}
   */
  @Test
  void testNewXMPBasicSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualXmpBasicSchema = new XMPBasicSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpBasicSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/"));
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
    List<AbstractField> allProperties = actualXmpBasicSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpBasicSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpBasicSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpBasicSchema.getMetadata());
  }

  /**
   * Method under test: {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata, String)}
   */
  @Test
  void testNewXMPBasicSchema3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualXmpBasicSchema = new XMPBasicSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpBasicSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualXmpBasicSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpBasicSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmp", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/"));
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
    List<AbstractField> allProperties = actualXmpBasicSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpBasicSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpBasicSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpBasicSchema.getMetadata());
  }
}
