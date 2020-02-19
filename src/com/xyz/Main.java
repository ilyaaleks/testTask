package com.xyz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args==null)
        {
            return;
        }
        else if(args[0].charAt(0)=='-'){
            File file=new File(args[1]);
            if(!file.exists())
                return;
            for(char c:args[0].toCharArray())
            {
                switch(c)
                {
                    case 'm':{
                        Utils.getCountOfSymbols(file);
                    }break;
                    case 'w':{
                        Utils.getCountOfWords(file);
                    }break;
                    case 'X':{
                        Utils.getListOfTopOccurrences(file);
                    }break;
                }
            }
        }
        else {
            File file=new File(args[0]);
            if(!file.exists())
            {
                return;
            }
            Utils.getCountOfWords(file);
            Utils.getCountOfSymbols(file);
        }

    }
}

