package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDBorderStyleDictionaryDiffblueTest {
  /**
   * Test {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDBorderStyleDictionary(COSDictionary)")
  void testNewPDBorderStyleDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDBorderStyleDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}
   */
  @Test
  @DisplayName("Test new PDBorderStyleDictionary()")
  void testNewPDBorderStyleDictionary2() {
    // Arrange and Act
    PDBorderStyleDictionary actualPdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Assert
    PDLineDashPattern dashStyle = actualPdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    COSDictionary cOSObject2 = actualPdBorderStyleDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject2.getKey());
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.0f, actualPdBorderStyleDictionary.getWidth());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult3).isValid());
    assertEquals(PDBorderStyleDictionary.STYLE_SOLID, actualPdBorderStyleDictionary.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBorderStyleDictionary#setWidth(float)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setFloat(COSName, float)} does nothing.</li>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then calls {@link COSDictionary#setFloat(COSName, float)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setWidth(float)}
   */
  @Test
  @DisplayName("Test setWidth(float); given COSDictionary setFloat(COSName, float) does nothing; when '0.5'; then calls setFloat(COSName, float)")
  void testSetWidth_givenCOSDictionarySetFloatDoesNothing_when05_thenCallsSetFloat() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    doNothing().when(dict).setFloat(Mockito.<COSName>any(), anyFloat());
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary(dict);

    // Act
    pdBorderStyleDictionary.setWidth(0.5f);

    // Assert that nothing has changed
    verify(dict).setFloat(isA(COSName.class), eq(0.5f));
    assertEquals(0.0f, pdBorderStyleDictionary.getWidth());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setWidth(float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)}
   * does nothing.</li>
   *   <li>When ten.</li>
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setWidth(float)}
   */
  @Test
  @DisplayName("Test setWidth(float); given COSDictionary setInt(COSName, int) does nothing; when ten; then calls setInt(COSName, int)")
  void testSetWidth_givenCOSDictionarySetIntDoesNothing_whenTen_thenCallsSetInt() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    doNothing().when(dict).setInt(Mockito.<COSName>any(), anyInt());
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary(dict);

    // Act
    pdBorderStyleDictionary.setWidth(10.0f);

    // Assert that nothing has changed
    verify(dict).setInt(isA(COSName.class), eq(10));
    assertEquals(0.0f, pdBorderStyleDictionary.getWidth());
  }

  /**
   * Test {@link PDBorderStyleDictionary#getWidth()}.
   * <ul>
   *   <li>Given
   * {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)} with
   * dict is {@link COSStream#COSStream()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given PDBorderStyleDictionary(COSDictionary) with dict is COSStream(); then return one")
  void testGetWidth_givenPDBorderStyleDictionaryWithDictIsCOSStream_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDBorderStyleDictionary(new COSStream())).getWidth());
  }

  /**
   * Test {@link PDBorderStyleDictionary#getWidth()}.
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given PDBorderStyleDictionary(); then return one")
  void testGetWidth_givenPDBorderStyleDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDBorderStyleDictionary()).getWidth());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setStyle(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>When {@code foo}.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setStyle(String)}
   */
  @Test
  @DisplayName("Test setStyle(String); given COSDictionary setName(COSName, String) does nothing; when 'foo'; then calls setName(COSName, String)")
  void testSetStyle_givenCOSDictionarySetNameDoesNothing_whenFoo_thenCallsSetName() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    doNothing().when(dict).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDBorderStyleDictionary(dict)).setStyle("foo");

    // Assert that nothing has changed
    verify(dict).setName(isA(COSName.class), eq("foo"));
  }

  /**
   * Test {@link PDBorderStyleDictionary#getStyle()}.
   * <ul>
   *   <li>Given
   * {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)} with
   * dict is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDBorderStyleDictionary(COSDictionary) with dict is COSStream()")
  void testGetStyle_givenPDBorderStyleDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(PDBorderStyleDictionary.STYLE_SOLID, (new PDBorderStyleDictionary(new COSStream())).getStyle());
  }

  /**
   * Test {@link PDBorderStyleDictionary#getStyle()}.
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.</li>
   *   <li>Then return {@link PDBorderStyleDictionary#STYLE_SOLID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDBorderStyleDictionary(); then return STYLE_SOLID")
  void testGetStyle_givenPDBorderStyleDictionary_thenReturnStyle_solid() {
    // Arrange, Act and Assert
    assertEquals(PDBorderStyleDictionary.STYLE_SOLID, (new PDBorderStyleDictionary()).getStyle());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName("Test setDashStyle(COSArray)")
  void testSetDashStyle() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Act
    pdBorderStyleDictionary.setDashStyle(null);

    // Assert
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(1, ((COSArray) getResult).toList().size());
    assertEquals(1, dashStyle.getDashArray().length);
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName("Test setDashStyle(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetDashStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    COSArray dashArray = new COSArray();
    dashArray.setKey(new COSObjectKey(1L, 1));
    dashArray.setDirect(false);

    // Act
    pdBorderStyleDictionary.setDashStyle(dashArray);

    // Assert
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getDashArray().length);
    assertTrue(((COSArray) getResult).toList().isEmpty());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link COSArray#COSArray()} Direct is {@code false}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName("Test setDashStyle(COSArray); given 'false'; when COSArray() Direct is 'false'; then array length is zero")
  void testSetDashStyle_givenFalse_whenCOSArrayDirectIsFalse_thenArrayLengthIsZero() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    COSArray dashArray = new COSArray();
    dashArray.setDirect(false);

    // Act
    pdBorderStyleDictionary.setDashStyle(dashArray);

    // Assert
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getDashArray().length);
    assertTrue(((COSArray) getResult).toList().isEmpty());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.</li>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName("Test setDashStyle(COSArray); given PDBorderStyleDictionary(); when COSArray(); then array length is zero")
  void testSetDashStyle_givenPDBorderStyleDictionary_whenCOSArray_thenArrayLengthIsZero() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Act
    pdBorderStyleDictionary.setDashStyle(new COSArray());

    // Assert
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getDashArray().length);
    assertTrue(((COSArray) getResult).toList().isEmpty());
  }

  /**
   * Test {@link PDBorderStyleDictionary#getDashStyle()}.
   * <ul>
   *   <li>Given
   * {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)} with
   * dict is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#getDashStyle()}
   */
  @Test
  @DisplayName("Test getDashStyle(); given PDBorderStyleDictionary(COSDictionary) with dict is COSStream()")
  void testGetDashStyle_givenPDBorderStyleDictionaryWithDictIsCOSStream() {
    // Arrange and Act
    PDLineDashPattern actualDashStyle = (new PDBorderStyleDictionary(new COSStream())).getDashStyle();

    // Assert
    COSBase cOSObject = actualDashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0, actualDashStyle.getPhase());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertTrue(((COSInteger) getResult3).isValid());
    assertArrayEquals(new float[]{3.0f}, actualDashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBorderStyleDictionary#getDashStyle()}.
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.</li>
   *   <li>Then return COSObject toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderStyleDictionary#getDashStyle()}
   */
  @Test
  @DisplayName("Test getDashStyle(); given PDBorderStyleDictionary(); then return COSObject toList size is two")
  void testGetDashStyle_givenPDBorderStyleDictionary_thenReturnCOSObjectToListSizeIsTwo() {
    // Arrange and Act
    PDLineDashPattern actualDashStyle = (new PDBorderStyleDictionary()).getDashStyle();

    // Assert
    COSBase cOSObject = actualDashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0, actualDashStyle.getPhase());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertTrue(((COSInteger) getResult3).isValid());
    assertArrayEquals(new float[]{3.0f}, actualDashStyle.getDashArray(), 0.0f);
  }
}
