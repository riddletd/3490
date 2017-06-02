%
% exists/2 X,Y : X exists in list Y
% 
% base case
% An item X exists in a list whose head item is X.
exists(Head, [Head|Tail]).


% recursive case
% An item X exists in a list whose head item is not X if it exists in the tail.
exists(X, [H|T]) :- X \== H, exists(X, T).

