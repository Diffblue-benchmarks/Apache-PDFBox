package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Component;
import java.awt.Dimension;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class HexEditorDiffblueTest {
  /**
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  void testSelectionChanged() throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(194, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(378, component.getPreferredSize().width);
    assertEquals(minimumSize, minimumSize.getSize());
  }

  /**
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  void testSelectionChanged2() {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel(new byte[]{}));

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert that nothing has changed
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(170, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    assertEquals(170, minimumSize.width);
    assertEquals(170.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(370, component.getPreferredSize().width);
    assertEquals(minimumSize, minimumSize.getSize());
  }

  /**
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  void testSelectionChanged3() throws UnsupportedEncodingException {
    // Arrange
    HexModel model = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    model.addHexModelChangeListener(mock(HexModelChangeListener.class));
    HexEditor hexEditor = new HexEditor(model);

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(194, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(378, component.getPreferredSize().width);
    assertEquals(minimumSize, minimumSize.getSize());
  }

  /**
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  void testSelectionChanged4() throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(-1, "0123456789ABCDEF"));

    // Assert that nothing has changed
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(170, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    assertEquals(170, minimumSize.width);
    assertEquals(170.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(370, component.getPreferredSize().width);
    assertEquals(minimumSize, minimumSize.getSize());
  }

  /**
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  void testSelectionChanged5() throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(194, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(378, component.getPreferredSize().width);
    assertEquals(minimumSize, minimumSize.getSize());
  }
}
