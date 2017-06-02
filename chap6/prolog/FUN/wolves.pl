/*  
    Just Wolves and Goats

    On a river bank there are 3 wolves and 3 goats.
    There is also a boat with 2 places for crossing the river.
    If it ever occurs that on a bank there remain more wolves than goats
    then it is dangerous, since the wolves will eat the goats.

    How could they all cross the river without being in danger?

  Representation:
    The banks are labeled e (east) and w (west). 

    A state (node) is:
       [BoatLocation, NumGoatsEast, NumWolvesEast, NumGoatsWest, NumWolvesWest]
    or short:
    [Bank,GoatsE,WolvesE,GoatsW,WolvesW]
    [e,2,0,1,3] - means the boat is on the east bank
                  on the east bank there are: 2 goats and no wolves
                  on the west bank there is 1 lamb and 3 wolves
              (this is acutally a unacceptable state).
*/


/* Generators.
    Initial state is boat and all animals on east bank.
    Final state is boat and all animals on west bank.
*/
initial([e,3,3,0,0]).
final([w,0,0,3,3]).

/*
   Generator.
    Allowable boat seatings.
    boat/2 cycles through the various allowable boat seatings.
*/
boat(NumGoats,NumWolves) :-
  member([NumGoats,NumWolves], [[0,1],[1,0],[1,1],[2,0],[0,2]]).


/* Program entry: main. */
main :-
  initial(Start),
  length(StateList, L), L < 15,
  verify([Start | StateList]),
  prettyprint([Start|StateList]).



/*********************** YOUR CONTRIBUTIONS ************************/

/* Define what it means to be in an unsafe state. */
unsafe([_,GoatsEast,WolvesEast,_,_]):- ??????????????
unsafe([_,_,_,GoatsWest,WolvesWest]):- ??????????????



/* verify/1
 * 
 * argument is a list of states
 *
 * Base case: list of 1 state that is the final state
 *            
 * Recursive case:
 *  list of 2 more more states,
 *  legal move between the two states,
 *  the second state is a safe state,
 *  continue recursion but without the first state.
 */





/* move/2
 * Both args are states
 *
 * There are two moves: boat on east goes west, boat on west goes east.
 *
 * Here is description of first move, other is similar.
 *   Use boat/2 to generate a configuration of goats and wolves in the boat.
 *   Then do comparisons (including "is") to see if the second state
 *     derives from the first state and the boat/2 configuration.
 *
 * Goats on the east side originally should be >= goats in the boat.
 * Goats on the east side in the new state "is" original east side goats
 *   less goats in the boat. Similarly for wolves on the east side.
 * Goats on the west side in the new state is the sum of the goats on
 *   on the west side originally and the goats in the boat.
 * Similarly for the wolves.
 */




/* prettyprint
 * Very simple: prints each path state.
 * base case: empty path, write a "nl".
 * recursive case: "write" the head, write a "nl", prettyprint tail.
 */

