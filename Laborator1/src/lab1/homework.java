package lab1;

import java.util.ArrayList;

public class homework {

    //build a random word from an alphabet
    static String getRandomString(String[] alphabet, int n){
        StringBuilder randomWord = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)((alphabet.length - 1) * Math.random());
            randomWord.append(alphabet[index]);
        }

        return randomWord.toString();
    }

    //verify if the words have a letter in common
    static Boolean commonLetter(String firstString, String secondString){
        for(int i = 0; i < firstString.length(); i++)
            for(int j = 0; j < secondString.length(); j++)
                if(firstString.charAt(i) == secondString.charAt(j))
                    return true;
        return false;
    }


    public static void main(String[] args){
        long startTime = System.nanoTime();
        //validate the arguments
        if(args.length < 3)
            System.out.println("Numar invalid de argumente");
        else{
            //get the arguments
            int n = Integer.parseInt(args[0], 10);
            int p = Integer.parseInt(args[1], 10);

            String[] alphabet = new String[args.length - 2];
            int cnt = 0;

            for(int i = 2; i < args.length; i++)
                alphabet[cnt++] = args[i];

            String[] words = new String[n];

            //create an array of random words generated from the alphabet
            cnt = 0;
            while(cnt < n){
                words[cnt] = getRandomString(alphabet, p);
                cnt ++;
            }

            //print the words
            for(int i = 0; i < words.length; i++)
                System.out.println(words[i]);

            //create a boolean matrix
            Boolean[][] adjacency = new Boolean[n][n];

            //data structure to store the neighbors of each word
            ArrayList<ArrayList<String>> neighbors = new ArrayList<>();

            //add data in matrix and array
           for(int i = 0; i < n; i++) {
                ArrayList<String> aux = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if(i != j){
                        adjacency[i][j] = commonLetter(words[i], words[j]);
                        if (adjacency[i][j]) {
                            aux.add(words[j]);
                        }
                    }
                    else
                        adjacency[i][j] = false;
                }
                neighbors.add(aux);
            }

            //print the adjacency matrix
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++)
//                    System.out.print(adjacency[i][j] + " ");
//                System.out.print("\n");
//            }

            if(n < 30000) {
                //print the neighbors of each word
                for (int i = 0; i < neighbors.size(); i++) {
                    for (int j = 0; j < neighbors.get(i).size(); j++)
                        System.out.print(neighbors.get(i).get(j) + " ");
                    System.out.print('\n');
                }
            }
            else{
                long finalTime = System.nanoTime();

                //if n >= 30000 print the running time of the app
                System.out.println("Timpul de executie este " + (finalTime - startTime));
            }

        }
    }
}
