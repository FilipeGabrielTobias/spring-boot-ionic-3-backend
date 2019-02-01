package com.filipetobias.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filipe.Tobias on 30/07/2018.
 */
public class URL {

    public static String decodeParam(String s){
        try {
            URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
        return s;
    }

    public static List<Integer> decodeIntList(String s) {
        String[] vet = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vet.length; i++){
           list.add(Integer.parseInt(vet[i]));
        }
        return list;
        // utilização de lmabida
        // return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
    }

}
