
% Find the Kth element of a list.

% kth_element([List], Index, Result) :- Result will be the Head of the list at the Index.
% Starting Index: 1

kth_element([Item|_], 1, Item).
kth_element([_|Tail], Index, Result) :-
	Index > 1,
	Dec is Index - 1,
	kth_element(Tail, Dec, Result).
