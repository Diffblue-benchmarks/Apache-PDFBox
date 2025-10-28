package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class LayerTypeDiffblueTest {
  /**
   * Method under test: {@link LayerType#getLayerName()}
   */
  @Test
  void testGetLayerName() {
    // Arrange, Act and Assert
    assertNull((new LayerType(XMPMetadata.createXMPMetadata())).getLayerName());
  }

  /**
   * Method under test: {@link LayerType#getLayerName()}
   */
  @Test
  void testGetLayerName2() {
    // Arrange
    LayerType layerType = new LayerType(XMPMetadata.createXMPMetadata());
    layerType.addSimpleProperty(LayerType.LAYER_NAME, "Value");

    // Act and Assert
    assertEquals("Value", layerType.getLayerName());
  }

  /**
   * Method under test: {@link LayerType#setLayerName(String)}
   */
  @Test
  void testSetLayerName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    LayerType layerType = new LayerType(metadata);

    // Act
    layerType.setLayerName("Image");

    // Assert
    List<AbstractField> allProperties = layerType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Image", layerType.getLayerName());
    assertEquals("Image", ((TextType) getResult).getStringValue());
    assertEquals("Image", ((TextType) getResult).getRawValue());
    assertEquals("Image", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("photoshop", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(LayerType.LAYER_NAME, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link LayerType#getLayerText()}
   */
  @Test
  void testGetLayerText() {
    // Arrange, Act and Assert
    assertNull((new LayerType(XMPMetadata.createXMPMetadata())).getLayerText());
  }

  /**
   * Method under test: {@link LayerType#getLayerText()}
   */
  @Test
  void testGetLayerText2() {
    // Arrange
    LayerType layerType = new LayerType(XMPMetadata.createXMPMetadata());
    layerType.addSimpleProperty(LayerType.LAYER_TEXT, "Value");

    // Act and Assert
    assertEquals("Value", layerType.getLayerText());
  }

  /**
   * Method under test: {@link LayerType#setLayerText(String)}
   */
  @Test
  void testSetLayerText() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    LayerType layerType = new LayerType(metadata);

    // Act
    layerType.setLayerText("Image");

    // Assert
    List<AbstractField> allProperties = layerType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Image", layerType.getLayerText());
    assertEquals("Image", ((TextType) getResult).getStringValue());
    assertEquals("Image", ((TextType) getResult).getRawValue());
    assertEquals("Image", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("photoshop", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(LayerType.LAYER_TEXT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link LayerType#LayerType(XMPMetadata)}
   */
  @Test
  void testNewLayerType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    LayerType actualLayerType = new LayerType(metadata);

    // Assert
    List<Attribute> allAttributes = actualLayerType.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult = allAttributes.get(0);
    assertEquals("Resource", getResult.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualLayerType.getNamespace());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", getResult.getNamespace());
    assertEquals("parseType", getResult.getName());
    assertEquals("photoshop", actualLayerType.getPreferedPrefix());
    assertEquals("photoshop", actualLayerType.getPrefix());
    assertNull(actualLayerType.getPropertyName());
    assertNull(actualLayerType.getLayerName());
    assertNull(actualLayerType.getLayerText());
    List<AbstractField> allProperties = actualLayerType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualLayerType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualLayerType.getContainer().getAllProperties());
    assertSame(metadata, actualLayerType.getMetadata());
  }
}
