package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFAnnotationInkDiffblueTest {
  /**
   * Test {@link FDFAnnotationInk#FDFAnnotationInk(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationInk#FDFAnnotationInk(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationInk(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationInk.<init>(COSDictionary)"})
  void testNewFDFAnnotationInk() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationInk(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationInk#FDFAnnotationInk()}.
   *
   * <p>Method under test: {@link FDFAnnotationInk#FDFAnnotationInk()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationInk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationInk.<init>()"})
  void testNewFDFAnnotationInk2() throws IOException {
    // Arrange and Act
    FDFAnnotationInk actualFdfAnnotationInk = new FDFAnnotationInk();

    // Assert
    assertEquals("", actualFdfAnnotationInk.getRichContents());
    assertNull(actualFdfAnnotationInk.getColor());
    assertNull(actualFdfAnnotationInk.getPage());
    assertNull(actualFdfAnnotationInk.getContents());
    assertNull(actualFdfAnnotationInk.getDate());
    assertNull(actualFdfAnnotationInk.getIntent());
    assertNull(actualFdfAnnotationInk.getName());
    assertNull(actualFdfAnnotationInk.getSubject());
    assertNull(actualFdfAnnotationInk.getTitle());
    assertNull(actualFdfAnnotationInk.getCreationDate());
    assertNull(actualFdfAnnotationInk.getInkList());
    assertNull(actualFdfAnnotationInk.getRectangle());
    assertNull(actualFdfAnnotationInk.getBorderEffect());
    assertNull(actualFdfAnnotationInk.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationInk.getOpacity());
    assertFalse(actualFdfAnnotationInk.isHidden());
    assertFalse(actualFdfAnnotationInk.isInvisible());
    assertFalse(actualFdfAnnotationInk.isLocked());
    assertFalse(actualFdfAnnotationInk.isLockedContents());
    assertFalse(actualFdfAnnotationInk.isNoRotate());
    assertFalse(actualFdfAnnotationInk.isNoView());
    assertFalse(actualFdfAnnotationInk.isNoZoom());
    assertFalse(actualFdfAnnotationInk.isPrinted());
    assertFalse(actualFdfAnnotationInk.isReadOnly());
    assertFalse(actualFdfAnnotationInk.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationInk#FDFAnnotationInk(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#FDFAnnotationInk(Element)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationInk(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationInk.<init>(Element)"})
  void testNewFDFAnnotationInk_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationInk(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationInk#setInkList(List)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationInk#FDFAnnotationInk()} InkList size is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#setInkList(List)}
   */
  @Test
  @DisplayName("Test setInkList(List); then FDFAnnotationInk() InkList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationInk.setInkList(List)"})
  void testSetInkList_thenFDFAnnotationInkInkListSizeIsOne() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();

    ArrayList<float[]> inklist = new ArrayList<>();
    inklist.add(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    fdfAnnotationInk.setInkList(inklist);

    // Assert
    List<float[]> inkList = fdfAnnotationInk.getInkList();
    assertEquals(1, inkList.size());
    COSDictionary cOSObject = fdfAnnotationInk.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, inkList.get(0), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationInk#setInkList(List)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationInk#FDFAnnotationInk()} InkList size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#setInkList(List)}
   */
  @Test
  @DisplayName("Test setInkList(List); then FDFAnnotationInk() InkList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationInk.setInkList(List)"})
  void testSetInkList_thenFDFAnnotationInkInkListSizeIsTwo() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();

    ArrayList<float[]> inklist = new ArrayList<>();
    inklist.add(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    inklist.add(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    fdfAnnotationInk.setInkList(inklist);

    // Assert
    List<float[]> inkList = fdfAnnotationInk.getInkList();
    assertEquals(2, inkList.size());
    COSDictionary cOSObject = fdfAnnotationInk.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, inkList.get(0), 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, inkList.get(1), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationInk#setInkList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link FDFAnnotationInk#FDFAnnotationInk()} InkList Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#setInkList(List)}
   */
  @Test
  @DisplayName("Test setInkList(List); when ArrayList(); then FDFAnnotationInk() InkList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationInk.setInkList(List)"})
  void testSetInkList_whenArrayList_thenFDFAnnotationInkInkListEmpty() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();

    // Act
    fdfAnnotationInk.setInkList(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfAnnotationInk.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationInk.getInkList().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add array of {@code float} with ten and {@code 0.5}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName(
      "Test getInkList(); given ArrayList() add array of float with ten and '0.5'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFAnnotationInk.getInkList()"})
  void testGetInkList_givenArrayListAddArrayOfFloatWithTenAnd05_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<float[]> inklist = new ArrayList<>();
    inklist.add(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();
    fdfAnnotationInk.setInkList(inklist);

    // Act
    List<float[]> actualInkList = fdfAnnotationInk.getInkList();

    // Assert
    assertEquals(1, actualInkList.size());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualInkList.get(0), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationInk#FDFAnnotationInk()} InkList is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName(
      "Test getInkList(); given FDFAnnotationInk() InkList is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFAnnotationInk.getInkList()"})
  void testGetInkList_givenFDFAnnotationInkInkListIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();
    fdfAnnotationInk.setInkList(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfAnnotationInk.getInkList().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationInk#FDFAnnotationInk(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName(
      "Test getInkList(); given FDFAnnotationInk(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFAnnotationInk.getInkList()"})
  void testGetInkList_givenFDFAnnotationInkWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationInk(new COSDictionary()).getInkList());
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationInk#FDFAnnotationInk()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList(); given FDFAnnotationInk(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FDFAnnotationInk.getInkList()"})
  void testGetInkList_givenFDFAnnotationInk_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationInk().getInkList());
  }
}
