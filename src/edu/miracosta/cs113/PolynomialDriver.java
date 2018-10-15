package edu.miracosta.cs113;

/**
 * PolynomialDriver.java : This driver program demonstrates Polynomial ADT implementation.
 * A menu program allows a user to edit the first and second polynomials(clear, create, and add terms),
 * display the result of adding the current first and second polynomial(without deleting/modifying those two
 * polynomials) and exiting the program.
 * The user will be allowed to enter terms for a polynomial in whatever order they'd like and the polynomial
 * will be stored, output, and maintain proper order.
 *
 * @author Danny Lee
 * @version 1.0
 */


import java.util.Scanner;

public class PolynomialDriver {
    /*
     *ALGORITHM:
     *  WHILE exitProgram != true
     *      Display menu options 1~4
     *      Get user input for menu.
     *      IF menuInput == 1 or menuInput == 2
     *          WHILE endEditPolynomial != true
     *              Display editing options to the user and edit.
     *      IF menuInput == 3
     *          Display the result of adding two polynomials to the user.
     *      IF menuInput == 4
     *          Exit the program.
     * END
     *
     */

    /**
     * Driver method for editing and adding two polynomials.
     * @param args not used for driver
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String termInput = "";
        int menuInput = 0;
        int editChoice = 0;
        int termToEdit = 0;
        boolean endEditFirstPolynomial = false;
        boolean endEditSecondPolynomial = false;
        boolean exitProgram = false;


        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.createListOfTerms();
        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.createListOfTerms();

        Polynomial tempPolynomial = new Polynomial();
        tempPolynomial.createListOfTerms();
        Polynomial tempPolynomial2 = new Polynomial();
        tempPolynomial2.createListOfTerms();

        Polynomial simplifiedPolynomial = new Polynomial();
        simplifiedPolynomial.createListOfTerms();
        Polynomial simplifiedPolynomial2 = new Polynomial();
        simplifiedPolynomial2.createListOfTerms();

        Polynomial addedPolynomial = new Polynomial();
        addedPolynomial.createListOfTerms();

        Polynomial finalPolynomial = new Polynomial();
        finalPolynomial.createListOfTerms();

        //Program starts
        while (!exitProgram) {
            //Display the menu options.
            System.out.println("===================Menu======================");
            System.out.println("1. Edit the first polynomial.");
            System.out.println("2. Edit the second polynomial.");
            System.out.println("3. Display the result of adding two polynomials.");
            System.out.println("4. Exit the program.");

            menuInput = keyboard.nextInt();

            switch (menuInput) {
                case 1:
                    System.out.println("Editing first polynomial. Please choose a number among the options below.");

                    endEditFirstPolynomial = false;
                    while (!endEditFirstPolynomial) {
                        //Display editing options for the first polynomial.
                        System.out.println("1. Create terms.");
                        System.out.println("2. Display the terms in the first polynomial.");
                        System.out.println("3. Edit a specific term.");
                        System.out.println("4. Clear all terms in the first polynomial");
                        System.out.println("5. Add terms to the first polynomial.");
                        System.out.println("6. End editing first polynomial.");
                        editChoice = keyboard.nextInt();
                        keyboard.nextLine();
                        if (editChoice == 1) {
                            System.out.println("Please enter a term.");
                            termInput = keyboard.nextLine();
                            tempPolynomial.addTerm(new Term(termInput));
                        } else if (editChoice == 2) {
                            System.out.println(tempPolynomial.getList());
                        } else if (editChoice == 3) {
                            System.out.println("Which term do you want to edit? (0th, 1st, 2nd. ...)");
                            termToEdit = keyboard.nextInt();
                            keyboard.nextLine();
                            System.out.println("Please enter a new term to replace Term number " + termToEdit + ".");
                            termInput = keyboard.nextLine();
                            tempPolynomial.getList().set(termToEdit, new Term(termInput));
                        } else if (editChoice == 4) {
                            System.out.println("Clearing all the terms.");
                            tempPolynomial.getList().clear();
                        } else if (editChoice == 5) {
                            System.out.println("Adding all the terms to the first polynomial.");

                            firstPolynomial.add(tempPolynomial);
                            //firstPolynomial.setNumTerms(tempPolynomial.getList().size());
                            System.out.println("Polynomial 1 : " + firstPolynomial);
                            simplifiedPolynomial = firstPolynomial.simplifyPolynomial();
                            System.out.println("Polynomial 1 after simplifying: " + simplifiedPolynomial);
                        } else if (editChoice == 6) {
                            endEditFirstPolynomial = true;
                        } else {
                            System.out.println("Please choose menu between 1 to 6.");
                        }


                    } break; //end of endEdit while loop.


                case 2:
                    System.out.println("Editing second polynomial. Please choose a number among the options below.");

                    endEditSecondPolynomial = false;
                    while (!endEditSecondPolynomial) {
                        //Display editing options for the second polynomial.
                        System.out.println("1. Create terms.");
                        System.out.println("2. Display the terms in the second polynomial.");
                        System.out.println("3. Edit a specific term.");
                        System.out.println("4. Clear all terms in the second polynomial");
                        System.out.println("5. Add terms to the second polynomial.");
                        System.out.println("6. End editing second polynomial.");
                        editChoice = keyboard.nextInt();
                        keyboard.nextLine();
                        if (editChoice == 1) {
                            System.out.println("Please enter a term.");
                            termInput = keyboard.nextLine();
                            tempPolynomial2.addTerm(new Term(termInput));
                        } else if (editChoice == 2) {
                            System.out.println(tempPolynomial2.getList());
                        } else if (editChoice == 3) {
                            System.out.println("Which term do you want to edit? (0th, 1st, 2nd. ...)");
                            termToEdit = keyboard.nextInt();
                            keyboard.nextLine();
                            System.out.println("Please enter a new term to replace Term number " + termToEdit + ".");
                            termInput = keyboard.nextLine();
                            tempPolynomial2.getList().set(termToEdit, new Term(termInput));
                        } else if (editChoice == 4) {
                            System.out.println("Clearing all the terms.");
                            tempPolynomial2.getList().clear();
                        } else if (editChoice == 5) {
                            System.out.println("Adding all the terms to the second polynomial.");

                            secondPolynomial.add(tempPolynomial2);
                            //firstPolynomial.setNumTerms(tempPolynomial.getList().size());
                            System.out.println("Polynomial 2 : " + secondPolynomial);
                            simplifiedPolynomial2 = secondPolynomial.simplifyPolynomial();
                            System.out.println("Polynomial 2 after simplifying: " + simplifiedPolynomial2);
                        } else if (editChoice == 6) {
                            endEditSecondPolynomial = true;
                        } else {
                            System.out.println("Please choose menu between 1 to 6.");
                        }


                    } break; //end of endEdit while loop.

                case 3:
                    System.out.println("Adding two polynomials.");
                    System.out.println("Polynomial 1 : " + simplifiedPolynomial);
                    System.out.println("Polynomial 2 : " + simplifiedPolynomial2);
                    addedPolynomial.add(firstPolynomial);
                    addedPolynomial.add(secondPolynomial);

                    System.out.println("Added Result before simplifying : " + addedPolynomial);
                    finalPolynomial = addedPolynomial.simplifyPolynomial();
                    System.out.println("Result : " + finalPolynomial);
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    exitProgram = true;
                    break;
            }//end of switch menu input

        }//end of while exit program

    }//end of main method
}//end of class