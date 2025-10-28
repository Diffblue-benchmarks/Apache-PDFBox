package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppearanceGeneratorHelperDiffblueTest {
  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(new ArrayList<>());
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue2() throws IOException {
    // Arrange
    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(new PDAnnotationWidget());
    PDVariableText field = mock(PDVariableText.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue3() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue4() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue6() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalArgumentException("PMD"));
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary).getInt(isA(COSName.class), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  void testSetAppearanceValue7() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getQ()).thenReturn(5);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("42");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Annot");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Widget");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("name");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("log4j2.messageFactory");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("log4j2.flowMessageFactory");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("Da Value");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("java.util.Set");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("ID");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("BI");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("/");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper13() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance("null");
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper14() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance(Boolean.TRUE.toString());
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  void testNewAppearanceGeneratorHelper15() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDAcroForm acroForm = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    acroForm.setDefaultAppearance(Boolean.FALSE.toString());
    acroForm.setDefaultResources(new PDResources());

    PDComboBox field = new PDComboBox(acroForm);
    field.importFDF(new FDFField());

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
