import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet11 {

    public static void main(String[] args) {
        
    }

// Exercise 1
    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        }
        ArrayList<String> response = new ArrayList<String>();

        for (int j = start; j < end; j++) {
            if (j % 3 == 0 && j % 5 == 0) {
                response.add("FizzBuzz");
            }
            else if (j % 3 == 0) {
                response.add("Fizz");
            }
            else if (j % 5 == 0) {
                response.add("Buzz");
            } else {
                response.add(Integer.toString(j));
            }
        }
        return response;
    }

// Exercise 2
    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }
        if (numbers.size() == 0) {
            return 0;
        }

        HashMap<Integer, Integer> firstAppearance = new HashMap<Integer, Integer>();
        int span = 1;
        int maxSpan = 1;

        for (int j = 0; j < numbers.size(); j++) {

            Integer num = firstAppearance.get(numbers.get(j));

            if (num == null) {
                firstAppearance.put(numbers.get(j), j);
            }
            else {
                span = j - num + 1;
                if (span > maxSpan) {
                    maxSpan = span;
                }
            }
        }
        return maxSpan;
    }

// Exercise 3
    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return null;
        }

        int numThree = 0;
        int numFour = 0;
        int firstThree = 0;
        int firstFour = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                if (numThree == -1) {
                    numThree = i;
                }
                if (i != numbers.size()-1 && numbers.get(i+1) == 3) {
                    return null;
                }
                numThree++;
            }
            else if (numbers.get(i) == 4) {
                if (firstFour == -1) {
                    firstFour = i;
                }
                numFour++;
            }
        }

        if (numThree != numFour) {
            return null;
        }

        for (int i = firstThree; i < numbers.size(); i++) {

            if (numbers.get(i) == 4) {

                for (int j = 0; j < numbers.size(); j++) {

                    if (numbers.get(j) == 3) {
                        int t = numbers.get(j+1);
                        numbers.set(j+1, numbers.get(i));
                        numbers.set(i, t);
                    }
                }
            }
        }
        return numbers;
    }

// Exercise 4
    public ArrayList<Integer> fix45(ArrayList<Integer> num) {
        if (num == null) {
            return null;
        }

        int numFour = 0;
        int numFive = 0;

        for (int i = 0; i < num.size(); i++) {

            if (num.get(i) == 4) {

                if (i != num.size()-1 && num.get(i+1) == 4) {
                    return null;
                }
                numFour++;
            }
            else if (num.get(i) == 5) {
                numFive++;
            }
        }

        if (numFour == 0 && numFive == 0) {
            return null;
        }

        for (int j = 0; j < num.size(); j++) {
            if (num.get(j) == 5) {

                for (int k = 0; k < num.size(); k++) {

                    if (num.get(k) == 4 && num.get(k+1) != 5) {
                        int t = num.get(k+1);

                        num.set(k+1, num.get(j));

                        num.set(j, t);
                    }
                }
            }
        }
        return num;
    }

// Exercise 5
    public boolean canBalance(ArrayList<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {
            return false;
        }

        int leftBal = 0;
        int rightBal = 0;

        for (int i = 0; i < numbers.size(); i++) {


            for (int j = i; j >= 0; j--) {
                leftBal += numbers.get(j);
            }

            for (int k = i+1; k < numbers.size(); k++) {
                rightBal += numbers.get(k);
            }

            if (rightBal == leftBal) {
                return true;
            }

            leftBal = 0;
            rightBal = 0;
        }
        return false;
    }

// Exercise 6
    public boolean linearIn(ArrayList<Integer> out, ArrayList<Integer> in) {

        if (out == null || in == null || out.size() == 0 || in.size() == 0) {
            return false;
        }

        for (int i = 0; i< out.size()-1; i++) {
            if (out.get(i) > out.get(i+1)) {
                return false;
            }
        }

        for (int k = 0; k < in.size()-1; k++) {
            if (in.get(k) > in.get(k+1)) {
                return false;
            }
        }

        boolean found = true;
        for (int j = 0; j < in.size(); j++) {
            int test = 0;
            for (int m = 0; m < out.size(); m++) {
                if (out.get(m) == in.get(j)) {
                    test += 1;
                }
            }
            if (test == 0) {
                return false;
            }
        }
        return true;
    }


    //Exercise 7
    public ArrayList<Integer> squareUp(int m) {
        if (m < 0) {
            return null;
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= m; k++) {
                if (k > m-j) {
                    answer.add(m-k+1);
                } else {
                    answer.add(0);
                }
            }
        }
        return answer;
    }


    // Exercise 8
    public ArrayList<Integer> seriesUp(int n) {
        if (n < 0) {
            return null;
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            for (int h = 0; h < i; h++) {
                answer.add(h+1);
            }
        }
        return answer;
    }

    // Exercise 9
    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }
        int lowIndex = 0;
        int highIndex = 0;
        int current = 0;
        int max = 0;

        for (int j = 0; j < numbers.size(); j++) {
            for (int k = numbers.size() - 1; k >= 0; k--) {
                if (numbers.get(j) == numbers.get(k)) {
                    current = 1;
                    lowIndex = j + 1;
                    highIndex = k - 1;
                    while
                    ((lowIndex <= numbers.size() - 1 && highIndex >= 0) &&
                            (numbers.get(lowIndex) == numbers.get(highIndex))) {
                        highIndex-=1;
                        lowIndex+=1;
                        current+=1;
                    }
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        return max;
    }


    // Exercise 10
    public int countClumps(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return -1;
        }

        int numClumps = 0;
        boolean inClump = false;

        for (int j = 0; j < numbers.size()-1; j++) {
            if ((numbers.get(j) == numbers.get(j+1)) && !inClump) {
                numClumps+=1;
                inClump = true;
            } else if (inClump && (numbers.get(j) != numbers.get(j-1))) {
                inClump = false;
            }
        }
        return numClumps;
    }
}