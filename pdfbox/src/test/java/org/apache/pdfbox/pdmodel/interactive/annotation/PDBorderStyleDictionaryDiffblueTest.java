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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDBorderStyleDictionaryDiffblueTest {
  /**
   * Test {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDBorderStyleDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.<init>(COSDictionary)"})
  void testNewPDBorderStyleDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDBorderStyleDictionary(dict).getCOSObject());
  }

  /**
   * Test {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}
   */
  @Test
  @DisplayName("Test new PDBorderStyleDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.<init>()"})
  void testNewPDBorderStyleDictionary2() {
    // Arrange and Act
    PDBorderStyleDictionary actualPdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Assert
    PDLineDashPattern dashStyle = actualPdBorderStyleDictionary.getDashStyle();
    assertTrue(dashStyle.getCOSObject() instanceof COSArray);
    COSDictionary cOSObject = actualPdBorderStyleDictionary.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1.0f, actualPdBorderStyleDictionary.getWidth());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDBorderStyleDictionary.STYLE_SOLID, actualPdBorderStyleDictionary.getStyle());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBorderStyleDictionary#setWidth(float)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setFloat(COSName, float)} does nothing.
   *   <li>When {@code 0.5}.
   *   <li>Then calls {@link COSDictionary#setFloat(COSName, float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setWidth(float)}
   */
  @Test
  @DisplayName(
      "Test setWidth(float); given COSDictionary setFloat(COSName, float) does nothing; when '0.5'; then calls setFloat(COSName, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setWidth(float)"})
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)} does nothing.
   *   <li>When ten.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setWidth(float)}
   */
  @Test
  @DisplayName(
      "Test setWidth(float); given COSDictionary setInt(COSName, int) does nothing; when ten; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setWidth(float)"})
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
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)} with dict is
   *       {@link COSStream#COSStream()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#getWidth()}
   */
  @Test
  @DisplayName(
      "Test getWidth(); given PDBorderStyleDictionary(COSDictionary) with dict is COSStream(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDBorderStyleDictionary.getWidth()"})
  void testGetWidth_givenPDBorderStyleDictionaryWithDictIsCOSStream_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDBorderStyleDictionary(new COSStream()).getWidth());
  }

  /**
   * Test {@link PDBorderStyleDictionary#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given PDBorderStyleDictionary(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDBorderStyleDictionary.getWidth()"})
  void testGetWidth_givenPDBorderStyleDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDBorderStyleDictionary().getWidth());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setStyle(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setName(COSName, String)} does nothing.
   *   <li>When {@code Style}.
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStyle(String); given COSDictionary setName(COSName, String) does nothing; when 'Style'; then calls setName(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setStyle(String)"})
  void testSetStyle_givenCOSDictionarySetNameDoesNothing_whenStyle_thenCallsSetName() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    doNothing().when(dict).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    new PDBorderStyleDictionary(dict).setStyle("Style");

    // Assert that nothing has changed
    verify(dict).setName(isA(COSName.class), eq("Style"));
  }

  /**
   * Test {@link PDBorderStyleDictionary#getStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)} with dict is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#getStyle()}
   */
  @Test
  @DisplayName(
      "Test getStyle(); given PDBorderStyleDictionary(COSDictionary) with dict is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDBorderStyleDictionary.getStyle()"})
  void testGetStyle_givenPDBorderStyleDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(
        PDBorderStyleDictionary.STYLE_SOLID,
        new PDBorderStyleDictionary(new COSStream()).getStyle());
  }

  /**
   * Test {@link PDBorderStyleDictionary#getStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   *   <li>Then return {@link PDBorderStyleDictionary#STYLE_SOLID}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDBorderStyleDictionary(); then return STYLE_SOLID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDBorderStyleDictionary.getStyle()"})
  void testGetStyle_givenPDBorderStyleDictionary_thenReturnStyle_solid() {
    // Arrange, Act and Assert
    assertEquals(PDBorderStyleDictionary.STYLE_SOLID, new PDBorderStyleDictionary().getStyle());
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName("Test setDashStyle(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setDashStyle(COSArray)"})
  void testSetDashStyle() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Act
    pdBorderStyleDictionary.setDashStyle(null);

    // Assert that nothing has changed
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(1, ((COSArray) getResult).toList().size());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDashStyle(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setDashStyle(COSArray)"})
  void testSetDashStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    COSArray dashArray = new COSArray(new ArrayList<>());
    dashArray.setDirect(false);
    dashArray.setKey(new COSObjectKey(1L, 1));

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
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertArrayEquals(new float[] {}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDashStyle(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setDashStyle(COSArray)"})
  void testSetDashStyle_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    COSArray dashArray = new COSArray(new ArrayList<>());
    dashArray.setDirect(false);
    dashArray.setKey(null);

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
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertArrayEquals(new float[] {}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBorderStyleDictionary#setDashStyle(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  @DisplayName("Test setDashStyle(COSArray); when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderStyleDictionary.setDashStyle(COSArray)"})
  void testSetDashStyle_whenCOSArray() {
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
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertArrayEquals(new float[] {}, dashStyle.getDashArray(), 0.0f);
  }
}
