package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOptionalContentMembershipDictionaryDiffblueTest {
  /**
   * Test {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.<init>()"})
  void testNewPDOptionalContentMembershipDictionary() {
    // Arrange and Act
    PDOptionalContentMembershipDictionary actualPdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    // Assert
    COSName visibilityPolicy = actualPdOptionalContentMembershipDictionary.getVisibilityPolicy();
    assertEquals("AnyOn", visibilityPolicy.getName());
    COSDictionary cOSObject = actualPdOptionalContentMembershipDictionary.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(visibilityPolicy.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(visibilityPolicy.isDirect());
    assertFalse(visibilityPolicy.isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(actualPdOptionalContentMembershipDictionary.getOCGs().isEmpty());
  }

  /**
   * Test {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.<init>(COSDictionary)"})
  void testNewPDOptionalContentMembershipDictionary_givenA() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.<init>(COSDictionary)"})
  void testNewPDOptionalContentMembershipDictionary_givenFalse() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.<init>(COSDictionary)"})
  void testNewPDOptionalContentMembershipDictionary_givenOne() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.<init>(COSDictionary)"})
  void testNewPDOptionalContentMembershipDictionary_givenOne2() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDOptionalContentMembershipDictionary(COSDictionary); given parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.<init>(COSDictionary)"})
  void testNewPDOptionalContentMembershipDictionary_givenParseHex0123456789abcdef()
      throws IOException {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getOCGs()}.
   *
   * <ul>
   *   <li>Given {@link
   *       PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#getOCGs()}
   */
  @Test
  @DisplayName("Test getOCGs(); given PDOptionalContentMembershipDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDOptionalContentMembershipDictionary.getOCGs()"})
  void testGetOCGs_givenPDOptionalContentMembershipDictionary() {
    // Arrange, Act and Assert
    assertTrue(new PDOptionalContentMembershipDictionary().getOCGs().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getOCGs()}.
   *
   * <ul>
   *   <li>Given {@link
   *       PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()} OCGs is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#getOCGs()}
   */
  @Test
  @DisplayName("Test getOCGs(); given PDOptionalContentMembershipDictionary() OCGs is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDOptionalContentMembershipDictionary.getOCGs()"})
  void testGetOCGs_givenPDOptionalContentMembershipDictionaryOCGsIsArrayList() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();
    pdOptionalContentMembershipDictionary.setOCGs(new ArrayList<>());

    // Act and Assert
    assertTrue(pdOptionalContentMembershipDictionary.getOCGs().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setOCGs(List)"})
  void testSetOCGs() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    PDPropertyList pdPropertyList = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(pdPropertyList.getCOSObject()).thenReturn(cosDictionary);

    ArrayList<PDPropertyList> ocgs = new ArrayList<>();
    ocgs.add(pdPropertyList);

    // Act
    pdOptionalContentMembershipDictionary.setOCGs(ocgs);

    // Assert
    verify(pdPropertyList).getCOSObject();
    List<PDPropertyList> oCGs = pdOptionalContentMembershipDictionary.getOCGs();
    assertEquals(1, oCGs.size());
    assertSame(cosDictionary, oCGs.get(0).getCOSObject());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setOCGs(List)"})
  void testSetOCGs2() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosDictionary.setKey(key);

    PDPropertyList pdPropertyList = mock(PDPropertyList.class);
    when(pdPropertyList.getCOSObject()).thenReturn(cosDictionary);

    ArrayList<PDPropertyList> ocgs = new ArrayList<>();
    ocgs.add(pdPropertyList);

    // Act
    pdOptionalContentMembershipDictionary.setOCGs(ocgs);

    // Assert
    verify(pdPropertyList).getCOSObject();
    List<PDPropertyList> oCGs = pdOptionalContentMembershipDictionary.getOCGs();
    assertEquals(1, oCGs.size());
    assertSame(key, oCGs.get(0).getCOSObject().getKey());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List); given COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setOCGs(List)"})
  void testSetOCGs_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);

    PDPropertyList pdPropertyList = mock(PDPropertyList.class);
    when(pdPropertyList.getCOSObject()).thenReturn(cosDictionary);

    ArrayList<PDPropertyList> ocgs = new ArrayList<>();
    ocgs.add(pdPropertyList);

    // Act
    pdOptionalContentMembershipDictionary.setOCGs(ocgs);

    // Assert
    verify(pdPropertyList).getCOSObject();
    List<PDPropertyList> oCGs = pdOptionalContentMembershipDictionary.getOCGs();
    assertEquals(1, oCGs.size());
    assertSame(cosDictionary, oCGs.get(0).getCOSObject());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setOCGs(List)"})
  void testSetOCGs_givenNull_whenArrayListAddNull() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    ArrayList<PDPropertyList> ocgs = new ArrayList<>();
    ocgs.add(null);

    // Act
    pdOptionalContentMembershipDictionary.setOCGs(ocgs);

    // Assert
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdOptionalContentMembershipDictionary.getOCGs().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setOCGs(List)"})
  void testSetOCGs_thenThrowIllegalArgumentException() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    PDPropertyList pdPropertyList = mock(PDPropertyList.class);
    when(pdPropertyList.getCOSObject()).thenThrow(new IllegalArgumentException());

    ArrayList<PDPropertyList> ocgs = new ArrayList<>();
    ocgs.add(pdPropertyList);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdOptionalContentMembershipDictionary.setOCGs(ocgs));
    verify(pdPropertyList).getCOSObject();
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setOCGs(List)"})
  void testSetOCGs_whenArrayList() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    // Act
    pdOptionalContentMembershipDictionary.setOCGs(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdOptionalContentMembershipDictionary.getOCGs().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}.
   *
   * <ul>
   *   <li>Then return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}
   */
  @Test
  @DisplayName("Test getVisibilityPolicy(); then return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDOptionalContentMembershipDictionary.getVisibilityPolicy()"})
  void testGetVisibilityPolicy_thenReturnA() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();
    pdOptionalContentMembershipDictionary.setVisibilityPolicy(COSName.A);

    // Act and Assert
    assertSame(COSName.A, pdOptionalContentMembershipDictionary.getVisibilityPolicy());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}.
   *
   * <ul>
   *   <li>Then return {@link COSName#ANY_ON}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}
   */
  @Test
  @DisplayName("Test getVisibilityPolicy(); then return ANY_ON")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDOptionalContentMembershipDictionary.getVisibilityPolicy()"})
  void testGetVisibilityPolicy_thenReturnAny_on() {
    // Arrange, Act and Assert
    assertSame(COSName.ANY_ON, new PDOptionalContentMembershipDictionary().getVisibilityPolicy());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}.
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}
   */
  @Test
  @DisplayName("Test setVisibilityPolicy(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setVisibilityPolicy(COSName)"})
  void testSetVisibilityPolicy() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    // Act
    pdOptionalContentMembershipDictionary.setVisibilityPolicy(COSName.A);

    // Assert
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(COSName.A, pdOptionalContentMembershipDictionary.getVisibilityPolicy());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}.
   *
   * <p>Method under test: {@link
   * PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}
   */
  @Test
  @DisplayName("Test setVisibilityPolicy(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentMembershipDictionary.setVisibilityPolicy(COSName)"})
  void testSetVisibilityPolicy2() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary =
        new PDOptionalContentMembershipDictionary();

    // Act
    pdOptionalContentMembershipDictionary.setVisibilityPolicy(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
