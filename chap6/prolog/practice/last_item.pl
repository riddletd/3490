% P01 (*): Find the last element of a list

% last_item(L,X) :- X is the last element of the list L
%    (list, item) (?,?)

% Note: last(?Elem, ?List) is predefined

last_item([X], X).
last_item([_|Tail], X) :- last_item(Tail, X).

