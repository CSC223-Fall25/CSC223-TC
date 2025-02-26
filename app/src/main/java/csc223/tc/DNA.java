/*
 * DNA Lab Assignment
 */
package csc223.tc;
public class DNA {
    public static String countNucleotides(String dna){
        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;
        for (int i = 0; i <dna.length(); i++){
            if (dna.charAt(i) == 'A'){
                A += 1;
            } 
            else if (dna.charAt(i) == 'C'){
                C += 1;
            } 
            else if (dna.charAt(i) == 'G'){
                G += 1;
            } 
            else if (dna.charAt(i) == 'T'){
                T += 1;
            }
        }
        return  A + " " + C + " " + G + " " + T;
        
    }



    public static String transcribe(String dna){

        String dnastring = "";

        for (int i = 0; i <dna.length(); i++){
            if (dna.charAt(i) != 'T'){
                dnastring += dna.charAt(i);
            } 
            else if (dna.charAt(i) == 'T'){
                dnastring += 'U';
            }
        }
        return dnastring;
    }

    public static String reverseComplement(String dna){

        String complementString = "";

        for (int i = dna.length()-1; i > -1; i--){
            if (dna.charAt(i) == 'A'){
                complementString += 'C';
            } 
            else if (dna.charAt(i) == 'C'){
                complementString += 'A';
            } 
            else if (dna.charAt(i) == 'G'){
                complementString += 'T';
            } 
            else if (dna.charAt(i) == 'T'){
                complementString += 'G';
            }
        }
        return complementString;
    }

    public static void main(String[] args){
        String test = DNA.countNucleotides("AAACCCGGTTTT");
        System.out.println(test);

        String test2 = DNA.transcribe("AAACCCGGTTTT");
        System.out.println(test2);

        String test3 = DNA.reverseComplement("AAACCCGGTTTT");
        System.out.println(test3);
    }

}