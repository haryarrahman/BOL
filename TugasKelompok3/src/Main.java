import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Integer> scores = new ArrayList<Integer>(Arrays.asList(0,0,0));
        List<String> lastAnswer = new ArrayList<String>();  
        List<String> dictLevel1 = Arrays.asList(
            "sachet", "scathe", "chase", "cheat", "chest", "teach", "haste", "ache",
            "cash", "chat", "each", "tach", "tech", "hate", "heat", "eth", "has", "hat" ,
            "she", "the", "ace", "act", "cat", "ate", "eat", "est"
        );      
        List<String> dictLevel2 = Arrays.asList(
            "ration", "intro", "nitro", "ratio", "train", "anti", "into", "iron", 
            "noir", "nori", "rain", "riot", "air", "ant", "art", "ion", "not", "oar", 
            "oat", "ran", "rat", "rot"
        );                
        List<String> dictLevel3 = Arrays.asList(
            "drake", "ready", "yerk", "dark", "yard", "year", "dare", "dear", 
            "read", "key", "yak", "ark", "day", "dry", "dye", "ray", "red"            
        );

        System.out.println(
                "Coepoe Word Puzzle\n"
                + "==================\n\n"
                + "Rules :\n"
                + "1. Create a word using given characters, min 3 characters & max 6 characters.\n"
                + "2. Each level, You have 10 chances to answer correctly.\n"
                + "3. To get through to next level, you have to score 70 points each level\n"
        );

        // quiz lvl 1
        quizFormatter(1, dictLevel1, lastAnswer, scores);

        // quiz lvl 2
        if (scores.get(0) >= 70) quizFormatter(2, dictLevel2, lastAnswer, scores);

        // quiz lvl 3
        if (scores.get(1) >= 70) quizFormatter(3, dictLevel3, lastAnswer, scores);

        // result score
        if (scores.get(2) >= 70) {
            int overallScore = scores.get(0) + scores.get(1) + scores.get(2);
            System.out.println("Overall score : " + overallScore + "\n");
            System.out.println("You Winn!!");
        }
    }


    public static void quizFormatter(int lvl, List<String> dictionary, List<String> lastAnswer, List<Integer> scores ) {

        int answerCount = 1, scoreIdx = lvl - 1;
        boolean runLvl = true;
        Scanner input = new Scanner(System.in);

        do {
            scores.set(scoreIdx, 0);

            System.out.println("\nLevel " + lvl);
            System.out.println("-------");
            System.out.println("\t\t" + scrambleWord(dictionary));

            do {
                System.out.print(answerCount + "> Your Answer : ");
                String answer = input.nextLine();

                if ((int)answer.length() < 3 || (int)answer.length() > 6) {
                    System.out.println("\n** Please answer with minimun 3 character and maximum 6 character!! **\n");
                } else if (lastAnswer.contains(answer)) {
                    System.out.println("\n** you can't answer with the same words!! **\n");
                } else {
                    if (dictionary.contains(answer)) {
                        scores.set(scoreIdx, scores.get(scoreIdx) + 10);
                        System.out.println(">** Right. Your Score : " + scores.get(scoreIdx) + " **<\n");
                    }
                    answerCount++;
                }

                lastAnswer.add(answer);
            } while (answerCount <= 10);

            System.out.println("\nYou had answered 10 times with " + scores.get(scoreIdx)/10 +" right answers..");

            if (scores.get(scoreIdx) >= 70) {
                System.out.println("Correct Answers : ");
                for (String s : dictionary) {
                    int idx = dictionary.indexOf(s) + 1;
                    System.out.print(s + " \t");
                    if (idx % 10 == 0) System.out.println("");
                }
                runLvl = false;
            } else {
                String rerun;
                do {
                    System.out.println("You Lose!! Try Again..\n");
                    System.out.print("Do you want to retry [y/t] : ");
                    rerun = input.nextLine();

                    if (!checkRerun(rerun)){
                        System.out.println("Please insert [y/t]!!\n");
                    }
                } while(!checkRerun(rerun));

                if (rerun.contains("t") || rerun.contains("T")) runLvl = false;
            }

            answerCount = 1;
            lastAnswer.clear();
        } while (runLvl);

        System.out.println("");
    }
    public static boolean checkRerun(String answer) {
        String[] answerRun = {"y","Y","t","T"};
        boolean contains = Arrays.stream(answerRun).anyMatch(answer::equals);

        return contains;
    }
    public static String scrambleWord(List<String> arr) {
        List<String> theScramble = new ArrayList<String>();

        for (int charIndex = 0; charIndex < 6; charIndex++) {
            for (int i=0; i < arr.size(); i++) {
                String word = arr.get(i);
                String scrambleWord = scramblingWord(word);
                char[] scrambleArr = scrambleWord.toCharArray();

                for (int j = 0; j < scrambleArr.length; j++) {
                    if (!theScramble.contains(String.valueOf(scrambleArr[j]))) {
                        theScramble.add(String.valueOf(scrambleArr[j]));
                    }
                }
            }
        }

        return String.join("   ", theScramble);
    }

    public static String scramblingWord(String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            int randomIndex = (int)(Math.random() * wordArray.length);
            char temp = wordArray[i];
            wordArray[i] = wordArray[randomIndex];
            wordArray[randomIndex] = temp;
        }
        return new String(wordArray);
    }
}