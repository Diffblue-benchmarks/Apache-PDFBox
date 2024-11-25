package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFAnnotationInkDiffblueTest {
  /**
   * Test {@link FDFAnnotationInk#FDFAnnotationInk(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationInk#FDFAnnotationInk(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationInk(COSDictionary)")
  void testNewFDFAnnotationInk() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationInk(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationInk#FDFAnnotationInk()}.
   * <p>
   * Method under test: {@link FDFAnnotationInk#FDFAnnotationInk()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationInk()")
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
    COSDictionary cOSObject = actualFdfAnnotationInk.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationInk.getRectangle());
    assertNull(actualFdfAnnotationInk.getBorderEffect());
    assertNull(actualFdfAnnotationInk.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationInk.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationInk#setInkList(List)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationInk#FDFAnnotationInk()} InkList size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#setInkList(List)}
   */
  @Test
  @DisplayName("Test setInkList(List); then FDFAnnotationInk() InkList size is one")
  void testSetInkList_thenFDFAnnotationInkInkListSizeIsOne() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();

    ArrayList<float[]> inklist = new ArrayList<>();
    inklist.add(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    fdfAnnotationInk.setInkList(inklist);

    // Assert
    List<float[]> inkList = fdfAnnotationInk.getInkList();
    assertEquals(1, inkList.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, inkList.get(0), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationInk#setInkList(List)}.
   * <ul>
   *   <li>Then {@link FDFAnnotationInk#FDFAnnotationInk()} InkList size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#setInkList(List)}
   */
  @Test
  @DisplayName("Test setInkList(List); then FDFAnnotationInk() InkList size is two")
  void testSetInkList_thenFDFAnnotationInkInkListSizeIsTwo() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();

    ArrayList<float[]> inklist = new ArrayList<>();
    inklist.add(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    inklist.add(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    fdfAnnotationInk.setInkList(inklist);

    // Assert
    List<float[]> inkList = fdfAnnotationInk.getInkList();
    assertEquals(2, inkList.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, inkList.get(1), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationInk#setInkList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFAnnotationInk#FDFAnnotationInk()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#setInkList(List)}
   */
  @Test
  @DisplayName("Test setInkList(List); when ArrayList(); then FDFAnnotationInk() COSObject Values size is three")
  void testSetInkList_whenArrayList_thenFDFAnnotationInkCOSObjectValuesSizeIsThree() {
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add array of {@code float} with ten
   * and {@code 0.5}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList(); given ArrayList() add array of float with ten and '0.5'; then return size is one")
  void testGetInkList_givenArrayListAddArrayOfFloatWithTenAnd05_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<float[]> inklist = new ArrayList<>();
    inklist.add(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();
    fdfAnnotationInk.setInkList(inklist);

    // Act
    List<float[]> actualInkList = fdfAnnotationInk.getInkList();

    // Assert
    assertEquals(1, actualInkList.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualInkList.get(0), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationInk#FDFAnnotationInk()} InkList is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList(); given FDFAnnotationInk() InkList is ArrayList(); then return Empty")
  void testGetInkList_givenFDFAnnotationInkInkListIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFAnnotationInk fdfAnnotationInk = new FDFAnnotationInk();
    fdfAnnotationInk.setInkList(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfAnnotationInk.getInkList().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationInk#FDFAnnotationInk(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList(); given FDFAnnotationInk(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetInkList_givenFDFAnnotationInkWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationInk(new COSDictionary())).getInkList());
  }

  /**
   * Test {@link FDFAnnotationInk#getInkList()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationInk#FDFAnnotationInk()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList(); given FDFAnnotationInk(); then return 'null'")
  void testGetInkList_givenFDFAnnotationInk_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationInk()).getInkList());
  }
}
