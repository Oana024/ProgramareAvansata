package lab1;

import java.util.ArrayList;

public class bonus {

    Boolean found;

    //build a random word from an alphabet
    String getRandomString(String[] alphabet, int n){
        StringBuilder randomWord = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)((alphabet.length - 1) * Math.random());
            randomWord.append(alphabet[index]);
        }

        return randomWord.toString();
    }

    //verify if the words have a letter in common
    Boolean commonLetter(String firstString, String secondString){
        for(int i = 0; i < firstString.length(); i++)
            for(int j = 0; j < secondString.length(); j++)
                if(firstString.charAt(i) == secondString.charAt(j))
                    return true;
        return false;
    }

    void dfs(int nodStart, int nod, Boolean[] visited, Boolean[][] adjacency, ArrayList<String> solution, String[] words){
        visited[nod] = true;
        solution.add(words[nod]);
        if(adjacency[nodStart][nod] && solution.size() >= 3 && !found){
            System.out.println("Subset: ");
            for(int i = 0; i < solution.size(); i++)
                System.out.print(solution.get(i) + " ");
            found = true;
        }
        else{
            for(int i = 0; i < words.length; i++)
                if(adjacency[nod][i] && !visited[i])
                    dfs(nodStart, i, visited, adjacency, solution, words);
        }
    }

    public static void main(String[] args){
        bonus Bonus = new bonus();

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
                words[cnt] = Bonus.getRandomString(alphabet, p);
                cnt ++;
            }

            //print the words
            for(int i = 0; i < words.length; i++)
                System.out.println(words[i]);

            //create a boolean matrix
            Boolean[][] adjacency = new Boolean[n][n];

            //add data in matrix and array
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i != j){
                        adjacency[i][j] = Bonus.commonLetter(words[i], words[j]);
                    }
                    else
                        adjacency[i][j] = false;
                }
            }

            //print the adjacency matrix
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    System.out.print(adjacency[i][j] + " ");
                System.out.print("\n");
            }

            Boolean[] visited = new Boolean[n];
            for(int i = 0; i < n; i++)
                visited[i] = false;

            ArrayList<String> solution = new ArrayList<>();

            Bonus.found = false;

            for(int i = 0; i < n; i++){
                if(!Bonus.found)
                    Bonus.dfs(0, 0, visited, adjacency, solution, words);
            }
        }
    }
}
