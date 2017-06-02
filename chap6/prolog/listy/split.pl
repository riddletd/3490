%
% split a list into two parts
%
% split/3 inList outHalf1 outHalf2
%
% samples:
% split([a,b,c], [a,c], [b]) is true.
% split([a,b,c,d], [a,c], [b,d]) is true.
%
%
% Base case 0: List of no items
% An input list of no items has no items in both half lists
%
split([], [], []).


% Base case 1: List of just one item
% An input list of one item places that item in outHalf1
%
split([Item], [Item], []).


% Recursive case: List of two or more items
% An input list separated into two items and a tail places one item as the head of the two
% half lists and the tails of the half lists come from recursing on the tail.
%

split([Item1,Item2 | Tail], [Item1 | Tail1], [Item2 | Tail2]) :-
 		                                 split(Tail, Tail1, Tail2).

