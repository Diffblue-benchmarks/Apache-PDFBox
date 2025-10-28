package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.swing.tree.TreePath;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.debugger.ui.ArrayEntry;
import org.apache.pdfbox.debugger.ui.MapEntry;
import org.apache.pdfbox.debugger.ui.PageEntry;
import org.apache.pdfbox.debugger.ui.XrefEntry;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class TreeStatusDiffblueTest {
  /**
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  void testGetStringForPath() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    // Act and Assert
    assertEquals("", treeStatus.getStringForPath(new TreePath(new Object[]{"42"})));
  }

  /**
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  void testGetStringForPath2() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> treeStatus.getStringForPath(new TreePath(new Object[]{"42", "42"})));
  }

  /**
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  void testGetStringForPath3() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals("[1]", treeStatus.getStringForPath(new TreePath(new Object[]{"42", arrayEntry})));
  }

  /**
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  void testGetStringForPath4() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    // Act and Assert
    assertEquals("Root/Pages", treeStatus
        .getStringForPath(new TreePath(new Object[]{"42", new PageEntry(new COSDictionary(), 10, "Page Label")})));
  }

  /**
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  void testGetStringForPath5() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/Offset: 1 [1 1 R]", treeStatus.getStringForPath(
        new TreePath(new Object[]{"42", new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))})));
  }

  /**
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  void testGetPathForString() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus("Root Node")).getPathForString("Status String"));
    assertNull((new TreeStatus(new COSDictionary())).getPathForString("Status String"));
    assertNull((new TreeStatus(new COSDictionary(new COSDictionary()))).getPathForString("Status String"));
    assertNull((new TreeStatus("Root Node")).getPathForString("["));
  }

  /**
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  void testGetPathForString2() {
    // Arrange and Act
    TreePath actualPathForString = (new TreeStatus("Root Node")).getPathForString("/");

    // Assert
    assertEquals("Root Node", actualPathForString.getLastPathComponent());
    Object[] path = actualPathForString.getPath();
    assertEquals("Root Node", path[0]);
    assertNull(actualPathForString.getParentPath());
    assertEquals(1, actualPathForString.getPathCount());
    assertEquals(1, path.length);
  }

  /**
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  void testGetPathForString3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSArray());

    COSArray val = new COSArray();
    val.add(object);

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(val);
    mapEntry.setValue(new COSArray());

    // Act
    TreePath actualPathForString = (new TreeStatus(mapEntry)).getPathForString("42");

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPathForString);
  }
}
