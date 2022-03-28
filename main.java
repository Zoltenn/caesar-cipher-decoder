import java.util.Scanner;

public class CodeBreaker {
    public static void main(String[] args) {

        //user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your cypher text: ");
        String cypher = sc.nextLine();

        //turn input string into char array
        char[] cypherArray = new char[cypher.length()];
        for (int i = 0; i < cypher.length(); i++) {
            cypherArray[i] = cypher.charAt(i);
        }

        //loop for shifting chars from -26 to 26, assigns that to temp[], and test for english
        for (int i = -26; i <= 26; i++ ) {

            char[] temp = shift(cypherArray, i);
            int flag = 0;  // flag will test for 3/4 english words found

            //search for english: the, be, to, of, and
            for (int j = 0; j < temp.length; j++) {

                try {

                    //the, to
                    if (temp[j] == 'T' || temp[j] == 't') {
                        if ((temp[j + 1] == 'h' && temp[j + 2] == 'e') || temp[j + 1] == 'o') {
                            flag += 1;
                        }
                    }

                    //be
                    else if (temp[j] == 'B' || temp[j] == 'b'){
                        if (temp[j + 1] == 'e') {
                            flag += 1;
                        }
                    }

                    //of
                    else if (temp[j] == 'O' || temp[j] == 'o') {
                        if (temp[j + 1] == 'f') {
                            flag += 1;
                        }
                    }

                    //and
                    else if (temp[j] == 'A' || temp[j] == 'a') {
                        if (temp[j + 1] == 'n' && temp[j + 2] == 'd') {
                            flag += 1;
                        }
                    }
                }
                catch (Exception e) {
                    break;
                }

            }

            //if 3/4 words present, print that solution
            if (flag >= 3) {
                System.out.println();
                printArray(temp);
                System.out.println();
            }
        }

        sc.close();

    } // end of main method
    

    //shift each char (ascii) in array
    public static char[] shift(char[] arr, int shiftNum) {
        char[] shiftedArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shiftedArr[i] = (char)(arr[i] + (shiftNum));
        }
        return shiftedArr;
    }

    //print char array
    public static void printArray(char[] arr) {
        for (char element: arr) {
            System.out.print(element);
        }

    }

}
