package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDefaultAppearanceStringDiffblueTest {
  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(new COSDictionary());
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo2() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenThrow(new IllegalArgumentException(
        "Using the subsetted font '{}' without a PDDocument context; call subset() before saving"));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo3() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(null);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo4() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo5() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo6() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo7() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(false);
    when(font.isEmbedded()).thenReturn(true);

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).isEmbedded();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo8() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(properties).getCOSObject();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo9() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary2).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(properties).getCOSObject();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo10() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  void testWriteTo11() throws IOException {
    // Arrange
    PDPropertyList properties = mock(PDPropertyList.class);
    when(properties.getCOSObject()).thenReturn(new COSDictionary());

    PDResources defaultResources = new PDResources();
    defaultResources.add(properties);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(
        COSString.parseHex("0123456789ABCDEF"), defaultResources);
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenThrow(new IllegalArgumentException(
        "Using the subsetted font '{}' without a PDDocument context; call subset() before saving"));
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f));
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(properties).getCOSObject();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  void testCopyNeededResourcesTo() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    COSStream stream = new COSStream();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(stream);

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = resources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertNull(pdDefaultAppearanceString.getFont());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((Set<COSName>) fontNames).isEmpty());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  void testCopyNeededResourcesTo2() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    COSStream stream = new COSStream();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(stream);

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = resources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertNull(pdDefaultAppearanceString.getFont());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((Set<COSName>) fontNames).isEmpty());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  void testCopyNeededResourcesTo3() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = new COSStream();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(stream);

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = resources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(font, pdDefaultAppearanceString.getFont());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  void testCopyNeededResourcesTo4() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setDirect(true);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = new COSStream();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(stream);

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = resources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(font, pdDefaultAppearanceString.getFont());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  void testCopyNeededResourcesTo5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(5L, 5));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = new COSStream();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(stream);

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = resources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(font, pdDefaultAppearanceString.getFont());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  void testCopyNeededResourcesTo6() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(5L, 5));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = new COSStream();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(stream);

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = resources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(font, pdDefaultAppearanceString.getFont());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDefaultAppearanceString#setFont(PDFont)}
   *   <li>{@link PDDefaultAppearanceString#setFontColor(PDColor)}
   *   <li>{@link PDDefaultAppearanceString#setFontName(COSName)}
   *   <li>{@link PDDefaultAppearanceString#setFontSize(float)}
   *   <li>{@link PDDefaultAppearanceString#getFont()}
   *   <li>{@link PDDefaultAppearanceString#getFontColor()}
   *   <li>{@link PDDefaultAppearanceString#getFontName()}
   *   <li>{@link PDDefaultAppearanceString#getFontSize()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());

    // Act
    pdDefaultAppearanceString.setFont(font);
    PDColor fontColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    pdDefaultAppearanceString.setFontColor(fontColor);
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFontSize(10.0f);
    PDFont actualFont = pdDefaultAppearanceString.getFont();
    PDColor actualFontColor = pdDefaultAppearanceString.getFontColor();
    COSName actualFontName = pdDefaultAppearanceString.getFontName();

    // Assert that nothing has changed
    assertEquals(10.0f, pdDefaultAppearanceString.getFontSize());
    assertSame(font, actualFont);
    assertSame(fontColor, actualFontColor);
    assertSame(actualFontName.A, actualFontName);
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDDefaultAppearanceString(null, null));

  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDDefaultAppearanceString(COSString.parseHex("0123456789ABCDEF"), null));

  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString4() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("42");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString5() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("ID");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString6() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("/");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString7() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("org.apache.pdfbox.cos.COSString");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Method under test:
   * {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  void testNewPDDefaultAppearanceString8() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("42");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }
}
