
%%%MIN%%%
% Min base case
min([X],X).

% Recursive case 1
min([Head|Tail], Head) :- min(Tail, MinTail), Head < MinTail.

% Recursive case 2
min([Head|Tail], MinTail) :- min(Tail, MinTail), Head >= MinTail.


%%%DELETE FIRST%%%
% Base case 1
delFirst([X], X).

% Base case 2


% Recursive case 1
% Go through list and instantiate a variable with
% the first element that needs to be deleted



