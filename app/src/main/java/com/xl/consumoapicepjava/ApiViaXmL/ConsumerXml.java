package com.xl.consumoapicepjava.ApiViaXmL;

import com.xl.consumoapicepjava.ApiViaXmL.Model.CEP;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class ConsumerXml {

    public static List<CEP> xmlDados(String conteudo) {


        try {

            boolean dadosNaTag = false;
            String tagAtual = "";
            CEP cep = null;
            List<CEP> cepList = new ArrayList<>();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();

            xmlPullParser.setInput(new StringReader(conteudo));

            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_TAG: //Init tag
                        tagAtual = xmlPullParser.getName();
                        /* In this case endereco is the start tag contains data <endereco/> data in here <endereco/>
                         *<endereco>
                         *<cep>01001-000</cep>
                         * <logradouro>Praça da Sé</logradouro>
                         *<complemento>lado ímpar</complemento>
                         *<bairro>Sé</bairro>
                         * <localidade>São Paulo</localidade>
                         *<uf>SP</uf>
                         * <ibge>3550308</ibge>
                         * <gia>1004</gia>
                         * <ddd>11</ddd>
                         * <siafi>7107</siafi>
                         * </endereco>
                         */
                        if (tagAtual.endsWith("xmlcep")) {
                            dadosNaTag = true;
                            cep = new CEP();
                            cepList.add(cep);

                        }
                        break;
                    case XmlPullParser.END_TAG: // End tag
                        if (xmlPullParser.getName().equals("xmlcep")) {
                            dadosNaTag = false;
                        }
                        tagAtual = "";
                        break;

                    case XmlPullParser.TEXT:
                        if (dadosNaTag && cep != null){
                            switch (tagAtual){
                                case "cep":
                                    cep.setCep(xmlPullParser.getText());
                                    break;
                                case "logradouro":
                                    cep.setLogradouro(xmlPullParser.getText());
                                    break;
                                case "complemento":
                                    cep.setComplemento(xmlPullParser.getText());
                                    break;
                                case "bairro":
                                    cep.setBairro(xmlPullParser.getText());
                                    break;
                                case "localidade":
                                    cep.setLocalidade(xmlPullParser.getText());
                                    break;
                                case "uf":
                                    cep.setUf(xmlPullParser.getText());
                                    break;
                                case "ibge":
                                    cep.setIbge(xmlPullParser.getText());
                                    break;
                                case "gia":
                                    cep.setGia(xmlPullParser.getText());
                                    break;
                                case "ddd":
                                    cep.setDdd(xmlPullParser.getText());
                                    break;
                                case "siafi":
                                    cep.setSiafi(xmlPullParser.getText());
                                    break;

                            }
                        }
                        break;

                }
                eventType = xmlPullParser.next(); // To next Tag <endereco> data in here <endereco/>
            }

            return cepList; // Return cep list


        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
