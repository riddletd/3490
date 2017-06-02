
% Base Case
qsort([], []).

% Recursive Case
qsort([Pivot|UnsorterdTail], Sorted) :-
			     separate(UnsortedTail, Pivot, Smallers, Largers),
			     qsort(Smallers, SortedSmallers),
			     qsort(Largers, SortedLargers),
			     append(SortedSmallers, [Pivot|SortedLargers], Sorted), !.
