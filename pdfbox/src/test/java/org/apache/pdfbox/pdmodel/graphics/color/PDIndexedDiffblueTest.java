package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.MissingResourceException;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDIndexedDiffblueTest {
  /**
   * Test {@link PDIndexed#PDIndexed()}.
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed()}
   */
  @Test
  @DisplayName("Test new PDIndexed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>()"})
  void testNewPDIndexed() {
    // Arrange and Act
    PDIndexed actualPdIndexed = new PDIndexed();

    // Assert
    COSBase cOSObject = actualPdIndexed.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSInteger);
    assertTrue(toListResult.get(0) instanceof COSName);
    assertTrue(toListResult.get(1) instanceof COSName);
    assertTrue(toListResult.get(3) instanceof COSNull);
    assertEquals("Indexed", actualPdIndexed.getName());
    PDColor initialColor = actualPdIndexed.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(actualPdIndexed.getBaseColorSpace());
    assertEquals(1, actualPdIndexed.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualPdIndexed, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSName#A}.
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given A; when COSArray get(int) return A; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenA_whenCOSArrayGetReturnA_thenThrowMissingResourceException()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSName.A);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(MissingResourceException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSName#A}.
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given A; when COSArray get(int) return A; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenA_whenCOSArrayGetReturnA_thenThrowMissingResourceException2()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSName.A);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(
        MissingResourceException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given COSArray(); when COSArray get(int) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenCOSArray_whenCOSArrayGetReturnCOSArray() throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(new COSArray());
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given COSArray(); when COSArray get(int) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenCOSArray_whenCOSArrayGetReturnCOSArray2() throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(new COSArray());
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given COSDictionary(); when COSArray get(int) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenCOSDictionary_whenCOSArrayGetReturnCOSDictionary() throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(new COSDictionary());
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given COSDictionary(); when COSArray get(int) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenCOSDictionary_whenCOSArrayGetReturnCOSDictionary2()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(new COSDictionary());
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(indexedArray.get(anyInt())).thenReturn(cosObject);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey2()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(indexedArray.get(anyInt())).thenReturn(cosObject);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given COSStream(); when COSArray get(int) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenCOSStream_whenCOSArrayGetReturnCOSStream() throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(new COSStream());
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given COSStream(); when COSArray get(int) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenCOSStream_whenCOSArrayGetReturnCOSStream2() throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(new COSStream());
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given FALSE; when COSArray get(int) return FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenFalse_whenCOSArrayGetReturnFalse_thenThrowIOException()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given FALSE; when COSArray get(int) return FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenFalse_whenCOSArrayGetReturnFalse_thenThrowIOException2()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSFloat#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given ONE; when COSArray get(int) return ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenOne_whenCOSArrayGetReturnOne_thenThrowIOException()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSFloat.ONE);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray); given ONE; when COSArray get(int) return ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray)"})
  void testNewPDIndexed_givenOne_whenCOSArrayGetReturnOne_thenThrowIOException2()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSInteger.ONE);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSFloat#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given ONE; when COSArray get(int) return ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenOne_whenCOSArrayGetReturnOne_thenThrowIOException3()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSFloat.ONE);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSArray} {@link COSArray#get(int)} return {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDIndexed#PDIndexed(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDIndexed(COSArray, PDResources); given ONE; when COSArray get(int) return ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.<init>(COSArray, PDResources)"})
  void testNewPDIndexed_givenOne_whenCOSArrayGetReturnOne_thenThrowIOException4()
      throws IOException {
    // Arrange
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(COSInteger.ONE);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDIndexed(indexedArray, new PDResources()));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(1);
  }

  /**
   * Test {@link PDIndexed#getName()}.
   *
   * <p>Method under test: {@link PDIndexed#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDIndexed.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Indexed", new PDIndexed().getName());
  }

  /**
   * Test {@link PDIndexed#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDIndexed#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDIndexed.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {0.0f, 1.0f}, new PDIndexed().getDefaultDecode(1), 0.0f);
  }

  /**
   * Test {@link PDIndexed#toRGB(float[])}.
   *
   * <p>Method under test: {@link PDIndexed#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDIndexed.toRGB(float[])"})
  void testToRGB() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDIndexed().toRGB(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDIndexed#toRawImage(WritableRaster)} with {@code raster}.
   *
   * <p>Method under test: {@link PDIndexed#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDIndexed.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() {
    // Arrange, Act and Assert
    assertNull(new PDIndexed().toRawImage(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDIndexed#getBaseColorSpace()}
   *   <li>{@link PDIndexed#getInitialColor()}
   *   <li>{@link PDIndexed#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDColorSpace PDIndexed.getBaseColorSpace()",
    "PDColor PDIndexed.getInitialColor()",
    "int PDIndexed.getNumberOfComponents()",
    "java.lang.String PDIndexed.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDIndexed pdIndexed = new PDIndexed();

    // Act
    PDColorSpace actualBaseColorSpace = pdIndexed.getBaseColorSpace();
    PDColor actualInitialColor = pdIndexed.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertNull(actualBaseColorSpace);
    assertEquals(1, pdIndexed.getNumberOfComponents());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdIndexed, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDIndexed#setBaseColorSpace(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDIndexed#setBaseColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setBaseColorSpace(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDIndexed.setBaseColorSpace(PDColorSpace)"})
  void testSetBaseColorSpace() {
    // Arrange
    PDIndexed pdIndexed = new PDIndexed();

    // Act
    pdIndexed.setBaseColorSpace(PDDeviceGray.INSTANCE);

    // Assert
    COSBase cOSObject = pdIndexed.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(4, ((COSArray) cOSObject).toList().size());
    assertSame(PDDeviceGray.INSTANCE, pdIndexed.getBaseColorSpace());
  }
}
