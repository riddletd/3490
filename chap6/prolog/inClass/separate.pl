%
% separate a list into two sublists based on a pivot value
%
% separate/3 inList pivotValue outHalf1 outHalf2
%
% samples:
% separate([1,5,3,14,55], 4, [1,3], [5,14,55]) is true.
% separate([], 4, [], []) is true.



%
%
% Base case 0: List of no items
% An input list of no items has no items in both half lists
%
separate([], _, [], []).


% Base case 1: List of just one item
% An input list of one item places that item in outHalf1
%
separate([Num], Pivot, [Num], []) :- Num =< Pivot. 
separate([Num], Pivot, [], [Num]) :- Num > Pivot. 





% Recursive case: List of two or more items
% An input list separated into two items and a tail places one item as the head of the two
% half lists and the tails of the half lists come from recursing on the tail.
%

separate([Head | Tail], Pivot, [Head | S], L ) :- Head =< Pivot, 
                                                  separate(Tail, Pivot, S, L).
separate([Head | Tail], Pivot, S, [Head | L] ) :- Head > Pivot, 
                                                  separate(Tail, Pivot, S, L).

