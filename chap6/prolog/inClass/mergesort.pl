msort([], []).

msort([Item], [Item]).

msort(Unsorted, Sorted) :- split(Unsorted, L1, L2),
	       	       	  msort(L1, SortedL1),
			  msort(L2, SortedL2),
			  merge(SortedL1, SortedL2, Sorted).
% Base case 1
merge([], List, List).

% Base case 2
merge(list, [], List).

% Recursive case 1
merge([Head1|Tail1], [Head2|Tail2], [Head1|Others]) :- Head1 =< Head2,
		     		    		       merge(Tail1, [Head2|Tail2], Others).

% Recursive case 2
merge([Head1|Tail1], [Head2|Tail2], [Head2|TheRest]) :- 
