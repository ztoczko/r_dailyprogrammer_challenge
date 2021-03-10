package com.reddit.r_dailyprogrammer_challenge;

public class Ch375 {

    public static void main(String[] args) {

        System.out.println(checkStructuralBalance(getRelations()));

    }

    public static String[] getPlayers() {
        String[] result = {"Daenerys Targaryen",        //0
                "Jon Snow",                             //1
                " Tyrion Lannister",                    //2
                "Varys",                                //3
                "Jorah Mormont",                        //4
                "Beric Dondarrion",                     //5
                "Sandor \"the Hound\"Clegane",          //6
                "Theon and Yara Greyjoy",               //7
                "Sansa Stark",                          //8
                "Arya Stark",                           //9
                "Bran Stark",                           //10
                "The Lords of the North and the Vale",  //11
                "Littlefinger",                         //12
                "Cersei Lannister",                     //13
                "Jaime Lannister",                      //14
                "Euron Greyjoy"};                       //15
        return result;
    }

    public static byte[][] getRelations() {

        byte[][] result = {
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Daenerys Targaryen
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//Jon Snow
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Tyrion Lannister
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Varys
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Jorah Mormont
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Beric Dondarrion
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Sandor “the Hound” Clegane
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Theon and Yara Greyjoy
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},//Sansa Stark
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},//Arya Stark
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},//Bran Stark
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},//The Lords of the North and the Vale
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},//Littlefinger
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},//Cersei Lannister
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},//Jaime Lannister
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}}; //Euron Greyjoy
        return result;
    }

    public static boolean checkStructuralBalance(byte[][] relations) {

        for (int i = 0; i < relations.length; i++){
            for (int j = i +1; j < relations.length; j++){
                for (int k = j + 1; k < relations.length; k++){
                    if (relations[i][j] + relations[i][k] + relations[j][k] != 3 && relations[i][j] + relations[i][k] + relations[j][k] != 1){
                        System.out.println(i + " " + j + " " + k);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

