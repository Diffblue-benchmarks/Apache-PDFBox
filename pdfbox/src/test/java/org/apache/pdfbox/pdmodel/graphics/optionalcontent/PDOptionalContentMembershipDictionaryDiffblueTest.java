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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOptionalContentMembershipDictionaryDiffblueTest {
  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary()")
  void testNewPDOptionalContentMembershipDictionary() {
    // Arrange and Act
    PDOptionalContentMembershipDictionary actualPdOptionalContentMembershipDictionary = new PDOptionalContentMembershipDictionary();

    // Assert
    COSName visibilityPolicy = actualPdOptionalContentMembershipDictionary.getVisibilityPolicy();
    assertEquals("AnyOn", visibilityPolicy.getName());
    COSDictionary cOSObject = actualPdOptionalContentMembershipDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(visibilityPolicy.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(visibilityPolicy.isDirect());
    assertFalse(visibilityPolicy.isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdOptionalContentMembershipDictionary.getOCGs().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given A")
  void testNewPDOptionalContentMembershipDictionary_givenA() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given FALSE")
  void testNewPDOptionalContentMembershipDictionary_givenFalse() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given ONE")
  void testNewPDOptionalContentMembershipDictionary_givenOne() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given ONE")
  void testNewPDOptionalContentMembershipDictionary_givenOne2() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentMembershipDictionary(COSDictionary); given parseHex '0123456789ABCDEF'")
  void testNewPDOptionalContentMembershipDictionary_givenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentMembershipDictionary(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getOCGs()}.
   * <ul>
   *   <li>Given
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOptionalContentMembershipDictionary#getOCGs()}
   */
  @Test
  @DisplayName("Test getOCGs(); given PDOptionalContentMembershipDictionary()")
  void testGetOCGs_givenPDOptionalContentMembershipDictionary() {
    // Arrange, Act and Assert
    assertTrue((new PDOptionalContentMembershipDictionary()).getOCGs().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getOCGs()}.
   * <ul>
   *   <li>Given
   * {@link PDOptionalContentMembershipDictionary#PDOptionalContentMembershipDictionary()}
   * OCGs is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOptionalContentMembershipDictionary#getOCGs()}
   */
  @Test
  @DisplayName("Test getOCGs(); given PDOptionalContentMembershipDictionary() OCGs is ArrayList()")
  void testGetOCGs_givenPDOptionalContentMembershipDictionaryOCGsIsArrayList() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary = new PDOptionalContentMembershipDictionary();
    pdOptionalContentMembershipDictionary.setOCGs(new ArrayList<>());

    // Act and Assert
    assertTrue(pdOptionalContentMembershipDictionary.getOCGs().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#setOCGs(List)}.
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#setOCGs(List)}
   */
  @Test
  @DisplayName("Test setOCGs(List)")
  void testSetOCGs() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary = new PDOptionalContentMembershipDictionary();

    // Act
    pdOptionalContentMembershipDictionary.setOCGs(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}.
   * <ul>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}
   */
  @Test
  @DisplayName("Test getVisibilityPolicy(); then return A")
  void testGetVisibilityPolicy_thenReturnA() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary = new PDOptionalContentMembershipDictionary();
    pdOptionalContentMembershipDictionary.setVisibilityPolicy(COSName.A);

    // Act
    COSName actualVisibilityPolicy = pdOptionalContentMembershipDictionary.getVisibilityPolicy();

    // Assert
    assertSame(actualVisibilityPolicy.A, actualVisibilityPolicy);
  }

  /**
   * Test {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}.
   * <ul>
   *   <li>Then return {@link COSName#ANY_ON}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#getVisibilityPolicy()}
   */
  @Test
  @DisplayName("Test getVisibilityPolicy(); then return ANY_ON")
  void testGetVisibilityPolicy_thenReturnAny_on() {
    // Arrange and Act
    COSName actualVisibilityPolicy = (new PDOptionalContentMembershipDictionary()).getVisibilityPolicy();

    // Assert
    assertSame(actualVisibilityPolicy.ANY_ON, actualVisibilityPolicy);
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}.
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}
   */
  @Test
  @DisplayName("Test setVisibilityPolicy(COSName)")
  void testSetVisibilityPolicy() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary = new PDOptionalContentMembershipDictionary();
    COSName visibilityPolicy = COSName.A;

    // Act
    pdOptionalContentMembershipDictionary.setVisibilityPolicy(visibilityPolicy);

    // Assert
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSName expectedVisibilityPolicy = visibilityPolicy.A;
    assertSame(expectedVisibilityPolicy, pdOptionalContentMembershipDictionary.getVisibilityPolicy());
  }

  /**
   * Test
   * {@link PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}.
   * <p>
   * Method under test:
   * {@link PDOptionalContentMembershipDictionary#setVisibilityPolicy(COSName)}
   */
  @Test
  @DisplayName("Test setVisibilityPolicy(COSName)")
  void testSetVisibilityPolicy2() {
    // Arrange
    PDOptionalContentMembershipDictionary pdOptionalContentMembershipDictionary = new PDOptionalContentMembershipDictionary();

    // Act
    pdOptionalContentMembershipDictionary.setVisibilityPolicy(null);

    // Assert
    COSDictionary cOSObject = pdOptionalContentMembershipDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
