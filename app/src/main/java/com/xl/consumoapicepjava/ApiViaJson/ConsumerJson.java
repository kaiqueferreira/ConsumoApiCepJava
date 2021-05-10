package com.xl.consumoapicepjava.ApiViaJson;

import com.xl.consumoapicepjava.ApiViaXmL.Model.CEP;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumerJson {

    public static List<CEP> jsonDados(String conteudo) {

        try {
            List<CEP> cepList = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for (int i = 0; i<jsonArray.length(); i++){

                jsonObject = jsonArray.getJSONObject(i);

                CEP cep = new CEP();

                cep.setLogradouro(jsonObject.getString("logradouro"));
                cep.setComplemento(jsonObject.getString("complemento"));
                cep.setBairro(jsonObject.getString("bairro"));
                cep.setLocalidade(jsonObject.getString("localidade"));
                cep.setUf(jsonObject.getString("uf"));
                cep.setIbge(jsonObject.getString("ibge"));
                cep.setGia(jsonObject.getString("gia"));
                cep.setDdd(jsonObject.getString("ddd"));
                cep.setSiafi(jsonObject.getString("siafi"));

                cepList.add(cep);
            }
            return  cepList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
