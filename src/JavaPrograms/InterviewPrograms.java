package JavaPrograms;

import java.security.Key;
import java.util.*;

import static java.lang.String.valueOf;

public class InterviewPrograms {

    public static void iterateMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "AA");
        map.put("b", "BB");
        map.put("c", "CC");
        map.put("d", "DD");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String home = "HoMePaGe";//get OEAE of home page
        home = home.toUpperCase();

        char temp;
        for (int i = 1; i < home.length(); i = i + 2) {
            temp = home.charAt(i);

            System.out.print(temp);

        }
        iterateMap();
        Integer[] a = {1, 2, 1, 2, 5, 9};
        getSecondLargestNo();
        validateUserName("A1usguxg");
        validateUserName1("Swara Saraf");
        System.out.println(Arrays.toString(getNewArray(a)));
        getCharacterCount();
        generateRandomNumber();
    }

    private static Integer[] append(Integer[] arr, int element) {
        Integer[] array = new Integer[arr.length + 1];
        System.arraycopy(arr, 0, array, 0, arr.length);
        array[arr.length] = element;
        return array;
    }

    public static Integer[] getNewArray(Integer[] a) {
        Integer[] output = {};
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 4) {
                return output;
            } else {
                output = append(output, a[i]);

            }
        }
        return output;
    }

    public static void getSecondLargestNo() {
        int[] a = {6, 2, 8, 1, 7, 3, 2, 10};
        int max = 0;
        int secondLargest = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("Largest no. in an array = " + max);
        for (int j = 0; j < a.length; j++) {
            if (a[j] > secondLargest && a[j] != max) {
                secondLargest = a[j];
            }
        }
        System.out.println("Second largest no. in an array = " + secondLargest);

    }

    public static void validateUserName(String givenUserName) {
        boolean flag = true;
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        for (int i = 0; i < specialChars.length(); i++) {
            if (givenUserName.contains(valueOf(specialChars.charAt(i))) || givenUserName.contains(" ")) {
                System.out.println("Username is invalid");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Username is valid");
        }
    }

    public static void validateUserName1(String givenUserName) {
        boolean flag = true;
        char[] username = givenUserName.toCharArray();
        for (Character c : username) {
            if (!(Character.isLetterOrDigit(c))) {
                System.out.println("Username is invalid***");
                flag = false;
                break;
            }

        } if (flag) {
            System.out.println("Username is valid***");
        }


        }
        public static void getCharacterCount(){
        String s = "The quick brown fox jumps over the lazy dog";
        String s1 = s.toLowerCase();
        char[] ca = s1.toCharArray();
        List<Integer> characterOccurrence =new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ca.length;i++){
            if(!(map.containsKey(ca[i]))){
                map.put(ca[i],1);
            }else{
               int v =  map.get(ca[i])+1;
               map.put(ca[i],v);
            }
        }map.remove(' ');
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
                System.out.println(entry.getKey()+" : "+entry.getValue());
                    characterOccurrence.add(entry.getValue());

         }
            Collections.sort(characterOccurrence);
            int highestCharacterIndex = characterOccurrence.size()-1;
            int highestOccurrenceCharacter = characterOccurrence.get(highestCharacterIndex);

            for(Map.Entry<Character,Integer> entry: map.entrySet()){

                if (entry.getValue().equals(highestOccurrenceCharacter)) {
                    Character  highestOccurrenceCharacterName = entry.getKey();
                    System.out.println("highestOccurrenceCharacterName = "+highestOccurrenceCharacterName);
                    System.out.println("highestOccurrenceCharacterNumber = "+highestOccurrenceCharacter);
                    break;
                }
            }
      }

        
        public static void generateRandomNumber() {
        	Random r = new Random();
        	int low = 1;
        	int high = 6;
        	int result = r.nextInt(high-low) + low;
        	System.out.println("result ="+ result);
        }

        





        }


