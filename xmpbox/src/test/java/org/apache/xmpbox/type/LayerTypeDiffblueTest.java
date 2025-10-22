package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LayerTypeDiffblueTest {
  /**
   * Test {@link LayerType#LayerType(XMPMetadata)}.
   * <p>
   * Method under test: {@link LayerType#LayerType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new LayerType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LayerType.<init>(XMPMetadata)"})
  void testNewLayerType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    LayerType actualLayerType = new LayerType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualLayerType.getNamespace());
    assertEquals("photoshop", actualLayerType.getPreferedPrefix());
    assertEquals("photoshop", actualLayerType.getPrefix());
    assertNull(actualLayerType.getPropertyName());
    assertNull(actualLayerType.getLayerName());
    assertNull(actualLayerType.getLayerText());
    assertEquals(1, actualLayerType.getAllAttributes().size());
    assertTrue(actualLayerType.getAllProperties().isEmpty());
    assertTrue(actualLayerType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualLayerType.getMetadata());
  }

  /**
   * Test {@link LayerType#getLayerName()}.
   * <ul>
   *   <li>Given {@link LayerType#LayerType(XMPMetadata)} with metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerType#getLayerName()}
   */
  @Test
  @DisplayName("Test getLayerName(); given LayerType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LayerType.getLayerName()"})
  void testGetLayerName_givenLayerTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LayerType(XMPMetadata.createXMPMetadata())).getLayerName());
  }

  /**
   * Test {@link LayerType#getLayerName()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerType#getLayerName()}
   */
  @Test
  @DisplayName("Test getLayerName(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LayerType.getLayerName()"})
  void testGetLayerName_thenReturnValue() {
    // Arrange
    LayerType layerType = new LayerType(XMPMetadata.createXMPMetadata());
    layerType.addSimpleProperty(LayerType.LAYER_NAME, "Value");

    // Act and Assert
    assertEquals("Value", layerType.getLayerName());
  }

  /**
   * Test {@link LayerType#setLayerName(String)}.
   * <p>
   * Method under test: {@link LayerType#setLayerName(String)}
   */
  @Test
  @DisplayName("Test setLayerName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LayerType.setLayerName(String)"})
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
   * Test {@link LayerType#getLayerText()}.
   * <ul>
   *   <li>Given {@link LayerType#LayerType(XMPMetadata)} with metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerType#getLayerText()}
   */
  @Test
  @DisplayName("Test getLayerText(); given LayerType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LayerType.getLayerText()"})
  void testGetLayerText_givenLayerTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LayerType(XMPMetadata.createXMPMetadata())).getLayerText());
  }

  /**
   * Test {@link LayerType#getLayerText()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LayerType#getLayerText()}
   */
  @Test
  @DisplayName("Test getLayerText(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LayerType.getLayerText()"})
  void testGetLayerText_thenReturnValue() {
    // Arrange
    LayerType layerType = new LayerType(XMPMetadata.createXMPMetadata());
    layerType.addSimpleProperty(LayerType.LAYER_TEXT, "Value");

    // Act and Assert
    assertEquals("Value", layerType.getLayerText());
  }

  /**
   * Test {@link LayerType#setLayerText(String)}.
   * <p>
   * Method under test: {@link LayerType#setLayerText(String)}
   */
  @Test
  @DisplayName("Test setLayerText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LayerType.setLayerText(String)"})
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
}
