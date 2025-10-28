package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class ThumbnailTypeDiffblueTest {
  /**
   * Method under test: {@link ThumbnailType#getHeight()}
   */
  @Test
  void testGetHeight() {
    // Arrange, Act and Assert
    assertNull((new ThumbnailType(XMPMetadata.createXMPMetadata())).getHeight());
  }

  /**
   * Method under test: {@link ThumbnailType#getHeight()}
   */
  @Test
  void testGetHeight2() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.HEIGHT, 42);

    // Act and Assert
    assertEquals(42, thumbnailType.getHeight().intValue());
  }

  /**
   * Method under test: {@link ThumbnailType#setHeight(Integer)}
   */
  @Test
  void testSetHeight() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setHeight(1);

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("1", ((IntegerType) getResult).getStringValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(1, ((IntegerType) getResult).getValue().intValue());
    assertEquals(1, thumbnailType.getHeight().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.HEIGHT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ThumbnailType#getWidth()}
   */
  @Test
  void testGetWidth() {
    // Arrange, Act and Assert
    assertNull((new ThumbnailType(XMPMetadata.createXMPMetadata())).getWidth());
  }

  /**
   * Method under test: {@link ThumbnailType#getWidth()}
   */
  @Test
  void testGetWidth2() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.WIDTH, 42);

    // Act and Assert
    assertEquals(42, thumbnailType.getWidth().intValue());
  }

  /**
   * Method under test: {@link ThumbnailType#setWidth(Integer)}
   */
  @Test
  void testSetWidth() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setWidth(1);

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("1", ((IntegerType) getResult).getStringValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(1, ((IntegerType) getResult).getValue().intValue());
    assertEquals(1, thumbnailType.getWidth().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.WIDTH, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ThumbnailType#getImage()}
   */
  @Test
  void testGetImage() {
    // Arrange, Act and Assert
    assertNull((new ThumbnailType(XMPMetadata.createXMPMetadata())).getImage());
  }

  /**
   * Method under test: {@link ThumbnailType#getImage()}
   */
  @Test
  void testGetImage2() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.IMAGE, "Value");

    // Act and Assert
    assertEquals("Value", thumbnailType.getImage());
  }

  /**
   * Method under test: {@link ThumbnailType#setImage(String)}
   */
  @Test
  void testSetImage() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setImage("Image");

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Image", ((TextType) getResult).getStringValue());
    assertEquals("Image", thumbnailType.getImage());
    assertEquals("Image", ((TextType) getResult).getRawValue());
    assertEquals("Image", ((TextType) getResult).getValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.IMAGE, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ThumbnailType#getFormat()}
   */
  @Test
  void testGetFormat() {
    // Arrange, Act and Assert
    assertNull((new ThumbnailType(XMPMetadata.createXMPMetadata())).getFormat());
  }

  /**
   * Method under test: {@link ThumbnailType#getFormat()}
   */
  @Test
  void testGetFormat2() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.FORMAT, "Value");

    // Act and Assert
    assertEquals("Value", thumbnailType.getFormat());
  }

  /**
   * Method under test: {@link ThumbnailType#setFormat(String)}
   */
  @Test
  void testSetFormat() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setFormat("Format");

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ChoiceType);
    assertEquals("Format", ((ChoiceType) getResult).getStringValue());
    assertEquals("Format", thumbnailType.getFormat());
    assertEquals("Format", ((ChoiceType) getResult).getRawValue());
    assertEquals("Format", ((ChoiceType) getResult).getValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.FORMAT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ThumbnailType#ThumbnailType(XMPMetadata)}
   */
  @Test
  void testNewThumbnailType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ThumbnailType actualThumbnailType = new ThumbnailType(metadata);

    // Assert
    List<Attribute> allAttributes = actualThumbnailType.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult = allAttributes.get(0);
    assertEquals("Resource", getResult.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", actualThumbnailType.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult.getNamespace());
    assertEquals("parseType", getResult.getName());
    assertEquals("xmpGImg", actualThumbnailType.getPreferedPrefix());
    assertEquals("xmpGImg", actualThumbnailType.getPrefix());
    assertNull(actualThumbnailType.getHeight());
    assertNull(actualThumbnailType.getWidth());
    assertNull(actualThumbnailType.getPropertyName());
    assertNull(actualThumbnailType.getFormat());
    assertNull(actualThumbnailType.getImage());
    List<AbstractField> allProperties = actualThumbnailType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualThumbnailType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualThumbnailType.getContainer().getAllProperties());
    assertSame(metadata, actualThumbnailType.getMetadata());
  }
}
