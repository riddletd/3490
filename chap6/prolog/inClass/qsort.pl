/*
 * qsort/2 - Quicksort
 *
 * Can use the built-in append/3 method.
 */

% base case
% An empty list is sorted.
qsort([], []).

% recursive case
% Using the head of the unsorted list as a pivot, divide the unsorted list
%   into two sublists (one has smaller items, the other larger items).
%   Recurse on each of these sublists to get sorted sublists.
%   Append these together into the final sorted list.
%qsort(Unsorted, Sorted) :-
qsort([Pivot|UnsortedTail], Sorted) :-
   separate(UnsortedTail, Pivot, Smallers, Largers),
   qsort(Smallers, SortedSmallers),
   qsort(Largers, SortedLargers),
   append(SortedSmallers, [Pivot | SortedLargers], Sorted).
   
