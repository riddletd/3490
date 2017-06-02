/* Farmer, Wolf, Goat, Cabbage 
 *
 * Representation:
 *   e = East river bank
 *   w = West river bank
 *   Each state (node): [FarmerLocation, WolfLocation, GoatLocation, CabbageLocation]
 *     so: [e,w,w,e] means Farmer,Cabbage are on east bank; Wolf,Goat on west bank
 *         (this is an unsafe state!)
 */


/* 4 moves: farmer by himself, farmer+wolf, farmer+goat, farmer+cabbage */
/* Farmer moves by himself if he's on opposite bank and other are unchanged. */
move([F1,W,G,C],[F2,W,G,C]) :- opposite(F1,F2), safe([F2,W,G,C]).

/* Farmer moves wolf if they are on same side originally and
   same side afterwards,
   and the banks are opposites, and others are unchanged. */
move([S1,S1,G,C],[S2,S2,G,C]) :- opposite(S1,S2), safe([S2,S2,G,C]).

/* Similarly for F+G and F+C... */
move([S1,W,S1,C],[S2,W,S2,C]) :- opposite(S1,S2), safe([S2,W,S2,C]).
move([S1,W,G,S1],[S2,W,G,S2]) :- opposite(S1,S2), safe([S2,W,G,S2]).


/* West is opposite of East and East is opposite of West. */
opposite(e,w).
opposite(w,e).

/* There are lots of safe states but only a few unsafe ones; so less work for
   us to define the smaller set and then negate to get larger set! */
/* A safe state is not an unsafe state. */
safe([F,W,G,C]) :- \+(unsafe([F,W,G,C])).

/* There are two unsafe states:
   1. wolf and goat on same side that is opposite of farmer,
   2. goat and cabbage on same side that is opposite of farmer
*/
unsafe([F,S,S,_]) :- opposite(F,S).
unsafe([F,_,S,S]) :- opposite(F,S).


/* Start and end state generators. */
initial([e,e,e,e]).
final([w,w,w,w]).

/* Program entry point */
fwgc :-
      initial(Start),
      length(Solution, L), L < 10,
      verify([Start|Solution]),
      prettyprint([Start|Solution]).





/* Solutions are being generated so verify a solution.
 * base case: last state is the final state.
 * recursive case: allowable move from first to second state,
 *                 recurse on path without first state.
 */
verify([State]) :- final(State).

verify([State1, State2 | Tail]) :-
    move(State1, State2), verify([State2|Tail]).


/* prettyprint each state recursively ending with "nl" */
prettyprint([]) :- nl.
prettyprint([H|T]) :- write(H), nl, prettyprint(T).
