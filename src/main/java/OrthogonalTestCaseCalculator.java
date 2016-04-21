/*
        MIT License

        Copyright (c) [2016] [Brandon Garlock]

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class OrthogonalTestCaseCalculator {
    private Random randomSeed ;
    public OrthogonalTestCaseCalculator() {
        randomSeed = new Random();
    }

    public OrthogonalTestCaseCalculator(long seed) {
            randomSeed = new Random(seed);
    }


    public ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> maxIndex) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        int max_options = 0;
        int multiplier = 1;
        for (int i = 0; i < maxIndex.size(); i++) {
            multiplier = multiplier * maxIndex.get(i);
            if (maxIndex.get(i) > max_options) {
                max_options = maxIndex.get(i);
            }
        }

        int numberofeach = (max_options * max_options);
        if (multiplier < numberofeach) {
            numberofeach = multiplier;
        }
        numberofeach = numberofeach / maxIndex.get(0);
        for (int i = 0; i < maxIndex.get(0); i++) {
            for (int j = 0; j < numberofeach; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                matrix.add(temp);

            }
        }
        if (maxIndex.size() == 1) {
            return matrix;
        }

        int secondMax = maxIndex.get(1);
        int counter = 0;
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).add(counter);
            counter++;
            if (counter >= secondMax) {
                counter = 0;
            }

        }

        if (maxIndex.size() == 2) {
            return matrix;
        }

        for (int thirdIndex = 2; thirdIndex < maxIndex.size(); thirdIndex++) {
            if (maxIndex.get(thirdIndex) > 0) {
                ArrayList<Integer> third = randomOrder(maxIndex.get(thirdIndex), matrix.size());
                ArrayList<Integer> ratings = confidence(matrix, third);
                int oldConfidence = sumConfidence(ratings);
                for (int k = 0; k < 3; k++) {
                    for (int i = 0; i < third.size(); i++) {

                        for (int j = 0; j < third.size(); j++) {
                            ArrayList<Integer> temp = new ArrayList<Integer>();
                            for (int toadd : third) {
                                temp.add(toadd);
                            }
                            Collections.swap(temp, i, j);
                            int new_confidence = sumConfidence(confidence(matrix, temp));
                            if (new_confidence < oldConfidence) {
                                third = temp;
                                oldConfidence = new_confidence;
                            }
                        }


                    }
                }


                for (int i = 0; i < matrix.size(); i++) {
                    matrix.get(i).add(third.get(i));
                }
            }
        }


        return matrix;
    }


    private  int sumConfidence(List<Integer> a) {
        int returnValue = 0;
        for (Integer b : a) {
            returnValue += b;
        }

        return returnValue;
    }

    private  ArrayList<Integer> confidence(ArrayList<ArrayList<Integer>> input, ArrayList<Integer> addon) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> columnValues = new ArrayList<Integer>();
            int count = 0;
            int currentValue = addon.get(i);
            for (int j = 0; j < input.get(0).size(); j++) {
                columnValues.add(input.get(i).get(j));
            }

            for (int j = 0; j < input.size() - 3; j++) {
                if (addon.size() == j) {
                    int ii = 1;
                    i++;
                    int k = i;
                }
                if (addon.get(j) == currentValue) {
                    for (int k = 0; k < input.get(0).size(); k++) {
                        if (input.get(j).get(k).equals(columnValues.get(k))) {
                            count++;
                        }

                    }

                }

            }
            returnList.add(count);

        }

        return returnList;

    }

    private  ArrayList<Integer> randomOrder(int max, int length) {
        ArrayList<Integer> returnArray = new ArrayList<Integer>();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j <= length / max; j++) {
                returnArray.add(i);
            }

        }
        Collections.shuffle(returnArray, randomSeed);

        return returnArray;

    }


}
