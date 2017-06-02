/*
 * Write the program max/2 that takes a list of integers as its 
 * first argument and an integer as its second argument.
 * Verification mode: max/2 returns Yes if the second argument
 * is the maximum element value of the first argument list.
 * Computation mode: max/2 determines a value for the
 * second argument that would verify.
 *
 * max([1,2,3,5,4], 5). returns Yes
 * max([1,2,3,2,1], X). returns X=3
 *
 */

% base case
% The max of a one-item list is that item.
max([Item], Item).


% recursieve case 1
% The max of a list is the head of the list if the head is larger than
%   the max of the tail.
max([Head|Tail], Head) :- max(Tail, MaxTail), Head >= MaxTail.

% recursive case 2
% The max of a list is the max of the tail if the max of the tail is
%   larger than the head.
max([Head|Tail], MaxTail) :- max(Tail, MaxTail), Head < MaxTail.

