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
import static org.junit.Assert.*;


public class OrthogonalTestCaseCalculatorTest {
    @org.junit.Test
    public void FourTestInput() throws Exception {
        ArrayList<Integer> numberOfTestCasesForEachInput = new ArrayList<Integer>();
        numberOfTestCasesForEachInput.add(5);
        numberOfTestCasesForEachInput.add(8);
        numberOfTestCasesForEachInput.add(7);
        numberOfTestCasesForEachInput.add(8);
        OrthogonalTestCaseCalculator calculator = new OrthogonalTestCaseCalculator(1000);
        ArrayList<ArrayList<Integer>> perms = calculator.permutations(numberOfTestCasesForEachInput);
        assertEquals(perms.toString(),"[[0, 0, 3, 7], [0, 1, 4, 4], [0, 2, 5, 1], [0, 3, 5, 2], [0, 4, 3, 3], [0, 5, 1, 1], [0, 6, 4, 6], [0, 7, 2, 5], [0, 0, 0, 0], [0, 1, 1, 5], [0, 2, 6, 7], [0, 3, 6, 3], [1, 4, 0, 6], [1, 5, 4, 2], [1, 6, 6, 2], [1, 7, 1, 3], [1, 0, 1, 7], [1, 1, 2, 1], [1, 2, 3, 4], [1, 3, 4, 5], [1, 4, 2, 0], [1, 5, 0, 4], [1, 6, 3, 5], [1, 7, 5, 7], [2, 0, 3, 2], [2, 1, 0, 3], [2, 2, 2, 6], [2, 3, 0, 7], [2, 4, 1, 4], [2, 5, 6, 0], [2, 6, 5, 4], [2, 7, 4, 1], [2, 0, 6, 5], [2, 1, 5, 0], [2, 2, 2, 2], [2, 3, 3, 1], [3, 4, 6, 1], [3, 5, 5, 3], [3, 6, 2, 3], [3, 7, 0, 2], [3, 0, 4, 4], [3, 1, 6, 6], [3, 2, 0, 5], [3, 3, 2, 4], [3, 4, 4, 7], [3, 5, 5, 6], [3, 6, 1, 2], [3, 7, 3, 0], [4, 0, 2, 6], [4, 1, 3, 2], [4, 2, 4, 3], [4, 3, 3, 6], [4, 4, 5, 5], [4, 5, 2, 7], [4, 6, 0, 1], [4, 7, 6, 4], [4, 0, 5, 1], [4, 1, 1, 0], [4, 2, 1, 0], [4, 3, 1, 0]]");
    }
    @org.junit.Test
    public void SingleTestCaseForInput() throws Exception {
        ArrayList<Integer> numberOfTestCasesForEachInput = new ArrayList<Integer>();
        numberOfTestCasesForEachInput.add(5);
        numberOfTestCasesForEachInput.add(1);
        numberOfTestCasesForEachInput.add(7);
        numberOfTestCasesForEachInput.add(8);
        OrthogonalTestCaseCalculator calculator = new OrthogonalTestCaseCalculator(1000);
        ArrayList<ArrayList<Integer>> perms = calculator.permutations(numberOfTestCasesForEachInput);

        assertEquals(perms.toString(), "[[0, 0, 3, 7], [0, 0, 2, 1], [0, 0, 5, 4], [0, 0, 1, 0], [0, 0, 6, 1], [0, 0, 1, 2], [0, 0, 4, 5], [0, 0, 4, 7], [0, 0, 6, 6], [0, 0, 3, 5], [0, 0, 5, 3], [0, 0, 0, 0], [1, 0, 6, 7], [1, 0, 0, 7], [1, 0, 2, 5], [1, 0, 4, 3], [1, 0, 1, 4], [1, 0, 5, 6], [1, 0, 3, 0], [1, 0, 4, 1], [1, 0, 2, 2], [1, 0, 0, 3], [1, 0, 3, 1], [1, 0, 5, 0], [2, 0, 3, 6], [2, 0, 1, 7], [2, 0, 2, 6], [2, 0, 1, 3], [2, 0, 2, 3], [2, 0, 6, 4], [2, 0, 5, 2], [2, 0, 3, 1], [2, 0, 6, 5], [2, 0, 5, 1], [2, 0, 0, 2], [2, 0, 4, 0], [3, 0, 6, 3], [3, 0, 5, 7], [3, 0, 2, 4], [3, 0, 0, 6], [3, 0, 1, 6], [3, 0, 4, 4], [3, 0, 0, 1], [3, 0, 2, 0], [3, 0, 4, 2], [3, 0, 5, 5], [3, 0, 1, 5], [3, 0, 3, 2], [4, 0, 2, 0], [4, 0, 3, 4], [4, 0, 3, 3], [4, 0, 4, 6], [4, 0, 5, 5], [4, 0, 2, 7], [4, 0, 6, 2], [4, 0, 6, 0], [4, 0, 1, 1], [4, 0, 0, 4], [4, 0, 0, 5], [4, 0, 0, 4]]");
    }
    @org.junit.Test
    public void TwoTestInput() throws Exception {
        ArrayList<Integer> numberOfTestCasesForEachInput = new ArrayList<Integer>();
        numberOfTestCasesForEachInput.add(5);
        numberOfTestCasesForEachInput.add(8);
        OrthogonalTestCaseCalculator calculator = new OrthogonalTestCaseCalculator(1000);
        ArrayList<ArrayList<Integer>> perms = calculator.permutations(numberOfTestCasesForEachInput);
        assertEquals(perms.toString(),"[[0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [0, 5], [0, 6], [0, 7], [1, 0], [1, 1], [1, 2], [1, 3], [1, 4], [1, 5], [1, 6], [1, 7], [2, 0], [2, 1], [2, 2], [2, 3], [2, 4], [2, 5], [2, 6], [2, 7], [3, 0], [3, 1], [3, 2], [3, 3], [3, 4], [3, 5], [3, 6], [3, 7], [4, 0], [4, 1], [4, 2], [4, 3], [4, 4], [4, 5], [4, 6], [4, 7]]");
    }
    @org.junit.Test
    public void OneTestInput() throws Exception {
        ArrayList<Integer> numberOfTestCasesForEachInput = new ArrayList<Integer>();
        numberOfTestCasesForEachInput.add(5);
        OrthogonalTestCaseCalculator calculator = new OrthogonalTestCaseCalculator(1000);
        ArrayList<ArrayList<Integer>> perms = calculator.permutations(numberOfTestCasesForEachInput);
        System.out.println(perms);
        assertEquals(perms.toString(),"[[0], [1], [2], [3], [4]]");

    }
}