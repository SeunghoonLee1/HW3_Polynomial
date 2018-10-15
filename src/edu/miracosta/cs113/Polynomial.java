package edu.miracosta.cs113;

/**
 * Polynomial.java : This class has a LinkedList<Term> instance variable, which specifically contains
 * polynomial-related methods(like creating a polynomial, adding two polynomials etc.).
 *
 *  @author Danny Lee
 *  @version 1.0
 */

import java.security.cert.PolicyNode;
import java.util.LinkedList;

public class Polynomial{

    private int numTerms = 0;
    private LinkedList<Term> listOfTerms = null;

    /**
     * Default constructor, initializes instance variables.
     */
    public Polynomial(){
        listOfTerms = null;
        numTerms = 0;
    }

    /**
     * Copy constructor, deep copies Polynomial object
     *
     * @param anotherPolynomial used to get all Polynomial parts and deep copy.
     */
    public Polynomial(Polynomial anotherPolynomial){
        this.setList(anotherPolynomial.getList());
    }

    /**
     * Creates LinkedList<Term> object and assigns to the instance variable.
     */
    public void createListOfTerms(){
        listOfTerms = new LinkedList<>();
    }

    /**
     * Accessor for numTerms value.
     *
     * @return numTerms integer value
     */
    public int getNumTerms(){
        return numTerms;
    }

    /**
     * Mutator for numTerms value.
     *
     * @param numberOfTerms integer value representing the number of terms in the LinkedList.
     */
    public void setNumTerms(int numberOfTerms){
        numTerms = numberOfTerms;
    }

    /**
     * This helper method adds another term to the LInkedList.
     * If the LinkedList if empty, add the termToAdd to the front of the list.
     * If not, add to the last of the list.
     * When done, increment numTerms by one.
     * @param termToAdd represents a Term object that will be added to the LinkedList.
     */
    //This adds another term "to the linked list".
    public void addTerm(Term termToAdd){
        if(listOfTerms.size() == 0){
            listOfTerms.addFirst(termToAdd);
        }else{
            //assuming the user will enter terms in proper order(high to low).
            listOfTerms.addLast(termToAdd);
        }
        numTerms++;
    }

    /**
     * This helper method switches two terms of given indices.
     *
     * @param firstTermIndex, represents the index number of the Term in the LinkedList.
     * @param secondTermIndex represents the index number of the other Term in the LinkedList.
     */
    public void switchTerms(int firstTermIndex, int secondTermIndex){
        Term temp = this.getTerm(secondTermIndex);
        this.listOfTerms.set(secondTermIndex, this.getTerm(firstTermIndex));
        this.listOfTerms.set(firstTermIndex,temp);

    }

    /**
     * This helper method sort terms in descending order based on exponents of the terms..
     *
     */
    public void sortTerms(){
        int result = 0;
        for(int i = 0; i < this.getNumTerms(); i++){
            for(int j = i + 1; j< this.getNumTerms(); j++){
                result = this.getNumTerms();
                if(this.getTerm(i).getExponent() < this.getTerm(j).getExponent()){ //when i exponent < j exponent

                    this.switchTerms(i,j);
                }
            }//end of inner for loop(j)
        }//end of outer for loop(i)
    }

    /**
     * This helper method adds coefficients of the LinkedList.
     * Looping through the polynomial's terms, if terms with the same exponents are found, it adds the
     * coefficients of them and stores the new Term object into a new simplifiedPolynomial's LinkedList.
     * If not found, it just adds that Term to the simplifiedPolynomial.
     *
     * @return  simplifiedPolynomial represents a polynomial that has
     * all the coefficients with the same exponents added together.
     */
    public Polynomial addCoefficients(){

        Polynomial simplifiedPolynomial = new Polynomial();
        simplifiedPolynomial.createListOfTerms();
        int i = 0;
        int j = 0;

        for(i = 0; i < this.getNumTerms(); i++){
            for(j = i + 1; j < this.getNumTerms(); j++){
                if(this.getTerm(i).compareTo(this.getTerm(j)) == 0){
                    simplifiedPolynomial.addTerm(new Term(this.getTerm(i).getExponent(),(this.getTerm(i).getCoefficient() + this.getTerm(j).getCoefficient())));
                    i++;
                    break;
                }else if(j == this.getNumTerms() - 1){
                    simplifiedPolynomial.addTerm(new Term(this.getTerm(i).getExponent(), this.getTerm(i).getCoefficient()));
                }
            }//enf of inner for loop(j)

        }//end of outer for loop(i)
        if(i >= 3){
            if(this.getTerm(i - 1).compareTo(this.getTerm(i - 2)) != 0 && i == this.getNumTerms() ){//adding the last term to the polynomial
                simplifiedPolynomial.addTerm(new Term(this.getTerm(i - 1).getExponent(), this.getTerm(i - 1).getCoefficient()));
            }
        }else if(i < 3){
            if(i == this.getNumTerms());
            simplifiedPolynomial.addTerm(new Term(this.getTerm(i - 1).getExponent(), this.getTerm(i - 1).getCoefficient()));
        }

        return simplifiedPolynomial;
    }

    /**
     * This helper method simplifies the Polynomial by calling two helper methods (sortTerms() and addCoefficients())
     * @return  simplifiedPolynomial represents a polynomial that is sorted in descending order of exponents and
     * its coefficients with the same exponents added together.
     */
    public Polynomial simplifyPolynomial(){

        Polynomial simplifiedPolynomial = new Polynomial();

        this.sortTerms();
        simplifiedPolynomial = this.addCoefficients();

        return simplifiedPolynomial;
    }

    /**
     * This helper method adds two polynomials.
     * It adds the polynomialToAdd to the calling polynomial object.
     *
     * @param polynomialToAdd represents the polynomial to be added.
     */
    public void add(Polynomial polynomialToAdd){

        for(int i = 0; i < polynomialToAdd.getNumTerms(); i++){
            this.getList().add(polynomialToAdd.getTerm(i));
        }
        this.setNumTerms(numTerms + polynomialToAdd.getList().size());
    }

    /**
     * Accessor for getList value.
     *
     * @return listOfTerms LinkedList<Term> variable.
     */

    public LinkedList<Term> getList(){
        return listOfTerms;
    }

    /**
     * Mutator for listOfTerms value.
     * It clears the original elements in the listOfTerms and adds the elements in the givenList.
     * @param  givenList LinkedList<Term>
     */

    public void setList(LinkedList<Term> givenList){
        this.listOfTerms.clear();
        this.listOfTerms.addAll(givenList);
    }

    /**
     * Accessor for numTerms value.
     * It returns the Term in the LinkedList of the given index.
     *
     * @param index integer value representing the index of the Term to return in the LinkedList.
     * @return termToReturn Term object
     */
    public Term getTerm(int index){
        Term termToReturn = listOfTerms.get(index);
        return termToReturn;
    }

    /**
     * clears all the elements in the LinkedList<Term>
     *
     */
    public void clear(){
        listOfTerms.clear();
    }

    /**
     *toString representing the values of the Polynomial.
     *
     * @return stringToReturn representing the terms in the Polynomial that are being added/subtracted to each other.
     */
    @Override
    public String toString(){
        String stringToReturn = "";

        for(int i = 0; i < this.getNumTerms(); i++){
            if(i == 0){
                stringToReturn = stringToReturn + this.getTerm(i);
            }else if(this.getTerm(i).getCoefficient() > 0){
                stringToReturn = stringToReturn + " + " + this.getTerm(i);
            }else if(this.getTerm(i).getCoefficient() == 0){
                stringToReturn =  stringToReturn;
            }else{
                stringToReturn = stringToReturn + " " +this.getTerm(i);
            }
        }
        return stringToReturn;
    }

    /**
     * Equals method checks all instance variables are equal.
     * @param otherObject another object that is being compared.
     * @return boolean value that represents if two Polynomials are equal or not.
     */
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }else if(getClass() != otherObject.getClass()){
            return false;
        }else{
            LinkedList<Term> otherList = (LinkedList<Term>)otherObject;
            if(listOfTerms.size() != otherList.size()){
                return false;
            }else{
                for(int i = 0; i < listOfTerms.size(); i++){
                    if(!(listOfTerms.get(i).equals(otherList.get(i)))){
                        return false;
                    }
                }
            }

            //How can we traverse?? do we use getNode?
            return true;
        }
    }

}//end of class