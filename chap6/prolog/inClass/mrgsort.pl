%
% mrgsort/2 - Merge sort
%

% base case 1
% An empty list is sorted.
mrgsort([], []).

% base case 2
% A one-item list is sorted.
mrgsort([Item], [Item]).


% recursive case
% Divide the unsorted list into two halves. Recurse on each unsorted half
%    to get two sorted halves. Merge the two sorted halves into the
%    final sorted list.
mrgsort(Unsorted, Sorted) :- split(Unsorted, L1, L2),
                           mrgsort(L1, SortedL1),
			   mrgsort(L2, SortedL2),
			   merge(SortedL1, SortedL2, Sorted), !.
                           
			   



% merge/3
% Inputs: two lists of numbers
% Output: one list with all input numbers such that they are sorted
%
% base case 1
% Merging an empty list with a list results in the same list.
merge([], List, List).

% base case 2
% Merging a list with an empty list results in the same list.
merge(List, [], List).


% recursive case 1
% Merging a list1 with a list2 has the head1 as the merged list head
%    if head1 is smaller than head2. The tail of the merged list comes
%    from a recursive call using tail1 and list2.
merge([Head1|Tail1], [Head2|Tail2], [Head1|TheRest]) :-
   Head1 =< Head2,
   merge(Tail1, [Head2|Tail2], TheRest).


% recursive case 2
% Merging a list1 with a list2 has the head2 as the merged list head
%    if head1 is larger than head2. The tail of the merged list comes
%    from a recursive call using list1 and tail2.
merge([Head1|Tail1], [Head2|Tail2], [Head2|TheRest]) :-
   Head1 > Head2,
   merge([Head1|Tail1], Tail2, TheRest).


